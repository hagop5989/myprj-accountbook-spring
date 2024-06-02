package com.springmytestprj0527.domain.board.modal;

import lombok.Data;

@Data
public class Modal {
    private Integer id;
    private String nickName;
    private Integer boardId;
    private String text;

    private boolean likeState;
    private Integer likeNum;
}
