package org.example.xdiamond.util;

import java.util.List;
import java.util.Map;


/**
 * 数据访问器接口
 * 
 * @author zongying.zhao
 * @version $Id: DataAccessor.java, v 0.1 2017年8月22日 下午6:07:00 zongying.zhao Exp $
 */
public interface DataAccessor {

    <T> T selectOne(String statementId);

    <T> T selectOne(String statementId, Object sqlParam);

    // ----------------------------------------------------------------------------------------------------

    <T> List<T> selectList(String statementId);

    <T> List<T> selectList(String statementId, Object sqlParam);

    // ----------------------------------------------------------------------------------------------------

    <K, V> Map<K, V> selectMap(String statementId, String mapKey);

    <K, V> Map<K, V> selectMap(String statementId, Object sqlParam, String mapKey);

    // ----------------------------------------------------------------------------------------------------

    <T> PaginationResult<T> selectPaging(String statementId, int pageNumber, int pageSize);

    <T> PaginationResult<T> selectPaging(String statementId, Object sqlParam, int pageNumber, int pageSize);

    // ----------------------------------------------------------------------------------------------------

    int insert(String statementId);

    int insert(String statementId, Object sqlParam);

    // ----------------------------------------------------------------------------------------------------

    int update(String statementId);

    int update(String statementId, Object sqlParam);

    // ----------------------------------------------------------------------------------------------------

    int delete(String statementId);

    int delete(String statementId, Object sqlParam);
}
