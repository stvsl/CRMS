package Entity;

import DBUtils.DBExecutor.roomExec;

public class roomEntity implements iEntity<roomEntity> {

    private String rno;
    private String description;

    public roomEntity() {
    }

    public roomEntity(String rno, String description) {
        this.rno = rno;
        this.description = description;
    }

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int insertToDB() {
        return roomExec.insertToDB(this);
    }

    @Override
    public int deleteFromDB() {
        return roomExec.deleteFromDB(this);
    }

    @Override
    public roomEntity searchFromDB() {
        return roomExec.searchFromDB(this);
    }

    @Override
    public int updateToDB() {
        return roomExec.updateToDB(this);
    }

}
