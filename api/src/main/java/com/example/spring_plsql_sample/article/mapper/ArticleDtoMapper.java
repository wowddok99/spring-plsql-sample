package com.example.spring_plsql_sample.article.mapper;

import com.example.spring_plsql_sample.article.dto.ArticleCommandDto.ArticleUpdateCommand;
import com.example.spring_plsql_sample.article.dto.ArticleCommandDto.ArticleCommandResponse;
import com.example.spring_plsql_sample.article.dto.ArticleCommandDto.ArticleCreateCommand;
import com.example.spring_plsql_sample.article.vo.ArticleVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ArticleDtoMapper {

    ArticleVO toVo(ArticleCreateCommand dto);

    ArticleCommandResponse toCommandResponse(ArticleVO vo);

    void updateVoFromDto(ArticleUpdateCommand dto, @MappingTarget ArticleVO vo);
}
