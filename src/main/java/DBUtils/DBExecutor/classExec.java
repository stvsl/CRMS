package DBUtils.DBExecutor;

import java.sql.ResultSet;

import DBUtils.dbAssistant.DBQueryer;
import Entity.classesEntity;

public class classExec {
    public static int insertToDB(classesEntity c) {
        DBQueryer dbq = new DBQueryer("INSERT INTO Class VALUES('" + c.getClassno() + "','" + c.getClassname() + "','"
                + c.getClassgrade() + "','" + c.getClassdept() + "','" + c.getClassprofession() + "','"
                + c.getPassword() + "','" + c.getClasston() + "')");
        return dbq.executeUpdate();
    }

    public static int deleteFromDB(classesEntity classesEntity) {
        DBQueryer dbq = new DBQueryer("DELETE FROM Class WHERE classno='" + classesEntity.getClassno() + "'");
        return dbq.executeUpdate();
    }

    public static classesEntity searchFromDB(classesEntity classesEntity) {
        DBQueryer dbq = new DBQueryer("SELECT * FROM Class WHERE classno='" + classesEntity.getClassno() + "'");
        ResultSet rs = dbq.executeQuery();
        try {
            if (rs.next()) {
                classesEntity.setClassno(rs.getString("classno"));
                classesEntity.setClassname(rs.getString("classname"));
                classesEntity.setClassgrade(rs.getInt("classgrade"));
                classesEntity.setClassdept(rs.getString("classdept"));
                classesEntity.setClassprofession(rs.getString("classprofession"));
                classesEntity.setPassword(rs.getString("password"));
                classesEntity.setClasston(rs.getInt("classton"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classesEntity;
    }

    public static int updateToDB(classesEntity classesEntity) {
        DBQueryer dbq = new DBQueryer("UPDATE Class SET classname='" + classesEntity.getClassname() + "',classgrade='"
                + classesEntity.getClassgrade() + "',classdept='" + classesEntity.getClassdept() + "',classprofession='"
                + classesEntity.getClassprofession() + "',password='" + classesEntity.getPassword() + "',classton='"
                + classesEntity.getClasston() + "' WHERE classno='" + classesEntity.getClassno() + "'");
        return dbq.executeUpdate();
    }
}
