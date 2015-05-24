import java.io.File;

import jxl.Workbook;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class covert2xls2 {
	  public covert2xls2()
	  {}
	  public static void main(String [] args) throws Exception
	  {
		  //处理randData2数据集
		  File file=new File("RandDataL2");
		  String text[];
		  text=file.list();
		  System.out.println(text[0]);	 
	      String fileName0=text[0];	      
		  Readtext txtReadtext0=new Readtext();
		  String str0="RandDataL2\\"+fileName0;
		  //读取文件str0
		  txtReadtext0.Read2(str0);
		  String filexls0="E:\\experimentData2\\"+txtReadtext0.sizeAttribute+"P"+txtReadtext0.dense+".xls";
		  WritableWorkbook workbook = Workbook.createWorkbook(new File(filexls0));	
		  WritableSheet sheet= workbook.createSheet("First Sheet", 0);
//		  int r=1;//从哪个数据点开始 对固定属性建立一个。xls文件
//		  int m=0;
		  for(int i=0;i<text.length;i++)
		  {
		      System.out.println(text[i]);	 
		      String fileName=text[i];	      
			  Readtext txtReadtext=new Readtext();
			  String str4="RandDataL2\\"+fileName;
			  txtReadtext.Read2(str4);	
//			  String string=txtReadtext.sizeObject+","+txtReadtext.sizeAttribute+","+txtReadtext.dense;
//			  System.out.println(string);
			  //代表属性从20开始
//			  m=txtReadtext.sizeAttribute/10;
//			  if(txtReadtext.sizeAttribute/10!=r)
//			  {
//				 workbook.write(); 
//				 workbook.close();
//				 String  filex1snew="D:\\project\\randData2\\"+txtReadtext.sizeAttribute+"P"+txtReadtext.dense+".xls";
//				 WritableWorkbook workbooknew = Workbook.createWorkbook(new File(filex1snew));				 
//				 workbook=workbooknew;
//				 sheet= workbooknew.createSheet("First Sheet", 0); 
//				 r=r+1;
//			  }		   
				  int index=0;
				  if(txtReadtext.Alg==15)
				  {
					  //存放花费的时间
					  Number number = new Number(0, txtReadtext.sizeObject/100-2,txtReadtext.result[0]);
					  sheet.addCell(number);				  
					  //存放产生节点的个数
					  Number number1 = new Number(1,txtReadtext.sizeObject/100-2,txtReadtext.result[1]);
					  sheet.addCell(number1);				  				  
				  }
				  else if (txtReadtext.Alg==16) 
				  {
					
					  //存放花费的时间
					  Number number = new Number(2, txtReadtext.sizeObject/100-2,txtReadtext.result[0]);
					  sheet.addCell(number);				  
					  //存放产生节点的个数
					  Number number1 = new Number(3,txtReadtext.sizeObject/100-2,txtReadtext.result[1]);
					  sheet.addCell(number1);	
				  }
//				  else if(txtReadtext.Alg==15)
//				  {
//					  //存放花费的时间
//					  Number number = new Number(4, txtReadtext.sizeObject/100-2,txtReadtext.result[0]);
//					  sheet.addCell(number);				  
//					  //存放产生节点的个数
//					  Number number1 = new Number(5,txtReadtext.sizeObject/100-2,txtReadtext.result[1]);
//					  sheet.addCell(number1);	
//				  }
//				  else if(txtReadtext.Alg==16)
//				  {
//					  //存放花费的时间
//					  Number number = new Number(6, txtReadtext.sizeObject/100-2,txtReadtext.result[0]);
//					  sheet.addCell(number);				  
//					  //存放产生节点的个数
//					  Number number1 = new Number(7,txtReadtext.sizeObject/100-2,txtReadtext.result[1]);
//					  sheet.addCell(number1);	
//				  }
//				  else if(txtReadtext.Alg==10)
//				  {
//					  //存放花费的时间
//					  Number number = new Number(8, txtReadtext.sizeObject/100-2,txtReadtext.result[0]);
//					  sheet.addCell(number);				  
//					  //存放产生节点的个数
//					  Number number1 = new Number(9,txtReadtext.sizeObject/100-2,txtReadtext.result[1]);
//					  sheet.addCell(number1);	
//				  }
		 }	
//		  if(r==m)
		  {
			  workbook.write(); 
			  workbook.close(); 
		  }			  
	    }	 

}
