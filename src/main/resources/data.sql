INSERT INTO image (url, type) VALUES ('http://localhost:8080/5.svg', 2);
INSERT INTO image (url, type) VALUES ('http://localhost:8080/7.svg', 2);
INSERT INTO image (url, type) VALUES ('http://localhost:8080/6.svg', 2);
INSERT INTO image (url, type) VALUES ('http://localhost:8080/8.svg', 2);

INSERT INTO users (name, user_id, email, pw, created_date) VALUES ('김혜승', 'hyeseung', 's2224@e-mirim.hs.kr', '$2a$10$BxnbZ4Pr5y5qLlf7WmzThOIKLByL6aq9k3I8CZ45pNZMvX6QZWXYW', '2023-10-20 10:11:20');
INSERT INTO point (variation, balance, user_id) VALUES (0, 0, 1);

INSERT INTO team (title, description, start_date, finish_date, user_list) VALUES ('title', 'description', '2023-10-20 00:00:00', '2024-01-12 00:00:00', '1');
INSERT INTO team (title, description, start_date, finish_date, user_list) VALUES ('title', 'description', '2023-10-20 00:00:00', '2024-01-20 00:00:00', '1');
INSERT INTO team (title, description, start_date, finish_date, user_list) VALUES ('title', 'description', '2023-10-20 00:00:00', '2024-01-30 00:00:00', '1');
INSERT INTO team (title, description, start_date, finish_date, user_list) VALUES ('title', 'description', '2023-10-20 00:00:00', '2024-02-01 00:00:00', '1');

INSERT INTO walk (count, date, user_id) VALUES (100, '2023-10-20', 1);
INSERT INTO walk (count, date, user_id) VALUES (200, '2023-11-20', 1);
INSERT INTO walk (count, date, user_id) VALUES (300, '2023-12-20', 1);
INSERT INTO walk (count, date, user_id) VALUES (400, '2024-01-10', 1);
INSERT INTO walk (count, date, user_id) VALUES (500, '2024-01-11', 1);
INSERT INTO walk (count, date, user_id) VALUES (250, '2024-01-12', 1);
INSERT INTO walk (count, date, user_id) VALUES (330, '2024-01-13', 1);
INSERT INTO walk (count, date, user_id) VALUES (190, '2024-01-14', 1);
INSERT INTO walk (count, date, user_id) VALUES (242, '2024-01-15', 1);
INSERT INTO walk (count, date, user_id) VALUES (983, '2024-01-16', 1);
INSERT INTO walk (count, date, user_id) VALUES (10, '2024-01-17', 1);

INSERT INTO category (name) VALUES ('의류');
INSERT INTO category (name) VALUES ('잡화');

INSERT INTO product (name, description, point, category_id) VALUES ('상의', '상의입니다', 200, 1);
INSERT INTO product (name, description, point, category_id) VALUES ('잡화', '잡화입니다', 100, 2);

INSERT INTO challenge (description, point) VALUES ('만보기 100번 걷기', 100);