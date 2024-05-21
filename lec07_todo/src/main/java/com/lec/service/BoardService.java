package com.lec.service;

import com.lec.domain.Board;

public interface BoardService {

    Long register(Board board);
    Board readOne(Long bno);
    void modify(Board board);
    void remove(Long bno);


}
