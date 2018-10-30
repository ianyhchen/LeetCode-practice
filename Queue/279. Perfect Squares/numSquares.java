class Solution {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();        
        int numbers = 0;
        queue.offer(n);
        while(!queue.isEmpty()){
            int size = queue.size();
            numbers++;
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                if(!set.add(cur)){
                    continue;
                }
                for(int j = 1; j <= Math.sqrt(cur); j++){
                    int diff = cur - j * j;         //minus the perfect square numbers 
                    if(diff == 0) return numbers;   //=>find another perfect square number which equal to diff                    
                    queue.offer(diff);
                }
            }
        }
        return 0;
    }
}
