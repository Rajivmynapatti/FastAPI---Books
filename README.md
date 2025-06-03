Getting Started

### Prerequisites

- Python 3.7+
- pip

### Installation

1. Clone the repository:
    ```bash
    git clone 
    ```

2. Navigate to the project directory:

    ```bash
    cd bookstore
    ```

3. Install the required packages:

    ```bash
    pip install -r requirements.txt
    ```

### Running the Application

1. Start the FastAPI server:

    ```bash
    uvicorn main:app --reload
    ```

2. The API will be available at `http://127.0.0.1:8000`

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
