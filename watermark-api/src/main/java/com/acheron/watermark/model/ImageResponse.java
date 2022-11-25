package com.acheron.watermark.model;

public class ImageResponse {
	
	private String imageResponse;

	public ImageResponse(String imageResponse) {
		super();
		this.imageResponse = imageResponse;
	}

	public String getImageResponse() {
		return imageResponse;
	}

	public void setImageResponse(String imageResponse) {
		this.imageResponse = imageResponse;
	}

	@Override
	public String toString() {
		return "ImageResponse [imageResponse=" + imageResponse + "]";
	}

	
	
	

}
