authentication
----------------------------
use basic auth
username : user
password : user123

get urls
-------------------------------
http://localhost:8000/getOriginalUrl/{tinyUrl}

post url
------------------------------------------------
http://localhost:8000/getShortUrl

body raw/json
sample data 
{
	"url" : "hoe.com",
	"domain": "ss.cpm"
}

mysql database setup
--------------------------------
set the following as per your system in 
file path: src\main\resources\application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/{youy dbname}?autoReconnect=true
spring.datasource.username={username}
spring.datasource.password={password}
