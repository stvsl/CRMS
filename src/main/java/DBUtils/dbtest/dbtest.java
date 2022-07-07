package DBUtils.dbtest;

import java.sql.SQLException;

import DBUtils.DBBusiness.arrangeDao;

public class dbtest {

    public static void main(String[] args) throws SQLException {
        arrangeDao a = new arrangeDao();
        a.listToArray(a.searchAll("100000"));
    }

}
