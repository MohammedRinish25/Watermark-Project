package com.acheron.watermark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acheron.watermark.model.ImageTemplate;

/**
 * @author MohammedRinishA
 *
 */
public interface IWatermarkRepository extends JpaRepository<ImageTemplate, Integer> {
	
	/**
	 * @param imageName to find the image by name
	 * @return the image template object
	 */
	ImageTemplate findByImageName(String imageName);

}
