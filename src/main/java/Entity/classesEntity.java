package Entity;

import DBUtils.DBExecutor.classExec;

public class classesEntity implements iEntity<classesEntity> {
    private String classno;
    private String classname;
    private int classgrade;
    private String classdept;
    private String classprofession;
    private String password;
    private int classton;

    public classesEntity() {
    }

    public classesEntity(String classno, String classname, int classgrade, String classdept, String classprofession,
            String password, int classton) {
        this.classno = classno;
        this.classname = classname;
        this.classgrade = classgrade;
        this.classdept = classdept;
        this.classprofession = classprofession;
        this.password = password;
        this.classton = classton;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getClassgrade() {
        return classgrade;
    }

    public void setClassgrade(int classgrade) {
        this.classgrade = classgrade;
    }

    public String getClassdept() {
        return classdept;
    }

    public void setClassdept(String classdept) {
        this.classdept = classdept;
    }

    public String getClassprofession() {
        return classprofession;
    }

    public void setClassprofession(String classprofession) {
        this.classprofession = classprofession;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getClasston() {
        return classton;
    }

    public void setClasston(int classton) {
        this.classton = classton;
    }

    @Override
    public int insertToDB() {
        return classExec.insertToDB(this);
    }

    @Override
    public int deleteFromDB() {
        return classExec.deleteFromDB(this);
    }

    @Override
    public classesEntity searchFromDB() {
        return classExec.searchFromDB(this);
    }

    @Override
    public int updateToDB() {
        return classExec.updateToDB(this);
    }

}
