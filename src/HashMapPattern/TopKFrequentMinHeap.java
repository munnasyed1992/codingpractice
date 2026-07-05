package HashMapPattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentMinHeap {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequentMinHeap(new int[]{3,3,1,1,1,2,2,2}, 2)));
    }

    /*
 ============================================================
  PROBLEM: Top K Frequent Elements (LeetCode #347)
 ============================================================
  Given: array of integers, integer k
  Return: the k most frequent elements (any order)

  Example:
    Input:  nums = [1,1,1,2,2,3], k = 2
    Output: [1, 2]
    (1 appears 3 times, 2 appears 2 times → top 2)

 ============================================================
  PATTERN: HashMap (count) + Min-Heap of size K (filter)
 ============================================================
  Two-stage pipeline:
    Stage 1: HashMap → count frequencies
    Stage 2: Min-Heap of size K → keep only top K frequencies

  THE COUNTER-INTUITIVE TRICK (memorize this!):
  → To find top K LARGEST → use a MIN-heap of size K
  → Why? When heap is full and a bigger element comes,
    we pop the SMALLEST (the weakest survivor gets kicked out).
  → Final K elements in heap = the K largest.

  Analogy: VIP club with K seats. New person arrives →
  bouncer compares them to the WEAKEST current VIP. If new
  person is stronger, kick out the weakest. Final K = top K.

 ============================================================
  WHEN TO USE THIS PATTERN
 ============================================================
  Signals in the problem:
    ✓ "Top K most/largest/highest..."
    ✓ "K closest / K smallest"
    ✓ "Frequencies" + "ranking"
    ✓ Brute force = sort everything → O(n log n) is too slow

  Time:  O(n log k)   — better than sort O(n log n) when k << n
  Space: O(n + k)     — HashMap + heap
 ============================================================
*/
    public static int[] topKFrequentMinHeap(int[] nums, int k) {

        // STEP 1: Count frequency of each number using HashMap
        // Pattern: HashMap frequency counter (key=number, value=count)
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums) {
            // getOrDefault: returns current count if key exists, else 0; then +1
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        // STEP 2: Create a MIN-HEAP that compares by frequency
        // Each heap element is an int[] of length 2:
        //   index 0 = frequency (used for comparison)
        //   index 1 = the actual number (the answer we want)
        //
        // Comparator (a, b) -> a[0] - b[0]:
        //   → a[0] - b[0] is NEGATIVE when a[0] < b[0]
        //   → Negative means "a has higher priority" (comes out first)
        //   → So SMALLER frequency comes out first = MIN-HEAP
        //
        // Memorize: (a, b) -> a - b → min-heap | (a, b) -> b - a → max-heap
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // STEP 3: Process each (number, frequency) pair
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            // Push [frequency, number] into the heap
            queue.offer(new int[]{entry.getValue(), entry.getKey()});

            // KEY MOVE: if heap grows beyond K, kick out the smallest frequency
            // This is what keeps only the TOP K largest frequencies inside.
            if (queue.size() > k) {
                queue.poll();   // removes element with SMALLEST frequency (root of min-heap)
            }
        }

        // STEP 4: Extract the K numbers from the heap
        // The heap now contains exactly K elements — the top K most frequent
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            // poll() returns int[] like [freq, number]
            // We only care about the number → index [1]
            res[i] = queue.poll()[1];
        }
        return res;
    }

/*
 ============================================================
  GOTCHAS TO REMEMBER
 ============================================================
  ⚠️  MIN-heap for top K LARGEST — feels backwards but correct
  ⚠️  Comparator on a[0] (frequency), but extract [1] (number) at end
       Easy to mix up — the heap compares by freq, returns the number
  ⚠️  Storing as int[2] is a common interview trick — could also use
       Map.Entry or a custom class, but int[] is the cleanest
  ⚠️  poll() removes from the TOP of the heap = the MIN element
  ⚠️  When k == nums.length, the if-condition never fires — still works

 ============================================================
  ALTERNATIVE APPROACHES (mention in interview)
 ============================================================
  1. Sort by frequency → O(n log n). Simpler but slower.
  2. Bucket sort → O(n) time. Optimal. Use when interviewer
     asks "can you do better than n log k?"
  3. QuickSelect → O(n) average. Hard to implement under pressure.

  Heap is the "sweet spot" — fast, clean, easy to write live.

 ============================================================
  SIMILAR PROBLEMS USING THIS PATTERN
 ============================================================
  • Kth Largest Element in Array (#215)  — min-heap of size K
  • K Closest Points to Origin (#973)    — max-heap of size K (top K SMALLEST distances)
  • Top K Frequent Words (#692)          — same idea, strings
  • Find K Pairs with Smallest Sums (#373) — heap of size K
  • Merge K Sorted Lists (#23)           — min-heap of list heads

 ============================================================
  HOW TO RECOGNIZE THIS PATTERN NEXT TIME
 ============================================================
  ✅ Problem says "top K", "K most/least", "K closest", "Kth largest"
  ✅ You need to RANK things by some score
  ✅ K is much smaller than N (heap of size K is the win)
  → Reach for PriorityQueue with a custom comparator

  The 2-line decision:
  "Top K LARGEST?"  → MIN-heap of size K, comparator (a,b) -> a-b
  "Top K SMALLEST?" → MAX-heap of size K, comparator (a,b) -> b-a
 ============================================================
*/
}
