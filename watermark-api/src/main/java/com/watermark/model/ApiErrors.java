package com.watermark.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

/**
 * @author MohammedRinishA
 *
 */
public class ApiErrors {
	
	LocalDateTime time;
	String message;
	HttpStatus status;
	int statusCode;
	String error;
	/**
	 * 
	 */
	public ApiErrors() {
		super();
	}
	/**
	 * @param time
	 * @param message
	 * @param status
	 * @param statusCode
	 * @param error
	 */
	public ApiErrors(LocalDateTime time, String message, HttpStatus status, int statusCode, String error) {
		super();
		this.time = time;
		this.message = message;
		this.status = status;
		this.statusCode = statusCode;
		this.error = error;
	}
	/**
	 * @return the time
	 */
	public LocalDateTime getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "ApiErrors [time=" + time + ", message=" + message + ", status=" + status + ", statusCode=" + statusCode
				+ ", error=" + error + "]";
	}
	
}
	
			
	
