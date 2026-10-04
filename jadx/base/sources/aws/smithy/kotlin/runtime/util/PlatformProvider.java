package aws.smithy.kotlin.runtime.util;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;

/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0001\rJ\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u000eÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/PlatformProvider;", "Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;", "Laws/smithy/kotlin/runtime/util/Filesystem;", "Laws/smithy/kotlin/runtime/util/OperatingSystem;", "osInfo", "()Laws/smithy/kotlin/runtime/util/OperatingSystem;", "", "isJvm", "()Z", "isAndroid", "isBrowser", "isNode", "isNative", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface PlatformProvider extends PlatformEnvironProvider, Filesystem {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    boolean isAndroid();

    boolean isBrowser();

    boolean isJvm();

    boolean isNative();

    boolean isNode();

    OperatingSystem osInfo();

    /* JADX INFO: compiled from: Platform.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/PlatformProvider$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "System", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "getSystem", "()Laws/smithy/kotlin/runtime/util/PlatformProvider;", "getSystem$annotations", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final PlatformProvider System = SystemDefaultProvider.INSTANCE;

        @InternalApi
        public static /* synthetic */ void getSystem$annotations() {
        }

        private Companion() {
        }

        public final PlatformProvider getSystem() {
            return System;
        }
    }
}
