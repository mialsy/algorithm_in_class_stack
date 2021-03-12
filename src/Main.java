import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deque<StringBuilder> stack = new ArrayDeque<>();

        StringBuilder sb  = new StringBuilder();
        stack.push(sb);
        sb.append("hi");
        System.out.println(stack.peek());
    }
}
