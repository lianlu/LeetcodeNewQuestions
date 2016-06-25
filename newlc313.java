// Write a program to find the nth super ugly number.
//
// Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
// For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers
// given primes = [2, 7, 13, 19] of size 4.
//
// Note:
// (1) 1 is a super ugly number for any given primes.
// (2) The given numbers in primes are in ascending order.
// (3) 0 < k ��?100, 0 < n ��?106, 0 < primes[i] < 1000.
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
      if (n == 1) return 1;
      int []index = new int[primes.length];
      int count = 1;
      List<Integer> res = new ArrayList<>();
      res.add(1);
      for (int k = 0; k < n; k++){
        cur = res.get(k);
        int minVal = Integer.MAX_VALUE;
        for (int j = 0; j < primes.length; j++){
          if (minVal > res[index[j]] * primes[j]) minVal = res[index[j]] * primes[j];
        }
        for (int j = 0; j < primes.length; j++){
          if (minVal == res[index[j]] * primes[j]) index[j]++;
        }
        res.add(minVal);
      }
      return res.get(n-1);
    }
}
