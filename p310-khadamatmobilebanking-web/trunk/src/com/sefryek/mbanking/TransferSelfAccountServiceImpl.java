package com.sefryek.mbanking;

import com.sefryek.mbanking.mobileHandler.MIDletConstant;
import com.sefryek.mbanking.model.Constant;
import com.sefryek.mbanking.model.MessageBody;
import com.sefryek.mbanking.utils.MyConnection;
import com.sefryek.mbanking.utils.PackNumeric;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/9/13
 * Time: 3:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class TransferSelfAccountServiceImpl implements TransferSelfAccountService {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);

    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String transfer(String serviceName, String request) {
        String servicType = bundle.getString("accountBalance");
        if (servicType.equals("1")) {
            return get_1(serviceName, request);
        } else if (servicType.equals("2")) {
            return get_2();
        } else if (servicType.equals("3")) {
            return get_3();
        }
        return "";
    }

    public String get_1(String serviceName, String request) {

        String accountTypeLetter = request.substring(9, 10);
        String accountType = "";
        if (accountTypeLetter.equals("j")) {
            accountType = "01";
        } else if (accountTypeLetter.equals("k")) {
            accountType = "02";
        } else if (accountTypeLetter.equals("p")) {
            accountType = "03";
        }


        String accCode = request.substring(10, 11);
        String params[] = request.toString().split(" ");
        MyConnection myConnection = new MyConnection();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "SELECT * FROM test.tbl_account where code=? and acctype=?";
        String accountNumber = "";
        String destAccount = params[3];
        String amount = params[4];
        String date = Constant.date;
        String trace = Constant.trace;
        try {
            connection = myConnection.createConnection();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        try {
            //make account number and date for Field1
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,accCode);
            preparedStatement.setString(2,accountType);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                accountNumber = rs.getString("accnumber");
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return MIDletConstant.ACC_SLF_TRANSFER+"0"+MessageBody.accountSelfTransfer + "|" +
                PackNumeric.packNumeric2(accountNumber+destAccount+date+trace+amount)+"+"+ PackNumeric.packNumeric2(Constant.availableBal) +"|";
    }

    public String get_2() {
        return "2";
    }

    public String get_3() {
        return "3";
    }
}
