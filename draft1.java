import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Testes {
    public static void main(String[] args) {
        // create java.util String List bellow
        List<String> list = new ArrayList<>();
        List<String> formatList = new ArrayList<>();

        // create String variable with various names
        String names = "UIHSUhasuh uhsuahsUHS uhsushquh AUHSHUAuhashu UHSUAHUHSA";
        list.add(names);
        // split list by space and add double quotes
        list.stream().forEach(str -> {
            formatList.addAll(Arrays.asList(str.split(" ")));
            // add double quotes
            formatList.replaceAll(s -> "\"" + s + "\"");
        });

        // remove all square brackets
        String result = formatList.toString().replaceAll("\\[|\\]", "");
        System.out.println(result);
        }
    }
