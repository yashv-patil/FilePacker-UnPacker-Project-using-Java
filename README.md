# Java File Packer & Unpacker

## 📌 Overview

The **Java File Packer & Unpacker** is a Java-based file handling application that allows multiple files from a folder to be **packed into a single file** and later **unpacked back into their original files**.

The project uses **Java File I/O, byte streams, file metadata, and Java Swing** to implement the packing and unpacking operations.

The Packer stores each file's **name, size, and data** inside a single pack file using a fixed **100-byte header** followed by the file's data.

---

## 🚀 Features

* 📦 Pack multiple files into a single pack file
* 📂 Unpack files from a packed file
* 🖥️ Simple Java Swing GUI
* 📄 Stores file name and file size in the header
* 💾 Uses `FileInputStream` and `FileOutputStream`
* 🔢 Uses byte buffers for file data processing
* 🧩 Fixed 100-byte header for each packed file
* ⚡ Automatically closes the GUI after Pack/Unpack operation
* 🛡️ Basic file and exception handling

---

## 📂 Project Structure

```text
PackerUnpacker/
│
├── Data/
│   ├── File1
│   ├── File2
│   └── File3
│
├── FilePacker.java
├── FileUnpacker.java
└── README.md
```

### 📁 Data Folder

The `Data` folder contains sample files used to test the packing and unpacking functionality.

### 📦 FilePacker.java

Responsible for:

* Taking the source folder name
* Taking the pack file name
* Reading files from the folder
* Creating a 100-byte header
* Writing file information and data into the pack file

### 📤 FileUnpacker.java

Responsible for:

* Taking the pack file name
* Reading the 100-byte header
* Extracting the file name and file size
* Creating the original file
* Reading and writing the stored file data

---

## 🔄 How It Works

### 📦 Packing Process

The Packer takes all files from the specified folder and stores them sequentially inside one pack file.

```text
Data Folder
    │
    ├── File1
    ├── File2
    └── File3
          │
          ▼
   ┌───────────────┐
   │ FilePacker.java│
   └───────┬───────┘
           │
           ▼
      Packed File
```

For every file, the Packer creates a **100-byte header** containing:

```text
File Name + File Size + Padding Spaces
```

The structure inside the packed file is:

```text
┌──────────────────────┬──────────────────────┐
│ 100 Byte Header      │ File Data            │
├──────────────────────┼──────────────────────┤
│ File Name + Size     │ Original File Bytes  │
└──────────────────────┴──────────────────────┘
```

This process is repeated for every file in the folder.

---

### 📤 Unpacking Process

The Unpacker reads the packed file sequentially.

```text
      Packed File
           │
           ▼
   ┌─────────────────┐
   │ FileUnpacker.java│
   └────────┬────────┘
            │
            ▼
     Read 100 Byte Header
            │
            ▼
     Get File Name & Size
            │
            ▼
       Read File Data
            │
            ▼
       Create New File
```

The Unpacker continues reading headers and file data until all files stored in the packed file are extracted.

---

## 🖥️ GUI

Both applications use **Java Swing** for their graphical interface.

### 📦 File Packer

The Packer GUI provides:

* Folder Name input
* Pack File Name input
* Pack button

```text
┌─────────────────────────────┐
│      Java File Packer       │
│                             │
│ Folder Name that Exist:     │
│ [________________________]  │
│                             │
│ Pack File Name:             │
│ [________________________]  │
│                             │
│          [ Pack ]           │
│                             │
└─────────────────────────────┘
```

### 📤 File Unpacker

The Unpacker GUI provides:

* Pack File Name input
* Unpack button

```text
┌─────────────────────────────┐
│     Java File Un-Packer     │
│                             │
│ Pack File Name:             │
│ [________________________]  │
│                             │
│        [ Unpack ]           │
│                             │
└─────────────────────────────┘
```

---

## 🛠️ Technologies Used

* **Language:** Java
* **GUI:** Java Swing
* **File Handling:** Java I/O
* **Input Stream:** `FileInputStream`
* **Output Stream:** `FileOutputStream`
* **File Management:** `File`
* **Buffer:** `byte[]`
* **Event Handling:** Swing ActionListener / Lambda Expression
* **Threading:** `Runnable`

---

## ▶️ How to Run

### 1️⃣ Compile FilePacker

Open the terminal inside the project folder:

```bash
javac FilePacker.java
```

### 2️⃣ Run FilePacker

```bash
java FilePacker
```

Enter the folder containing the files.

For example:

```text
Folder Name:
Data
```

Then enter the pack file name:

```text
Pack File Name:
MyPack.pack
```

The files inside the `Data` folder will be packed into `MyPack.pack`.

---

### 3️⃣ Compile FileUnpacker

```bash
javac FileUnpacker.java
```

### 4️⃣ Run FileUnpacker

```bash
java FileUnpacker
```

Enter the name of the packed file:

```text
Pack File Name:
MyPack.pack
```

The files stored inside the pack file will be extracted.

---

## 💻 Example

### Before Packing

```text
PackerUnpacker/
│
├── Data/
│   ├── File1
│   ├── File2
│   └── File3
│
├── FilePacker.java
└── FileUnpacker.java
```

Run:

```bash
java FilePacker
```

Enter:

```text
Folder Name: Data
Pack File Name: MyPack.pack
```

After successful packing:

```text
PackerUnpacker/
│
├── Data/
│   ├── File1
│   ├── File2
│   └── File3
│
├── MyPack.pack
├── FilePacker.java
└── FileUnpacker.java
```

Now run:

```bash
java FileUnpacker
```

Enter:

```text
Pack File Name: MyPack.pack
```

The files stored in `MyPack.pack` are extracted again.

---

## 🎯 Learning Objectives

This project helped in understanding:

* Java File Handling
* File Input and Output Streams
* Byte Stream Operations
* Reading and Writing Binary Data
* File Metadata
* Byte Arrays and Buffers
* Exception Handling
* Java Swing GUI
* Event Handling
* Lambda Expressions
* `Runnable` Interface
* File Packing and Unpacking Logic

---

## 🔮 Future Enhancements

* 🎨 Improve the GUI design
* 📊 Add a progress bar for packing and unpacking
* 📁 Add file/folder selection using `JFileChooser`
* 🗜️ Add file compression
* 🔐 Add password protection
* ✅ Add better input validation
* ⚠️ Improve error messages in the GUI
* 📋 Display packing and unpacking status directly in the application

---

## 🤝 Contributions

Suggestions, improvements, and pull requests are welcome.

---

## 👨‍💻 Author

**Yash Patil**

MCA Graduate | Java Developer | Software Developer
