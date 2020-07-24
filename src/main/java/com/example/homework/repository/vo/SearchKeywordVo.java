package com.example.homework.repository.vo;

import lombok.Data;

import java.util.Date;

@Data
public class SearchKeywordVo {

    private long seq;
    private String keyword;
    private String writer;
    private Date regDate;

}
