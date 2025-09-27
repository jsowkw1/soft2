# soft2
Assignment 1 – Divide and Conquer Algorithms
1. Architecture Notes

MergeSort: implemented with a reusable buffer and small-n cutoff (InsertionSort).

QuickSort: randomized pivot; recursion always goes into the smaller partition, larger one is processed iteratively → depth O(log n).

Deterministic Select: Median-of-Medians (MoM5); recursion only into the necessary side.

Closest Pair: sorted by x, recursive split, “strip” checked in y-order (≤ 7–8 neighbors).

Metrics: time (System.nanoTime()), recursion depth (counter), comparisons/allocations (counters).

2. Recurrence Analysis

MergeSort:
T(n) = 2T(n/2) + Θ(n) → Master Theorem Case 2 → Θ(n log n).

QuickSort:
Average: T(n) ≈ 2T(n/2) + Θ(n) → Θ(n log n).
Worst: T(n) = T(n−1) + Θ(n) → Θ(n²).

Deterministic Select (MoM5):
T(n) = T(n/5) + T(7n/10) + Θ(n). By Akra–Bazzi → Θ(n).

Closest Pair:
T(n) = 2T(n/2) + Θ(n) → Master Theorem Case 2 → Θ(n log n).

3. Experimental Results
   Running time (averaged over multiple runs):

MergeSort: consistent with ~n log n growth.

QuickSort: faster than MergeSort on random data, slower on presorted arrays.

Select: linear trend visible at larger n.

Closest Pair: matches O(n log n); agrees with O(n²) brute force for small n.

Recursion depth:

MergeSort ≈ log₂n.

QuickSort ≤ 2 log₂n (confirmed).

Select and Closest Pair ≈ log₂n.

Constant-factor effects:

JIT warm-up improves later runs.

GC and cache effects dominate at small n.

Large n results align well with theory.

4. Summary

Theory and practice align: MergeSort & Closest Pair → O(n log n), Select → O(n), QuickSort → O(n log n) on average but sensitive to input.

Constant factors (JIT, GC, cache) explain anomalies on small arrays.