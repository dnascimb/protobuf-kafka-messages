# kafka-protobuf-messages
A Kafka Producer and Consumer example using a very basic protobuf schema (message.proto)

Essentially, this repo contains the code (and executable JAR) to demonstrate producing and consuming messages to a Kafka Topic named "messages". There are many changes that one might make to this code if they were to use it in a real world scenario. It's a demo... simply meant to show how protobuf can be used for messaging with Kafka. 

I configured the maven build to produce two JARs to /target. One JAR, uber-protobuf-kafka-messages-1.0-SNAPSHOT.jar, includes all the dependencies that are used by this project. This is the JAR that is executable.


### Running it

Executing the JAR successfully requires Java to be installed. I created/tested it using Java 8.
```shell
MacBook-Pro:bin dan$ java -version
java version "1.8.0"
Java(TM) SE Runtime Environment (build 1.8.0-b132)
Java HotSpot(TM) 64-Bit Server VM (build 25.0-b70, mixed mode)
```

Also required, a running Kafka instance available via localhost:9092 (I hardcoded the port due to 
unfortunate time constraints). I tested using Confluent 4.0.0. You can download + install 
the Confluent Kafka distribution here: https://docs.confluent.io/current/quickstart.html


### Building it

Requires Java and Maven. I used Java 8 and Maven 3.2.1.
```shell
MacBook-Pro:kafka-protobuf-messages dan$ mvn -version
Apache Maven 3.2.1 (ea8b2b07643dbb1b84b6d16e1f08391b666bc1e9; 2014-02-14T09:37:52-08:00)
Maven home: /Applications/apache-maven-3.2.1
Java version: 1.8.0, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.13.2", arch: "x86_64", family: "mac"
```

