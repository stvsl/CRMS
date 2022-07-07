package DBUtils.DBExecutor;

import java.sql.ResultSet;

import DBUtils.dbAssistant.DBQueryer;
import Entity.teacherEntity;

public class teacherExec {

    public static int insertToDB(teacherEntity teacherEntity) {
        DBQueryer dbQueryer = new DBQueryer("insert into Teacher values(?,?,?)");
        dbQueryer.setString(1, teacherEntity.getTno());
        dbQueryer.setString(2, teacherEntity.getTname());
        dbQueryer.setString(3, teacherEntity.getPassword());
        return dbQueryer.executeUpdate();
    }

    public static int deleteFromDB(teacherEntity teacherEntity) {
        DBQueryer dbQueryer = new DBQueryer("delete from Teacher where tno=?");
        dbQueryer.setString(1, teacherEntity.getTno());
        return dbQueryer.executeUpdate();
    }

    public static teacherEntity searchFromDB(teacherEntity teacherEntity) {
        DBQueryer dbQueryer = new DBQueryer("select * from Teacher where tno=?");
        dbQueryer.setString(1, teacherEntity.getTno());
        ResultSet rs = dbQueryer.executeQuery();
        try {
            if (rs.next()) {
                teacherEntity.setTno(rs.getString("tno"));
                teacherEntity.setTname(rs.getString("tname"));
                teacherEntity.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherEntity;
    }

    public static int updateToDB(teacherEntity teacherEntity) {
        DBQueryer dbQueryer = new DBQueryer("update Teacher set tname=?,password=? where tno=?");
        dbQueryer.setString(1, teacherEntity.getTname());
        dbQueryer.setString(2, teacherEntity.getPassword());
        dbQueryer.setString(3, teacherEntity.getTno());
        return dbQueryer.executeUpdate();
    }

}
