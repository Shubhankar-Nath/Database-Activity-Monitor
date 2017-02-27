import java.io.*;
import java.util.*;

public class parser
{
  public static void main(String[] args)
  {
    String stringLine, ID, time, querry;
    try
    {
    FileReader fr = new  FileReader("log.log");
    BufferedReader br =new BufferedReader(fr);
      br.readLine();//Excaping three lines
      br.readLine();
      br.readLine();
    while((stringLine=br.readLine())!=null)
    {
      if (stringLine.startWith==null)
        br.readLine();
      ID= stringLine.substring(0,6);
      System.out.println("Service ID of Querry: " +ID);
      time= stringLine.substring(7,15);
      System.out.println("Time of Querry: " +time);
      querry= stringLine.substring(16);
      System.out.println("Querry: " +querry);
      System.out.println("=============================" );
    }
  }catch (IOException e)
  {
    e.printStackTrace();
  }
  }
  }
