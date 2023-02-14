package cameleoon.trial.exception;

import javax.persistence.EntityNotFoundException;

public class QuoteNotFoundException extends EntityNotFoundException {

	public QuoteNotFoundException(String message) {
		super(message);
	}
}
