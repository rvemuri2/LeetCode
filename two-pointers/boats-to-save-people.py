class Solution:
      def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        count = 0
        l, r = 0, len(people) - 1

        while r >= l:
            # Always count the boat
            count += 1

            # If the lightest and heaviest can share a boat
            if people[r] + people[l] <= limit:
                l += 1  # Move left pointer

            r -= 1  # Move right pointer (heaviest person always leaves)

        return count


        