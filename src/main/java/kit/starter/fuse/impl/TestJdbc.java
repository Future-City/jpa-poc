package kit.starter.fuse.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class TestJdbc {

    public static void main(String[] args) throws Exception {

        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/test_schema?relaxAutoCommit=true");
        source.setUsername("root");
        source.setPassword("admin");
        source.setPoolPreparedStatements(true);

        // BasicDataSource source = new BasicDataSource();
        // source.setDriverClassName("com.mysql.jdbc.Driver");
        // source.setUrl("jdbc:mysql://fc-dev-db-1.cr3siawi9plu.us-west-1.rds.amazonaws.com:3306/fc_db_1?relaxAutoCommit=true");
        // source.setUsername("FutureCity");
        // source.setPassword("ae520b9e$");
        // source.setPoolPreparedStatements(true);

        Connection con = source.getConnection();

        String query = "SELECT * FROM users";

        Statement state = con.createStatement();
        ResultSet results = state.executeQuery(query);

        while (results.next()) {
            System.out.println(results.getString("id") + " | " + results.getString("name") + " | " + results.getString("login") + " | "
                            + results.getString("password"));
        }

        System.out.println("Fin");
    }
}
