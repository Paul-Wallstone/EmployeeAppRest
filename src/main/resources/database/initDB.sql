DROP TABLE IF EXISTS employeedb.employee ;
CREATE TABLE IF NOT EXISTS employeedb.employee(
    employee_id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    department_id INT NOT NULL,
    gender VARCHAR(15) NOT NULL,
    job_title VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL);