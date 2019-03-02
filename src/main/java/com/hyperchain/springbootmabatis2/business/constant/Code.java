package com.hyperchain.springbootmabatis2.business.constant;

public enum Code {
    //通用部分
    UNDEFINED(-2, "未定义"),
    FAILED(-1, "失败"),
    SUCCESS(0, "成功"),

    RET_ERROR(3, "合约回执异常"),
    WX_CODE_ERROR(4, "二维码返回异常"),
    WX_LOGIN_ERROR(5,"微信登录失败"),

    USER_SPEC_NULL(201, "用户或物种不正确"),

    NO_RECORD(301, "暂无守护记录"),
    NO_RELATORS(302, "暂无无人一起守护"),

    UPLOAD_FILE_ERROR(3002, "上传文件失败"),


    REJECT_SEND_SMS(1001, "发送类型有误或者非法请求"),
    INVALIED_CODE(1002, "无效的验证码"),
    INVALIED_CONTRACT(1003, "合约不存在或不合法"),
    EMPTY_RESULT(2000, "未找到合约"),

    USER_EXISTED(2001, "用户已经存在"),
    USER_UNEXISTED(2002, "用户不存在"),
    USER_LOGINED(2003, "TOKEN无效，请重新登录"),


    NOT_SUPPORT_VERSION(2004, "不支持的编译版本"),
    PARAMETER_ERROR(8001, "参数校验异常"),
    FILE_ERROR(8002, "文件读取异常"),

    PERMISSION_DENIED(9001, "权限拒绝"),
    UNKNOWN_ABNORMAL(9002, "未知异常"),
    INVALID_USER(9003, "账户不存在，该用户可能未注册或已失效"),
    ACCOUNT_KEY_EMPTY(9004, "用户名为空"),
    ACCOUNT_ALREADY_EXIST(9005, "用户名已存在"),
    ERROR_PASSWORD(9006, "密码错误"),
    PASSWORD_ERROR_TIME_OVER(9007, "错误次数超过限制"),
    ACCOUNT_STILL_LOCK(9008, "账户仍处于锁定状态"),

    TOKEN_FORMAT_ERROR(9009, "token格式错误，不是有效token"),
    TOKEN_INVALID(9010, "token过期"),
    TOKEN_CRYPT_ERROR(9011, "token加解密异常"),

    HYPERCHAIN_ERROR(9100, "区块链异常"),

    JSON_TRANSFER_ERROR(9200, "JSON转化异常"),

    CLIENT_NOT_REGISTER(9300, "业务系统未注册"),
    CLIENT_ALREADY_REGISTER(9301, "业务系统已注册"),

    CLIENT_ROLE_NOT_EXIST(9400, "该业务系统该角色不存在"),

    SYSTEM_ERROR(9999, "系统异常，请稍后重试");

    private int code;
    private String msg;

    // 构造方法
    Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static String getMsgByCodeInt(int codeInt) {
        for (Code e : Code.values()) {
            if (e.getCode() == codeInt) {
                return e.msg;
            }
        }
        throw new IllegalArgumentException("未定义的code码:" + codeInt);
    }

    public static Code getCodeByCodeInt(int codeInt) {
        for (Code code : Code.values()) {
            if (code.getCode() == codeInt) {
                return code;
            }
        }
        throw new IllegalArgumentException("未定义的code码:" + codeInt);
    }

}
