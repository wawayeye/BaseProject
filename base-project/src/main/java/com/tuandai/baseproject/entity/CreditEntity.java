package com.tuandai.baseproject.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
public class CreditEntity {
    @Getter
    @Setter
    private int channel_no;
    @Getter
    @Setter
    private String report_json;
    @Getter
    @Setter
    private String request_no;
}
