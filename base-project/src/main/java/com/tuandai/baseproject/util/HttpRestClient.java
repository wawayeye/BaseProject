package com.tuandai.baseproject.util;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

public class HttpRestClient {
    public static String HttpRestClient(String url, HttpMethod method, Map<String, Object> map) throws IOException {
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        HttpEntity<Map<String, Object>> request = new HttpEntity<Map<String, Object>>(map, headers);
        //  执行HTTP请求
        ResponseEntity<String> response = client.postForEntity(url, request, String.class);
        return response.getBody();
    }
}
