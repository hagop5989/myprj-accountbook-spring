package com.springmytestprj0527.service.board;

import com.springmytestprj0527.domain.board.Board;
import com.springmytestprj0527.mapper.board.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;

    public void addRow(Board board) {
        String categoriesToString = board.getCategories().toString();
        int addedRow = mapper.addRow(board, categoriesToString);
        System.out.println("board = " + board);
        System.out.println("categoriesToString = " + categoriesToString);
        System.out.println("addedRow = " + addedRow);
    }
}
