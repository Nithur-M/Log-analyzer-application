package kln.se.ass2;

import kln.se.ass2.input.CommandLineInput;
import kln.se.ass2.input.Input;
import kln.se.ass2.logfile.Firstreadinglog;
import kln.se.ass2.logfile.Logfilehandler;
import kln.se.ass2.logfile.Morereadinglog;
import kln.se.ass2.logvariable.Log;
import kln.se.ass2.logvariable.Logvariables;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {

//logfilepath = "src\\main\\resources\\example.log";
        Input input=new CommandLineInput();
        Textfilehandler textfilehandler = new Textfilehandler();
        Log logvariables=new Logvariables();
        Firstreadinglog firstreadinglog = new Firstreadinglog(textfilehandler,logvariables);
        Logfilehandler logfilehandler = null;
        Morereadinglog morereadinglog = new Morereadinglog(textfilehandler,logvariables);


        LogAnalyzerApp app=new LogAnalyzerApp(textfilehandler,firstreadinglog,morereadinglog,input);
        app.show();



    }
}
