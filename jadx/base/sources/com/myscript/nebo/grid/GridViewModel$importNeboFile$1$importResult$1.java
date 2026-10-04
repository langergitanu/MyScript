package com.myscript.nebo.grid;

import android.net.Uri;
import com.myscript.nebo.dms.core.INeboFileImporter;
import com.myscript.nebo.dms.util.ImportController;
import com.myscript.nebo.grid.GridViewModel;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.snt.core.NotebookKey;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/grid/GridViewModel$ImportStateUI;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$importNeboFile$1$importResult$1", m1609f = "GridViewModel.kt", m1610i = {0, 0}, m1611l = {863}, m1612m = "invokeSuspend", m1613n = {"result", "file"}, m1614nl = {869}, m1615s = {"L$0", "L$1"}, m1616v = 2)
final class GridViewModel$importNeboFile$1$importResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GridViewModel.ImportStateUI>, Object> {
    final /* synthetic */ NotebookKey $notebookKey;
    final /* synthetic */ Uri $requestedUri;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GridViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GridViewModel$importNeboFile$1$importResult$1(GridViewModel gridViewModel, Uri uri, NotebookKey notebookKey, Continuation<? super GridViewModel$importNeboFile$1$importResult$1> continuation) {
        super(2, continuation);
        this.this$0 = gridViewModel;
        this.$requestedUri = uri;
        this.$notebookKey = notebookKey;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GridViewModel$importNeboFile$1$importResult$1(this.this$0, this.$requestedUri, this.$notebookKey, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GridViewModel.ImportStateUI> continuation) {
        return ((GridViewModel$importNeboFile$1$importResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewModel$importNeboFile$1$importResult$1$1 */
    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C64981 extends FunctionReferenceImpl implements Function0<String> {
        C64981(Object obj) {
            super(0, obj, Uri.class, "toString", "toString()Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return ((Uri) this.receiver).toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0093 A[Catch: all -> 0x0018, TryCatch #2 {all -> 0x0018, blocks: (B:6:0x0014, B:34:0x008b, B:36:0x0093, B:37:0x0096), top: B:55:0x0014 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        ImportController.ImportResult importResultImportNeboFile;
        File file;
        Throwable th;
        Exception e;
        TechnicalLogger technicalLogger;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TechnicalLoggerExt.logAction(this.this$0.logger, "GridViewModel", "importNeboFile", new C64981(this.$requestedUri));
            INeboFileImporter iNeboFileImporter = this.this$0.neboFileImporter;
            importResultImportNeboFile = iNeboFileImporter != null ? iNeboFileImporter.importNeboFile(this.$requestedUri) : null;
            File file2 = importResultImportNeboFile != null ? importResultImportNeboFile.file : null;
            if (importResultImportNeboFile != null && importResultImportNeboFile.isSuccess() && file2 != null) {
                try {
                    this.this$0.pageRepository.importNeboFile(file2, this.$notebookKey);
                    this.L$0 = importResultImportNeboFile;
                    this.L$1 = file2;
                    this.label = 1;
                    if (this.this$0.updatePages(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    file = file2;
                    file.delete();
                } catch (Exception e2) {
                    file = file2;
                    e = e2;
                    technicalLogger = this.this$0.logger;
                    if (technicalLogger != null) {
                    }
                    GridViewModel.ImportStateUI.Failure.Unknown unknown = GridViewModel.ImportStateUI.Failure.Unknown.INSTANCE;
                    file.delete();
                    return unknown;
                } catch (Throwable th2) {
                    file = file2;
                    th = th2;
                    file.delete();
                    throw th;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            file = (File) this.L$1;
            importResultImportNeboFile = (ImportController.ImportResult) this.L$0;
            try {
                try {
                    ResultKt.throwOnFailure(obj);
                    file.delete();
                } catch (Exception e3) {
                    e = e3;
                    technicalLogger = this.this$0.logger;
                    if (technicalLogger != null) {
                        technicalLogger.logError(e);
                    }
                    GridViewModel.ImportStateUI.Failure.Unknown unknown2 = GridViewModel.ImportStateUI.Failure.Unknown.INSTANCE;
                    file.delete();
                    return unknown2;
                }
            } catch (Throwable th3) {
                th = th3;
                file.delete();
                throw th;
            }
        }
        if ((importResultImportNeboFile != null ? importResultImportNeboFile.status : null) == ImportController.ImportStatus.KO_NO_URI) {
            return GridViewModel.ImportStateUI.Failure.InvalidUri.INSTANCE;
        }
        if (importResultImportNeboFile == null || !importResultImportNeboFile.isSuccess()) {
            return GridViewModel.ImportStateUI.Failure.Unknown.INSTANCE;
        }
        return GridViewModel.ImportStateUI.Success.INSTANCE;
    }
}
