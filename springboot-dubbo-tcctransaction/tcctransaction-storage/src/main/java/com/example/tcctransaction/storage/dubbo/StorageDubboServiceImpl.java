package com.example.tcctransaction.storage.dubbo;


import com.alibaba.dubbo.config.annotation.Service;
import com.example.tcctransaction.common.dto.CommodityDTO;
import com.example.tcctransaction.common.dto.ResponseData;
import com.example.tcctransaction.common.dubbo.StorageDubboService;
import com.example.tcctransaction.storage.service.ITStorageService;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: heshouyou
 * @Description
 * @Date Created in 2019/1/23 16:13
 */
@Service(version = "1.0.0",protocol = "${dubbo.protocol.id}",
        application = "${dubbo.application.id}",registry = "${dubbo.registry.id}",
        timeout = 3000)
public class StorageDubboServiceImpl implements StorageDubboService {

    @Autowired
    private ITStorageService storageService;

    @Override
    @Compensable(confirmMethod = "confirmDecreaseStorage",cancelMethod = "cancelDecreaseStorage",
    transactionContextEditor = DubboTransactionContextEditor.class)
    public ResponseData decreaseStorage(CommodityDTO commodityDTO) {
        return storageService.decreaseStorage(commodityDTO);
    }

    public void confirmDecreaseStorage(CommodityDTO commodityDTO) {
        System.out.println("TCC事务确认");
    }
    public void cancelDecreaseStorage(CommodityDTO commodityDTO) {
        System.out.println("TCC事务取消");
    }
}
