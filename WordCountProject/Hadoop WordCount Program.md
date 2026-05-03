# 📘 Hadoop WordCount Program using Eclipse

## 👨‍💻 Project Title

WordCount using Hadoop MapReduce (Java + Eclipse)

---

## 🎯 Objective

To implement the WordCount program using Hadoop MapReduce framework, compile it using Eclipse, and execute it on Hadoop.

---

## 🛠️ Software Requirements

* Ubuntu OS
* Java JDK 1.8
* Hadoop 3.3.6
* Eclipse IDE (Java Developers)

---

## 📁 Project Structure

```
WordCountProject/
 ├── wordcount/
 │    ├── WCMapper.java
 │    ├── WCReducer.java
 │    ├── WCDriver.java
 └── wordcount.jar
```

---

## 🧾 Description

The WordCount program counts the frequency of each word in a given input file using MapReduce.

* **Mapper** → Reads input and emits (word, 1)
* **Reducer** → Aggregates counts of each word
* **Driver** → Configures and runs the job

---

## 🧑‍💻 Program Code

### 1. WCMapper.java

* Tokenizes input text into words
* Emits each word with count 1

### 2. WCReducer.java

* Sums occurrences of each word

### 3. WCDriver.java

* Configures MapReduce job
* Sets input and output paths

---

## ⚙️ Steps to Execute

### 🔹 Step 1: Start Hadoop

```bash
start-dfs.sh
start-yarn.sh
```

---

### 🔹 Step 2: Create Input Directory

```bash
hdfs dfs -mkdir /input
```

---

### 🔹 Step 3: Create Input File

```bash
nano input.txt
```

Add:

```
hello hadoop
hello world
big data hadoop
```

---

### 🔹 Step 4: Upload File to HDFS

```bash
hdfs dfs -put input.txt /input
```

---

### 🔹 Step 5: Run WordCount Program

```bash
hadoop jar /home/hadoop/wordcount.jar wordcount.WCDriver /input /output
```

---

### 🔹 Step 6: View Output

```bash
hdfs dfs -cat /output/part-r-00000
```

---

## 📊 Sample Output

```
big 1
data 1
hadoop 2
hello 2
world 1
```

---

## ✅ Result

The WordCount program was successfully executed using Hadoop MapReduce, and the frequency of each word was obtained.

---

## 🧠 Conclusion

This experiment demonstrates how Hadoop processes large datasets using parallel computing through MapReduce.

---

## ⚠️ Notes

* Ensure Java 1.8 is configured
* Add all Hadoop JARs in Eclipse
* Remove output directory before re-running

---

## 🚀 Viva Questions

**Q1: What is Mapper?**
→ Processes input and produces key-value pairs

**Q2: What is Reducer?**
→ Aggregates values for each key

**Q3: What is HDFS?**
→ Distributed file system used by Hadoop

**Q4: Why Combiner is used?**
→ To reduce data transfer between Mapper and Reducer

---

✨ End of Document

