package com.tuandai.baseproject.dto.qnj.resp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
public class ChannelPlatformRelationDTO {

    @Getter
    @Setter
    private String user_id;

    @Getter
    @Setter
    private String txn_id;
}
