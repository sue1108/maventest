package com.succez.maven.test.exam.one;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.succez.maven.test.common.StaticConstant;
import com.succez.maven.test.pojo.AClass;

/**
 * 
 * <p>Copyright: Copyright (c) 2011<p>
 * <p>第一道题：对列表进行排序的测试类<p>
 * @author sue
 * @createdate 2011-11-11
 */
public class SortClassTest {

	@Test
	public void testSort() {
		SortClass a = SortClass.getInstance();
		SortClass b = SortClass.getInstance();
		if( a == b)
			System.out.println("1");
		
		int len = StaticConstant.LIST_LEN;
		if( len <= 0 )
			len = 5;
		List<AClass> aList = new ArrayList<AClass>(len);
		
		SortClass sc = SortClass.getInstance();
		
		aList = sc.getListValues(aList, 5);
		for (AClass aClass : aList) {
			System.out.println( aClass.getV1() + "-" + aClass.getV2());
		}
		System.out.println(" v1 - v2 ");
		aList = sc.sort(aList);
		for (AClass aClass : aList) {
			System.out.println( aClass.getV1() + "-" + aClass.getV2());
		}
	}

}
