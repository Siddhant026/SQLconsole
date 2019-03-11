import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.*;

class addDatavase
{
    public static String AddDatabase(String dir)
    {
        System.out.println("Enter Name of Database");
        String database=reader.nextLine();
        String folder=dir+"\\"+database;
        //delfol=folder;

        // Creating new database in Java, if it doesn't exists
        File directory = new File(folder);
        if (directory.exists()) 
        {
            System.out.println("Directory already exists ...");
        } 
        else 
        {
            System.out.println("Directory not exists, creating now");

            success = directory.mkdir();
            if (success) 
            {
                System.out.printf("Successfully created new databse : %s%n", folder);
            } 
            else 
            {
                System.out.printf("Failed to create new database: %s%n", folder);
            }
        }

        return folder;
    }
}

