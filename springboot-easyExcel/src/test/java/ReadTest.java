import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.bvgol.springboot.easyexcel.listener.ExcelListener;
import com.bvgol.springboot.easyexcel.pojo.LoanInfo;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.apache.commons.codec.Resources.getInputStream;

public class ReadTest {

//    /**
//     * 最简单的读
//     * <p>1. 创建excel对应的实体对象 参照{@link DemoData}
//     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
//     * <p>3. 直接读即可
//     */
//    @Test
//    public void simpleRead() {
//        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
//        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
//    }

    //读excel代码示例如下
    @Test
    public void testExcel2003NoModel() {
        InputStream inputStream = getInputStream("loan1.xls");
        try {
            // 解析每行结果在listener中处理
            ExcelListener listener = new ExcelListener();
            ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null, listener);
            excelReader.read();
        } catch (Exception e) {

        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testExcel2003WithReflectModel() {
        InputStream inputStream = getInputStream("loan1.xls");
        try {
            // 解析每行结果在listener中处理
            AnalysisEventListener listener = new ExcelListener();

            ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null, listener);

            excelReader.read(new Sheet(1, 2, LoanInfo.class));
        } catch (Exception e) {

        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



//    @Test
//    public void testWrite(){
//        OutputStream out = new FileOutputStream("/Users/jipengfei/77.xlsx");
//        try {
//            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX,false);
//            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
//            Sheet sheet1 = new Sheet(1, 0);
//            sheet1.setSheetName("第一个sheet");
//            writer.write(getListString(), sheet1);
//            writer.finish();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Test
//    public void test1() throws FileNotFoundException {
//        OutputStream out = new FileOutputStream("/Users/jipengfei/78.xlsx");
//        try {
//            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
//            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
//            Sheet sheet1 = new Sheet(1, 0, ExcelPropertyIndexModel.class);
//            writer.write(getData(), sheet1);
//            writer.finish();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Test
//    public void test1() throws FileNotFoundException {
//
//        OutputStream out = new FileOutputStream("/Users/jipengfei/77.xlsx");
//        try {
//            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX,false);
//            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
//            Sheet sheet1 = new Sheet(1, 0);
//            sheet1.setSheetName("第一个sheet");
//            writer.write(getListString(), sheet1);
//
//            //写第二个sheet sheet2  模型上打有表头的注解，合并单元格
//            Sheet sheet2 = new Sheet(2, 3, MultiLineHeadExcelModel.class, "第二个sheet", null);
//            sheet2.setTableStyle(getTableStyle1());
//            writer.write(getModeldatas(), sheet2);
//
//            //写sheet3  模型上没有注解，表头数据动态传入
//            List<List<String>> head = new ArrayList<List<String>>();
//            List<String> headCoulumn1 = new ArrayList<String>();
//            List<String> headCoulumn2 = new ArrayList<String>();
//            List<String> headCoulumn3 = new ArrayList<String>();
//            headCoulumn1.add("第一列");
//            headCoulumn2.add("第二列");
//            headCoulumn3.add("第三列");
//            head.add(headCoulumn1);
//            head.add(headCoulumn2);
//            head.add(headCoulumn3);
//            Sheet sheet3 = new Sheet(3, 1, NoAnnModel.class, "第三个sheet", head);
//            writer.write(getNoAnnModels(), sheet3);
//            writer.finish();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    @Test
//    public void test2() throws FileNotFoundException {
//        OutputStream out = new FileOutputStream("/Users/jipengfei/77.xlsx");
//        try {
//            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX,false);
//
//            //写sheet1  数据全是List<String> 无模型映射关系
//            Sheet sheet1 = new Sheet(1, 0);
//            sheet1.setSheetName("第一个sheet");
//            Table table1 = new Table(1);
//            writer.write(getListString(), sheet1, table1);
//            writer.write(getListString(), sheet1, table1);
//
//            //写sheet2  模型上打有表头的注解
//            Table table2 = new Table(2);
//            table2.setTableStyle(getTableStyle1());
//            table2.setClazz(MultiLineHeadExcelModel.class);
//            writer.write(getModeldatas(), sheet1, table2);
//
//            //写sheet3  模型上没有注解，表头数据动态传入,此情况下模型field顺序与excel现实顺序一致
//            List<List<String>> head = new ArrayList<List<String>>();
//            List<String> headCoulumn1 = new ArrayList<String>();
//            List<String> headCoulumn2 = new ArrayList<String>();
//            List<String> headCoulumn3 = new ArrayList<String>();
//            headCoulumn1.add("第一列");
//            headCoulumn2.add("第二列");
//            headCoulumn3.add("第三列");
//            head.add(headCoulumn1);
//            head.add(headCoulumn2);
//            head.add(headCoulumn3);
//            Table table3 = new Table(3);
//            table3.setHead(head);
//            table3.setClazz(NoAnnModel.class);
//            table3.setTableStyle(getTableStyle2());
//            writer.write(getNoAnnModels(), sheet1, table3);
//            writer.write(getNoAnnModels(), sheet1, table3);
//
//            writer.finish();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
