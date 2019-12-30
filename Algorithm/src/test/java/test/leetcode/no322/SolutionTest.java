package test.leetcode.no322;

import leetcode.no322.Solution;
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
* Method: coinChange(int[] coins, int amount) 
* 
*/ 
@Test
public void testCoinChange() throws Exception {
    Solution solution = new Solution();
    System.out.println(solution.coinChange(new int[]{2}, 3));
}


/** 
* 
* Method: coinChangeInternal(int[] coins, int remain, int[]cache) 
* 
*/ 
@Test
public void testCoinChangeInternal() throws Exception { 
//TODO: Test goes here...
/*
try { 
   Method method = Solution.getClass().getMethod("coinChangeInternal", int[].class, int.class, int[]cache.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
