package cn.saatana.core.common;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Page<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<T> list;
	private int total;
}
