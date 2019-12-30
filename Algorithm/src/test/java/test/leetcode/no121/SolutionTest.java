package test.leetcode.no121;

import leetcode.no121.Solution;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 23, 2019</pre> 
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
* Method: maxProfit(int[] prices) 
* 
*/ 
@Test
public void testMaxProfit() throws Exception {
    Solution solution = new Solution();
    int[] prices = new int[]{7,6,4,3,1};
    System.out.println(solution.maxProfit(prices));
}


@Test
public void testMaxProfitV1() throws Exception {
    Solution solution = new Solution();
    int[] prices = new int[]{7,1,5,3,6,4};
    System.out.println(solution.maxProfitV1(prices));
}

} 
