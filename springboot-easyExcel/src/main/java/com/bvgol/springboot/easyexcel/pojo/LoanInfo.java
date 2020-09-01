package com.bvgol.springboot.easyexcel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.math.BigDecimal;
import java.util.Date;

public class LoanInfo extends BaseRowModel {
    @ExcelProperty(index = 0)
    private String bankLoanId;
    
    @ExcelProperty(index = 1)
    private Long customerId;
    
    @ExcelProperty(index = 2,format = "yyyy/MM/dd")
    private Date loanDate;
    
    @ExcelProperty(index = 3)
    private BigDecimal quota;
    
    @ExcelProperty(index = 4)
    private String bankInterestRate;
    
    @ExcelProperty(index = 5)
    private Integer loanTerm;
    
    @ExcelProperty(index = 6,format = "yyyy/MM/dd")
    private Date loanEndDate;
    
    @ExcelProperty(index = 7)
    private BigDecimal interestPerMonth;

    @ExcelProperty(value = {"一级表头","二级表头"})
    private BigDecimal sax;
}