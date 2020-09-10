package kln.se.ass2;

import java.util.ArrayList;
import java.util.List;

public class Morereadinglog extends Logfilehandler {

        List<Logvariables> getcurrentlogstates(String logfilepath, String pretimestamp){

            List<Logvariables> loglines = super.readfileandstore(logfilepath);
            List<Logvariables> templog = new ArrayList<Logvariables>();


            int state = 0;

            for (Logvariables b : loglines) {

                if((b.getTimestatmp()).equals(pretimestamp)) {
                    state=1;

                    continue;
                }
                if(state==1){
                    templog.add(b);
                }

            }//End Loop

            //return statements

         if(!templog.isEmpty()) {
             //Second time reading file
             System.out.println("Second time reading file");
             return templog;
         }
         else{
              //Text already created new path files
             if(!(pretimestamp.equals(loglines.get(loglines.size() - 1).getTimestatmp()))) {
                 System.out.println("Text file already created new path files");
                 return loglines;
             }
             else{
                 //
                 System.out.println("\nThis "+logfilepath+"file is already read or containe faults statements and not contain new states\n");
                 System.out.println("Program Terminated");
                 return templog;
             }
         }

        }


        void errorchecking(List<Logvariables> newlog) {

            for (Logvariables s : newlog) {
                if ((s.getLoglevel()).contains("ERROR")) {

                    //Calling Email Class

                }
            }

            Logvariables logvariables = newlog.get(newlog.size() - 1);
            Textfilehandler textfilehandler = new Textfilehandler();
            textfilehandler.writetofile(logvariables.getTimestatmp());
        }


    }



