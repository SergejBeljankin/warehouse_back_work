DELETE FROM technological_operations;

INSERT INTO technological_operations(id, number, comments, date, is_archive, volume_of_production, company_id, project_id, warehouse_for_materials_id, warehouse_for_product_id, technological_map_id)
VALUES (1, 'number', 'comments', null , false, 1.1, 1, 1, 1, 1,1)
-- (2, 'numberTwo', 'commentsTwo', null , false, 1.1, 1, 1, 1, 2,1)