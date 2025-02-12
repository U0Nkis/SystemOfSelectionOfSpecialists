CREATE TABLE clients (
                         id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                         full_name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL,
                         phone VARCHAR(15) NOT NULL,
                         city VARCHAR(100) NOT NULL
);

CREATE TABLE specialists (
                             id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                             full_name VARCHAR(255) NOT NULL,
                             email VARCHAR(255) NOT NULL,
                             phone VARCHAR(15) NOT NULL,
                             city VARCHAR(100) NOT NULL
);

CREATE TABLE services (
                          id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                          specialist_id UUID NOT NULL,
                          service_name VARCHAR(255) NOT NULL,
                          price DECIMAL(10, 2) NOT NULL,
                          FOREIGN KEY (specialist_id) REFERENCES specialists(id) ON DELETE CASCADE
);

CREATE TABLE registrations (
                               id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                               client_id UUID NOT NULL,
                               specialist_id UUID NOT NULL,
                               service_id UUID NOT NULL,
                               registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE,
                               FOREIGN KEY (specialist_id) REFERENCES specialists(id) ON DELETE CASCADE,
                               FOREIGN KEY (service_id) REFERENCES services(id) ON DELETE CASCADE
);
