package leetcode.no133;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public int val;
    public List<Node> neighbors;

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

}
