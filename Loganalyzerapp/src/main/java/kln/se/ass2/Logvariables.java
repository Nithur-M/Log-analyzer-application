package kln.se.ass2;

public class Logvariables {

   private String timestatmp;
   private String loglevel;
   private String message;

    public String getTimestatmp() {
        return timestatmp;
    }

    public void setTimestatmp(String timestatmp) {
        this.timestatmp = timestatmp;
    }

    public String getLoglevel() {
        return loglevel;
    }

    public void setLoglevel(String loglevel) {
        this.loglevel = loglevel;
    }

    public Logvariables(String timestatmp, String loglevel, String message) {
        this.timestatmp = timestatmp;
        this.loglevel = loglevel;
        this.message = message;
    }


}
