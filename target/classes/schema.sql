CREATE TABLE IF NOT EXISTS Accounts (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Profiles (
    id SERIAL PRIMARY KEY,
    account_id INT UNIQUE NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    phone VARCHAR(50),
    address TEXT,
    FOREIGN KEY (account_id) REFERENCES Accounts(id)
);

CREATE TABLE IF NOT EXISTS Loans (
    id SERIAL PRIMARY KEY,
    account_id INT NOT NULL,
    loan_amount DECIMAL(10,2) NOT NULL,
    interest_rate DECIMAL(5,2) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    FOREIGN KEY (account_id) REFERENCES Accounts(id)
);

CREATE TABLE  IF NOT EXISTS Guarantors (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(50)
);

CREATE TABLE  IF NOT EXISTS Loan_Guarantors (
    loan_id INT NOT NULL,
    guarantor_id INT NOT NULL,
    PRIMARY KEY (loan_id, guarantor_id),
    FOREIGN KEY (loan_id) REFERENCES Loans(id),
    FOREIGN KEY (guarantor_id) REFERENCES Guarantors(id)
);

CREATE TABLE  IF NOT EXISTS Payments (
    id SERIAL PRIMARY KEY,
    loan_id INT NOT NULL,
    payment_date DATE NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (loan_id) REFERENCES Loans(id)
);





































