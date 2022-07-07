package DBUtils.DBExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtils.dbAssistant.DBQueryer;
import Entity.adminEntity;

public class adminExec {

    public static int deleteAdmin(adminEntity admin) {
        DBQueryer dbq = new DBQueryer("delete from Admin where ano = '" + admin.getAno() + "'");
        return dbq.executeUpdate();
    }

    public static adminEntity searchAdmin(adminEntity admin) {
        DBQueryer dbq = new DBQueryer("select * from Admin where ano = '" + admin.getAno() + "'");
        ResultSet rs = dbq.executeQuery();
        try {
            if (rs.next()) {
                admin.setAname(rs.getString("aname"));
                admin.setPassword(rs.getString("password"));
                return admin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int register(String ano, String password, String aname) {
        DBQueryer dbq = new DBQueryer("insert into Admin values('" + ano + "','" + password + "','" + aname + "')");
        return dbq.executeUpdate();
    }

    public static int updateAdmin(adminEntity admin) {
        DBQueryer dbq = new DBQueryer(
                "update Admin set aname = '" + admin.getAname() + "',password = '" + admin.getPassword()
                        + "' where ano = '" + admin.getAno() + "'");
        return dbq.executeUpdate();
    }

}
