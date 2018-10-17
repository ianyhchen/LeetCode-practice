class Solution {
    public void rotate(int[] nums, int k) {
        //Brute force solution*
        /*int len = nums.length;
        while(k > 0){
            int last = nums[len-1];
            for(int i = len-1; i > 0; i--){
                int left = nums[i-1];
                nums[i] = left;
            }
            nums[0] = last;
            k--;
        }*/
        //
        /*for(int i:nums){
            System.out.println(i);
        }*/
        
        //Extra array solution**
        /*int len = nums.length;
        int[] extra = new int[len];
        for(int i = 0; i < len; i++){
            extra[(i+k)%len] = nums[i];
        }
        for(int j = 0; j < len; j++){
            nums[j] = extra[j];
        }*/
        //Cyclic Replacement***
            //replace the element in correct place directly.
        int count = 0;
        int len = nums.length;
        k = k % len; // if k > length, k the same as k % length.
        for(int start = 0; count < len; start++){
            int current = start;
            int prev = nums[start];
            do{
                int nextIndex = (current+k) % len;
                int temp = nums[nextIndex];
                nums[nextIndex] = prev;
                prev = temp;
                current = nextIndex;    
                count++;                
            } while(start != current);  //the current index will form a cycle and trace back to the start index
        }
    }
}
