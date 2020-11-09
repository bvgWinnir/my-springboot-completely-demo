package com.bvgol.lambda.stream;

class ClassA {
    String id;
    String realName;

    public ClassA(String id, String realName) {
        this.id = id;
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "ClassA{" +
                "id='" + id + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getRealName() {
        return realName;
    }
}

class ClassB {
    String id;
    String nickName;

    public ClassB(String id, String nickName) {
        this.id = id;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "ClassB{" +
                "id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }
}
