package cn.saatana.modules.person.entity;

import cn.saatana.core.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Person extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String id;
	private String firstname;
	private String lastname;
	private String sex;
	private int age;

	public Person() {
	}

}
