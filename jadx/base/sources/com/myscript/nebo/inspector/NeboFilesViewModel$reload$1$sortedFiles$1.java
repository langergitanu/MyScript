package com.myscript.nebo.inspector;

import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NeboFilesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "Lcom/myscript/nebo/inspector/NeboFile;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboFilesViewModel$reload$1$sortedFiles$1", m1609f = "NeboFilesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class NeboFilesViewModel$reload$1$sortedFiles$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends NeboFile>>, Object> {
    final /* synthetic */ List<NeboFile> $foundFiles;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NeboFilesViewModel$reload$1$sortedFiles$1(List<NeboFile> list, Continuation<? super NeboFilesViewModel$reload$1$sortedFiles$1> continuation) {
        super(2, continuation);
        this.$foundFiles = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NeboFilesViewModel$reload$1$sortedFiles$1(this.$foundFiles, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends NeboFile>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<NeboFile>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<NeboFile>> continuation) {
        return ((NeboFilesViewModel$reload$1$sortedFiles$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return CollectionsKt.sortedWith(this.$foundFiles, new Comparator() { // from class: com.myscript.nebo.inspector.NeboFilesViewModel$reload$1$sortedFiles$1$invokeSuspend$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((NeboFile) t).getFile(), ((NeboFile) t2).getFile());
            }
        });
    }
}
