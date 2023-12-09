# Sorting

This directory contains templates/implementations of sorting algorithms: *Quick sort, Merge sort, Radix sort, etc*..

## Note

Each sorting algorithm is implemented by solving a simple and concise problem to demonstrate its functionality and resulting output.

# **Algorithm: Partition**

## Description

The partition algorithm is a fundamental step in the quicksort algorithm. It divides a set of elements into two parts based on a specified predicate. This README provides details on the input format, output format, and examples for the partition algorithm.

## Problem Statement

### Input

- The first line of the input file contains the number `N` - the number of elements in the array (0 ≤ N ≤ 106).
- The second line contains `N` integers `ai`, separated by spaces (-109 ≤ ai ≤ 109).
- The third line contains the pivot element `x` (-109 ≤ x ≤ 109). Note that `x` does not necessarily occur among `ai`.

### Output

Outputs the result of the algorithm using the "less than x" predicate:
- On the first line, outputs the number of array elements less than `x`.
- On the second line, outputs the number of all others.

### Example 1

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

### Example 2

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

### Example 3
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

## Implementation Notes
To solve the problem, we could implement a function that takes a predicate and a pair of iterators defining an array (or an array and two indices in it) and returns the partition point, i.e., the iterator (index) at the end of the part that contains elements satisfying the specified predicate. This function can then be used to implement sorting.