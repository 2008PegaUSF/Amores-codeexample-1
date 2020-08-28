											--CHINOOK LAB--
--1 SQL Queries --
 
 --1.1
select "EmployeeId", "LastName","Email" from "Employee" where "LastName" = 'King'; 			  --Task to find email from 
select "City","State" from "Employee" where "FirstName" = 'Andrew' and "ReportsTo" is null;       --Task to find city and state where the first name in Andrew

--1.2
select * from "Album" where "AlbumId" in
(select "AlbumId" from "Track" where "Composer" ='AC/DC');										   --Task to find all records from the composer AC/DC

--1.3
select * from "Album" order by "Title" desc ;                                                      --Task to order Album table by Title
select "FirstName" from "Customer" order by "City" asc;                                            --Task to order Customer's first name by city

--1.7
select * from "Invoice" where "Total" between 15 and 50;										   --Task to find the totals between 15 and 50 from the Invoice table
select * from "Employee" where "HireDate" between '2003-06-01' and '2004-03-01';				   --Task to find the employees hired between 06/01/2003 and 03/01/2004.


--2 DML Statements --

--2.1
INSERT into "Genre" ("GenreId" , "Name") values (26, 'Anime');
INSERT into "Genre" ("GenreId" , "Name") values (27, 'Cartoons');									--Insert two complete new records into Genre table 

INSERT INTO "Employee" ("EmployeeId", "LastName" , "FirstName" )
values (9, 'Skywalker', 'Luke');
INSERT INTO "Employee" ("EmployeeId" , "LastName" , "FirstName" ) 
values (10, 'Skywalker', 'Jade');																     --insert two new employees into the employee table

INSERT into "Customer" ("CustomerId" "LastName", "FirstName" , "Email" ) 
values (55, 'Kenobi', 'Ben', 'mayda4thbewithyou@sw.com');
INSERT into "Customer" ("CustomerId" , "LastName" , "FirstName", "Email" ) 
values (61, 'Gin', 'Qui-Gon', 'theresalwayzabiggerfish@sw.com');									 --insert two new customers in the customer table

--2.2
update "Customer"
Set "FirstName" = 'Robert', "LastName" = 'WALTER'
where "FirstName" = 'Aaron' and "LastName" = 'Mitchell';                                             --Update Aaron Mitchell to Rober Walter

update "Artist" 
set "Name" = 'CCR' where "Name" = 'Creedence Clearwater Revival';                      				  --Update CCR to Creedence Clearwater Revival

--2.3 
/* Verify that the record exists */
SELECT * FROM "Customer" 
WHERE "CustomerId" = '32';
/* Delete customer gets an error that points to INVOICEID constraint */
DELETE FROM "Customer" 
WHERE "CustomerId" = '32';
/* See what invoices are connected to CUSTOMERID = 32 */
SELECT * FROM "Invoice" 
WHERE "CustomerId" = '32';
/* Delete INVOICE gets an error that points to INVOICELINE INVOICEID constraint */
DELETE FROM "Invoice" 
WHERE "CustomerId" = '32';
/* See where INVOICELINE connects to INVOICE */
SELECT * FROM "InvoiceLine"
WHERE "InvoiceId" = '245' OR "InvoiceId" = '268' OR "InvoiceId" = '290' OR "InvoiceId" = '342' OR "InvoiceId" = '50' OR "InvoiceId" = '61' OR "InvoiceId" = '116';
/* Delete invoices from last child INVOICELINE */
DELETE FROM "InvoiceLine" 
WHERE "InvoiceId" = '245' OR "InvoiceId" = '268' OR "InvoiceId" = '290' OR "InvoiceId" = '342' OR "InvoiceId" = '50' OR "InvoiceId" = '61' OR "InvoiceId" = '116';
/* Delete from invoices */
DELETE FROM "Invoice"
WHERE "CustomerId" = '32';
/* Delete from Customer/parent */
DELETE FROM "Customer" 
WHERE "CustomerId" = '32';
/* Verify Delete */
SELECT * FROM "Customer"
WHERE "CustomerId" = '32';


-- 3 SQL Functions --

--3.1
select localtime;																	   --Displays the local time
select "Name",length("Name") from "MediaType";                                         --Displays the length the name of the type of media from MediaType

--3.2
select avg("Total") from "Invoice";													   --Displays the average of the total from invoice
select max("UnitPrice") from "InvoiceLine";											   --Displays the most expensive track

--3.3
select avg("UnitPrice") from "InvoiceLine";											   --Displays the average of the items in invoice line
select * from "Employee" where "BirthDate" > '01-010-1968';							   --Displays the employees that were born after 1968.



-- 4 Triggers --

--4.1
create  or replace function employee_insert()
returns trigger  as 
$$
begin 
	insert into "Employee"("Phone")
	values(new."Phone" = '867-5309')
	
	return new
end;
$$
language 'plpgsql'

create trigger ins_same_employee
	after insert 
	on employee.phone
	for each row
	execute procedure employee.phone();

-- 5 Joins -- 

--5.1
select "LastName","FirstName","InvoiceId" from "Customer"
inner join "Invoice" on "Customer"."CustomerId" = "Invoice"."CustomerId";        --Creates an inner join that joins customers and orders that specifies the name of the customer and invoice id.

--5.2
select "Customer"."CustomerId","Customer"."LastName", "Customer"."FirstName","Invoice"."InvoiceId","Invoice"."Total" 
from "Customer"
full outer join "Invoice" on "Customer"."CustomerId" = "Invoice"."InvoiceId"; 	--Creates an outer join that joins the customer and invoice table, specifying the customerId, first name, last name, invoiceId and total.

--5.3
select "Artist"."Name", "Album"."Title" from "Album"
right join "Artist" on "Album"."ArtistId" = "Artist"."ArtistId";				--Creates a right join that joins album and artist specifying 

--5.4
select * from "Artist" cross join "Album"
order by "Artist"."Name" asc;													--Creates a cross join between artist and album by ascemding artist name. 

--5.5
select * from "Employee" a, "Employee" b
where a."ReportsTo" = b."ReportsTo";											--Creates a self join on the employee table via reportsto column.



