package com.it100000.exception;

import com.it100000.dto.BasicResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * 通用异常处理
 *
 * @author 杨新杰
 * @date 2019/7/1116:54
 */
@RestControllerAdvice
public class CommonException {

    /**
     * SQL异常
     */
    @ExceptionHandler(SQLException.class)
    public BasicResult unauthenticatedException(HttpServletRequest request, Exception ex) {
        return new BasicResult(BasicResult.FAILURE, ex.getMessage(), "数据库异常");
    }


}
