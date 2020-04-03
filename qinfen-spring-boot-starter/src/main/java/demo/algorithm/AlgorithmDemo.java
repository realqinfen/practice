package demo.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/***
 * @Description 算法demo
 * @Author fen.qin  14:14 2020/1/9
 **/
public class AlgorithmDemo {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.size();
        int[] arr = new int[]{1};
        List<Node> list = new ArrayList<Node>();
        Node n5 = new Node("5", null);
        Node n4 = new Node("4", n5);
        Node n3 = new Node("3", n4);
        Node n2 = new Node("2", n3);
        Node n1 = new Node("1", n2);
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);
        System.out.println(JSON.toJSONString(list));
        Node reverse = reverse(list.get(0));
        System.out.println(JSON.toJSONString(list));
    }

    /**
     * @Description 单向链表反转
     * @Author fen.qin  14:15 2020/1/9
     **/
    public static Node reverse(Node node) {
        if (node == null || node.getNext() == null) {
            return null;
        }
        Node temp = node.getNext();
        System.out.println("current node : " + node + "next node : " + node.getNext());
        Node newHead = reverse(temp);
        temp.setNext(node);
        node.setNext(null);
        return newHead;
    }
}
