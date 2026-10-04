package com.myscript.nebo.languagemanager.data;

import com.myscript.atk.resourcemanager.Language;
import com.myscript.nebo.languagemanager.util.LanguageListUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: com.myscript.nebo.languagemanager.data.LanguageRepositoryImpl$getInstalledLanguages$1$installedLanguages$1 */
/* JADX INFO: compiled from: LanguageRepositoryImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "Lcom/myscript/atk/resourcemanager/Language;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.languagemanager.data.LanguageRepositoryImpl$getInstalledLanguages$1$installedLanguages$1", m1609f = "LanguageRepositoryImpl.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class C6614x5abc5f70 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Language>>, Object> {
    int label;
    final /* synthetic */ LanguageRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C6614x5abc5f70(LanguageRepositoryImpl languageRepositoryImpl, Continuation<? super C6614x5abc5f70> continuation) {
        super(2, continuation);
        this.this$0 = languageRepositoryImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C6614x5abc5f70(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Language>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<Language>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Language>> continuation) {
        return ((C6614x5abc5f70) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        LanguageListUtil.Companion companion = LanguageListUtil.INSTANCE;
        List<String> confPaths = this.this$0.resourceManager.getConfPaths();
        Intrinsics.checkNotNullExpressionValue(confPaths, "getConfPaths(...)");
        List<String> listBuildInstalledLanguages = companion.buildInstalledLanguages(confPaths);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listBuildInstalledLanguages, 10));
        Iterator<T> it = listBuildInstalledLanguages.iterator();
        while (it.hasNext()) {
            arrayList.add(new Language((String) it.next(), null, true, null, 10, null));
        }
        return arrayList;
    }
}
