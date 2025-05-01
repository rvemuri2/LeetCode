CREATE OR REPLACE FUNCTION NthHighestSalary(N INT)
  RETURNS TABLE (Salary INT) AS $$
BEGIN
  IF N <= 0 THEN
    RETURN QUERY VALUES (NULL::INT);
  ELSE
    RETURN QUERY
      SELECT (SELECT DISTINCT e.salary
                FROM employee e
               ORDER BY e.salary DESC
               OFFSET N - 1
               FETCH FIRST 1 ROW ONLY);
  END IF;
END;
$$ LANGUAGE plpgsql;