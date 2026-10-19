package exceptions;

public class ApiException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int httpCode = 500;
	
	public ApiException(String message) {
		super(message);
	}
	public ApiException(String message, int codigo) {
		super(message);
		this.httpCode = codigo;
	}
	public int getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
	
}
