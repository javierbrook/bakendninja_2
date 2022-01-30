package com.udemy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "log")
public class Log {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;	
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "details")
	private String details;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "url")
	private String url;

	public Log(Date date, String details, String username, String url) {
		super();
		this.date = date;
		this.details = details;
		this.username = username;
		this.url = url;
	}
	
}
