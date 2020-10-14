package com.bvgol.recursion;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

/**
 * @program: my-springboot-completely
 * @description: 菜单
 * @author: GUOCHEN
 * @create: 2020/09/30 09:15
 */
@Data
@Builder
public class Menu {
    private String  id;
    private String pid;
    private String name ;
    private int  level;
    private List<Menu> children;


    public static List<Menu> initList(){
        List<Menu> list = new ArrayList<>(Arrays.asList(Menu.builder().id("1").pid("0").name("全部菜单").build()));

        int id = 1;
        for (int i = 0; i < 2; i++) {
            int pid =1;
            id++;
            list.add(Menu.builder().id(id+"").pid(pid+"").name(pid+"-级菜单-"+i).build());
            for (int j = 0; j <2; j++) {
                pid ++;
                id++;
                list.add(Menu.builder().id(id+"").pid(pid+"").name(pid+"-级菜单-"+j).build());

                for (int k = 0; k < 2; k++) {
                    pid ++;
                    id++;
                    list.add(Menu.builder().id(id+"").pid(pid+"").name(pid+"-级菜单-"+k).build());
                }
            }
        }
        return list;
    }

    private static void initLists(){
        List<Menu> list = new ArrayList<>(Arrays.asList(
                Menu.builder().id("1").pid("0").name("0").build(),
                Menu.builder().id("2").pid("1").name("1-0").build(),
                Menu.builder().id("3").pid("1").name("1-1").build(),
                Menu.builder().id("4").pid("2").name("1-0-1").build(),
                Menu.builder().id("5").pid("2").name("1-0-2").build(),
                Menu.builder().id("6").pid("3").name("1-1-1").build(),
                Menu.builder().id("7").pid("3").name("1-1-2").build(),
                Menu.builder().id("8").pid("4").name("1-0-1-1").build(),
                Menu.builder().id("9").pid("6").name("1-1-1-1").build(),
                Menu.builder().id("10").pid("8").name("1-0-1-1-1").build(),
                Menu.builder().id("11").pid("8").name("1-0-1-1-2").build(),
                Menu.builder().id("12").pid("10").name("1-0-1-1-1-1").build(),
                Menu.builder().id("13").pid("10").name("1-0-1-1-1-2").build()

        ));
    }

    public static void main(String[] args) {
        Menu.initList();
    }
}
