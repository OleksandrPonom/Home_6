package org.example.database;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LongestProject {
	private String name;
	private int month;

	public LongestProject(String name, int month) {
		this.name = name;
		this.month = month;
	}

	@Override
	public String toString() {
		return "\r\nLongestProject{" +
				"name='" + name + '\'' +
				", month=" + month +
				'}';
	}
}
