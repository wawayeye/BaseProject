package com.tuandai.baseproject.dto.qnj.req;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
public class PushLogsReq {

    @Getter
    @Setter
    private String txn_id;
    @Getter
    @Setter
    private int platform;
    @Getter
    @Setter
    private int type;

}
