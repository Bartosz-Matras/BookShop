package pl.matrasbartosz.bookshop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Long idBook;

    @Column(name = "name")
    private String name;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "number_of_pages")
    private int numberOfPages;

    @Column(name = "book_type")
    private BookType bookType;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "id_book"),
            inverseJoinColumns = @JoinColumn(name = "id_author")
    )
    private List<Author> authorList;

    public Book() {
    }

    public Book(String name, String publisher, int numberOfPages, BookType bookType) {
        this.name = name;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
        this.bookType = bookType;
    }

    public Book(Long idBook, String name, String publisher, int numberOfPages, BookType bookType) {
        this.idBook = idBook;
        this.name = name;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
        this.bookType = bookType;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public void addAuthor(Author author){
        if(authorList == null){
            authorList = new ArrayList<>();
        }

        authorList.add(author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", bookType=" + bookType +
                '}';
    }
}
