delete from bonus_transactions;

insert into bonus_transactions(id, created, transaction_type, bonus_value, transaction_status, execution_date, bonus_program, comment )
values(6, '2021-11-11 02:00:00', 'EARNING', 100 ,'COMPLETED', '2021-11-11 03:00:00', 'BEGINER','FOR CUPCAKES' ) ,
       (9, '2021-11-11 02:20:00', 'EARNING', 500 ,'COMPLETED', '2021-11-11 03:20:00', 'VIP','FOR DELIVERY');