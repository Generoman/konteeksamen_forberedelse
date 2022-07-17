insert into players (name, binary_score, multichoice_score)
VALUES ('Person1', 3, 3);
insert into players (name, binary_score, multichoice_score)
VALUES ('Person2', 4, 4);
insert into players (name, binary_score, multichoice_score)
VALUES ('Person3', 0, 0);

insert into binary_questions (question, correct_answer)
VALUES ('Are we there yet?', false);
insert into binary_questions (question, correct_answer)
VALUES ('Are you going to answer this question correctly?', true);
insert into binary_questions (question, correct_answer)
VALUES ('Is "yes" negative?', false);
insert into binary_questions (question, correct_answer)
VALUES ('Are you there?', true);

insert into multichoice_questions (question, correct_answer, answer_0, answer_1, answer_2, answer_3)
VALUES ('Choose "a":', 0, 'a', 'b', 'c', 'd');
insert into multichoice_questions (question, correct_answer, answer_0, answer_1, answer_2, answer_3)
VALUES ('Choose "b":', 1, 'a', 'b', 'c', 'd');
insert into multichoice_questions (question, correct_answer, answer_0, answer_1, answer_2, answer_3)
VALUES ('Choose "c":', 2, 'a', 'b', 'c', 'd');
insert into multichoice_questions (question, correct_answer, answer_0, answer_1, answer_2, answer_3)
VALUES ('Choose "d":', 3, 'a', 'b', 'c', 'd');
