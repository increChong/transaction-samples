package com.example.tcctransaction.order.service;


import com.example.tcctransaction.common.dto.OrderDTO;
import com.example.tcctransaction.common.dto.ResponseData;

public interface ITOrderService {

    /**
     * 创建订单
     */
    ResponseData<OrderDTO> createOrder(OrderDTO orderDTO);
}
