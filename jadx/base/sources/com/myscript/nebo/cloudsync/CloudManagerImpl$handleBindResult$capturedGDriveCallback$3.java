package com.myscript.nebo.cloudsync;

import com.myscript.nebo.dms.core.LibraryRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: CloudManagerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class CloudManagerImpl$handleBindResult$capturedGDriveCallback$3 extends FunctionReferenceImpl implements Function0<Unit> {
    CloudManagerImpl$handleBindResult$capturedGDriveCallback$3(Object obj) {
        super(0, obj, LibraryRepository.class, "notifyCloudStorageFull", "notifyCloudStorageFull()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((LibraryRepository) this.receiver).notifyCloudStorageFull();
    }
}
