package aws.smithy.kotlin.runtime.p011io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.smithy.kotlin.runtime.InternalApi;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkByteChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m1599d2 = {"", "autoFlush", "", "maxBufferSize", "Laws/smithy/kotlin/runtime/io/SdkByteChannel;", "SdkByteChannel", "(ZI)Laws/smithy/kotlin/runtime/io/SdkByteChannel;", "", FirebaseAnalytics.Param.CONTENT, TypedValues.CycleType.S_WAVE_OFFSET, "length", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "SdkByteReadChannel", "([BII)Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "DEFAULT_BYTE_CHANNEL_MAX_BUFFER_SIZE", "I", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkByteChannelKt {
    public static final int DEFAULT_BYTE_CHANNEL_MAX_BUFFER_SIZE = 16384;

    public static /* synthetic */ SdkByteChannel SdkByteChannel$default(boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            i = 16384;
        }
        return SdkByteChannel(z, i);
    }

    @InternalApi
    public static final SdkByteChannel SdkByteChannel(boolean z, int i) {
        return new RealSdkByteChannel(z, i);
    }

    public static /* synthetic */ SdkByteReadChannel SdkByteReadChannel$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        return SdkByteReadChannel(bArr, i, i2);
    }

    @InternalApi
    public static final SdkByteReadChannel SdkByteReadChannel(byte[] content, int i, int i2) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new RealSdkByteChannel(content, i, i2);
    }
}
