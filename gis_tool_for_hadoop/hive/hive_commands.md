CREATE TABLE pokes (foo INT, bar STRING);

show tables;

LOAD DATA LOCAL INPATH './examples/files/kv1.txt' OVERWRITE INTO TABLE pokes;

select * from pokes;
