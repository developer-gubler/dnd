Purpose(s):
1) Just to create a project for display as part of my portfolio. Please realize this application is intentionally over-architected for the purpose of displaying my skills.
2) Create something that a D&D Dungeon Master can use to:
    - Track hit points, conditions, etc of players and creatures -- if one creature/player has concentration and is tied to a condition, then both are tracked
    - Track round and initiative
    - Possibility of adding automated rolling of dice

Suggested mechanism for getting the project running (NOTE: writing this from memory and I tend to gloss over some instructions that some people may need more details on -- because I am doing this from memory, some of these instructions are high level and may not make much sense unless you are already familiar with this sort of thing):
- Install Chocolatey or Homebrew (ie this is a Package Manager - Chocolatey is Windows, Homebrew is Mac)
- Install Docker via Chocolatey/Homebrew
- Install Terraform via Chocolatey/Homebrew
- Install Postman via Chocolatey/Homebrew
- Start Docker Desktop
- Download this project
- navigate to the terraform directory
- terraform init
- terraform apply
- docker network inspect dnd_network
- look for the dnd-database entry and take note of the IP address
- in Docker Desktop, click the link under Port(s) for dnd_pgadmin (ie 5051:5050)
- login to dnd_pgadmin from Docker Desktop using credentials specified in terraform\main.tf
- open Query editor in pgadmin and insert the data from src\test\resources\schema-postgresql.sql and src\test\resources\data-postgresql.sql
- mvnw clean package
- mvnw spring-boot:run
- open Postman
- import collection located in the project postman directory
- begin testing!

Currently there are two branches for this code:
1) Non-Reactive branch is the "main" branch
2) Reactive branch is the "reactive" branch - this is the current branch that I am working on.

Note(s):
1) I realize this is going to be a huge project, but I have never let anything like that stop me.  How do you eat an elephant? One bite at a time.
2) There really isn't much functionality to the project at this time.  So far, I have really just been setting the project up for future success.  However, it does have the ability to look at a sample list of creatures.

Current Features:
1) Terraform creation of the Docker infrastrusture
2) Docker (ie Dockerfile and compose.yaml)
3) Testing leveraging JUnit in 4 different Test Driven Development (TDD) styles
  - Standard way that developers normally test (ie all beans autoconfigured, web server, all requests routed through the web server, etc)
  - Mock MVC (ie all beans autoconfigured, no web server, all requests routed directly to the endpoint, etc)
  - Web MVC (ie beans are manually configured and responses are configured via Mockito, no web server, all requests routed directly to the endpoint, etc)
  - Testcontainers (ie Docker)
4) Automatic database initialization of the schema (ie it does NOT automatically initialize the data -- that must be done manually)
5) Postman collection of requests
6) API for a reader application that retrieves Creatures, Equipment, and a cross-reference between Creatures and Equipment.

Future Features:
1) Creating a UI/UX for the reader application
2) Add battle application
	- Event Driven Architecture (EDA). Loose-coupling via Kafka/RabbitMQ. Loose-coupling is best utilized in situations where there are limited resources - in this case, hit points will be the resource that is limited.
	- Registering an account
	- SSL/TLS
	- Authentication/Authorization - Logging into application
	- Adding players to an account
	- Creating battles associated with an account
	- Create UI/UX for the battle application
3) Add additional testing style for Behavior Driven Development (BDD) leveraging Cucumber
