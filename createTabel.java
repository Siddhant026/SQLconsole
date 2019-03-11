import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.*;

class createTable
{
  System.out.println("Enter file name to be created ");
        String filename = reader.nextLine();
        filename=filename+".csv";
        folder=folder+"\\"+filename; 
        FileWriter writer = null;
        System.out.println("Successfully created new table : "+filename);

 try {
    writer = new FileWriter(folder);
    do
    {
        System.out.println("enter the column name ");
        Cname=reader.next();
        writer.append(Cname);
        writer.append(',');
        System.out.println("do you want to enter another column ?\nEnter YES if you want to ");
        z=reader.next();
    }while(z.equals("YES"));
    writer.append('\n');

     System.out.println("Columns Created in th CSV file...");

  } catch (IOException e) {
     e.printStackTrace();
  } finally {
        try {
      writer.flush();
      writer.close();
        } catch (IOException e) {
      e.printStackTrace();
}

        // close Scanner to prevent resource leak
        reader.close();
}