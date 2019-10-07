package com.mycharx.rauh.common.unifiedexception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The type Business exception.
 *
 * @author 张卜亢
 * @date 2019.10.07 22:12:31
 */
@Getter
@AllArgsConstructor
public final class BusinessException extends RuntimeException {
    private String errorCode;
    private String errorMsg;

    public static BusinessException byEnum(ExceptionEnum exceptionEnum){
        return new BusinessException(exceptionEnum.getErrorCode(),exceptionEnum.getErrorMsg());
    }
}
