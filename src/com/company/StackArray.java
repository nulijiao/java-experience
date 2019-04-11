package com.company;

public class StackArray {
    private int size;
    private int [] stack;
    private int index = 0;

    public StackArray(int size) {
        this.stack = new int[size];
        this.size = size;
    }

    public void push(int el) {
        if(this.index == size - 1) {
            System.out.println("stackoverflow");
            return;
        }
        this.stack[this.index++] = el;
    }

    public void pop() {
        if(this.index == 0) {
            System.out.println("empty stack can not pop");
            return;
        }
        this.index--;
    }

}

class QueueArray {
    private int size;
    private int [] queue;
    private int frontIndex = 0;
    private int endIndex = 0;

    public QueueArray(int size) {
        this.queue = new int[size];
        this.size = size;
    }

    public void push(int el) {
        if(this.endIndex - this.frontIndex == size) {
            System.out.println("stackoverflow");
            return;
        }
        this.queue[this.endIndex++] = el;
    }

    public void out() {
        if(this.endIndex == 0) {
            System.out.println("empty stack can not pop");
            return;
        }
        this.frontIndex++;

    }
}

class LinkNode {
    public LinkNode next;
    public LinkNode pre;
    public int val;

    public LinkNode(int val) {
        this.val = val;

    }
}

class StackLink {
    private LinkNode head = new LinkNode(-1);
    private LinkNode tail = head;
    public void push(LinkNode node) {
        node.pre = this.tail;
        this.tail.next = node;
        this.tail = node;
        this.tail.next = null;
    }
    public void pop() {
        this.tail = this.tail.pre;
        this.tail.next = null;
    }
    public void getStack() {
        LinkNode temp = this.head;
        temp = head.next;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

class QueueNode {
    public QueueNode front;
    public QueueNode tail;
    public int val;

    public QueueNode(int val) {
        this.val = val;

    }
}

class QueueNodeLink {
    private LinkNode head = new LinkNode(-1);
    private LinkNode tail = head;
    public void push(LinkNode node) {
        node.pre = this.tail;
        this.tail.next = node;
        this.tail = node;
        this.tail.next = null;
    }
    public void pop() {
        this.head = this.head.next;
    }
    public void getQueue() {
        LinkNode temp = this.head;
        temp = head.next;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

/*
*
*判断链表是否有环
*
* */

class MyLinkNode {
    private MyLinkNode pre = null;
    private MyLinkNode tail = null;
    /*
    * 设置快慢指针一个1一个2走得快的迟早会和慢的相遇
    *
    * */
    public boolean isCircle(MyLinkNode node) {
        MyLinkNode fast;
        MyLinkNode slow;
        fast = node.tail;
        slow = node.tail;
        while(node.tail != null) {
            slow = fast;
            fast = fast.tail;
            if(slow == fast) {
                return true;
            }

        }
        return false;
    }
}

