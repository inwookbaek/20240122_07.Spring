package com.lec.domain;

import java.util.Date;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(BoardListeners.class)
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	private String title;
	@Column(updatable = false)
	private String writer;
	private String content;
	
	@Column(insertable = false, updatable = false, columnDefinition = "date default now()")
	private Date createDate;// create_date
	@Column(insertable = false, updatable = false, columnDefinition = "bigint default 0")
	private Long cnt;
	private String fileName;
	@Transient
	private MultipartFile uploadFile;
	
	// @Transient
	// @Column(columnDefinition = "integer default 0", nullable = true)
	private Long board_ref;
	private Long board_lev;
	private Long board_seq;
}