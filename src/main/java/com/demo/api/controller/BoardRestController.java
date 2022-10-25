package com.demo.api.controller;

import com.demo.api.domain.Board;
import com.demo.api.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardRestController {

    private final BoardService boardService;

    @GetMapping("/board")
    private List<Board> boardList() {
        return boardService.boardList();
    }

    @GetMapping("/board/{boardId}")
    private Board show(@PathVariable Long boardId) {
        return boardService.show(boardId);
    }

    @PostMapping("/board")
    private Board save(@RequestBody Board board){
        return boardService.save(board);
    }

    @DeleteMapping("/board/{boardId}")
    private void delete(@PathVariable Long boardId){
        boardService.delete(boardId);
    }

    @PutMapping("/board/{boardId}")
    private Board update(@PathVariable Long boardId,@RequestBody Board board) {
        return boardService.update(boardId,board);
    }

}
