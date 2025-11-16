package com.example.spring_plsql_sample.article.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.Instant;

public final class ArticleCommandDto {

    private ArticleCommandDto() {}

    @Builder
    public record ArticleCreateCommand(
            @NotBlank(message = "제목을 입력하십시오.")
            @Size(max = 200)
            String title,

            String content,

            String author
    ) {}

    @Builder
    public record ArticleUpdateCommand(
            @NotBlank(message = "제목을 입력하십시오.")
            @Size(max = 200)
            String title,

            String content
    ) {}

    @Builder
    public record ArticleCommandResponse(
            Long id,
            String title,
            String content,
            String author,
            Instant createdAt,
            Instant updatedAt
    ) {}
}