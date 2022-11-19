package com.watermark.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.watermark.exception.MessageNotFoundException;
import com.watermark.exception.TemplateNotFoundException;
import com.watermark.model.ImageTemplate;
import com.watermark.repository.IWatermarkRepository;

 
/**
 * @author MohammedRinishA
 *
 */
@Service
public class WatermarkService implements IWatermarkService { 
	
	private Logger logger=LoggerFactory.getLogger(WatermarkService.class);
	IWatermarkRepository waterMarkRepository;
	
	

	/**
	 * @param waterMarkRepository
	 * 
	 */
	@Autowired
	public void setWaterMarkRepository(IWatermarkRepository waterMarkRepository) {
		this.waterMarkRepository = waterMarkRepository;
	}

    /**
     * this variable stores the destination once the image is being watermaked
     */
    @Value("${path.values}")
	public String destinationPath ;

	
	@Override
	public List<ImageTemplate> getAll() {
		logger.info("This returns the All the list which is present");
		return waterMarkRepository.findAll();

	}
	
	

	
	/**This method is used to water mark the image and return the file destination
	 * @param imageTemplate is used where all details of the templates are being passed as an object
	 * @param message is variable which stores the user message for water mark
	 * @return water mark the image and returns the destination path
	 * @throws IOException 
	 */
	@Override
	public String magick(ImageTemplate imageTemplate, String message) throws IOException {

		String inputName = imageTemplate.getImageName();
		String inputPath = imageTemplate.getPath();

		if(message.isEmpty()) {
			logger.warn("Exception occurring - no message found");
			throw new MessageNotFoundException();
		}
		else {
			

				int index = inputPath.lastIndexOf('\\');
				String location = inputPath.substring(0, index);
				logger.info("Getting the path");
				Process process = null;
				String extension = inputPath.substring(inputPath.lastIndexOf("."), inputPath.length());
				logger.info("getting the exact location");
				
				try {

					process = Runtime.getRuntime()
							 .exec("cmd /c magick convert" + inputPath
									+ " -font Arial -pointsize 35 -draw  \"gravity center fill white text 5,-35 '"
									+ message + "' \" " + inputName + "_converted" + extension, null, new File(destinationPath));
					
				
					StringBuilder output = new StringBuilder();

					BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

					String line;
					while ((line = reader.readLine()) != null) {
						output.append(line + "\n");
					}

					int exitVal = process.waitFor();
					if (exitVal == 0) {
						logger.info("successfully done the pocess");

					}

				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					process.destroy();
				}
		}		
		        return destinationPath;
		
	}

	
	
 
/**
 * @param imageName the image name is taken as the parameter passed it to check whether the image is present or not
 * @return imageTemplate details,if imageTemplate is null throws a exception
 */
@Override
	public ImageTemplate findByName(String imageName) {
	ImageTemplate imageTemplate = waterMarkRepository.findByImageName(imageName);
		if (imageTemplate == null) {
			logger.warn("Exception occurring - no image template found");
			throw new TemplateNotFoundException();
		}
		return imageTemplate;
	}



/**
 * @param imageTemplate using this we can add a new image template
 */
@Override
public void addTemplate(ImageTemplate imageTemplate) {
	logger.info("add image template");
	waterMarkRepository.save(imageTemplate);
}

}