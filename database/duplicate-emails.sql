# Write your MySQL query statement below
# Please upvote, if you like my solution
# 1
SELECT Email FROM Person GROUP BY Email HAVING COUNT(Email) > 1;