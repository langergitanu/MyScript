package aws.smithy.kotlin.runtime.p011io;

import aws.smithy.kotlin.runtime.InternalApi;
import java.io.Closeable;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Closeable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a?\u0010\u0006\u001a\u00028\u0001\"\f\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u0001\"\u0004\b\u0001\u0010\u0003*\u00028\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, m1599d2 = {"Ljava/io/Closeable;", "Laws/smithy/kotlin/runtime/io/Closeable;", "C", "R", "Lkotlin/Function1;", "block", "use", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "", "closeIfCloseable", "(Ljava/lang/Object;)V", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CloseableKt {
    public static final <C extends Closeable, R> R use(C c, Function1<? super C, ? extends R> block) throws IOException {
        Intrinsics.checkNotNullParameter(c, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            R rInvoke = block.invoke(c);
            c.close();
            return rInvoke;
        } catch (Throwable th) {
            try {
                c.close();
            } catch (Throwable th2) {
                ExceptionsKt.addSuppressed(th, th2);
            }
            throw th;
        }
    }

    @InternalApi
    public static final void closeIfCloseable(Object obj) throws IOException {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        if (obj instanceof Closeable) {
            ((Closeable) obj).close();
        }
    }
}
