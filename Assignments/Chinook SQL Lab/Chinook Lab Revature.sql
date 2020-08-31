											--CHINOOK LAB--
--1 SQL Queries --
 
 --1.1
 
 --Task to find email from
select "EmployeeId", "LastName","Email" from "Employee" where "LastName" = 'King'; 	

--Task to find city and state where the first name in Andrew
select "City","State" from "Employee" where "FirstName" = 'Andrew' and "ReportsTo" is null;       

--1.2

--Task to find all records from the composer AC/DC
select * from "Album" where "AlbumId" in
(select "AlbumId" from "Track" where "Composer" ='AC/DC');										   

--1.3

--Task to order Album table by Title
select * from "Album" order by "Title" desc ;          

--Task to order Customer's first name by city
select "FirstName" from "Customer" order by "City" asc;                                            

--1.7

--Task to find the totals between 15 and 50 from the Invoice table
select * from "Invoice" where "Total" between 15 and 50;	

--Task to find the employees hired between 06/01/2003 and 03/01/2004.
select * from "Employee" where "HireDate" between '2003-06-01' and '2004-03-01';				  


--2 DML Statements --

--2.1

--Insert two complete new records into Genre table 
INSERT into "Genre" ("GenreId" , "Name") values (26, 'Anime');
INSERT into "Genre" ("GenreId" , "Name") values (27, 'Cartoons');	

--insert two new employees into the employee table
INSERT INTO "Employee" ("EmployeeId", "LastName" , "FirstName" )
values (9, 'Skywalker', 'Luke');
INSERT INTO "Employee" ("EmployeeId" , "LastName" , "FirstName" ) 
values (10, 'Skywalker', 'Jade');																     

--insert two new customers in the customer table
INSERT into "Customer" ("CustomerId" "LastName", "FirstName" , "Email" ) 
values (55, 'Kenobi', 'Ben', 'mayda4thbewithyou@sw.com');
INSERT into "Customer" ("CustomerId" , "LastName" , "FirstName", "Email" ) 
values (61, 'Gin', 'Qui-Gon', 'theresalwayzabiggerfish@sw.com');									 

--2.2
--Update Aaron Mitchell to Rober Walter
update "Customer"
Set "FirstName" = 'Robert', "LastName" = 'WALTER'
where "FirstName" = 'Aaron' and "LastName" = 'Mitchell';                                             

--Update CCR to Creedence Clearwater Revival
update "Artist" 
set "Name" = 'CCR' where "Name" = 'Creedence Clearwater Revival';                      				  

--2.3 
/* Verify that the record exists */
SELECT * FROM "Customer" 
WHERE "CustomerId" = '32';
/* Trys to delete customer info out right.....ERROR occurs */
DELETE FROM "Customer" 
WHERE "CustomerId" = '32';
/* Thought it would be easy to see where invoices connects to CUSTOMERID = 32 */
SELECT * FROM "Invoice" 
WHERE "CustomerId" = '32';
/* Where frustrations begins..... */
DELETE FROM "Invoice" 
WHERE "CustomerId" = '32';
/* See where INVOICELINE connects to INVOICE */
SELECT * FROM "InvoiceLine"
WHERE "InvoiceId" = '245' OR "InvoiceId" = '268' OR "InvoiceId" = '290' OR "InvoiceId" = '342' OR "InvoiceId" = '50' OR "InvoiceId" = '61' OR "InvoiceId" = '116';
/* Removes exisitence from Invoiceline  */
DELETE FROM "InvoiceLine" 
WHERE "InvoiceId" = '245' OR "InvoiceId" = '268' OR "InvoiceId" = '290' OR "InvoiceId" = '342' OR "InvoiceId" = '50' OR "InvoiceId" = '61' OR "InvoiceId" = '116';
/* Burns all records of his invoices */
DELETE FROM "Invoice"
WHERE "CustomerId" = '32';
/*SENDS ROBERT WALTER TO THE SHADOW REALM */
DELETE FROM "Customer" 
WHERE "CustomerId" = '32';
/*Confirms ROBERT WALTER HAS BEEN SENT TO THE SHADOW REALM*/
SELECT * FROM "Customer"
WHERE "CustomerId" = '32';


-- 3 SQL Functions --

--3.1

--Displays the local time
select localtime;	

--Displays the length the name of the type of media from MediaType
select "Name",length("Name") from "MediaType";                                         

--3.2
--Displays the average of the total from invoice
select avg("Total") from "Invoice";				

--Displays the most expensive track
select max("UnitPrice") from "InvoiceLine";											   

--3.3

 --Displays the average of the items in invoice line
select avg("UnitPrice") from "InvoiceLine";		

--Displays the employees that were born after 1968.
select * from "Employee" where "BirthDate" > '01-010-1968';							   



-- 4 Triggers --

--4.1	/*AFTER*/
--Creates a trigger for changing the phone number to '867-5309'....nice!
create  or replace function employee_insert_pn()
returns trigger  as $$
begin 
		if(TG_OP = 'INSERT') then 
		new."Phone" = '867-5309';
		end if;
		return new;
		end;
$$
language 'plpgsql';

create trigger employee_insert
	after insert 
	on "Employee"
	for each row
	execute function employee_insert_pn();

--4.2 /*BEFORE*/
--Creates a trigger to change the company to Revature
create or replace function company_insert_here()
returns trigger as $$
begin
	if(TG_OP = 'INSERT') then
	new."Company" = 'Revature';
	end if; 
	return new;
	end;
$$ language plpgsql;

create trigger customer_insert
before insert on "Customer"
for each row
execute function company_insert_here();

-- 5 Joins -- 

--5.1
--Creates an inner join that joins customers and orders that specifies the name of the customer and invoice id.
select "LastName","FirstName","InvoiceId" from "Customer"
inner join "Invoice" on "Customer"."CustomerId" = "Invoice"."CustomerId";        

--5.2
--Creates an outer join that joins the customer and invoice table, specifying the customerId, first name, last name, invoiceId and total.
select "Customer"."CustomerId","Customer"."LastName", "Customer"."FirstName","Invoice"."InvoiceId","Invoice"."Total" 
from "Customer"
full outer join "Invoice" on "Customer"."CustomerId" = "Invoice"."InvoiceId"; 	


--5.3
--Creates a right join that joins album and artist specifying
select "Artist"."Name", "Album"."Title" from "Album"
right join "Artist" on "Album"."ArtistId" = "Artist"."ArtistId";				 

--5.4
--Creates a cross join between artist and album by ascemding artist name. 
select * from "Artist" cross join "Album"
order by "Artist"."Name" asc;													

--5.5
--Creates a self join on the employee table via reportsto column.
select * from "Employee" a, "Employee" b
where a."ReportsTo" = b."ReportsTo";		


--6 SET OPERATIONS--

--6.1 
--Create a UNION query for finding the unique records of last name, first name, and phone number for all customers and employees.
select "Customer"."LastName", "Customer"."FirstName", "Customer"."Phone" from "Customer"   
union
select "Employee"."LastName", "Employee"."FirstName", "Employee"."Phone" from "Employee";  

--6.2
/*Create an EXCEPT ALL query for finding all records of the city, state, and postal codes for all customers
 * along long with all records of employees that have a different  city, state, and postal codes of any customer.
 */
select "Customer"."City", "Customer"."State", "Customer"."PostalCode" from "Customer" 
except all
select "Employee"."City", "Employee"."State", "Employee"."PostalCode" from "Employee";  



