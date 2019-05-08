package cn.saatana.core.common;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String id;
	protected Date createDate;
	protected Date updateDate;
	protected String creatorId;
	protected String updatorId;
	protected DataStatus dataStatus = DataStatus.NORMAL;
	protected int page = 1;
	protected int limit = 10;

	public String preCreate() {
		this.setCreateDate(new Date());
		this.setId(BaseEntity.UUID());
		return this.getId();
	}

	public void preUpdate() {
		this.setUpdateDate(new Date());
	}

	public void preRemove() {
		preUpdate();
		this.setDataStatus(DataStatus.REMOVE);
	}

	public void preRestore() {
		preUpdate();
		this.setDataStatus(DataStatus.NORMAL);
	}

	public static final String UUID() {
		return java.util.UUID.randomUUID().toString().replaceAll("-", "");
	}

	public enum DataStatus {
		NORMAL(0), REMOVE(1);
		private int value;

		public int getValue() {
			return this.value;
		}

		@Override
		public String toString() {
			return this.value + "";
		}

		private DataStatus(int value) {
			this.value = value;
		}
	}
}