CREATE TABLE borrowings (
    borrowing_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    borrowingDate DATE NOT NULL
);