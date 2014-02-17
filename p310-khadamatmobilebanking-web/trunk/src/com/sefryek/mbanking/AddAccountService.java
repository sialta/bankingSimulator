package com.sefryek.mbanking;

import com.sun.net.httpserver.HttpExchange;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/9/13
 * Time: 3:04 AM
 * To change this template use File | Settings | File Templates.
 */
public interface AddAccountService {
    public String addNewAccount(String serviceName,String request);
}
