package com.bvgol.ifelse;

public class XXX {
    public static void main(String[] args) {
        XXX.ifelse();
        XXX.onenum();
    }

    public static void onenum() {
        String sign = "TOUTIAO";
        ChannelRuleEnum channelRule = ChannelRuleEnum.match(sign);
        GeneralChannelRule rule = channelRule.channel;
        rule.process(sign);
    }

    public static void ifelse() {
        //这里我们模拟接收到的数据，其渠道为为TOUTIAO，来自头条的数据
        String sign = "TOUTIAO";
        GeneralChannelRule rule = null;
        //根据对应渠道获取对应的具体规则实现类
        if (ChannelRuleEnum.TENCENT.code.equals(sign)) {
            rule = new TencentChannelRule();
        } else if (ChannelRuleEnum.TOUTIAO.code.equals(sign)) {
            rule = new TouTiaoChannelRule();
        } else {
            //匹配不到
        }
        //执行
        rule.process(sign);
    }
}

//1、首先构建一个 GeneralChannelRule 基础规则抽象类，定义一个抽象方法process()，不同的渠道都需要实现该抽象方法。
abstract class GeneralChannelRule {
    public abstract void process(String sign);
}

//2、编写一个腾讯的规则类，定义具体对于腾讯渠道数据的处理逻辑
class TencentChannelRule extends GeneralChannelRule {
    @Override
    public void process(String sign) {
        // Tencent处理逻辑
    }
}

//3.编写一个头条的规则类，定义具体对于头条数据的处理逻辑
class TouTiaoChannelRule extends GeneralChannelRule {
    @Override
    public void process(String sign) {
        // TouTiao处理逻辑
    }
}

//4、建立一个简单的枚举类
enum ChannelRuleEnum {
    /**
     * 头条
     */
    TOUTIAO("TOUTIAO", new TouTiaoChannelRule()),
    /**
     * 腾讯
     */
    TENCENT("TENCENT", new TencentChannelRule()),
    ;
    public String name;

    public GeneralChannelRule channel;
    public String code;

    ChannelRuleEnum(String name, GeneralChannelRule channel) {
        this.name = name;
        this.channel = channel;
    }

    //匹配
    public static ChannelRuleEnum match(String name) {
        ChannelRuleEnum[] values = ChannelRuleEnum.values();
        for (ChannelRuleEnum value : values) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public GeneralChannelRule getChannel() {
        return channel;
    }
}

//5、使用规则对数据进行处理。
