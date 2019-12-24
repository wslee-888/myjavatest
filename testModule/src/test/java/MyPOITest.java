import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyPOITest {
    public static void main(String[] args) {

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("订单售后申请数据");
        CellRangeAddress region = new CellRangeAddress(1,2,3,5);
        hssfSheet.addMergedRegion(region);

        FileOutputStream fileOut = null;
        BufferedImage bufferImg = null;//图片一
        BufferedImage bufferImg1 = null;//图片二
        try {
            // 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            ByteArrayOutputStream byteArrayOut1 = new ByteArrayOutputStream();

            //将两张图片读到BufferedImage
            bufferImg = ImageIO.read(new File("C:\\Users\\fcz01\\Desktop\\img\\"));
            bufferImg1 = ImageIO.read(new File("C:/1.jpg"));
            ImageIO.write(bufferImg, "png", byteArrayOut);
            ImageIO.write(bufferImg1, "png", byteArrayOut1);

            // 创建一个工作薄
            HSSFWorkbook wb = new HSSFWorkbook();
            //创建一个sheet
            HSSFSheet sheet = wb.createSheet("out put excel");

            HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
            /**
             * 该构造函数有8个参数
             * 前四个参数是控制图片在单元格的位置，分别是图片距离单元格left，top，right，bottom的像素距离
             * 后四个参数，前连个表示图片左上角所在的cellNum和 rowNum，后天个参数对应的表示图片右下角所在的cellNum和 rowNum，
             * excel中的cellNum和rowNum的index都是从0开始的
             *
             */
            //图片一导出到单元格B2中
            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,
                    (short) 1, 1, (short) 2, 2);
            //图片二导出到单元格C3到E5中，且图片的left和top距离边框50
            HSSFClientAnchor anchor1 = new HSSFClientAnchor(50, 50, 0, 0,
                    (short) 2, 2, (short) 5, 5);

            // 插入图片
            patriarch.createPicture(anchor, wb.addPicture(byteArrayOut
                    .toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
            patriarch.createPicture(anchor1, wb.addPicture(byteArrayOut1
                    .toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
            //使用流导出--------------------------
//            HttpServletResponse resp = null;
//            String fileName = "fileName";
//            ByteArrayOutputStream os = new ByteArrayOutputStream();
//              wb.write(os);
//              //关闭流
//              os.close();
//
//              byte[] bytes= os.toByteArray();
//              int length=0;
//              if(bytes!=null){
//                   length = bytes.length;
//              }
//              OutputStream output = resp.getOutputStream();
//              resp.setContentType("application/msexcel;charset=utf-8");
//              resp.setHeader("Content-disposition", "attachment; filename="+ new String(fileName.getBytes("GB2312"),"ISO8859-1"));
//              resp.setContentLength(length);
//              output = resp.getOutputStream();
//              if(bytes != null){
//                   output.write(bytes);
//              }
//              output.flush();
//              resp.flushBuffer();
//              output.close();
            //--------------------------

            fileOut = new FileOutputStream("C:/output_Excel.xlsx");
            // 写入excel文件
            wb.write(fileOut);
        } catch (IOException io) {
            io.printStackTrace();
            System.out.println("io erorr : " + io.getMessage());
        } finally {
            if (fileOut != null) {
                try {
                    fileOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
