package aws.smithy.kotlin.runtime.telemetry.logging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: LoggerProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\b¨\u0006\u0004"}, m1599d2 = {"getLogger", "Laws/smithy/kotlin/runtime/telemetry/logging/Logger;", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/telemetry/logging/LoggerProvider;", "telemetry-api"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LoggerProviderKt {
    public static final /* synthetic */ <T> Logger getLogger(LoggerProvider loggerProvider) {
        Intrinsics.checkNotNullParameter(loggerProvider, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        String qualifiedName = Reflection.getOrCreateKotlinClass(Object.class).getQualifiedName();
        if (qualifiedName != null) {
            return loggerProvider.getOrCreateLogger(qualifiedName);
        }
        throw new IllegalArgumentException("getLogger<T> cannot be used on an anonymous object".toString());
    }
}
