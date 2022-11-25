package com.acheron.watermark.service;

import java.io.IOException;
import java.util.List;

import com.acheron.watermark.exception.MessageNotFoundException;
import com.acheron.watermark.exception.TemplateNotFoundException;
import com.acheron.watermark.model.ImageResponse;
import com.acheron.watermark.model.ImageTemplate;

/**
 * @author MohammedRinishA
 *
 */

public interface IWatermarkService {
	
    
    /**
     * @return the list of templates 
     */
    List<ImageTemplate> getAll();
	
    /**
     * @param name passing the name as an argument to find the image by name
     * @return the image template
     * @throws TemplateNotFoundException when no templates available
     */
    ImageTemplate findByName(String name) throws TemplateNotFoundException;
     
    /**
     * @param imageTemplate passing this which has name and path to retrieve it
     * @param message to get the message from the user
     * @return the destination where the file has been stored
     * @throws TemplateNotFoundException when the template ie the image not found
     * @throws IOException when the file itself not present in the location
     */
   ImageResponse magick(ImageTemplate imageTemplate,String message) throws  IOException,MessageNotFoundException;

	/**
	 * @param imageTemplate using this we can add the templates
	 */
	void addTemplate(ImageTemplate imageTemplate);
    
    
	

}
