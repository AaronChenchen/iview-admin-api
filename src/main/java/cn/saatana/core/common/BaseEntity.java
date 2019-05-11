package cn.saatana.core.common;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.saatana.core.Safer;
import cn.saatana.core.auth.entity.AuthorizationInformation;
import cn.saatana.core.auth.entity.Authorizer;
import lombok.Data;

/**
 * 公共实体类
 *
 * @author 向文可
 *
 */
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int STATUS_NORMAL = 0;
	public static final int STATUS_DELETED = 1;
	public static final String WHERE_CLAUSE = "data_status = " + STATUS_NORMAL;
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 64)
	private String id;
	private String description;
	private Date createDate;
	private Date updateDate;
	@JSONField(serialize = false)
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Authorizer creator;
	@JSONField(serialize = false)
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Authorizer updator;
	@JSONField(serialize = false)
	@JsonIgnore
	private int dataStatus = 0;
	@Transient
	protected Integer page;
	@Transient
	protected Integer limit;

	public void preCreate() {
		this.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		AuthorizationInformation authInfo = Safer.currentAuthInfo();
		if (authInfo != null) {
			this.setCreator(authInfo.getAuth());
		}
		this.setCreateDate(new Date());
	}

	public void preUpdate() {
		AuthorizationInformation authInfo = Safer.currentAuthInfo();
		if (authInfo != null) {
			this.setUpdator(authInfo.getAuth());
		}
		this.setUpdateDate(new Date());
	}

	public void preDelete() {
		preUpdate();
		this.dataStatus = STATUS_DELETED;
	}

	public void preRestore() {
		preUpdate();
		this.dataStatus = STATUS_NORMAL;
	}

	@JsonGetter
	public String getCreatorId() {
		String res = null;
		Authorizer auth = this.getCreator();
		if (auth != null) {
			res = auth.getId();
		}
		return res;
	}

	@JsonGetter
	public String getCreatorUsername() {
		String res = null;
		Authorizer auth = this.getCreator();
		if (auth != null) {
			res = auth.getUsername();
		}
		return res;
	}

	@JsonGetter
	public String getUpdatorId() {
		String res = null;
		Authorizer auth = this.getUpdator();
		if (auth != null) {
			res = auth.getId();
		}
		return res;
	}

	@JsonGetter
	public String getUpdatorUsername() {
		String res = null;
		Authorizer auth = this.getUpdator();
		if (auth != null) {
			res = auth.getUsername();
		}
		return res;
	}
}
