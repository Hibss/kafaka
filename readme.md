本地需要安装zookeeper&&kafka;
启动工程前,需要启动zookeeper&&kafka;
工程使用了springBoot的devTools进行热部署
查看topic list:
.\bin\windows\kafka-topics.bat --list --zookeeper 127.0.0.1:2181

查看topic状态
.\bin\windows\kafka-topics.bat --describe --zookeeper 127.0.0.1:2181 --topic shengyuanzhou

控制台发送消息:

.\bin\windows\kafka-console-producer.bat --broker-list 127.0.0.1:9092 --topic shengyuanzhou

控制台接收消息:

.\bin\windows\kafka-console-consumer.bat --zookeeper 127.0.0.1:2181 --topic shengyuanzhou --from-beginning