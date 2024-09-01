package com.neptune.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	private String id;
	private String name;

	// Getter and Setter methods
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Constructor with parameters
	public User(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// Default constructor
	public User() {
		super();
	}
}
