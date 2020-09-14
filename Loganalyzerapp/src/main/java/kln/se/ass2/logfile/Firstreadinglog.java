package kln.se.ass2.logfile;

import kln.se.ass2.mail.Mail;
import kln.se.ass2.mail.SendMail;
import kln.se.ass2.logvariable.Log;
import kln.se.ass2.logvariable.Logvariables;
import kln.se.ass2.textcontent.Textfilehandler;

import java.util.List;

public class Firstreadinglog extends Logfilehandler {
    Textfilehandler textfilehandler;
    Log logvariables;
     Mail sentmail;
    public Firstreadinglog(Textfilehandler textfilehandler, Log logvariables,Mail sentmail) {
      this.textfilehandler=textfilehandler;
      this.logvariables=logvariables;
      this.sentmail=sentmail;
    }

    public void errorchecking(String logfilepath) {

        int errorstate=0;
        List<Logvariables> loglines = super.readlogfile(logfilepath);
        for (Logvariables s : loglines) {
            if ((s.getLoglevel()).contains("ERROR")) {


                if(errorstate==0) {
                    System.out.println("Error Found");
                    errorstate = 1;
                   sentmail.sendmail();

                }

            }
        }

        logvariables = loglines.get(loglines.size() - 1);
        textfilehandler.writetofile(logvariables.getTimestatmp());
    }




    }

