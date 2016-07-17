package com.abroad.ysg.domain;

import javax.persistence.*;
import java.util.Date;

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
	
	@Column(name = "BOARD_CREATE_DATE")
	private Date board_create_date;	//���� ��¥

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

	public Date getCreate_date() {
		return board_create_date;
	}

	public void setCreate_date(Date board_create_date) {
		this.board_create_date = board_create_date;
	}
	

}