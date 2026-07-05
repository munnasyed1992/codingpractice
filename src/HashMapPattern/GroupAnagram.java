package HashMapPattern;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        //System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagram2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,ArrayList<String>> map=new HashMap<>();
        for(String s : strs){
            //we are sorting because after sorting each anagram which are same category will be equal
            //so we can use it as key and add remaining as value
            char [] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key,k -> new ArrayList<>()).add(s);
            /*if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);*/


        }
        return new ArrayList<>(map.values());

    }

    /*
 ============================================================
  PROBLEM: Group Anagrams (LeetCode #49)
 ============================================================
  Given: array of strings
  Return: anagrams grouped together

  Example:
    Input:  ["eat","tea","tan","ate","nat","bat"]
    Output: [["eat","tea","ate"],["tan","nat"],["bat"]]

 ============================================================
  PATTERN: HashMap — Canonical Key Grouping
 ============================================================
  Trick: All anagrams share the same letter frequencies.
  → Build a "fingerprint" from letter counts.
  → Use fingerprint as HashMap key to bucket anagrams together.

  Two ways to build the fingerprint:
    1. Sort the string  → "eat" → "aet"   (O(k log k) per word)
    2. Count letters    → "eat" → "#1#0...#1..." (O(k) per word) ← THIS solution

 ============================================================
  WHEN TO USE THIS PATTERN
 ============================================================
  → "Group items that share property X"
  → "Find all items that are equivalent under transformation"
  → Brute force compares every pair → O(n²) → use HashMap to drop to O(n)

  Key questions to ask yourself:
    1. What is the "canonical form" (fingerprint) of each item?
    2. Can I use that fingerprint as a HashMap key?

  Time:  O(n * k)    Space: O(n * k)
 ============================================================
*/
    public static List<List<String>> groupAnagram2(String[] strs) {

        // key = fingerprint string, value = group of anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            // STEP 1: Count letters in this word
            // Trick: int[26] for lowercase, index using (c - 'a')
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;   // 'a'→0, 'b'→1, ..., 'z'→25
            }

            // STEP 2: Build fingerprint string from count array
            // WHY '#'? Prevents collision: [1,11] vs [11,1] would both → "111" without separator
            //                              with '#' → "#1#11" vs "#11#1" → distinct
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#").append(count[i]);
            }
            String key = sb.toString();
            // Example for "eat": "#1#0#0#0#1#0...#1#0...#0"
            //                     ↑a       ↑e        ↑t

            // STEP 3: Add word to its anagram group
            // computeIfAbsent = "if key missing, create empty list; then return the list"
            // Saves us from writing: if(!map.containsKey()) { map.put(k, new ArrayList<>()) }
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        // Only the groups matter, not the fingerprint keys
        return map.values().stream().toList();
    }

/*
 ============================================================
  GOTCHAS TO REMEMBER
 ============================================================
  ⚠️  Don't forget '#' separator — silent bug, hard to catch
  ⚠️  int[26] only works for lowercase a-z. For mixed case or unicode → use HashMap<Character, Integer>
  ⚠️  StringBuilder, not String concatenation, inside the loop (performance)

 ============================================================
  SIMILAR PROBLEMS THAT USE THIS PATTERN
 ============================================================
  • Valid Anagram (#242)              — frequency comparison
  • Find All Anagrams in String (#438) — frequency + sliding window
  • Find Duplicate File in System (#609) — group by file content (canonical key)
  • Isomorphic Strings (#205)          — canonical mapping

 ============================================================
  HOW TO RECOGNIZE THIS PATTERN NEXT TIME
 ============================================================
  ✅ Problem says "group by", "find all X that are similar/equivalent"
  ✅ Brute force is comparing every pair → O(n²)
  ✅ You can describe each item with a unique "fingerprint"
  → Reach for HashMap<fingerprint, List<original>>
 ============================================================
*/


    }

