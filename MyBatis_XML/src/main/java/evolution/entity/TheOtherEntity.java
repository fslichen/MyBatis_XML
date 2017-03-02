package evolution.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TheOtherEntity {
	private int id;
	private String name;
	private int age;
	private String address;
	
	public TheOtherEntity(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
}
