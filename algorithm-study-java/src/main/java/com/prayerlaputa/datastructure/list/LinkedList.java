package com.prayerlaputa.datastructure.list;

/**
 * @author chenglong.yu@brgroup.com
 * created on 2020/7/13
 */
public class LinkedList<T> {


    ListNode<T> head, tail;
    int size;


    public LinkedList() {
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
    }

    public ListNode findByVal(T t) {
        ListNode node = head;
        while(!node.next.equals(tail) && !node.value.equals(t)) {
            node = node.next;
        }

        if (node.equals(tail)) {
            return null;
        } else {
            return node;
        }
    }

    /**
     * 头插法
     * 注意此处采用的是有头结点的链表
     *
     * @param t
     */
    public void insertToHead(T t) {
        ListNode node = new ListNode(t);
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
    }

    /**
     * 注意，由于此处由于是双向链表、且有尾节点，直接插入即可。
     * 若没有尾节点，还需要先遍历一遍。
     *
     * @param t
     */
    public void insertToTail(T t) {
        ListNode node = new ListNode(t);
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
    }


    public ListNode removeByVal(T t) {
        if (head.next == tail) {
            return null;
        }

        ListNode pointer = head;
        while(!pointer.next.equals(tail)) {
            if (pointer.next.value.equals(t)) {
                ListNode node = pointer.next;
                pointer.next = node.next;
                node.next.pre = pointer;
                node.next = null;
                node.pre = null;
                size--;
                return node;
            }
        }

        return null;
    }

    public int size() {
        return size;
    }
}
