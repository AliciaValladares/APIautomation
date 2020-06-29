# APIautomation
API automation with Rest Assured 


PRE-REQUIREMENTS:
1. Create a new maven proyect in your IDE.
2. Insert the following jar files:

a. TestNG 
b. Rest Assured
c. JSON Schema Validator
d. JSON path

INSTALLATION:
1.  Install NPM: it is a Node Package Manager and you can get it from nodejs.org. 
2.  Install JSON Server: it is a necessary tool to carry out the api testing. Run the following command in the terminal: "npm install -g json-server" 
3.  Create a db.json file (Anywhere on your machine: the content must be in a JSON format as it follows: 
{   
"posts": 
[
  { "id": 1, 
    "title": "json-server", 
    "author": "typicode" 
  }   
],   
"comments": 
[
  { "id": 1, 
    "body": "some comment", 
    "postId": 1 
  }   
],   
"profile": 
   { "name": "typicode" } 
}

4. Start JSON Server: it will be connected to the 3000 port by default using the following command: "json-server --watch db.json". If you prefer to use another port, you can try the following: "json-server --watch --port(port number you want to use) db.json"

TEST EXECUTION:
This maven project is going to be run using testNG librery.
API endpoints:
- GET:    "https://localhost-3000/posts/1"
- POST:   "https://localhost-3000/posts"
- PUT:    "https://localhost-3000/posts/1"
- DELETE: "https://localhost-3000/posts/1"


