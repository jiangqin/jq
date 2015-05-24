import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Readtext {
  public Readtext()
  {}
  public  double[] result=new double[2];
  public  int sizeObject;
  public int sizeAttribute;
  public int dense;
  public int Alg;
  public int delSize;
  public  void Read(String FileName)
    throws FileNotFoundException, IOException
  {
	//读入数据文件
	   FileInputStream is=new FileInputStream(FileName);
       InputStreamReader ir=new InputStreamReader(is);
       BufferedReader in =new BufferedReader(ir);
       String strln;
       int Count=0;
     
      //读文件
       while((strln=in.readLine())!=null)
      {
    	   Count++;
    	   //解析文件名
    	   if(Count==3)
    	   {
    		   String[] attList=strln.split(" ");
    		   String str=attList[1];
    		   int findex=str.indexOf(".");
    		   int indexOfK=str.indexOf("K");
    		   String size="";
    		    size=str.substring(findex+1,indexOfK);
    		    size.trim();
    		    sizeObject=Integer.parseInt(size)*100;
    		    int indexOfP=str.indexOf("P");	  	
    		    String sizeAttribute1=str.substring(indexOfK+1,indexOfP);
    		    sizeAttribute=Integer.parseInt(str.substring(indexOfK+1,indexOfP));
    		    int indexOfL=str.indexOf("L");
    		    dense=Integer.parseInt(str.substring(indexOfP+1,indexOfL));
    		   
    	   }
    	   else if(Count==4)
    	   {
    		   String str=strln;
    		   Pattern p=Pattern.compile("-+");
    		   Matcher mat=p.matcher(str);
    		   String s=mat.replaceAll(" ");
    		   s.trim();
    		   int index=s.indexOf(":");
    		    delSize=Integer.parseInt(s.substring(index+1).trim());
    		    System.out.println(delSize);
    	   }
    	   else if(Count==5)
    	   {
			
    		   String str=strln;
    		   Pattern p=Pattern.compile("-+");
    		   Matcher mat=p.matcher(str);
    		   String s=mat.replaceAll(" ");
    		   s.trim();
    		   int index=s.indexOf(":");
    		    Alg=Integer.parseInt(s.substring(index+1).trim());
    		    System.out.println(Alg);
    		   
		  }
    	   //处理时间
    	   else if(Alg==10&&Count==6||Alg!=10&&Count==7
    			   )
    		   
   	     {
    	  String[] attList=strln.split(" ");
   	     if(attList.length>1)
   	    {
   	    	int j=0;
           for (int m = 1; m < attList.length; m++) 
           {	
        	 if(m==1||m==4)
        	  {
	   		    String str=attList[m];
	   		    str=str.trim();
		   		String str2="";
		   		if(str != null && !"".equals(str))
		   		{
		   		  for(int i=0;i<str.length();i++)
		   		  {
		   		    if(str.charAt(i)>=48 && str.charAt(i)<=57||str.charAt(i)=='.')
		   		    {
		   		    	str2+=str.charAt(i);
		   		    }
		   		  }	   		 
		   	   }
		   		result[j++]=Double.parseDouble(str2);
		   		System.out.println(str2);
		   	}
       
           } 
           
   	    }
      }
     }
       }
  public  void Read2(String FileName)
		    throws FileNotFoundException, IOException
		  {
			//读入数据文件
			   FileInputStream is=new FileInputStream(FileName);
		       InputStreamReader ir=new InputStreamReader(is);
		       BufferedReader in =new BufferedReader(ir);
		       String strln;
		       int Count=0;
		     
		      //读文件
		       while((strln=in.readLine())!=null)
		      {
		    	   Count++;
		    	   //解析文件名
		    	   if(Count==3)
		    	   {
		    		   String[] attList=strln.split(" ");
		    		   String str=attList[1];
		    		   int findex=str.lastIndexOf("a");
		    		   int indexOfP=str.indexOf("P");
		    		   String size="";
		    		    size=str.substring(findex+1,indexOfP);
		    		    size.trim();
		    		    sizeAttribute=Integer.parseInt(size);
		    		   int indexOfK=str.indexOf("K");	  	
		    		    sizeObject=(int) (Double.parseDouble(str.substring(indexOfP+1,indexOfK))*1000);
		    		    int indexOfL=str.indexOf("L");
		    		    dense=Integer.parseInt(str.substring(indexOfK+1,indexOfL));
		    		   
		    	   }
		    	   else if(Count==4)
		    	   {
		    		   String str=strln;
		    		   Pattern p=Pattern.compile("-+");
		    		   Matcher mat=p.matcher(str);
		    		   String s=mat.replaceAll(" ");
		    		   s.trim();
		    		   int index=s.indexOf(":");
		    		    delSize=Integer.parseInt(s.substring(index+1).trim());
		    		    System.out.println(delSize);
		    	   }
		    	   else if(Count==5)
		    	   {
					
		    		   String str=strln;
		    		   Pattern p=Pattern.compile("-+");
		    		   Matcher mat=p.matcher(str);
		    		   String s=mat.replaceAll(" ");
		    		   s.trim();
		    		   int index=s.indexOf(":");
		    		    Alg=Integer.parseInt(s.substring(index+1).trim());
		    		    System.out.println(Alg);
		    		   
				  }
		    	   //处理时间
		    	   else if(Alg==10&&Count==6||Alg!=10&&Count==7
		    			   )
		    		   
		   	     {
		    	  String[] attList=strln.split(" ");
		   	     if(attList.length>1)
		   	    {
		   	    	int j=0;
		           for (int m = 1; m < attList.length; m++) 
		           {	
		        	 if(m==1||m==4)
		        	  {
			   		    String str=attList[m];
			   		    str=str.trim();
				   		String str2="";
				   		if(str != null && !"".equals(str))
				   		{
				   		  for(int i=0;i<str.length();i++)
				   		  {
				   		    if(str.charAt(i)>=48 && str.charAt(i)<=57||str.charAt(i)=='.')
				   		    {
				   		    	str2+=str.charAt(i);
				   		    }
				   		  }	   		 
				   	   }
				   		result[j++]=Double.parseDouble(str2);
				   		System.out.println(str2);
				   	}
		       
		           } 
		           
		   	    }
		      }
		     }
		       }
 
}

