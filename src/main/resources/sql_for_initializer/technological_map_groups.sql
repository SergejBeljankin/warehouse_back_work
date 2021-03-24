INSERT INTO technological_map_groups (id, name, code, comment)
VALUES (1, 'Группа 1', 'ТкГ1', 'Первая группа технологических карт');
INSERT INTO technological_map_groups (id, name, code, comment, parent_technological_map_group_id)
VALUES (2, 'Группа 1-1', 'ТкГ1-1', 'Первая подгруппа первой группы технологических карт',1);
INSERT INTO technological_map_groups (id, name, code, comment, parent_technological_map_group_id)
VALUES (3, 'Группа 1-2', 'ТкГ1-2', 'Вторая подгруппа первой группы технологических карт',1);
INSERT INTO technological_map_groups (id, name, code, comment)
VALUES (4, 'Группа 2', 'ТкГ2', 'Вторая группа технологических карт');
INSERT INTO technological_map_groups (id, name, code, comment, parent_technological_map_group_id)
VALUES (5, 'Группа 2-1', 'ТкГ2-1', 'Первая подгруппа второй группы технологических карт',2);
