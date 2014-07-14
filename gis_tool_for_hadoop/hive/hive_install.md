export HIVE_HOME=/home/hduser/hive-0.12.0-cdh5.0.2
export PATH=$HIVE_HOME/bin:$PATH

hdfs dfs -mkdir -p /hive/warehouse


HADOOP_HOME/bin/hadoop fs -mkdir       /tmp
HADOOP_HOME/bin/hadoop fs -mkdir       /user/hive/warehouse
HADOOP_HOME/bin/hadoop fs -chmod g+w   /tmp
HADOOP_HOME/bin/hadoop fs -chmod g+w   /user/hive/warehouse



