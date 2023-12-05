package com.mysql.mybatis.test.demo.config.filter.utils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.StringUtils;

//import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Slf4j
@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class Guid {
    public final static String HTTP_HEADER_TRACKING_ID = "X-GUID";
    public final static String GUID_NAME = "guid";

    /**
     * request 의 header 로 부터 가져온 guid 가 있을경우 해당 guid 를<br>
     * 없을 경우 새로운 guid 를 생성해서 반환한다.
     * @param request 요청 HttpServletRequest
     * @return 최종 확정된 guid
     */
    public static String getGuid(HttpServletRequest request){
        String guid = request.getHeader(GUID_NAME);
        if (guid == null || guid.isEmpty()) {
            guid = UUID.randomUUID().toString();
//            log.info("## created GUID={}", guid);
        }
        return guid;
    }
}
