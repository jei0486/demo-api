package com.demo.api.controller;

import com.demo.api.domain.Board;
import com.demo.api.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/boards")
@RestController
public class BoardRestController {

    private final BoardService boardService;

    @GetMapping("")
    private List<Board> boardList() {
        return boardService.boardList();
    }

    @GetMapping("/{boardId}")
    private Board show(@PathVariable Long boardId) {
        return boardService.show(boardId);
    }

    @PostMapping("")
    private Board save(@RequestBody Board board){
        return boardService.save(board);
    }

    @DeleteMapping("/{boardId}")
    private void delete(@PathVariable Long boardId){
        boardService.delete(boardId);
    }

    @PutMapping("/{boardId}")
    private Board update(@PathVariable Long boardId,@RequestBody Board board) {
        return boardService.update(boardId,board);
    }

}
