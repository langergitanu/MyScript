package com.myscript.nebo.editing;

import com.myscript.atk.core.Renderer;
import com.myscript.atk.core.ViewTransform;
import com.myscript.nebo.editing.impl.p027ui.NeboPageView;
import com.myscript.snt.core.PageController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PageControllerState.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageControllerState;", "", "pageController", "Lcom/myscript/snt/core/PageController;", "pageView", "Lcom/myscript/nebo/editing/impl/ui/NeboPageView;", "<init>", "(Lcom/myscript/snt/core/PageController;Lcom/myscript/nebo/editing/impl/ui/NeboPageView;)V", "getPageController", "()Lcom/myscript/snt/core/PageController;", "getPageView", "()Lcom/myscript/nebo/editing/impl/ui/NeboPageView;", "value", "", "isBound", "()Z", "unbind", "", "Companion", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageControllerState {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean isBound;
    private final PageController pageController;
    private final NeboPageView pageView;

    public /* synthetic */ PageControllerState(PageController pageController, NeboPageView neboPageView, DefaultConstructorMarker defaultConstructorMarker) {
        this(pageController, neboPageView);
    }

    @JvmStatic
    public static final PageControllerState bind(PageController pageController, NeboPageView neboPageView) {
        return INSTANCE.bind(pageController, neboPageView);
    }

    private PageControllerState(PageController pageController, NeboPageView neboPageView) {
        this.pageController = pageController;
        this.pageView = neboPageView;
        this.isBound = true;
        neboPageView.setBitmapCache(PageControllerStateKt.getImagesCache());
        ViewTransform renderer = pageController.getRenderer();
        try {
            Renderer renderer2 = renderer;
            renderer = pageController.getViewTransform();
            try {
                renderer2.setView(neboPageView, renderer, pageController.workingDirPath());
                Unit unit = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(renderer, null);
                Unit unit2 = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(renderer, null);
            } finally {
            }
        } finally {
        }
    }

    public final PageController getPageController() {
        return this.pageController;
    }

    public final NeboPageView getPageView() {
        return this.pageView;
    }

    /* JADX INFO: renamed from: isBound, reason: from getter */
    public final boolean getIsBound() {
        return this.isBound;
    }

    public final void unbind() {
        if (!this.isBound) {
            return;
        }
        this.isBound = false;
        this.pageView.setUpdatableRendering(null);
        Renderer renderer = this.pageController.getRenderer();
        try {
            renderer.setView(null, null, "");
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(renderer, null);
            this.pageView.setBitmapCache(null);
            this.pageView.releaseOffscreenManager();
            this.pageController.delete();
        } finally {
        }
    }

    /* JADX INFO: compiled from: PageControllerState.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageControllerState$Companion;", "", "<init>", "()V", "bind", "Lcom/myscript/nebo/editing/PageControllerState;", "pageController", "Lcom/myscript/snt/core/PageController;", "pageView", "Lcom/myscript/nebo/editing/impl/ui/NeboPageView;", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PageControllerState bind(PageController pageController, NeboPageView pageView) {
            Intrinsics.checkNotNullParameter(pageController, "pageController");
            Intrinsics.checkNotNullParameter(pageView, "pageView");
            PageController pageControllerNewRef = PageController.newRef(pageController);
            Intrinsics.checkNotNullExpressionValue(pageControllerNewRef, "newRef(...)");
            return new PageControllerState(pageControllerNewRef, pageView, null);
        }
    }
}
