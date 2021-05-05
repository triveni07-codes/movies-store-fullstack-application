CREATE TABLE IF NOT EXISTS MOVIES (
   ID   INT PRIMARY KEY,
   TITLE VARCHAR (100)     NOT NULL,
   DESCRIPTION  VARCHAR (200)   NOT NULL,
   IMAGE_URL  VARCHAR (500)  NOT NULL,
   WATCHED  BOOLEAN NOT NULL DEFAULT FALSE
);

INSERT INTO MOVIES
(ID, TITLE, DESCRIPTION, IMAGE_URL, WATCHED)
VALUES (1000, 'The Avengers', 'New York blows up in this!', 'http://d21lz9b0v8r1zn.cloudfront.net/wp-content/uploads//2012/03/detail.jpg', FALSE);

INSERT INTO MOVIES
(ID, TITLE, DESCRIPTION, IMAGE_URL, WATCHED)
VALUES (1001, 'Dark City', 'This looks mysterious. Cool!', 'https://i.chzbgr.com/full/5569379584/hA96709E0/', FALSE);

INSERT INTO MOVIES
(ID, TITLE, DESCRIPTION, IMAGE_URL, WATCHED)
VALUES (1002, 'Matrix', 'Something different to try!', 'https://m.media-amazon.com/images/I/71F0pogpAmL._SL1382_.jpg', FALSE);

INSERT INTO MOVIES
(ID, TITLE, DESCRIPTION, IMAGE_URL, WATCHED)
VALUES (1003, 'John Carter', 'He is super cool!', 'https://gdj-inr5u0ip5pewom.stackpathdns.com/wp-content/uploads/2012/03/movies-poster-20.jpg', FALSE);

INSERT INTO MOVIES
(ID, TITLE, DESCRIPTION, IMAGE_URL, WATCHED)
VALUES (1004, 'Harry Potter ', 'Its mysterious!', 'https://maxcdn.icons8.com/app/uploads/2019/05/poster-for-movie.png', FALSE);

INSERT INTO MOVIES
(ID, TITLE, DESCRIPTION, IMAGE_URL, WATCHED)
VALUES (1005, 'The Dark Knight', 'This looks mysterious. Cool!', 'https://qph.fs.quoracdn.net/main-qimg-d96cc1808f88d15a62633841e6e2efe0', FALSE);

commit;