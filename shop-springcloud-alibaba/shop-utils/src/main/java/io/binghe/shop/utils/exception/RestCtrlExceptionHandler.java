package io.binghe.shop.utils.exception;

import io.binghe.shop.utils.constants.HttpCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author gongwj
 * @Date 2022/5/4
 */
@RestControllerAdvice
public class RestCtrlExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(RestCtrlExceptionHandler.class);

    /**
     * 全局异常处理，统一返回状态码
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        logger.error("服务器抛出了异常：{}", e);
        return new Result<String>(HttpCode.FAILURE, "执行失败", e.getMessage());
    }
}
