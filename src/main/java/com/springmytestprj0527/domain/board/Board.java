package com.springmytestprj0527.domain.board;

import lombok.Data;

import static java.lang.Integer.parseInt;

@Data
public class Board {
    private String date;
    private Integer income;
    private Integer expense;


    public Board(String income, String expense) {
        this.income = parseInt(income.replace(",", ""));
        this.expense = parseInt(expense.replace(",", ""));
    }

    private String how;
    private String[] categories;
}
