package com.sefryek.broker;

import com.sefryek.broker.model.Constant;
import com.sefryek.broker.utils.PackNumeric;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/9/13
 * Time: 3:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class ServiceListUpdateImpl implements ServiceListUpdate {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);

    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String updateList(String serviceName, String request) {
        String servicType = bundle.getString("updateList");
        if (servicType.equals("1")) {
            return list_1(serviceName,request);
        } else if (servicType.equals("2")) {
            return list_2();
        } else if (servicType.equals("3")) {
            return list_3();
        }
        return "";
    }

    public String list_1(String serviceName, String request) {

        if (Constant.OUTPUT.equals("SUCCESS")) {

            String Field1 = PackNumeric.packNumeric("12345678912341");
            return "sif0s" + "|" + Field1 + "|";
        } else return "sif1acc.incorrect|";
    }

    public String list_2() {
        return "2";
    }

    public String list_3() {
        return "3";
    }
}
