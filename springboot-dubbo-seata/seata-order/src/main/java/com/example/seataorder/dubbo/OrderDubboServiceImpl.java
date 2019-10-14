package com.example.seataorder.dubbo;

import com.example.seatacommon.dto.OrderDTO;
import com.example.seatacommon.dto.ResponseData;
import com.example.seatacommon.dubbo.OrderDubboService;
import com.example.seataorder.service.ITOrderService;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: heshouyou
 * @Description
 * @Date Created in 2019/1/23 15:59
 */
@Service(version = "1.0.0",protocol = "${dubbo.protocol.id}",
        application = "${dubbo.application.id}",registry = "${dubbo.registry.id}",
        timeout = 3000)
public class OrderDubboServiceImpl implements OrderDubboService {

    @Autowired
    private ITOrderService orderService;

    @Override
    public ResponseData<OrderDTO> createOrder(OrderDTO orderDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        return orderService.createOrder(orderDTO);
    }
}
