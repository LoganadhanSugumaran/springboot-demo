

# Candidate Voting System
Java spring developer assignment
This is a simple REST API for managing candidate votes.

## Requirements

- Java
- Spring Boot

## Usage

1. Access the API at `http://localhost:8080

### Endpoints

- `POST /api/candidates/entercandidate?name={name}`: Enter a new candidate.
- `POST /api/candidates/castvote?name={name}`: Cast a vote for a candidate.
- `GET /api/candidates/countvote?name={name}`: Get the vote count for a candidate.
- `GET /api/candidates/listvote`: Get a list of all candidates and their vote counts.
- `GET /api/candidates/getwinner`: Get the candidate with the highest vote count.

##  Additionally i have done MySQL database connection to access from MySQL database 
uncomment application.properties file, repository and model file to enable MySQL
