package com.succez.maven.test.exam.three;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import com.succez.maven.test.common.StaticConstant;


/**
 * 
 * <p>Copyright: Copyright (c) 2011<p>
 * <p>文件的操作<p>
 * @author sue
 * @createdate 2011-11-07
 */
public class ThreeClass {
	
	/**
	 * <p>读取文件的内容</p>
	 * @param fobj		文件的路径，eg：D:\\test.txt  
	 * @return			读取fobj的内容，存入String并返回；如果参数异常或者不存在，返回""
	 */
	public static String getFileString( File fobj){
		if( fobj.isFile()){
			int temp = 0;
			int len = StaticConstant.STRINGBUFFER_LEN;
			if( len <= 0 )
				len = 8;
			StringBuffer buf = new StringBuffer(len);
			FileInputStream in = null;
			Reader read = null;
			try {
				in = new FileInputStream(fobj);
				read = new InputStreamReader(in);  //处理16位,文件可能包含中文
				while( (temp = read.read()) != -1  ){
					buf.append((char)temp);		//StringBuffer可以直接添加char类型的内容
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if( read != null )
					    read.close();
					if( in != null)
					    in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			return buf.toString();
		}
		else
			return "";
		
	}
	
	/**
	 * <p>将服务器端的字符串格式化为js端的常量</p>
	 * @param s		服务器端的内容
	 * @return		将s格式化为js端的常量并返回；如果s为null，或者长度为0，或者为""，不作任何操作并返回""
	 */
	public final static String formatJsStr(String s){
		if( s != null && !"".equals(s) && s.length() > 0 ){
			int len = StaticConstant.STRINGBUFFER_LEN;
			if( len <= 0)
				len = 8;
			byte bt[] = null;
			try {
				//getBytes()使用平台默认字符集解码指定的byte数组，而getBytes[String charset]指定了字符集
				bt = s.getBytes("utf-8");  
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			//设置新的字节数组长度为bt[]长度2倍，可能传入的参数s，内包含”或者\
			byte newBt[] = new byte[bt.length * 2];  
			int j = 0;
			
			for( int i = 0 ; i < bt.length ; i++ , j++){
				if( bt[i] == 34 || bt[i] == 92 ){  //34表示" 92表示\，转换为js常量为：\"或\\,字节值为：92+34或92+92
					newBt[j++] = 92;
					newBt[j] = bt[i];
				}else if(bt[i] == 9){  //9表示tab，转换为js的常量为：\t，字节值为：92+116
					newBt[j++] = 92;
					newBt[j] = 116;
				}else if(bt[i] == 13 && bt[++i] == 10){  //13 、 10 表示回车换行，转换为js的常量为：\n，字节值：92、110
					newBt[j++] = 92;
					newBt[j] = 110;
				}
				else{
					newBt[j] = bt[i];
				}
			}
			try {
//				通过使用指定的字符集解码指定的 byte的子数组，构造一个新的 String，从0开始，长度为j
				s = new String(newBt , 0 , j , "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return s;
		}else {
			return "";
		}
		
	}
	
	
	/**
	 * <p>将文件转换为字节数组</p>
	 * @param fobj		文件路径
	 * @return			将文件内容转换为字节数组并返回；如果文件不存在或者读入异常，则返回null
	 */
	public static byte[] file2buf( File fobj){
		if( !fobj.exists())
			return null;
		else{
			String str = ThreeClass.getFileString(fobj);  //读取文件的内容，返回为String对象
			byte bt[] = null;
			if( str != null && !"".equals(str) && str.length() > 0)
				try {
					bt = str.getBytes("utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			return bt;
			
		}
		
	}
}
