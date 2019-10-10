package com.tuandai.baseproject.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 组装sql
 *
 * @author xiaoyong
 * @date 2019-03-21 17:01
 */
public class BuildSqlUtils {
    public static String SqlsEnumBuild(String sql, Object object) {
        StringBuffer whereSql = new StringBuffer(" where 1=1 ");
        Field[] f1 = object.getClass().getDeclaredFields();

        for (int i = 0; i < f1.length; i++) {
            String attributeName = f1[i].getName();
            String methodName = attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
            Object result = null;
            try {
                Method getMethod = object.getClass().getMethod("get" + methodName);
                result = getMethod.invoke(object);
            } catch (Exception e) {
                System.err.println("该类属性 用get取不到 =>"+ e);
            }
            whereSql.append(" and " + attributeName + " = \"" + result + "\";");
        }
        return sql + whereSql;
    }
}
