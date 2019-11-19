package com.anoyi.douyin.util;


import java.util.HashMap;
import java.util.Map;

/**
 * 抖音乱码转数字
 *
 * 0	&#xe60d;	&#xe603;	&#xe616;
 * 1	&#xe60e;	&#xe602;	&#xe618;
 * 2	&#xe610;	&#xe605;	&#xe617;
 * 3	&#xe611;	&#xe604;	&#xe61a;
 * 4	&#xe619; 	&#xe60c;	&#xe606;
 * 5	&#xe60f;	&#xe607;	&#xe61b;
 * 6	&#xe61f;	&#xe612;	&#xe608;
 * 7	&#xe613;	&#xe60a;	&#xe61c;
 * 8	&#xe61d;	&#xe614;	&#xe60b;
 * 9	&#xe609;	&#xe61e;	&#xe615;
 */
public class DyNumberConvertor {

    private final static Map<String, String> NUMBER_MAP = new HashMap<>(30);

    static {
        NUMBER_MAP.put("60d", "0");
        NUMBER_MAP.put("603", "0");
        NUMBER_MAP.put("616", "0");
        NUMBER_MAP.put("60e", "1");
        NUMBER_MAP.put("602", "1");
        NUMBER_MAP.put("618", "1");
        NUMBER_MAP.put("610", "2");
        NUMBER_MAP.put("605", "2");
        NUMBER_MAP.put("617", "2");
        NUMBER_MAP.put("611", "3");
        NUMBER_MAP.put("604", "3");
        NUMBER_MAP.put("61a", "3");
        NUMBER_MAP.put("619", "4");
        NUMBER_MAP.put("60c", "4");
        NUMBER_MAP.put("606", "4");
        NUMBER_MAP.put("60f", "5");
        NUMBER_MAP.put("607", "5");
        NUMBER_MAP.put("61b", "5");
        NUMBER_MAP.put("61f", "6");
        NUMBER_MAP.put("612", "6");
        NUMBER_MAP.put("608", "6");
        NUMBER_MAP.put("613", "7");
        NUMBER_MAP.put("60a", "7");
        NUMBER_MAP.put("61c", "7");
        NUMBER_MAP.put("61d", "8");
        NUMBER_MAP.put("614", "8");
        NUMBER_MAP.put("60b", "8");
        NUMBER_MAP.put("609", "9");
        NUMBER_MAP.put("61e", "9");
        NUMBER_MAP.put("615", "9");
    }

    /**
     * 解析数字
     */
    public static String getNumber(String str) {
        String hash = str.replace(";", "");
        return NUMBER_MAP.get(hash);
    }

}
