package com.tuandai.baseproject.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class ApplyAduitData {
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String userId;
    @Getter
    @Setter
    private String recordVersion;
    @Getter
    @Setter
    private Integer type;
    @Getter
    @Setter
    private String reportJson;
    @Getter
    @Setter
    private String reportHtml;
    @Getter
    @Setter
    private Date createTime;
    @Getter
    @Setter
    private Date updateTime;
    @Getter
    @Setter
    private Integer sourceFrom;

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id  +
                ", \"userId\":\"" + userId + '\"' +
                ", \"recordVersion\":\"" + recordVersion + '\"' +
                ", \"type\":" + type +
                ", \"reportJson\":\"" + reportJson + '\"' +
                ", \"reportHtml\":\"" + reportHtml + '\"' +
                ", \"createTime\":" + createTime +
                ", \"updateTime\":" + updateTime +
                ", \"sourceFrom\":" + sourceFrom +
                '}';
    }

}
