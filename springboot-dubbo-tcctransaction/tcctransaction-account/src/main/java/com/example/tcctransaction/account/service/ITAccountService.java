package com.example.tcctransaction.account.service;


import com.example.tcctransaction.common.dto.AccountDTO;
import com.example.tcctransaction.common.dto.ResponseData;

public interface ITAccountService {

    /**
     * 扣用户钱
     */
    ResponseData decreaseAccount(AccountDTO accountDTO);
}
