package com.myscript.nebo.editing;

import com.myscript.nebo.discoverability.DiscoverabilityManager;
import com.myscript.nebo.discoverability.IDiscoverableFeature;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.editing.discoverability.EditingDiscoverableFeature;
import com.myscript.nebo.editing.discoverability.EditingDiscoverableFeatureKt;
import com.myscript.snt.dms.PageType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NoteEditorViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.NoteEditorViewModel$initDiscoverability$1$1$1$1", m1609f = "NoteEditorViewModel.kt", m1610i = {0, 0, 0, 0}, m1611l = {264}, m1612m = "invokeSuspend", m1613n = {"textExclusions", "pdfExclusions", "containerExclusions", "boardExclusions"}, m1614nl = {273}, m1615s = {"L$0", "L$1", "L$2", "L$3"}, m1616v = 2)
final class NoteEditorViewModel$initDiscoverability$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PageModel $note;
    final /* synthetic */ PageType $pageType;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ NoteEditorViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NoteEditorViewModel$initDiscoverability$1$1$1$1(NoteEditorViewModel noteEditorViewModel, PageType pageType, PageModel pageModel, Continuation<? super NoteEditorViewModel$initDiscoverability$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = noteEditorViewModel;
        this.$pageType = pageType;
        this.$note = pageModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NoteEditorViewModel$initDiscoverability$1$1$1$1(this.this$0, this.$pageType, this.$note, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NoteEditorViewModel$initDiscoverability$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.isFreemiumBusinessModelEnabled) {
                Set of = SetsKt.setOf(EditingDiscoverableFeature.BoardFeature.INSTANCE, EditingDiscoverableFeature.NotebookFeature.INSTANCE, EditingDiscoverableFeature.PdfFeature.INSTANCE, EditingDiscoverableFeature.ConvertTextFeature.INSTANCE, EditingDiscoverableFeature.PdfAddPageFeature.INSTANCE, EditingDiscoverableFeature.PdfOptimizationFeature.INSTANCE);
                Set of2 = SetsKt.setOf(EditingDiscoverableFeature.DocumentFeature.INSTANCE, EditingDiscoverableFeature.BoardFeature.INSTANCE, EditingDiscoverableFeature.NotebookFeature.INSTANCE, EditingDiscoverableFeature.DocumentConvertTextFeature.INSTANCE, EditingDiscoverableFeature.AIExplainFeature.INSTANCE);
                Set of3 = SetsKt.setOf(EditingDiscoverableFeature.DocumentFeature.INSTANCE, EditingDiscoverableFeature.BoardFeature.INSTANCE, EditingDiscoverableFeature.PdfFeature.INSTANCE, EditingDiscoverableFeature.DocumentConvertTextFeature.INSTANCE, EditingDiscoverableFeature.PdfAddPageFeature.INSTANCE, EditingDiscoverableFeature.PdfOptimizationFeature.INSTANCE);
                Set of4 = SetsKt.setOf(EditingDiscoverableFeature.DocumentFeature.INSTANCE, EditingDiscoverableFeature.NotebookFeature.INSTANCE, EditingDiscoverableFeature.PdfFeature.INSTANCE, EditingDiscoverableFeature.DocumentConvertTextFeature.INSTANCE, EditingDiscoverableFeature.PdfAddPageFeature.INSTANCE, EditingDiscoverableFeature.PdfOptimizationFeature.INSTANCE);
                DiscoverabilityManager discoverabilityManager = this.this$0.discoverabilityManager;
                if (discoverabilityManager != null) {
                    List<IDiscoverableFeature> editingDiscoverableFeatures = EditingDiscoverableFeatureKt.getEditingDiscoverableFeatures();
                    PageType pageType = this.$pageType;
                    PageModel pageModel = this.$note;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : editingDiscoverableFeatures) {
                        IDiscoverableFeature iDiscoverableFeature = (IDiscoverableFeature) obj2;
                        if ((pageType == PageType.TextDocument && !CollectionsKt.contains(of, iDiscoverableFeature)) || ((pageType == PageType.PDF && !CollectionsKt.contains(of2, iDiscoverableFeature)) || ((pageType == PageType.RawContent && pageModel.isContainer() && !CollectionsKt.contains(of3, iDiscoverableFeature)) || (pageType == PageType.RawContent && !pageModel.isContainer() && !CollectionsKt.contains(of4, iDiscoverableFeature))))) {
                            arrayList.add(obj2);
                        }
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(of);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(of2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(of3);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(of4);
                    this.label = 1;
                    if (discoverabilityManager.updateDiscoverableFeaturesList(arrayList, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
