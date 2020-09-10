package kln.se.ass2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        String logfilepath;

        System.out.println("Enter log file path");
        //   String logfilepath= input.nextLine();


        logfilepath = "src\\main\\resources\\example.log";

        Textfilehandler textfilehandler = new Textfilehandler();


        Logfilehandler logfilehandler = null;

        if (!textfilehandler.isfilecreated()) {
            textfilehandler.createnewfile();
            Firstreadinglog firstreadinglog = new Firstreadinglog();
            firstreadinglog.errorchecking(logfilepath);
        }
        else {
            String previoustimestamp = textfilehandler.readinglastline();
            List<Logvariables> newlogslist = new ArrayList<Logvariables>();
            Morereadinglog morereadinglog = new Morereadinglog();
            newlogslist = morereadinglog.getcurrentlogstates(logfilepath, previoustimestamp);
            if(newlogslist.isEmpty()){
                return ;
            }
            morereadinglog.errorchecking(newlogslist);
        }



    }
}
