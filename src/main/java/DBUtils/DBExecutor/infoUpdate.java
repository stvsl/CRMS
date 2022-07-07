package DBUtils.DBExecutor;

import DBUtils.dbAssistant.DBQueryer;

public class infoUpdate {

    /**
     * 更新教师信息
     * 
     * @param teacherid 教师id
     * @param name      教师姓名
     * @return 更新结果
     */
    public static int updateTeacherInfo(String teacherid, String name) {
        DBQueryer dbQuery = new DBQueryer("update Teacher set tname = ? where tno = ?");
        dbQuery.setString(1, name);
        dbQuery.setString(2, teacherid);
        return dbQuery.executeUpdate();
    }

    /***
     * 更新班级信息
     * 
     * @param classno    班级编号
     * @param name       班级名称
     * @param geade      班级年级
     * @param dept       班级系别
     * @param profession 班级专业
     * @param ton        班级人数
     * @return 更新结果
     */
    public static int updateClassInfo(String classno, String name, int geade, String dept, String profession, int ton) {
        DBQueryer dbQuery = new DBQueryer(
                "UPDATE Class SET classname=?, classgrade=?, classdept=?, classprofession=?, classton=? WHERE classno = ?;");
        dbQuery.setString(1, name);
        dbQuery.setInt(2, geade);
        dbQuery.setString(3, dept);
        dbQuery.setString(4, profession);
        dbQuery.setInt(5, ton);
        dbQuery.setString(6, classno);
        return dbQuery.executeUpdate();
    }

    /***
     * 更新教师密码
     * 
     * @param tno      教师编号
     * @param password 密码
     * @return 更新结果
     */
    public static int changeTeacherPassword(String tno, String password) {
        DBQueryer dbQuery = new DBQueryer("update Teacher set password = ? where tno = ?");
        dbQuery.setString(1, password);
        dbQuery.setString(2, tno);
        return dbQuery.executeUpdate();
    }

    /***
     * 更新学生密码
     * 
     * @param sno      学生编号
     * @param password 密码
     * @return 更新结果
     */
    public static int changeClassPassword(String classno, String password) {
        DBQueryer dbQuery = new DBQueryer("update Class set password = ? where classno = ?");
        dbQuery.setString(1, password);
        dbQuery.setString(2, classno);
        return dbQuery.executeUpdate();
    }

    /***
     * 更新管理员密码
     * 
     * @param adminid  管理员编号
     * @param password 密码
     * @return 更新结果
     */
    public static int changeAdminPassword(String adminid, String password) {
        DBQueryer dbQuery = new DBQueryer("update Admin set password = ? where ano = ?");
        dbQuery.setString(1, password);
        dbQuery.setString(2, adminid);
        return dbQuery.executeUpdate();
    }
}
