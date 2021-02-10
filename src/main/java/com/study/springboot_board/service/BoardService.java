package com.study.springboot_board.service;

import com.study.springboot_board.domain.Board;
import com.study.springboot_board.dto.BoardResponseDto;
import com.study.springboot_board.dto.BoardSaveRequestDto;
import com.study.springboot_board.dto.BoardUpdateRequestDto;
import com.study.springboot_board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    /** 게시글 - 목록 조회 */
    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAll() {

        return boardRepository.findAll()
                .stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
    }

    /** 게시글 - 상세 조회 */
    @Transactional(readOnly = true)
    public BoardResponseDto findById(Long id) {

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[boardId=" + id + "] 해당 게시글이 존재하지 않습니다."));

        return new BoardResponseDto(board);
    }

    /** 게시글 - 등록 */
    @Transactional
    public Long save(BoardSaveRequestDto boardSaveRequestDto) {

        return boardRepository.save(boardSaveRequestDto.toEntity())
                .getId();
    }

    /** 게시글 - 수정 */
    @Transactional
    public Long update(Long id, BoardUpdateRequestDto boardUpdateRequestDto) {

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[boardId=" + id + "] 해당 게시글이 존재하지 않습니다."));

        board.update(boardUpdateRequestDto.getBoardTitle(), boardUpdateRequestDto.getBoardContent());

        return id;
    }
}