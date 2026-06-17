-- Scenario 1: Apply 1% discount to customers above 60

DECLARE
BEGIN
   FOR cust IN (
      SELECT CustomerID, Age
      FROM Customers
   )
   LOOP
      IF cust.Age > 60 THEN
         UPDATE Loans
         SET InterestRate = InterestRate - 1
         WHERE CustomerID = cust.CustomerID;
      END IF;
   END LOOP;

   COMMIT;
END;
/

-- Scenario 2: Promote customers to VIP

DECLARE
BEGIN
   FOR cust IN (
      SELECT CustomerID, Balance
      FROM Customers
   )
   LOOP
      IF cust.Balance > 10000 THEN
         UPDATE Customers
         SET IsVIP = 'TRUE'
         WHERE CustomerID = cust.CustomerID;
      END IF;
   END LOOP;

   COMMIT;
END;
/

-- Scenario 3: Send reminders for loans due within 30 days

BEGIN
   FOR loan IN (
      SELECT CustomerID, DueDate
      FROM Loans
      WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30
   )
   LOOP
      DBMS_OUTPUT.PUT_LINE(
         'Reminder: Loan due for Customer ID '
         || loan.CustomerID
         || ' on '
         || loan.DueDate
      );
   END LOOP;
END;
/