package cn.saatana.core.common;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;

@Data
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String id;
	protected Date createDate;
	protected Date updateDate;
	protected String creatorId;
	protected String updatorId;
	protected String description;
	protected DataStatus dataStatus = DataStatus.NORMAL;
	protected int page = 1;
	protected int limit = 10;

	public BaseEntity() {
	}

	public BaseEntity(ResultSet set, int rownum) {
		try {
			this.setId(set.getString("id"));
			this.setCreateDate(set.getTimestamp("create_date"));
			this.setUpdateDate(set.getTimestamp("update_date"));
			this.setCreatorId(set.getString("creator_id"));
			this.setUpdatorId(set.getString("updator_id"));
			this.setDescription(set.getString("description"));
			this.setDataStatus(DataStatus.of(set.getInt("data_status")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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

		@JsonValue
		public int getValue() {
			return this.value;
		}

		public static DataStatus of(int value) {
			List<DataStatus> list = Arrays.asList(DataStatus.values()).parallelStream()
					.filter(item -> item.getValue() == value).collect(Collectors.toList());
			DataStatus res = null;
			if (list.size() > 0) {
				res = list.get(0);
			}
			return res;
		}

		@Override
		public String toString() {
			return this.value + "";
		}

		DataStatus(int value) {
			this.value = value;
		}
	}
}
