--INSERT INTO _USER(id, name, birth_day) VALUES(1001, 'EEee', current_date())
DELETE FROM TODO WHERE username='user';

INSERT INTO TODO(id, description, done, target_date, username) VALUES(10001, 'Get AWS Certified', false, current_date, 'user');

INSERT INTO TODO(id, description, done, target_date, username) VALUES(10002, 'Learn DevOps', false, current_date, 'user');

INSERT INTO TODO(id, description, done, target_date, username) VALUES(10003, 'Learn Full Stack Development', false, current_date, 'user');
