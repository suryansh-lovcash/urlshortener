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