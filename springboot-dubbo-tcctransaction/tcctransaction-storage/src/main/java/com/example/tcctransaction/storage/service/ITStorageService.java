package com.example.tcctransaction.storage.service;


import com.example.tcctransaction.common.dto.CommodityDTO;
import com.example.tcctransaction.common.dto.ResponseData;

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
