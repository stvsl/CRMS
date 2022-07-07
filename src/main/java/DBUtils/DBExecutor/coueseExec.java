package DBUtils.DBExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtils.dbAssistant.DBQueryer;
import Entity.courseEntity;

public class coueseExec {

    public static int insertToDB(courseEntity c) {
        DBQueryer dbq = new DBQueryer("INSERT INTO Course VALUES('" + c.getCno() + "','" + c.getCname() + "','"
                + c.getLength() + "')");
        return dbq.executeUpdate();
    }

    public static int deleteFromDB(courseEntity c) {
        DBQueryer dbq = new DBQueryer("DELETE FROM Course WHERE cno = '" + c.getCno() + "'");
        return dbq.executeUpdate();
    }

    public static courseEntity searchFromDB(courseEntity c) {
        DBQueryer dbq = new DBQueryer("SELECT * FROM Course WHERE cno = '" + c.getCno() + "'");
        ResultSet rs = dbq.executeQuery();
        try {
            if (rs.next()) {
                c.setCname(rs.getString("cname"));
                c.setLength(rs.getInt("length"));
                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int updateToDB(courseEntity c) {
        DBQueryer dbq = new DBQueryer("UPDATE Course SET cname = '" + c.getCname() + "',length = '" + c.getLength()
                + "' WHERE cno = '" + c.getCno() + "'");
        return dbq.executeUpdate();
    }

}
