package test.leetcode.no371;

import leetcode.no371.Solution;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 25, 2019</pre> 
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
* Method: getSum(int a, int b) 
* 
*/ 
@Test
public void testGetSum() throws Exception {

    Solution solution = new Solution();
    System.out.println(solution.getSum(1, 2));

}


@Test
public void testGetSumV1() throws Exception {

    Solution solution = new Solution();
    System.out.println(solution.getSumV1(-1, -2));

}


} 
