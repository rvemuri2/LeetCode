class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:

        count_s1 = Counter(s1)

        count_s2 = {}

        L = 0


        for R in range(len(s2)):

            count_s2[s2[R]] = count_s2.get(s2[R], 0) + 1

            if(R - L + 1 == len(s1)):

                if(count_s2 == count_s1):
                    return True
                else:
                    count_s2[s2[L]] -= 1
                    if(count_s2[s2[L]] == 0):
                        del count_s2[s2[L]]
                    L += 1

        print(count_s2)
        print(count_s1)
        
        return False



        