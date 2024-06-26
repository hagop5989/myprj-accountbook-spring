package com.springmytestprj0527.controller.board.modal;

import com.springmytestprj0527.domain.board.modal.Modal;
import com.springmytestprj0527.service.board.modal.ModalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/board/modal")
public class ModalController {
    private final ModalService service;

    @GetMapping("list")
    public List<Modal> modalList(@RequestParam String boardId) {
        List<Modal> modalList = service.modalList(boardId);
        return modalList;
    }

    @PostMapping("insert")
    public void insert(@ModelAttribute Modal modal,
                       @RequestParam(value = "files[]", required = false) MultipartFile[] files
    ) throws IOException {
        service.insert(modal, files);
    }

    @DeleteMapping("delete")
    public void delete(@RequestBody Modal modal) {
        service.delete(modal);
    }

    @PutMapping("update")
    public void update(@RequestBody Modal modal) {
        service.update(modal);
    }
}
