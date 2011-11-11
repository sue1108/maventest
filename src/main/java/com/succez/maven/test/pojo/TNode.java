package com.succez.maven.test.pojo;

/**
 * @author sue
 * @createdate 2011-11-9
 */
public class TNode {

	private String value ;
	
	private TNode left;
	
	private TNode right;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public TNode getLeft() {
		return left;
	}

	public void setLeft(TNode left) {
		this.left = left;
	}

	public TNode getRight() {
		return right;
	}

	public void setRight(TNode right) {
		this.right = right;
	}
	
	
	
}
