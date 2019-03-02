package com.hyperchain.springbootmabatis2.business.response;

import com.hyperchain.springbootmabatis2.business.constant.Code;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class BaseResult<T> {
    private int code;
    private String message;
    private T data = (T) new Object();
    public BaseResult() {
        this.data = (T) new Object();
    }

    public BaseResult(String msg) {
        this();
        this.code = 200;
        this.message = msg;
    }

    public BaseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

  /*  public BaseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }*/

    // 与Code码交互
    public BaseResult(Code code) {
        this();
        this.code = code.getCode();
        this.message = code.getMsg();
    }

    /**
     * 返回结果代码code和消息msg，不需要返回值
     * @param code 结果类型
     */
    public final void returnWithoutValue(Code code) {
        this.code = code.getCode();
        this.message = code.getMsg();
    }

    /**
     * 返回结果代码code和消息msg，并返回值
     * @param code   结果类型
     * @param object 返回值
     */
    public final void returnWithValue(Code code, T object) {
        returnWithoutValue(code);
        this.data = object;
    }
}
