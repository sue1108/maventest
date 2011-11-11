package com.succez.maven.test.exam.three;


import java.io.File;

import org.junit.Test;

public class ThreeClassTest {

	@Test
	public void test() {
		File file = new File("d:\\test.txt");
//		byte bt[] = 
				ThreeClass.file2buf(file); //将文件内容转换为字节数组
		
		System.out.println("初始字符串:"+ThreeClass.getFileString(file));
		System.out.println("转换后字符串:"+ThreeClass.formatJsStr(ThreeClass.getFileString(file)));
	}

}
