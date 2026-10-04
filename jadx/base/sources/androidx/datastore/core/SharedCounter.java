package androidx.datastore.core;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SharedCounter.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b`\u0018\u0000 \u00072\u00020\u0001:\u0003\u0005\u0006\u0007J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, m1599d2 = {"Landroidx/datastore/core/SharedCounter;", "", "getValue", "", "incrementAndGetValue", "RealSharedCounter", "ShadowSharedCounter", "Factory", "datastore-core"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public interface SharedCounter {

    /* JADX INFO: renamed from: Factory, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    int getValue();

    int incrementAndGetValue();

    /* JADX INFO: compiled from: SharedCounter.android.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Landroidx/datastore/core/SharedCounter$RealSharedCounter;", "Landroidx/datastore/core/SharedCounter;", "nativeSharedCounter", "Landroidx/datastore/core/NativeSharedCounter;", "mappedAddress", "", "<init>", "(Landroidx/datastore/core/NativeSharedCounter;J)V", "getValue", "", "incrementAndGetValue", "datastore-core"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    private static final class RealSharedCounter implements SharedCounter {
        private final long mappedAddress;
        private final NativeSharedCounter nativeSharedCounter;

        public RealSharedCounter(NativeSharedCounter nativeSharedCounter, long j) {
            Intrinsics.checkNotNullParameter(nativeSharedCounter, "nativeSharedCounter");
            this.nativeSharedCounter = nativeSharedCounter;
            this.mappedAddress = j;
        }

        @Override // androidx.datastore.core.SharedCounter
        public int getValue() {
            return this.nativeSharedCounter.nativeGetCounterValue(this.mappedAddress);
        }

        @Override // androidx.datastore.core.SharedCounter
        public int incrementAndGetValue() {
            return this.nativeSharedCounter.nativeIncrementAndGetCounterValue(this.mappedAddress);
        }
    }

    /* JADX INFO: compiled from: SharedCounter.android.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m1599d2 = {"Landroidx/datastore/core/SharedCounter$ShadowSharedCounter;", "Landroidx/datastore/core/SharedCounter;", "<init>", "()V", "value", "Ljava/util/concurrent/atomic/AtomicInteger;", "getValue", "", "incrementAndGetValue", "datastore-core"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    private static final class ShadowSharedCounter implements SharedCounter {
        private final AtomicInteger value = new AtomicInteger(0);

        @Override // androidx.datastore.core.SharedCounter
        public int getValue() {
            return this.value.get();
        }

        @Override // androidx.datastore.core.SharedCounter
        public int incrementAndGetValue() {
            return this.value.incrementAndGet();
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SharedCounter$Factory, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SharedCounter.android.kt */
    @Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u001b\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0000¢\u0006\u0002\b\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Landroidx/datastore/core/SharedCounter$Factory;", "", "<init>", "()V", "nativeSharedCounter", "Landroidx/datastore/core/NativeSharedCounter;", "createCounterFromFd", "Landroidx/datastore/core/SharedCounter;", "pfd", "Landroid/os/ParcelFileDescriptor;", "create", "produceFile", "Lkotlin/Function0;", "Ljava/io/File;", "create$datastore_core", "isDalvik", "", "datastore-core"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final NativeSharedCounter nativeSharedCounter;

        private Companion() {
        }

        static {
            NativeSharedCounter nativeSharedCounter2;
            try {
                System.loadLibrary("datastore_shared_counter");
                nativeSharedCounter2 = new NativeSharedCounter();
            } catch (Throwable th) {
                if ($$INSTANCE.isDalvik()) {
                    throw th;
                }
                nativeSharedCounter2 = null;
            }
            nativeSharedCounter = nativeSharedCounter2;
        }

        private final SharedCounter createCounterFromFd(ParcelFileDescriptor pfd) throws IOException {
            NativeSharedCounter nativeSharedCounter2 = nativeSharedCounter;
            if (nativeSharedCounter2 == null) {
                if (!isDalvik()) {
                    return new ShadowSharedCounter();
                }
                throw new IllegalStateException("DataStore failed to load the native library to create SharedCounter.".toString());
            }
            int fd = pfd.getFd();
            if (nativeSharedCounter2.nativeTruncateFile(fd) != 0) {
                throw new IOException("Failed to truncate counter file");
            }
            long jNativeCreateSharedCounter = nativeSharedCounter2.nativeCreateSharedCounter(fd);
            if (jNativeCreateSharedCounter < 0) {
                throw new IOException("Failed to mmap counter file");
            }
            return new RealSharedCounter(nativeSharedCounter2, jNativeCreateSharedCounter);
        }

        public final SharedCounter create$datastore_core(Function0<? extends File> produceFile) throws Throwable {
            ParcelFileDescriptor parcelFileDescriptorOpen;
            Intrinsics.checkNotNullParameter(produceFile, "produceFile");
            try {
                parcelFileDescriptorOpen = ParcelFileDescriptor.open(produceFile.invoke(), 939524096);
            } catch (Throwable th) {
                th = th;
                parcelFileDescriptorOpen = null;
            }
            try {
                Intrinsics.checkNotNull(parcelFileDescriptorOpen);
                SharedCounter sharedCounterCreateCounterFromFd = createCounterFromFd(parcelFileDescriptorOpen);
                if (parcelFileDescriptorOpen != null) {
                    parcelFileDescriptorOpen.close();
                }
                return sharedCounterCreateCounterFromFd;
            } catch (Throwable th2) {
                th = th2;
                if (parcelFileDescriptorOpen != null) {
                    parcelFileDescriptorOpen.close();
                }
                throw th;
            }
        }

        private final boolean isDalvik() {
            return StringsKt.equals("dalvik", System.getProperty("java.vm.name"), true);
        }
    }
}
