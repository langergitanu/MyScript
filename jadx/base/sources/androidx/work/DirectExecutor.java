package androidx.work;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DirectExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016j\u0002\b\u0005¨\u0006\f"}, m1599d2 = {"Landroidx/work/DirectExecutor;", "Ljava/util/concurrent/Executor;", "", "<init>", "(Ljava/lang/String;I)V", "INSTANCE", "execute", "", "command", "Ljava/lang/Runnable;", "toString", "", "work-runtime_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DirectExecutor implements Executor {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DirectExecutor[] $VALUES;
    public static final DirectExecutor INSTANCE = new DirectExecutor("INSTANCE", 0);

    private static final /* synthetic */ DirectExecutor[] $values() {
        return new DirectExecutor[]{INSTANCE};
    }

    public static EnumEntries<DirectExecutor> getEntries() {
        return $ENTRIES;
    }

    public static DirectExecutor valueOf(String str) {
        return (DirectExecutor) Enum.valueOf(DirectExecutor.class, str);
    }

    public static DirectExecutor[] values() {
        return (DirectExecutor[]) $VALUES.clone();
    }

    private DirectExecutor(String str, int i) {
    }

    static {
        DirectExecutor[] directExecutorArr$values = $values();
        $VALUES = directExecutorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(directExecutorArr$values);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        Intrinsics.checkNotNullParameter(command, "command");
        command.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "DirectExecutor";
    }
}
