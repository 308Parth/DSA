class Solution {
    public String decodeString(String s) {

        Stack<Integer> numbers = new Stack<>();
        Stack<String> strings = new Stack<>();

        String current = "";
        int num = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // If it is a number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // Opening bracket
            else if (ch == '[') {
                numbers.push(num);
                strings.push(current);

                num = 0;
                current = "";
            }

            // Closing bracket
            else if (ch == ']') {

                int repeat = numbers.pop();
                String previous = strings.pop();

                String temp = "";

                for (int j = 0; j < repeat; j++) {
                    temp += current;
                }

                current = previous + temp;
            }

            // Normal character
            else {
                current += ch;
            }
        }

        return current;
    }
}