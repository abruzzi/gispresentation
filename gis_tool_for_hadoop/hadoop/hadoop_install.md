- 查看NameNode，DataNode运行情况
可以访问：http://192.168.56.191:50070/

- 执行wordcount任务

首先找到相应的jar：  
      ./hadoop-2.3.0-cdh5.0.2/share/hadoop/mapreduce2/hadoop-mapreduce-examples-2.3.0-cdh5.0.2.jar  

然后使用jar命令：  
      hadoop jar ./hadoop-2.3.0-cdh5.0.2/share/hadoop/mapreduce2/hadoop-mapreduce-examples-2.3.0-cdh5.0.2.jar wordcount /input /output
      


