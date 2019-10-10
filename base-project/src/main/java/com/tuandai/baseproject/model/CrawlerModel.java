package com.tuandai.baseproject.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
public class CrawlerModel {
    @Getter
    @Setter
    private String order_sn;
    @Getter
    @Setter
    private String record_version;
    @Getter
    @Setter
    private String report_json;
    @Getter
    @Setter
    private String type;
    @Getter
    @Setter
    private String crawler_from;
}
