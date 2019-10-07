package com.mycharx.rauh.common.unifiedexception;

/**
 * 异常状态枚举类
 *
 * @author 张卜亢
 * @date 2019.10.07 22:51:14
 */
public enum ExceptionEnum {
    /**
     * 未知错误
     */
    UNKNOWN_ERROR("-1", "未知错误"),
    /**
     * 参数不合法
     */
    PARAM_ERROR("1001", "参数不合法"),
    /**
     * 数据库异常
     */
    DATABASE_ERROR("1002", "数据库异常");
    private String errorCode;
    private String errorMsg;

    ExceptionEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
