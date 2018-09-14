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
   * ��ȡtxt�ļ�������
   * @param file ��Ҫ��ȡ���ļ�����
   * @return �����ļ�����
   */
  public Vector<Record> read(/*File file*/){
      Vector<Record> records = new Vector<Record>(); 
      try{
          InputStream in=this.getClass().getResourceAsStream("/data/data.txt");
          Reader fdata=new InputStreamReader(in);
          BufferedReader br = new BufferedReader(fdata);
       //   BufferedReader br = new BufferedReader(new FileReader(file));//����һ��BufferedReader������ȡ�ļ�
          String s = null;
          s = br.readLine();
          s = br.readLine();
          while((s = br.readLine())!=null){//ʹ��readLine������һ�ζ�һ��
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
