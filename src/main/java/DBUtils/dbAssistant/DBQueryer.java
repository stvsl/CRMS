package DBUtils.dbAssistant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/***
 * 数据库操作助手-预查询器
 */
public class DBQueryer {
    private Connection conn;
    private PreparedStatement prep;
    private ResultSet rs;

    public DBQueryer() {
        conn = new DBConnector().getConnection();
    }

    public DBQueryer(String sql) {
        conn = new DBConnector().getConnection();
        this.prepareQuery(sql);
    }

    /***
     * 预编译查询语句
     * 
     * @param sql 查询语句
     */
    public void prepareQuery(String sql) {
        try {
            prep = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /***
     * 设置字符串
     * 
     * @param index 参数索引
     * @param value 参数值
     */
    public void setString(int index, String value) {
        try {
            prep.setString(index, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /***
     * 设置整数
     * 
     * @param index 参数索引
     * @param value 参数值
     */
    public void setInt(int index, int value) {
        try {
            prep.setInt(index, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /***
     * 设置浮点数
     * 
     * @param index 参数索引
     * @param value 参数值
     */
    public void setDouble(int index, double value) {
        try {
            prep.setDouble(index, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /***
     * 设置単精度浮点数
     * 
     * @param index 参数索引
     * @param value 参数值
     */
    public void setFloat(int index, float value) {
        try {
            prep.setFloat(index, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /***
     * 设置布尔
     * 
     * @param index 参数索引
     * @param value 参数值
     */
    public void setBoolean(int index, boolean value) {
        try {
            prep.setBoolean(index, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /***
     * 设置字节数组
     * 
     * @param index 参数索引
     * @param value 参数值
     */
    public void setBytes(int index, byte[] value) {
        try {
            prep.setBytes(index, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /***
     * 设置日期
     * 
     * @param index 参数索引
     * @param value 日期值
     */
    public void setDate(int index, java.sql.Date value) {
        try {
            prep.setDate(index, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /***
     * 设置日期时间
     * 
     * @param index 参数索引
     * @param value 日期时间
     */
    public void setTime(int index, java.sql.Time value) {
        try {
            prep.setTime(index, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置时间戳
     * 
     * @param index 参数索引
     * @param value 时间戳
     */
    public void setTimestamp(int index, java.sql.Timestamp value) {
        try {
            prep.setTimestamp(index, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /***
     * 执行查询
     * 
     * @return 查询结果
     */
    public ResultSet executeQuery() {
        try {
            rs = prep.executeQuery();
        } catch (SQLException e) {
            System.out.println("执行查询失败");
            e.printStackTrace();
        }
        return rs;
    }

    /***
     * 执行更新
     * 
     * @return 更新结果
     */
    public int executeUpdate() {
        // 打印sql语句
        System.out.println(prep.toString());
        try {
            return prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /***
     * 关闭连接
     */
    public void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (prep != null) {
                prep.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}