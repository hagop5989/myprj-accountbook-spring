package com.springmytestprj0527.service.board.modal;

import com.springmytestprj0527.domain.board.modal.Modal;
import com.springmytestprj0527.mapper.board.modal.ModalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class ModalService {
    private final ModalMapper modalMapper;

    public List<Modal> modalList() {
        return modalMapper.findAllModalList();
    }

    public void insert(Modal modal) {
        modalMapper.insert(modal);

    }

    public void delete(Modal modal) {
        Modal dbModal = modalMapper.selectByModalId(modal.getId());
        if (dbModal != null) {
            int delete = modalMapper.delete(dbModal);
            System.out.println("delete개수 = " + delete);
        }
    }

    public void update(Modal modal) {
        modalMapper.update(modal);

    }
}
