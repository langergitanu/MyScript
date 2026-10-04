package aws.smithy.kotlin.runtime.p011io;

import androidx.exifinterface.media.ExifInterface;
import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BuffereredSourceAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a6\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\b\u0003H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, m1599d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/io/SdkBufferedSource;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "wrapOkio", "(Laws/smithy/kotlin/runtime/io/SdkBufferedSource;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BuffereredSourceAdapterKt {
    public static final <T> T wrapOkio(SdkBufferedSource sdkBufferedSource, Function1<? super SdkBufferedSource, ? extends T> block) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke(sdkBufferedSource);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }
}
