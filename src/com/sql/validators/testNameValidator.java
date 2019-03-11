package com.sql.validators;

import com.sql.exceptions.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.util.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class testNameValidator
{
	public boolean nameValidator(String filename)
	{
		System.out.println("File name is: "+filename);
		boolean b;
		Properties prop = new Properties();
		FileInputStream input=null; 
		Logger logger = Logger.getLogger(NameValidator.class);
		PropertyConfigurator.configure("C:\\Users\\Sanjay\\Desktop\\SQLconsole\\configs\\logger\\logger.properties");
		try
		{	
			input = new FileInputStream("C:\\Users\\Sanjay\\Desktop\\SQLconsole\\configs\\constants\\exceptions.properties");
			prop.load(input);
			emptyFileName(filename);
			fileLength(filename);
			specialCharacter(filename);
			logger.info("At this time the Table/Database is created/detelted");
		}
		catch(EmptyFileNameException e)
		{
			logger.error("\n \n"+e+prop.getProperty("emptyNameMessage")+"\n");
			return false;
		}
		catch(FileLengthException e)
		{
			logger.error("\n \n"+e+prop.getProperty("longFileNameMessage")+"\n");
			return false;
		}
		catch(SpecialCharacterException e)
		{
			logger.error("\n \n"+e+prop.getProperty("specialcharacterMessage")+"\n");
			return false;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return true;
	}
	private void emptyFileName(String filename)throws EmptyFileNameException
	{
		if (filename=="")
			throw new EmptyFileNameException("Empty File Name Exception");
	}
	private void fileLength(String fileName)throws FileLengthException
	{
		int fileLength=25;
		String namelength = fileName.split("\\.")[0];
		if(namelength.length()>fileLength)
			throw new FileLengthException("File Length Exception");
	}
	private void specialCharacter(String fileName)throws SpecialCharacterException
	{
		fileName = fileName.split("\\.")[0];
		Pattern  patternGet = Pattern.compile("[@#$%^&(,)_]");
		Matcher check = patternGet.matcher(fileName);
		boolean finalValue = check.find();
		if (finalValue == true)
			throw new SpecialCharacterException("Special Character Exception");
	}
}

class NameValidator
{
	public static void main(String[] args)
	{
		testNameValidator Object = new testNameValidator();
		boolean checkValidator = Object.nameValidator("database1");
		System.out.println(checkValidator);
		checkValidator = Object.nameValidator("ta&le");
		System.out.println(checkValidator);
	}
}