// Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
//
// Example:
// Given num = 16, return true. Given num = 5, return false.
//
// Follow up: Could you solve it without loops/recursion?
public class Solution {
    public boolean isPowerOfFour(int num) {
      return num > 0 && num&(num-1)==0 && num%3==1;
    }
}
