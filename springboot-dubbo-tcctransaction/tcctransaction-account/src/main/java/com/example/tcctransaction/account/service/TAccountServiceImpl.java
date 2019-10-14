package com.example.tcctransaction.account.service;

import com.example.tcctransaction.account.mapper.TAccountDao;
import com.example.tcctransaction.common.dto.AccountDTO;
import com.example.tcctransaction.common.dto.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TAccountServiceImpl implements ITAccountService {


    @Autowired
    private TAccountDao tAccountDao;

    /**
     * 扣用户钱
     *
     * @param accountDTO
     */
    @Override
    public ResponseData decreaseAccount(AccountDTO accountDTO) {
        int account = tAccountDao.decreaseAccount(accountDTO.getUserId(), accountDTO.getAmount().doubleValue());
        if (account > 0) {
            return new ResponseData("10000", "success");
        }
        return new ResponseData("20000", "fail");
    }
}
