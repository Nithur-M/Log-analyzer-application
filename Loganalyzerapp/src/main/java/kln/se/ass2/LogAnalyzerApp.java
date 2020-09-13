package kln.se.ass2;

import kln.se.ass2.input.Input;
import kln.se.ass2.logfile.Firstreadinglog;
import kln.se.ass2.logfile.Morereadinglog;
import kln.se.ass2.logvariable.Logvariables;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class LogAnalyzerApp {
    Textfilehandler textfilehandler;
    Firstreadinglog firstreadinglog;
    Morereadinglog morereadinglog;
    Input input;
    public LogAnalyzerApp(Textfilehandler textfilehandler, Firstreadinglog firstreadinglog, Morereadinglog morereadinglog, Input input)
    {
        this.textfilehandler=textfilehandler;
        this.firstreadinglog=firstreadinglog;
        this.morereadinglog=morereadinglog;
        this.input=input;
    }

    public void show() throws FileNotFoundException {
        String logfilepath=input.readFile();

        if (!textfilehandler.isfilecreated()) {
            textfilehandler.createnewfile();
            firstreadinglog.errorchecking(logfilepath);
        }
        else {
            String previoustimestamp = textfilehandler.readinglastline();
            List<Logvariables> newlogslist = new ArrayList<Logvariables>();
            newlogslist = morereadinglog.getcurrentlogstates(logfilepath, previoustimestamp);
            if(newlogslist.isEmpty()){
                return ;
            }
            morereadinglog.errorchecking(newlogslist);
        }

    }
}