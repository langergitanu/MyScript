package androidx.datastore.core;

import kotlin.Metadata;

/* JADX INFO: compiled from: State.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"Landroidx/datastore/core/UnInitialized;", "Landroidx/datastore/core/State;", "", "<init>", "()V", "datastore-core"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class UnInitialized extends State<Object> {
    public static final UnInitialized INSTANCE = new UnInitialized();

    private UnInitialized() {
        super(-1, null);
    }
}
