package DBUtils.DBBusiness;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DBUtils.dbAssistant.DBQueryer;
import Entity.courseEntity;

public class courseDao {

    public List<courseEntity> searchAll() {
        DBQueryer dbQueryer = new DBQueryer("SELECT * FROM Course");
        ResultSet rs = dbQueryer.executeQuery();
        List<courseEntity> courses = new java.util.ArrayList<courseEntity>();
        try {
            while (rs.next()) {
                courseEntity c = new courseEntity();
                c.setCno(rs.getString("cno"));
                c.setCname(rs.getString("cname"));
                c.setLength(rs.getInt("length"));
                courses.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
