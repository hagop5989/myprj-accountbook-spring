package com.springmytestprj0527.service.board;

import com.springmytestprj0527.domain.board.Board;
import com.springmytestprj0527.mapper.board.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;

    public void addRow(Board board) {
        String[] categories = board.getCategories();
        String categoriesToString = String.join(",", categories);

        int addedRow = mapper.addRow(board, categoriesToString);
        System.out.println("BoardService.addRow");
        System.out.println("board = " + board);
        System.out.println("categoriesToString = " + categoriesToString);
        System.out.println("addedRow = " + addedRow);
    }

    public List<Board> boardList() {
        List<Board> allBoardList = mapper.findAllBoardList();
        System.out.println("allBoardList = " + allBoardList);
        return allBoardList;
    }

    public void deleteRow(Integer rowId) {
        int i = mapper.deleteRowById(rowId);
        System.out.println("삭제 성공 = " + i);
    }
}
