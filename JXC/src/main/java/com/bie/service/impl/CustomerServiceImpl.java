package com.bie.service.impl;

import org.springframework.stereotype.Service;

import com.bie.po.JxcCustomer;
import com.bie.service.CustomerService;
/***
 * 
 * @author 别先生
 * 1:客户的业务层实现类,继承工具类,实现客户接口
 */
@Service("customerService")
public class CustomerServiceImpl extends BaseServiceImpl<JxcCustomer> implements CustomerService{

}
