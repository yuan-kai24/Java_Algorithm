package org.yk.datastructure;

/**
 * 链表
 *
 * @param <T>
 */
public class MyList<T> {
    // 当前元素
    private T now_data = null;
    // 下一个元素
    private MyList<T> next_data = null;
    // 链表
    private int length = 0;

    /**
     * 增
     * 有点递归的味道
     **/
    public boolean add(T data) {
        if (this.next_data == null) {
            this.next_data = new MyList<>();
            this.next_data.setNow_data(data);
        } else {
            this.next_data.add(data);
        }
        this.length++;
        return true;
    }

    /**
     * 删除第几个元素
     **/
    public boolean del(int limit) {
        boolean result = false;
        MyList<T> use_data = this;
        for (int i = 0; i < length; i++) {
            // 判断是否删除下一个元素
            if ((i+1) == limit) {
                use_data.setNext_data(use_data.getNext_data().getNext_data());
                this.length--;
                result = true;
                break;
            }
            use_data = use_data.getNext_data();
        }
        return result;
    }

    /**
     * 删除指定元素
     **/
    public boolean del(T data) {
        boolean result = false;
        MyList<T> use_data = this;
        for (int i = 0; i < length; i++) {
            // 一样的道理，只是变成了比较
            if ((use_data.getNext_data().getNow_data().equals(data))) {
                use_data.setNext_data(use_data.getNext_data().getNext_data());
                this.length--;
                result = true;
                break;
            }
            use_data = use_data.getNext_data();
        }
        return result;
    }

    /**
     * 改
     **/
    public boolean update(int limit, T data) {
        MyList<T> use_data = this;
        boolean result = false;
        for (int i = 1; i <= length; i++) {
            use_data = use_data.getNext_data();
            if(limit == i){
                use_data.setNow_data(data);
                result = true;
            }
        }
        return true;
    }

    /**
     * 查
     **/
    public T get(int limit) {
        T result = null;
        MyList<T> use_data = this;
        for (int i = 1; i <= length; i++) {
            use_data = use_data.getNext_data();
            if (i == limit) {
                result = use_data.getNow_data();
                break;
            }
        }
        return result;
    }

    public T getNow_data() {
        return now_data;
    }

    public void setNow_data(T now_data) {
        this.now_data = now_data;
    }

    public MyList<T> getNext_data() {
        return next_data;
    }

    public void setNext_data(MyList<T> next_data) {
        this.next_data = next_data;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer("[");
        MyList<T> use_data = this;
        for (int i = 0; i < length; i++) {
            use_data = use_data.getNext_data();
            str.append("\"" + use_data.getNow_data() + "\",");
        }
        str.deleteCharAt(str.length()-1);
        str.append("]");
        return str.toString();
    }
}
