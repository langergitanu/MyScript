package com.myscript.nebo.settings;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.preference.PreferenceViewHolder;
import androidx.window.core.layout.WindowSizeClass;
import com.myscript.android.utils.AssetManagerExt;
import com.myscript.android.utils.ViewExt;
import com.myscript.nebo.common.utils.DisplayMetricsExtKt;
import com.myscript.nebo.editing.ConfPathExtKt;
import com.myscript.nebo.editing.EditingController;
import com.myscript.nebo.editing.PageControllerLoadingException;
import com.myscript.nebo.editing.PageControllerState;
import com.myscript.nebo.editing.PageLoader;
import com.myscript.nebo.editing.PageParam;
import com.myscript.nebo.editing.impl.p027ui.NeboPageView;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.SingleColumnGridFactoryStrategy;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.File;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PagePreviewPreference.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.settings.PagePreviewPreference$onBindViewHolder$1$1", m1609f = "PagePreviewPreference.kt", m1610i = {0, 0, 1, 1, 1, 1, 1}, m1611l = {AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID, PDFACompliance.e_PDFA1_3_3}, m1612m = "invokeSuspend", m1613n = {"lpuDir", "neboFile", "lpuDir", "neboFile", "confPath", "displayMetrics", "pageLoader"}, m1614nl = {PDFACompliance.e_PDFA1_2_1, 137}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4"}, m1616v = 2)
final class PagePreviewPreference$onBindViewHolder$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ViewGroup $editingLayout;
    final /* synthetic */ PreferenceViewHolder $holder;
    final /* synthetic */ View $inkTestView;
    final /* synthetic */ View $testHereView;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ PagePreviewPreference this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagePreviewPreference$onBindViewHolder$1$1(PagePreviewPreference pagePreviewPreference, PreferenceViewHolder preferenceViewHolder, ViewGroup viewGroup, View view, View view2, Continuation<? super PagePreviewPreference$onBindViewHolder$1$1> continuation) {
        super(2, continuation);
        this.this$0 = pagePreviewPreference;
        this.$holder = preferenceViewHolder;
        this.$editingLayout = viewGroup;
        this.$inkTestView = view;
        this.$testHereView = view2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PagePreviewPreference$onBindViewHolder$1$1(this.this$0, this.$holder, this.$editingLayout, this.$inkTestView, this.$testHereView, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PagePreviewPreference$onBindViewHolder$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|61|(1:(1:(17:6|7|8|30|62|31|(1:33)|34|(1:36)|37|38|39|(1:51)|52|(1:54)|55|56)(2:13|14))(1:15))(6:16|(3:18|(0)|29)|52|(0)|55|56)|21|66|22|26|27|(2:(0)|(1:65))) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a5, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a6, code lost:
    
        android.util.Log.e(com.myscript.nebo.settings.PagePreviewPreference.TAG, "Unable to retrieve conf path", r0);
        r0 = kotlin.collections.CollectionsKt.emptyList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x010f, code lost:
    
        if (r0 == r2) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x019c A[PHI: r2
      0x019c: PHI (r2v4 android.view.View) = (r2v2 android.view.View), (r2v7 android.view.View) binds: [B:50:0x019a, B:40:0x0182] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01ad  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        View view;
        File file;
        File file2;
        Object objLoad$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
            } catch (Throwable th) {
                View view2 = this.this$0.loadingView;
                if (view2 != null) {
                    ViewExt.fadeOut$default(view2, 0L, 0L, 3, null);
                }
                throw th;
            }
        } catch (PageControllerLoadingException e) {
            Log.e(PagePreviewPreference.TAG, "Error during page controller loading", e);
            view = this.this$0.loadingView;
            if (view != null) {
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            file = new File(this.this$0.getContext().getCacheDir(), "page_preview");
            file2 = new File(file, this.this$0.neboAssetPath);
            if (!file2.exists()) {
                this.L$0 = file;
                this.L$1 = file2;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new C67881(this.this$0, file2, null), this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (this.this$0.isDetached) {
            }
            return Unit.INSTANCE;
        }
        if (i == 1) {
            file2 = (File) this.L$1;
            file = (File) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objLoad$default = obj;
            AutoCloseable autoCloseable = (AutoCloseable) objLoad$default;
            PagePreviewPreference pagePreviewPreference = this.this$0;
            final ViewGroup viewGroup = this.$editingLayout;
            final View view3 = this.$inkTestView;
            final View view4 = this.$testHereView;
            try {
                PageController pageController = (PageController) autoCloseable;
                pageController.setColorInversionPolicy(pagePreviewPreference.colorPolicy);
                pageController.setGridStrategy(new SingleColumnGridFactoryStrategy());
                EditingController editingController = pagePreviewPreference.editingCtrl;
                if (editingController != null) {
                    editingController.setTextDisplaySettings(pagePreviewPreference.fontSize, pagePreviewPreference.lineHeight);
                }
                Context context = viewGroup.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                pagePreviewPreference.pageControllerState = PageControllerState.INSTANCE.bind(pageController, new NeboPageView(DisplayMetricsExtKt.getFixedDisplayMetrics(context), false));
                EditingController editingController2 = pagePreviewPreference.editingCtrl;
                if (editingController2 != null) {
                    editingController2.setPageController(pagePreviewPreference.pageControllerState, false, false, false, false, 16);
                }
                viewGroup.post(new Runnable() { // from class: com.myscript.nebo.settings.PagePreviewPreference$onBindViewHolder$1$1$2$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewExt.fadeIn$default(viewGroup, 0L, 0L, 3, null);
                        ViewExt.fadeIn$default(view3, 0L, 0L, 3, null);
                        ViewExt.fadeIn$default(view4, 0L, 0L, 3, null);
                    }
                });
                AutoCloseableKt.closeFinally(autoCloseable, null);
                view = this.this$0.loadingView;
                if (view != null) {
                    ViewExt.fadeOut$default(view, 0L, 0L, 3, null);
                }
                if (this.this$0.isDetached) {
                    this.this$0.unbindPageController();
                }
                return Unit.INSTANCE;
            } finally {
            }
        }
        File file3 = file2;
        File file4 = file;
        Context applicationContext = this.this$0.getContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        List<String> listEmptyList = ConfPathExtKt.getConfPath(applicationContext);
        List<String> list = listEmptyList;
        Context context2 = this.$holder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        DisplayMetrics fixedDisplayMetrics = DisplayMetricsExtKt.getFixedDisplayMetrics(context2);
        PageLoader pageLoader = new PageLoader(null, 1, null);
        this.L$0 = SpillingKt.nullOutSpilledVariable(file4);
        this.L$1 = SpillingKt.nullOutSpilledVariable(file3);
        this.L$2 = SpillingKt.nullOutSpilledVariable(list);
        this.L$3 = SpillingKt.nullOutSpilledVariable(fixedDisplayMetrics);
        this.L$4 = SpillingKt.nullOutSpilledVariable(pageLoader);
        this.label = 2;
        objLoad$default = PageLoader.load$default(pageLoader, new PageParam.Standalone(file4, file3, 0, 4, null), fixedDisplayMetrics.xdpi, fixedDisplayMetrics.ydpi, fixedDisplayMetrics.scaledDensity, list, false, false, null, null, this, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.PagePreviewPreference$onBindViewHolder$1$1$1 */
    /* JADX INFO: compiled from: PagePreviewPreference.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.settings.PagePreviewPreference$onBindViewHolder$1$1$1", m1609f = "PagePreviewPreference.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $neboFile;
        int label;
        final /* synthetic */ PagePreviewPreference this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67881(PagePreviewPreference pagePreviewPreference, File file, Continuation<? super C67881> continuation) {
            super(2, continuation);
            this.this$0 = pagePreviewPreference;
            this.$neboFile = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C67881(this.this$0, this.$neboFile, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67881) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AssetManager assets = this.this$0.getContext().getAssets();
            Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
            AssetManagerExt.copyAsset(assets, this.this$0.neboAssetPath, this.$neboFile);
            return Unit.INSTANCE;
        }
    }
}
