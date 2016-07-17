package com.abroad.ysg.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="FILEBOARD")
public class FileBoard {

	@Id
	@GeneratedValue
	@Column(name = "FILE_ID")
	private Long id;
	
	@Column(name = "BOARD_ID")
	private Long board_id;
	
	@Column(name = "ORIGIN_FILE")
	private String origin_file;
	
	@Column(name = "STORED_FILE")
	private String stored_file;
	
	@Column(name = "FILE_SIZE")
	private Long file_size;
	
	@Column(name = "FILE_CREATE_DATE")
	private Date file_create_date;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBoard_id() {
		return board_id;
	}

	public void setBoard_id(Long board_id) {
		this.board_id = board_id;
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

	public Date getFile_create_date() {
		return file_create_date;
	}

	public void setFile_create_date(Date file_create_date) {
		this.file_create_date = file_create_date;
	}
	
	
}
