package com.myscript.nebo.editing;

import com.myscript.nebo.SmartGuideController;
import com.myscript.nebo.freemium.FreemiumLimitationTrigger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PageFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0016¨\u0006\u000b"}, m1599d2 = {"com/myscript/nebo/editing/PageFragment$onViewCreated$2$3", "Lcom/myscript/nebo/SmartGuideController$BlockActionCallback;", "exportToPowerPoint", "", "boxId", "", "tryUsePremiumFeature", "trigger", "Lcom/myscript/nebo/freemium/FreemiumLimitationTrigger;", "action", "Lkotlin/Function0;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageFragment$onViewCreated$2$3 implements SmartGuideController.BlockActionCallback {
    final /* synthetic */ PageFragment this$0;

    PageFragment$onViewCreated$2$3(PageFragment pageFragment) {
        this.this$0 = pageFragment;
    }

    @Override // com.myscript.nebo.SmartGuideController.BlockActionCallback
    public void exportToPowerPoint(String boxId) {
        Intrinsics.checkNotNullParameter(boxId, "boxId");
        exportToPowerPoint(boxId);
    }

    @Override // com.myscript.nebo.SmartGuideController.BlockActionCallback
    public void tryUsePremiumFeature(FreemiumLimitationTrigger trigger, final Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(action, "action");
        this.this$0.getFreemiumLimitationViewModel().tryUsePremiumFeature(trigger, new Function0() { // from class: com.myscript.nebo.editing.PageFragment$onViewCreated$2$3$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PageFragment$onViewCreated$2$3.tryUsePremiumFeature$lambda$0(action);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tryUsePremiumFeature$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
