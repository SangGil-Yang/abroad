package com.abroad.ysg.domain;

import javax.persistence.*;

@Entity
@Table(name="LOGIN")
public class Login {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private String id;
	
	@Column(name = "PASSWORD")
	private String pwd;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "HP")
	private String hp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}
	
}
