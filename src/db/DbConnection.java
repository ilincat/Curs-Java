package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import objects.Author;
import objects.Book;

public class DbConnection {
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	private static Connection connection = null;

	// static method to create instance of Singleton class
	public static Connection getInstance() {
		if (connection == null)
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(
						"jdbc:sqlserver://localhost:1433;databaseName=CursJava;" + "user=dev;password=Password2.");
			} catch (Exception e) {
				e.printStackTrace();
			}

		return connection;
	}

	public static void addBook(String title, long authorId, int year) {
		try {
			preparedStatement = connection.prepareStatement("insert into books(authorId, title, year) values(?,?,?)");
			preparedStatement.setLong(1, authorId);
			preparedStatement.setString(2, title);
			preparedStatement.setInt(3, year);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addAuthor(String firstName, String lastName) {
		try {
			preparedStatement = connection.prepareStatement("insert into authors(firstName,lastName) values(?,?)");
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Author> getAllAuthors() {
		List<Author> authors = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement("select * from authors");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				authors.add(new Author(resultSet.getLong("Id"), resultSet.getString("FirstName"),
						resultSet.getString("LastName")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authors;
	}

	public static List<Book> getAllBooks() {
		List<Book> authors = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement("select * from books");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				authors.add(new Book(resultSet.getLong("Id"), resultSet.getString("Title"),
						resultSet.getLong("AuthorId"), resultSet.getInt("Year")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authors;
	}

	public static Book getBook(long id) {
		try {
			preparedStatement = connection.prepareStatement("select * from books where id=?");
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return new Book(resultSet.getLong("Id"), resultSet.getString("Title"), resultSet.getLong("AuthorId"),
						resultSet.getInt("Year"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Author getAuthor(long id) {
		try {
			preparedStatement = connection.prepareStatement("select * from authors where id=?");
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return new Author(resultSet.getLong("Id"), resultSet.getString("FirstName"),
						resultSet.getString("LastName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void deleteBook(long id) {
		try {
			preparedStatement = connection.prepareStatement("delete from books where id=?");
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateAuthorName(String name, Long id) {
		try {
			preparedStatement = connection.prepareStatement("update authors set lastName=? where id=?");
			preparedStatement.setString(1, name);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
