package com.myscript.nebo.editing;

import androidx.lifecycle.MutableLiveData;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.nebo.common.utils.PageBackgroundUtilsKt;
import com.myscript.snt.core.PageKey;
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
@DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$pageListener$1$onPageUpdated$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class PageViewModel$pageListener$1$onPageUpdated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $newBackgroundColor;
    final /* synthetic */ int $newBackgroundColorIndex;
    final /* synthetic */ BackgroundPattern $newBackgroundPattern;
    final /* synthetic */ PageKey $pageKey;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageViewModel$pageListener$1$onPageUpdated$1(PageViewModel pageViewModel, int i, BackgroundPattern backgroundPattern, int i2, PageKey pageKey, Continuation<? super PageViewModel$pageListener$1$onPageUpdated$1> continuation) {
        super(2, continuation);
        this.this$0 = pageViewModel;
        this.$newBackgroundColor = i;
        this.$newBackgroundPattern = backgroundPattern;
        this.$newBackgroundColorIndex = i2;
        this.$pageKey = pageKey;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$pageListener$1$onPageUpdated$1(this.this$0, this.$newBackgroundColor, this.$newBackgroundPattern, this.$newBackgroundColorIndex, this.$pageKey, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PageViewModel$pageListener$1$onPageUpdated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        int iResolveBackgroundColor = (this.this$0.getOpenPageProperties().getPageType() != PageType.PDF && PageBackgroundUtilsKt.getLIGHT_BACKGROUND_COLORS().contains(Boxing.boxInt(this.$newBackgroundColor))) ? PageBackgroundUtilsKt.resolveBackgroundColor(this.$newBackgroundColor, this.this$0.getDarkMode()) : this.$newBackgroundColor;
        int i = iResolveBackgroundColor;
        MutableLiveData mutableLiveData = this.this$0._pageProperties;
        PageProperties pageProperties = (PageProperties) this.this$0._pageProperties.getValue();
        mutableLiveData.setValue(pageProperties != null ? PageProperties.copy$default(pageProperties, null, false, null, i, this.$newBackgroundPattern, false, 39, null) : null);
        this.this$0.selectedBackgroundColorIndex = this.$newBackgroundColorIndex;
        this.this$0._backgroundSettingsUIState.setValue(this.this$0.computeBackgroundSettingsUIState(this.$pageKey));
        return Unit.INSTANCE;
    }
}
