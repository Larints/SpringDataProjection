-- Insert departments
INSERT INTO departments (department_name) VALUES ('IT');
INSERT INTO departments (department_name) VALUES ('HR');

-- Insert employees
INSERT INTO employees (first_name, last_name, position, salary, department_id)
VALUES ('John', 'Doe', 'Developer', 50000.0, 1);

INSERT INTO employees (first_name, last_name, position, salary, department_id)
VALUES ('Jane', 'Smith', 'HR Manager', 60000.0, 2);
