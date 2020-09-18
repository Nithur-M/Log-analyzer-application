package kln.se.ass2.logfile;

import kln.se.ass2.logvariable.Log;
import kln.se.ass2.mail.Mail;
import kln.se.ass2.textcontent.Textfile;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class MorereadinglogTest extends Logfilehandler{
    Textfile textfile = mock(Textfile.class);
    Log logvariables ;
    Mail sentmail  = mock(Mail.class);

    @Test
    public void should_fetch_lines_from_readlogfile(){
        Morereadinglog morereadinglog = new Morereadinglog(textfile,logvariables,sentmail);

        morereadinglog.getcurrentlogstates("src\\main\\resources\\example.log","2020-09-06T17:24:09Z");

        assertNotNull(super.readlogfile("src\\main\\resources\\example.log"));
    }
}