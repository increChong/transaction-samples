package com.example.seatastorage.service;


import com.example.seatacommon.dto.CommodityDTO;
import com.example.seatacommon.dto.ResponseData;

/**
 * 仓库服务
 *
 * @author heshouyou
 * @since 2019-01-13
 */
public interface ITStorageService {

    /**
     * 扣减库存
     */
    ResponseData decreaseStorage(CommodityDTO commodityDTO);
}
