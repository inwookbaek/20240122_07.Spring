package com.lec.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.lec.domain.Board;


public interface BoardRepository extends CrudRepository<Board, Long>{

	@Modifying
	@Transactional
	@Query(value="update Board b set b.cnt= b.cnt + 1 where b.seq = :seq", nativeQuery = false)
	int updateReadCount(@Param("seq") Long seq);
	
	@Modifying
	@Transactional
	@Query("update Board b set b.board_ref = b.seq, b.board_lev=:lev, b.board_seq=:_seq where b.seq=:seq")
	void updateLastSeq(@Param("lev") Long i, @Param("_seq") Long j, @Param("seq") Long seq);
	
	// select * from board where title like '%xxx%';
	Page<Board> findByTitleContaining(String title, Pageable pageable);
	Page<Board> findByWriterContaining(String writer, Pageable pageable);
	Page<Board> findByContentContaining(String content, Pageable pageable);
	
}
