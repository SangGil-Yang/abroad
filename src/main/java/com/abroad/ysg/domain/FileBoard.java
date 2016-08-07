package com.abroad.ysg.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FILEBOARD")
public class FileBoard {

	@Id
	@GeneratedValue
	@Column(name = "FILE_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "BOARD_ID")
	private Board board;
	
	@Column(name = "ORIGIN_FILE")
	private String origin_file;
	
	@Column(name = "STORED_FILE")
	private String stored_file;
	
	@Column(name = "FILE_SIZE")
	private Long file_size;
	
	@Column(name = "FILE_CREATE_DATE", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp file_create_date;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public String getOrigin_file() {
		return origin_file;
	}

	public void setOrigin_file(String origin_file) {
		this.origin_file = origin_file;
	}

	public String getStored_file() {
		return stored_file;
	}

	public void setStored_file(String stored_file) {
		this.stored_file = stored_file;
	}

	public Long getFile_size() {
		return file_size;
	}

	public void setFile_size(Long file_size) {
		this.file_size = file_size;
	}

	public Timestamp getFile_create_date() {
		return file_create_date;
	}

	public void setFile_create_date(Timestamp file_create_date) {
		this.file_create_date = file_create_date;
	}
	
	
}
