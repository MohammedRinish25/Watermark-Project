package com.acheron.watermark.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author MohammedRinishA
 *
 */
@Entity
public class ImageTemplate {
	
	@Id
	@GeneratedValue(generator="image_gen",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="image_gen",sequenceName="image_sequence",initialValue=1,allocationSize=1)
	private Integer imageId;
	private String imageName;
	private String path;
	/**
	 * 
	 */
	public ImageTemplate() {
		super();
	}
	
	/**
	 * @param imageName
	 * @param path
	 */
	public ImageTemplate(String imageName, String path) {
		super();
		this.imageName = imageName;
		this.path = path;
	}

	/**
	 * @return
	 */
	public Integer getImageId() {
		return imageId;
	}
	/**
	 * @param imageId
	 */
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
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
	public String getPath() {
		return path;
	}
	/**
	 * @param path
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "ImageTemplate [imageId=" + imageId + ", imageName=" + imageName + ", path=" + path + "]";
	}
	
	
	
	
	
	
	
}
