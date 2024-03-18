from faker import Faker
import uuid
import random
import bcrypt
faker = Faker()


def addRow(file, user_name, name, surname, email, raw_password, is_active, role_id):
    account_id = str(uuid.uuid4())
    hashed_password = bcrypt.hashpw(raw_password.encode('utf-8'), bcrypt.gensalt())
    hashed_password = hashed_password.decode('utf-8')
    last_login = faker.date_time_between(start_date='-1y', end_date='now').strftime("%Y-%m-%d %H:%M:%S")
    created_at = faker.date_time_between(start_date='-2y', end_date='-1y').strftime("%Y-%m-%d %H:%M:%S")
    updated_at = faker.date_time_between(start_date='-1y', end_date='now').strftime("%Y-%m-%d %H:%M:%S")
    file.write(f"INSERT INTO account (account_id, user_name, name, surname, email, password, role_id, is_active, last_login, created_at, updated_at) VALUES ('{account_id}', '{user_name}', '{name}', '{surname}', '{email}', '{hashed_password}', {role_id}, {is_active}, '{last_login}', '{created_at}', '{updated_at}');\n")

def createDefaultAccounts():
    with open('db/migration/V4__create_accounts.sql', 'w') as file:
        addRow(file, "admin123", "Default", "Admin", "admin@admin.com", "admin123", True, 1)
        addRow(file, "seller123", "Default", "Seller", "seller@seller.com", "seller123", True, 2)
        addRow(file, "customer123", "Default", "Customer", "customer@customer.com", "customer123", True, 3)


roles = ['ADMINISTRATOR', 'SELLER', 'CUSTOMER']
role_ids = []
role_id = 1
with open('db/migration/V3__create_roles.sql', 'w') as file:
    for role in roles:
        file.write(f"INSERT INTO role (name) VALUES ('{role}');\n")
        role_ids.append(role_id)
        role_id += 1

createDefaultAccounts()

with open('db/migration/V4__create_accounts.sql', 'a') as file:
    for _ in range(100):
        user_name = faker.user_name()
        name = faker.first_name()
        surname = faker.last_name()
        email = faker.email()
        raw_password = faker.password()
        is_active = random.choice([True, False])
        role_id = random.choice(role_ids)

        addRow(file, user_name, name, surname, email, raw_password, is_active, role_id)



