package cn.saatana.modules.user.entity;

import java.text.NumberFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;

import org.hibernate.annotations.Where;

import cn.saatana.core.auth.entity.Authorizer;
import cn.saatana.core.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user")
public class User extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Where(clause = WHERE_CLAUSE)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Authorizer authorizer;

	private String name;
	@JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
	private Date birthday;

	private String address;

	private String mobilePhone;

	private String telPhone;

	private String email;

	private Integer sex;

	private String description;

	@JsonGetter
	public String getAge() {
		String res = "不详";
		if (birthday != null) {
			res = NumberFormat.getIntegerInstance()
					.format((System.currentTimeMillis() - birthday.getTime()) / 31557600000l) + "周岁";
		}
		return res;
	}
}
