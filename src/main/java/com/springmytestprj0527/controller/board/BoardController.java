package com.springmytestprj0527.controller.board;

import com.springmytestprj0527.domain.board.Board;
import com.springmytestprj0527.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {
    private final BoardService service;

    @PostMapping("addRow")
    public void addRow(@RequestBody Board board) {
        System.out.println("board = " + board);
        service.addRow(board);
    }

}
