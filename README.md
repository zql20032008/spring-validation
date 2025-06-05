Spring Validation: 数据有效性验证
基于Spring框架和Hibernate-Validator的验证功能扩展教程。



功能特性
支持对集合(Collection)或数组(Array)类型参数进行验证

将验证结果对象化，便于使用

自动整理验证结果并返回响应

依赖项
Hibernate-validator版本不限。

xml
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>4.3.2.Final</version>
</dependency>
实际使用的核心源码包是org.syaku.spring.validation.*。

配置
Bean上下文配置

java
@Configuration
public class ValidationConfiguration {

    // 应用@Validation声明式方式
    @Bean
    public ValidationAspect validationAspect() {
        return new ValidationAspect();
    }

    // 简化消息方法使用
    @Bean
    public MessageSourceAccessor messageSourceAccessor() {
        return new MessageSourceAccessor(messageSource);
    }

    /**
     <bean id="validator" class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean">
     <property name="validationMessageSource" ref="messageSource" />
     </bean>
     */
    @Bean
    public Validator validator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        // 若不声明messageSource则使用库中的默认消息
        validator.setValidationMessageSource(messageSource);
        validator.afterPropertiesSet();
        return validator;
    }
}
应用配置

java
public class ServletConfiguration extends WebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Autowired
    Validator validator;

    /**
     <mvc:annotation-driven validator="validator"/>
     */
    @Override
    public Validator getValidator() {
        return validator;
    }
    
    ... 省略 ...
}
使用方法
获取验证错误

java
@PostMapping
public String formPost(Model model, @Validated Form form, BindingResult bindingResult) {
    
    if (bindingResult.hasErrors()) {
        model.addAttribute("errors",
                new ValidationResult(
                        bindingResult,
                        new AppValidationMessage(messageSource)
                ).getFieldErrors());
    }
    
    或
    
    if (bindingResult.hasErrors()) {
        throw new ValidationException(bindingResult);
    }
}
自动处理验证错误

java
@PutMapping
@ResponseBody
public SuccessHandler ajaxPut(@Validated @RequestBody Form form) {
    return new SuccessHandler("success");
}

或

@PutMapping
@ResponseBody
public SuccessHandler ajaxPut(@Validation @RequestBody Form form) {
    return new SuccessHandler("success");
}
集合或数组类型验证

java
@PutMapping(value = "/forms")
@ResponseBody
public SuccessHandler ajaxPutForms(@Validation @RequestBody List<Form> forms, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        throw new ValidationException(bindingResult);
    }

    return new SuccessHandler("success");
}
集合或数组类型验证并自动返回结果

java
@PostMapping(value = "/forms")
@ResponseBody
public SuccessHandler ajaxPostForms(@Validation @RequestBody List<Form> forms) {
    return new SuccessHandler("success");
}
额外支持的验证功能
@Between - 验证值是否在特定范围内

@DateTime - 验证字符串是否为日期格式

@SingleByte - 验证单个字符是否为1字节(即只允许英文、数字和1字节特殊字符)

@GeneralPattern - 验证多种格式的值

支持格式:

大写字母数字下划线,
大写字母数字,
大写字母,
字母数字下划线,
字母数字,
字母,
韩文数字,
韩文,
数字,
用户ID,
定时任务表达式