package com.watermark.exception;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.watermark.model.ApiErrors;

/**
 * @author MohammedRinishA
 *
 */


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	/**This method returns an over ridden HttpRequestMethodNotSupportException
    * @param ex passes the HttpRequestMethodNotSupportedException to the method
    * @param headers HttpHeaders are passed to the method 
    * @param status HttpStatus of the given request is passed
    * @param request the web request path is passed
    * @return an ResponseEntity of Object type with status, headers and errors
    */
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		String message=ex.getMessage();
		String error =" Request Method not suported";
		ApiErrors errors = new ApiErrors(LocalDateTime.now(),message,status,status.value(),error);
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	/**This method returns an over ridden handleHttpmediaTypeNotSupported exception
	    * @param ex HttpMediaTypeNotSupportedException to the method
	    * @param headers HttpHeaders are passed to the method 
	    * @param status HttpStatus of the given request is passed
	    * @param request the web request path is passed
	    * @return an ResponseEntity of Object type with status, headers and errors
	    */
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message=ex.getMessage();
		String error ="Media not suported";
		ApiErrors errors = new ApiErrors(LocalDateTime.now(),message,status,status.value(),error);
		headers.add("info", message);
		return ResponseEntity.status(status).body(errors);
	}

	/**This method returns an over ridden MissingPathVariableException exception
	    * @param ex MissingPathVariableException to the method
	    * @param headers HttpHeaders are passed to the method 
	    * @param status HttpStatus of the given request is passed
	    * @param request the web request path is passed
	    * @return an ResponseEntity of Object type with status, headers and errors
	    */

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message=ex.getMessage();
		String error ="Missing path variable";
		ApiErrors errors = new ApiErrors(LocalDateTime.now(),message,status,status.value(),error);
		headers.add("info", message);
		return ResponseEntity.status(status).body(errors);
	}

	/**This method returns an over ridden MissingServletRequestParameterExceptionexception
	    * @param ex MissingServletRequestParameterException to the method
	    * @param headers HttpHeaders are passed to the method 
	    * @param status HttpStatus of the given request is passed
	    * @param request the web request path is passed
	    * @return an ResponseEntity of Object type with status, headers and errors
	    */
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message=ex.getMessage();
		String error ="Request parameter is Missing";
		ApiErrors errors = new ApiErrors(LocalDateTime.now(),message,status,status.value(),error);
		headers.add("info", message);
		return ResponseEntity.status(status).body(errors);
	}

	/**This method returns an over ridden TypeMismatchException exception
	    * @param ex TypeMismatchException to the method
	    * @param headers HttpHeaders are passed to the method 
	    * @param status HttpStatus of the given request is passed
	    * @param request the web request path is passed
	    * @return an ResponseEntity of Object type with status, headers and errors
	    */
	
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message=ex.getMessage();
		String error ="Type Mismatch";
		ApiErrors errors = new ApiErrors(LocalDateTime.now(),message,status,status.value(),error);
		headers.add("info", message);
		return ResponseEntity.status(status).body(errors);
	}
	
	/**This method returns an  TemplateNotFoundException
	 * @param e TemplateNotFoundException to the method
	 * @return an ResponseEntity of Object type with status, headers and errors
	 */
	@ExceptionHandler(TemplateNotFoundException.class)
	public ResponseEntity<Object>handleTemplateNotFound(TemplateNotFoundException e){
		String message=e.getMessage();
		String error="Template Not Found Exception";
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),message,HttpStatus.FORBIDDEN,HttpStatus.FORBIDDEN.value(),error);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info",message);
		return ResponseEntity.status(HttpStatus.FORBIDDEN).headers(headers).body(errors);
 
	}
	
	/**This method returns an  TemplateNotFoundException
	 * @param e TemplateNotFoundException to the method
	 * @return an ResponseEntity of Object type with status, headers and errors
	 */
	@ExceptionHandler(MessageNotFoundException.class)
	public ResponseEntity<Object>handleMessageNotFound(MessageNotFoundException e){
		String message=e.getMessage();
		String error="Message Not Found Exception";
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),message,HttpStatus.FORBIDDEN,HttpStatus.FORBIDDEN.value(),error);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info",message);
		return ResponseEntity.status(HttpStatus.FORBIDDEN).headers(headers).body(errors);
 
	}
	
	/**This method returns an IOException
	 * @param e IOException to the method
	 * @return an ResponseEntity of Object type with status, headers and errors
	 */
	@ExceptionHandler(IOException.class)
	public ResponseEntity<Object>handleIoException(IOException e){
		String message=e.getMessage();
		String error="file not found error";
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),message,HttpStatus.FORBIDDEN,HttpStatus.FORBIDDEN.value(),error);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info",message);
		return ResponseEntity.status(HttpStatus.FORBIDDEN).headers(headers).body(errors);
 
	}
	
	

}
