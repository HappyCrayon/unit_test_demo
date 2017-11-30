package junit.simple;


public class Calculator {

    public String add(String input) {
        if ("".equals(input))
            return "0";

        final String[] split = input.split(",");
        int sum = 0;
        for (int i = 0; i < split.length; i++)
            sum += Integer.valueOf(split[i]);
        return String.valueOf(sum);
    }
}
