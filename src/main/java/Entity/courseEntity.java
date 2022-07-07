package Entity;

import DBUtils.DBExecutor.coueseExec;

public class courseEntity implements iEntity<courseEntity> {
    private String cno;
    private String cname;
    private int length;

    public courseEntity() {
    }

    public courseEntity(String cno, String cname, int length) {
        this.cno = cno;
        this.cname = cname;
        this.length = length;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public int insertToDB() {
        return coueseExec.insertToDB(this);
    }

    @Override
    public int deleteFromDB() {
        return coueseExec.deleteFromDB(this);
    }

    @Override
    public courseEntity searchFromDB() {
        return coueseExec.searchFromDB(this);
    }

    @Override
    public int updateToDB() {
        return coueseExec.updateToDB(this);
    }

}
