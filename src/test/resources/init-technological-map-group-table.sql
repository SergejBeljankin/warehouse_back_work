delete
from technological_map_groups;

insert into technological_map_groups(id, code, comment, is_archived, name, parent_technological_map_group_id)
values (1, 'G1', 'coment 1', false, 'Group 1', null),
       (2, 'G2', 'coment 2', false, 'Group 2', null),
       (3, 'G1-1', 'coment 3', false, 'Group 1-1', 1)