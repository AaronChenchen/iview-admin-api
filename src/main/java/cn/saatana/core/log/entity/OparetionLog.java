package cn.saatana.core.log.entity;

import cn.saatana.core.common.CommonEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 操作日志
 *
 * @author 向文可
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OparetionLog extends CommonEntity {
	private static final long serialVersionUID = 1L;
	private String controller;
	private String controllerName;
	private String method;
	private String methodName;
	private String ip;
}
