# Sorting
This directory contains templates/implementations of sorting algorithms: *Quick sort, Merge sort, Radix sort, etc*..

**Note**
Each sorting algorithm is implemented by solving a simple and concise problem to demonstrate its functionality and resulting output.


## **Algorithm: Partition**

### Description
The partition algorithm is a fundamental step in the quicksort algorithm. It divides a set of elements into two parts based on a specified predicate. This README provides details on the input format, output format, and examples for the partition algorithm.

### Problem Statement
#### Input
- The first line of the input file contains the number `N` - the number of elements in the array (0 ≤ `N` ≤ 10^6).
- The second line contains `N` integers `ai`, separated by spaces (-10^9 ≤ `ai` ≤ 10^9).
- The third line contains the pivot element `x` (-10^9 ≤ `x` ≤ 10^9). Note that `x` does not necessarily occur among `ai`.

#### Output
Outputs the result of the algorithm using the "less than x" predicate:
- On the first line, outputs the number of array elements less than `x`.
- On the second line, outputs the number of all others.

#### Example 1
#### Input
```plaintext
5
1 9 4 2 3
3
```

#### Output
```plaintext
2
3
```

#### Example 2
#### Input
```plaintext
0

0
```

#### Output
```plaintext
0
0
```

#### Example 3
#### Input
```plaintext
1
0
0
```

#### Output
```plaintext
0
1
```

### Implementation Notes
To solve the problem, it is recommended implement a function that takes a predicate and a pair of iterators defining an array (or an array and two indices in it) and returns the partition point, i.e., the iterator (index) at the end of the part that contains elements satisfying the specified predicate. This function can then be used to implement sorting.


## **Algorithm: Quick Sort**

### Description
Implementation of quicksort.
At each step, it chooses a pivot element and performs partition around it. Then recursively run the algorithm on the two parts into which the original array is divided.

### Problem Statement
#### Input
- The first line of the input file contains the number `N` — the number of elements in the array (0 ≤ `N` ≤ 10^6).
- The second line contains `N` integers `ai`, separated by spaces (-10^9 ≤ `ai` ≤ 10^9).

#### Output
Prints the result of the sorting, i.e., `N` integers separated by spaces.

#### Example
#### Input
```plaintext
5
1 5 2 4 3
```

#### Output
```plaintext
1 2 3 4 5
```

## Implementation Notes
We can use the function implemented in the partition algorithm.


## **Algorithm: Merge**

### Description
The basic algorithm for merge sort is the merging of two sorted arrays into one ordered array. This operation is performed in linear time with linear memory consumption. Implementation of the merge of two arrays is the first step to write a merge sort.

### Problem Statement
#### Input
- The input file's first line contains the number `N` — the number of elements in the first array (0 ≤ `N` ≤ 10^6).
- The second line contains `N` integers `ai`, separated by spaces, sorted in non-decreasing order (-10^9 ≤ `ai` ≤ 10^9).
- The third line of the input file contains the number `M` — the number of elements in the second array (0 ≤ `M` ≤ 10^6).
- The fourth line contains `M` integers `bi`, separated by spaces, sorted in non-decreasing order (-10^9 ≤ `bi` ≤ 10^9).

#### Output
Outputs the result of merging these two arrays, i.e., `M` + `N` integers separated by spaces, in non-decreasing order.

#### Example 1
#### Input
```plaintext
5
1 3 5 5 9
3
2 5 6
```

#### Output
```plaintext
1 2 3 5 5 6 9
```

#### Example 2
#### Input
```plaintext
1
0
0
```

#### Output
```plaintext
0
```

#### Example 3
#### Input
```plaintext
0
1
0
```

#### Output
```plaintext
0
```

## Implementation Notes
To solve this problem, it is recommended to implement a function that takes two pairs of iterators as input, defining two arrays, and an iterator to the beginning of the buffer where the result should be written. Iterators can be replaced by passing arrays and indices in them. In this form, it will be convenient to use this function to implement the merge sort.


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
