# 📡 Spark Streaming Text Cleaning Application

## 📌 Overview

This project demonstrates a simple **Apache Spark Structured Streaming** application written in Scala.
The program receives real-time text data from a socket, performs basic text preprocessing, and outputs cleaned text to the console.

---

## 🎯 Objective

* To understand **Spark Structured Streaming**
* To process **real-time text data**
* To implement **basic NLP preprocessing techniques**

---

## 🛠️ Technologies Used

* Apache Spark 3.5.0
* Scala 2.12
* Java 8
* Netcat (nc)

---

## 📂 Project Structure

```
Streaming_Spark/
│
├── SparkStreaming.scala      # Main Scala program
├── TextCleaningStream.jar    # Compiled JAR file
└── README.md                 # Project documentation
```

---

## ⚙️ Features

* Reads real-time data from socket (port 9999)
* Converts text to lowercase
* Removes extra whitespace
* Removes punctuation
* Removes stop words
* Performs basic stemming (pseudo-lemmatization)
* Outputs cleaned text to console

---

## 🧠 Processing Steps

1. Input text is received from socket stream
2. Convert text to lowercase
3. Remove extra spaces
4. Remove punctuation
5. Remove stop words
6. Apply simple stemming rules
7. Print cleaned output

---

## 🚀 How to Run the Program

### 🔹 Step 1: Navigate to Project Directory

```bash
cd ~/Documents/Streaming_Spark
```

---

### 🔹 Step 2: Compile the Program

```bash
scalac -cp "$SPARK_HOME/jars/*" SparkStreaming.scala
```

---

### 🔹 Step 3: Create JAR File

```bash
jar -cvf TextCleaningStream.jar *.class
```

---

### 🔹 Step 4: Start Socket Stream (Terminal 1)

```bash
nc -lk 9999
```

---

### 🔹 Step 5: Run Spark Streaming Application (Terminal 2)

```bash
spark-submit \
  --class TextCleaningStream \
  --master local[*] \
  TextCleaningStream.jar
```

---

### 🔹 Step 6: Provide Input

Type any text in **Terminal 1**:

```
This is a streaming TEST!!!
```

---

### 🔹 Step 7: Output (Terminal 2)

```
-------------------------------------------
Batch: 1
-------------------------------------------
this stream test
```

---

## ⚠️ Important Notes

* Ensure **Scala 2.12** is used (compatible with Spark 3.5)
* Use two terminals:

  * Terminal 1 → Input (netcat)
  * Terminal 2 → Spark execution
* Press **Enter** after typing input to send data

---

## 🐞 Common Errors & Fixes

### ❌ Error: NoSuchMethodError (refArrayOps)

**Cause:** Scala version mismatch
**Solution:** Use Scala 2.12

---

### ❌ No Output Displayed

**Cause:** No input sent to socket
**Solution:** Type input in netcat terminal and press Enter

---

## 📈 Limitations

* Uses basic rule-based stemming instead of true lemmatization
* Socket source is not suitable for production use

---

## 🔮 Future Enhancements

* Integrate **Spark NLP** for advanced text processing
* Store output in **HDFS / Database**
* Perform **real-time analytics (word count, sentiment analysis)**

---

## 📚 Conclusion

This project demonstrates how Spark Structured Streaming can be used for real-time text processing and basic NLP tasks. It provides a foundation for building scalable streaming applications.

---

