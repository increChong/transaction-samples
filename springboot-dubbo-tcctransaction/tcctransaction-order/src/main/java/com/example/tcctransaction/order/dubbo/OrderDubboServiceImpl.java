package com.example.tcctransaction.order.dubbo;


import com.alibaba.dubbo.config.annotation.Service;
import com.example.tcctransaction.common.dto.OrderDTO;
import com.example.tcctransaction.common.dto.ResponseData;
import com.example.tcctransaction.common.dubbo.OrderDubboService;
import com.example.tcctransaction.order.service.ITOrderService;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
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
    @Compensable(confirmMethod = "confirmCreateOrder",cancelMethod = "cancelCreateOrder",
            transactionContextEditor = DubboTransactionContextEditor.class)
    public ResponseData<OrderDTO> createOrder(OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    public void confirmCreateOrder(OrderDTO orderDTO){
        System.out.println("TCC事务确认");
    }

    public void cancelCreateOrder(OrderDTO orderDTO){
        System.out.println("TCC事务取消");
    }
}
