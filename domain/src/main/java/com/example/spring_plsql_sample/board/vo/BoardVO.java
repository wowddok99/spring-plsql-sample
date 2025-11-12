package com.example.spring_plsql_sample.board.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
    private long id;
    private String title;
    private String content;
    private String author;
}