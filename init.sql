CREATE TABLE message (
  id SERIAL PRIMARY KEY,
  message VARCHAR(255) NOT NULL
);

INSERT INTO message (message) VALUES ('Hello, World!');
INSERT INTO message (message) VALUES ('This is a test message.');