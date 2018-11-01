class Solution {
    public int mySqrt(int x) {
        if(x <= 1){
            return x;
        }
        int left = 1, right = x / 2, ans = 0;
        while(left <= right){
            int middle = left + (right - left) / 2;
            //Prevent middle*middle <= x overflow
            if(middle <= x / middle){                
                left = middle + 1;
                ans = middle;
            }
            else{
                right = middle - 1;
            }
        }
        return ans;
    }
}
