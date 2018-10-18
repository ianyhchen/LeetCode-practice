class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //HashMap solution (slow)
        /*Map<Integer,Integer> map = new HashMap<>();
        int len = numbers.length;
        int[] result = new int[2];
        //int j = 0;
        for(int i = 0; i < len; i++){
            if(map.containsKey(target-numbers[i])){
                result[0] = map.get(target - numbers[i])+1;
                result[1] = i+1;
            }
            map.put(numbers[i],i);
        }
        return result;*/
        
        //Two pointer solution
        int len = numbers.length;
        int[] result = new int[2];
        int l = 0, r = len - 1;
        while(l < r){
            if(target == (numbers[l] + numbers[r])){
                result[0] = l + 1;
                result[1] = r + 1;
                return result;
            }
            else if(target < ( numbers[l] + numbers[r])){
                r--;
            }
            else{
                l++;
            }   
            
        }
        return null;
    }
}
