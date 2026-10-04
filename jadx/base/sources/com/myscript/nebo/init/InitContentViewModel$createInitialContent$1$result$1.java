package com.myscript.nebo.init;

import com.myscript.atk.core.BackgroundPattern;
import com.myscript.nebo.common.utils.PageBackgroundUtilsKt;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.PaperSize;
import com.myscript.snt.dms.CoverColorUtilsExt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InitContentViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/init/InitContentState;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.init.InitContentViewModel$createInitialContent$1$result$1", m1609f = "InitContentViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class InitContentViewModel$createInitialContent$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InitContentState>, Object> {
    final /* synthetic */ String $collectionName;
    final /* synthetic */ int $folderColor;
    final /* synthetic */ String $folderName;
    final /* synthetic */ int $notebookColor;
    final /* synthetic */ String $notebookName;
    final /* synthetic */ InitContentState $state;
    int label;
    final /* synthetic */ InitContentViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitContentViewModel$createInitialContent$1$result$1(InitContentViewModel initContentViewModel, String str, InitContentState initContentState, String str2, int i, int i2, String str3, Continuation<? super InitContentViewModel$createInitialContent$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = initContentViewModel;
        this.$collectionName = str;
        this.$state = initContentState;
        this.$folderName = str2;
        this.$folderColor = i;
        this.$notebookColor = i2;
        this.$notebookName = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitContentViewModel$createInitialContent$1$result$1(this.this$0, this.$collectionName, this.$state, this.$folderName, this.$folderColor, this.$notebookColor, this.$notebookName, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InitContentState> continuation) {
        return ((InitContentViewModel$createInitialContent$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CollectionKey collectionKeyFindCollectionByName = this.this$0.libraryRepository.findCollectionByName(this.$collectionName);
            if (collectionKeyFindCollectionByName != null || (collectionKeyFindCollectionByName = this.this$0.libraryRepository.createCollection(this.$collectionName)) != null) {
                NotebookKey notebookKeyCreateFolder = this.this$0.libraryRepository.createFolder(collectionKeyFindCollectionByName, this.$folderName, this.$folderColor);
                if (notebookKeyCreateFolder != null) {
                    this.this$0.libraryRepository.setLastOpenedFolderKey(notebookKeyCreateFolder);
                    List<Integer> listListOf = CollectionsKt.listOf((Object[]) new Integer[]{Boxing.boxInt(this.$notebookColor), Boxing.boxInt(CoverColorUtilsExt.computeGradientEndColor(this.$notebookColor))});
                    LibraryRepository libraryRepository = this.this$0.libraryRepository;
                    String str = this.$notebookName;
                    String str2 = this.this$0.languageKey;
                    PaperSize a4 = PaperSize.getA4();
                    Intrinsics.checkNotNullExpressionValue(a4, "getA4(...)");
                    PageKey pageKeyAddPaginatedContainer = libraryRepository.addPaginatedContainer(notebookKeyCreateFolder, str, str2, listListOf, a4, ((Number) CollectionsKt.first((List) PageBackgroundUtilsKt.getLIGHT_BACKGROUND_COLORS())).intValue(), BackgroundPattern.NONE);
                    if (pageKeyAddPaginatedContainer != null) {
                        this.this$0.libraryRepository.setLastChosenLanguage(this.this$0.languageKey);
                        return InitContentState.copy$default(this.$state, false, pageKeyAddPaginatedContainer.isValid(), null, 5, null);
                    }
                    return InitContentState.copy$default(this.$state, false, false, InitContentError.CANNOT_CREATE_NOTEBOOK, 3, null);
                }
                return InitContentState.copy$default(this.$state, false, false, InitContentError.CANNOT_CREATE_FOLDER, 3, null);
            }
            return InitContentState.copy$default(this.$state, false, false, InitContentError.CANNOT_CREATE_COLLECTION, 3, null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