Once Java and Maven are installed, run 'mvn clean package':
```shell
MacBook-Pro:kafka-protobuf-messages dan$ mvn clean package
[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for protobuf-kafka-messages:protobuf-kafka-messages:jar:1.0-SNAPSHOT
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-shade-plugin is missing. @ line 104, column 21
[WARNING] 
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING] 
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING] 
[INFO] 
[INFO] Using the builder org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder with a thread count of 1
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building protobuf-kafka-messages 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
Downloading: http://maven.davidtrott.com/repository/org/apache/maven/plugins/maven-shade-plugin/maven-metadata.xml
[WARNING] Could not transfer metadata org.apache.maven.plugins:maven-shade-plugin/maven-metadata.xml from/to dtrott-public (http://maven.davidtrott.com/repository): maven.davidtrott.com: unknown error
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ protobuf-kafka-messages ---
[INFO] Deleting /Users/dan/Documents/workspace/kafka-protobuf-messages/target
[INFO] 
[INFO] --- protoc-jar-maven-plugin:2.6.1.4:run (default) @ protobuf-kafka-messages ---
[INFO] Include directories:
[INFO]     /Users/dan/Documents/workspace/kafka-protobuf-messages/src/main/proto
[INFO] Input directories:
[INFO]     /Users/dan/Documents/workspace/kafka-protobuf-messages/src/main/proto
[INFO] Output targets:
[INFO]     java: /Users/dan/Documents/workspace/kafka-protobuf-messages/target/generated-sources (add: main, clean: false)
[INFO] /Users/dan/Documents/workspace/kafka-protobuf-messages/target/generated-sources does not exist. Creating...
[INFO]     Processing (java): message.proto
protoc-jar: protoc version: 261, detected platform: mac os x/x86_64
protoc-jar: executing: [/var/folders/6g/2tnxyc2d3ml3q_mpqkmfbt2m0000gn/T/protoc459055611055815488.exe, -I/Users/dan/Documents/workspace/kafka-protobuf-messages/src/main/proto, -I/Users/dan/Documents/workspace/kafka-protobuf-messages/src/main/proto, --java_out=/Users/dan/Documents/workspace/kafka-protobuf-messages/target/generated-sources, /Users/dan/Documents/workspace/kafka-protobuf-messages/src/main/proto/message.proto]
[INFO] Adding generated classes to classpath
[INFO] 
[INFO] --- maven-dependency-plugin:2.8:copy-dependencies (default) @ protobuf-kafka-messages ---
[INFO] Copying netty-3.7.0.Final.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/netty-3.7.0.Final.jar
[INFO] Copying metrics-core-3.1.2.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/metrics-core-3.1.2.jar
[INFO] Copying log4j-1.2.17.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/log4j-1.2.17.jar
[INFO] Copying snappy-java-1.1.1.7.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/snappy-java-1.1.1.7.jar
[INFO] Copying jline-0.9.94.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/jline-0.9.94.jar
[INFO] Copying jopt-simple-3.2.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/jopt-simple-3.2.jar
[INFO] Copying hamcrest-core-1.3.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/hamcrest-core-1.3.jar
[INFO] Copying protoc-jar-2.6.1.4.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/protoc-jar-2.6.1.4.jar
[INFO] Copying slf4j-log4j12-1.7.25.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/slf4j-log4j12-1.7.25.jar
[INFO] Copying kafka-clients-0.9.0.0.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/kafka-clients-0.9.0.0.jar
[INFO] Copying junit-4.12.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/junit-4.12.jar
[INFO] Copying slf4j-api-1.7.25.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/slf4j-api-1.7.25.jar
[INFO] Copying zkclient-0.3.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/zkclient-0.3.jar
[INFO] Copying metrics-core-2.2.0.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/metrics-core-2.2.0.jar
[INFO] Copying zookeeper-3.4.6.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/zookeeper-3.4.6.jar
[INFO] Copying kafka_2.10-0.8.2.2.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/kafka_2.10-0.8.2.2.jar
[INFO] Copying scala-library-2.10.4.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/scala-library-2.10.4.jar
[INFO] Copying lz4-1.2.0.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/lz4-1.2.0.jar
[INFO] Copying protobuf-java-2.6.1.jar to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/lib/protobuf-java-2.6.1.jar
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ protobuf-kafka-messages ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/dan/Documents/workspace/kafka-protobuf-messages/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.3:compile (default-compile) @ protobuf-kafka-messages ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 7 source files to /Users/dan/Documents/workspace/kafka-protobuf-messages/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ protobuf-kafka-messages ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/dan/Documents/workspace/kafka-protobuf-messages/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.3:testCompile (default-testCompile) @ protobuf-kafka-messages ---
[INFO] No sources to compile
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ protobuf-kafka-messages ---
[INFO] No tests to run.
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ protobuf-kafka-messages ---
[INFO] Building jar: /Users/dan/Documents/workspace/kafka-protobuf-messages/target/protobuf-kafka-messages.jar
[INFO] 
[INFO] --- maven-shade-plugin:3.1.0:shade (default) @ protobuf-kafka-messages ---
[INFO] Including io.dropwizard.metrics:metrics-core:jar:3.1.2 in the shaded jar.
[INFO] Including org.apache.kafka:kafka-clients:jar:0.9.0.0 in the shaded jar.
[INFO] Including org.xerial.snappy:snappy-java:jar:1.1.1.7 in the shaded jar.
[INFO] Including net.jpountz.lz4:lz4:jar:1.2.0 in the shaded jar.
[INFO] Including org.apache.kafka:kafka_2.10:jar:0.8.2.2 in the shaded jar.
[INFO] Including com.yammer.metrics:metrics-core:jar:2.2.0 in the shaded jar.
[INFO] Including org.scala-lang:scala-library:jar:2.10.4 in the shaded jar.
[INFO] Including org.apache.zookeeper:zookeeper:jar:3.4.6 in the shaded jar.
[INFO] Including jline:jline:jar:0.9.94 in the shaded jar.
[INFO] Including io.netty:netty:jar:3.7.0.Final in the shaded jar.
[INFO] Including net.sf.jopt-simple:jopt-simple:jar:3.2 in the shaded jar.
[INFO] Including com.101tec:zkclient:jar:0.3 in the shaded jar.
[INFO] Including org.slf4j:slf4j-api:jar:1.7.25 in the shaded jar.
[INFO] Including org.slf4j:slf4j-log4j12:jar:1.7.25 in the shaded jar.
[INFO] Including log4j:log4j:jar:1.2.17 in the shaded jar.
[INFO] Including com.google.protobuf:protobuf-java:jar:2.6.1 in the shaded jar.
[INFO] Including com.github.os72:protoc-jar:jar:2.6.1.4 in the shaded jar.
[INFO] Replacing /Users/dan/Documents/workspace/kafka-protobuf-messages/target/uber-protobuf-kafka-messages-1.0-SNAPSHOT.jar with /Users/dan/Documents/workspace/kafka-protobuf-messages/target/protobuf-kafka-messages-1.0-SNAPSHOT-shaded.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 4.879 s
[INFO] Finished at: 2018-02-01T11:14:20-08:00
[INFO] Final Memory: 19M/148M
[INFO] ------------------------------------------------------------------------
MacBook-Pro:kafka-protobuf-messages dan$ 
```

