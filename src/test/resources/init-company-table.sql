DELETE FROM companies;

INSERT INTO companies(id, name, inn, sort_number, phone, fax, email, payer_vat, address, comment_to_address, leader, leader_manager_position, leader_signature, chief_accountant, chief_accountant_signature, stamp, legal_detail_id)
VALUES (1, 'companyName', '24251Inn', '123Sort', '899955222', '899955222', 'c@mail', true, 'c','c','c','c','c','c','c','c',null )