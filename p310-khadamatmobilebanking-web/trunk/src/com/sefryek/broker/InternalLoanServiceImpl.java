package com.sefryek.broker;

import com.sefryek.broker.model.Constant;
import com.sefryek.broker.utils.MyConnection;
import com.sefryek.broker.utils.PackNumeric;
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
public class InternalLoanServiceImpl implements LoanService {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);

    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String payLoan(String serviceName, String request) {
        String servicType = bundle.getString("internalPayLoan");
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

        if(Constant.OUTPUT.equals("SUCCESS")) {

            String accountTypeLetter = request.substring(19, 20);
            String accountType = "";
            if (accountTypeLetter.equals("j")) {
                accountType = "01";
            } else if (accountTypeLetter.equals("k")) {
                accountType = "02";
            } else if (accountTypeLetter.equals("p")) {
                accountType = "03";
            }


            String accCode = request.substring(20, 21);
        String params[] = request.toString().split(" ");
            MyConnection myConnection = new MyConnection();
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            String query = "SELECT * FROM mobile_banking.tbl_account where code=? and acctype=?";
            String accountNumber = "";
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
        String IBAN = params[2];
        String amount = params[3];
        String trace = Constant.trace;
        String Field1= PackNumeric.packNumeric2(IBAN+amount+trace);
        return "lon0b" + "|" +Field1+"|";
        }else return "lon1acc.incorrect|";
    }

    public String get_2() {
        return "2";
    }

    public String get_3() {
        return "3";
    }
}
