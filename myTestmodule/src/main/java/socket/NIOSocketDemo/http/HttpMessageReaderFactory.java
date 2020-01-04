package socket.NIOSocketDemo.http;


import socket.NIOSocketDemo.IMessageReader;
import socket.NIOSocketDemo.IMessageReaderFactory;

/**
 * Created by jjenkov on 18-10-2015.
 */
public class HttpMessageReaderFactory implements IMessageReaderFactory {

    public HttpMessageReaderFactory() {
    }

    @Override
    public IMessageReader createMessageReader() {
        return new HttpMessageReader();
    }
}
