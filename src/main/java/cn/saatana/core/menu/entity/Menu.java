package cn.saatana.core.menu.entity;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import cn.saatana.core.common.CommonEntity;
import cn.saatana.core.utils.tree.TreeNode;
import cn.saatana.core.utils.tree.Treeable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Menu extends CommonEntity implements Treeable<Menu> {
	private static final long serialVersionUID = 1L;
	private String code;
	private String title;
	private Menu parent;
	private String icon;
	private String router;
	private Integer sort;
	private Boolean display;
	private String permission;
	private List<Menu> children = new ArrayList<>();

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
