package com.bvgol.examples.my.hash;

import java.util.HashMap;

class Key {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public Key(Integer id) {
        this.id = id;
    }

    //    故意先注释掉equals和hashCode方法
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Key)) {
            return false;
        } else {
            return this.getId().equals(((Key) o).getId());
        }
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

public class WithoutHashCode {
    public static void main(String[] args) {
        Key k1 = new Key(1);
        Key k2 = new Key(1);
        HashMap<Key, String> hm = new HashMap<Key, String>();
        hm.put(k1, "Key with id is 1");
        hm.put(k2, "Key with id is 2");
        System.out.println(hm.get(k2));
    }
}
