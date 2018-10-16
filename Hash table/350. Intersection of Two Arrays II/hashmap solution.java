class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> hashmap = new HashMap<Integer, Integer>(); //(key,value) = (element,the number of element)  
        List<Integer> intersection = new ArrayList<Integer>();  //store the intersection elements
        for(int i : nums1){            
            hashmap.put(i, hashmap.getOrDefault(i,0)+1);                    
        }        
        for(int j: nums2){
            if(hashmap.containsKey(j)){                
                intersection.add(j);
                hashmap.put(j, hashmap.getOrDefault(j,0)-1);
                hashmap.remove(j,0);
            }
        }
        int[] result = new int[intersection.size()];
        int k = 0;
        for(int i: intersection){
            //System.out.println(i);                       
            result[k++] = i;            
        }
        return result;
    }
}
