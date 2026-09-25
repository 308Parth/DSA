class Solution {

    int i = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression);

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    // Parse one complete expression
    Set<String> parse(String s) {
        Set<String> result = new HashSet<>();
        result.add("");

        while (i < s.length() && s.charAt(i) != '}') {

            char ch = s.charAt(i);

            if (ch == ',') {
                // Union: move to the next expression
                i++;

                Set<String> next = parse(s);
                result.addAll(next);

            } else {
                // Concatenation
                Set<String> next = parseTerm(s);

                Set<String> temp = new HashSet<>();

                for (String a : result) {
                    for (String b : next) {
                        temp.add(a + b);
                    }
                }

                result = temp;
            }
        }

        return result;
    }

    // Parse a single term: letter OR {...}
    Set<String> parseTerm(String s) {

        Set<String> result = new HashSet<>();

        char ch = s.charAt(i);

        if (ch == '{') {
            i++; // skip '{'

            result = parse(s);

            i++; // skip '}'

        } else {
            result.add(String.valueOf(ch));
            i++;
        }

        return result;
    }
}