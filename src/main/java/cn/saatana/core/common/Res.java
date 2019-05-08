package cn.saatana.core.common;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class Res<T> {
	private HttpStatus status;
	private String message;
	private T data;
	private Date serviceTime = new Date();

	public static <T> Res<T> ok(T data) {
		return of(HttpStatus.OK, "操作成功", data);
	}

	public static <T> Res<T> ok(String message, T data) {
		return of(HttpStatus.OK, message, data);
	}

	public static <T> Res<T> error(T data) {
		return of(HttpStatus.INTERNAL_SERVER_ERROR, "服务器异常", data);
	}

	public static <T> Res<T> error(String message, T data) {
		return of(HttpStatus.INTERNAL_SERVER_ERROR, message, data);
	}

	public static <T> Res<T> of(HttpStatus status, String message, T data) {
		return new Res<T>().setData(data).setMessage(message).setStatus(status);
	}

	private Res() {
	}

	public Date getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Date serviceTime) {
		this.serviceTime = serviceTime;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public Res<T> setStatus(HttpStatus status) {
		this.status = status;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Res<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public T getData() {
		return data;
	}

	public Res<T> setData(T data) {
		this.data = data;
		return this;
	}
}
