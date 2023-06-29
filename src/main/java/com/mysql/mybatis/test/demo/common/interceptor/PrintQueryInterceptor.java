package com.mysql.mybatis.test.demo.common.interceptor;

import com.mysql.mybatis.test.demo.user.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Method;

@Slf4j
@Intercepts({
          @Signature(type=Executor.class, method="query", args={MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type=Executor.class, method="update", args={MappedStatement.class, Object.class})
        })
public class PrintQueryInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Method mthd = invocation.getMethod();
        String query = "";

        Object[] args = invocation.getArgs();
        Object param = args[1];
        MappedStatement mappedStatement = ((MappedStatement) args[0]);
        String mapperId = mappedStatement.getId();

        String sql = mappedStatement.getBoundSql(param).getSql();
        log.info("[MAPPER: {}, METHOD: {}]\n sql: {}, param: {}", mapperId, mthd.getName(), sql, param);
//        if (mthd.getName().equals("query")) {
//
//        }

        return invocation.proceed();
    }
}
