package kln.se.ass2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Maillist {
    public void getmailaddress(){
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT * FROM emailtable";
        try{
            st=Maildata.getConnection().prepareStatement(query);
            rs= st.executeQuery();
            while(rs.next()){
                String out1 = (rs.getString(2));
                System.out.println(out1);
            }

        } catch (SQLException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
