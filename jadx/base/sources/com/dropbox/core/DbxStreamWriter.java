package com.dropbox.core;

import com.dropbox.core.util.IOUtil;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Throwable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DbxStreamWriter<E extends Throwable> {
    public abstract void write(NoThrowOutputStream noThrowOutputStream) throws Throwable;

    public static final class InputStreamCopier extends DbxStreamWriter<IOException> {
        private final InputStream source;

        public InputStreamCopier(InputStream inputStream) {
            this.source = inputStream;
        }

        @Override // com.dropbox.core.DbxStreamWriter
        public void write(NoThrowOutputStream noThrowOutputStream) throws IOException {
            IOUtil.copyStreamToStream(this.source, noThrowOutputStream);
        }
    }

    public static final class ByteArrayCopier extends DbxStreamWriter<RuntimeException> {
        private final byte[] data;
        private final int length;
        private final int offset;

        public ByteArrayCopier(byte[] bArr, int i, int i2) {
            if (bArr == null) {
                throw new IllegalArgumentException("'data' can't be null");
            }
            if (i < 0 || i >= bArr.length) {
                throw new IllegalArgumentException("'offset' is out of bounds");
            }
            int i3 = i + i2;
            if (i3 < i || i3 > bArr.length) {
                throw new IllegalArgumentException("'offset+length' is out of bounds");
            }
            this.data = bArr;
            this.offset = i;
            this.length = i2;
        }

        public ByteArrayCopier(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // com.dropbox.core.DbxStreamWriter
        public void write(NoThrowOutputStream noThrowOutputStream) {
            noThrowOutputStream.write(this.data, this.offset, this.length);
        }
    }
}
