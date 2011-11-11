package com.succez.maven.test.exam.four;

import com.succez.maven.test.common.StaticConstant;
import com.succez.maven.test.pojo.TNode;


/**
 * 
 * <p>Copyright: Copyright (c) 2011<p>
 * <p>二叉树的设置、遍历<p>
 * @author sue
 * @createdate 2011-11-07
 */
public class NodeClass {
	
	/**
	 * 默认值
	 */
	private static String treeValues[] = {"A" , 
		"B" ,
		"D" ,
		"G" , "H" , "C" , "F" ,
		"H1" , "C1" , "F1" , "H" , "C" , "F" , "H1" , "C1" , 
		"F1" ,"G" , "H" , "C" , "F" ,
		"#"}; 
	
	private static int index =0;

	public NodeClass(String treeValues[]){
		index = 0;
		NodeClass.treeValues = treeValues;
	}
	
	/**
	 * <p>递归为二叉树赋值</p>
	 * @return	返回二叉树
	 */
	public static TNode setTreeValue( ){
		TNode tree = new TNode();
		if( treeValues!= null && treeValues.length > 0 && index >= 0){
			if( index > treeValues.length-1 || treeValues[index].equals("#")) 
				return tree;
			else{
				
				tree.setValue(treeValues[index]);
				index = index * 2 +1; //left
				tree.setLeft(setTreeValue());
				index ++;
				tree.setRight(setTreeValue());  //right
				index = index/2 - 1;
				return tree;
			}
			
		}else
			return null;
		
	}

	/**
	 * <p>按层遍历，遍历第n层的数，放入一个数组中</p>
	 * @param tree		
	 * @param n			遍历第n层的数
	 * @return			返回遍历第n层的数，顺序为从左到右<br/>如果n<=0或者tree为null，不作任何操作，并返回相应错误提示
	 */
	public static String treeLevel( TNode tree , int n){
		String str = null;
		if(n>0 && tree != null && tree.getValue() != null ){
			int endLen = (int)Math.pow(2, n)-1;   //到第N层止的总共节点数
			int startLen = (int)Math.pow(2, n-1)-1;  //到第N-1层止的总共节点数
			int treeLen = treeValues.length -1 ;//二叉树的总共节点数
			if( startLen <= treeLen ){
				//如果第N-1层止的节点数大于二叉树的整个节点数，则说明没有第N层
					TNode nodeArr[] = new TNode[treeLen*2];
					nodeArr[0] = tree;
					int i = 0;  //
					int j = 1;  //
					int tmp =0;
					if( treeLen >  endLen)  //说需要返回的不是最后一层的节点
						tmp = endLen;
					else    //说明需要返回的是最后一层的节点
						tmp = treeLen ;
					TNode tmpNode ;
					int t = 0;
					while( j <=  tmp){ //按层次遍历二叉树
						
						//如果t=0，取左子节点，t=1，取右子节点
						while(t<2){
							tmpNode = (t==0) ? nodeArr[i].getLeft() : nodeArr[i].getRight();
							if( tmpNode != null && tmpNode.getValue() != null){
								nodeArr[j++] = tmpNode;  
							}else{
								j++;
							}
							t++;
						}
						i++;
						t = 0;
					}
					
					int len = StaticConstant.STRINGBUFFER_LEN;
					if( len <= 0 )
						len = 8;
					StringBuffer sbf = new StringBuffer(len);
					for( int m = startLen ; m < tmp  ; m++ )
					{
						sbf.append(nodeArr[m].getValue() + "-");
					}
					str = sbf.substring(0, sbf.length()-1).toString();
			}else{
				str = "没有第N层";
			}
		}else{
			str = "TNode不能为null并且N应该为正整数";
		}
		return str;
	}
}
