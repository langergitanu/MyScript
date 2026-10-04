package com.google.common.p018io;

import com.google.errorprone.annotations.DoNotMock;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
@DoNotMock("Implement it normally")
public interface ByteProcessor<T> {
    T getResult();

    boolean processBytes(byte[] buf, int off, int len) throws IOException;
}
