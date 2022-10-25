package com.demo.api.service;

import com.demo.api.domain.Board;
import com.demo.api.domain.BoardEntity;
import com.demo.api.domain.BoardRepository;
import com.demo.api.util.ModelMapperUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;


    public List<Board> boardList() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<Board> collect = boardEntityList.stream().map(boardEntity -> ModelMapperUtil.map(boardEntity,Board.class)).collect(Collectors.toList());
        return collect;
    }

    public Board show(Long boardId) {
        BoardEntity old = boardRepository.getById(boardId);
        old.setHits(old.getHits()+1);
        BoardEntity boardEntity = boardRepository.save(old);
        return ModelMapperUtil.map(boardEntity,Board.class);
    }

    public Board save(Board board){
        BoardEntity boardEntity = boardRepository.save(BoardEntity.builder()
                .createdId(board.getCreatedId())
                .subject(board.getSubject())
                .content(board.getContent())
                .build());
        return ModelMapperUtil.map(boardEntity,Board.class);
    }

    public void delete(Long boardId){
        boardRepository.deleteById(boardId);
    }

    public Board update(Long boardId,Board board) {
        BoardEntity old = boardRepository.getById(boardId);
        old.setSubject(board.getSubject());
        old.setContent(board.getContent());
        old.setModifiedId(board.getModifiedId());
        BoardEntity boardEntity = boardRepository.save(old);
        return ModelMapperUtil.map(boardEntity,Board.class);
    }

}
