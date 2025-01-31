class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:

        people.sort()

        count = 0

        l = 0
        
        r = len(people) - 1

        while(r >= l):

            if(people[r] + people[l] <= limit):
                count += 1
                r -= 1
                l += 1
            
            if(people[r] + people[l] > limit):

                if(people[r] <= limit):
                    count += 1
                    r -= 1


        return count


        