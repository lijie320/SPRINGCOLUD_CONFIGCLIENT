package cn.et.lesson03.entity;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Result {
	/**
	 * 0��ʾʧ��
	 * 1��ʾ�ɹ�
	 */
    private int code;
    private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		if(message!=null && message.length()>500)
		return message.substring(0, 500);
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setMessage(Exception msg) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		msg.printStackTrace(new PrintStream(bos));
		this.message = new String(bos.toByteArray());
	}
}
