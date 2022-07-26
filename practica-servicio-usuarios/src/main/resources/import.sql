INSERT INTO `users` (username, password, enabled, name, surname, email) VALUES ('rodri','123456',1, 'Rodrigo', 'Cruz','rodri@correo.com');
INSERT INTO `users` (username, password, enabled, name, surname, email) VALUES ('admin','123456',1, 'Pepe', 'Administrador','admin@correo.com');

INSERT INTO `roles` (name) VALUES ('ROLE_USER');
INSERT INTO `roles` (name) VALUES ('ROLE_ADMIN');

INSERT INTO `users_roles` (user_id, roles_id) VALUES (1, 1);
INSERT INTO `users_roles` (user_id, roles_id) VALUES (2, 2);
INSERT INTO `users_roles` (user_id, roles_id) VALUES (2, 1);