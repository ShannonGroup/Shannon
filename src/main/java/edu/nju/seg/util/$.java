package edu.nju.seg.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * golden hammer
 */
public class $ {

    /**
     * read content as string from the file
     * @param f the target file
     * @return maybe the content
     */
    public static Optional<String> readContent(File f)
    {
        try {
            String content = Files.readString(f.toPath(), StandardCharsets.UTF_8);
            return Optional.of(content);
        } catch (IOException e) {
            System.err.println(e.toString());
        }
        return Optional.empty();
    }

    /**
     * check if the string is blank
     * @param str the string
     * @return if the string is blank
     */
    public static boolean isBlank(String str)
    {
        return str == null || str.equals("");
    }

    /**
     * judge if a list is a blank list
     * @param list the list
     * @param <T> the type of the list
     * @return if the list is blank
     */
    public static <T> boolean isBlankList(List<T> list)
    {
        return list == null || list.size() == 0;
    }

    public static <T> boolean isNotBlankList(List<T> list)
    {
        return !isBlankList(list);
    }

    /**
     * filter blank string
     * @param list the string list
     * @return the list without blank string
     */
    public static List<String> filter_blank_str(List<String> list)
    {
        return list.stream()
                .filter(s -> !isBlank(s))
                .collect(Collectors.toList());
    }

    /**
     * split expressions
     * @param s the expression string
     * @return expression list
     */
    public static List<String> splitExpr(String s)
    {
        if (isBlank(s)) {
            return new ArrayList<>();
        }
        return Arrays.asList(s.trim().split(","));
    }

    /**
     * create new list according to the given list and the element t
     * @param list the given list
     * @param t the new element
     * @param <T> the element type
     * @return new list
     */
    public static <T> List<T> addToList(List<T> list, T t)
    {
        List<T> result = new ArrayList<>(list);
        result.add(t);
        return result;
    }

    /**
     * create a new list according to the original list without the given element
     * @param list the original list
     * @param e the element which will not exist in the new list
     * @param <T> the generic type
     * @return the new list without the given element
     */
    public static <T> List<T> listSubEle(List<T> list, T e)
    {
        return list.stream()
                .filter(c -> !c.equals(e))
                .collect(Collectors.toList());
    }

    /**
     * judge if the object is Number type
     * @param o the object
     * @return if the object is Number type
     */
    public static boolean isNumber(Object o)
    {
        return o instanceof Number;
    }

    /**
     * judge if the given string is numeric
     * @param s the given string
     * @return if s is numeric
     */
    public static boolean isNumeric(String s)
    {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * remove all white space from the given string
     * @param s the given string
     * @return the string which all the whitespace is removed
     */
    public static String remove_whitespace(String s)
    {
        return s.replaceAll(" ", "").replaceAll("\n", "");
    }

    public static boolean is_ad_judgement(String s)
    {
        return s.startsWith("forall") || s.startsWith("exists");
    }

    /**
     * get the list derived from the array, whose index starts from one
     * @param arr the array
     * @param <T> the type of the List
     * @return the list
     */
    public static <T> List<T> get_list_after_one(T[] arr)
    {
        return Arrays.asList(Arrays.copyOfRange(arr, 1, arr.length));
    }

    public static String loop_queue_prefix(List<Integer> loop_queue)
    {
        if ($.isBlankList(loop_queue)) {
            return "";
        }
        StringBuilder builder = new StringBuilder("loop_");
        for (Integer i: loop_queue) {
            builder.append(i);
            builder.append("_");
        }
        return builder.toString();
    }

    public static boolean is_odd(int i)
    {
        return i % 2 == 1;
    }

    public static boolean is_even(int i)
    {
        return i % 2 == 0;
    }

}
