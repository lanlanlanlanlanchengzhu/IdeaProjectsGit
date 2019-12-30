package test.leetcode.no70;

import leetcode.no70.Solution;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 28, 2019</pre> 
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
* Method: climbStairs(int n) 
* 
*/ 
@Test
public void testClimbStairs() throws Exception { 
    Solution solution = new Solution();
    System.out.println(solution.climbStairsV2(3));
} 


} 
