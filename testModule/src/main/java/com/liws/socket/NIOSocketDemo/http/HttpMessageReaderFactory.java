package com.liws.socket.NIOSocketDemo.http;


import com.liws.socket.NIOSocketDemo.IMessageReader;
import com.liws.socket.NIOSocketDemo.IMessageReaderFactory;

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
