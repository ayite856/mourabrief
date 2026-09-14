public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;
    private String categories;
    private int number0Fcopies;
    private int publicationYear;
    private String publishingHouse;

    public Book(String isbn, String title, String author, boolean isAvailable, String categories, int number0Fcopies, int publicationYear, String publishingHouse) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
        this.categories = categories;
        this.number0Fcopies = number0Fcopies;
        this.publicationYear = publicationYear;
        this.publishingHouse = publishingHouse;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public int getNumber0Fcopies() {
        return number0Fcopies;
    }

    public void setNumber0Fcopies(int number0Fcopies) {
        this.number0Fcopies = number0Fcopies;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
}
