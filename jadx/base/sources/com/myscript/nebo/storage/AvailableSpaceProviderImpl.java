package com.myscript.nebo.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.StatFs;
import androidx.preference.PreferenceManager;
import com.myscript.nebo.C6079R;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AvailableSpaceProviderImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/storage/AvailableSpaceProviderImpl;", "Lcom/myscript/nebo/storage/AvailableSpaceProvider;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getAvailableSpace", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFakeDialing", "", "getCriticalThreshold", "getLowThreshold", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AvailableSpaceProviderImpl implements AvailableSpaceProvider {
    public static final int $stable = 8;
    private final Context context;

    public AvailableSpaceProviderImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.myscript.nebo.storage.AvailableSpaceProvider
    public Object getAvailableSpace(Continuation<? super Long> continuation) {
        return Boxing.boxLong(new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes());
    }

    private final boolean isFakeDialing() {
        return PreferenceManager.getDefaultSharedPreferences(this.context).getBoolean(this.context.getString(C6079R.string.pref_internal_low_storage_dialing_key), false);
    }

    @Override // com.myscript.nebo.storage.AvailableSpaceProvider
    public long getCriticalThreshold() {
        if (isFakeDialing()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
            return ((long) Math.min(defaultSharedPreferences.getInt(this.context.getString(C6079R.string.pref_internal_low_storage_critical_threshold), 0), defaultSharedPreferences.getInt(this.context.getString(C6079R.string.pref_internal_low_storage_low_threshold), 0))) * 1048576;
        }
        return super.getCriticalThreshold();
    }

    @Override // com.myscript.nebo.storage.AvailableSpaceProvider
    public long getLowThreshold() {
        if (isFakeDialing()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
            return ((long) Math.max(defaultSharedPreferences.getInt(this.context.getString(C6079R.string.pref_internal_low_storage_critical_threshold), 0), defaultSharedPreferences.getInt(this.context.getString(C6079R.string.pref_internal_low_storage_low_threshold), 0))) * 1048576;
        }
        return super.getLowThreshold();
    }
}
