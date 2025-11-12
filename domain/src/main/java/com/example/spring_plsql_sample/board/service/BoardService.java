package com.example.spring_plsql_sample.board.service;

import com.example.spring_plsql_sample.board.mapper.BoardMapper;
import com.example.spring_plsql_sample.board.vo.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    @Transactional
    public BoardVO createPost(BoardVO boardVO) {
        boardMapper.createPost(boardVO);
        return boardVO;
    }

    public List<BoardVO> getAllPosts() {
        return boardMapper.getAllPosts();
    }

    public BoardVO getPostById(long id) {
        return boardMapper.getPostById(id);
    }

    @Transactional
    public BoardVO updatePost(BoardVO boardVO) {
        boardMapper.updatePost(boardVO);
        return boardVO;
    }

    @Transactional
    public void deletePost(long id) {
        boardMapper.deletePost(id);
    }

    public boolean exists(long id) {
        return boardMapper.getPostById(id) != null;
    }
}