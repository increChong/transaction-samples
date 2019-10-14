package com.example.tcctransaction.common.dubbo;


import com.example.tcctransaction.common.dto.OrderDTO;
import com.example.tcctransaction.common.dto.ResponseData;
import org.mengyun.tcctransaction.api.Compensable;

/**
 * @Author: heshouyou
 * @Description  订单服务接口
 * @Date Created in 2019/1/13 16:28
 */
public interface OrderDubboService {

    /**
     * 创建订单
     */
    @Compensable
    ResponseData<OrderDTO> createOrder(OrderDTO orderDTO);
}
