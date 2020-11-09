package com.bvgol.java7list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname DetailRecordProcess
 * @Description TODO
 * @Date 2020/5/28 15:46
 * @Created by guochen
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailRecordProcess implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private String id;
    /**
     * 工序
     */
    private String procedure;
    /**
     * 工步
     */
    private String workStep;
    /**
     * 设备/虚拟设备
     */
    private String asset;
    /**
     * 工序顺序
     */
    private Integer procedureSort;

    /**
     * 作业人(报工人)
     */
    private String reportUserName;

}
