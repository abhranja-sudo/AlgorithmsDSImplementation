package com.ar50645.recursion;

/*
WordBreakProblem: Given a String S, which contains letters and no spaces, determine if you can break it into valid words.
 Return one such combination of words.You can assume that you are provided a dictionary of English words.
 For example:S = "ilikemangotango"
 Output:Return any one of these:
 "i like mango tango"
 "i like man go tan go"
 "i like mango tan go"
 "i like man go tango"
 */
import java.util.*;

public class WordBreak {
    public enum Memo {
        NOT_FOUND,
        UNVISITED
    }

    public static List<String> wordBreak(String s, Set<String> dictionary){
        if(s == null)   return null;
        List<String> result = new ArrayList<>();
        Memo[] memos = new Memo[s.length()];
        Arrays.fill(memos, Memo.UNVISITED);
        wordBreak(s, dictionary, 0, 0, result, memos);
        return result;
    }

    private static boolean wordBreak(String s, Set<String> dictionary, int startIndex, int endIndex,
                                          List<String> result, Memo[] memos) {
        if(memos[startIndex] == Memo.NOT_FOUND){
            return false;
        }

        String candidate = s.substring(startIndex, endIndex);
        if(endIndex == s.length()){
            if(dictionary.contains(candidate)){
                result.add(candidate);
                return true;
            }
            return false;
        }
        if(dictionary.contains(candidate)){
            result.add(candidate);
            if(!wordBreak(s, dictionary, endIndex, endIndex + 1, result, memos)){
                result.remove(result.size() - 1);
                memos[endIndex] = Memo.NOT_FOUND;
            }else{
                return true;
            }
        }
        return wordBreak(s, dictionary, startIndex, endIndex + 1, result, memos);
    }
}
