package com.sql.processors;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.*;

public class SQLconsoleProcessor
{
	public boolean AddDatabase(String folder)
	{
		boolean success = false;
        // Creating new database in Java, if it doesn't exists
        File directory = new File(folder);
        if (directory.exists()) 
        {
            System.out.println("Directory already exists ...");
            return false;
        } 
        else 
        {
            System.out.println("Directory not exists, creating now");
            success = directory.mkdir();
            if (success) 
            {
                System.out.printf("Successfully created new databse : %s%n", folder);
                return true;
            } 
            else 
            {
                System.out.printf("Failed to create new database: %s%n", folder);
                return false;
            }
        }
	}

	public boolean AddTable(String folder)
	{
		Scanner input= new Scanner(System.in);
		String Cname,z;
        FileWriter writer = null;
        System.out.println("Successfully created new table : ");
 		try 
 		{
    	writer = new FileWriter(folder);
   		do
    	{
        	System.out.println("enter the column name ");
        	Cname=input.next();
        	writer.append(Cname);
        	writer.append(',');
        	System.out.println("do you want to enter another column ?\nEnter YES if you want to ");
        	z=input.next();
    	}while(z.equals("YES"));
    	writer.append('\n');
     	System.out.println("Columns Created in th CSV file...");
     	return true;
  		} 
  		catch (IOException e) 
  		{
     	e.printStackTrace();
     	return false;
  		} 
  		finally 
  		{
        	try 
        	{
      		writer.flush();
      		writer.close();
        	} 
        	catch (IOException e) 
        	{
      		e.printStackTrace();
			}
		}
	}

	public boolean DeleteDatabase(File file)
	{
		//to end the recursive loop
        if (!file.exists())
        {
            return false;
        }
        
        //if directory, go inside and call recursively
        if (file.isDirectory()) 
        {
            for (File f : file.listFiles()) 
            {
                //call recursively
                DeleteDatabase(f);
            }
        }
        //call delete to delete files and empty directory
        file.delete();
        System.out.println("Deleted file/folder: "+file.getAbsolutePath());
        return true;
	}

	public boolean DeleteTable(File f2) 
	{
		if (f2.isDirectory()) 
        {
        	String[] list = f2.list();
        	for (int i = 0; i < list.length; i++) 
        	{
        	boolean success = DeleteTable(new File(f2, list[i]));
        		if (!success) 
        		{
          			return false;
        		}
        	}
    	}
    	return f2.delete();
	}
}