package com.tuandai.baseproject.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *  模型返回数据实体
 */
@Data
@ToString
public class CreditResponEntity {
    @Getter
    @Setter
    private int  channel_no;
    @Getter
    @Setter
    private String  record_id;
    @Getter
    @Setter
    private String user_id;
    @Getter
    @Setter
    private String project_id;
    @Getter
    @Setter
    private String audit_result;
    @Getter
    @Setter
    private String result_code;
    @Getter
    @Setter
    private String result_remark;

}
