package com.ar50645.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder buffer, int open, int close, int max){
        if (buffer.length() == max * 2) {
            ans.add(buffer.toString());
            return;
        }

        if (open < max) {
            buffer.append("(");
            backtrack(ans, buffer, open + 1, close, max);
            buffer.deleteCharAt(buffer.length() - 1);
        }
        if (close < open) {
            buffer.append(")");
            backtrack(ans, buffer, open, close + 1, max);
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }
}
