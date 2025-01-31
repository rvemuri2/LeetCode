class Solution:
      def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        count = 0
        l, r = 0, len(people) - 1

        while r >= l:

            remain = limit - people[r]
            r -= 1
            count += 1

            if(l <= r and remain >= people[r]):
                l += 1

        return count


        