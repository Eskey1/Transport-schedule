CREATE TABLE IF NOT EXISTS users (
   id BINARY(16) PRIMARY KEY,
   created_date TIMESTAMP,
   lastMod_date TIMESTAMP,
   created_by VARCHAR(255),
   modified_by VARCHAR(255),
   name VARCHAR(255) UNIQUE,
   email VARCHAR(255) UNIQUE,
   password VARCHAR(255),
   role VARCHAR(255)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;