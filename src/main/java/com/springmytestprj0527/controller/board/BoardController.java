package com.springmytestprj0527.controller.board;

import com.springmytestprj0527.domain.board.Board;
import com.springmytestprj0527.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService service;

    @PostMapping("addRow")
    public void addRow(@RequestBody Board board) {
        System.out.println("BoardController-board = " + board);
        service.addRow(board);
    }

    @GetMapping("list")
    public Map<String,Object> boardList() {
        System.out.println("list working");
        List<Board> boards = service.boardList();
        System.out.println("boards = " + boards);
        return Map.of("boardList",boards);
    }
}
