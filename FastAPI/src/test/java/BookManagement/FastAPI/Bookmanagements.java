package BookManagement.FastAPI;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Bookmanagements {

	static String accessToken;

	@Test
	public void BookManagement() {

		RequestSpecification req = new RequestSpecBuilder().setBaseUri(FastAPIResources.BaseURL())
				.setContentType(ContentType.JSON).build();

		ResponseSpecification res200 = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();


		// -----------------------Login for the FASTAPI - Bookmanagement----------------

		LoginRequest login = new LoginRequest();
		login.setEmail("Test3@grr.la");
		login.setPassword("Test@1234");

		LoginResponse loginres = given().spec(req).body(login)
				.when()
				.post(FastAPIResources.Login())
				.then().spec(res200).extract().response()
				.as(LoginResponse.class);

		accessToken = loginres.getAccess_token();
		System.out.println("User logged in successfully");

		// -----------------------CreateBook for the FASTAPI -Bookmanagement----------------

		CreateBookRequest createBook = new CreateBookRequest();
		createBook.setAuthor("John Will");
		createBook.setBook_summary("Dive into the world of REST APIs and master the art of automated testing with this practical, hands-on guide.");
		createBook.setName("Rest Assured API Testing");
		createBook.setPrice(20);
		createBook.setPublished_year("2024");

		RequestSpecification reqAuth = new RequestSpecBuilder().setBaseUri(FastAPIResources.BaseURL())
				.setAccept(ContentType.JSON).setContentType(ContentType.JSON)
				.addHeader("Authorization", "Bearer " + accessToken).build();

		CreateBookResponse newBook = given().spec(reqAuth).body(createBook)
				.when()
				.post(FastAPIResources.CreateBook())
				.then().spec(res200).extract().response()
				.as(CreateBookResponse.class);

		String bookID = newBook.getId();
		
		System.out.println("The Book has been created with the id: "+ bookID);


		// -----------------------Get books by Book_ID for the FASTAPI -Bookmanagement----------------

		GetBookByIDResponse getbookByID = given().pathParam("book_id", bookID).spec(reqAuth)
				.when()
				.get(FastAPIResources.GetBookById())
				.then().spec(res200).extract().response()
				.as(GetBookByIDResponse.class);

		String getBookName = getbookByID.getName();
	
		System.out.println("The book name searched by Book_ID "+bookID+" is:  " +getBookName);

		
		// -----------------------UPDATE books using Book_ID for the FASTAPI -Bookmanagement----------------

		UpdateBookRequest updateBook = new UpdateBookRequest();
		updateBook.setAuthor("Rahul Shetty");
		updateBook.setBook_summary("This comprehensive resource takes you on a journey from the foundational principles of RESTful architecture and HTTP methods to the intricacies of building robust test automation frameworks.");
		updateBook.setName("Mastering Rest API Automation with Rest Assured");
		updateBook.setPrice(30);
		updateBook.setPublished_year("2025");

		UpdateBookResponse updatebook = given().pathParam("book_id", bookID).spec(reqAuth).body(updateBook)
				.when()
				.put(FastAPIResources.UpdateBookByID())
				.then().spec(res200).extract().response()
				.as(UpdateBookResponse.class);

		String updatedBookName = updatebook.getName();

		System.out.println("The updated book name searched by Book_ID "+bookID+" is:  " + updatedBookName);

		
		// -----------------------Delete books by using Book_IDfor the FASTAPI -Bookmanagement----------------

		DeleteBookByIDResponse deleteBookID = given().pathParam("book_id", bookID).spec(reqAuth).body(updateBook)
				.when()
				.delete(FastAPIResources.DeleteBookByID())
				.then().spec(res200).extract().response()
				.as(DeleteBookByIDResponse.class);

		String message = deleteBookID.getMessage();

		System.out.println(message);

	}

}
