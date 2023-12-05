package com.mysql.mybatis.test.demo.config.filter;

import java.io.IOException;

import com.mysql.mybatis.test.demo.config.filter.utils.Guid;
import com.mysql.mybatis.test.demo.config.filter.utils.RequestUtils;
import com.mysql.mybatis.test.demo.config.filter.utils.RequestWrapper;
import com.mysql.mybatis.test.demo.config.filter.utils.SystemConst;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.util.StopWatch;

@Slf4j
public class FirstFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//
		Filter.super.init(filterConfig);
//		System.out.println("first filter init");
	}
	
	@SneakyThrows
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // http servlet request 일때 정상적인 로깅 진행
        if(request instanceof HttpServletRequest && response instanceof HttpServletResponse){

            RequestWrapper requestWrapper = new RequestWrapper((HttpServletRequest) request);

            // api transaction log - start
            final String serviceUri = requestWrapper.getMethod() + "_" + requestWrapper.getRequestURI();
            final String guid = Guid.getGuid(requestWrapper);

            //TODO 추후 hnt 전체 걷어낼때 실행시 JVM Option 변경 필요
            MDC.put("HOST_NAME", System.getProperty("hntframe.run.common.hostname"));
            MDC.put(Guid.GUID_NAME, guid);

            final String clientIp = RequestUtils.getClientIp(requestWrapper);
            final String headersInfo = RequestUtils.getHeadersInfo(requestWrapper);
            final String body = RequestUtils.getRequestBody(requestWrapper);

            if(body == null || body.isEmpty()){
                log.info("{} start - guid={}, serviceUrl={}, clientIp={}, headers={}", SystemConst.LOG_PREFIX, guid, serviceUri, clientIp, headersInfo);
            }else{
                log.info("{} start - guid={}, serviceUrl={}, body={}\n, clientIp={}\n, headers={}", SystemConst.LOG_PREFIX, guid, serviceUri, body, clientIp, headersInfo);
            }

            // 실제 메서드 진행 chain
            chain.doFilter(requestWrapper, response);

            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.addHeader(Guid.HTTP_HEADER_TRACKING_ID, guid);


        }else{ // http servlet request 가 아니더라도 진행 자체는 되어야 하기에 해당 부분 우선 진행 함 (논리적으로는 일어나지 않음.)
            try{
                log.info("{} start - filter in but request is not servletRequest. context path ::{}", SystemConst.LOG_PREFIX, request.getServletContext().getContextPath());
            }catch (Exception e){
                log.error("trx log start err :: ", e);
                log.warn("{} start - filter in but request is not servletRequest.", SystemConst.LOG_PREFIX);
            }

            // 실제 메서드 진행 chain
            chain.doFilter(request, response);
        }

        stopWatch.stop();
        log.info("{} end - {}ms", SystemConst.LOG_PREFIX, stopWatch.getTotalTimeMillis());

        String xSiteCode = ((HttpServletRequest) request).getHeader("X-Site-Code");
        log.info("{} end - guid={}, siteCode={}, requestURI={}"
                , SystemConst.LOG_PREFIX
                , MDC.get(Guid.GUID_NAME)
                , xSiteCode
                , ((HttpServletRequest) request).getRequestURI()
        );
	}

	@Override
	public void destroy() {
		//
//		System.out.println("first filter destroy");
		Filter.super.destroy();
	}
}
