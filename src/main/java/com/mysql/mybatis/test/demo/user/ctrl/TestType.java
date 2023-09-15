package com.mysql.mybatis.test.demo.user.ctrl;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum TestType {
    //예약여부, 정산자결재여부, 완결여부, 분기마감여부, 미완결사유서여부, 송금여부, 상호계산여부
    NORES("nores", 0, 0, 0, 0, 0, 0, 0) //예약 없어서 수정 불가
    , SETT("sett", 1, 1, 0, 0, 0, 0, 0) //정산자 결재 없어서 수정 불가
    , END("end", 1, 1, 1, 0, 0, 0, 0) //완결 되어 있어서 사유서 작성 가능
    , QUARTER("quarter", 1, 1, 1, 1, 0, 0, 0) //분기마감 되어 수정 불가
    , REASON("reason", 1, 1, 1, 0, 0, 0, 1)//미완결 사유서가 있어 수정 불가
    , RMTN("rmtn", 1, 0, 0, 0, 1, 0, 0)//송금 내역이 있어 수정 불가
    , MUTUAL("mutual", 0, 0, 0, 0, 0, 1, 0)//상호계산 내역이 있어 수정 불가
    ;

    private String label;
    private int resCnt;
    private int settCnt;
    private int endCnt;
    private int quarterCnt;
    private int reasonCnt;
    private int rmtnCnt;
    private int mutualCnt;

    TestType(String label, int resCnt, int settCnt, int endCnt, int quarterCnt, int reasonCnt, int rmtnCnt, int mutualCnt) {
        this.label = label;
        this.resCnt = resCnt;
        this.settCnt = settCnt;
        this.endCnt = endCnt;
        this.quarterCnt = quarterCnt;
        this.reasonCnt = reasonCnt;
        this.rmtnCnt = rmtnCnt;
        this.mutualCnt = mutualCnt;
    }

    String getLabel() { return this.label; }
    int getResCnt() { return this.resCnt; }
    int getSettCnt() { return this.settCnt; }
    int getEndCnt() { return this.endCnt; }
    int getQuarterCnt() { return this.quarterCnt; }
    int getReasonCnt() { return this.reasonCnt; }
    int getRmtnCnt() { return this.rmtnCnt; }
    int getMutualCnt() { return this.mutualCnt; }

    static TestType valueOfType(String label) {
        if (label == null) label = "nores";
        return Arrays.stream(values()).collect(Collectors.toMap(TestType::getLabel, Function.identity())).get(label);
    }
}
