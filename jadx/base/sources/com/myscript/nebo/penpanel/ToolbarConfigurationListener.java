package com.myscript.nebo.penpanel;

import com.myscript.snt.core.IToolbarConfigurationListener;
import com.myscript.snt.core.ToolbarConfiguration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ToolbarViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B%\u0012\u001c\u0010\u0004\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016R$\u0010\u0004\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolbarConfigurationListener;", "Lcom/myscript/snt/core/IToolbarConfigurationListener;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "delegate", "Lkotlin/Function1;", "Lcom/myscript/snt/core/ToolbarConfiguration;", "", "Lcom/myscript/nebo/penpanel/ToolbarConfigurationDelegate;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "toolbarChanged", "toolbarConfiguration", "close", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class ToolbarConfigurationListener implements IToolbarConfigurationListener, AutoCloseable {
    private Function1<? super ToolbarConfiguration, Unit> delegate;

    public ToolbarConfigurationListener(Function1<? super ToolbarConfiguration, Unit> function1) {
        this.delegate = function1;
    }

    @Override // com.myscript.snt.core.IToolbarConfigurationListener
    public void toolbarChanged(ToolbarConfiguration toolbarConfiguration) {
        Function1<? super ToolbarConfiguration, Unit> function1 = this.delegate;
        if (function1 != null) {
            function1.invoke(toolbarConfiguration);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.delegate = null;
    }
}
