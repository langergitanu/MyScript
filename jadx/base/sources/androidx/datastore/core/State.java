package androidx.datastore.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: State.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, m1599d2 = {"Landroidx/datastore/core/State;", ExifInterface.GPS_DIRECTION_TRUE, "", "version", "", "<init>", "(I)V", "getVersion", "()I", "Landroidx/datastore/core/Data;", "Landroidx/datastore/core/Final;", "Landroidx/datastore/core/NoValueDataState;", "Landroidx/datastore/core/ReadException;", "Landroidx/datastore/core/UnInitialized;", "datastore-core"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public abstract class State<T> {
    private final int version;

    public /* synthetic */ State(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private State(int i) {
        this.version = i;
    }

    public final int getVersion() {
        return this.version;
    }
}
