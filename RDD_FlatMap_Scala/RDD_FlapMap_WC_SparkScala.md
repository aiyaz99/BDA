# Apache Spark RDD Program: Word Count using FlatMap

## 📌 Aim

To count the frequency of each word in a text file using **RDD transformations (flatMap, map, reduceByKey)** and display only those words whose count is **greater than 4**.

---

## 🛠️ Requirements

* Apache Spark installed
* Scala installed
* Java (JDK 8 or above)
* Input file (`wc_input.txt`)

---

## 📂 Sample Input (`wc_input.txt`)

```text
hello spark hello hadoop hello spark big data spark hello spark
big data spark hello hadoop spark hello
```

---

## ⚙️ Steps to Execute (Using Spark Shell)

### Step 1: Start Spark Shell

```bash
spark-shell
```

---

### Step 2: Read Input File

```scala
val textFile = sc.textFile("wc_input.txt")
```

---

### Step 3: Split Lines into Words

```scala
val words = textFile.flatMap(line => line.split("\\s+"))
```

---

### Step 4: Convert to Key-Value Pairs

```scala
val pairs = words.map(word => (word, 1))
```

---

### Step 5: Count Word Frequencies

```scala
val counts = pairs.reduceByKey(_ + _)
```

---

### Step 6: Filter Words (Count > 4)

```scala
val result = counts.filter { case (_, count) => count > 4 }
```

---

### Step 7: Display Output

```scala
result.collect().foreach(println)
```

---

## ✅ Output (Example)

```text
(hello,6)
(spark,7)
```

---

## 🔍 Explanation

* **flatMap()** → Splits each line into individual words
* **map()** → Converts each word into `(word, 1)` pair
* **reduceByKey()** → Aggregates counts of each word
* **filter()** → Selects words with frequency greater than 4
* **collect()** → Retrieves results to driver for display

---

## 🎯 Conclusion

The program successfully demonstrates how Apache Spark RDD transformations can be used to perform efficient word count and filtering operations on large datasets.

---

