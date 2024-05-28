package com.springmytestprj0527.mapper.board;

import com.springmytestprj0527.domain.board.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Insert("""
            INSERT INTO board
            (date, income, expense, categories, how)
            VALUES(#{board.date},
                 #{board.income},
                 #{board.expense},
                 #{categoriesToString},
                 #{board.how}
                 )
            """)
    int addRow(Board board, String categoriesToString);

    @Select("""
            SELECT *
            FROM board
            """)
    List<Board> findAllBoardList();
}
