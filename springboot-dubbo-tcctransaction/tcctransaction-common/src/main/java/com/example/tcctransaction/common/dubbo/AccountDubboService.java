package com.example.tcctransaction.common.dubbo;


import com.example.tcctransaction.common.dto.AccountDTO;
import com.example.tcctransaction.common.dto.ResponseData;
import org.mengyun.tcctransaction.api.Compensable;

/**
 * @Author: heshouyou
 * @Description  账户服务接口
 * @Date Created in 2019/1/13 16:37
 */
public interface AccountDubboService {

    /**
     * 从账户扣钱
     */
    @Compensable
    ResponseData decreaseAccount(AccountDTO accountDTO);
}
