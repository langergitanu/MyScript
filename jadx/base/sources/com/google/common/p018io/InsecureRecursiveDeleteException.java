package com.google.common.p018io;

import java.nio.file.FileSystemException;

/* JADX INFO: loaded from: classes6.dex */
public final class InsecureRecursiveDeleteException extends FileSystemException {
    public InsecureRecursiveDeleteException(String file) {
        super(file, null, "unable to guarantee security of recursive delete");
    }
}
