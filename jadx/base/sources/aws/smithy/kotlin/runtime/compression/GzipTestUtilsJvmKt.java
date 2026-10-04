package aws.smithy.kotlin.runtime.compression;

import aws.smithy.kotlin.runtime.InternalApi;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.ByteStreamsKt;

/* JADX INFO: compiled from: GzipTestUtilsJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0002\u0010\u0012\n\u0002\b\u0004\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"", "bytes", "decompressGzipBytes", "([B)[B", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GzipTestUtilsJvmKt {
    @InternalApi
    public static final byte[] decompressGzipBytes(byte[] bytes) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bytes));
        try {
            byte[] bytes2 = ByteStreamsKt.readBytes(gZIPInputStream);
            gZIPInputStream.close();
            return bytes2;
        } catch (Throwable th) {
            try {
                gZIPInputStream.close();
            } catch (Throwable th2) {
                ExceptionsKt.addSuppressed(th, th2);
            }
            throw th;
        }
    }
}
