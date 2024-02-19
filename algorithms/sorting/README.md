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


## **Algorithm: Add Two Fractions**

### Description
Given two rational fractions: `a/b` and `c/d`. Adds them, and represents the result in the form of an irreducible fraction `m/n`.

### Problem Statement
#### Input
- The program receives `4` natural numbers `a, b, c, d`, each of which is not greater than 100.

#### Output
The program should output two natural numbers `m` and `n` such that `m/n` = `a/b` + `c/d` and the fraction `m/n` is in its irreducible form.

#### Example
#### Input
```plaintext
1 2 1 2
```

#### Output
```plaintext
1 1
```


## **Algorithm: Travelling in Moscow**

### Description
During one of his campaigns, an old knight Yury Long-Legged found a huge planar field with an interesting anomaly. When standing on the field, it was only possible to move along specific trajectories: either along the lines that cross a fixed point `K` or along concentric circles centered at the same point. Moving along any other trajectory was impossible.

The knight was so impressed by the place that he decided to build a city on the field. Point `K` was pronounced the center of the knight's lands and the starting point of all roads. But then the knight wondered what minimal distance he will have to travel while walking from point `A` to point `B` on the field.

While moving, one can drop the current trajectory at any moment and pick another arc or radial line passing through one's current location. The distance traveled is the sum of the distances traveled along all radial and circular parts of the route.

### Problem Statement
#### Input
- The first line of the input contains four integers — coordinates of point `A` (`xA` and `yA`) followed by coordinates of point `B` (`xB` and `yB`). Point `K` is located at the origin. All coordinates don't exceed `10^6` by absolute value.

#### Output
Outputs a single number: the minimal distance that knight will have to travel on the way from `A` to `B`. The answer is considered correct if absolute or relative error is no more than `10^-6`.

#### Example 1
#### Input
```plaintext
0 5 4 3
```

#### Output
```plaintext
4.636476090008
```

#### Example 2
#### Input
```plaintext
0 5 4 -3
```

#### Output
```plaintext
10.000000000000
```


## **Algorithm: Anagram**

### Description
There are two strings. Checks if one string is an anagram of the other. An anagram is a string obtained from another by rearranging the letters.

### Problem Statement
#### Input
- The strings consist of lowercase Latin letters, with a maximum length of `100000`. Each one is written on a separate line.

#### Output
Prints `YES` if one of the strings is an anagram of the other and `NO` if it is otherwise.

#### Example 1
#### Input
```plaintext
dusty
study
```

#### Output
```plaintext
YES
```

#### Example 2
#### Input
```plaintext
rat
bat
```

#### Output
```plaintext
NO
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
