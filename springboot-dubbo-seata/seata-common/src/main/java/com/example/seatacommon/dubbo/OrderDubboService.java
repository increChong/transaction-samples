package com.example.seatacommon.dubbo;


import com.example.seatacommon.dto.OrderDTO;
import com.example.seatacommon.dto.ResponseData;

/**
 * @Author: heshouyou
 * @Description  订单服务接口
 * @Date Created in 2019/1/13 16:28
 */
public interface OrderDubboService {

    /**
     * 创建订单
     */
    ResponseData<OrderDTO> createOrder(OrderDTO orderDTO);
}
