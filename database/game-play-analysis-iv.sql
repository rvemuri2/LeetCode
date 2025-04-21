# Write your MySQL query statement below

select 
    round(count(loggedInAgain)/count(*),2) fraction 
from 
    #Get All unique Players
    (
        select distinct player_id from activity
    ) r1 

    left join

    # Left join all unique players with those who logged in just the next day after their first day login
    (
        select player_id, 1 loggedInAgain from (
            select player_id, min(event_date) event_date from activity group by player_id
        ) q1 where exists(
            select 1 from activity where player_id=q1.player_id and event_date=q1.event_date + INTERVAL 1 DAY
        )
    ) r2

    on r1.player_id=r2.player_id

