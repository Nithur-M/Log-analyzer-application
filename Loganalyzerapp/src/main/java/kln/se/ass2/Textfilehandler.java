package kln.se.ass2;

import java.io.*;
import java.util.Scanner;

public class Textfilehandler {

    public static String filepath ="src\\main\\resources\\text.txt";

  static  File textfile = new File(filepath);

     public Boolean isfilecreated(){

         if(textfile.exists()){
             return true;
         }
         else{
             return false;
         }
     }

     public void createnewfile(){
         try {
             textfile.createNewFile();
         }
         catch (IOException i){
             System.out.println(i);
         }
     }

     public void writetofile(String currenttimestamp){

         try {
             FileWriter fw = new FileWriter(filepath,true);
             fw.write("\n"+currenttimestamp);
             fw.close();
         }
         catch(Exception e){
             System.out.println(e);
         }
     }

     public String readinglastline() throws FileNotFoundException {
         String strLine = null;
         String lastlinestring="";

         try {
             FileInputStream fis = new FileInputStream(filepath);
             DataInputStream dis = new DataInputStream(fis);
             BufferedReader br = new BufferedReader(new InputStreamReader(dis));
             LineNumberReader ln = new LineNumberReader(br);
             Scanner sn= new Scanner(fis);


             while ((strLine = br.readLine()) != null) {
                    lastlinestring=strLine;

             }
         } catch (IOException e) {
             e.printStackTrace();
         }

    return lastlinestring;
    }


}
