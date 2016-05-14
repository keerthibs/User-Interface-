# User-Interface-
A simple project to understand the techniques of User Interface Designing


This project is a course in user interface design, which is to write a simple program to maintain a file of data.  This is a very common thing to write in the “real world,” but it’s not as easy as it looks.  Consider an operation that processed rebates*.  Specifications are as follows:
1.	The file (and therefore the screen) will contain the following fields: 
a.	First name (20)
b.	Last name (20)
c.	Middle initial (1)	(may be blank; entry not required)
d.	Address line 1 (35)
e.	Address line 2 (35) 	(may be blank; entry not required)
f.	City (25)
g.	State (2)
h.	Zip code (9)
i.	Phone number (21)
j.	E-mail address (60)
k.	Proof of purchase attached (Yes/No)
l.	Date received (default to today but changeable)
2.	Your program must provide three functions: 
a.	Add a new record to the end of the file.
b.	Modify an existing record and write it back to the file.  This means that you can modify all fields of the record, including the name.
c.	Delete a record from the file.
3.	This program prevents to add a record that contains the same first name, last name, and middle initial as a record already in the file.  
4.	Since this is not a database focussed project, A flat file was used a flat text file with one record per line.  One way to do this is to read the entire file into memory when the program starts and write it back out.  When the program starts, read the entire file.  When a user saves data, write the entire file.
5.	This program is written in Java using Swing.
6.	No third-party controls were used.  Only things that are part of the java, javax, and javafx packages are used.
