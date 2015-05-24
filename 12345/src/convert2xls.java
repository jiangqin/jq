 import java.io.File; 
import java.util.Date; 
import jxl.*; 
import jxl.write.*;
import jxl.write.Number;
public class convert2xls {
  public convert2xls()
  {}
  public static void main(String [] args) throws Exception
  {
	  //处理randData1 Log文件
	  File file=new File("shiyan");
	  String text[];
	  text=file.list();
	  System.out.println(text[0]);	 
      String fileName0=text[0];	      
	  Readtext txtReadtext0=new Readtext();
	  String str0="shiyan\\"+fileName0;
	  //读取文件str0
	  txtReadtext0.Read(str0);
	  String filexls0="E:\\experimentData\\"+txtReadtext0.sizeObject+"P"+txtReadtext0.dense+".xls";
	  WritableWorkbook workbook = Workbook.createWorkbook(new File(filexls0));	
	  WritableSheet sheet= workbook.createSheet("First Sheet", 0);
	  int r=3;//最开始的文件中 对每个固定的对象个数 建立一个.xls文件
	  int m=0;
	  for(int i=0;i<text.length;i++)
	  {
	      System.out.println(text[i]);	 
	      String fileName=text[i];	      
		  Readtext txtReadtext=new Readtext();
		  String str4="shiyan\\"+fileName;
		  txtReadtext.Read(str4);	
//		  String string=txtReadtext.sizeObject+","+txtReadtext.sizeAttribute+","+txtReadtext.dense;
//		  System.out.println(string);
		  //代表属性从100到400
		  m=txtReadtext.sizeObject/100;
//		  if(txtReadtext.sizeObject/100!=r)
//		  {
//			 workbook.write(); 
//			 workbook.close();
//			 String  filex1snew="E:\\experimentData\\"+txtReadtext.sizeObject+"P"+txtReadtext.dense+".xls";
//			 WritableWorkbook workbooknew = Workbook.createWorkbook(new File(filex1snew));				 
//			 workbook=workbooknew;
//			 sheet= workbooknew.createSheet("First Sheet", 0); 
//			 r=r+1;
//		  }		    
			  int index=0;
			  if(txtReadtext.Alg==12)
			  {
				  // 第0+1列存放，第sizeAttribute/10-1+1行存放花费的时间
				  Number number = new Number(0, txtReadtext.sizeAttribute/10-1,txtReadtext.result[0]);
				  sheet.addCell(number);				  
				  //第2列，第sizeAttribute/10-1+1行存放产生节点的个数
				  Number number1 = new Number(1,txtReadtext.sizeAttribute/10-1,txtReadtext.result[1]);
				  sheet.addCell(number1);				  				  
			  }
			  else if (txtReadtext.Alg==15) 
			  {
				
				  //存放花费的时间
				  Number number = new Number(2, txtReadtext.sizeAttribute/10-1,txtReadtext.result[0]);
				  sheet.addCell(number);				  
				  //存放产生节点的个数
				  Number number1 = new Number(3,txtReadtext.sizeAttribute/10-1,txtReadtext.result[1]);
				  sheet.addCell(number1);	
			  }
			  else if(txtReadtext.Alg==16)
			  {
				  //存放花费的时间
				  Number number = new Number(4, txtReadtext.sizeAttribute/10-1,txtReadtext.result[0]);
				  sheet.addCell(number);				  
				  //存放产生节点的个数
				  Number number1 = new Number(5,txtReadtext.sizeAttribute/10-1,txtReadtext.result[1]);
				  sheet.addCell(number1);	
			  }
			/*  else if(txtReadtext.Alg==16)
			  {
				  //存放花费的时间
				  Number number = new Number(6, txtReadtext.sizeAttribute/10-1,txtReadtext.result[0]);
				  sheet.addCell(number);				  
				  //存放产生节点的个数
				  Number number1 = new Number(7,txtReadtext.sizeAttribute/10-1,txtReadtext.result[1]);
				  sheet.addCell(number1);	
			  }
			  else if(txtReadtext.Alg==10)
			  {
				  //存放花费的时间
				  Number number = new Number(8, txtReadtext.sizeAttribute/10-1,txtReadtext.result[0]);
				  sheet.addCell(number);				  
				  //存放产生节点的个数
				  Number number1 = new Number(9,txtReadtext.sizeAttribute/10-1,txtReadtext.result[1]);
				  sheet.addCell(number1);	
			  }*/
		  }	
//	  if(r==m)
	  {
		  workbook.write(); 
		  workbook.close(); 
	  }			  
    }	 
  }

