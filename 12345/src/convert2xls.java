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
	  //����randData1 Log�ļ�
	  File file=new File("shiyan");
	  String text[];
	  text=file.list();
	  System.out.println(text[0]);	 
      String fileName0=text[0];	      
	  Readtext txtReadtext0=new Readtext();
	  String str0="shiyan\\"+fileName0;
	  //��ȡ�ļ�str0
	  txtReadtext0.Read(str0);
	  String filexls0="E:\\experimentData\\"+txtReadtext0.sizeObject+"P"+txtReadtext0.dense+".xls";
	  WritableWorkbook workbook = Workbook.createWorkbook(new File(filexls0));	
	  WritableSheet sheet= workbook.createSheet("First Sheet", 0);
	  int r=3;//�ʼ���ļ��� ��ÿ���̶��Ķ������ ����һ��.xls�ļ�
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
		  //�������Դ�100��400
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
				  // ��0+1�д�ţ���sizeAttribute/10-1+1�д�Ż��ѵ�ʱ��
				  Number number = new Number(0, txtReadtext.sizeAttribute/10-1,txtReadtext.result[0]);
				  sheet.addCell(number);				  
				  //��2�У���sizeAttribute/10-1+1�д�Ų����ڵ�ĸ���
				  Number number1 = new Number(1,txtReadtext.sizeAttribute/10-1,txtReadtext.result[1]);
				  sheet.addCell(number1);				  				  
			  }
			  else if (txtReadtext.Alg==15) 
			  {
				
				  //��Ż��ѵ�ʱ��
				  Number number = new Number(2, txtReadtext.sizeAttribute/10-1,txtReadtext.result[0]);
				  sheet.addCell(number);				  
				  //��Ų����ڵ�ĸ���
				  Number number1 = new Number(3,txtReadtext.sizeAttribute/10-1,txtReadtext.result[1]);
				  sheet.addCell(number1);	
			  }
			  else if(txtReadtext.Alg==16)
			  {
				  //��Ż��ѵ�ʱ��
				  Number number = new Number(4, txtReadtext.sizeAttribute/10-1,txtReadtext.result[0]);
				  sheet.addCell(number);				  
				  //��Ų����ڵ�ĸ���
				  Number number1 = new Number(5,txtReadtext.sizeAttribute/10-1,txtReadtext.result[1]);
				  sheet.addCell(number1);	
			  }
			/*  else if(txtReadtext.Alg==16)
			  {
				  //��Ż��ѵ�ʱ��
				  Number number = new Number(6, txtReadtext.sizeAttribute/10-1,txtReadtext.result[0]);
				  sheet.addCell(number);				  
				  //��Ų����ڵ�ĸ���
				  Number number1 = new Number(7,txtReadtext.sizeAttribute/10-1,txtReadtext.result[1]);
				  sheet.addCell(number1);	
			  }
			  else if(txtReadtext.Alg==10)
			  {
				  //��Ż��ѵ�ʱ��
				  Number number = new Number(8, txtReadtext.sizeAttribute/10-1,txtReadtext.result[0]);
				  sheet.addCell(number);				  
				  //��Ų����ڵ�ĸ���
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

