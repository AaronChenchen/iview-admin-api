package cn.saatana.core.auth.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import cn.saatana.core.common.BaseEntity;
import cn.saatana.core.role.entity.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "authorizer")
public class Authorizer extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	@Column(name = "login_date")
	private Date loginDate;
	@Where(clause = WHERE_CLAUSE)
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable(name = "r_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<>();

	public Authorizer() {
	}

	public Authorizer(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@JSONField(serialize = false)
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JSONField(serialize = true)
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

}
