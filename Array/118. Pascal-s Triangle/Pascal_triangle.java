class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        //if user request zero rows, they get zero rows.
        if(numRows == 0){
            return triangle;
        }
        //first row is always [1]
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        
        for(int rowIndex = 1; rowIndex < numRows; rowIndex++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowIndex-1);
            //first element is always 1.
            row.add(1);
            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for(int i = 1; i < rowIndex; i++){
                row.add(prevRow.get(i-1)+prevRow.get(i));
            }
            // The last row element is always 1.
            row.add(1);
            
            triangle.add(row);
        }
        return triangle;
        
    }
}
