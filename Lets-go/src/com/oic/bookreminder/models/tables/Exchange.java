package com.oic.bookreminder.models.tables;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table EXCHANGE.
 */
public class Exchange {

    private Long id;
    private String userId;
    private String userName;
    private String bookId;
    private String content;
    private java.util.Date createdDate;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Exchange() {
    }

    public Exchange(Long id) {
        this.id = id;
    }

    public Exchange(Long id, String userId, String userName, String bookId, String content, java.util.Date createdDate) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.bookId = bookId;
        this.content = content;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public java.util.Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(java.util.Date createdDate) {
        this.createdDate = createdDate;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}