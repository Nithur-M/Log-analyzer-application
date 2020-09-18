package kln.se.ass2.logfile;

import kln.se.ass2.logvariable.Log;
import kln.se.ass2.logvariable.Logvariables;
import kln.se.ass2.mail.Mail;
import kln.se.ass2.textcontent.Textfile;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FirstreadinglogTest extends Logfilehandler{
    Textfile textfile = mock(Textfile.class);
    Log logvariables ;
    Mail sentmail  = mock(Mail.class);

    @Test
    public void should_fetch_lines_from_readlogfile(){


        Firstreadinglog firstreadinglog = new Firstreadinglog(textfile,logvariables,sentmail);
        firstreadinglog.errorchecking("src\\main\\resources\\example.log");

      assertNotNull(super.readlogfile("src\\main\\resources\\example.log"));

    }
}