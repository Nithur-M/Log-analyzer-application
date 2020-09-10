package kln.se.ass2;


import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Maildata {
    private static String servername ="localhost";
    private static String username ="root";
    private static String dbname ="loganalyzerapp";
    private static Integer portnumber = 3308;
    private static String password ="";
    private static Object level;

    public static Connection getConnection() throws SQLException
    {
        Connection sql =null;
        MysqlDataSource datasource = new MysqlDataSource();

        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);

        try{
            sql =datasource.getConnection();
        } catch(SQLException ex){
            Logger.getLogger(" Get Connection -> " + Maildata.class.getName()).log(Level.SEVERE,null,ex);

        }
        return sql;
    }


}


