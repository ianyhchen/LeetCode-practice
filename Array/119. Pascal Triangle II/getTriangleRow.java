class Solution {
    public List<Integer> getRow(int rowIndex) {
        //extra space solution
        /*List<Integer> row = new ArrayList<>();
        List<Integer> prevRow = new ArrayList<>();
        prevRow.add(1);
        if(rowIndex == 0){
            return prevRow;
        }
        for(int i = 1; i <= rowIndex; i++){
            row.add(1);
            for(int j = 1; j < i; j++){
                row.add(prevRow.get(j-1)+prevRow.get(j));
            }
            row.add(1);
            if(rowIndex == i){
                return row;
            }
            else{
                prevRow = new ArrayList<Integer>(row);
                row = new ArrayList<>();
            }
        }        
        return null;   */
        //in-place solution
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            result.add(1);
            for(int j = i-1; j > 0; j--){
                result.set(j, result.get(j-1)+result.get(j));
            }            
        }
        return result;
        
    }
}
