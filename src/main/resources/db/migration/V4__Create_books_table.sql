CREATE TABLE books (
    book_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    bookTitle VARCHAR(100)NOT NULL,
    bookAuthor VARCHAR(100) NOT NULL,
    bookPublishedIn INT(4) NOT NULL,
    bookEdition VARCHAR(100),
    bookCover VARCHAR(50),
    bookISBNno VARCHAR(50),
    bookFormat VARCHAR(50),
    bookNumberOfPage INT(4),
    bookInLanguage VARCHAR(20),
    bookDesctiption VARCHAR(500),
    bookIsBorrowed TINYINT(1)
);