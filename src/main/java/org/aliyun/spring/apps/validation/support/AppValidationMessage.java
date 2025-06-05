package org.aliyun.spring.apps.validation.support;

import org.aliyun.spring.validation.ValidationMessage;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.validation.FieldError;

/**
 * 
 *
 * @author bruce.zql

 * @since 2025. 5. 16.
 */
	public class AppValidationMessage implements ValidationMessage {
	private final MessageSourceAccessor messageSourceAccessor;

	public AppValidationMessage(MessageSourceAccessor messageSourceAccessor) {
		this.messageSourceAccessor = messageSourceAccessor;
	}

	@Override
	public String getFieldName(FieldError fieldError) {
		return messageSourceAccessor.getMessage("text.field." + fieldError.getField(), fieldError.getField());
	}

	@Override
	public String getBindingFailure(FieldError fieldError) {
		return messageSourceAccessor.getMessage("text.valid.Invalid", fieldError.getDefaultMessage());
	}
}
