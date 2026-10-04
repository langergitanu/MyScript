package com.google.common.p018io;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public interface LineProcessor<T> {
    T getResult();

    boolean processLine(String line) throws IOException;
}
