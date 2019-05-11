package cn.saatana.core.org.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.Where;

import cn.saatana.core.common.BaseEntity;
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
@Entity
@Table(name = "org")
public class Org extends BaseEntity implements Treeable<Org> {
	private static final long serialVersionUID = 1L;
	private String title;

	private String code;

	private Integer type;

	private Integer level;
	@Where(clause = WHERE_CLAUSE)
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Org parent;

	@Transient
	private List<Org> children = new ArrayList<>();

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
