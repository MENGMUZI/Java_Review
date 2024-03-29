package swordoffer;

/**
 * @author : mengmuzi
 * create at:  2019-08-05  09:16
 * @description: 数组中重复的数字
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class DuplicateNumber {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!set.add(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;

    }


    public boolean duplicate02(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length < 2) {
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != i) {
                int val = numbers[numbers[i]];
                if (val == numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }


    public int duplicateInArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int start = 1;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int count = getCount(nums, start, mid);
            if (start == end) {
                if (count > 1) {
                    return start;
                }
            } else if (count < mid - start + 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private int getCount(int[] nums, int start, int mid) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (start <= nums[i] && nums[i] <= mid) {
                count++;
            }
        }
        return count;
    }


}
