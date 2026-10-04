package com.myscript.nebo.inspector;

import android.app.Application;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NeboFilesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "Lcom/myscript/nebo/inspector/NeboFile;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboFilesViewModel$reload$1$foundFiles$1", m1609f = "NeboFilesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class NeboFilesViewModel$reload$1$foundFiles$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends NeboFile>>, Object> {
    int label;
    final /* synthetic */ NeboFilesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NeboFilesViewModel$reload$1$foundFiles$1(NeboFilesViewModel neboFilesViewModel, Continuation<? super NeboFilesViewModel$reload$1$foundFiles$1> continuation) {
        super(2, continuation);
        this.this$0 = neboFilesViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NeboFilesViewModel$reload$1$foundFiles$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends NeboFile>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<NeboFile>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<NeboFile>> continuation) {
        return ((NeboFilesViewModel$reload$1$foundFiles$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List listFindFiles$default = NeboFilesInspector.findFiles$default(this.this$0.inspector, null, 1, null);
            Application application = this.this$0.application;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFindFiles$default, 10));
            Iterator it = listFindFiles$default.iterator();
            while (it.hasNext()) {
                arrayList.add(NeboInspectorActivityKt.createNeboFile(application, (File) it.next()));
            }
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
