package com.springmytestprj0527.controller.board.modal;

import com.springmytestprj0527.domain.board.modal.Modal;
import com.springmytestprj0527.service.board.modal.ModalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/board/modal")
public class ModalController {
    private final ModalService service;

    @GetMapping("list")
    public List<Modal> modalList() {
        List<Modal> modalList = service.modalList();
        return modalList;
    }

    @PostMapping("insert")
    public void insert(@RequestBody Modal modal) {
        service.insert(modal);
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
