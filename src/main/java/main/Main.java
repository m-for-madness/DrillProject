package main;

import driver.Drill_JDBCDriver;

public class Main {
    public static void main(String[] args) throws Exception {
        Drill_JDBCDriver jdbcDriver = new Drill_JDBCDriver();
        try {
            jdbcDriver.runDrillJdbcDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
