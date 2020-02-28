package com.supero.biblioteca.custom;

import org.springframework.data.domain.Sort.Direction;

/**
 * @author bruno.freiberger
 *
 */
public class Sort {

	private String[] properties;
	private Direction direction;

	public Sort(String[] properties, Direction direction) {
		this.properties = properties;
		this.direction = direction;
	}

	public Sort() {
		// TODO Auto-generated constructor stub
	}

	public String[] getProperties() {
		return properties;
	}

	public void setProperties(String[] properties) {
		this.properties = properties;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
