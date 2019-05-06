# Apache Lucene Analyzer / Elasticsearch Analyzer Example

## Prerequisites
- Java 8+
- Gradle
- Docker

## 1. Apache Lucene Analyzer
 
* This repository is for testing Apache Lucene Analyzer(version 8.0.0). You can check following examples in `example` directory.
- SimpleAnalyzer
- StandardAnalyzer
- StopAnalyzer
- WhiteSpaceAnalyzer
- CustomAnalyzer

## 2. Elasticsearch
If you run the command like this, you will have the elasticsearch 7.0.0 and kibana 7.0.0 locally.

```
docker-compose up --build
```

### 2.1 run Elasticsearch
If you run this command, you can check if the elasticsearch run.
```
 curl localhost:9200
```

You can get the result like this.
```
{
  "name" : "elasticsearch1",
  "cluster_name" : "docker-cluster",
  "cluster_uuid" : "iPf7AL4pT2mRJ9kYp4raPA",
  "version" : {
    "number" : "7.0.0",
    "build_flavor" : "default",
    "build_type" : "docker",
    "build_hash" : "b7e28a7",
    "build_date" : "2019-04-05T22:55:32.697037Z",
    "build_snapshot" : false,
    "lucene_version" : "8.0.0",
    "minimum_wire_compatibility_version" : "6.7.0",
    "minimum_index_compatibility_version" : "6.0.0-beta1"
  },
  "tagline" : "You Know, for Search"
}
```

### 2.2 Kibana run
If you can check Kibana on your browser with this URL.
```
localhost:5201
```

You can run the analyzer test on devtools in Kibana. It has some analyzer examples in `elasticsearch_example.txt` in resource directory.

### 2.3 How to stop
You can run this command.
```
docker-compose stop
```