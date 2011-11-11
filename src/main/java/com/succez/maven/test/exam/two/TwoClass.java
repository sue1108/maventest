package com.succez.maven.test.exam.two;

import com.succez.maven.test.common.StaticConstant;


/**
 * 
 * <p>Copyright: Copyright (c) 2011<p>
 * <p>succez<p>
 * @author sue
 * @createdate 2011-11-07
 */
public class TwoClass {
	
	private static TwoClass instance = new TwoClass();
	
	public static TwoClass getInstance(){
		if( null != instance ){
			return instance;
		}else
			return new TwoClass();
	}
	
	/**
	 * <p>将正整数转换成16进制的串</p>
	 * @param intNum	正整数
	 * @return			如果intNum为正整数，返回对应的16进制数；如果小于0，则返回参数错误提示信息	
	 */
	public String intToHex( int intNum){
		if ( intNum < 0){  //如果为负数，则提示错误
			return "参数有误，应该为正整数！";
			
		}else{
			int len = StaticConstant.STRINGBUFFER_LEN;
			if( len <= 0 )
				len = 8;
			StringBuffer sbf = new StringBuffer(len);
			int tmp = 0;
			if( intNum > 10){
				while ( intNum/16 > 0  || intNum > 0){  
					tmp = intNum%16;
					if( tmp > 10)  //如果大于10，则需要转码为对象的A-F
//						将10-15的十进制转换为A-F，A的ASCII为65
						sbf.append( (char)(tmp+55) );    
					else
						sbf.append(tmp);
					intNum = intNum/16;
				}
			}else{
				sbf.append(intNum);
			}
			return sbf.reverse().toString();
		}
	}
	
}
