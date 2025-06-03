Getting Started

### Prerequisites
[bookstore.zip](https://github.com/user-attachments/files/20574436/bookstore.zip)

- Python 3.7+
- pip

### Installation

1. Navigate to the project directory:

    ```bash
    cd bookstore
    ```

2. Install the required packages:

    ```bash
    pip install -r requirements.txt
    ```

### Running the Application

1. Start the FastAPI server:

2. Navigate to the project directory:

    ```bash
    cd bookstore

    ```bash
    uvicorn main:app --reload
    ```

3. The API will be available at `http://127.0.0.1:8000`

4. Once the Server is up and running then open FASTAPI Project
5. Navigate till this location: FastAPI---Books/FastAPI/src/test/java/BookManagement/FastAPI/Bookmanagements.java
6. Now right click on the Bookmanagements.java and then select "run as" - "TestNG Test"
7. On the console you will be able to see the result printing.

### API Endpoints

- Book Management

    - POST /books/: Create a new book.
    - PUT /books/{book_id}: Update a book by ID.
    - DELETE /books/{book_id}: Delete a book by ID.
    - GET /books/{book_id}: Get a book by ID.
    - GET /books/: Get all books.

- User Authentication

    - POST /signup: Sign up a new user.
    - POST /login: Log in and receive an access token.

- Health Check
    - GET /health: Check the health of the API.
