package com.lec.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.ToString;

//@Entity
@ToString(exclude = "board")
public class BoardImage {

	@Id
	private String uuid;
	private String imageFileName;

	@ManyToOne
	private Board board;
}
