package cn.saatana.core.org.entity;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import cn.saatana.core.common.CommonEntity;
import cn.saatana.core.utils.DictUtils;
import cn.saatana.core.utils.tree.TreeNode;
import cn.saatana.core.utils.tree.Treeable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 组织机构
 *
 * @author 向文可
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Org extends CommonEntity implements Treeable<Org> {
	private static final long serialVersionUID = 1L;
	private String title;
	private String code;
	private Integer type;
	private Integer level;
	private Org parent;
	private List<Org> children = new ArrayList<>();
	private Integer scope;

	@Override
	public TreeNode<Org> convertToTreeNode() {
		return new TreeNode<>(getId() + "", getTitle(), getParentId(), this, 0, true, false);
	}

	@Override
	public void formatChildren(List<Org> children) {
		this.setChildren(children);
	}

	@Override
	public String uniqueCode() {
		return getId() + "";
	}

	@JsonGetter
	public String getParentId() {
		String res = null;
		if (parent != null) {
			res = parent.getId() + "";
		}
		return res;
	}

	@JsonGetter
	public String getTypeLabel() {
		return DictUtils.query("orgType", type);
	}

	@JsonGetter
	public String getLevelLabel() {
		return DictUtils.query("orgLevel", level);
	}

	@JSONField(serialize = false)
	@JsonIgnore
	public Org getParent() {
		return parent;
	}

	@JsonProperty
	public void setParent(Org parent) {
		this.parent = parent;
	}
}
