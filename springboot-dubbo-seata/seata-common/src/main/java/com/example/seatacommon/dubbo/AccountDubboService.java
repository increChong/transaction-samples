package com.example.seatacommon.dubbo;


import com.example.seatacommon.dto.AccountDTO;
import com.example.seatacommon.dto.ResponseData;

/**
 * @Author: heshouyou
 * @Description  账户服务接口
 * @Date Created in 2019/1/13 16:37
 */
public interface AccountDubboService {

    /**
     * 从账户扣钱
     */
    ResponseData decreaseAccount(AccountDTO accountDTO);
}
