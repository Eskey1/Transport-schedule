CREATE TABLE IF NOT EXISTS station_data (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    station_type VARCHAR(255) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;