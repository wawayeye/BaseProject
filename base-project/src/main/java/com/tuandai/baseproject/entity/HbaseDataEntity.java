package com.tuandai.baseproject.entity;


import java.util.Arrays;

public class HbaseDataEntity {
    private String tableName;
    private String familyName;
    private String rowKeyLike;
    private String[] columeName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getRowKeyLike() {
        return rowKeyLike;
    }

    public void setRowKeyLike(String rowKeyLike) {
        this.rowKeyLike = rowKeyLike;
    }

    public String[] getColumeName() {
        return columeName;
    }

    public void setColumeName(String[] columeName) {
        this.columeName = columeName;
    }

    @Override
    public String toString() {
        return "HbaseDataEntity{" +
                "tableName='" + tableName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", rowKeyLike='" + rowKeyLike + '\'' +
                ", columeName=" + Arrays.toString(columeName) +
                '}';
    }
}
