# ITE221 Project
<div>
<a href="https://stamford.edu">
   <img src="https://img.shields.io/badge/Institution-Stamford%20Int.%20University-blue"/>
</a>
<img src="https://img.shields.io/badge/Class-ITE221-lightgrey"/>
<img src="https://img.shields.io/badge/Term-3-lightgrey"/>
<a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/github/license/jagaapple/next-secure-headers.svg" alt="license"></a>
</div>

A basic implementation of a CLI written in Java.

Please keep in mind that in order for this to be able to compile and run, you will have to add a file called ``config.properties`` into the src directory with the contents:
```properties
USERDB_NAME=database_name
USERDB_USERNAME=username
USERDB_PASSWORD=password
USERDB_PASSWORD_SALT=password_salt 
```

* This connects to `jdbc:mysql://localhost:3306/USERDB_NAME` so if you change ports or w/e, you'll need to modify the DatabaseHandler. 

##
Creation date: `8:00 AM - 28/3/2022`

