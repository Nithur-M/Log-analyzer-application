package kln.se.ass2.mail;

import kln.se.ass2.mysqlrepostery.Maillist;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SendMailTest {

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

       verify(Maillist.getmailaddress());

    }
}