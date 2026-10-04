package com.myscript.nebo.dms.core;

import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.FilesKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LibraryRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.dms.core.LibraryRepository$onDmsUpdate$1$dmsSyncStateChanged$1", m1609f = "LibraryRepository.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class LibraryRepository$onDmsUpdate$1$dmsSyncStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cloudOperationLoggerContent;
    final /* synthetic */ String $debugSyncStates;
    int label;
    final /* synthetic */ LibraryRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LibraryRepository$onDmsUpdate$1$dmsSyncStateChanged$1(LibraryRepository libraryRepository, String str, String str2, Continuation<? super LibraryRepository$onDmsUpdate$1$dmsSyncStateChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = libraryRepository;
        this.$cloudOperationLoggerContent = str;
        this.$debugSyncStates = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LibraryRepository$onDmsUpdate$1$dmsSyncStateChanged$1(this.this$0, this.$cloudOperationLoggerContent, this.$debugSyncStates, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LibraryRepository$onDmsUpdate$1$dmsSyncStateChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        File file = new File(this.this$0.filesDirectory, "cloud_ops.log");
        String str = this.$cloudOperationLoggerContent;
        Intrinsics.checkNotNull(str);
        FilesKt.appendText(file, str, Charsets.UTF_8);
        File file2 = new File(this.this$0.filesDirectory, "cloud_ops.log");
        String str2 = this.$debugSyncStates;
        Intrinsics.checkNotNull(str2);
        FilesKt.appendText(file2, str2, Charsets.UTF_8);
        return Unit.INSTANCE;
    }
}
