package com.tuandai.baseproject.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
public class CrawlerEntity {
    @Getter
    @Setter
    private String order_sn;
    @Getter
    @Setter
    private String type;
    @Getter
    @Setter
    private String record_version;

}
