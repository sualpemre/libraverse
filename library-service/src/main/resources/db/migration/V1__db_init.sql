CREATE TABLE author
(
    author_id  VARCHAR(255) NOT NULL,
    name       VARCHAR(255) NULL,
    birth_date datetime NULL,
    biography  VARCHAR(255) NULL,
    CONSTRAINT pk_author PRIMARY KEY (author_id)
);

CREATE TABLE publisher
(
    publisher_id   BIGINT AUTO_INCREMENT NOT NULL,
    publisher_name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_publisher PRIMARY KEY (publisher_id)
);

CREATE TABLE book
(
    book_id          VARCHAR(255) NOT NULL,
    title            VARCHAR(255) NULL,
    isbn             VARCHAR(255) NULL,
    `description`    VARCHAR(255) NULL,
    price            FLOAT        NOT NULL,
    publication_date datetime NULL,
    author_id        VARCHAR(255) NULL,
    publisher_id     BIGINT NULL,
    CONSTRAINT pk_book PRIMARY KEY (book_id)
);


CREATE TABLE genre
(
    genre_id   BIGINT AUTO_INCREMENT NOT NULL,
    genre_name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_genre PRIMARY KEY (genre_id)
);

CREATE TABLE language
(
    language_id   BIGINT AUTO_INCREMENT NOT NULL,
    language_name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_language PRIMARY KEY (language_id)
);



CREATE TABLE book_genre
(
    book_id  VARCHAR(255) NOT NULL,
    genre_id BIGINT       NOT NULL,
    CONSTRAINT pk_book_genre PRIMARY KEY (book_id, genre_id)
);

CREATE TABLE book_language
(
    book_id     VARCHAR(255) NOT NULL,
    language_id BIGINT       NOT NULL,
    CONSTRAINT pk_book_language PRIMARY KEY (book_id, language_id)
);

ALTER TABLE book
    ADD CONSTRAINT FK_BOOK_ON_AUTHOR FOREIGN KEY (author_id) REFERENCES author (author_id);

ALTER TABLE book
    ADD CONSTRAINT FK_BOOK_ON_PUBLISHER FOREIGN KEY (publisher_id) REFERENCES publisher (publisher_id);

ALTER TABLE book_genre
    ADD CONSTRAINT fk_boogen_on_book FOREIGN KEY (book_id) REFERENCES book (book_id);

ALTER TABLE book_genre
    ADD CONSTRAINT fk_boogen_on_genre FOREIGN KEY (genre_id) REFERENCES genre (genre_id);

ALTER TABLE book_language
    ADD CONSTRAINT fk_boolan_on_book FOREIGN KEY (book_id) REFERENCES book (book_id);

ALTER TABLE book_language
    ADD CONSTRAINT fk_boolan_on_language FOREIGN KEY (language_id) REFERENCES language (language_id);