class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        l = list()
        for i in range(0,n):
            for j in range(i+1,n):
                if (nums[i]+nums[j]==target):
                    l.append(i)
                    l.append(j)
                    return l
        
