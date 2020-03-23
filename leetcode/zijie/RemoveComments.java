package zijie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class RemoveComments {

    public static void main(String[] args) {
//        List<String> ans = (new RemoveComments()).removeComments(new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"});
        List<String> ans = (new RemoveComments()).removeComments(new String[]{"a/*comment", "line", "more_comment*/b"});
       System.out.println(ans);
        for (String an : ans) {
            System.out.println(an);
        }
    }
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        boolean bad = false;
        for (int i = 0; i < source.length; i++) {
            String currStr = source[i];
            if (!bad) {
                if (Pattern.matches("^/\\*.*", currStr)) {
                    if (!Pattern.matches(".*\\*/$", currStr)) {
                        bad = true;
                    }
                } else if (!Pattern.matches("^(.\\s)//.*", currStr)){
                    ans.add(currStr);
                } else {
                    ans.add("  ");

                }
            } else {
                if (Pattern.matches(".*\\*/$", currStr)) {
                    bad = false;
                }
            }

        }
        return ans;
    }
}
