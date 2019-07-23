package com.it100000.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 基本的通用返回对象
 *
 * @author 杨新杰
 * @date 2019/7/1115:41
 */
@Data
@ToString
@EqualsAndHashCode
public class BasicResult {

    /**
     * 成功
     */
    public static final int SUCCESS = 1;

    /**
     * 失败
     */
    public static final int FAILURE = 0;


    private int status;

    private Object data;

    private String msg;

    public BasicResult(int status, Object data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    /**
     * 成功返回
     * @param data 可变参数,可以为空,也可以传入多个obj
     * @return 基本数据传输对象
     * @author 杨新杰
     * @date 2019/7/11 16:08
     **/
    public static BasicResult successResult(Object... data) {
        if (data.length == 0){
            return new BasicResult(BasicResult.SUCCESS, "[]" , "操作成功");
        }
        return new BasicResult(BasicResult.SUCCESS, data, "操作成功");
    }

    /**
     * 成功返回
     * @param data 可变参数,可以为空,也可以传入多个obj
     * @return 基本数据传输对象
     * @author 杨新杰
     * @date 2019/7/11 16:08
     **/
    public static BasicResult failureResult(Object... data) {
        if (data.length == 0){
            return new BasicResult(BasicResult.FAILURE, "[]", "操作失败");
        }
        return new BasicResult(BasicResult.FAILURE, data, "操作失败");
    }


}
