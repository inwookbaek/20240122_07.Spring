package com.lec.service;

import com.lec.dto.BoardDTO;
import com.lec.dto.PageRequestDTO;
import com.lec.dto.PageResponseDTO;

public interface BoardService {
	
	Long register(BoardDTO boardDTO);
	BoardDTO readOne(Long bno);
    void modify(BoardDTO boardDTO);
    void remove(Long bno);
    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);	
}
