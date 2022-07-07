package DBUtils.DBExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtils.dbAssistant.DBQueryer;
import Entity.roomEntity;

public class roomExec {
    public static int insertToDB(roomEntity r) {
        DBQueryer dbq = new DBQueryer("INSERT INTO Room VALUES('" + r.getRno() + "','" + r.getDescription() + "')");
        return dbq.executeUpdate();
    }

    public static int deleteFromDB(roomEntity r) {
        DBQueryer dbq = new DBQueryer("DELETE FROM Room WHERE rno = '" + r.getRno() + "'");
        return dbq.executeUpdate();
    }

    public static roomEntity searchFromDB(roomEntity r) {
        DBQueryer dbq = new DBQueryer("SELECT * FROM Room WHERE rno = '" + r.getRno() + "'");
        ResultSet rs = dbq.executeQuery();
        try {
            if (rs.next()) {
                r.setDescription(rs.getString("rdescription"));
                return r;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int updateToDB(roomEntity r) {
        DBQueryer dbq = new DBQueryer("UPDATE Room SET rdescription = '" + r.getDescription() + "' WHERE rno = '"
                + r.getRno() + "'");
        return dbq.executeUpdate();
    }
}
