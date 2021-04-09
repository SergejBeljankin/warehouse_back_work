DELETE FROM technological_maps;

INSERT INTO technological_maps (
    id,
    name,
    comment,
    is_archived,
    production_cost,
    technological_map_group_id
)
VALUES (1, 'Производство стула', 'comments', true, 1.1, null);