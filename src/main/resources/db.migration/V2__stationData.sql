--INSERT INTO users(name, email, password, role);
--INSERT INTO users(ApplicationUser.name, ApplicationUser.email, ApplicationUser.password, ApplicationUser.role) VALUES('5', '5@mail.com', '5', 'USER');
--INSERT INTO users(name, email, password, role) VALUES('5', '5@mail.com', '5', 'USER');
CREATE TABLE IF NOT EXISTS station_data (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    station_type VARCHAR(255) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;