package com.lec.repository;


import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import com.lec.domain.Board;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

	@Autowired
	BoardRepository boardRepository;
	
	@Test
	@DisplayName("게시판 샘플 데이타 생성")
	public void testInsert() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Board board = Board.builder()
					.title("title..." + i)
					.content("content..." + i)
					.writer("writer..." + (i%10))
					.build();
			Board result = boardRepository.save(board);
			log.info("BNO: " + result.getBno());
		});
		
	}
	
	@Test
	@DisplayName("게시판 한 건 조회")
	public void testSelect() {
		
		Long bno = 500L;
		Optional<Board> result = boardRepository.findById(bno);
		Board board = result.orElseThrow();
		log.info(board);		
	}
	
	@Test
	@DisplayName("게시판 수정")
	public void testUpdate() {
		
		Long bno = 401L;
		Optional<Board> result = boardRepository.findById(bno);
		Board board = result.orElseThrow();
		board.chang("제목100", "글 상세내용 100");
		boardRepository.save(board);
		log.info(board);		
	}
	
	
	@Test
	@DisplayName("게시판 삭제")
	public void testDelete() {
		
		Long bno = 401L;
		Optional<Board> result = boardRepository.findById(bno);
		Board board = result.orElseThrow();
		boardRepository.deleteById(bno);
		log.info(board);		
	}
	
	@Test
	@DisplayName("페이징 처리")
	public void testPaging() {
		
		Pageable pageable = PageRequest.of(0,10,Sort.by("bno").descending());
		Page<Board> result = boardRepository.findAll(pageable);
		log.info("총건수: " + result.getTotalElements());
		log.info("총페이지: " + result.getTotalPages());
		log.info("현페이지: " + result.getNumber());
		log.info("페이지크기: " + result.getSize());
		
		List<Board> boardList = result.getContent();
		boardList.forEach(board -> log.info(board));
	}
	
}
