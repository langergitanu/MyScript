package com.myscript.nebo.export;

import android.app.Application;
import com.myscript.nebo.log.TechnicalLoggerExt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ExportViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.export.ExportViewModel$export$1$resultFiles$1", m1609f = "ExportViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class ExportViewModel$export$1$resultFiles$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<String>>, Object> {
    final /* synthetic */ Application $application;
    int label;
    final /* synthetic */ ExportViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExportViewModel$export$1$resultFiles$1(Application application, ExportViewModel exportViewModel, Continuation<? super ExportViewModel$export$1$resultFiles$1> continuation) {
        super(2, continuation);
        this.$application = application;
        this.this$0 = exportViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExportViewModel$export$1$resultFiles$1(this.$application, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<String>> continuation) {
        return ((ExportViewModel$export$1$resultFiles$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        final File file = new File(this.$application.getCacheDir().getAbsolutePath(), "export");
        file.mkdirs();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                file2.delete();
            }
        }
        TechnicalLoggerExt.logAction(this.this$0.logger, ExportViewModel.TAG, "export", new Function0() { // from class: com.myscript.nebo.export.ExportViewModel$export$1$resultFiles$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExportViewModel$export$1$resultFiles$1.invokeSuspend$lambda$1(file);
            }
        });
        ExportProgress exportProgress = new ExportProgress(this.this$0.onExportProgress);
        try {
            List<String> listMakeExport = this.this$0.exportController.makeExport(file.getAbsolutePath(), exportProgress);
            AutoCloseableKt.closeFinally(exportProgress, null);
            ArrayList arrayList = new ArrayList();
            Intrinsics.checkNotNull(listMakeExport);
            for (String str : listMakeExport) {
                Intrinsics.checkNotNull(str);
                arrayList.add(str);
            }
            return arrayList;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeSuspend$lambda$1(File file) {
        return "exportDir='" + file + "'";
    }
}
