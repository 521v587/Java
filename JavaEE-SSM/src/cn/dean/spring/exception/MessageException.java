package cn.dean.spring.exception;

public class MessageException extends Exception {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public MessageException(String msg) {
		super();
		this.msg = msg;
	}
	
}
