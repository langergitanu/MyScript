package com.myscript.nebo.editing;

import com.myscript.atk.core.Point;
import com.myscript.atk.p021ui.ActionMenuCallback;
import com.myscript.atk.p021ui.ActionMenuEntry;
import com.myscript.atk.p021ui.IActionMenuListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: PageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003BC\u0012:\u0010\u0004\u001a6\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b¢\u0006\u0004\b\f\u0010\rJ;\u0010\u000e\u001a\u00020\n2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\nH\u0016RB\u0010\u0004\u001a6\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/editing/ActionMenuListener;", "Lcom/myscript/atk/ui/IActionMenuListener;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "delegate", "Lkotlin/Function4;", "", "Lcom/myscript/atk/ui/ActionMenuEntry;", "Lcom/myscript/atk/core/Point;", "Lcom/myscript/atk/ui/ActionMenuCallback;", "", "Lcom/myscript/nebo/editing/ActionMenuListenerDelegate;", "<init>", "(Lkotlin/jvm/functions/Function4;)V", "actionMenuChanged", "actions", "inputPoint", "menuPoint", "callback", "([Lcom/myscript/atk/ui/ActionMenuEntry;Lcom/myscript/atk/core/Point;Lcom/myscript/atk/core/Point;Lcom/myscript/atk/ui/ActionMenuCallback;)V", "close", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class ActionMenuListener implements IActionMenuListener, AutoCloseable {
    private Function4<? super ActionMenuEntry[], ? super Point, ? super Point, ? super ActionMenuCallback, Unit> delegate;

    public ActionMenuListener(Function4<? super ActionMenuEntry[], ? super Point, ? super Point, ? super ActionMenuCallback, Unit> function4) {
        this.delegate = function4;
    }

    @Override // com.myscript.atk.p021ui.IActionMenuListener
    public void actionMenuChanged(ActionMenuEntry[] actions, Point inputPoint, Point menuPoint, ActionMenuCallback callback) {
        Function4<? super ActionMenuEntry[], ? super Point, ? super Point, ? super ActionMenuCallback, Unit> function4 = this.delegate;
        if (function4 != null) {
            function4.invoke(actions, inputPoint, menuPoint, callback);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.delegate = null;
    }
}
