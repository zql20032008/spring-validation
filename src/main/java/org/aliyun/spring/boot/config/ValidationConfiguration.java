package org.aliyun.spring.boot.config;

import org.aliyun.spring.validation.ValidationAspect;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @site http://syaku.tistory.com
 * @since 2017. 5. 11.
 */
@Configuration
public class ValidationConfiguration {
	private MessageSource messageSource;

	@Bean
	public ValidationAspect validationAspect() {
		return new ValidationAspect();
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:org/syaku/spring/i18n/message");

		this.messageSource = messageSource;

		return messageSource;
	}

	@Bean
	public MessageSourceAccessor messageSourceAccessor() {
		return new MessageSourceAccessor(messageSource);
	}

	/**
	 <bean id="validator" class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean">
	 <property name="validationMessageSource" ref="messageSource" />
	 </bean>
	 * @return
	 */
	@Bean
	public Validator validator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource);
		validator.afterPropertiesSet();
		return validator;
	}
}
