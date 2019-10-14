package com.example.seataorder.service;


import com.example.seatacommon.dto.OrderDTO;
import com.example.seatacommon.dto.ResponseData;


public interface ITOrderService {

    /**
     * 创建订单
     */
    ResponseData<OrderDTO> createOrder(OrderDTO orderDTO);
}
