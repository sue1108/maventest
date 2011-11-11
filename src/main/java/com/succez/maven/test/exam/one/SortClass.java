package com.succez.maven.test.exam.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.succez.maven.test.common.StaticConstant;
import com.succez.maven.test.pojo.AClass;


/**
 * <p>Copyright: Copyright (c) 2011<p>
 * <p>succez<p>
 * @author sue
 * @createdate 2011-11-07
 */
public class SortClass {
	
	private static SortClass instance = new SortClass();
	
	public static SortClass getInstance(){
		if( null != instance ){
			return instance;
		}else
			return new SortClass();
	}
	/**
	 * <p>为List的对象赋值</p>
	 * @param aList		允许为null，当为null时，初始化aList
	 * @param n			aList的长度，正整数
	 * @return			返回值为List<AClass>对象，如果n<0，不作任何处理，直接返回sList;n>=0,对aList赋值并返回
	 */
	public List<AClass> getListValues(List<AClass> aList , int n){
		if( null == aList ){   //对aList进行null判断，如果为空，则需要new对象，不为空，则不作操作
			int len = StaticConstant.LIST_LEN;
			if( len <= 0 )
				len = 5;
			aList = new ArrayList<AClass>(len);
		}
		
		if ( n > 0 ){   //如果传入的n值不是正整数，不作任何操作
			
			int v1 = 0;
			int v2 = 0;
			for( int i = 0 ; i < n ; i++){
				AClass aClass = new AClass();
				v1 = (int) (Math.random()*100);
				v2 = (int) (Math.random()*100);
				aClass.setV1(v1);
				aClass.setV2(v2);
				aList.add(aClass);
			}
		}
		
		return aList;
	}
	
	
	/**
	 * <p>使用冒泡排序法对指定列表进行排序</p>
	 * <p>排序条件：1、按AClass的属性V1降序排列；2、如果V1相等，则按AClass的属性V2升序排列</p>
	 * @param aList		不允许为null
	 * @return			如果aList为null，则初始化aList，不作任何操作并返回aList
	 */
	public List<AClass> sort(List<AClass> aList ){
		if(  null != aList ){
			int lenList = aList.size();
			AClass aTempI ;//不必创建对象
			AClass aTempJ ;
//			AClass aTemp ; 
			for( int i = 0 ; i < lenList ; i++){
				for( int j = i + 1 ; j < lenList ; j++){//多次使用的应该定义一个变量
					aTempI = aList.get(i);
					aTempJ = aList.get(j);
					
					if( aTempI.getV1() < aTempJ.getV1()  //如果i的v1小于j的v1，则替换（降序排列）
							//如果i的v1等于j的v1，则根据v2的升序排列
							|| ( aTempI.getV1() == aTempJ.getV1() && aTempI.getV2() > aTempJ.getV2() ) 
						){
						Collections.swap(aList, i, j);
						/*aTemp = aTempI;
						aList.set(i, aTempJ);
						aList.set(j, aTemp);*/
					}
				}
			}
		}else{
			int len = StaticConstant.LIST_LEN;
			if( len <= 0 )
				len = 5;
			aList = new ArrayList<AClass>(len);
		}
		
		return aList;
	}
	

}
