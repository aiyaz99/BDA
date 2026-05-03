# 📘 Hadoop MapReduce Program

## Mean Maximum Temperature per Month (NCDC Dataset)

---

## 🎯 Objective

To develop a Hadoop MapReduce program to compute the **average (mean) temperature for each month of each year** using the NCDC weather dataset.

---

## 📂 Dataset

* Source: NCDC weather dataset (GitHub Hadoop book repository)
* Format: Fixed-width text files
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

* Reads each line from dataset
* Extracts:

  * Year
  * Month
  * Temperature
* Filters invalid/missing data
* Outputs:

```
(year-month, temperature)
```

---

### 🔹 Reducer

* Receives list of temperatures for each key
* Computes average:

```
mean = sum / count
```

* Outputs:

```
(year-month, mean temperature)
```

---

## 📁 Project Structure

```
meanmaxtemp/
 ├── MeanMaxMapper.java
 ├── MeanMaxReducer.java
 └── MeanMaxDriver.java
```

---

## ⚙️ Steps to Execute

### 1. Start Hadoop

```
start-dfs.sh
start-yarn.sh
```

---

### 2. Create Input Directory in HDFS

```
hdfs dfs -mkdir /input
```

---

### 3. Upload Dataset

```
hdfs dfs -put 1901.gz /input
hdfs dfs -put 1902.gz /input
```

---

### 4. Run MapReduce Job

```
hadoop jar meanmaxtemp.jar meanmaxtemp.MeanMaxDriver /input /meanmaxtemp_output
```

---

### 5. View Output

```
hdfs dfs -cat /meanmaxtemp_output/part-r-00000
```

---

## 📊 Sample Output

```
1901-01   27
1901-02   30
1901-03   35
...
1902-01   28
1902-02   31
```

---

## ⚠️ Challenges Faced

### 1. Runtime Error

* Issue: `StringIndexOutOfBoundsException`
* Cause: Some lines were shorter than expected
* Solution: Added line length check

---

### 2. Empty Output

* Issue: No output generated initially
* Cause: Incorrect filtering using `TMAX`
* Solution: Removed `TMAX` condition

---

## 💡 Key Learnings

* Importance of handling real-world noisy data
* Understanding Hadoop MapReduce workflow
* Working with compressed `.gz` files directly
* Debugging distributed applications

---

## ✅ Conclusion

The MapReduce program successfully computes the **average temperature for each month across years**, demonstrating efficient processing of large-scale weather data using Hadoop.

---

## 🔚 End of Program

