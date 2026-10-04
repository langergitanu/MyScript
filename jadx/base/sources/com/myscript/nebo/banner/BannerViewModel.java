package com.myscript.nebo.banner;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.myscript.nebo.banner.BannerLayout;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: BannerViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0013H\u0007J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0013J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b¨\u0006$"}, m1599d2 = {"Lcom/myscript/nebo/banner/BannerViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/myscript/nebo/banner/BannerLayout$Callback;", "<init>", "()V", "_currentPermanentBanner", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/banner/Banner;", "currentPermanentBanner", "Landroidx/lifecycle/LiveData;", "getCurrentPermanentBanner", "()Landroidx/lifecycle/LiveData;", "_currentTransientBanner", "currentTransientBanner", "getCurrentTransientBanner", "push", "", "banner", "replace", "", "showTransientBanner", "Lkotlinx/coroutines/Job;", "showPermanentBanner", "dismiss", "id", "", "blackList", LogFactory.PRIORITY_KEY, "Lcom/myscript/nebo/banner/Priority;", "blacklist", "onClosed", "bannerId", "onActionButtonClicked", "actionType", "Lcom/myscript/nebo/banner/Action;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BannerViewModel extends ViewModel implements BannerLayout.Callback {
    private final MutableLiveData<Banner> _currentPermanentBanner = new MutableLiveData<>();
    private final MutableLiveData<Banner> _currentTransientBanner = new MutableLiveData<>();

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final HashSet<String> blackList = new HashSet<>();

    /* JADX INFO: compiled from: BannerViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Type.values().length];
            try {
                iArr[Type.PERMANENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Type.PERMANENT_FORCED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Type.TRANSIENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Type.UNIQUE_TRANSIENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Action.values().length];
            try {
                iArr2[Action.PRIMARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[Action.SECONDARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @JvmStatic
    public static final boolean addBannerToBlackList(String str) {
        return INSTANCE.addBannerToBlackList(str);
    }

    @JvmStatic
    public static final boolean isBannerBlackListed(String str) {
        return INSTANCE.isBannerBlackListed(str);
    }

    @JvmStatic
    public static final boolean removeBannerFromBlackList(String str) {
        return INSTANCE.removeBannerFromBlackList(str);
    }

    public final void dismiss(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        dismiss$default(this, id, false, 2, (Object) null);
    }

    public final LiveData<Banner> getCurrentPermanentBanner() {
        return this._currentPermanentBanner;
    }

    public final LiveData<Banner> getCurrentTransientBanner() {
        return this._currentTransientBanner;
    }

    public final void push(Banner banner) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        push(banner, false);
    }

    public static /* synthetic */ void push$default(BannerViewModel bannerViewModel, Banner banner, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        bannerViewModel.push(banner, z);
    }

    public final void push(Banner banner, boolean replace) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        int i = WhenMappings.$EnumSwitchMapping$0[banner.getType().ordinal()];
        if (i == 1 || i == 2) {
            showPermanentBanner(banner, replace);
            return;
        }
        if (i == 3) {
            showTransientBanner(banner);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (INSTANCE.isBannerBlackListed(banner.getId())) {
                return;
            }
            showTransientBanner(banner);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.banner.BannerViewModel$showTransientBanner$1 */
    /* JADX INFO: compiled from: BannerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.banner.BannerViewModel$showTransientBanner$1", m1609f = "BannerViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Banner $banner;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61651(Banner banner, Continuation<? super C61651> continuation) {
            super(2, continuation);
            this.$banner = banner;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BannerViewModel.this.new C61651(this.$banner, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BannerViewModel.this._currentTransientBanner.setValue(this.$banner);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final Job showTransientBanner(Banner banner) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C61651(banner, null), 3, null);
    }

    static /* synthetic */ void showPermanentBanner$default(BannerViewModel bannerViewModel, Banner banner, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        bannerViewModel.showPermanentBanner(banner, z);
    }

    private final void showPermanentBanner(Banner banner, boolean replace) {
        Banner value;
        if (INSTANCE.isBannerBlackListed(banner.getId())) {
            return;
        }
        if (replace || (value = getCurrentPermanentBanner().getValue()) == null || (!Intrinsics.areEqual(banner.getId(), value.getId()) && banner.getPriority().getValue() > value.getPriority().getValue())) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C61641(banner, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.banner.BannerViewModel$showPermanentBanner$1 */
    /* JADX INFO: compiled from: BannerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.banner.BannerViewModel$showPermanentBanner$1", m1609f = "BannerViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Banner $banner;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61641(Banner banner, Continuation<? super C61641> continuation) {
            super(2, continuation);
            this.$banner = banner;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BannerViewModel.this.new C61641(this.$banner, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61641) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BannerViewModel.this._currentPermanentBanner.setValue(this.$banner);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ void dismiss$default(BannerViewModel bannerViewModel, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        bannerViewModel.dismiss(str, z);
    }

    public final void dismiss(String id, boolean blackList2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Banner value = getCurrentPermanentBanner().getValue();
        if (value != null && Intrinsics.areEqual(value.getId(), id)) {
            if (blackList2) {
                INSTANCE.addBannerToBlackList(id);
            }
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BannerViewModel$dismiss$1$1(this, null), 3, null);
            return;
        }
        Banner value2 = getCurrentTransientBanner().getValue();
        if (value2 == null || !Intrinsics.areEqual(value2.getId(), id)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BannerViewModel$dismiss$2$1(this, null), 3, null);
        if (value2.getType() == Type.UNIQUE_TRANSIENT) {
            INSTANCE.addBannerToBlackList(id);
        }
    }

    public static /* synthetic */ void dismiss$default(BannerViewModel bannerViewModel, Priority priority, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        bannerViewModel.dismiss(priority, z);
    }

    public final void dismiss(Priority priority, boolean blacklist) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        Banner value = getCurrentPermanentBanner().getValue();
        if (value != null && value.getPriority() == priority) {
            if (blacklist) {
                INSTANCE.addBannerToBlackList(value.getId());
            }
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BannerViewModel$dismiss$3$1(this, null), 3, null);
            return;
        }
        Banner value2 = getCurrentTransientBanner().getValue();
        if (value2 == null || value2.getPriority() != priority) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BannerViewModel$dismiss$4$1(this, null), 3, null);
        if (value2.getType() == Type.UNIQUE_TRANSIENT) {
            INSTANCE.addBannerToBlackList(value2.getId());
        }
    }

    @Override // com.myscript.nebo.banner.BannerLayout.Callback
    public void onClosed(String bannerId) {
        Intrinsics.checkNotNullParameter(bannerId, "bannerId");
        dismiss$default(this, bannerId, false, 2, (Object) null);
    }

    @Override // com.myscript.nebo.banner.BannerLayout.Callback
    public void onActionButtonClicked(String bannerId, Action actionType) {
        Runnable action;
        Runnable secondaryAction;
        Runnable action2;
        Runnable secondaryAction2;
        Intrinsics.checkNotNullParameter(bannerId, "bannerId");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Banner value = getCurrentTransientBanner().getValue();
        if (Intrinsics.areEqual(bannerId, value != null ? value.getId() : null)) {
            int i = WhenMappings.$EnumSwitchMapping$1[actionType.ordinal()];
            if (i == 1) {
                Banner value2 = getCurrentTransientBanner().getValue();
                if (value2 != null && (action2 = value2.getAction()) != null) {
                    action2.run();
                }
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                Banner value3 = getCurrentTransientBanner().getValue();
                if (value3 != null && (secondaryAction2 = value3.getSecondaryAction()) != null) {
                    secondaryAction2.run();
                }
            }
            Banner value4 = getCurrentTransientBanner().getValue();
            if (value4 != null && value4.getIsCloseable()) {
                dismiss(bannerId, value4.getBlackListOnActionClicked());
            }
        }
        Banner value5 = getCurrentPermanentBanner().getValue();
        if (Intrinsics.areEqual(bannerId, value5 != null ? value5.getId() : null)) {
            int i2 = WhenMappings.$EnumSwitchMapping$1[actionType.ordinal()];
            if (i2 == 1) {
                Banner value6 = getCurrentPermanentBanner().getValue();
                if (value6 != null && (action = value6.getAction()) != null) {
                    action.run();
                }
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                Banner value7 = getCurrentPermanentBanner().getValue();
                if (value7 != null && (secondaryAction = value7.getSecondaryAction()) != null) {
                    secondaryAction.run();
                }
            }
            Banner value8 = getCurrentPermanentBanner().getValue();
            if (value8 == null || !value8.getIsCloseable()) {
                return;
            }
            dismiss(bannerId, value8.getBlackListOnActionClicked());
        }
    }

    /* JADX INFO: compiled from: BannerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/banner/BannerViewModel$Companion;", "", "<init>", "()V", "blackList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "isBannerBlackListed", "", "bannerId", "addBannerToBlackList", "removeBannerFromBlackList", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean isBannerBlackListed(String bannerId) {
            Intrinsics.checkNotNullParameter(bannerId, "bannerId");
            return BannerViewModel.blackList.contains(bannerId);
        }

        @JvmStatic
        public final boolean addBannerToBlackList(String bannerId) {
            Intrinsics.checkNotNullParameter(bannerId, "bannerId");
            return BannerViewModel.blackList.add(bannerId);
        }

        @JvmStatic
        public final boolean removeBannerFromBlackList(String bannerId) {
            Intrinsics.checkNotNullParameter(bannerId, "bannerId");
            return BannerViewModel.blackList.remove(bannerId);
        }
    }
}
