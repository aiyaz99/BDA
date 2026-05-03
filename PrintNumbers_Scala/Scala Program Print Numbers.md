# Scala Program: Print Numbers from 1 to 100

## 📌 Aim

To write and execute a Scala program that prints numbers from 1 to 100 using a `for` loop.

---

## 🛠️ Requirements

* Scala installed on the system
* Java (JDK 8 or above)
* Terminal / Command Prompt

---

## 📄 Program Code

**File Name:** `PrintNumbers.scala`

```scala
object PrintNumbers {
  def main(args: Array[String]): Unit = {
    for(i <- 1 to 100) {
      println(i)
    }
  }
}
```

---

## ⚙️ Steps to Execute

### Step 1: Create the File

```bash
nano PrintNumbers.scala
```

Paste the code and save the file.

---

### Step 2: Compile the Program

```bash
scalac PrintNumbers.scala
```

* This generates bytecode files (`.class` files).
* If no errors appear, compilation is successful.

---

### Step 3: Run the Program

```bash
scala PrintNumbers
```

---

## ✅ Output

The program prints numbers from 1 to 100:

```
1
2
3
...
100
```

---

## 🎯 Conclusion

The Scala program was successfully executed, demonstrating the use of a `for` loop to iterate and print numbers from 1 to 100.

---

