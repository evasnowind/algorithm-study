package com.prayerlaputa.datastructure.list;

/**
 * @author chenglong.yu@brgroup.com
 * created on 2020/7/13
 */
public class ListNode <T> {
    T value;
    ListNode<T> next;
    ListNode<T> pre;

    public ListNode() {

    }

    public ListNode(T t) {
        this.value = t;
    }

    @Override
    public int hashCode() {
        if (null != value) {
            return value.hashCode();
        } else {
            return super.hashCode();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (null == value) {
            return false;
        } else {
            return value.equals(obj);
        }
    }
}
