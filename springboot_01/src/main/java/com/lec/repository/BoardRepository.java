package com.lec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {


}
