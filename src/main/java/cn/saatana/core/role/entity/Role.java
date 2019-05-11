package cn.saatana.core.role.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;

import org.hibernate.annotations.Where;

import cn.saatana.core.common.BaseEntity;
import cn.saatana.core.menu.entity.Menu;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "role")
public class Role extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Column(name = "name")
	private String name;
	@Column(name = "code")
	private String code;
	@Column(name = "description")
	private String description;
	@Where(clause = WHERE_CLAUSE)
	@OrderBy("sort,title")
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable(name = "r_role_menu")
	private Set<Menu> menus = new HashSet<>();

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
}
