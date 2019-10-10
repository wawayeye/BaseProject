package com.tuandai.baseproject.dto.qnj;

/**
 * 婚姻状况
 *
 * @author hujunfei
 * @date 2018-12-01 15:01
 */
public class Marriage {

    /**
     * 婚姻状况:1.未婚,2.已婚,3.离异,4.已婚未育,5.丧偶,6.其他
     */
    private String marriage;

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    @Override
    public String toString() {
        return "Marriage{" +
                "marriage='" + marriage + '\'' +
                '}';
    }
}
