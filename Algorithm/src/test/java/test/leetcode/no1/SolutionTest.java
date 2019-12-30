package test.leetcode.no1;

import leetcode.no1.Solution;
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
* Method: twoSum(int[] nums, int target)
*
*/
@Test
public void testTwoSum() throws Exception {

    Solution solution = new Solution();
    int nums[] = {2, 7, 11, 15};
    int target = 9;
    int[] res = solution.twoSum(nums, target);
    for (int one : res) {
        System.out.println(one);
    }

}

@Test
public void testTwoSumV1() throws Exception {
    Solution solution = new Solution();
    int nums[] = {2, 7, 11, 15};
    int target = 9;
    int[] res = solution.twoSumV1(nums, target);
    for (int one : res) {
        System.out.println(one);
    }
}

    @Test
public void testTwoSumV2() throws Exception {
    Solution solution = new Solution();
    int nums[] = {2, 7, 11, 15};
    int target = 9;
    int[] res = solution.twoSumV2(nums, target);
    for (int one : res) {
        System.out.println(one);
    }
}

} 
