#Hashmap solution
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {} # val:index
        for i, num in enumerate(nums):
            if (target - num) in hashmap:
                return [hashmap[target-num],i]
            hashmap[num] = i
        
