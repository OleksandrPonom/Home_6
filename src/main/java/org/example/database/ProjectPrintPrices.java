package org.example.database;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectPrintPrices {
	private String name;
	private long project;
	private long price;

	public ProjectPrintPrices(String name, long project, long price) {
		this.name = name;
		this.project = project;
		this.price = price;
	}

	@Override
	public String toString() {
		return "\r\nProjectCountPrices ==> {" +
				"name='" + name + '\'' +
				", project=" + project +
				", price=" + price +
				'}';
	}
}
