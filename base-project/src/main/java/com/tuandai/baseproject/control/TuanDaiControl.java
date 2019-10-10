package com.tuandai.baseproject.control;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/test")
public class TuanDaiControl {

    @PostMapping("/test")
    public String getContactInfo() throws Exception {
//        ImpalaUtils.test();
        return  "success";
    }
}
