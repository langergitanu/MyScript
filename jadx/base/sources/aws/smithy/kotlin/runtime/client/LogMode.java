package aws.smithy.kotlin.runtime.client;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.webkit.Profile;
import aws.smithy.kotlin.runtime.ClientException;
import com.survicate.surveys.TextRecallingManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LogMode.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00152\u00020\u0001:\u0007\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0086\u0002J\u0011\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0086\u0002J\u0014\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0000J\n\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0006\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/LogMode;", "", "mask", "", "<init>", "(I)V", "plus", "mode", "minus", "equals", "", "other", "isEnabled", "toString", "", Profile.DEFAULT_PROFILE_NAME, "LogRequest", "LogRequestWithBody", "LogResponse", "LogResponseWithBody", "Composite", "Companion", "Laws/smithy/kotlin/runtime/client/LogMode$Composite;", "Laws/smithy/kotlin/runtime/client/LogMode$Default;", "Laws/smithy/kotlin/runtime/client/LogMode$LogRequest;", "Laws/smithy/kotlin/runtime/client/LogMode$LogRequestWithBody;", "Laws/smithy/kotlin/runtime/client/LogMode$LogResponse;", "Laws/smithy/kotlin/runtime/client/LogMode$LogResponseWithBody;", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class LogMode {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int mask;

    public /* synthetic */ LogMode(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private LogMode(int i) {
        this.mask = i;
    }

    /* JADX INFO: compiled from: LogMode.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005H\u0096\u0080\u0004¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/LogMode$Default;", "Laws/smithy/kotlin/runtime/client/LogMode;", "<init>", "()V", "toString", "", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Default extends LogMode {
        public static final Default INSTANCE = new Default();

        private Default() {
            super(0, null);
        }

        @Override // aws.smithy.kotlin.runtime.client.LogMode
        public String toString() {
            return Profile.DEFAULT_PROFILE_NAME;
        }
    }

    /* JADX INFO: compiled from: LogMode.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005H\u0096\u0080\u0004¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/LogMode$LogRequest;", "Laws/smithy/kotlin/runtime/client/LogMode;", "<init>", "()V", "toString", "", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class LogRequest extends LogMode {
        public static final LogRequest INSTANCE = new LogRequest();

        private LogRequest() {
            super(1, null);
        }

        @Override // aws.smithy.kotlin.runtime.client.LogMode
        public String toString() {
            return "LogRequest";
        }
    }

    /* JADX INFO: compiled from: LogMode.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005H\u0096\u0080\u0004¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/LogMode$LogRequestWithBody;", "Laws/smithy/kotlin/runtime/client/LogMode;", "<init>", "()V", "toString", "", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class LogRequestWithBody extends LogMode {
        public static final LogRequestWithBody INSTANCE = new LogRequestWithBody();

        private LogRequestWithBody() {
            super(3, null);
        }

        @Override // aws.smithy.kotlin.runtime.client.LogMode
        public String toString() {
            return "LogRequestWithBody";
        }
    }

    /* JADX INFO: compiled from: LogMode.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005H\u0096\u0080\u0004¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/LogMode$LogResponse;", "Laws/smithy/kotlin/runtime/client/LogMode;", "<init>", "()V", "toString", "", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class LogResponse extends LogMode {
        public static final LogResponse INSTANCE = new LogResponse();

        private LogResponse() {
            super(4, null);
        }

        @Override // aws.smithy.kotlin.runtime.client.LogMode
        public String toString() {
            return "LogResponse";
        }
    }

    /* JADX INFO: compiled from: LogMode.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005H\u0096\u0080\u0004¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/LogMode$LogResponseWithBody;", "Laws/smithy/kotlin/runtime/client/LogMode;", "<init>", "()V", "toString", "", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class LogResponseWithBody extends LogMode {
        public static final LogResponseWithBody INSTANCE = new LogResponseWithBody();

        private LogResponseWithBody() {
            super(12, null);
        }

        @Override // aws.smithy.kotlin.runtime.client.LogMode
        public String toString() {
            return "LogResponseWithBody";
        }
    }

    /* JADX INFO: compiled from: LogMode.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/LogMode$Composite;", "Laws/smithy/kotlin/runtime/client/LogMode;", "mask", "", "<init>", "(I)V", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Composite extends LogMode {
        public Composite(int i) {
            super(i, null);
        }
    }

    public final LogMode plus(LogMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        return new Composite(mode.mask | this.mask);
    }

    public final LogMode minus(LogMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        return new Composite((~mode.mask) & this.mask);
    }

    public boolean equals(Object other) {
        return (other instanceof LogMode) && this.mask == ((LogMode) other).mask;
    }

    public final boolean isEnabled(LogMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        int i = this.mask;
        int i2 = mode.mask;
        return (i & i2) == i2;
    }

    /* JADX INFO: compiled from: LogMode.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/LogMode$Companion;", "", "<init>", "()V", "allModes", "", "Laws/smithy/kotlin/runtime/client/LogMode;", "fromString", TypedValues.Custom.S_STRING, "", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<LogMode> allModes() {
            return CollectionsKt.listOf((Object[]) new LogMode[]{LogRequest.INSTANCE, LogRequestWithBody.INSTANCE, LogResponse.INSTANCE, LogResponseWithBody.INSTANCE});
        }

        public final LogMode fromString(String string) {
            Object next;
            Intrinsics.checkNotNullParameter(string, "string");
            List<String> listSplit$default = StringsKt.split$default((CharSequence) StringsKt.trim((CharSequence) string).toString(), new String[]{"|"}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
            for (String str : listSplit$default) {
                Iterator<T> it = LogMode.INSTANCE.allModes().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (StringsKt.equals(str, ((LogMode) next).toString(), true)) {
                        break;
                    }
                }
                LogMode logMode = (LogMode) next;
                if (logMode == null) {
                    throw new ClientException("Log mode " + str + " is not supported, should be one or more of: " + CollectionsKt.joinToString$default(LogMode.INSTANCE.allModes(), TextRecallingManager.ANSWER_SEPARATOR, null, null, 0, null, null, 62, null));
                }
                arrayList.add(logMode);
            }
            Iterator it2 = arrayList.iterator();
            if (!it2.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next2 = it2.next();
            while (it2.hasNext()) {
                next2 = ((LogMode) next2).plus((LogMode) it2.next());
            }
            return (LogMode) next2;
        }
    }

    public String toString() {
        List<LogMode> listAllModes = INSTANCE.allModes();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listAllModes) {
            if (isEnabled((LogMode) obj)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, "|", null, null, 0, null, null, 62, null);
    }
}
