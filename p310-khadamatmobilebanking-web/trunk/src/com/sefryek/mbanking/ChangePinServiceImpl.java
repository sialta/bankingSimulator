package com.sefryek.mbanking;

import com.sefryek.broker.utils.PackNumeric;
import com.sefryek.mbanking.model.Constant;
import com.sefryek.mbanking.model.MessageBody;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/9/13
 * Time: 3:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class ChangePinServiceImpl implements DefaultAccountService {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);

    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String getDefaultAccount(String serviceName, String request) {
        String servicType = bundle.getString("changePin");
        if (servicType.equals("1")) {
            return get_1(serviceName,request);
        } else if (servicType.equals("2")) {
            return get_2();
        } else if (servicType.equals("3")) {
            return get_3();
        }
        return "";
    }

    public String get_1(String serviceName, String request) {

        if(Constant.OUTPUT.equals("SUCCESS")){
        String accountNumber = "";
        return MessageBody.defaultAccount + "~" + accountNumber + "~|"+ PackNumeric.packNumeric(Constant.listOfAccountsWithPosition)+"|"+Constant.defaultAccountLocation+"|";
        }else return "def1acc.incorrect|";
    }

    public String get_2() {
        return "2";
    }

    public String get_3() {
        return "3";
    }
}
