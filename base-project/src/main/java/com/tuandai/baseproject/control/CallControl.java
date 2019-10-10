package com.tuandai.baseproject.control;


import com.tuandai.baseproject.entity.CallEntiry;
import com.tuandai.baseproject.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/call")
public class CallControl {
    @Autowired
    private CallService callService;
    @PostMapping("/getContactInfo1")
    public String getContactInfo(@RequestBody CallEntiry callEntiry) throws IOException{

        return  callService.getContactInfo(callEntiry).toString();
    }
    @PostMapping("/getContactRecord1")
    public String getContactRecord(@RequestBody CallEntiry callEntiry) throws IOException{

        return  callService.getContactRecord(callEntiry).toString();
    }
    @PostMapping("/getContactInfo")
    public String getContactInfoBykudu(@RequestBody CallEntiry callEntiry) throws Exception {

        return  callService.getContactInfoBykudu(callEntiry).toString();
    }
    @PostMapping("/getContactRecord")
    public String getContactRecordBykudu(@RequestBody CallEntiry callEntiry) throws Exception {

        return  callService.getContactRecordBykudu(callEntiry).toString();
    }
}
