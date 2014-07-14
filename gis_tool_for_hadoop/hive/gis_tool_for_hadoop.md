1. git clone https://github.com/Esri/geometry-api-java.git


export HIVE_AUX_JARS_PATH=/home/hduser/apache-hive-0.13.1-bin/lib


mv esri-geometry-api.jar spatial-sdk-hadoop.jar $HIVE_HOME/lib


add jar /home/hduser/gis-tools-for-hadoop/samples/lib/spatial-sdk-hadoop.jar /home/hduser/gis-tools-for-hadoop/samples/lib/esri-geometry-api.jar;

create temporary function ST_Point as 'com.esri.hadoop.hive.ST_Point';
create temporary function ST_Contains as 'com.esri.hadoop.hive.ST_Contains';

CREATE EXTERNAL TABLE IF NOT EXISTS earthquakes (datetime STRING, latitude DOUBLE, longitude DOUBLE, magnitude DOUBLE)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
LOCATION '/hive/warehouse/earthquakes'
tblproperties ("skip.header.line.count"="1");

CREATE EXTERNAL TABLE IF NOT EXISTS counties (Area string, Perimeter string, State string, County string, Name string, BoundaryShape binary)
ROW FORMAT SERDE 'com.esri.hadoop.hive.serde.JsonSerde'              
STORED AS INPUTFORMAT 'com.esri.json.hadoop.EnclosedJsonInputFormat'
OUTPUTFORMAT 'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'
LOCATION '/hive/warehouse/counties'; 

CREATE EXTERNAL TABLE IF NOT EXISTS counties (Area string, Perimeter string, State string, County string, Name string, BoundaryShape binary)
ROW FORMAT SERDE 'com.esri.hadoop.hive.serde.JsonSerde'
LOCATION '/hive/warehouse/counties'; 

CREATE EXTERNAL TABLE IF NOT EXISTS esri (name string)
ROW FORMAT SERDE 'com.esri.hadoop.hive.serde.JsonSerde'
STORED AS INPUTFORMAT 'com.esri.json.hadoop.EnclosedJsonInputFormat'
OUTPUTFORMAT 'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'
LOCATION '/hive/warehouse/esri';


CREATE EXTERNAL TABLE IF NOT EXISTS my_table (field1 string, field2 int, field3 string, field4 double)
ROW FORMAT SERDE 'org.apache.hadoop.hive.contrib.serde2.JsonSerde'
LOCATION '/hive/warehouse/sample';

add jar
  ${env:HOME}/gis-tools-for-hadoop/samples/lib/esri-geometry-api.jar
  ${env:HOME}/gis-tools-for-hadoop/samples/lib/spatial-sdk-hadoop.jar;

create temporary function ST_Point as 'com.esri.hadoop.hive.ST_Point';
create temporary function ST_Contains as 'com.esri.hadoop.hive.ST_Contains';