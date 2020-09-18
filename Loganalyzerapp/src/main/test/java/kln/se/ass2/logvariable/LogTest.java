package kln.se.ass2.logvariable;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class LogTest {

    Log logvariables =new Logvariables("2020-09-06T17:28:11Z","INFO","MESSAGE");

    @Test
   public void gets_the_values_from_logvariables_class_gettimestampt() {
              assertSame("2020-09-06T17:28:11Z",logvariables.getTimestatmp());
   }

    @Test
    public void gets_the_values_from_logvariables_class_getloglevel() {

        assertSame("INFO",logvariables.getLoglevel());
    }
}