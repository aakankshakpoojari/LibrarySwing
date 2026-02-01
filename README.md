#  Library Management System

*Built with Java Swing + OOP + Data Structures*

https://github.com/aakankshakpoojari/LibrarySwing/blob/main/images/demo.png/

## What's this about?
There are 3 tabs that shows:
- **Books** - Add/search 20+ books (ArrayList + HashMap)
- **Issue** - Queue up book requests (FIFO processing)  
- **Users** - Track users + undo issues (Stack + HashMap)

## What Each Tab Does

| Tab | What it shows | Data Structure |
|-----|---------------|----------------|
| **📚 Books** | Live table + search | `ArrayList<Book>` |
| **📋 Issue** | Request → Process queue | `Queue<String>` |
| **👤 Users** | Add user + undo stack | `HashMap + Stack` |
**No databases/frameworks** - pure Java standard library!

## Tech I Used
OOP : Encapsulation, Inheritance, Polymorphism, Singleton <br>
Data Structures : ArrayList, HashMap, Queue, Stack <br>
Swing GUI : JTable, JTabbedPane, event handling

## How to Run
**VS Code**: F5 on `MainGUI.java`  
**Terminal**: `./run.sh`

## File Structure
src/
├── model/ ← Book classes (inheritance demo)
├── structures/ ← ArrayList/Queue/Stack wrappers
├── service/ ← Singleton LibraryService
└── gui/ ← Swing interface 

Shubham bhavatu 