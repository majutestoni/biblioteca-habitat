package br.furb.inf.furbot.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError {
	private Integer status;
	private Integer code;
	private Long timeStamp;
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<FieldMessage>();

	public ValidationError(Integer status, Integer code, Long timeStamp) {
		setStatus(status);
		setCode(code);
		setTimeStamp(timeStamp);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String messagem) {
		errors.add(new FieldMessage(fieldName, messagem));
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
