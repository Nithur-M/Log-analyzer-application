package kln.se.ass2.textcontent;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class TextfilehandlerTest {



    @Test
    public void file_created_or_not(){

        FileExistence tfh = new FileExistence();
        assertTrue(tfh.isfilecreated());
    }

    @Test
    public void create_new_file_working_or_not(){

        CreateFile tfh = new CreateFile ();
        tfh.createnewfile();
    }

    @Test
    public void check_writetofile(){

     WriteFile tfh = new WriteFile();
        tfh.writetofile("jh");

    }

    @Test
    public void check_lastlinereading() throws FileNotFoundException {

        ReadLastLine tfh = new ReadLastLine();
      String string=  tfh.readinglastline();
      assertNotNull(string);

    }

}