-- Вставка пользователей
INSERT INTO Users (name, email, password) VALUES
                                              ('Иванов Иван', 'ivanov@example.com', 'password123'),
                                              ('Петров Петр', 'petrov@example.com', 'securepass'),
                                              ('Сидоров Сидор', 'sidorov@example.com', 'qwerty123');

-- Вставка задач
INSERT INTO Tasks (title, description, initial_code) VALUES
                                                        ('Задача 1', 'Описание для задачи 1', 'Начальный код для задачи 1'),
                                                        ('Задача 2', 'Описание для задачи 2', 'Начальный код для задачи 2'),
                                                        ('Задача 3', 'Описание для задачи 3', 'Начальный код для задачи 3');

-- Вставка решений
INSERT INTO Solutions (user_id, task_id, code, is_correct, feedback, submission_timestamp) VALUES
                                                                                             (1, 1, 'Код решения для задачи', true, 'Отлично!', '2024-04-18 12:00:00'),
                                                                                             (2, 1, 'Код решения для задачи', false, 'Ошибка в логике', '2024-04-18 12:30:00'),
                                                                                             (3, 2, 'Код решения для задачи', true, 'Все верно', '2024-04-18 13:00:00'),
                                                                                             (1, 3, 'Код решения для задачи', true, 'Правильно!', '2024-04-18 13:30:00');
