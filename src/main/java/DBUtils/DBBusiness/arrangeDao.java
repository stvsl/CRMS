package DBUtils.DBBusiness;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DBUtils.dbAssistant.DBQueryer;
import Entity.arrangeEntity;

public class arrangeDao {
    public List<arrangeEntity> searchAll(String id) {
        // 判断id长度
        if (id.length() == 6) {
            DBQueryer dbQueryer = new DBQueryer("SELECT * FROM Arrange WHERE tno = '" + id + "'");
            ResultSet rs = dbQueryer.executeQuery();
            List<arrangeEntity> arranges = new java.util.ArrayList<arrangeEntity>();
            try {
                while (rs.next()) {
                    arrangeEntity a = new arrangeEntity();
                    a.setClassno(rs.getString("classno"));
                    a.setCno(rs.getString("cno"));
                    a.setRno(rs.getString("rno"));
                    a.setTno(rs.getString("tno"));
                    a.setTimes(rs.getInt("times"));
                    arranges.add(a);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return arranges;
        } else {
            DBQueryer dbQueryer = new DBQueryer("SELECT * FROM Arrange WHERE classno = '" + id + "'");
            ResultSet rs = dbQueryer.executeQuery();
            List<arrangeEntity> arranges = new java.util.ArrayList<arrangeEntity>();
            try {
                while (rs.next()) {
                    arrangeEntity a = new arrangeEntity();
                    a.setClassno(rs.getString("classno"));
                    a.setCno(rs.getString("cno"));
                    a.setRno(rs.getString("rno"));
                    a.setTno(rs.getString("tno"));
                    a.setTimes(rs.getInt("times"));
                    arranges.add(a);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return arranges;
        }
    }

    // 链表转换为长度35的数组
    public arrangeEntity[] listToArray(List<arrangeEntity> list) {
        arrangeEntity[] arr = new arrangeEntity[35];
        // 迭代器
        for (int i = 0; i < list.size(); i++) {
            arr[list.get(i).getTimes()] = list.get(i);
        }
        return arr;
    }
}
