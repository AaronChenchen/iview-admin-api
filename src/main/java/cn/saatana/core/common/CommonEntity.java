package cn.saatana.core.common;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.saatana.core.Safer;
import cn.saatana.core.auth.entity.AuthorizationInformation;
import cn.saatana.core.auth.entity.Authorizer;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 公共实体类
 *
 * @author 向文可
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class CommonEntity extends PageQueryable implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int STATUS_NORMAL = 0;
	public static final int STATUS_DELETED = 1;
	private String id;
	private String description;
	private Date createDate;
	private Date updateDate;
	@JSONField(serialize = false)
	@JsonIgnore
	private Authorizer creator;
	@JSONField(serialize = false)
	@JsonIgnore
	private Authorizer updator;
	@JSONField(serialize = false)
	@JsonIgnore
	private int dataStatus = 0;
	@JSONField(serialize = false)
	@JsonIgnore
	protected Integer scope;

	public void preCreate() {
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

	public void preRemove() {
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
