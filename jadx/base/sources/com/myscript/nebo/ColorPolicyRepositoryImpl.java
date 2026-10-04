package com.myscript.nebo;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.media3.common.MimeTypes;
import com.myscript.android.utils.ActivityLifecycleCallbacksAdapter;
import com.myscript.atk.core.HSLColorInversionPolicy;
import com.myscript.atk.core.IColorInversionPolicy;
import com.myscript.atk.core.IdentityColorInversionPolicy;
import com.myscript.nebo.common.ColorPolicyRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: compiled from: ColorPolicyRepositoryImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0014\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u0017H\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0018\u0010\u0019\u001a\u00020\u001a*\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001c¨\u0006\u001d"}, m1599d2 = {"Lcom/myscript/nebo/ColorPolicyRepositoryImpl;", "Lcom/myscript/nebo/common/ColorPolicyRepository;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "parentJob", "Lkotlinx/coroutines/CompletableJob;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "lightColorPolicy", "Lcom/myscript/atk/core/IdentityColorInversionPolicy;", "darkColorPolicy", "Lcom/myscript/atk/core/HSLColorInversionPolicy;", "colorPolicy", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/atk/core/IColorInversionPolicy;", "getColorPolicy", "()Landroidx/lifecycle/MutableLiveData;", "onLifecycleUpdate", "com/myscript/nebo/ColorPolicyRepositoryImpl$onLifecycleUpdate$1", "Lcom/myscript/nebo/ColorPolicyRepositoryImpl$onLifecycleUpdate$1;", "invertColor", "", "color", "isMyScriptActivity", "", "Landroid/app/Activity;", "(Landroid/app/Activity;)Z", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ColorPolicyRepositoryImpl implements ColorPolicyRepository {
    public static final int $stable = 8;
    private final MutableLiveData<IColorInversionPolicy> colorPolicy;
    private final HSLColorInversionPolicy darkColorPolicy;
    private final IdentityColorInversionPolicy lightColorPolicy;
    private final ColorPolicyRepositoryImpl$onLifecycleUpdate$1 onLifecycleUpdate;
    private CompletableJob parentJob;
    private final CoroutineScope scope;

    /* JADX WARN: Type inference failed for: r0v6, types: [com.myscript.nebo.ColorPolicyRepositoryImpl$onLifecycleUpdate$1] */
    public ColorPolicyRepositoryImpl(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        CompletableJob completableJobJob$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.parentJob = completableJobJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(completableJobJob$default.plus(Dispatchers.getMain()));
        IdentityColorInversionPolicy identityColorInversionPolicy = new IdentityColorInversionPolicy();
        this.lightColorPolicy = identityColorInversionPolicy;
        this.darkColorPolicy = new HSLColorInversionPolicy();
        this.colorPolicy = new MutableLiveData<>(identityColorInversionPolicy);
        ?? r0 = new ActivityLifecycleCallbacksAdapter() { // from class: com.myscript.nebo.ColorPolicyRepositoryImpl$onLifecycleUpdate$1
            @Override // com.myscript.android.utils.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onActivityCreated(activity, bundle);
                if (Build.VERSION.SDK_INT >= 29 || !this.this$0.isMyScriptActivity(activity)) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(this.this$0.scope, null, null, new C6045xa46490ff(this.this$0, activity, null), 3, null);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPreCreated(Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onActivityPreCreated(activity, savedInstanceState);
                if (Build.VERSION.SDK_INT < 29 || !this.this$0.isMyScriptActivity(activity)) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(this.this$0.scope, null, null, new C6046xc6a55248(this.this$0, activity, null), 3, null);
            }
        };
        this.onLifecycleUpdate = r0;
        application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) r0);
    }

    @Override // com.myscript.nebo.common.ColorPolicyRepository
    public MutableLiveData<IColorInversionPolicy> getColorPolicy() {
        return this.colorPolicy;
    }

    @Override // com.myscript.nebo.common.ColorPolicyRepository
    public int invertColor(int color) {
        IColorInversionPolicy value = getColorPolicy().getValue();
        return value != null ? value.invertColor2(color) : color;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMyScriptActivity(Activity activity) {
        String name;
        Package r5 = activity.getClass().getPackage();
        if (r5 == null || (name = r5.getName()) == null) {
            name = "";
        }
        return StringsKt.contains$default((CharSequence) name, (CharSequence) "com.myscript", false, 2, (Object) null);
    }
}
