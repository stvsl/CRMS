package Entity;

import DBUtils.DBExecutor.teacherExec;

public class teacherEntity implements iEntity<teacherEntity> {
    private String tno;
    private String tname;
    private String password;

    public teacherEntity() {
    }

    public teacherEntity(String tno, String tname, String password) {
        this.tno = tno;
        this.tname = tname;
        this.password = password;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int insertToDB() {
        return teacherExec.insertToDB(this);
    }

    @Override
    public int deleteFromDB() {
        return teacherExec.deleteFromDB(this);
    }

    @Override
    public teacherEntity searchFromDB() {
        return teacherExec.searchFromDB(this);
    }

    @Override
    public int updateToDB() {
        return teacherExec.updateToDB(this);
    }
}
