package com.tuandai.baseproject.service;

public interface UserService {

    /**
     * 根据orderSn查询userId
     * @param orderSn
     * @return
     */
    String getUserByOrderSn(String orderSn);
}
