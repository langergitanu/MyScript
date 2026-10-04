package com.myscript.nebo.cloudsync;

import com.myscript.nebo.dms.dropbox.DropboxCallback;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.myscript.nebo.cloudsync.CloudManagerImpl$sam$com_myscript_nebo_dms_dropbox_DropboxCallback_StatusCallback$0 */
/* JADX INFO: compiled from: CloudManagerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final class C6175x47b4483b implements DropboxCallback.StatusCallback, FunctionAdapter {
    private final /* synthetic */ Function0 function;

    C6175x47b4483b(Function0 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.function = function;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof DropboxCallback.StatusCallback) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // com.myscript.nebo.dms.dropbox.DropboxCallback.StatusCallback
    public final /* synthetic */ boolean isDropboxAvailable() {
        return ((Boolean) this.function.invoke()).booleanValue();
    }
}
