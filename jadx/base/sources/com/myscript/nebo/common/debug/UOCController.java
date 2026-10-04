package com.myscript.nebo.common.debug;

import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.myscript.atk.core.Context;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UOCController.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m1599d2 = {"Lcom/myscript/nebo/common/debug/UOCController;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "uocViewId", "", "engineContext", "Lcom/myscript/atk/core/Context;", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;ILcom/myscript/atk/core/Context;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "setActivity", "(Landroidx/appcompat/app/AppCompatActivity;)V", "uocTimer", "Ljava/util/Timer;", "uoc", "Lcom/myscript/nebo/common/debug/UOCView;", "uocExpected", "", "onDestroy", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onResume", "startTimer", "onPause", "stopTimer", "display", "showUOC", "common_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UOCController implements DefaultLifecycleObserver {
    private AppCompatActivity activity;
    private Context engineContext;
    private UOCView uoc;
    private boolean uocExpected = true;
    private Timer uocTimer;
    private final int uocViewId;

    public UOCController(AppCompatActivity appCompatActivity, int i, Context context) {
        Lifecycle lifecycle;
        this.activity = appCompatActivity;
        this.uocViewId = i;
        this.engineContext = context;
        if (appCompatActivity == null || (lifecycle = appCompatActivity.getLifecycleRegistry()) == null) {
            return;
        }
        lifecycle.addObserver(this);
    }

    public final AppCompatActivity getActivity() {
        return this.activity;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onCreate(LifecycleOwner lifecycleOwner) {
        super.onCreate(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onStart(LifecycleOwner lifecycleOwner) {
        super.onStart(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onStop(LifecycleOwner lifecycleOwner) {
        super.onStop(lifecycleOwner);
    }

    public final void setActivity(AppCompatActivity appCompatActivity) {
        this.activity = appCompatActivity;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(owner, "owner");
        AppCompatActivity appCompatActivity = this.activity;
        if (appCompatActivity != null && (lifecycle = appCompatActivity.getLifecycleRegistry()) != null) {
            lifecycle.removeObserver(this);
        }
        this.activity = null;
        this.engineContext = null;
        super.onDestroy(owner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onResume(owner);
        startTimer();
    }

    private final void startTimer() {
        AppCompatActivity appCompatActivity = this.activity;
        UOCView uOCView = appCompatActivity != null ? (UOCView) appCompatActivity.findViewById(this.uocViewId) : null;
        this.uoc = uOCView;
        if (uOCView != null) {
            uOCView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.common.debug.UOCController$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UOCController.startTimer$lambda$0(this.f$0, view);
                }
            });
        }
        UOCView uOCView2 = this.uoc;
        if (uOCView2 != null) {
            uOCView2.setVisibility(this.uocExpected ? 0 : 8);
        }
        if (this.uocExpected) {
            Timer timer = new Timer("UOC Timer");
            timer.scheduleAtFixedRate(new UOCController$startTimer$2$1(this), 0L, 500L);
            this.uocTimer = timer;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTimer$lambda$0(UOCController uOCController, View view) {
        System.gc();
        System.runFinalization();
        AppCompatActivity appCompatActivity = uOCController.activity;
        if (appCompatActivity != null) {
            Toast.makeText(appCompatActivity, "GC Triggered", 1).show();
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onPause(owner);
        stopTimer();
    }

    private final void stopTimer() {
        UOCView uOCView = this.uoc;
        if (uOCView != null) {
            uOCView.setVisibility(8);
            uOCView.setOnClickListener(null);
        }
        this.uoc = null;
        Timer timer = this.uocTimer;
        if (timer != null) {
            timer.cancel();
        }
    }

    public final void display(boolean showUOC) {
        this.uocExpected = showUOC;
        if (showUOC) {
            startTimer();
        } else {
            stopTimer();
        }
    }
}
