package com.lifecycle;

import org.springframework.context.Phased;

public class MyPhased implements Phased{
    @Override
    public int getPhase() {
        return 0;
    }
}
