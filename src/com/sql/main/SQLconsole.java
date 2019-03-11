package com.sql.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.*;
import com.sql.exceptions.*;
import com.sql.validators.*;
import com.sql.processors.*;

class SQLconsole
{
	static public void main(String args[])
	{
		boolean b,q;
		SQLconsoleProcessor SQLprocessor = new SQLconsoleProcessor();
		testNameValidator Validator = new testNameValidator();
		Scanner input= new Scanner(System.in);
		int options;
		String z;
		String dir,database,folder,filename;
		do
		{
			System.out.println("ENTER THE OPTION FROM THE FOLLOWING:-");
			System.out.println("i.Create Database-Press 1");
			System.out.println("ii.Delete Database- Press 2");
			System.out.println("iii.Create Table-Press 3");
			System.out.println("iv.Delete table-Press 4");
			System.out.println("Enter the Options");
			options=input.nextInt();
			switch(options)
        	{
			case 1:
				System.out.println("Creating the database...");
				System.out.println("Enter WorkSpace (location of the database)");
        		dir = input.next();
				System.out.println("Enter Name of Database");
        		database=input.next();
        		q=Validator.nameValidator(database);
        		if(q==true)
        			System.out.println("Database Name is fine");
        		folder=dir+"\\"+database;
				b=SQLprocessor.AddDatabase(folder);
				System.out.println(b);
				break;
			case 2:
				System.out.println("Deleting Database...");
				System.out.println("Enter WorkSpace (location of the database)");
        		dir = input.next();
				System.out.println("Enter Name of Database");
        		database=input.next();
        		q=Validator.nameValidator(database);
        		if(q==true)
        			System.out.println("Database Name is fine");
        		folder=dir+"\\"+database;
        		File file = new File(folder);
        		b=SQLprocessor.DeleteDatabase(file);
        		System.out.println(b);
				break;
			case 3:
				System.out.println("Creating Table....");
				System.out.println("Enter WorkSpace (location of the database)");
        		dir = input.next();
        		System.out.println("Enter Name of Database");
        		database=input.next();
        		folder=dir+"\\"+database;
				System.out.println("Enter file name to be created ");
        		filename = input.next();
        		q=Validator.nameValidator(filename);
        		if(q==true)
        			System.out.println("Table Name is fine");
        		filename=filename+".csv";
        		folder=folder+"\\"+filename;
				b=SQLprocessor.AddTable(folder);
				System.out.println(b);
				break;
			case 4:
				System.out.println("Deleting the table");
				System.out.println("Enter WorkSpace (location of the database)");
        		dir = input.next();
        		System.out.println("Enter Name of Database");
        		database=input.next();
        		folder=dir+"\\"+database;
				System.out.println("Enter file name to be deleted ");
        		filename = input.next();
        		q=Validator.nameValidator(filename);
        		if(q==true)
        			System.out.println("Table Name is fine");
        		filename=filename+".csv";
        		folder=folder+"\\"+filename;
        		File f2 = new File(folder);
        		b=SQLprocessor.DeleteTable(f2);
        		System.out.println(b);
				break;
			default :
				System.out.println("Error:please enter a valid option");
				break;
			}
			System.out.println("If you want to run the code again type YES ");
			z=input.next();
		}while(z.equals("YES"));
    }   
}