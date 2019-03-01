package objects;

public class Book {
	long id;
	String title;
	long authorId;
	int year;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Book(long id, String title, long authorId, int year) {
		super();
		this.id = id;
		this.title = title;
		this.authorId = authorId;
		this.year = year;
	}

	public Book() {
		super();
	}

}
