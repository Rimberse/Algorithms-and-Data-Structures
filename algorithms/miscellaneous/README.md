# Miscellaneous
This directory contains templates/implementations of various algorithms.

**Note**
Each algorithm is implemented by solving a simple and concise problem to demonstrate its functionality and resulting output.


## **Algorithm: Distinct from minimum on sequence**

### Description
Given a sequence of integers `a1, a2, ..., an`. Queries are defined: find any element in the sequence in the range from `L` to `R` inclusive, which is not equal to the minimum in that range.

### Problem Statement
#### Input
- The first line contains two integers `N`, 1 ≤ `N` ≤ 100, and `M`, 1 ≤ `M` ≤ 1000 — the length of the sequence and the number of queries, respectively.
- The second line contains the sequence itself, where 0 ≤ `ai` ≤ 1000.
- Starting from the third line, `M` queries are listed, consisting of the boundaries of the range `L` and `R`, where `L`, `R` are indices of the array, numbered from 0..

#### Output
For each query, prints the answer in a separate line — any element in `[L, R]`, except the minimum. If there is no such element, prints `"NOT FOUND"`.

#### Example 1
#### Input
```plaintext
10 5
1 1 1 2 2 2 3 3 3 10
0 1
0 3
3 4
7 9
3 7
```

#### Output
```plaintext
NOT FOUND
2
NOT FOUND
10
3
```

#### Example 2
#### Input
```plaintext
4 2
1 1 1 2
0 2
0 3
```

#### Output
```plaintext
NOT FOUND
2
```


## How to Run
To execute the program, follow these steps:

1. Compile the code
   ```console
   $ javac AlgorithmImplementation.java
   ```
2. Run the program
    ```console
   $ java AlgorithmImplementation
   ```
