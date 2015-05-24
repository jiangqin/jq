 import java.io.File; 
import java.util.Date; 
import jxl.*; 
import jxl.write.*;
import jxl.write.Number;
public class converM {

	/**
	 *JQ
	 *2015-1-23
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws WriteException 
	 */
	public static void main(String[] args) throws  Exception{
		// TODO Auto-generated method stub
		  //处理randData1 Log文件
		 //gaiguo
		  File file=new File("shiyan\\randData5");
		  String text[];
		  text=file.list();
		  System.out.println(text[0]);	 
	      String fileName0=text[0];	      
		  Readtext txtReadtext0=new Readtext();
		//gaiguo
		  String str0="randData5\\"+fileName0;
		  //读取文件str0
		  txtReadtext0.Read(str0);
		//gaiguo
		  String filexls0="D:\\project\\experimentData5\\"+txtReadtext0.delSize+txtReadtext0.sizeObject+"P"+".xls";
		  WritableWorkbook workbook = Workbook.createWorkbook(new File(filexls0));	
		  WritableSheet sheet= workbook.createSheet("First Sheet", 0);
		  //gaiguo
		  int r=3;//最开始的文件中 对每个固定的对象个数 建立一个.xls文件
		  int m=0;
		  for(int i=0;i<text.length;i++)
		  {
		      System.out.println(text[i]);	 
		      String fileName=text[i];	      
			  Readtext txtReadtext=new Readtext();
			  String str4="randData5\\"+fileName;
			  txtReadtext.Read(str4);	
//			  String string=txtReadtext.sizeObject+","+txtReadtext.sizeAttribute+","+txtReadtext.dense;
//			  System.out.println(string);
			  //代表属性从100到400
			//gaiguo
			  m=txtReadtext.delSize/10;
			  if(txtReadtext.delSize/10!=r)
			  {
				 workbook.write(); 
				 workbook.close();
				//gaiguo
				 String  filex1snew="D:\\project\\experimentData5\\"+txtReadtext.delSize+txtReadtext.sizeObject+"P"+".xls";
//				 File file21=new File(filex1snew);
//				 if(!file2.exists())				 
				  WritableWorkbook workbooknew = Workbook.createWorkbook(new File(filex1snew));				 
				  workbook=workbooknew;
				  sheet= workbooknew.createSheet("First Sheet", 0);
				 
				 r=r+1;
			  }		    
				  int index=0;
				  if(txtReadtext.Alg==15)
				  {
					  // 第0+1列存放，第sizeAttribute/10-1+1行存放花费的时间
					  Number number,number1;
					  if(txtReadtext.sizeAttribute<2000)
					  {
					    number = new Number(0, (txtReadtext.sizeAttribute-1000)/100,txtReadtext.result[0]);
					    sheet.addCell(number);				  
					  //第2列，第sizeAttribute/10-1+1行存放产生节点的个数
					   number1 = new Number(1,(txtReadtext.sizeAttribute-1000)/100,txtReadtext.result[1]);
					    sheet.addCell(number1);	
					  }	
					  else
					  {
						  number = new Number(0, (txtReadtext.sizeAttribute-2000)/100+10,txtReadtext.result[0]);
						    sheet.addCell(number);				  
						  //第2列，第sizeAttribute/10-1+1行存放产生节点的个数
						   number1 = new Number(1,(txtReadtext.sizeAttribute-2000)/100+10,txtReadtext.result[1]);
						    sheet.addCell(number1);
					  }
				  }
				  else if (txtReadtext.Alg==16) 
				  {
					  // 第0+1列存放，第sizeAttribute/10-1+1行存放花费的时间
					  Number number,number1;
					  if(txtReadtext.sizeAttribute<2000)
					  {
					    number = new Number(2, (txtReadtext.sizeAttribute-1000)/100,txtReadtext.result[0]);
					    sheet.addCell(number);				  
					  //第2列，第sizeAttribute/10-1+1行存放产生节点的个数
					   number1 = new Number(3,(txtReadtext.sizeAttribute-1000)/100,txtReadtext.result[1]);
					    sheet.addCell(number1);	
					  }	
					  else
					  {
						  number = new Number(2, (txtReadtext.sizeAttribute-2000)/100+10,txtReadtext.result[0]);
						    sheet.addCell(number);				  
						  //第2列，第sizeAttribute/10-1+1行存放产生节点的个数
						   number1 = new Number(3,(txtReadtext.sizeAttribute-2000)/100+10,txtReadtext.result[1]);
						    sheet.addCell(number1);
					  }
					
					  //存放花费的时间	
				  }
				  else if(txtReadtext.Alg==12)
				  {
					  Number number,number1;
					  if(txtReadtext.sizeAttribute<2000)
					  {
					    number = new Number(4, (txtReadtext.sizeAttribute-1000)/100,txtReadtext.result[0]);
					    sheet.addCell(number);				  
					  //第2列，第sizeAttribute/10-1+1行存放产生节点的个数
					   number1 = new Number(5,(txtReadtext.sizeAttribute-1000)/100,txtReadtext.result[1]);
					    sheet.addCell(number1);	
					  }	
					  else
					  {
						  number = new Number(4, (txtReadtext.sizeAttribute-2000)/100+10,txtReadtext.result[0]);
						    sheet.addCell(number);				  
						  //第2列，第sizeAttribute/10-1+1行存放产生节点的个数
						   number1 = new Number(5,(txtReadtext.sizeAttribute-2000)/100+10,txtReadtext.result[1]);
						    sheet.addCell(number1);
					  }
				  }
			  }	
		  if(m==r)
		  {
			  workbook.write(); 
			  workbook.close(); 
		  }	

	}

}
