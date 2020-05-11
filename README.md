# FKPayrollDesign

First import the FKpayroll.sql in your local mysql.

Create new database in mysql using CREATE DATABASE FKpayroll

Now quit mysql and import sql file

  mysql -u root -p FKpayroll < /home/user/Desktop/FKpayroll.sql
  
  path will be different based on where you have store it.
  find path using pwd.
  
  replace root with your username.
  replace password with your sql password 
Now open Admin.java and change
  static String user="root";
    	static String password="password";
    	static String url="jdbc:mysql://localhost:3306/FKpayroll";

Just compile Admin.java make sure mysql library is included in class path.

If facing any problem , please contact me.
