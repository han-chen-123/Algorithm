package Algorithms.niuke;

import java.util.*;
public class deleteNodeNiuke {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while(in.hasNext())
            {
                //输入节点数
                int nodeNum = in.nextInt();
                //输入头节点的值
                int headVal = in.nextInt();
                //构造头节点
                Node pHead = new Node(headVal);
                for(int i = 0;i < nodeNum - 1;i ++)
                {
                    //插入节点值
                    int nextVal = in.nextInt();
                    //前一节点值
                    int preVal = in.nextInt();
                    //插入节点
                    insert(pHead,preVal,nextVal);
                }
                int deleteVal = in.nextInt();
                pHead = removeNode(pHead, deleteVal);
                while(pHead.next != null)
                {
                    System.out.print(pHead.val + " ");
                    pHead = pHead.next;
                }
                System.out.println(pHead.val + " ");
            }
        }
        /*
         参数 pHead 头节点
         preVal 上一节点值
         nextVal 插入节点值
        */
        public static void insert(Node pHead,int preVal,int nextVal)
        {
            Node pNext = new Node(nextVal);
            Node pCurrent = pHead;
            while(pCurrent != null)
            {
                if(pCurrent.val == preVal)
                {
                    pNext.next = pCurrent.next;
                    pCurrent.next = pNext;
                    break;
                }
                pCurrent = pCurrent.next;
            }
        }
        public static Node removeNode(Node pHead,int val)
        {
            Stack<Node> stack = new Stack<Node>();
            while(pHead != null)
            {
                if(pHead.val != val)
                {
                    stack.push(pHead);
                }
                pHead = pHead.next;
            }
            while(!stack.isEmpty())
            {
                stack.peek().next = pHead;
                pHead = stack.pop();
            }
            return pHead;
        }
    }
    class Node
    {
        public int val;
        public Node next;
        public Node(int val)
        {
            this.val = val;
        }
    }

