from faker import Faker
import uuid
import random
import bcrypt
import copy
faker = Faker()


author_ids = []
with open('db/migration/V3__create_authors.sql', 'w') as file:
    for _ in range(50):
        name = faker.name()
        birth_date = faker.date_of_birth(minimum_age=20, maximum_age=80)
        biography = faker.text()
        author_id = str(uuid.uuid4())
        author_ids.append(author_id)
        file.write(f"INSERT INTO author (author_id, name, birth_date, biography)VALUES ('{author_id}', '{name}', '{birth_date}', '{biography}');\n")

publisher_ids = []
publisher_id = 1
with open('db/migration/V4__create_publishers.sql', 'w') as file:
    for _ in range(50):
        publisher_name = faker.company()
        file.write(f"INSERT INTO publisher (publisher_name) VALUES ('{publisher_name}');\n")
        publisher_ids.append(publisher_id)
        publisher_id += 1

book_ids = []
with open('db/migration/V5__create_books.sql', 'w') as file:
    for _ in range(50):
        author_id = random.choice(author_ids)
        publisher_id = random.choice(publisher_ids)
        book_id = str(uuid.uuid4())
        title = faker.sentence(nb_words=4)
        isbn = faker.isbn13()
        description = faker.paragraph()
        price = round(random.uniform(5, 50), 2)
        publication_date = faker.date_between(start_date='-10y', end_date='today')
        file.write(f"INSERT INTO book (book_id, title, isbn, `description`, price, publication_date, author_id, publisher_id) VALUES ('{book_id}', '{title}', '{isbn}', '{description}', {price}, '{publication_date}', '{author_id}', {publisher_id});\n")
        book_ids.append(book_id)

genres = ['Fantasy', 'Science Fiction', 'Romance', 'Mystery', 'Thriller', 'Horror', 'Historical Fiction', 'Non-fiction', 'Biography', 'Memoir', 'Young Adult', 'Children']
genre_ids = []
genre_id = 1
with open('db/migration/V6__create_genres.sql', 'w') as file:
    for genre in genres:
        file.write(f"INSERT INTO genre (genre_name) VALUES ('{genre}');\n")
        genre_ids.append(genre_id)
        genre_id += 1


language_ids = []
language_id = 1
with open('db/migration/V7__create_languages.sql', 'w') as file:
    for _ in range(50):
        language = faker.language_name()
        file.write(f"INSERT INTO language (language_name) VALUES ('{language}');\n")
        language_ids.append(language_id)
        language_id += 1

with open('db/migration/V8__create_relations.sql', 'w') as file:
    for book_id in book_ids:
        copy_genre_ids = genre_ids.copy()
        copy_language_ids = language_ids.copy()
        for _ in range(random.randint(1, 5)):
            genre_id = random.choice(copy_genre_ids)
            copy_genre_ids.remove(genre_id)
            file.write(f"INSERT INTO book_genre (book_id, genre_id) VALUES ('{book_id}',{genre_id});\n")

        for _ in range(random.randint(1, 5)):
            language_id = random.choice(copy_language_ids)
            copy_language_ids.remove(language_id)
            file.write(f"INSERT INTO book_language (book_id, language_id) VALUES ('{book_id}',{language_id});\n")


