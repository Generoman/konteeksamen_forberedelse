create
database QuizGame;

use
QuizGame;

create table players
(
    id                int not null auto_increment primary key,
    name              varchar(255),
    binary_score      int,
    multichoice_score int
);

create table binary_questions
(
    id             int not null auto_increment primary key,
    question       varchar(255),
    correct_answer bool
);

create table multichoice_questions
(
    id             int not null auto_increment primary key,
    question       varchar(255),
    correct_answer int,
    answer_0       varchar(255),
    answer_1       varchar(255),
    answer_2       varchar(255),
    answer_3       varchar(255)
);