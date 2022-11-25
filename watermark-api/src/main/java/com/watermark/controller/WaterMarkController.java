package com.watermark.controller;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.watermark.exception.MessageNotFoundException;
import com.watermark.exception.TemplateNotFoundException;
import com.watermark.model.ImageResponse;
import com.watermark.model.ImageTemplate;
import com.watermark.model.InputTemplate;
import com.watermark.service.IWatermarkService;



/**
 * @author MohammedRinishA
 *
 */

/**
 * @author MohammedRinishA
 *
 */
@RestController
@RequestMapping("watermark-api")
public class WaterMarkController {
	
	private Logger logger=LoggerFactory.getLogger(WaterMarkController.class);

	IWatermarkService watermarkService;

	/**
	 * @param watermarkSevice to set
	 */
	@Autowired
	public void setWatermarkService(IWatermarkService watermarkService) {
		this.watermarkService = watermarkService;
	}


	

	/**
	 * @return the list of images present
	 */
	@GetMapping("/image")
	public List<ImageTemplate> getImageTemplateList() {
		logger.info("Getting all the templates list");
		return watermarkService.getAll();
	
	}

	
	
	  /**
	 * @param inputTemplate is passed as an object to retrieve the imageName and message
	 * @return the string which is the destination where the water marked image is being stored
	 * @throws IOException 
	 * @throws TemplateNotFoundException 
	 */
	  @PostMapping("/image") 
	  public ResponseEntity<ImageResponse> process(@RequestBody InputTemplate inputTemplate) throws TemplateNotFoundException, IOException,MessageNotFoundException {
		 
		ImageTemplate imageTemplate=  watermarkService.findByName(inputTemplate.getImageName());
		logger.info("getting image in the image template");
		ImageResponse response=  watermarkService.magick(imageTemplate,inputTemplate.getMessage());
		logger.info("getting the image Template and message ");
		
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "getting image name and message");
	    return ResponseEntity.ok().headers(header).body(response);
	  
	  }
	
	
	
	/**
	 * This variable has the destination path stored in it
	 */
	@Value("${path.values}")
	public String destinationPath ;
	 
	 


	/**
	 * @param request pass the HttpServletRequest
	 * @param response get the HttpServletResponse
	 * @param fileName pass the file name
	 * @throws IOException throws the IO exception
	 */
	 
	@GetMapping("/file/{fileName:.+}")
	public void downloadResource(HttpServletRequest request, HttpServletResponse response,
	@PathVariable("fileName") String fileName) throws IOException  {
	       	
	     File file = new File( destinationPath + fileName+".jpg");
	    
		  if (file.exists()) {
          String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		  if (mimeType == null) {
			mimeType = "application/octet-stream";
			}
          response.setContentType(mimeType);

		  response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

		  response.setContentLength((int) file.length());

		  InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

		  FileCopyUtils.copy(inputStream, response.getOutputStream());

			}
		}
	}
	  
	


