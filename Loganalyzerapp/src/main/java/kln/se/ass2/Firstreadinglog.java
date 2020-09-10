package kln.se.ass2;

import java.util.List;

public class Firstreadinglog extends Logfilehandler {


     void errorchecking(String logfilepath) {

        List<Logvariables> loglines = super.readfileandstore(logfilepath);
        for (Logvariables s : loglines) {
            if ((s.loglevel).contains("ERROR")) {
                System.out.println("Error Found");
                //Calling Email Class

            }
            Textfilehandler textfilehandler = new Textfilehandler();

        }
        Textfilehandler textfilehandler = new Textfilehandler();
        Logvariables logvariables = loglines.get(loglines.size() - 1);
        textfilehandler.writetofile(logvariables.timestatmp);
    }




    }

