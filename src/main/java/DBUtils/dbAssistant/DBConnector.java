package DBUtils.dbAssistant;

// import java.io.BufferedInputStream;
// import java.io.FileInputStream;
// import java.io.InputStream;
import java.sql.*;

/***
 * 数据库连接处理器
 * 
 * @author stvsl
 * @date 2022-6-28
 */
public class DBConnector {

    private static String JDBC_DRIVER;
    private static String DB_URL;
    private static String USER;
    private static String PASS;

    public DBConnector() {
        // configLoader();
        JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        DB_URL = "jdbc:mysql://127.0.0.1:3306/CRMS?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        USER = "root";
        PASS = "yourpassword";
    }

    /***
     * 从配置文件中读取数据库连接信息
     * 
     * @return 是否读取成功
     */
    // private boolean configLoader() {
    // try {
    // InputStream in = new BufferedInputStream(new
    // FileInputStream("src/main/java/DBUtils/sqlconfig.properties"));
    // java.util.Properties prop = new java.util.Properties();
    // prop.load(in);
    // JDBC_DRIVER = prop.getProperty("name");
    // DB_URL = prop.getProperty("url");
    // USER = prop.getProperty("user");
    // PASS = prop.getProperty("password");
    // } catch (Exception e) {
    // System.out.println("配置文件读取失败");
    // e.printStackTrace();
    // return false;
    // }
    // return true;
    // }

    /***
     * 获取数据库连接
     * 
     * @apiNote 该方法只能在本包中调用,请不要随意在其它包中调用
     * @Deprecated 该方法为过程中的方法，不建议使用
     * @return 数据库连接
     */
    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败,请检查驱动是否存在且版本配置正确。");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("数据库连接失败,请检查数据库是否存在且配置正确。");
            e.printStackTrace();
            return null;
        }
    }
}
