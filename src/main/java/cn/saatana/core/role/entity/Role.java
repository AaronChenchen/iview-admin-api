package cn.saatana.core.role.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonGetter;

import cn.saatana.core.common.BaseEntity;
import cn.saatana.core.menu.entity.Menu;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String name;
	private String code;
	private Set<Menu> menus = new HashSet<>();
	private Set<Integer> accessScopes = new HashSet<>();

	@JsonGetter
	public String getMenusName() {
		StringBuilder sb = new StringBuilder();
		this.menus.forEach(item -> {
			sb.append(item.getTitle());
			sb.append(",");
		});
		if (this.menus.size() != 0) {
			sb.setLength(sb.length() - 1);
		}
		return sb.toString();
	}

	public Role(ResultSet set, int rownum) {
		super(set, rownum);
		try {
			this.setName(set.getString("name"));
			this.setCode(set.getString("code"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
