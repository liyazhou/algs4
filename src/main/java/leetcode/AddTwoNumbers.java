package leetcode;

import java.util.Stack;

//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
//        Explanation: 342 + 465 = 807.
public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = null;
        int jinWei = 0;
        while (l2 != null || l1 != null || jinWei != 0) {
            int num1 = 0, num2 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            int sum = (num1 + num2 + jinWei) % 10;
            if (node == null) {
                node = new ListNode(sum);
            } else {
                ListNode temp = node;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = new ListNode(sum);
            }
            jinWei = (num1 + num2 + jinWei) / 10;
        }
        return node;
    }
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode node = null;
//        int jinWei = 0;
//        while (l2 != null || l1 != null || jinWei != 0) {
//            int num1 = 0, num2 = 0;
//            if (l1 != null) {
//                num1 = l1.val;
//                l1 = l1.next;
//            }
//            if (l2 != null) {
//                num2 = l2.val;
//                l2 = l2.next;
//            }
//            int sum = (num1 + num2 + jinWei) % 10;
//            if (node == null) {
//                node = new ListNode(sum);
//            } else {
//                ListNode temp = node;
//                while (temp.next != null) {
//                    temp = temp.next;
//                }
//                temp.next = new ListNode(sum);
//            }
//            jinWei = (num1 + num2 + jinWei) / 10;
//        }
//        return node;
//    }
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int num1 = converNode2Num(l1);
//        int num2 = converNode2Num(l2);
//        int sum = num1 + num2;
//        return convertNum2Node(sum);
//    }
//
//    //    convert listNode to integer
//    public int converNode2Num(ListNode listNode) {
//        Stack<Integer> stack1 = new Stack();
//        while (listNode != null) {
//            stack1.push(listNode.val);
//            listNode = listNode.next;
//        }
//        int num = 0;
//        while (!stack1.isEmpty()) {
//            num = num * 10 + stack1.pop();
//        }
//        return num;
//    }
//
//    public ListNode convertNum2Node(int num) {
//        ListNode node = null;
//        if (num == 0) {
//            node = new ListNode(0);
//        } else {
//            while (num != 0) {
//                int digit = num % 10;
//                if (node == null) {
//                    node = new ListNode(digit);
//                } else {
//                    ListNode temp = node;
//                    while (temp.next != null) {
//                        temp = temp.next;
//                    }
//                    temp.next = new ListNode(digit);
//                }
//                num /= 10;
//            }
//        }
//        return node;
//    }
//    public ListNode convertNum2Node(int num) {
//        Stack<Integer> stack1 = new Stack();
//        while (num != 0) {
//            stack1.push(num % 10);
//            num /= 10;
//        }
//        ListNode node = null;
//        while (!stack1.isEmpty()) {
//            if (node == null) {
//                node = new ListNode(stack1.pop());
//            } else {
//                ListNode temp = node;
//                while (temp.next != null) {
//                    temp = temp.next;
//                }
//                temp.next = new ListNode(stack1.pop());
//            }
//        }
//        return node;
//    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5);
//        ListNode listNode1 = new ListNode(2);
//        listNode1.next = new ListNode(4);
//        listNode1.next.next = new ListNode(3);
        System.out.println(listNode1);

//        ListNode listNode2 = new ListNode(0);
        ListNode listNode2 = new ListNode(5);
//        listNode2.next = new ListNode(6);
//        listNode2.next.next = new ListNode(4);
        System.out.println(listNode2);

        ListNode sumNode = new AddTwoNumbers().addTwoNumbers(listNode1, listNode2);
        System.out.println(sumNode);
    }
}


//      Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode tempNode = this;
        while (tempNode != null) {
            sb.append(tempNode.val);
            tempNode = tempNode.next;
        }
        return sb.toString();
    }

}