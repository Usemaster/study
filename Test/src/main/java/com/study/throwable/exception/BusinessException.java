package com.study.throwable.exception;

/**
 * 业务逻辑异常
 * @author gongwj
 * @Date 2023/2/20
 */
public class BusinessException extends  RuntimeException{

    static final long serialVersionUID = -7034897190745766939L;

    public BusinessException() {
        super();
    }


    public BusinessException(String message) {
        super(message);
    }


    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }


    public BusinessException(Throwable cause) {
        super(cause);
    }


    protected BusinessException(String message, Throwable cause,
                                   boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
