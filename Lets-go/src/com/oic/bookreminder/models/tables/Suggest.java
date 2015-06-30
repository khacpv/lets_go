package com.oic.bookreminder.models.tables;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table SUGGEST.
 */
public class Suggest {

    private Long id;
    private Long bookId;
    private String bookTitle;
    private String thumbnail;
    private String author;
    private String content;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Suggest() {
    }

    public Suggest(Long id) {
        this.id = id;
    }

    public Suggest(Long id, Long bookId, String bookTitle, String thumbnail, String author, String content) {
        this.id = id;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.thumbnail = thumbnail;
        this.author = author;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
