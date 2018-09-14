package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Vector;

public class ReadData {
  /**
   * 读取txt文件的内容
   * @param file 想要读取的文件对象
   * @return 返回文件内容
   */
  public Vector<Record> read(/*File file*/){
      Vector<Record> records = new Vector<Record>(); 
      try{
          InputStream in=this.getClass().getResourceAsStream("/data/data.txt");
          Reader fdata=new InputStreamReader(in);
          BufferedReader br = new BufferedReader(fdata);
       //   BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
          String s = null;
          s = br.readLine();
          s = br.readLine();
          while((s = br.readLine())!=null){//使用readLine方法，一次读一行
              Record v = new Record();
              String[] a=s.split(",",-1);
              v.setAll(a);
              records.add(v);
          }
          br.close();    
      }catch(Exception e){
          e.printStackTrace();
      }
      return records;
  }
}
