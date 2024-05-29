package com.springmytestprj0527.domain.board;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Board {
    private Integer id;

    private LocalDate date;
    private Integer income;
    private Integer expense;


    private String how;
    private String[] categories;
    private String stringCategories;

}
