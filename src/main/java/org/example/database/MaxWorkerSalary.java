package org.example.database;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaxWorkerSalary {
	private String name;
	private long salary;

	public MaxWorkerSalary(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "\r\nMaxWorkerSalary{" +
				"name='" + name + '\'' +
				", salary=" + salary +
				'}';
	}
}
