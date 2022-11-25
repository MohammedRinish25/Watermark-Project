package com.acheron.watermark.model;




/**
 * @author MohammedRinishA
 *
 */
public class InputTemplate {
	
	
	private String imageName;
	private String message;
	/**
	 * 
	 */
	public InputTemplate() {
		super();
	}
	/**
	 * @param imageName
	 * @param message
	 */
	public InputTemplate(String imageName, String message) {
		super();
		this.imageName = imageName;
		this.message = message;
	}
	/**
	 * @return
	 */
	public String getImageName() {
		return imageName;
	}
	/**
	 * @param imageName
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	/**
	 * @return
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "InputTemplate [imageName=" + imageName + ", message=" + message + "]";
	}
	
	
	
}
