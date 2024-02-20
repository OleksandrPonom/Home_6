package org.example.database;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaxProjectCountClient {
	private String name;
	@JsonProperty(value = "project_count")
	private int projectCount;

	public MaxProjectCountClient(String name, int projectCount) {
		this.name = name;
		this.projectCount = projectCount;
	}

	@Override
	public String toString() {
		return "\r\nMaxProjectCountClient  == > {" +
				"name='" + name + '\'' +
				", projectCount=" + projectCount +
				'}';
	}
}
