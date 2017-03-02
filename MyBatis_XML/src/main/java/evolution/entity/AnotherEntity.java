package evolution.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnotherEntity {
	private int id;
	private String name;
	
	public AnotherEntity(String name) {
		this.name = name;
	}
}
