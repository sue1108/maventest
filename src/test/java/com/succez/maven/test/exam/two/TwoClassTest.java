package com.succez.maven.test.exam.two;


import org.junit.Test;

/**
 * 
 * <p>Copyright: Copyright (c) 2011<p>
 * <p>第二道题：将正整数转换为十六进制的测试类<p>
 * @author sue
 * @createdate 2011-11-11
 */
public class TwoClassTest {

	@Test
	public void test() {
		TwoClass tc = TwoClass.getInstance();
		String str = tc.intToHex(1008);
		System.out.println(str);
	}

}
