CREATE TABLE member (
  member_id UUID PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  date_of_birth DATE NOT NULL,
  gender CHAR(1) NOT NULL,
  address VARCHAR(255) NOT NULL,
  number INT NOT NULL,
  unit VARCHAR(255),
  zip_code VARCHAR(8) NOT NULL,
  city VARCHAR(255) NOT NULL,
  state VARCHAR(2) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  email VARCHAR(255) NOT NULL,
  join_date DATETIME NOT NULL,
  membership_plan VARCHAR(255) NOT NULL,
  active BOOLEAN NOT NULL DEFAULT TRUE
);