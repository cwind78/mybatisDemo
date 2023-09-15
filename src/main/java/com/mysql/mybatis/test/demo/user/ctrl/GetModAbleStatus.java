package com.mysql.mybatis.test.demo.user.ctrl;

import com.mysql.mybatis.test.demo.user.vo.GetModAbleStatusInVo;
import com.mysql.mybatis.test.demo.user.vo.GetModAbleStatusOutVo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GetModAbleStatus {
    public GetModAbleStatusOutVo getModAbleStatus(GetModAbleStatusInVo vo) {
        GetModAbleStatusOutVo response = new GetModAbleStatusOutVo(vo.getResCd(), "Y", "");
        TestType testType = TestType.valueOfType("nores");
        try {
            String resCd = Optional.ofNullable(vo.getResCd()).orElseThrow(() -> new Exception("예약코드가 없습니다."));

        } catch (Exception e) {
            response.setResponseFlag("E");
            response.setResponseMsg(e.getMessage());
        }

        return response;
    }

    public Map<String, String> getResult(TestType testType) {
        Map<String, String> result = new HashMap<>();
        try {


        } catch (Exception e) {

        }

        return result;
    }

    //호텔 예약 확인
    public int getHotelResYn(TestType testType) {
        return testType.getResCnt();
    }

    //정산자 결재 확인
    public int getSettAprvYn(TestType testType) {
        return testType.getSettCnt();
    }
    //분기마감 확인
    public int getQuarterDeadLineYn(TestType testType) {
        return testType.getQuarterCnt();
    }

    //출금 확인
    public int getRmtnYn(TestType testType) {
        return testType.getRmtnCnt();
    }

    //상호계산 확인
    public int getMutualYn(TestType testType) {
        return testType.getMutualCnt();
    }

    //완결 여부
    public int getEndYn(TestType testType) {
        return testType.getEndCnt();
    }

    //미완결 사유서 여부
    public int getUnfinishedReasonYn(TestType testType) {
        return testType.getReasonCnt();
    }
}