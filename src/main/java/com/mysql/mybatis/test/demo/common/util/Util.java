package com.mysql.mybatis.test.demo.common.util;

import com.mysql.mybatis.test.demo.common.vo.Rslt;

import java.math.BigDecimal;

public class Util {
    public static boolean isEmpty(String s) {
        return s == null || s.equals("");
    }

    public static Rslt simpleProcessResponse(BigDecimal r) {
        int val = r.compareTo(BigDecimal.ONE);
        return new Rslt(val<0?"E":"S", val<0?"실패":"성공");
    }
}
