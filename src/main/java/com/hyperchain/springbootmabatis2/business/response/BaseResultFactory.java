package com.hyperchain.springbootmabatis2.business.response;

import com.hyperchain.springbootmabatis2.business.constant.Code;

public final class BaseResultFactory {

    public static BaseResult produceEmptyResult(Code code) {
        return new BaseResult(code);
    }

    public static BaseResult produceEmptyResult(int codeInt, String msg) {
        return new BaseResult(codeInt, msg);
    }

    public static BaseResult produceResult(int codeInt, String msg, Object data) {
        return new BaseResult(codeInt, msg, data);
    }

    public static BaseResult produceResult(Code code, Object data) {
        return new BaseResult(code.getCode(), code.getMsg(), data);
    }

}
