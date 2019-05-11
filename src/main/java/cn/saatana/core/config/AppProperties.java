package cn.saatana.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
	/**
	 * 是否开启授权TOKEN验证
	 */
	private boolean enableSafer = true;
	/**
	 * 是否记录请求的详细信息
	 */
	private boolean logRequestInfo = true;
	/**
	 * 是否记录操作日志
	 */
	private boolean logOparetion = true;
	/**
	 * 是否允许本地跨域请求
	 */
	private boolean allowLocalCrossDomain = true;
	/**
	 * TOKEN存活时间，默认300，单位秒，设置30以下默认永不过期
	 */
	private long tokenLife = 60l * 5;
	/**
	 * 文件最大大小，单位KB，默认20MB
	 */
	private long fileMaxSize = 1024l * 20;
}
