class Solution {
    public int binaryGap(int N) {
        //return the longest distance between two consecutive 1's in the binary representation
        //1001 distance => index:3 - index:0 = 3
        String binary = Integer.toBinaryString(N);
        //System.out.print(binary);
        int right = 0, left = 0, max = 0;
        int len = binary.length();       
        while(right < len){
            while(right < len && binary.charAt(right) == '0'){
                right++;
            }
            if(binary.charAt(left) == '0'){
                left = right;
            }
            if(right < len){
                max = Math.max(max, right - left);
                left = right;
                right++;
            }
        }
        return max;
    }
}
