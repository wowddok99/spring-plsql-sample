package com.example.spring_plsql_sample.board.mapper;

import com.example.spring_plsql_sample.board.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void createPost(BoardVO boardVO);
    List<BoardVO> getAllPosts();
    BoardVO getPostById(long id);
    void updatePost(BoardVO boardVO);
    void deletePost(long id);
}
