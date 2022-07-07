package Entity;

import DBUtils.DBExecutor.arrangeExec;

public class arrangeEntity implements iEntity<arrangeEntity> {
    private String classno;
    private String cno;
    private String rno;
    private String tno;
    private int times;

    public arrangeEntity() {
    }

    public arrangeEntity(String classno, String cno, String rno, String tno, int times) {
        this.classno = classno;
        this.cno = cno;
        this.rno = rno;
        this.tno = tno;
        this.times = times;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    @Override
    public int insertToDB() {
        return arrangeExec.insertToDB(this);
    }

    @Override
    public int deleteFromDB() {
        return arrangeExec.deleteFromDB(this);
    }

    @Override
    public arrangeEntity searchFromDB() {
        return arrangeExec.searchFromDB(this);
    }

    @Override
    public int updateToDB() {
        return arrangeExec.updateToDB(this);
    }

    @Override
    public String toString() {
        return arrangeExec.changeToString(classno, cno, rno, tno, times);
    }

    public String getChangeClassno() {
        return arrangeExec.changeClassno(this);
    }

    public String getChangeCno() {
        return arrangeExec.changeCno(this);
    }

    public String getChangeTno() {
        return arrangeExec.changeTno(this);
    }

    public void setChangeClassno(String classname) {
        this.classno = classname;
        arrangeExec.changebackClassno(this);
    }

    public void setChangeTno(String tname) {
        this.tno = tname;
        arrangeExec.changebackTno(this);
    }

    public void setChangeCno(String cname) {
        this.cno = cname;
        arrangeExec.changebackCno(this);
    }
}
