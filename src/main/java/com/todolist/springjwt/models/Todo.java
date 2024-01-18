/**
 * @author Shreepad Kulkarni
 *
 * ${tags}
 */


// Created the Todo entity to Create Todo in Database. 

package com.todolist.springjwt.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "todos")
@Builder
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int userid;

	private String title;
	private String description;
	private String date;
	private String tag;
	private boolean important;
	private boolean completed;

	public Todo() {
	}


	public String getTitle() {
		return title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean isImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Todo(int id, int userid, String title, String description, String date, String tag, boolean important,
			boolean completed) {
		super();
		this.id = id;
		this.userid = userid;
		this.title = title;
		this.description = description;
		this.date = date;
		this.tag = tag;
		this.important = important;
		this.completed = completed;
	}
}
