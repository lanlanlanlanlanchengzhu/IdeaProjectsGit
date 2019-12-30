package test.leetcode.no338;

import leetcode.no338.Solution;
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
* Method: countBits(int num) 
* 
*/ 
@Test
public void testCountBits() throws Exception {
    Solution solution = new Solution();
    int[] res = solution.countBitsDP(8);
    for (int oneRes : res) {
        System.out.println(oneRes);
    }
}


} 
