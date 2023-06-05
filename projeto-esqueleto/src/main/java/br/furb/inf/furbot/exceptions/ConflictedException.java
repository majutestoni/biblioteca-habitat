package br.furb.inf.furbot.exceptions;

public class ConflictedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ConflictedException(String message) {
		super(message);
	}

}
