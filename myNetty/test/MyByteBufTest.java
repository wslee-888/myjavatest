import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class MyByteBufTest {
    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.buffer(1024);
        byteBuf.writeBytes("嘻嘻嘻嘻哈哈哈哈".getBytes());

        System.out.println("byteBuf,readerIndex:"+byteBuf.readerIndex()+",可读区域大小："+byteBuf.readableBytes()+"，writerIndex:"+byteBuf.writerIndex()+",可写区域大小："+byteBuf.writableBytes());

        byteBuf.readByte();

        System.out.println("byteBuf,废弃区域大小："+byteBuf.readerIndex()+"，读索引位置:"+byteBuf.readerIndex()+",可读区域大小："+byteBuf.readableBytes()+"，写索引位置:"+byteBuf.writerIndex()+",可写区域大小："+byteBuf.writableBytes());

    }
}
