package com.tuandai.baseproject.dto.qnj;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Data
@ToString
public class UserPushLogDTO {

    @Setter
    @Getter
    private int status;

    @Setter
    @Getter
    private String txn_id;

}
