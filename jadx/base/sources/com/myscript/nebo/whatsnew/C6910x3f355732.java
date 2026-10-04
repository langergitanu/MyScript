package com.myscript.nebo.whatsnew;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: com.myscript.nebo.whatsnew.PLSMigrationViewModel$triggerLocalMigration$2$migrationSucceeded$1 */
/* JADX INFO: compiled from: PLSMigrationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.whatsnew.PLSMigrationViewModel$triggerLocalMigration$2$migrationSucceeded$1", m1609f = "PLSMigrationViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class C6910x3f355732 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ PLSMigrationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C6910x3f355732(PLSMigrationViewModel pLSMigrationViewModel, Continuation<? super C6910x3f355732> continuation) {
        super(2, continuation);
        this.this$0 = pLSMigrationViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C6910x3f355732(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((C6910x3f355732) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        PLSMigrationProgress pLSMigrationLogListener = new PLSMigrationLogListener(this.this$0.onMigrationLog);
        PLSMigrationViewModel pLSMigrationViewModel = this.this$0;
        try {
            PLSMigrationLogListener pLSMigrationLogListener2 = pLSMigrationLogListener;
            pLSMigrationLogListener = new PLSMigrationProgress(pLSMigrationViewModel.onMigrationProgress);
            try {
                boolean zMigrateToV2 = pLSMigrationViewModel.libraryMigrator.migrateToV2(pLSMigrationLogListener2, pLSMigrationLogListener);
                AutoCloseableKt.closeFinally(pLSMigrationLogListener, null);
                Boolean boolBoxBoolean = Boxing.boxBoolean(zMigrateToV2);
                AutoCloseableKt.closeFinally(pLSMigrationLogListener, null);
                return boolBoxBoolean;
            } finally {
            }
        } finally {
        }
    }
}
