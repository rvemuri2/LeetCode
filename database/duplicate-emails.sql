# Write your MySQL query statement below
# Please upvote, if you like my solution
SELECT Email FROM Person GROUP BY Email HAVING COUNT(Email) > 1;