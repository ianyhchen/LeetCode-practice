class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 1 # slow pointer
        for j in range(1,len(nums)): #fast pointer, increase j to skip duplicate
            # if not the same, increase i and copy the value of j to i, 
            if nums[j-1] != nums[j]: 
                nums[i] = nums[j]
                i+=1
        return i
        
                
        
