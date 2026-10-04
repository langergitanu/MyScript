package aws.smithy.kotlin.runtime.util;

import com.revenuecat.purchases.common.events.BackendEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u00020\u0004H\u0096\u0080\u0004¢\u0006\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/OsFamily;", "", "<init>", "(Ljava/lang/String;I)V", "", "toString", "()Ljava/lang/String;", "Linux", "MacOs", "Windows", "Android", "Ios", "IpadOs", "TvOs", "WatchOs", "Unknown", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OsFamily {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ OsFamily[] $VALUES;
    public static final OsFamily Linux = new OsFamily("Linux", 0);
    public static final OsFamily MacOs = new OsFamily("MacOs", 1);
    public static final OsFamily Windows = new OsFamily("Windows", 2);
    public static final OsFamily Android = new OsFamily("Android", 3);
    public static final OsFamily Ios = new OsFamily("Ios", 4);
    public static final OsFamily IpadOs = new OsFamily("IpadOs", 5);
    public static final OsFamily TvOs = new OsFamily("TvOs", 6);
    public static final OsFamily WatchOs = new OsFamily("WatchOs", 7);
    public static final OsFamily Unknown = new OsFamily("Unknown", 8);

    /* JADX INFO: compiled from: Platform.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OsFamily.values().length];
            try {
                iArr[OsFamily.Linux.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OsFamily.MacOs.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OsFamily.Windows.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OsFamily.Android.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[OsFamily.Ios.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[OsFamily.IpadOs.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[OsFamily.TvOs.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[OsFamily.WatchOs.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[OsFamily.Unknown.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ OsFamily[] $values() {
        return new OsFamily[]{Linux, MacOs, Windows, Android, Ios, IpadOs, TvOs, WatchOs, Unknown};
    }

    public static EnumEntries<OsFamily> getEntries() {
        return $ENTRIES;
    }

    public static OsFamily valueOf(String str) {
        return (OsFamily) Enum.valueOf(OsFamily.class, str);
    }

    public static OsFamily[] values() {
        return (OsFamily[]) $VALUES.clone();
    }

    private OsFamily(String str, int i) {
    }

    static {
        OsFamily[] osFamilyArr$values = $values();
        $VALUES = osFamilyArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(osFamilyArr$values);
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "linux";
            case 2:
                return "macos";
            case 3:
                return "windows";
            case 4:
                return BackendEvent.Workflows.Context.WORKFLOW_CONTEXT_PLATFORM;
            case 5:
                return "ios";
            case 6:
                return "ipados";
            case 7:
                return "tvos";
            case 8:
                return "watchos";
            case 9:
                return "unknown";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
