import java.io.File;

public class Main 
{
  public static void main(String[] args) throws Exception 
  {
    deleteDir(new File("C:\\Users\\Vijay kumar gupta\\Desktop\\abc\\delete.java"));
  }

  public static boolean deleteDir(File dir) 
  {
    if (dir.isDirectory()) {
      String[] children = dir.list();
      for (int i = 0; i < children.length; i++) {
        boolean success = deleteDir(new File(dir, children[i]));
        if (!success) {
          return false;
        }
      }
    }
    return dir.delete();
  }
}