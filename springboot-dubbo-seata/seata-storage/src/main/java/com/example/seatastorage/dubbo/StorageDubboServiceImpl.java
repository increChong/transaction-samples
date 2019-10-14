package com.example.seatastorage.dubbo;

import com.example.seatacommon.dto.CommodityDTO;
import com.example.seatacommon.dto.ResponseData;
import com.example.seatacommon.dubbo.StorageDubboService;
import com.example.seatastorage.service.ITStorageService;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Service;
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
    public ResponseData decreaseStorage(CommodityDTO commodityDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        return storageService.decreaseStorage(commodityDTO);
    }
}
