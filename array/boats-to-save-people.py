class Solution:
      def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        count = 0
        l, r = 0, len(people) - 1

        while r >= l:

            count += 1

            if people[r] + people[l] <= limit:
                l += 1

            r -= 1 

        return count


        