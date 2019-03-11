import java.util.Scanner;
public class Options
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int options;
		System.out.println("ENTER THE OPTION FROM THE FOLLOWING:-");
		System.out.println("i.Create Database-Press 1");
		System.out.println("ii.Delete Database- Press 2");
		System.out.println("iii.Create Table-Press 3");
		System.out.println("iv.Delete table-Press 4");
		options=sc.nextInt();

switch(options)
{
	case 1:
		System.out.println("Creating the database...");
		break;
	case 2:
		System.out.println("Deleting Database...");
		break;
		case 3:
	
		System.out.println("Creating Table....");
		break;
	case 4:
		System.out.println("Deleting the table");
		break;
		default :
		System.out.println("Error:please enter a valid option");
		break;
}
}
}