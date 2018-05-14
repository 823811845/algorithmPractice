package tTiao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static List<String> getData(String data) {
        String regex = "(\\([^\\)]*\\])";
        List<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(data);
        while (m.find()) {
            list.add(m.group().substring(1, m.group().length() - 1));
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getData("sdfsd(123)sdfsf"));
    }


}
