class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int len_a = a.length(), len_b = b.length();
        int carry = 0;
        int i = len_a-1, j = len_b-1; //traverse from last digit
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0){
                sum += a.charAt(i--) - '0';
            }
            if(j >= 0){
                sum += b.charAt(j--) - '0';
            }
            carry = sum / 2;
            res.insert(0, String.valueOf(sum % 2));
        }
        if(carry > 0){
            res.insert(0, String.valueOf(carry % 2));
        }
        return res.toString();
    }   
}
