package com.myscript.nebo.editing;

import androidx.media3.extractor.p007ts.TsExtractor;
import com.myscript.atk.core.CustomResource;
import com.myscript.atk.core.p020ui.TypesetListener;
import com.myscript.nebo.editing.PageParam;
import com.myscript.snt.core.DisplayContext;
import com.myscript.snt.core.NeboSanitizer;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.PageControllerSanitized;
import com.myscript.snt.core.RecoContext;
import com.myscript.snt.core.SWIGOptionContext;
import com.myscript.snt.core.StandalonePageControllerProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PageLoader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005Jj\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageLoader;", "", "workDispatcher", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "load", "Lcom/myscript/snt/core/PageController;", "pageParam", "Lcom/myscript/nebo/editing/PageParam;", "xdpi", "", "ydpi", "scaledDensity", "confPath", "", "", "withSmartGuideSupport", "", "withAnimationsSupport", "customResources", "Lcom/myscript/atk/core/CustomResource;", "optionContext", "Lcom/myscript/snt/core/SWIGOptionContext;", "(Lcom/myscript/nebo/editing/PageParam;FFFLjava/util/List;ZZLjava/util/List;Lcom/myscript/snt/core/SWIGOptionContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageLoader {
    private final CoroutineContext workDispatcher;

    /* JADX WARN: Multi-variable type inference failed */
    public PageLoader() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public PageLoader(CoroutineContext workDispatcher) {
        Intrinsics.checkNotNullParameter(workDispatcher, "workDispatcher");
        this.workDispatcher = workDispatcher;
    }

    public /* synthetic */ PageLoader(CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object load$default(PageLoader pageLoader, PageParam pageParam, float f, float f2, float f3, List list, boolean z, boolean z2, List list2, SWIGOptionContext sWIGOptionContext, Continuation continuation, int i, Object obj) throws PageControllerLoadingException {
        if ((i & 32) != 0) {
            z = false;
        }
        if ((i & 64) != 0) {
            z2 = false;
        }
        if ((i & 128) != 0) {
            list2 = new ArrayList();
        }
        if ((i & 256) != 0) {
            sWIGOptionContext = new SWIGOptionContext();
        }
        return pageLoader.load(pageParam, f, f2, f3, list, z, z2, list2, sWIGOptionContext, continuation);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageLoader$load$2 */
    /* JADX INFO: compiled from: PageLoader.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/snt/core/PageController;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageLoader$load$2", m1609f = "PageLoader.kt", m1610i = {0, 0}, m1611l = {87}, m1612m = "invokeSuspend", m1613n = {"displayContext", "recoContext"}, m1614nl = {TsExtractor.TS_SYNC_BYTE}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C64032 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PageController>, Object> {
        final /* synthetic */ List<String> $confPath;
        final /* synthetic */ List<CustomResource> $customResources;
        final /* synthetic */ SWIGOptionContext $optionContext;
        final /* synthetic */ PageParam $pageParam;
        final /* synthetic */ float $scaledDensity;
        final /* synthetic */ boolean $withAnimationsSupport;
        final /* synthetic */ boolean $withSmartGuideSupport;
        final /* synthetic */ float $xdpi;
        final /* synthetic */ float $ydpi;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C64032(float f, float f2, boolean z, boolean z2, float f3, List<String> list, List<? extends CustomResource> list2, PageParam pageParam, SWIGOptionContext sWIGOptionContext, Continuation<? super C64032> continuation) {
            super(2, continuation);
            this.$xdpi = f;
            this.$ydpi = f2;
            this.$withSmartGuideSupport = z;
            this.$withAnimationsSupport = z2;
            this.$scaledDensity = f3;
            this.$confPath = list;
            this.$customResources = list2;
            this.$pageParam = pageParam;
            this.$optionContext = sWIGOptionContext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C64032(this.$xdpi, this.$ydpi, this.$withSmartGuideSupport, this.$withAnimationsSupport, this.$scaledDensity, this.$confPath, this.$customResources, this.$pageParam, this.$optionContext, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PageController> continuation) {
            return ((C64032) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                DisplayContext displayContext = new DisplayContext(this.$xdpi, this.$ydpi, this.$withSmartGuideSupport, this.$withAnimationsSupport);
                RecoContext recoContext = new RecoContext(new TypesetListener(this.$xdpi, this.$ydpi, this.$scaledDensity), this.$confPath, this.$customResources);
                PageParam pageParam = this.$pageParam;
                if (pageParam instanceof PageParam.Standalone) {
                    StandalonePageControllerProvider standalonePageControllerProvider = new StandalonePageControllerProvider(((PageParam.Standalone) this.$pageParam).getWorkingDir().getAbsolutePath());
                    try {
                        try {
                            PageController pageController = standalonePageControllerProvider.pageController(((PageParam.Standalone) this.$pageParam).getNotebookFile().getAbsolutePath(), displayContext, recoContext);
                            if (pageController != null) {
                                return pageController;
                            }
                            throw new PageControllerLoadingException(new RuntimeException("Can't get standalone PageController"));
                        } catch (Exception e) {
                            throw new PageControllerLoadingException(e);
                        }
                    } finally {
                        standalonePageControllerProvider.delete();
                    }
                }
                if (!(pageParam instanceof PageParam.ByKey)) {
                    throw new NoWhenBranchMatchedException();
                }
                PageAccessSerializer pageAccessSerializer = PageAccessSerializer.INSTANCE;
                String strUuid = ((PageParam.ByKey) this.$pageParam).getPageKey().uuid();
                Intrinsics.checkNotNullExpressionValue(strUuid, "uuid(...)");
                this.L$0 = SpillingKt.nullOutSpilledVariable(displayContext);
                this.L$1 = SpillingKt.nullOutSpilledVariable(recoContext);
                this.label = 1;
                Object objWithPageAccess = pageAccessSerializer.withPageAccess(strUuid, new AnonymousClass1(this.$pageParam, displayContext, recoContext, this.$optionContext, null), this);
                return objWithPageAccess == coroutine_suspended ? coroutine_suspended : objWithPageAccess;
            } catch (PageControllerLoadingException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new PageControllerLoadingException(e3);
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.PageLoader$load$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: PageLoader.kt */
        @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/snt/core/PageController;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageLoader$load$2$1", m1609f = "PageLoader.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super PageController>, Object> {
            final /* synthetic */ DisplayContext $displayContext;
            final /* synthetic */ SWIGOptionContext $optionContext;
            final /* synthetic */ PageParam $pageParam;
            final /* synthetic */ RecoContext $recoContext;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PageParam pageParam, DisplayContext displayContext, RecoContext recoContext, SWIGOptionContext sWIGOptionContext, Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
                this.$pageParam = pageParam;
                this.$displayContext = displayContext;
                this.$recoContext = recoContext;
                this.$optionContext = sWIGOptionContext;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass1(this.$pageParam, this.$displayContext, this.$recoContext, this.$optionContext, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super PageController> continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                PageControllerSanitized pageControllerSanitizedInvoke = ((PageParam.ByKey) this.$pageParam).getPageControllerProvider().invoke(((PageParam.ByKey) this.$pageParam).getPageKey(), this.$displayContext, this.$recoContext, this.$optionContext);
                try {
                    NeboSanitizer.SanitizerStatus status = pageControllerSanitizedInvoke.getSanitizerResult().getStatus();
                    PageController pageController = pageControllerSanitizedInvoke.getPageController();
                    if (pageController != null && !PageLoaderKt.isCorruption(status)) {
                        return pageController;
                    }
                    Intrinsics.checkNotNull(status);
                    throw new PageControllerLoadingException(status);
                } finally {
                    pageControllerSanitizedInvoke.delete();
                }
            }
        }
    }

    public final Object load(PageParam pageParam, float f, float f2, float f3, List<String> list, boolean z, boolean z2, List<? extends CustomResource> list2, SWIGOptionContext sWIGOptionContext, Continuation<? super PageController> continuation) throws PageControllerLoadingException {
        return BuildersKt.withContext(this.workDispatcher, new C64032(f, f2, z, z2, f3, list, list2, pageParam, sWIGOptionContext, null), continuation);
    }
}
