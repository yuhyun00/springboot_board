package com.study.springboot_board.controller;

import java.util.List;

import com.study.springboot_board.dto.BoardUpdateRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.study.springboot_board.dto.BoardSaveRequestDto;
import com.study.springboot_board.dto.BoardResponseDto;
import com.study.springboot_board.service.BoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardController {

    private final BoardService boardService;

    //게시글 목록조회
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BoardResponseDto>> findAll() {

        List<BoardResponseDto> boardResponseDtoList = boardService.findAll();

        return new ResponseEntity<List<BoardResponseDto>>(boardResponseDtoList, HttpStatus.OK);
    }

    //게시글 상세조회
    @GetMapping(value = "/{boardId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BoardResponseDto> findById(@PathVariable("boardId") Long boardId) {

        BoardResponseDto boardResponseDto = boardService.findById(boardId);

        return new ResponseEntity<BoardResponseDto>(boardResponseDto, HttpStatus.OK);
    }

    //게시글 등록
    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Long> save(@RequestBody BoardSaveRequestDto boardSaveRequestDto) {

        Long savedBoardId = boardService.save(boardSaveRequestDto);

        return new ResponseEntity<Long>(savedBoardId, HttpStatus.CREATED);
    }

    //게시글 수정
    @PutMapping(value = "/{boardId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Long> update(@PathVariable("boardId") Long boardId, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {

        Long updatedboardSeq = boardService.update(boardId, boardUpdateRequestDto);

        return new ResponseEntity<Long>(updatedboardSeq, HttpStatus.CREATED);
    }

    //게시글 삭제
    @DeleteMapping(value = "/{boardId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Long> delete(@PathVariable("boardId") Long boardId) {

        boardService.delete(boardId);

        return new ResponseEntity<Long>(boardId, HttpStatus.NO_CONTENT);
    }
}

