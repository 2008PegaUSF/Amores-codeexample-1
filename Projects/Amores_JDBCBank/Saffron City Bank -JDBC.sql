create table "UserInfo"     
(	
	"UserID"  serial primary key,
    "Username" varchar(30) not null unique,
    "PassWord" varchar(10) not null,
    "Firstname" varchar(40) not null,
    "LastName" varchar(20) not null
); 

--Creates a table for the Customer information

create table "CustomerInfo"     
(	
	"CustomerID"  serial primary key,
	"UserID"   int not null,
    "Username" varchar(30) not null,
    "PassWord" varchar(10) not null,
    "Firstname" varchar(40) not null,
    "LastName" varchar(20) not null,
    
    foreign key("UserID") references "UserInfo"("UserID")
);    

--Creates a table of all customer account information
create table "AccountInfo"(
	"AccountID" serial primary key,
	"CustomerID" integer not null,
	"Acc1"	numeric,
	"Acc2"  numeric,
	"transaction" varchar,
	"entry_date"  timestamp,
	
	 foreign key("CustomerID") references "CustomerInfo"("CustomerID")    
);

--Creates specific admin table just to record administration information

create table "AdminInfo"
(	
	"AdminID"  serial primary key,
	"UserID"   int not null,
    "Username" varchar(30) not null unique,
    "PassWord" varchar(10) not null,
    "Firstname" varchar(40) not null,
    "LastName" varchar(20) not null,
    
    foreign key("UserID") references "UserInfo"("UserID")
);
 

GRANT ALL("AdminID") on "public"."AdminInfo" TO Admin1;