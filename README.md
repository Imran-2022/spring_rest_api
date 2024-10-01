## JAVA spring REST API Endpoints

#### #Get All Users

- **Endpoint:** `GET /users`
- **Description:** Get a list of all users.
- **Response:**
```
[
{
"id": 1,
"name": "Ida",
"age": 32,
"email": "ida@mail.com"
},
...
]
```

#### #Get User by ID

- **Endpoint:** `GET /users/{id}`
- **Description:** Get a specific user by ID.
- **Parameters:**
- `id`: Integer - The ID of the user.
- **Response:**

```
{
"id": 1,
"name": "Ida",
"age": 32,
"email": "ida@mail.com"
}
```


#### #Create User

- **Endpoint:** `POST /users`
- **Description:** Add a new user.
- **Request Body:**

```
{
"id": 6,
"name": "6",
"age": 6,
"email": "6@mail.com"
}
```
- **Response:**
```
"Added successfully"
```

#### #Update User

- **Endpoint:** `PUT /users/{id}`
- **Description:** Update an existing user.
- **Parameters:**
- `id`: Integer - The ID of the user to update.
- **Request Body:**

```
{
"id": 6,
"name": "Updated User",
"age": 30,
"email": "updateduser@mail.com"
}
```

- **Response:**
  
```
{
"id": 6,
"name": "Updated User",
"age": 30,
"email": "updateduser@mail.com"
}
```

#### #Delete User

- **Endpoint:** `DELETE /users/{id}`
- **Description:** Delete a user by ID.
- **Parameters:**
- `id`: Integer - The ID of the user to delete.
- **Response:**

```
"Deleted successfully"
```


## Getting Started

1. Clone the repository: `git clone https://github.com/yourusername/your-repo.git`
2. Run the Spring Boot application: `mvn spring-boot:run`
3. The application will start at `http://localhost:8080`.


