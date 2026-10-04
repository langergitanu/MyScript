package com.dropbox.core.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.CharacterCodingException;

/* JADX INFO: loaded from: classes4.dex */
public class IOUtil {
    public static final int DEFAULT_COPY_BUFFER_SIZE = 16384;
    public static final InputStream EmptyInputStream = new InputStream() { // from class: com.dropbox.core.util.IOUtil.1
        @Override // java.io.InputStream
        public int read() {
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) {
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            return -1;
        }
    };
    public static final OutputStream BlackHoleOutputStream = new OutputStream() { // from class: com.dropbox.core.util.IOUtil.2
        @Override // java.io.OutputStream
        public void write(int i) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
        }
    };

    public interface ProgressListener {
        void onProgress(long j);
    }

    public static Reader utf8Reader(InputStream inputStream) {
        return new InputStreamReader(inputStream, StringUtil.UTF8.newDecoder());
    }

    public static Writer utf8Writer(OutputStream outputStream) {
        return new OutputStreamWriter(outputStream, StringUtil.UTF8.newEncoder());
    }

    public static String toUtf8String(InputStream inputStream) throws CharacterCodingException, ReadException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            copyStreamToStream(inputStream, byteArrayOutputStream);
            return StringUtil.utf8ToString(byteArrayOutputStream.toByteArray());
        } catch (WriteException e) {
            throw new RuntimeException("impossible", e);
        }
    }

    public static void copyStreamToStream(InputStream inputStream, OutputStream outputStream) throws WriteException, ReadException {
        copyStreamToStream(inputStream, outputStream, 16384);
    }

    public static void copyStreamToStream(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws WriteException, ReadException {
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    return;
                }
                try {
                    outputStream.write(bArr, 0, i);
                } catch (IOException e) {
                    throw new WriteException(e);
                }
            } catch (IOException e2) {
                throw new ReadException(e2);
            }
        }
    }

    public static void copyStreamToStream(InputStream inputStream, OutputStream outputStream, int i) throws WriteException, ReadException {
        copyStreamToStream(inputStream, outputStream, new byte[i]);
    }

    public static byte[] slurp(InputStream inputStream, int i) throws IOException {
        return slurp(inputStream, i, new byte[16384]);
    }

    public static byte[] slurp(InputStream inputStream, int i, byte[] bArr) throws IOException {
        if (i < 0) {
            throw new RuntimeException("'byteLimit' must be non-negative: " + i);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copyStreamToStream(inputStream, byteArrayOutputStream, bArr);
        return byteArrayOutputStream.toByteArray();
    }

    public void copyFileToStream(File file, OutputStream outputStream) throws WriteException, ReadException {
        copyFileToStream(file, outputStream, 16384);
    }

    public void copyFileToStream(File file, OutputStream outputStream, int i) throws WriteException, ReadException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                copyStreamToStream(fileInputStream, outputStream, i);
            } finally {
                closeInput(fileInputStream);
            }
        } catch (IOException e) {
            throw new ReadException(e);
        }
    }

    public void copyStreamToFile(InputStream inputStream, File file) throws WriteException, ReadException {
        copyStreamToFile(inputStream, file, 16384);
    }

    public void copyStreamToFile(InputStream inputStream, File file, int i) throws WriteException, ReadException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                copyStreamToStream(inputStream, fileOutputStream, i);
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new WriteException(e);
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                    throw th;
                } catch (IOException e2) {
                    throw new WriteException(e2);
                }
            }
        } catch (IOException e3) {
            throw new WriteException(e3);
        }
    }

    public static void closeInput(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void closeInput(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static InputStream limit(InputStream inputStream, long j) {
        return new LimitInputStream(inputStream, j);
    }

    public static abstract class WrappedException extends IOException {
        private static final long serialVersionUID = 0;

        public WrappedException(String str, IOException iOException) {
            super(str + ": " + iOException.getMessage(), iOException);
        }

        public WrappedException(IOException iOException) {
            super(iOException);
        }

        @Override // java.lang.Throwable
        public IOException getCause() {
            return (IOException) super.getCause();
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            String message = super.getCause().getMessage();
            return message == null ? "" : message;
        }
    }

    public static final class ReadException extends WrappedException {
        private static final long serialVersionUID = 0;

        public ReadException(String str, IOException iOException) {
            super(str, iOException);
        }

        public ReadException(IOException iOException) {
            super(iOException);
        }
    }

    public static final class WriteException extends WrappedException {
        private static final long serialVersionUID = 0;

        public WriteException(String str, IOException iOException) {
            super(str, iOException);
        }

        public WriteException(IOException iOException) {
            super(iOException);
        }
    }

    private static final class LimitInputStream extends FilterInputStream {
        private long left;

        @Override // java.io.FilterInputStream, java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        public LimitInputStream(InputStream inputStream, long j) {
            super(inputStream);
            if (inputStream == null) {
                throw new NullPointerException("in");
            }
            if (j < 0) {
                throw new IllegalArgumentException("limit must be non-negative");
            }
            this.left = j;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(this.in.available(), this.left);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            throw new IOException("mark not supported");
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.left == 0) {
                return -1;
            }
            int i = this.in.read();
            if (i != -1) {
                this.left--;
            }
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            long j = this.left;
            if (j == 0) {
                return -1;
            }
            int i3 = this.in.read(bArr, i, (int) Math.min(i2, j));
            if (i3 != -1) {
                this.left -= (long) i3;
            }
            return i3;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long jSkip = this.in.skip(Math.min(j, this.left));
            this.left -= jSkip;
            return jSkip;
        }
    }
}
