package com.demo.com.usemaster;

public enum StatusEnum {

    SAVE_REVIEW("41", "新增待审批"),

    UPDATE_REVIEW("42", "修改待审批"),

    DELETE_REVIEW("43", "删除待审批"),

    START("44", "已生效"),

    IN_REVIEW("45", "待提交"),

    STOPED("46", "已退回"),

    DELETE("47", "删除"),

    ERROR_MSG("7000", "已经存在相同的卡代号对应卡产品名称和卡等级，请确认后重新输入");

    private String statusCode;
    private String statusVal;

    StatusEnum(String statusCode, String statusVal) {
        this.statusCode = statusCode;
        this.statusVal = statusVal;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getStatusVal() {
        return statusVal;
    }

}
