package com.study.throwable.exception;

/**
 * 登录失败异常
 * @author gongwj
 * @Date 2023/2/20
 */
public class LoginFailedException extends RuntimeException {

    static final long serialVersionUID = -7034897190745766939L;

    public LoginFailedException() {
        super();
    }


    public LoginFailedException(String message) {
        super(message);
    }


    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }


    public LoginFailedException(Throwable cause) {
        super(cause);
    }


    protected LoginFailedException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
