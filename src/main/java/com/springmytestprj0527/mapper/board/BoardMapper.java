package com.springmytestprj0527.mapper.board;

import com.springmytestprj0527.domain.board.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

    @Insert("""
            INSERT INTO board
            (date, income, expense, categories, how)
            VALUES
                (
                 date=#{board.date},
                 income=#{board.income},
                 expense=#{board.expense},
                 categories=#{categoriesToString},
                 how=#{board.how}
                 )
            """)
    int addRow(Board board, String categoriesToString);
}
