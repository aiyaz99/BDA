# 📘 Hadoop MapReduce Program

## Average Temperature per Year (NCDC Dataset)

---

## 🎯 Objective

To develop a Hadoop MapReduce program that computes the **average temperature for each year** using the NCDC weather dataset.

---

## 📂 Dataset

* Source: NCDC dataset (Hadoop GitHub repository)
* Format: Fixed-width weather data
* Files used:

  * `1901.gz`
  * `1902.gz`

---

## 🛠️ Technologies Used

* Java
* Hadoop (HDFS + MapReduce)
* Eclipse IDE
* Ubuntu Linux

---

## 📌 Program Description

### 🔹 Mapper

* Reads each line of input data
* Extracts:

  * Year
  * Temperature
* Filters:

  * Missing values (`9999`)
  * Invalid quality records
* Emits:

```id="y8gq3h"
(year, temperature)
```

---

### 🔹 Reducer

* Receives all temperature values for a year
* Computes:

```id="t4a1fd"
average = sum / count
```

* Emits:

```id="2u2z0z"
(year, average temperature)
```

---

## 📁 Project Structure

```id="3k6u0s"
averagetemp/
 ├── AverageMapper.java
 ├── AverageReducer.java
 └── AverageDriver.java
```

---

## ⚙️ Steps to Execute

### 1. Start Hadoop Services

```id="4r3r4m"
start-dfs.sh
start-yarn.sh
```

---

### 2. Create Input Directory

```id="a4v8iy"
hdfs dfs -mkdir /input
```

---

### 3. Upload Dataset

```id="p71lwv"
hdfs dfs -put 1901.gz /input
hdfs dfs -put 1902.gz /input
```

---

### 4. Run MapReduce Job

```id="l8jj1r"
hadoop jar averagetemp.jar averagetemp.AverageDriver /input /avg_output
```

---

### 5. View Output

```id="6n7glc"
hdfs dfs -cat /avg_output/part-r-00000
```

---

## 📊 Sample Output

```id="zq7v4g"
1901    27
1902    29
```

---

## ⚠️ Challenges Faced

### 1. Runtime Error

* Issue: `StringIndexOutOfBoundsException`
* Cause: Invalid or short lines in dataset
* Solution: Added line length validation

---

### 2. Data Handling

* Issue: Dataset contains noisy records
* Solution: Applied filtering using quality codes

---

## 💡 Key Learnings

* Understanding Hadoop MapReduce workflow
* Processing large datasets efficiently
* Handling real-world noisy data
* Working with compressed `.gz` files directly

---

## ✅ Conclusion

The program successfully calculates the **average yearly temperature**, demonstrating efficient distributed data processing using Hadoop MapReduce.

---

## 🔚 End of Program

