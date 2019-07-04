/**
 * 
 */
package com.mobiquityinc.packer.exception;

/**
 * @author alex
 *
 */
public class APIException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public APIException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public APIException(Throwable cause) {
		super(cause);
	}

}
