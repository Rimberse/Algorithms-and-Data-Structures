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


## **Algorithm: Merge Sort**

### Description
At each step, merge sort algorithm divides the array into two parts, sorts them independently, and merges them using the merge function (implemented in `Merging.java`).

### Problem Statement
#### Input
- The first line of the input file contains the number `N` — the number of elements in the array (0 ≤ `N` ≤ 10^6).
- The second line contains `N` integers `ai`, separated by spaces (-10^9 ≤ `ai` ≤ 10^9).

#### Output
Prints the result of the sort, i.e., `N` integers separated by spaces, in non-decreasing order.

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
It is recommended to use the function implemented in `Merging.java`.


## **Algorithm: Radix Sort**

### Description
Radix sort is one of the sorting algorithms that operates almost in linear time with respect to the size of the array to be sorted. This efficiency is achieved by utilizing the internal structure of the objects being sorted. Initially, this algorithm was used for sorting punched cards. Its first computer implementation was created at `MIT` by `Harold N. Seward`. Let's describe the algorithm in more detail.

Consider an array of strings, `s1, ..., si`, where all strings have the same length, `m`. The algorithm consists of `m` phases. In the `i-th` phase, the strings are sorted based on their `i-th` letter from the end. This process occurs as follows: for simplicity, let's consider strings consisting of digits from `0` to `9` in this task. For each digit, a "bucket" is created, and then the strings `si` are distributed into the "buckets" according to the `i-th` digit from the end. Strings with the `i-th` digit from the end equal to `j` go into the `j-th` bucket (for example, the string `123` will go into the third bucket in the first phase, the second bucket in the second phase, and the first bucket in the third phase). After that, elements are extracted from the buckets in the order of increasing bucket number. Thus, after the first phase, the strings are sorted by the last digit, after two phases - by the last two digits, ..., after `m` phases - by all digits. It is crucial that the elements in the buckets preserve the same order as in the original array (before the start of this phase). For example, if the array before the first phase looks like: `111, 112, 211, 311`, then the elements will be distributed among the buckets as follows: in the first bucket: `111, 211, 311`, and in the second: `112`.

This program clearly demonstrates the operation of this algorithm on a given array.

### Problem Statement
#### Input
- The first line of the input file contains an integer n (1 ≤ `n` ≤ 1000).
- The following `n` lines each contain one string `si`.
- The lengths of all `si` are the same and do not exceed 20.
- All `si` consist only of digits from `0` to `9`.

#### Output
Outputs the original array of strings, the state of the "buckets" after distributing the elements to them for each phase, and the sorted array in the output file. Follows the format given in the example.

## Example
### Input
```plaintext
9
12
32
45
67
98
29
61
35
09
```

#### Output
```plaintext
Initial array:
12, 32, 45, 67, 98, 29, 61, 35, 09
**********
Phase 1
Bucket 0: empty
Bucket 1: 61
Bucket 2: 12, 32
Bucket 3: empty
Bucket 4: empty
Bucket 5: 45, 35
Bucket 6: empty
Bucket 7: 67
Bucket 8: 98
Bucket 9: 29, 09
**********
Phase 2
Bucket 0: 09
Bucket 1: 12
Bucket 2: 29
Bucket 3: 32, 35
Bucket 4: 45
Bucket 5: empty
Bucket 6: 61, 67
Bucket 7: empty
Bucket 8: empty
Bucket 9: 98
**********
Sorted array:
09, 12, 29, 32, 35, 45, 61, 67, 98
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
