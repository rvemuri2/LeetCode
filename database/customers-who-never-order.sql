
select 
      c.name AS Customers 
from Customers c
Left join Orders o
on c.id = o.customerId
where o.customerId is null