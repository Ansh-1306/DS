import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Expression {
    public static void main(String[] args) {

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("0 --> Exit");
            System.out.println("1 --> Evaluate the expression");
            System.out.println("2 --> Construct a binary from the expression");
            System.out.println("Enter your choice");
            int choice = -1;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Enter your choice in numbers only.");
                choice = -1;
                sc.nextLine();
            }
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1: {
                    boolean flag = true;
                    while (flag) {
                        System.out.println("0 --> Back");
                        System.out.println("1 --> Prefix");
                        System.out.println("2 --> Postfix");
                        System.out.println("3 --> Infix");
                        System.out.println("Enter your choice");
                        int choice1 = -1;
                        try {
                            choice1 = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("Enter your choice in numbers only.");
                            choice1 = -1;
                        }
                        sc.nextLine();
                        switch (choice1) {
                            case 0:
                                flag = false;
                                break;
                            case 1:
                                System.out.println("Enter Prefix Expression");
                                String pre = sc.nextLine();
                                if (checkPrefix(pre))
                                    System.out.println(evaluatePrefix(pre));
                                else
                                    System.out.println("Invalid Expression");
                                break;
                            case 2:
                                System.out.println("Enter Postfix Expression");
                                String post = sc.nextLine();
                                if (checkPostfix(post))
                                    System.out.println(evaluatePostfix(post));
                                else
                                    System.out.println("Invalid Expression");
                                break;
                            case 3:
                                System.out.println("Enter Infix Expression");
                                String in = sc.nextLine();
                                if (checkInfix(in))
                                    System.out.println(evaluateInfix(in));
                                else
                                    System.out.println("Invalid Expression");
                                break;
                            default:
                                System.out.println("Enter valid choice");
                                break;
                        }
                    }
                    break;
                }
                case 2: {
                    boolean flag = true;
                    while (flag) {
                        System.out.println("0 --> Back");
                        System.out.println("1 --> Prefix");
                        System.out.println("2 --> Postfix");
                        System.out.println("3 --> Infix");
                        System.out.println("Enter your choice");
                        int choice1 = -1;
                        try {
                            choice1 = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("Enter your choice in numbers only.");
                            choice1 = -1;
                        }
                        sc.nextLine();
                        switch (choice1) {
                            case 0:
                                flag = false;
                                break;
                            case 1:
                                System.out.println("Enter Prefix Expression");
                                String pre = sc.nextLine();
                                if (checkPrefix(pre)) {
                                    Node n = buildTreeUsingPost(prefixToPostfix(pre).trim().split(" "));
                                    printNode(n);
                                    System.out.println();
                                    System.out.print("\tPREORDER  : ");
                                    preOrderTraversal(n);
                                    System.out.println();
                                    System.out.println();
                                    System.out.print("\tINORDER   : ");
                                    inOrderTraversal(n);
                                    System.out.println();
                                    System.out.println();
                                    System.out.print("\tPOSTORDER : ");
                                    postOrderTraversal(n);
                                    System.out.println();
                                    System.out.println();
                                } else
                                    System.out.println("Invalid Expression");
                                break;
                            case 2:
                                System.out.println("Enter Postfix Expression");
                                String post = sc.nextLine();
                                if (checkPostfix(post)) {
                                    Node n = buildTreeUsingPost(post.trim().split(" "));
                                    printNode(n);
                                    System.out.println();
                                    System.out.print("\tPREORDER  : ");
                                    preOrderTraversal(n);
                                    System.out.println();
                                    System.out.println();
                                    System.out.print("\tINORDER   : ");
                                    inOrderTraversal(n);
                                    System.out.println();
                                    System.out.println();
                                    System.out.print("\tPOSTORDER : ");
                                    postOrderTraversal(n);
                                    System.out.println();
                                    System.out.println();
                                } else
                                    System.out.println("Invalid Expression");
                                break;
                            case 3:
                                System.out.println("Enter Infix Expression");
                                String in = sc.nextLine();
                                if (checkInfix(in)) {
                                    Node n = buildTreeUsingPost(infixToPostfix(in).trim().split(" "));
                                    printNode(n);
                                    System.out.println();
                                    System.out.print("\tPREORDER  : ");
                                    preOrderTraversal(n);
                                    System.out.println();
                                    System.out.println();
                                    System.out.print("\tINORDER   : ");
                                    inOrderTraversal(n);
                                    System.out.println();
                                    System.out.println();
                                    System.out.print("\tPOSTORDER : ");
                                    postOrderTraversal(n);
                                    System.out.println();
                                    System.out.println();
                                } else
                                    System.out.println("Invalid Expression");
                                break;
                            default:
                                System.out.println("Enter valid choice");
                                break;
                        }
                    }
                    break;
                }
                default:
                    System.out.println("Enter valid choice");
                    break;
            }
        }
    }

    public static boolean checkPrefix(String exp) {
        String tokens[] = exp.trim().split(" ");
        int count = 0;
        for (int i = tokens.length - 1; i >= 0; i--) {
            if (isNumeric(tokens[i])) {
                count++;
            } else if (isOperator(tokens[i])) {
                count--;
            } else {
                return false;
            }
            if (count < 1) {
                return false;
            }
        }
        if (count != 1)
            return false;
        return true;
    }

    public static boolean checkPostfix(String exp) {
        String tokens[] = exp.trim().split(" ");
        int count = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (isNumeric(tokens[i])) {
                count++;
            } else if (isOperator(tokens[i])) {
                count--;
            } else {
                return false;
            }
            if (count < 1) {
                return false;
            }
        }
        if (count != 1)
            return false;
        return true;
    }

    public static boolean checkInfix(String exp) {
        return checkPostfix(infixToPostfix(exp));
    }

    public static Double evaluatePrefix(String exp) {
        String tokens[] = exp.trim().split(" ");
        Stack<Double> stack = new Stack<>();
        for (int i = tokens.length - 1; i >= 0; i--) {
            if (isNumeric(tokens[i])) {
                stack.push(Double.parseDouble(tokens[i]));
            } else if (isOperator(tokens[i])) {
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                double result = applyOperator(tokens[i], operand1, operand2);
                stack.push(result);
            } else {
                System.out.println("Invalid Expression");
                return null;
            }
        }
        return stack.pop();
    }

    public static Double evaluatePostfix(String exp) {
        String tokens[] = exp.trim().split(" ");
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isNumeric(tokens[i])) {
                stack.push(Double.parseDouble(tokens[i]));
            } else if (isOperator(tokens[i])) {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = applyOperator(tokens[i], operand1, operand2);
                stack.push(result);
            } else {
                System.out.println("Invalid expression");
                return null;
            }
        }
        return stack.pop();
    }

    public static Double evaluateInfix(String exp) {
        return evaluatePostfix(infixToPostfix(exp));
    }

    public static String infixToPostfix(String exp) {
        String postfix = "";
        Stack<String> stack = new Stack<>();
        String[] tokens = exp.trim().split(" ");

        stack.push("#");
        try {

            for (int i = 0; i < tokens.length; i++) {
                if (precedence(tokens[i]) > precedence(stack.peek())) {
                    stack.push(tokens[i]);
                } else if (tokens[i].equals("(")) {
                    stack.push("(");
                } else if (tokens[i].equals(")")) {
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postfix = postfix + " " + stack.pop();
                    }
                    if (!stack.isEmpty() && stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        throw new IllegalArgumentException("Invalid infix expression: mismatched parentheses");
                    }
                } else {
                    while (precedence(tokens[i]) <= precedence(stack.peek())) {
                        postfix = postfix + " " + stack.pop();
                    }
                    stack.push(tokens[i]);
                }
            }
        } catch (EmptyStackException ese) {
            ese.printStackTrace();
        }

        while (!stack.peek().equals("#")) {
            postfix = postfix + " " + stack.pop();
        }
        return postfix;
    }

    public static boolean isNumeric(String num) {
        try {
            Double.parseDouble(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isOperator(String op) {
        if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"))
            return true;
        return false;
    }

    public static int precedence(String op) {
        if (op.equals("+") || op.equals("-")) {
            return 1;
        } else if (op.equals("*") || op.equals("/")) {
            return 2;
        } else if (isNumeric(op)) {
            return 3;
        }
        return 0;
    }

    public static Double applyOperator(String operator, double operand1, double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    System.out.println("Division by zero is not allowed");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public static String prefixToPostfix(String exp) {
        Stack<String> stack = new Stack<>();
        String[] tokens = exp.trim().split(" ");

        for (int i = tokens.length - 1; i >= 0; i--) {
            if (isNumeric(tokens[i])) {
                stack.push(tokens[i]);
            } else if (isOperator(tokens[i])) {
                String op1 = stack.pop();
                String op2 = stack.pop();

                stack.push(op1 + " " + op2 + " " + tokens[i]);

            }
        }
        return stack.pop();
    }

    static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildTreeUsingPost(String[] postfixExpression) {
        Stack<Node> stack = new Stack<>();

        for (String token : postfixExpression) {
            if (isNumeric(token)) {
                stack.push(new Node(token));
            } else {
                Node rightOperand = stack.pop();
                Node leftOperand = stack.pop();
                Node operatorNode = new Node(token);
                operatorNode.left = leftOperand;
                operatorNode.right = rightOperand;
                stack.push(operatorNode);
            }
        }
        return stack.pop();
    }

    public static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.value + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public static void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value + " ");
        }
    }

    public static void printNode(Node root) {
        int maxLevel = maxLevel(root);
        List<Node> newNodes = new ArrayList<Node>();
        newNodes.add(root);

        printNodeInternal(newNodes, 1, maxLevel);
    }

    public static void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    public static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    public static int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    public static boolean isAllElementsNull(List<Node> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }
}
