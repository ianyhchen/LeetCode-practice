class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> hashmap = new HashMap<String,Integer>();
        for(int i = 0; i < list1.length; i++){
            hashmap.put(list1[i],i);
        }
        int min_index = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>(); // store the strings with minimum index
        for(int j = 0; j < list2.length && j <= min_index; j++){
            if(hashmap.containsKey(list2[j])){
                int index = hashmap.get(list2[j])+j;               
                if(index < min_index){   
                    result.clear();     //clear the result list and set the minimum index to index.
                    result.add(list2[j]);
                    min_index = index;
                }
                else if(index == min_index){//when the index is the same as the minimum index, add the string to the list
                    result.add(list2[j]);
                }
            }
        }
        String[] res = new String[result.size()];
        /*int i = 0;
        for(String s: result){
            res[i++] = s;
        }
        return res;*/
        return result.toArray(res);
     
    }
}
