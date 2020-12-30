package com.bvgol.examples.springbootmybatisplus.service.logic;

import com.bvgol.examples.springbootmybatisplus.model.SysConfig;
import com.bvgol.examples.springbootmybatisplus.model.SysDept;
import com.bvgol.examples.springbootmybatisplus.model.SysUser;
import com.bvgol.examples.springbootmybatisplus.service.impl.SysConfigService;
import com.bvgol.examples.springbootmybatisplus.service.impl.SysDeptService;
import com.bvgol.examples.springbootmybatisplus.service.impl.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2020/12/30 15:19
 */
@Service
@AllArgsConstructor
public class SimulationComplateAbleFuture {
    private SysConfigService sysConfigService;
    private SysDeptService sysDeptService;
    private SysUserService sysUserService;

    @Transactional(rollbackFor = Exception.class)
    public String one() {

        long begin = System.currentTimeMillis();
        sysUserService.save(SysUser.builder().username("userId").createTime(new Date()).build());
        System.out.println("用户操作完毕");
        CompletableFuture step1 = CompletableFuture.supplyAsync(() -> {
            boolean save = sysConfigService.save(SysConfig.builder().paramKey("sssss").build());
            System.out.println("步骤一操作完毕");
            return save;
        });

        CompletableFuture step2 = CompletableFuture.supplyAsync(() -> {
            boolean save = sysDeptService.save(SysDept.builder().name("2222222").build());
            System.out.println("步骤2操作完毕");
            return save;
        });

        CompletableFuture.allOf(step1, step2).join();

        System.out.println("全部操作完毕");
        long end = System.currentTimeMillis();
        System.out.println(end - begin);

        return "";
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    public String someExample() {
        long begin = System.currentTimeMillis();
        sysUserService.save(SysUser.builder().username("userId").createTime(new Date()).build());
        System.out.println("用户操作完毕");
        CompletableFuture step1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("步骤1抛出异常");
                boolean save = sysConfigService.save(SysConfig.builder().build());
                if (!save) {
                    throw new RuntimeException();
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
            return "save";
        });

        CompletableFuture step2 = CompletableFuture.supplyAsync(() -> {
            boolean save = sysDeptService.save(SysDept.builder().name("2222222").build());
            System.out.println("步骤2操作完毕");
            return save;
        });

        CompletableFuture.allOf(step1, step2).join();

        System.out.println("全部操作完毕");
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
        return "";
    }

    /**
     * 功能描述: 单事务回滚
     *
     * @param
     * @return: void
     * @author: 郭辰
     * @date: 2020/12/30 16:13
     */
    @Transactional(rollbackFor = Exception.class)
    public void tr() {
        boolean userId = sysUserService.save(SysUser.builder().username("user--").createTime(new Date()).build());
        System.out.println(userId);
        throw new RuntimeException();

    }

    /**
     * 功能描述: 嵌套事务回滚
     *
     * @param
     * @return: void
     * @author: 郭辰
     * @date: 2020/12/30 16:13
     */
    @Transactional(rollbackFor = Exception.class)
    public void trNESTED() {
        boolean userId = sysUserService.save(SysUser.builder().username("user--").createTime(new Date()).build());
        System.out.println(userId);
        //这里需要把 sysConfigService.insert标注为 嵌套事务
        //insert 中是空的,添加时会报错
        sysConfigService.insert(SysConfig.builder().build());

    }

    /**
     * 功能描述: 嵌套事务回滚2
     *
     * @param
     * @return: void
     * @author: 郭辰
     * @date: 2020/12/30 16:13
     */
    @Transactional(rollbackFor = Exception.class)
    public void trComNESTED() {
        long begin = System.currentTimeMillis();
        boolean userId = sysUserService.save(SysUser.builder().username("user--").createTime(new Date()).build());
        System.out.println(userId);
        //这里需要把 sysConfigService.insert标注为 嵌套事务
        //insert 中是空的,添加时会报错

        CompletableFuture step1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("步骤1抛出异常");
                int insert = sysConfigService.insert(SysConfig.builder().build());
                if (insert > 0) {
                    throw new RuntimeException();
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
            return "save";
        });
        CompletableFuture step2 = CompletableFuture.supplyAsync(() -> {
            boolean save = sysDeptService.save(SysDept.builder().name("2222222").build());
            System.out.println("步骤2操作完毕");
            return save;
        });

        CompletableFuture.allOf(step1, step2).join();

        System.out.println("全部操作完毕");
        long end = System.currentTimeMillis();
        System.out.println(end - begin);

    }
}
