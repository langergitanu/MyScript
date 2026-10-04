package com.myscript.nebo.export;

import android.app.Application;
import androidx.window.core.layout.WindowSizeClass;
import com.myscript.atk.core.DocumentType;
import com.myscript.atk.core.MimeType;
import com.myscript.atk.p021ui.SmartGuideComponent;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.editing.ConfPathExtKt;
import com.myscript.nebo.editing.PageLoader;
import com.myscript.nebo.editing.PageParam;
import com.myscript.nebo.export.ExportViewModel;
import com.myscript.snt.core.DisplayContext;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.PageControllerSanitized;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.RecoContext;
import com.myscript.snt.core.SWIGOptionContext;
import com.myscript.snt.core.SmartGuideManager;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ExportViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/export/ExportViewModel$State;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.export.ExportViewModel$exportToPowerPoint$1$state$1", m1609f = "ExportViewModel.kt", m1610i = {0, 0, 0}, m1611l = {319}, m1612m = "invokeSuspend", m1613n = {"outputFile", "confPath", "pageLoader"}, m1614nl = {PDFACompliance.e_PDFA3_2_3}, m1615s = {"L$0", "L$1", "L$2"}, m1616v = 2)
final class ExportViewModel$exportToPowerPoint$1$state$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ExportViewModel.State>, Object> {
    final /* synthetic */ Application $application;
    final /* synthetic */ String $boxId;
    final /* synthetic */ String $fileName;
    final /* synthetic */ PageKey $pageKey;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ExportViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExportViewModel$exportToPowerPoint$1$state$1(Application application, String str, PageKey pageKey, ExportViewModel exportViewModel, String str2, Continuation<? super ExportViewModel$exportToPowerPoint$1$state$1> continuation) {
        super(2, continuation);
        this.$application = application;
        this.$fileName = str;
        this.$pageKey = pageKey;
        this.this$0 = exportViewModel;
        this.$boxId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExportViewModel$exportToPowerPoint$1$state$1(this.$application, this.$fileName, this.$pageKey, this.this$0, this.$boxId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ExportViewModel.State> continuation) {
        return ((ExportViewModel$exportToPowerPoint$1$state$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objLoad$default;
        File file;
        SmartGuideComponent smartGuideComponent;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                File file2 = new File(this.$application.getCacheDir(), this.$fileName);
                List<String> confPath = ConfPathExtKt.getConfPath(this.$application);
                PageLoader pageLoader = new PageLoader(null, 1, null);
                this.L$0 = file2;
                this.L$1 = SpillingKt.nullOutSpilledVariable(confPath);
                this.L$2 = SpillingKt.nullOutSpilledVariable(pageLoader);
                this.label = 1;
                objLoad$default = PageLoader.load$default(pageLoader, new PageParam.ByKey(this.$pageKey, new C64601(this.this$0.libraryRepository)), this.this$0.displayMetrics.xdpi, this.this$0.displayMetrics.ydpi, this.this$0.displayMetrics.scaledDensity, confPath, false, false, null, null, this, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
                if (objLoad$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                file = file2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                file = (File) this.L$0;
                ResultKt.throwOnFailure(obj);
                objLoad$default = obj;
            }
            AutoCloseable autoCloseable = (AutoCloseable) objLoad$default;
            ExportViewModel exportViewModel = this.this$0;
            PageKey pageKey = this.$pageKey;
            String str = this.$boxId;
            try {
                PageController pageController = (PageController) autoCloseable;
                exportViewModel.libraryRepository.save(pageKey, pageController, true);
                SmartGuideManager smartGuideManager = pageController.getSmartGuideManager();
                if (smartGuideManager != null && (smartGuideComponent = smartGuideManager.getSmartGuideComponent()) != null) {
                    smartGuideComponent.exportBox(DocumentType.Presentation, str, file.getAbsolutePath());
                    Unit unit = Unit.INSTANCE;
                }
                AutoCloseableKt.closeFinally(autoCloseable, null);
                return new ExportViewModel.State.Done(ExportHelper.getExportIntent(this.this$0.getApplication(), MimeType.PPTX, CollectionsKt.listOf(file.getAbsolutePath())));
            } finally {
            }
        } catch (Exception e) {
            return new ExportViewModel.State.Error("Error while loading or exporting the page", e);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.export.ExportViewModel$exportToPowerPoint$1$state$1$1 */
    /* JADX INFO: compiled from: ExportViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C64601 extends FunctionReferenceImpl implements Function4<PageKey, DisplayContext, RecoContext, SWIGOptionContext, PageControllerSanitized> {
        C64601(Object obj) {
            super(4, obj, LibraryRepository.class, "getPageController", "getPageController(Lcom/myscript/snt/core/PageKey;Lcom/myscript/snt/core/DisplayContext;Lcom/myscript/snt/core/RecoContext;Lcom/myscript/snt/core/SWIGOptionContext;)Lcom/myscript/snt/core/PageControllerSanitized;", 0);
        }

        @Override // kotlin.jvm.functions.Function4
        public final PageControllerSanitized invoke(PageKey p0, DisplayContext p1, RecoContext p2, SWIGOptionContext p3) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            Intrinsics.checkNotNullParameter(p2, "p2");
            Intrinsics.checkNotNullParameter(p3, "p3");
            return ((LibraryRepository) this.receiver).getPageController(p0, p1, p2, p3);
        }
    }
}
