package driver;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.apache.drill.exec.ExecConstants;
import org.apache.drill.jdbc.Driver;

public class Drill_JDBCDriver {
    public static final String DRILL_JDBC_LOCAL_URI = "jdbc:drill:zk=local";

    public static final String DRILL_SAMPLE_QUERY = "SELECT * FROM cp.`employee.json` LIMIT 20";


    public void runDrillJdbcDriver() throws Exception {
        Connection con = null;

        try {
            con = new Driver().connect(DRILL_JDBC_LOCAL_URI, getDefaultProperties());
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(DRILL_SAMPLE_QUERY);

            int count = 0;
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                count++;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public static Properties getDefaultProperties() {
        final Properties properties = new Properties();
        properties.setProperty(ExecConstants.HTTP_ENABLE, "false");
        return properties;
    }
}
