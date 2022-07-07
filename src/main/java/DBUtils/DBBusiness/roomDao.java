package DBUtils.DBBusiness;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import Entity.roomEntity;
import DBUtils.dbAssistant.DBQueryer;

public class roomDao {
    public List<roomEntity> searchAll() {
        DBQueryer dbQueryer = new DBQueryer("SELECT * FROM Room");
        ResultSet rs = dbQueryer.executeQuery();
        List<roomEntity> rooms = new java.util.ArrayList<roomEntity>();
        try {
            while (rs.next()) {
                roomEntity r = new roomEntity();
                r.setRno(rs.getString("rno"));
                r.setDescription(rs.getString("rdescription"));
                rooms.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }
}
