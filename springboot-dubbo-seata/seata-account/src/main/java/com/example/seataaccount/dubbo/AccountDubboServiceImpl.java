package com.example.seataaccount.dubbo;

import com.example.seataaccount.service.ITAccountService;
import com.example.seatacommon.dto.AccountDTO;
import com.example.seatacommon.dto.ResponseData;
import com.example.seatacommon.dubbo.AccountDubboService;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: heshouyou
 * @Description  Dubbo Api Impl
 * @Date Created in 2019/1/23 14:40
 */
@Service(version = "1.0.0",protocol = "${dubbo.protocol.id}",
         application = "${dubbo.application.id}",registry = "${dubbo.registry.id}",
         timeout = 3000)
public class AccountDubboServiceImpl implements AccountDubboService {

    @Autowired
    private ITAccountService accountService;

    @Override
    public ResponseData decreaseAccount(AccountDTO accountDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        return accountService.decreaseAccount(accountDTO);
    }
}
