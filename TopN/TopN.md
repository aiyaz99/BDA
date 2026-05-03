## MapReduce Program: Top 10 Words with Alphabetical Sorting

---

## 🧾 Problem Statement

For a given text file (`sample1.txt`), develop a **Hadoop MapReduce program** to:

* Count occurrences of each word
* Extract the **Top 10 most frequent words**
* Display them in **alphabetical order**

---

## 🛠️ Technologies Used

* Java
* Apache Hadoop
* Eclipse IDE
* HDFS (Hadoop Distributed File System)

---

## 📂 Project Structure

```
topn/
 ├── SortMapper.java
 ├── SortReducer.java
 ├── SortDriver.java
```

---

## ⚙️ Program Description

### 🔹 Mapper (SortMapper.java)

* Reads input text line by line
* Splits words using tokenizer
* Converts words to lowercase
* Emits key-value pairs:

  ```
  (word, 1)
  ```

---

### 🔹 Reducer (SortReducer.java)

* Aggregates word counts
* Stores results in a HashMap
* Sorts words by frequency (descending)
* Selects **Top 10 words**
* Sorts those Top 10 words **alphabetically**
* Outputs final result

---

### 🔹 Driver (SortDriver.java)

* Configures Hadoop job
* Sets Mapper and Reducer classes
* Defines input and output paths
* Uses **single reducer** for global Top 10

---

## 🧪 Execution Steps

### 1️⃣ Start Hadoop Services

```bash
start-dfs.sh
start-yarn.sh
```

---

### 2️⃣ Create Input Directory in HDFS

```bash
hdfs dfs -mkdir /input
```

---

### 3️⃣ Upload Input File

```bash
hdfs dfs -put sample1.txt /input/
```

---

### 4️⃣ Run MapReduce Job

```bash
hadoop jar topn.jar topn.SortDriver /input /topn_output
```

---

### 5️⃣ View Output

```bash
hdfs dfs -cat /topn_output/part-r-00000
```

---

### 6️⃣ Delete Output Folder (if needed)

```bash
hdfs dfs -rm -r /topn_output
```

---

## 📊 Sample Output

```
apple   50
banana  45
cat     40
dog     38
...
```

✔ Displays **Top 10 most frequent words**
✔ Sorted in **alphabetical order**

---

## ⚠️ Important Notes

* Ensure Hadoop is properly configured
* Output directory must not already exist
* Use `job.setNumReduceTasks(1)` for correct results
* All words are converted to lowercase for consistency

---

## 🎯 Conclusion

This project demonstrates:

* Word count using MapReduce
* Sorting techniques in Reducer
* Efficient handling of large-scale text data

---

## 👨‍💻 Author

Name: Pradeep G
Course: Big Data Analytics Lab

