INSERT INTO user
(id, name, login, password)
VALUES
  (1, 'Vera', 'vera76532', 'testPassword'),
  (2, 'name2', 'login2', 'password2');

INSERT INTO notebook
(id, name, user_id)
VALUES
  (1, 'FirstNotebook', 2);
