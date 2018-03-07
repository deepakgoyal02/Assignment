package com.blk.boot.data;

import static java.time.LocalDateTime.now;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "guest_book_entry")
public class GuestBookEntry {

	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "guest_name",nullable=false)
	private String name;
	@Column
	private String comment;
	@Column(name = "client_id",nullable=false)
	private String clientId;
	@Column(name = "last_updated",nullable=false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@JsonFormat(pattern = "YYYY-MM-dd HH:mm")
	private LocalDateTime lastUpdated=now();

	public GuestBookEntry(String name, String clientId) {
		this.name = name;
		this.clientId = clientId;
	}

	public GuestBookEntry() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String email) {
		this.clientId = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
		return result;
	}
}