package com.succez.maven.test.exam.four;


import org.junit.Test;

import com.succez.maven.test.pojo.TNode;

public class NodeClassTest {

	@Test
	public void testSetTreeValue() {
//		fail("Not yet implemented");
	}

	@Test
	public void testTreeLevel() {
		TNode node = NodeClass.setTreeValue();
		if( node != null)
		System.out.println(NodeClass.treeLevel(node,1));
	}

}
