package com.mysql.mybatis.test.demo.user.type;

public enum UserType {
    REGIST("userRegist"),
    UPDATE("userUpdate"),
    DELETE("userDelete"),
    GETLIST("userGetList");

    UserType(String mthd) {
        this.mthd = mthd;
    }

    private String mthd;

    public String getMthd() {
        return this.mthd;
    }

}
