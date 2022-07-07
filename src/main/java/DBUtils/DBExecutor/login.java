package DBUtils.DBExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtils.dbAssistant.DBQueryer;

public class login {
    public static int verify(String username, String password) {
        DBQueryer queryer = new DBQueryer("SELECT verifypassword(?,?) AS result");
        queryer.setString(1, username);
        queryer.setString(2, password);
        ResultSet rs = queryer.executeQuery();
        try {
            if (rs.next()) {
                return rs.getInt("result");
            }
        } catch (SQLException e) {
            System.out.println("数据库执行错误：" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("未知执行错误：" + e.getMessage());
            e.printStackTrace();
        } finally {
            queryer.close();
        }
        return 0;
    }

    public static int register(String username, String password, String type) {
        DBQueryer queryer;
        if (type.equals("class")) {
            queryer = new DBQueryer("INSERT INTO Class (classno, password) VALUES(?,?)");
        } else if (type.equals("teacher")) {
            queryer = new DBQueryer("INSERT INTO Teacher (tno, password) VALUES(?,?)");
        } else {
            return -1;
        }
        queryer.setString(1, username);
        queryer.setString(2, password);
        return queryer.executeUpdate();
    }
}