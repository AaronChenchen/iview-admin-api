package cn.saatana.core.auth.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import cn.saatana.core.common.BaseEntity;
import cn.saatana.core.role.entity.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Authorizer extends BaseEntity {
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
	public Set<Integer> getAccessScopes() {
		Set<Integer> scopes = new HashSet<>();
		getRoles().forEach(role -> {
			scopes.addAll(role.getAccessScopes());
		});
		return scopes;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

}