2. Start Confluent
```shell
MacBook-Pro:bin dan$ confluent start

Starting zookeeper
zookeeper is [UP]
Starting kafka
kafka is [UP]
Starting schema-registry
schema-registry is [UP]
Starting kafka-rest
kafka-rest is [UP]
Starting connect
connect is [UP]
```

3. Run the JAR
```shell
MacBook-Pro:kafka-protobuf-messages dan$ java -jar target/uber-protobuf-kafka-messages-1.0-SNAPSHOT.jar

log4j:WARN No appenders could be found for logger (org.apache.kafka.clients.producer.ProducerConfig).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
starting MessageProducer
starting MessageConsumer
Sent message: (1, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user1"
user_guid: "24fb6457-9e4b-418c-a301-0442bb309946"
event_data: "{ \"event\": \"LOGIN\" }"
)
Sent message: (2, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user2"
user_guid: "e011c8cc-dfb9-485e-b171-b459e75038ee"
event_data: "{ \"event\": \"LOGIN\" }"
)
Sent message: (3, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user3"
user_guid: "776c3c86-2dde-4a2d-8dd8-3bb9171611b0"
event_data: "{ \"event\": \"LOGIN\" }"
)
Sent message: (4, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user4"
user_guid: "1cc73da1-95e6-4f4b-a04a-4704b5a3a32c"
event_data: "{ \"event\": \"LOGIN\" }"
)
Sent message: (5, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user5"
user_guid: "272a3427-096a-44fc-8e36-199161e0dd21"
event_data: "{ \"event\": \"LOGIN\" }"
)
Sent message: (6, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user6"
user_guid: "69e5b6d5-fb72-4784-8c41-d3f2be46fcfa"
event_data: "{ \"event\": \"LOGIN\" }"
)
Sent message: (7, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user7"
user_guid: "b81799e6-e48a-431a-b1e9-b9584f6809a3"
event_data: "{ \"event\": \"LOGIN\" }"
)
Sent message: (8, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user8"
user_guid: "478860a7-7efe-489e-9c3a-6be0e963e553"
event_data: "{ \"event\": \"LOGIN\" }"
)
Sent message: (9, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user9"
user_guid: "f2ba71a9-7c76-443e-9c5b-6ecc7e127175"
event_data: "{ \"event\": \"LOGIN\" }"
)
Sent message: (10, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user10"
user_guid: "6d7aa32f-9fea-4fc9-804b-248c73df1d0b"
event_data: "{ \"event\": \"LOGIN\" }"
)
Received message: (1, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user1"
user_guid: "24fb6457-9e4b-418c-a301-0442bb309946"
event_data: "{ \"event\": \"LOGIN\" }"
) at offset 20
Received message: (2, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user2"
user_guid: "e011c8cc-dfb9-485e-b171-b459e75038ee"
event_data: "{ \"event\": \"LOGIN\" }"
) at offset 21
Received message: (3, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user3"
user_guid: "776c3c86-2dde-4a2d-8dd8-3bb9171611b0"
event_data: "{ \"event\": \"LOGIN\" }"
) at offset 22
Received message: (4, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user4"
user_guid: "1cc73da1-95e6-4f4b-a04a-4704b5a3a32c"
event_data: "{ \"event\": \"LOGIN\" }"
) at offset 23
Received message: (5, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user5"
user_guid: "272a3427-096a-44fc-8e36-199161e0dd21"
event_data: "{ \"event\": \"LOGIN\" }"
) at offset 24
Received message: (6, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user6"
user_guid: "69e5b6d5-fb72-4784-8c41-d3f2be46fcfa"
event_data: "{ \"event\": \"LOGIN\" }"
) at offset 25
Received message: (7, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user7"
user_guid: "b81799e6-e48a-431a-b1e9-b9584f6809a3"
event_data: "{ \"event\": \"LOGIN\" }"
) at offset 26
Received message: (8, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user8"
user_guid: "478860a7-7efe-489e-9c3a-6be0e963e553"
event_data: "{ \"event\": \"LOGIN\" }"
) at offset 27
Received message: (9, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user9"
user_guid: "f2ba71a9-7c76-443e-9c5b-6ecc7e127175"
event_data: "{ \"event\": \"LOGIN\" }"
) at offset 28
Received message: (10, created_datetime: "Thu Feb 01 11:14:43 PST 2018"
user_id: "user10"
user_guid: "6d7aa32f-9fea-4fc9-804b-248c73df1d0b"
event_data: "{ \"event\": \"LOGIN\" }"
) at offset 29
```


