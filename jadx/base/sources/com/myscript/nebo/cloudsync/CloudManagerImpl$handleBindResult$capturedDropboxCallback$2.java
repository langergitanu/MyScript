package com.myscript.nebo.cloudsync;

import com.myscript.nebo.dms.dropbox.DropboxCallback;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CloudManagerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class CloudManagerImpl$handleBindResult$capturedDropboxCallback$2 implements DropboxCallback.ErrorCallback, FunctionAdapter {
    final /* synthetic */ CloudManagerImpl $tmp0;

    CloudManagerImpl$handleBindResult$capturedDropboxCallback$2(CloudManagerImpl cloudManagerImpl) {
        this.$tmp0 = cloudManagerImpl;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof DropboxCallback.ErrorCallback) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(2, this.$tmp0, CloudManagerImpl.class, "handleErrorAndThrow", "handleErrorAndThrow(Ljava/lang/String;Ljava/lang/Exception;)Ljava/lang/Void;", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // com.myscript.nebo.dms.dropbox.DropboxCallback.ErrorCallback
    public final Void handleAndThrowError(String str, Exception p1) throws Exception {
        Intrinsics.checkNotNullParameter(p1, "p1");
        this.$tmp0.handleErrorAndThrow(str, p1);
        throw new KotlinNothingValueException();
    }
}
