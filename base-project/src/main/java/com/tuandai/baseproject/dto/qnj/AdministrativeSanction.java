package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 是否有行政处罚  1 无  2 有
 *
 * @author hujunfei
 * @date 2018-12-19 17:55
 */
public class AdministrativeSanction {

    /**
     * 是否有行政处罚  1 无  2 有
     */
    @JsonProperty("administrative_sanction")
    private String administrativeSanction;

    public String getAdministrativeSanction() {
        return administrativeSanction;
    }

    public void setAdministrativeSanction(String administrativeSanction) {
        this.administrativeSanction = administrativeSanction;
    }

    @Override
    public String toString() {
        return "AdministrativeSanction{" +
                "administrativeSanction='" + administrativeSanction + '\'' +
                '}';
    }
}
