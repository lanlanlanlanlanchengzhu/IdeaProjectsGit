package test.leetcode.no191;

import leetcode.no191.Solution;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 27, 2019</pre> 
* @version 1.0 
*/ 
public class SolutionTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: hammingWeight(int n) 
* 
*/ 
@Test
public void testHammingWeight() throws Exception {
    Solution solution = new Solution();
    System.out.println(solution.hammingWeight(8));
    System.out.println(solution.hammingWeightV1(8));
    System.out.println(solution.hammingWeightV2(8));
}


} 
