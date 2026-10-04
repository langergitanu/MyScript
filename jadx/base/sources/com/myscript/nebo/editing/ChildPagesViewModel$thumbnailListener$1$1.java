package com.myscript.nebo.editing;

import androidx.lifecycle.MutableLiveData;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ChildPagesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$thumbnailListener$1$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class ChildPagesViewModel$thumbnailListener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $pageId;
    final /* synthetic */ boolean $success;
    final /* synthetic */ String $thumbnailPath;
    int label;
    final /* synthetic */ ChildPagesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChildPagesViewModel$thumbnailListener$1$1(ChildPagesViewModel childPagesViewModel, String str, String str2, boolean z, Continuation<? super ChildPagesViewModel$thumbnailListener$1$1> continuation) {
        super(2, continuation);
        this.this$0 = childPagesViewModel;
        this.$pageId = str;
        this.$thumbnailPath = str2;
        this.$success = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChildPagesViewModel$thumbnailListener$1$1(this.this$0, this.$pageId, this.$thumbnailPath, this.$success, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChildPagesViewModel$thumbnailListener$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ImmutableList immutableList = (ImmutableList) this.this$0._childPages.getValue();
            if (immutableList == null) {
                return Unit.INSTANCE;
            }
            MutableLiveData mutableLiveData = this.this$0._childPages;
            ImmutableList<ChildPage> immutableList2 = immutableList;
            String str = this.$pageId;
            String str2 = this.$thumbnailPath;
            boolean z = this.$success;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(immutableList2, 10));
            for (ChildPage childPageCopy$default : immutableList2) {
                if (Intrinsics.areEqual(childPageCopy$default.getId(), str)) {
                    File file = new File(str2);
                    if (!z || !file.isFile()) {
                        file = null;
                    }
                    childPageCopy$default = ChildPage.copy$default(childPageCopy$default, null, false, 0, 0, 0, 0, null, file != null ? file.getAbsolutePath() : null, false, null, 895, null);
                }
                arrayList.add(childPageCopy$default);
            }
            mutableLiveData.setValue(ExtensionsKt.toImmutableList(arrayList));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
