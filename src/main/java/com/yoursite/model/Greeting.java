package com.yoursite.model;

/**
 * Simpe Greeting pojo class for REST api demostration 
 * @author Hemrajsinh Gharia
 *
 */
public class Greeting {
	
	private final long id;
	private final String content;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
}
