package DBUtils.DBExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtils.dbAssistant.DBQueryer;
import Entity.arrangeEntity;

public class arrangeExec {
    public static int insertToDB(arrangeEntity a) {
        DBQueryer dbq = new DBQueryer("insert into Arrange values('" + a.getClassno() + "','" + a.getCno() + "','"
                + a.getRno() + "','" + a.getTno() + "','" + a.getTimes() + "')");
        return dbq.executeUpdate();
    }

    public static int deleteFromDB(arrangeEntity a) {
        DBQueryer dbq = new DBQueryer("delete from Arrange where classno = '" + a.getClassno() + "' and times = '"
                + a.getTimes() + "'");
        return dbq.executeUpdate();
    }

    public static arrangeEntity searchFromDB(arrangeEntity a) {
        DBQueryer dbq = new DBQueryer("select * from Arrange where classno = '" + a.getClassno() + "'");
        ResultSet rs = dbq.executeQuery();
        try {
            if (rs.next()) {
                a.setCno(rs.getString("cno"));
                a.setRno(rs.getString("rno"));
                a.setTno(rs.getString("tno"));
                a.setTimes(Integer.parseInt(rs.getString("times")));
                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int updateToDB(arrangeEntity a) {
        DBQueryer dbq = new DBQueryer("update Arrange set cno = '" + a.getCno() + "',rno = '" + a.getRno() + "',tno = '"
                + a.getTno() + "',times = '" + a.getTimes() + "' where classno = '" + a.getClassno() + "'");
        return dbq.executeUpdate();
    }

    public static String changeToString(String classno, String cno, String rno, String tno, int times) {
        DBQueryer dbq = new DBQueryer("select classname from Class where classno = '" + classno + "'");
        ResultSet rs = dbq.executeQuery();
        try {
            if (rs.next()) {
                classno = rs.getString("classname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbq = new DBQueryer("select cname from Course where cno = '" + cno + "'");
        rs = dbq.executeQuery();
        try {
            if (rs.next()) {
                cno = rs.getString("cname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbq = new DBQueryer("select tname from Teacher where tno = '" + tno + "'");
        rs = dbq.executeQuery();
        try {
            if (rs.next()) {
                tno = rs.getString("tname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classno + "<br />" + cno + "<br />" + rno + "<br />" + tno;
    }

    public static String changeClassno(arrangeEntity arrangeEntity) {
        DBQueryer dbq = new DBQueryer(
                "select classname from Class where classno = '" + arrangeEntity.getClassno() + "'");
        ResultSet rs = dbq.executeQuery();
        try {
            if (rs.next()) {
                return rs.getString("classname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String changeCno(arrangeEntity arrangeEntity) {
        DBQueryer dbq = new DBQueryer(
                "select cname from Course where cno = '" + arrangeEntity.getCno() + "'");
        ResultSet rs = dbq.executeQuery();
        try {
            if (rs.next()) {
                return rs.getString("cname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String changeTno(arrangeEntity arrangeEntity) {
        DBQueryer dbq = new DBQueryer(
                "select tname from Teacher where tno = '" + arrangeEntity.getTno() + "'");
        ResultSet rs = dbq.executeQuery();
        try {
            if (rs.next()) {
                return rs.getString("tname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static arrangeEntity changebackClassno(arrangeEntity arrangeEntity) {
        DBQueryer dbq = new DBQueryer(
                "select classno from Class where classname = '" + arrangeEntity.getClassno() + "'");
        ResultSet rs = dbq.executeQuery();
        try {
            if (rs.next()) {
                arrangeEntity.setClassno(rs.getString("classno"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrangeEntity;
    }

    public static arrangeEntity changebackTno(arrangeEntity arrangeEntity) {
        DBQueryer dbq = new DBQueryer(
                "select tno from Teacher where tname = '" + arrangeEntity.getTno() + "'");
        ResultSet rs = dbq.executeQuery();
        try {
            if (rs.next()) {
                arrangeEntity.setTno(rs.getString("tno"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrangeEntity;
    }

    public static void changebackCno(arrangeEntity arrangeEntity) {
        DBQueryer dbq = new DBQueryer(
                "select cno from Course where cname = '" + arrangeEntity.getCno() + "'");
        ResultSet rs = dbq.executeQuery();
        try {
            if (rs.next()) {
                arrangeEntity.setCno(rs.getString("cno"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
