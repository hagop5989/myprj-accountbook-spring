package com.springmytestprj0527.service.board.modal;

import com.springmytestprj0527.domain.board.modal.Modal;
import com.springmytestprj0527.domain.board.modal.ModalFile;
import com.springmytestprj0527.mapper.board.modal.ModalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class ModalService {
    private final ModalMapper modalMapper;

    public List<Modal> modalList(String boardId) {
        List<Modal> modalList = modalMapper.findAllModalList(boardId);
        for (Modal modal : modalList) {
            List<String> fileNames = modalMapper.selectFileNameByModalId(modal.getId());
            List<ModalFile> files = fileNames.stream()
                    .map(name -> new ModalFile(name, STR."http://172.31.208.1:8888/\{modal.getId()}/\{name}"))
                    .toList();
            modal.setFileList(files);
        }
        return modalList;
    }

    public void insert(Modal modal, MultipartFile[] files) throws IOException {
        modalMapper.insert(modal);
        // db 해당 게시물의 파일 목록 저장
        if (files != null) {
            for (MultipartFile file : files) {
                modalMapper.insertFileName(modal.getId(), file.getOriginalFilename());
                // 실제 파일 저장
                // 부모 디렉토리 만들기
                String dir = STR."C:/Temp/prj3/\{modal.getId()}";
                File dirFile = new File(dir);
                if (!dirFile.exists()) {
                    dirFile.mkdirs();
                }
                // 파일 경로
                String path = STR."C:/Temp/prj3/\{modal.getId()}/\{file.getOriginalFilename()}";
                File destination = new File(path);
                file.transferTo(destination);
            }
            List<String> foundFile
                    = modalMapper.selectFileNameByModalId(modal.getId());
            System.out.println("저장한 파일  = " + foundFile.toString());
            // 실제 파일 저장
        }
    }

    public void delete(Modal modal) {
        Modal dbModal = modalMapper.selectByModalId(modal.getId());
        if (dbModal != null) {
            List<String> fileNames = modalMapper.selectFileNameByModalId(modal.getId());

            String dir = STR."C:/Temp/prj3/\{modal.getId()}/";
            for (String fileName : fileNames) {
                new File(dir + fileName).delete();
            }

            File dirFile = new File(dir);
            if (dirFile.exists()) {
                dirFile.delete();
            }
            modalMapper.deleteFileNameById(modal.getId());

            int delete = modalMapper.delete(dbModal);
            System.out.println("delete개수 = " + delete);
        }
    }

    public void update(Modal modal) {
        modalMapper.update(modal);

    }
}
