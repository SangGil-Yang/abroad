package com.abroad.ysg.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="BOARD")
public class Board {

	@Id
	@GeneratedValue
	@Column(name = "BOARD_ID")
	private Long id;	// �⺻Ű ��
	
	@Column(name = "BOARD_TITLE")
	private String title;	// ����
	
	@Column(name = "BOARD_CONTENT")
	private String content;		// ����

	@Column(name = "COUNT")
	private int count;	// ��ȸ ��
	
	@Column(name = "BOARD_CREATE_DATE", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp board_create_date;	//���� ��¥

	// Getter, Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Timestamp getBoard_create_date() {
		return board_create_date;
	}

	public void setBoard_create_date(Timestamp board_create_date) {
		this.board_create_date = board_create_date;
	}
	

}