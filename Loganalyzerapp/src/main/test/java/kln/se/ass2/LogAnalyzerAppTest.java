package kln.se.ass2;

import kln.se.ass2.input.Input;
import kln.se.ass2.logfile.Firstreadinglog;
import kln.se.ass2.logfile.Morereadinglog;
import kln.se.ass2.mail.Mail;
import kln.se.ass2.mail.SendMail;
import kln.se.ass2.mysqlrepostery.Maillist;
import kln.se.ass2.textcontent.Textfile;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LogAnalyzerAppTest {

    Textfile textfilehandler = mock(Textfile.class);
    Firstreadinglog firstreadinglog = mock(Firstreadinglog.class);
    Morereadinglog morereadinglog   = mock(Morereadinglog.class);
    Input input = mock(Input.class);

    @Test
    public void should_getting_log_file_path() throws FileNotFoundException {

        when(input.readFilepath()).thenReturn("src\\main\\resources\\example.log");

       LogAnalyzerApp logAnalyzerApp = new LogAnalyzerApp(textfilehandler,firstreadinglog,morereadinglog,input);

       logAnalyzerApp.show();
       verify(input).readFilepath();

    }
    Mail mail = new SendMail();
    @Test
    public void should_fetch_mail_addresses_from_Maillist(){

        Maillist maillist = mock(Maillist.class);
        //   SendMail sendMail = mock(SendMail.class);
        List<String> emaillist= new ArrayList<String>();
        emaillist.add("tharunvar10@gmail.com");
        emaillist.add("tharun19@hotmail.com");

        when(Maillist.getmailaddress()).thenReturn(emaillist);

        mail.sendmail();

      //  verify(Maillist.getmailaddress());

    }


}