package com.myscript.nebo.penpanel;

import android.graphics.Canvas;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ColorPillView.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004H\u0002¨\u0006\u0005"}, m1599d2 = {"mutate", "", "Landroid/graphics/Canvas;", "block", "Lkotlin/Function1;", "penpanel_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ColorPillViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void mutate(Canvas canvas, Function1<? super Canvas, Unit> function1) {
        canvas.save();
        try {
            function1.invoke(canvas);
        } finally {
            canvas.restore();
        }
    }
}
