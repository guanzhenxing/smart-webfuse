package net.webfuse.common.validation;


import net.webfuse.common.util.RegexUtil;

/**
 * 正则表达式验证
 */
public class RegexValidator {

    /**
     * 校验
     *
     * @see net.webfuse.common.validation.Regex Regex枚举类中含有一些常用的正则
     * @param value 值
     * @param regex 正则表达式
     * @return 是否匹配
     */
    public static boolean validator(String value, String regex) {
        return RegexUtil.matcher(regex, value).matches();
    }
}
