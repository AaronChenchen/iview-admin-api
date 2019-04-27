package cn.saatana.core.auth.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import cn.saatana.core.common.CommonEntity;
import cn.saatana.core.role.entity.Role;

public class Authorizer extends CommonEntity {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Date loginDate;
	private Set<Role> roles = new HashSet<>();

	public Authorizer() {
	}

	public Authorizer(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@JsonIgnore
	@JSONField(serialize = false)
	public Set<Integer> getAccessScopes() {
		Set<Integer> scopes = new HashSet<>();
		getRoles().forEach(role -> {
			scopes.addAll(role.getAccessScopes());
		});
		return scopes;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

}
