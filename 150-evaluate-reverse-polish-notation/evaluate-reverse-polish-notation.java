class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> s1 = new Stack<>();
        int n = tokens.length;

        for(int i = 0; i < n; i++){

            if(tokens[i].equals("+") || tokens[i].equals("-") ||
               tokens[i].equals("*") || tokens[i].equals("/")) {

                int b = s1.pop(); // first popped
                int a = s1.pop(); // second popped

                if(tokens[i].equals("+")){
                    s1.push(a + b);
                }
                else if(tokens[i].equals("-")){
                    s1.push(a - b);
                }
                else if(tokens[i].equals("*")){
                    s1.push(a * b);
                }
                else if(tokens[i].equals("/")){
                    s1.push(a / b);
                }

            }
            else {
                s1.push(Integer.parseInt(tokens[i]));
            }
        }

        return s1.pop();
    }
}