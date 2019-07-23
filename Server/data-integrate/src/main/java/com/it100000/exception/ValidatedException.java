package com.it100000.exception;

import com.it100000.dto.BasicResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * 参数校验异常
 *
 * @author 杨新杰
 * @date 2019/7/1116:53
 */
@RestControllerAdvice
public class ValidatedException {

    /**
     * JSON方式校验异常处理
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BasicResult methodArgumentNotValidException(Exception ex) {
        MethodArgumentNotValidException c = (MethodArgumentNotValidException) ex;
        List<ObjectError> errors = c.getBindingResult().getAllErrors();
        StringBuffer errorMsg = new StringBuffer();
        errors.forEach(x -> errorMsg.append(x.getDefaultMessage()).append(";"));
        return new BasicResult(BasicResult.FAILURE,null,errorMsg.toString());
    }

    /**
     * 表单方式校验异常处理
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public BasicResult constraintViolationException(ConstraintViolationException cve) {
        Set<ConstraintViolation<?>> cves = cve.getConstraintViolations();
        StringBuffer errorMsg = new StringBuffer();
        cves.forEach(ex -> errorMsg.append(ex.getMessage()));
        return new BasicResult(BasicResult.FAILURE,null,errorMsg.toString());
    }

}
