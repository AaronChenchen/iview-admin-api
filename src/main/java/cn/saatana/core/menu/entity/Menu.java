package cn.saatana.core.menu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.Where;

import cn.saatana.core.common.BaseEntity;
import cn.saatana.core.utils.tree.TreeNode;
import cn.saatana.core.utils.tree.Treeable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "menu")
public class Menu extends BaseEntity implements Treeable<Menu> {
	private static final long serialVersionUID = 1L;

	private String code;

	private String title;

	@Where(clause = WHERE_CLAUSE)
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Menu parent;

	private String icon;

	private String router;

	private Integer sort;

	private Boolean display;

	private String permission;

	@Transient
	private List<Menu> children = new ArrayList<>();

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

	@Override
	public TreeNode<Menu> convertToTreeNode() {
		return new TreeNode<>(getId() + "", getTitle(), getParentId(), this, getSort(), true, false);
	}

	@Override
	public String uniqueCode() {
		return this.getId() + "";
	}

	@Override
	public void formatChildren(List<Menu> children) {
		this.setChildren(children);
	}

	@JsonGetter
	public String getParentId() {
		String res = null;
		if (parent != null) {
			res = parent.getId() + "";
		}
		return res;
	}

	@JSONField(serialize = false)
	@JsonIgnore
	public Menu getParent() {
		return parent;
	}

	@JsonProperty
	public void setParent(Menu parent) {
		this.parent = parent;
	}
}
