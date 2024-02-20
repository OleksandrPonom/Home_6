package org.example.database;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OldestYoungestWorkers {
	private String type;
	private String name;
	private String birthday;

	public OldestYoungestWorkers(String type, String name, String birthday) {
		this.type = type;
		this.name = name;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "\r\nOldestYoungestWorkers{" +
				"type='" + type + '\'' +
				", name='" + name + '\'' +
				", birthday='" + birthday + '\'' +
				'}';
	}
}
