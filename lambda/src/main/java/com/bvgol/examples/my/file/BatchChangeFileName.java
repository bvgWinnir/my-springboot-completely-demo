package com.bvgol.examples.my.file;

import java.io.File;

public class BatchChangeFileName {
    public static void main(String[] args)
    {
        String path = "D:\\视频\\jvm";
        String target="[高清 1080P] 尚硅谷2020最新版宋红康JVM教程持续更新中(java虚拟机详解，jvm从入门到精通)_";
        File file = new File(path);
        File[] list = file.listFiles();

        if (file.exists() && file.isDirectory())
        {
            for (int i = 0; i < list.length; i++)
            {
                String name = list[i].getName();

                String newName = name.replace(target,"");
                File dest = new File(path + "/" + newName);
                list[i].renameTo(dest);
                System.out.println(dest.getName());

                //漏了哪些
                //重了哪些
                //最好排序(原文件标题顺序)
            }
        }
    }
}
