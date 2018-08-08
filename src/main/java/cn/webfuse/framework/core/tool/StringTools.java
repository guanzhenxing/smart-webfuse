package cn.webfuse.framework.core.tool;

import org.apache.commons.io.Charsets;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTools extends StringUtils {

    public static final String EMPTY = "";

    public static final String COMMA = ",";

    /**
     * 将蛇形的字符串转换为驼峰型
     * @param input
     * @return
     */
    public static String convertSnakeCaseToCamel(String input){
        if (input == null) {
            return null;
        }
        if (input.indexOf("_") < 0) {
            return input;
        }
        String result = "";
        String[] split = StringUtils.split(input, "_");
        int index = 0;
        for (String s : split) {
            if (index == 0) {
                result += s.toLowerCase();
            } else {
                result += capitalize(s);
            }
            index++;
        }
        return result;
    }

    /**
     * These rules result in the following additional example translations from
     * Java property names to JSON element names.
     * <ul><li>&quot;userName&quot; is translated to &quot;user_name&quot;</li>
     * <li>&quot;UserName&quot; is translated to &quot;user_name&quot;</li>
     * <li>&quot;USER_NAME&quot; is translated to &quot;user_name&quot;</li>
     * <li>&quot;user_name&quot; is translated to &quot;user_name&quot; (unchanged)</li>
     * <li>&quot;user&quot; is translated to &quot;user&quot; (unchanged)</li>
     * <li>&quot;User&quot; is translated to &quot;user&quot;</li>
     * <li>&quot;USER&quot; is translated to &quot;user&quot;</li>
     * <li>&quot;_user&quot; is translated to &quot;user&quot;</li>
     * <li>&quot;_User&quot; is translated to &quot;user&quot;</li>
     * <li>&quot;__user&quot; is translated to &quot;_user&quot;
     * (the first of two underscores was removed)</li>
     * <li>&quot;user__name&quot; is translated to &quot;user__name&quot;
     * (unchanged, with two underscores)</li></ul>
     */
    public static String toLowerCaseWithUnderscores(String input) {
        if (input == null) return input; // garbage in, garbage out
        int length = input.length();
        StringBuilder result = new StringBuilder(length * 2);
        int resultLength = 0;
        boolean wasPrevTranslated = false;
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if (i > 0 || c != '_') // skip first starting underscore
            {
                if (Character.isUpperCase(c)) {
                    if (!wasPrevTranslated && resultLength > 0 && result.charAt(resultLength - 1) != '_') {
                        result.append('_');
                        resultLength++;
                    }
                    c = Character.toLowerCase(c);
                    wasPrevTranslated = true;
                } else {
                    wasPrevTranslated = false;
                }
                result.append(c);
                resultLength++;
            }
        }
        return resultLength > 0 ? result.toString() : input;
    }

    /**
     * 过滤字符串的HTML标签
     *
     * @param str 含html标签的字符串
     * @return htmlStr
     */
    public static String removeHtmlText(String str) {
        if (null == str) {
            return str;
        }
        String htmlStr = str;
        // 定义script的正则表达式
        String regExScript = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
        // 定义style的正则表达式
        String regExStyle = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
        // 定义HTML标签的正则表达式
        String regExHtml = "<[^>]+>";
        Pattern scriptPattern = null;
        Matcher scriptMatcher = null;
        Pattern stylePattern = null;
        Matcher styleMatcher = null;
        Pattern htmlPattern = null;
        Matcher htmlMatcher = null;
        try {
            scriptPattern = Pattern.compile(regExScript, Pattern.CASE_INSENSITIVE);
            scriptMatcher = scriptPattern.matcher(htmlStr);
            // 过滤script标签
            htmlStr = scriptMatcher.replaceAll("");
            // 过滤style标签
            stylePattern = Pattern.compile(regExStyle, Pattern.CASE_INSENSITIVE);
            styleMatcher = stylePattern.matcher(htmlStr);
            htmlStr = styleMatcher.replaceAll("");
            // 过滤html标签
            htmlPattern = Pattern.compile(regExHtml, Pattern.CASE_INSENSITIVE);
            htmlMatcher = htmlPattern.matcher(htmlStr);
            htmlStr = htmlMatcher.replaceAll("");
            htmlStr = htmlStr.replaceAll("&nbsp;", "");
        } catch (Exception e) {
            throw new RuntimeException("error occur when filter html content:" + e.getMessage(), e);
        }
        return htmlStr;
    }

    /**
     * read a file and return content as a string.
     *
     * @param file    file
     * @param charset charset, default set UTF8
     * @return content
     * @throws IOException
     */
    public static String file2String(File file, String charset) throws IOException {
        return stream2String(new FileInputStream(file), charset);
    }

    /**
     * read a InputStream and return content as a string.
     *
     * @param inputStream inputStream
     * @param charset     charset, default set UTF8
     * @return content
     * @throws IOException
     */
    public static String stream2String(InputStream inputStream, String charset) throws IOException {
        String useCharset = charset;
        if (isBlank(charset))
            useCharset = Charsets.UTF_8.displayName();

        StringBuilder sb = new StringBuilder();
        Reader r = new InputStreamReader(inputStream, useCharset);
        while (true) {
            char[] buffer = new char[1024];
            int length = r.read(buffer);
            if (length == -1) {
                break;
            }
            sb.append(buffer, 0, length);
        }
        r.close();
        return sb.toString();
    }

    /**
     * spilt by comma
     * <p/>
     * <pre>
     * StringTools.split(null)        = []
     * StringTools.split("")          = []
     * StringTools.split("abc")       = ["abc"]
     * StringTools.split("abc,def")   = ["abc", "def"]
     * StringTools.split("abc,,def")  = ["abc", "def"]
     * StringTools.split("abc,def,")  = ["abc", "def"]
     * StringTools.split("abc,def,ghi")  = ["abc", "def", "ghi"]
     * </pre>
     */
    public static List<String> spilt(String toSplit) {
        return spilt(toSplit, COMMA);
    }

    /**
     * <pre>
     * StringTools.split(null, *)         = []
     * StringTools.split("", *)           = []
     * StringTools.split("abc,def", null) = ["abc,def"]
     * StringTools.split("abc,def", "")   = ["abc,def"]
     * StringTools.split("abc,def", ",")  = ["abc", "def"]
     * StringTools.split("abc,,def", ",") = ["abc", "def"]
     * StringTools.split("abc,def,", ",") = ["abc", "def"]
     * StringTools.split("abc,def,ghi", ",") = ["abc", "def", "ghi"]
     * </pre>
     */
    public static List<String> spilt(String str, String separatorChars) {
        return Arrays.asList(split(str, separatorChars));
    }


    /**
     * 获取字符串的字符数
     *
     * @param strName
     * @return
     */
    public static int getCharLength(String strName) {
        char[] ch = strName.toCharArray();
        int length = 0;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c)) {
                // 数据库一个汉字占四个字符
                length = length + 4;
            } else {
                length++;
            }
        }
        return length;
    }

    public static String lowerFirstCharacter(String str) {
        if (isEmpty(str))
            return str;
        char[] arrays = str.toCharArray();
        char firstUpperCaseChar = arrays[0];
        char firstLowercaseChar = Character.toLowerCase(firstUpperCaseChar);
        arrays[0] = firstLowercaseChar;
        return new String(arrays);
    }

    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    /**
     * true-->1;
     * false-->0;
     *
     * @param booleanValue
     * @return
     */
    public static Byte booleanToByte(Boolean booleanValue) {

        if (booleanValue == null) {
            return null;
        }
        return booleanValue ? (byte) 1 : (byte) 0;
    }

    /**
     * 0--->false;
     * 非0-->true;
     *
     * @param byteValue
     * @return
     */
    public static Boolean byteToBoolean(Byte byteValue) {
        if (byteValue == null) {
            return false;
        }
        return byteValue == 0x00 ? false : true;
    }

    /**
     * Check whether the given {@code CharSequence} contains actual <em>text</em>.
     * <p>More specifically, this method returns {@code true} if the
     * {@code CharSequence} is not {@code null}, its length is greater than
     * 0, and it contains at least one non-whitespace character.
     * <p><pre class="code">
     * StringUtils.hasText(null) = false
     * StringUtils.hasText("") = false
     * StringUtils.hasText(" ") = false
     * StringUtils.hasText("12345") = true
     * StringUtils.hasText(" 12345 ") = true
     * </pre>
     *
     * @param str the {@code CharSequence} to check (may be {@code null})
     * @return {@code true} if the {@code CharSequence} is not {@code null},
     * its length is greater than 0, and it does not contain whitespace only
     * @see Character#isWhitespace
     */
    public static boolean hasText(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        }

        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check whether the given {@code String} contains actual <em>text</em>.
     * <p>More specifically, this method returns {@code true} if the
     * {@code String} is not {@code null}, its length is greater than 0,
     * and it contains at least one non-whitespace character.
     *
     * @param str the {@code String} to check (may be {@code null})
     * @return {@code true} if the {@code String} is not {@code null}, its
     * length is greater than 0, and it does not contain whitespace only
     * @see #hasText(CharSequence)
     */
    public static boolean hasText(String str) {
        return hasText((CharSequence) str);
    }

    /**
     * Check whether the given {@code CharSequence} contains any whitespace characters.
     *
     * @param str the {@code CharSequence} to check (may be {@code null})
     * @return {@code true} if the {@code CharSequence} is not empty and
     * contains at least 1 whitespace character
     * @see Character#isWhitespace
     */
    public static boolean containsWhitespace(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        }

        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check whether the given {@code String} contains any whitespace characters.
     *
     * @param str the {@code String} to check (may be {@code null})
     * @return {@code true} if the {@code String} is not empty and
     * contains at least 1 whitespace character
     * @see #containsWhitespace(CharSequence)
     */
    public static boolean containsWhitespace(String str) {
        return containsWhitespace((CharSequence) str);
    }

    /**
     * Check that the given {@code CharSequence} is neither {@code null} nor
     * of length 0.
     * <p>Note: this method returns {@code true} for a {@code CharSequence}
     * that purely consists of whitespace.
     * <p><pre class="code">
     * StringUtils.hasLength(null) = false
     * StringUtils.hasLength("") = false
     * StringUtils.hasLength(" ") = true
     * StringUtils.hasLength("Hello") = true
     * </pre>
     *
     * @param str the {@code CharSequence} to check (may be {@code null})
     * @return {@code true} if the {@code CharSequence} is not {@code null} and has length
     * @see #hasText(String)
     */
    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }

    /**
     * Check that the given {@code String} is neither {@code null} nor of length 0.
     * <p>Note: this method returns {@code true} for a {@code String} that
     * purely consists of whitespace.
     *
     * @param str the {@code String} to check (may be {@code null})
     * @return {@code true} if the {@code String} is not {@code null} and has length
     * @see #hasLength(CharSequence)
     * @see #hasText(String)
     */
    public static boolean hasLength(String str) {
        return hasLength((CharSequence) str);
    }

    /**
     * 判断是否是Json
     *
     * @param str
     * @return
     */
    public static boolean isJson(String str) {
        try {
            JsonTools.getInstance().getMapper().readValue(str, Map.class);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
