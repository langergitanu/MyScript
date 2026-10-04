package com.myscript.nebo.editing;

import androidx.lifecycle.MutableLiveData;
import com.myscript.nebo.common.utils.PageBackgroundUtilsKt;
import com.myscript.snt.dms.PageType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$darkMode$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class PageViewModel$darkMode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageViewModel$darkMode$1(PageViewModel pageViewModel, Continuation<? super PageViewModel$darkMode$1> continuation) {
        super(2, continuation);
        this.this$0 = pageViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$darkMode$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PageViewModel$darkMode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData mutableLiveData = this.this$0._backgroundSettingsUIState;
            PageViewModel pageViewModel = this.this$0;
            mutableLiveData.setValue(pageViewModel.computeBackgroundSettingsUIState(pageViewModel.getOpenPageKey()));
            int iResolveBackgroundColor = (this.this$0.getOpenPageProperties().getPageType() != PageType.PDF && PageBackgroundUtilsKt.getLIGHT_BACKGROUND_COLORS().contains(Boxing.boxInt(this.this$0.getSelectedBackgroundColor()))) ? PageBackgroundUtilsKt.resolveBackgroundColor(this.this$0.getSelectedBackgroundColor(), this.this$0.getDarkMode()) : this.this$0.getSelectedBackgroundColor();
            int i = iResolveBackgroundColor;
            MutableLiveData mutableLiveData2 = this.this$0._pageProperties;
            PageProperties pageProperties = (PageProperties) this.this$0._pageProperties.getValue();
            mutableLiveData2.setValue(pageProperties != null ? PageProperties.copy$default(pageProperties, null, false, null, i, null, false, 55, null) : null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
