package cn.saatana.core.dict.entity;

import cn.saatana.core.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Dictionary extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String type;
	private String code;
	private String label;
	private Integer value;
	private Integer sort;

	public Dictionary(String code, String label) {
		this.code = code;
		this.label = label;
	}

	public Dictionary(String code, Integer value) {
		this.code = code;
		this.value = value;
	}
}
