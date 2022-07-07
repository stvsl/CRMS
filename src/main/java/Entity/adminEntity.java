package Entity;

import DBUtils.DBExecutor.adminExec;

public class adminEntity implements iEntity<adminEntity> {
    private String ano;
    private String password;
    private String aname;

    public adminEntity() {
    }

    public adminEntity(String ano, String password, String aname) {
        this.ano = ano;
    }

    public String getAno() {
        return ano;
    }

    public String getAname() {
        return aname;
    }

    public String getPassword() {
        return password;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int insertToDB() {
        return 0;
    }

    @Override
    public int deleteFromDB() {
        return adminExec.deleteAdmin(this);
    }

    @Override
    public adminEntity searchFromDB() {
        return adminExec.searchAdmin(this);
    }

    @Override
    public int updateToDB() {
        return adminExec.updateAdmin(this);
    }
}
