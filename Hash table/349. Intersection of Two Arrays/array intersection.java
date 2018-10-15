class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //use two hashset
        Set<Integer> hashset = new HashSet<Integer>();
        Set<Integer> intersection = new HashSet<Integer>();
        for(int i : nums1){
            hashset.add(i);
        }
        for(int j : nums2){
            if(hashset.contains(j)){
                intersection.add(j);
            }
        }        
        int[] result = new int[intersection.size()];
        int k = 0;
        for(int i: intersection){
            result[k++] = i;
        }
        return result;
    }
}
