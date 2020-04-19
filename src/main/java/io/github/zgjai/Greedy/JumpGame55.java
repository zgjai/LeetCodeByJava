package io.github.zgjai.Greedy;

/**
 * Created by zhangguijiang on 2017/10/20.
 */

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * For example: A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame55 {

    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int maxIndex = nums[0];
        for (int i = 0; i < nums.length && i <= maxIndex; i++) {
            int tmpIndex = i + nums[i];
            if (tmpIndex >= maxIndex) {
                maxIndex = tmpIndex;
                if (maxIndex >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
