package com.mycharx.rauh.common.unifiedreturn;

import com.mycharx.rauh.common.unifiedexception.BusinessException;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * The type Unified return config.
 *
 * @author 张卜亢
 * @date 2019.10.07 21:23:06
 */
@EnableWebMvc
@Configuration
public class UnifiedReturnConfig {

    private static final String FQ_NAME = "com.mycharx.rauh.controller";

    @RestControllerAdvice(FQ_NAME)
    static class UnifiedExceptionHandler {
        @ExceptionHandler(BusinessException.class)
        public CommonResult<Void> handleBusinessException(BusinessException be) {
            return CommonResult.errorResult(be.getErrorCode(), be.getErrorMsg());
        }
    }

    @RestControllerAdvice(FQ_NAME)
    static class CommonResultResponseAdvice implements ResponseBodyAdvice<Object> {
        @Override
        public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
            return true;
        }

        @Override
        public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
            if (body instanceof CommonResult) {
                return body;
            }

            return new CommonResult<Object>(body);
        }
    }
}
