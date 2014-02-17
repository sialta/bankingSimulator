package com.sefryek.mbanking;

import com.sefryek.mbanking.mobileHandler.AccountBalanceService;
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
public class AccountBalanceServiceImpl implements AccountBalanceService {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);

    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String getAccountBalance(String serviceName, String request) {
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

        if(Constant.OUTPUT.equals("SUCCESS")){
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
        MyConnection myConnection = new MyConnection();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "SELECT * FROM test.tbl_account where code=? and acctype=?";
        String query2= "";
        String field1="";
        String field2="";
        String field3="";

        String query4 = "SELECT * FROM test.tbl_account where def=?";
        String acc = "";
        int location = 0;
        String packed="";
        String effectiveBalance= "";
        String availableBalance= "";
        String sign="";


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
                acc = rs.getString("accnumber");
                effectiveBalance=PackNumeric.packNumeric2( String.valueOf(rs.getInt("balance")));
                availableBalance=effectiveBalance;
                String sgn =String.valueOf( rs.getString("balance").substring(0,1));
                if(sgn.equals("-")){
                                  sign="-";
                }else {
                    sign="+";
                }
            }
            String date = "13901228";
             field1=PackNumeric.packNumeric2(acc+date);
             field2=sign+effectiveBalance;
             field3=sign+availableBalance;




        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return MessageBody.accountBalance + "|" + field1 + "|" + field2 + "|"+field3+"|";
        }else return "bal1acc.incorrect|";
    }

    public String get_2() {
        return "2";
    }

    public String get_3() {
        return "3";
    }
}
