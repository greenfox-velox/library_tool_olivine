CREATE TABLE users (
    user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    userName VARCHAR(45)NOT NULL,
    firstName VARCHAR(45) NOT NULL,
    lastName VARCHAR(45) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password  VARCHAR(45) NOT NULL,
    project VARCHAR(45),
    role VARCHAR(100)
);