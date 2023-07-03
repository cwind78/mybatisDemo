package com.mysql.mybatis.test.demo.common.interceptor;

//import com.mysql.mybatis.test.demo.user.dao.UserDao;
//import com.mysql.mybatis.test.demo.user.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.*;

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
//        String query = "";

        Object[] args = invocation.getArgs();
        Object param = args[1];
        MappedStatement mappedStatement = ((MappedStatement) args[0]);
        String mapperId = mappedStatement.getId();

        String sql = mappedStatement.getBoundSql(param).getSql();
        log.info("[MAPPER: {}, METHOD: {}]\n sql: {}, param: {}", mapperId, mthd.getName(), sql, param);

        if (!mthd.getName().equals("query")) {
            if (mappedStatement.getCache() == null) {
                String nameSpace = mappedStatement.getId().substring(0, mappedStatement.getId().lastIndexOf("."));
                log.info("Namespace Object ID: {}", nameSpace);
                Cache cache;
                try {
                    cache = mappedStatement.getConfiguration().getCache(nameSpace);
                    if (cache != null) {
                        MetaObject metaObject = SystemMetaObject.forObject(mappedStatement);
                        metaObject.setValue("cache", cache);
                    }
                } catch (IllegalArgumentException e) {
                    //
                }
            }
        }

        return invocation.proceed();
    }

    SqlSession getSqlSession(Object[] args) {
        for(Object o: args) {
            if (o instanceof SqlSession) {
                return (SqlSession) o;
            }
        }

        return null;
    }
}
