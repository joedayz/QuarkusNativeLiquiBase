-- Crear la tabla person si no existe (para cuando Liquibase está deshabilitado)
CREATE TABLE IF NOT EXISTS person (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

-- Datos de prueba
INSERT INTO person (name) VALUES ('Juan Pérez');
INSERT INTO person (name) VALUES ('María García');
INSERT INTO person (name) VALUES ('Carlos López');
INSERT INTO person (name) VALUES ('Ana Martínez');
INSERT INTO person (name) VALUES ('Luis Rodríguez');
INSERT INTO person (name) VALUES ('Carmen Sánchez');
INSERT INTO person (name) VALUES ('Javier Fernández');
INSERT INTO person (name) VALUES ('Isabel Torres');
INSERT INTO person (name) VALUES ('Miguel Ruiz');
INSERT INTO person (name) VALUES ('Elena Jiménez'); 