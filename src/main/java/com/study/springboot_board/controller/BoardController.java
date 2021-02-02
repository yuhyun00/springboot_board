package com.study.springboot_board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot_board.dto.BoardSaveRequestDto;
import com.study.springboot_board.dto.BoardResponseDto;
import com.study.springboot_board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardController {

    private final BoardService boardService;

    /**
     * 게시글 - 목록 조회
     */
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BoardResponseDto>> findAll() {

        List<BoardResponseDto> boardResponseDtoList = boardService.findAll();

        return new ResponseEntity<List<BoardResponseDto>>(boardResponseDtoList, HttpStatus.OK);
    }

    /**
     * 게시글 - 상세 조회
     */
    @GetMapping(value = "/{boardId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BoardResponseDto> findById(@PathVariable("boardId") Long boardId) {

        BoardResponseDto boardResponseDto = boardService.findById(boardId);

        return new ResponseEntity<BoardResponseDto>(boardResponseDto, HttpStatus.OK);
    }

    /**
     * 게시글 - 등록
     */
    @PostMapping(value = "/create", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Long> save(@RequestBody BoardSaveRequestDto boardSaveRequestDto) {

        Long savedBoardId = boardService.save(boardSaveRequestDto);

        return new ResponseEntity<Long>(savedBoardId, HttpStatus.CREATED);
    }
}

