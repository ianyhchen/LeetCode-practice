class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hashset = new HashSet<Integer>();
        //if the sum is already in the hashset, the cycle is appear.
        while(n != 1 && !hashset.contains(n)){
            hashset.add(n);
            int sum = 0;
            sum = digitsquareSum(n);
            n = sum;           
        }
        return n == 1;
        
    }
    private int digitsquareSum(int n){
        int sum = 0;
        while(n != 0){
            sum += (n%10) * (n%10);
            n /= 10;
        }
        return sum;
    }
}
