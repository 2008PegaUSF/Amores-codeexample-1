
create table "CustomerInfo"     
(	
	"CustomerID"  serial primary key,
	"UserID"   int not null,
    "Username" varchar(30) not null,
    "PassWord" varchar(10) not null,
    "Firstname" varchar(40) not null,
    "LastName" varchar(20) not null,
    "Acc1"	numeric,
	"Acc2"  numeric
   
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