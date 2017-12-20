package org.example.xdiamond.paging;

import java.sql.Connection;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.RowBounds;

/**
 * 基于MySQL的Mybatis分页拦截器实现
 * 
 * @author zongying.zhao
 * @version $Id: MySQLPagingInterceptor.java, v 0.1 2017年8月22日 下午6:08:34 zongying.zhao Exp $
 */
@Intercepts(
    @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
)
public class MySQLPagingInterceptor extends AbstractPagingInterceptor {

    @Override
    public String getPagingSql(String sql, RowBounds rowBounds) {
        int offset = rowBounds.getOffset();
        int limit = rowBounds.getLimit();
        if (limit == 0) {
            return sql;
        }
        return sql + String.format(" LIMIT %d, %d", offset, limit);
    }

    @Override
    public String getCountSql(String sql) {
        int index = sql.indexOf("LIMIT");
        if (index != -1) {
            sql = sql.substring(0, index).trim();
        }
        return "SELECT count(0) FROM (" + sql + ") temp";
    }
}
