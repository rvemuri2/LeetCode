-- SELECT Person.firstName, Person.lastName, Address.city, Address.state
-- FROM Person
-- LEFT JOIN Address ON Person.personId=Address.personId;

select p.firstname,p.lastname,a.city,a.state from Person p left join Address a on p.personId=a.personId;