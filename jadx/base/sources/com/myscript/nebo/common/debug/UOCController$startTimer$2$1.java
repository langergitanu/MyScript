package com.myscript.nebo.common.debug;

import androidx.appcompat.app.AppCompatActivity;
import com.myscript.atk.core.Context;
import java.util.TimerTask;
import kotlin.Metadata;

/* JADX INFO: compiled from: UOCController.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m1599d2 = {"com/myscript/nebo/common/debug/UOCController$startTimer$2$1", "Ljava/util/TimerTask;", "run", "", "common_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UOCController$startTimer$2$1 extends TimerTask {
    final /* synthetic */ UOCController this$0;

    UOCController$startTimer$2$1(UOCController uOCController) {
        this.this$0 = uOCController;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        AppCompatActivity activity = this.this$0.getActivity();
        if (activity != null) {
            final UOCController uOCController = this.this$0;
            activity.runOnUiThread(new Runnable() { // from class: com.myscript.nebo.common.debug.UOCController$startTimer$2$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    UOCController$startTimer$2$1.run$lambda$0(uOCController);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void run$lambda$0(UOCController uOCController) {
        UOCView uOCView = uOCController.uoc;
        if (uOCView != null) {
            Context context = uOCController.engineContext;
            uOCView.setMax(context != null ? context.getUserObjectLimit() : 0L);
            Context context2 = uOCController.engineContext;
            uOCView.setCount(context2 != null ? context2.getUserObjectCount() : 0L);
        }
    }
}
