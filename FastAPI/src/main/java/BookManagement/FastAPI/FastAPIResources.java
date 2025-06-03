package BookManagement.FastAPI;

public class FastAPIResources {
	
	public static String BaseURL() {
		
		String baseURL = "http://127.0.0.1:8000";
		return baseURL;
	}
	
	
	public static String Signup() {
		
		String signUp = "signup";
		return signUp;
		
	}
	
	public static String Login() {
		
		String login = "login";
		return login;
	}
	
	public static String CreateBook() {
		
		String createBook = "books/";
		return createBook;
		
	}
	
	public static String GetBookById() {
		
		String getBook = "books/{book_id}";
		return getBook;
		
	}
	
	public static String GetAllBooks() {
		String getAllBooks = "books/";
		return getAllBooks; 
	}
	
	public static String UpdateBookByID() {
		String updateBookById = "books/{book_id}";
		return updateBookById;
	}
	
	public static String DeleteBookByID() {
		
		String deleteBookById = "books/{book_id}";
		return deleteBookById;
	}

}
