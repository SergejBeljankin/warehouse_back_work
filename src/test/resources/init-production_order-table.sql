
insert into projects(id, name, code, description)
values (5, 'name', 'test', 'test');

insert into warehouses(id, address, comment, comment_to_address,
                       name, sort_number)
values (1, 'г.Санкт-Петербург', 'no comment', 'comments','Основной склад', 'test');

insert into technological_maps(id, comment, is_archived, name, production_cost,
                               technological_map_group_id)
values (1, 'comment', true, 'name', 15.00, null);

insert into companies(id, address, chief_accountant, chief_accountant_signature, comment_to_address, email,
                      fax, inn, leader, leader_manager_position, leader_signature, name, payer_vat, phone,
                      sort_number, stamp, legal_detail_id)
values (1, 'г. Москва, ул. 1-Я Магистральная', 'accountant', 'signature', 'comment_to_address', 'email',
        'fax', '1111111111', 'leader', 'position', 'leader_signature', 'name', true, '55-55-55', 'sort_number',
        'stamp', null);

insert into production_orderes(id, comment, date_time, number, plan_date,
                        volume_of_production, company_id, project_id, technological_map_id, warehouse_for_materials_id)
values (1, 'comment', null, '500', '2021-01-01', 10.00, 1 , 5, 1, 1);




