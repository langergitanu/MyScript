package com.samsung.android.sdk.pen.setting.quicktool;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenChipView;
import com.samsung.android.sdk.pen.setting.common.SpenVoiceAssistantAsButton;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCircularRoundLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCircularViewAdapter;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C8357R;
import com.survicate.surveys.TextRecallingManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: SpenSettingQTColorDialLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0003\u001b\u001e,\u0018\u0000 P2\u00020\u0001:\u0007PQRSTUVB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010 \u001a\u00020!J\u0017\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\b$J\u0015\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0017H\u0000¢\u0006\u0002\b'J\u0016\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0017J\u0014\u0010.\u001a\u00020!2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100J\u0014\u00102\u001a\u00020!2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020300J\u0018\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u0004\u0018\u0001092\u0006\u00105\u001a\u00020\u0014J\u000e\u0010:\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0007J&\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020=2\u0006\u00105\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0017J\u0016\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020AJ\u0012\u0010C\u001a\u00020\u00142\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J \u0010F\u001a\u00020!2\u0006\u00105\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0017H\u0002J \u0010G\u001a\u00020!2\u0006\u00105\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0017H\u0002J\u0010\u0010H\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0017H\u0002J,\u0010I\u001a\u00020!2\u0006\u0010D\u001a\u00020E2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00172\n\b\u0002\u0010#\u001a\u0004\u0018\u00010MH\u0002J \u0010N\u001a\u00020!2\u0006\u0010D\u001a\u00020E2\u0006\u0010O\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0017H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-¨\u0006W"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout;", "Landroid/widget/RelativeLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$ActionListener;", "mAnimationListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$OnAnimationListener;", "mFixedItems", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenChipView;", "mCircularViewAdapter", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularViewAdapter;", "mCircularRecyclerView", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularRecyclerView;", "mCircularRoundLayout", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularRoundLayout;", "mSelectedDialItemIdx", "", "mDialItemCount", "mIsShowAnimation", "", "mFixedItemClickListener", "Landroid/view/View$OnClickListener;", "onItemClickListener", "com/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$onItemClickListener$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$onItemClickListener$1;", "mAnimatorListenerAdapter", "com/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$mAnimatorListenerAdapter$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$mAnimatorListenerAdapter$1;", "close", "", "setAnimationListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAnimationListener$SDK_debug", "showAnimation", "isShown", "showAnimation$SDK_debug", "setVisibility", "visibility", "animation", "mInnerAnimationListener", "com/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$mInnerAnimationListener$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$mInnerAnimationListener$1;", "setDialItems", FirebaseAnalytics.Param.ITEMS, "", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$ColorDialItem;", "setFixedItems", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$FixedItem;", "addFixedItem", FirebaseAnalytics.Param.INDEX, "parent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getFixedSelectorDrawable", "Landroid/graphics/drawable/Drawable;", "setActionListener", "setSelected", "type", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$ButtonType;", "selected", "isScrollAt", "rawX", "", "rawY", "findFixedItemIndex", "view", "Landroid/view/View;", "setFixedItemSelected", "setDialItemSelected", "updateColorDialItem", "startFixedItemAnimation", "startDelay", "", "isShow", "Landroid/animation/Animator$AnimatorListener;", "startDialItemAnimation", "startOffset", "Companion", "ButtonType", "DialItemType", "ColorDialItem", "FixedItem", "ActionListener", "OnAnimationListener", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenSettingQTColorDialLayout extends RelativeLayout {
    private static final float BACKGROUND_END_ANGLE = 90.0f;
    private static final float BACKGROUND_START_ANGLE = 360.0f;
    private static final int DIAL_ITEM_START_DELAY = 16;
    private static final long HIDE_DIAL_ITEM_START_DURATION = 350;
    private static final int MAX_DIALED_ITEM_SIZE_VISIBLE = 10;
    private static final int MAX_FIXED_ITEM_SIZE = 2;
    private static final float SCALE_GONE = 0.0f;
    private static final float SCALE_VISIBLE = 1.0f;
    private static final long SHOW_DIAL_ITEM_START_DURATION = 400;
    private static final String TAG = "SpenSettingQTColorDialLayout";
    private ActionListener mActionListener;
    private OnAnimationListener mAnimationListener;
    private final SpenSettingQTColorDialLayout$mAnimatorListenerAdapter$1 mAnimatorListenerAdapter;
    private final SpenCircularRecyclerView mCircularRecyclerView;
    private final SpenCircularRoundLayout mCircularRoundLayout;
    private final SpenCircularViewAdapter mCircularViewAdapter;
    private int mDialItemCount;
    private final View.OnClickListener mFixedItemClickListener;
    private List<SpenChipView> mFixedItems;
    private final SpenSettingQTColorDialLayout$mInnerAnimationListener$1 mInnerAnimationListener;
    private boolean mIsShowAnimation;
    private int mSelectedDialItemIdx;
    private final SpenSettingQTColorDialLayout$onItemClickListener$1 onItemClickListener;

    /* JADX INFO: compiled from: SpenSettingQTColorDialLayout.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$ActionListener;", "", "onFixedButtonClick", "", FirebaseAnalytics.Param.INDEX, "", "isSelected", "", "onDialButtonClick", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public interface ActionListener {
        void onDialButtonClick(int index, boolean isSelected);

        void onFixedButtonClick(int index, boolean isSelected);
    }

    /* JADX INFO: compiled from: SpenSettingQTColorDialLayout.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$OnAnimationListener;", "", "onAnimationStart", "", "onAnimationEnd", "isShowAnimation", "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public interface OnAnimationListener {
        void onAnimationEnd(boolean isShowAnimation);

        void onAnimationStart();
    }

    /* JADX INFO: compiled from: SpenSettingQTColorDialLayout.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ButtonType.values().length];
            try {
                iArr[ButtonType.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonType.DIALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout$onItemClickListener$1] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout$mAnimatorListenerAdapter$1] */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout$mInnerAnimationListener$1] */
    public SpenSettingQTColorDialLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFixedItemClickListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpenSettingQTColorDialLayout.mFixedItemClickListener$lambda$0(this.f$0, view);
            }
        };
        ?? r0 = new SpenCircularViewAdapter.OnItemClickListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout$onItemClickListener$1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCircularViewAdapter.OnItemClickListener
            public void onItemClick(View view, int position) {
                Intrinsics.checkNotNullParameter(view, "view");
                SpenSettingQTColorDialLayout.ActionListener actionListener = this.this$0.mActionListener;
                if (actionListener != null) {
                    actionListener.onDialButtonClick(position, true);
                }
            }
        };
        this.onItemClickListener = r0;
        this.mAnimatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout$mAnimatorListenerAdapter$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationStart(animation);
                SpenSettingQTColorDialLayout.OnAnimationListener onAnimationListener = this.this$0.mAnimationListener;
                if (onAnimationListener != null) {
                    onAnimationListener.onAnimationStart();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                SpenSettingQTColorDialLayout.OnAnimationListener onAnimationListener = this.this$0.mAnimationListener;
                if (onAnimationListener != null) {
                    onAnimationListener.onAnimationEnd(this.this$0.mIsShowAnimation);
                }
            }
        };
        LayoutInflater.from(context).inflate(C8357R.layout.setting_qt_dial_layout, (ViewGroup) this, true);
        SpenCircularRoundLayout spenCircularRoundLayout = (SpenCircularRoundLayout) findViewById(C8357R.id.circular_mask_layout);
        this.mCircularRoundLayout = spenCircularRoundLayout;
        spenCircularRoundLayout.setAngle(360.0f, BACKGROUND_END_ANGLE);
        spenCircularRoundLayout.setAnimationFillType(SpenCircularRoundLayout.AnimationFillType.START_TO_END);
        SpenCircularViewAdapter spenCircularViewAdapter = new SpenCircularViewAdapter();
        this.mCircularViewAdapter = spenCircularViewAdapter;
        spenCircularViewAdapter.setOnItemClickListener((SpenCircularViewAdapter.OnItemClickListener) r0);
        SpenCircularRecyclerView spenCircularRecyclerView = (SpenCircularRecyclerView) findViewById(C8357R.id.circular_recycle_view);
        this.mCircularRecyclerView = spenCircularRecyclerView;
        spenCircularRecyclerView.setAdapter(spenCircularViewAdapter);
        this.mInnerAnimationListener = new OnAnimationListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout$mInnerAnimationListener$1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout.OnAnimationListener
            public void onAnimationStart() {
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout.OnAnimationListener
            public void onAnimationEnd(boolean isShowAnimation) {
                if (isShowAnimation) {
                    return;
                }
                this.this$0.setVisibility(8);
            }
        };
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SpenSettingQTColorDialLayout.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$ButtonType;", "", "<init>", "(Ljava/lang/String;I)V", "FIXED", "DIALED", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final class ButtonType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ButtonType[] $VALUES;
        public static final ButtonType FIXED = new ButtonType("FIXED", 0);
        public static final ButtonType DIALED = new ButtonType("DIALED", 1);

        private static final /* synthetic */ ButtonType[] $values() {
            return new ButtonType[]{FIXED, DIALED};
        }

        public static EnumEntries<ButtonType> getEntries() {
            return $ENTRIES;
        }

        private ButtonType(String str, int i) {
        }

        static {
            ButtonType[] buttonTypeArr$values = $values();
            $VALUES = buttonTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(buttonTypeArr$values);
        }

        public static ButtonType valueOf(String str) {
            return (ButtonType) Enum.valueOf(ButtonType.class, str);
        }

        public static ButtonType[] values() {
            return (ButtonType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SpenSettingQTColorDialLayout.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$DialItemType;", "", "<init>", "(Ljava/lang/String;I)V", "COLOR", "EMPTY", "DIVIDER", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final class DialItemType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DialItemType[] $VALUES;
        public static final DialItemType COLOR = new DialItemType("COLOR", 0);
        public static final DialItemType EMPTY = new DialItemType("EMPTY", 1);
        public static final DialItemType DIVIDER = new DialItemType("DIVIDER", 2);

        private static final /* synthetic */ DialItemType[] $values() {
            return new DialItemType[]{COLOR, EMPTY, DIVIDER};
        }

        public static EnumEntries<DialItemType> getEntries() {
            return $ENTRIES;
        }

        private DialItemType(String str, int i) {
        }

        static {
            DialItemType[] dialItemTypeArr$values = $values();
            $VALUES = dialItemTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(dialItemTypeArr$values);
        }

        public static DialItemType valueOf(String str) {
            return (DialItemType) Enum.valueOf(DialItemType.class, str);
        }

        public static DialItemType[] values() {
            return (DialItemType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: SpenSettingQTColorDialLayout.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$ColorDialItem;", "", "type", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$DialItemType;", "color", "", "description", "", "<init>", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$DialItemType;ILjava/lang/CharSequence;)V", "getType", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$DialItemType;", "setType", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$DialItemType;)V", "getColor", "()I", "getDescription", "()Ljava/lang/CharSequence;", "setDescription", "(Ljava/lang/CharSequence;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final /* data */ class ColorDialItem {
        private final int color;
        private CharSequence description;
        private DialItemType type;

        public static /* synthetic */ ColorDialItem copy$default(ColorDialItem colorDialItem, DialItemType dialItemType, int i, CharSequence charSequence, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                dialItemType = colorDialItem.type;
            }
            if ((i2 & 2) != 0) {
                i = colorDialItem.color;
            }
            if ((i2 & 4) != 0) {
                charSequence = colorDialItem.description;
            }
            return colorDialItem.copy(dialItemType, i, charSequence);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DialItemType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CharSequence getDescription() {
            return this.description;
        }

        public final ColorDialItem copy(DialItemType type, int color, CharSequence description) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new ColorDialItem(type, color, description);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ColorDialItem)) {
                return false;
            }
            ColorDialItem colorDialItem = (ColorDialItem) other;
            return this.type == colorDialItem.type && this.color == colorDialItem.color && Intrinsics.areEqual(this.description, colorDialItem.description);
        }

        public int hashCode() {
            int iHashCode = ((this.type.hashCode() * 31) + Integer.hashCode(this.color)) * 31;
            CharSequence charSequence = this.description;
            return iHashCode + (charSequence == null ? 0 : charSequence.hashCode());
        }

        public String toString() {
            return "ColorDialItem(type=" + this.type + ", color=" + this.color + ", description=" + ((Object) this.description) + ")";
        }

        public ColorDialItem(DialItemType type, int i, CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.color = i;
            this.description = charSequence;
        }

        public /* synthetic */ ColorDialItem(DialItemType dialItemType, int i, CharSequence charSequence, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(dialItemType, i, (i2 & 4) != 0 ? null : charSequence);
        }

        public final DialItemType getType() {
            return this.type;
        }

        public final void setType(DialItemType dialItemType) {
            Intrinsics.checkNotNullParameter(dialItemType, "<set-?>");
            this.type = dialItemType;
        }

        public final int getColor() {
            return this.color;
        }

        public final CharSequence getDescription() {
            return this.description;
        }

        public final void setDescription(CharSequence charSequence) {
            this.description = charSequence;
        }
    }

    /* JADX INFO: compiled from: SpenSettingQTColorDialLayout.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$FixedItem;", "", "resourceId", "", "selectorResId", "description", "", "<init>", "(IILjava/lang/CharSequence;)V", "getResourceId", "()I", "getSelectorResId", "getDescription", "()Ljava/lang/CharSequence;", "setDescription", "(Ljava/lang/CharSequence;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final /* data */ class FixedItem {
        private CharSequence description;
        private final int resourceId;
        private final int selectorResId;

        public static /* synthetic */ FixedItem copy$default(FixedItem fixedItem, int i, int i2, CharSequence charSequence, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = fixedItem.resourceId;
            }
            if ((i3 & 2) != 0) {
                i2 = fixedItem.selectorResId;
            }
            if ((i3 & 4) != 0) {
                charSequence = fixedItem.description;
            }
            return fixedItem.copy(i, i2, charSequence);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getResourceId() {
            return this.resourceId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getSelectorResId() {
            return this.selectorResId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CharSequence getDescription() {
            return this.description;
        }

        public final FixedItem copy(int resourceId, int selectorResId, CharSequence description) {
            return new FixedItem(resourceId, selectorResId, description);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FixedItem)) {
                return false;
            }
            FixedItem fixedItem = (FixedItem) other;
            return this.resourceId == fixedItem.resourceId && this.selectorResId == fixedItem.selectorResId && Intrinsics.areEqual(this.description, fixedItem.description);
        }

        public int hashCode() {
            int iHashCode = ((Integer.hashCode(this.resourceId) * 31) + Integer.hashCode(this.selectorResId)) * 31;
            CharSequence charSequence = this.description;
            return iHashCode + (charSequence == null ? 0 : charSequence.hashCode());
        }

        public String toString() {
            return "FixedItem(resourceId=" + this.resourceId + ", selectorResId=" + this.selectorResId + ", description=" + ((Object) this.description) + ")";
        }

        public FixedItem(int i, int i2, CharSequence charSequence) {
            this.resourceId = i;
            this.selectorResId = i2;
            this.description = charSequence;
        }

        public /* synthetic */ FixedItem(int i, int i2, CharSequence charSequence, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? null : charSequence);
        }

        public final int getResourceId() {
            return this.resourceId;
        }

        public final int getSelectorResId() {
            return this.selectorResId;
        }

        public final CharSequence getDescription() {
            return this.description;
        }

        public final void setDescription(CharSequence charSequence) {
            this.description = charSequence;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mFixedItemClickListener$lambda$0(SpenSettingQTColorDialLayout spenSettingQTColorDialLayout, View view) {
        ActionListener actionListener;
        int iFindFixedItemIndex = spenSettingQTColorDialLayout.findFixedItemIndex(view);
        if (iFindFixedItemIndex <= -1 || (actionListener = spenSettingQTColorDialLayout.mActionListener) == null) {
            return;
        }
        actionListener.onFixedButtonClick(iFindFixedItemIndex, view.isSelected());
    }

    public final void close() {
        List<SpenChipView> list = this.mFixedItems;
        if (list != null) {
            list.clear();
        }
        this.mFixedItems = null;
        this.mActionListener = null;
        this.mAnimationListener = null;
        this.mCircularViewAdapter.close();
        this.mCircularRecyclerView.close();
    }

    public final void setAnimationListener$SDK_debug(OnAnimationListener listener) {
        this.mAnimationListener = listener;
    }

    public final void showAnimation$SDK_debug(boolean isShown) {
        Log.i(TAG, "startAnimation isShown=" + isShown);
        this.mCircularRoundLayout.startAnimation(isShown);
        if (isShown) {
            if (getWidth() == 0 || getHeight() == 0) {
                this.mCircularRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout$showAnimation$1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        this.this$0.mCircularRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        this.this$0.updateColorDialItem(true);
                    }
                });
                return;
            } else {
                updateColorDialItem(true);
                return;
            }
        }
        updateColorDialItem(false);
    }

    public final void setVisibility(int visibility, boolean animation) {
        boolean z = animation && (visibility == 0 || getVisibility() == 0);
        Log.i(TAG, "setVisibility(" + visibility + TextRecallingManager.ANSWER_SEPARATOR + animation + ") isAnimation=" + z);
        if (!z || visibility == 4) {
            super.setVisibility(visibility);
            return;
        }
        if (visibility == 0) {
            setVisibility(0);
        }
        setAnimationListener$SDK_debug(this.mInnerAnimationListener);
        showAnimation$SDK_debug(visibility == 0);
    }

    public final void setDialItems(List<ColorDialItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        int i = 0;
        for (ColorDialItem colorDialItem : items) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("#%X", Arrays.copyOf(new Object[]{Integer.valueOf(colorDialItem.getColor())}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            Log.i(TAG, "[" + i + "] type=" + colorDialItem + ".type, color=" + str);
            i++;
        }
        this.mDialItemCount = items.size();
        this.mCircularViewAdapter.updateDialItems(items);
        this.mCircularRecyclerView.setDialItems(items);
    }

    public final void setFixedItems(List<FixedItem> items) {
        SpenChipView spenChipViewAddFixedItem;
        Intrinsics.checkNotNullParameter(items, "items");
        if (items.size() > 2) {
            throw new IllegalArgumentException("fixed item size must be less than or equal to 2".toString());
        }
        if (this.mFixedItems == null) {
            this.mFixedItems = new ArrayList();
        }
        List<SpenChipView> list = this.mFixedItems;
        Intrinsics.checkNotNull(list);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(C8357R.id.dial_main);
        int i = 0;
        for (FixedItem fixedItem : items) {
            int i2 = i + 1;
            if (i < list.size()) {
                spenChipViewAddFixedItem = list.get(i);
            } else {
                Intrinsics.checkNotNull(constraintLayout);
                spenChipViewAddFixedItem = addFixedItem(i, constraintLayout);
            }
            spenChipViewAddFixedItem.setColorRes(fixedItem.getResourceId());
            spenChipViewAddFixedItem.setSelectorRes(fixedItem.getSelectorResId());
            spenChipViewAddFixedItem.setContentDescription(fixedItem.getDescription());
            spenChipViewAddFixedItem.setTooltipText(fixedItem.getDescription());
            i = i2;
        }
        while (list.size() > items.size()) {
            SpenChipView spenChipView = list.get(CollectionsKt.getLastIndex(list));
            spenChipView.setOnClickListener(null);
            spenChipView.setAccessibilityDelegate(null);
            constraintLayout.removeView(spenChipView);
            list.remove(spenChipView);
            Log.i(TAG, "fixedItemCount=" + list.size());
        }
    }

    private final SpenChipView addFixedItem(int index, ConstraintLayout parent) {
        List<SpenChipView> list = this.mFixedItems;
        Intrinsics.checkNotNull(list);
        SpenQTAnglePosition spenQTAnglePosition = new SpenQTAnglePosition();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C8357R.dimen.qt_circle_default_size) / 2;
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(C8357R.dimen.qt_circle_radius);
        spenQTAnglePosition.setCenterPosition(dimensionPixelSize, dimensionPixelSize);
        spenQTAnglePosition.setRadius(dimensionPixelSize2);
        int dimensionPixelSize3 = getContext().getResources().getDimensionPixelSize(C8357R.dimen.qt_dial_fixed_item_size);
        int dimensionPixelSize4 = getContext().getResources().getDimensionPixelSize(C8357R.dimen.qt_dial_fixed_item_padding);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SpenChipView spenChipView = new SpenChipView(context);
        spenChipView.setBackgroundResource(C8357R.drawable.spen_round_ripple);
        spenChipView.setAccessibilityDelegate(new SpenVoiceAssistantAsButton());
        SpenChipView spenChipView2 = spenChipView;
        spenChipView2.setPadding(dimensionPixelSize4, dimensionPixelSize4, dimensionPixelSize4, dimensionPixelSize4);
        spenChipView.setOnClickListener(this.mFixedItemClickListener);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(dimensionPixelSize3, dimensionPixelSize3);
        PointF viewPosition = spenQTAnglePosition.getViewPosition(dimensionPixelSize3, dimensionPixelSize3, new Integer[]{60, 30}[index].intValue());
        parent.addView(spenChipView2, layoutParams);
        spenChipView.setX(viewPosition.x);
        spenChipView.setY(viewPosition.y);
        list.add(spenChipView);
        return spenChipView;
    }

    public final Drawable getFixedSelectorDrawable(int index) {
        List<SpenChipView> list = this.mFixedItems;
        SpenChipView spenChipView = list != null ? list.get(index) : null;
        if (spenChipView != null) {
            return spenChipView.getSelectorDrawable();
        }
        return null;
    }

    public final void setActionListener(ActionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mActionListener = listener;
    }

    public final void setSelected(ButtonType type, int index, boolean selected, boolean animation) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            setFixedItemSelected(index, selected, animation);
            setDialItemSelected(-1, selected, animation);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            setDialItemSelected(index, selected, animation);
        }
    }

    public final boolean isScrollAt(float rawX, float rawY) {
        return this.mCircularRoundLayout.isRawPointInPath(rawX, rawY);
    }

    private final int findFixedItemIndex(View view) {
        List<SpenChipView> list = this.mFixedItems;
        if (list == null || view == null) {
            return -1;
        }
        Intrinsics.checkNotNull(list);
        return CollectionsKt.indexOf((List<? extends View>) list, view);
    }

    private final void setFixedItemSelected(int index, boolean selected, boolean animation) {
        List<SpenChipView> list = this.mFixedItems;
        SpenChipView spenChipView = list != null ? list.get(index) : null;
        if (spenChipView != null) {
            spenChipView.setSelected(selected, animation);
        }
    }

    private final void setDialItemSelected(int index, boolean selected, boolean animation) {
        Log.i(TAG, "setDialItemSelected index=" + index + " selected=" + selected);
        if (selected) {
            this.mCircularRecyclerView.setSelectedColor(index);
            if (index >= 0) {
                this.mSelectedDialItemIdx = index;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateColorDialItem(boolean isShown) {
        Log.i(TAG, "updateColorDialItem isShown=" + isShown);
        int i = 0;
        if (isShown) {
            int i2 = 0;
            for (int i3 = 0; i3 < 10; i3++) {
                RecyclerView.ViewHolder viewHolderFindViewHolderForLayoutPosition = this.mCircularRecyclerView.findViewHolderForLayoutPosition((this.mSelectedDialItemIdx + i3) % this.mDialItemCount);
                if (viewHolderFindViewHolderForLayoutPosition != null) {
                    View itemView = viewHolderFindViewHolderForLayoutPosition.itemView;
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    startDialItemAnimation(itemView, ((long) i2) * 16, true);
                    i2++;
                }
            }
            List<SpenChipView> list = this.mFixedItems;
            if (list != null) {
                Iterator<T> it = list.iterator();
                int i4 = i2;
                while (it.hasNext()) {
                    int i5 = i + 1;
                    startFixedItemAnimation((SpenChipView) it.next(), ((long) i4) * 16, true, i == 1 ? this.mAnimatorListenerAdapter : null);
                    i4++;
                    i = i5;
                }
                return;
            }
            return;
        }
        int i6 = this.mDialItemCount;
        for (int i7 = 0; i7 < i6; i7++) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForLayoutPosition2 = this.mCircularRecyclerView.findViewHolderForLayoutPosition(i7);
            if (viewHolderFindViewHolderForLayoutPosition2 != null) {
                View itemView2 = viewHolderFindViewHolderForLayoutPosition2.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
                startDialItemAnimation(itemView2, 0L, false);
            }
        }
        List<SpenChipView> list2 = this.mFixedItems;
        if (list2 != null) {
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                int i8 = i + 1;
                startFixedItemAnimation((SpenChipView) it2.next(), 0L, false, i == 1 ? this.mAnimatorListenerAdapter : null);
                i = i8;
            }
        }
    }

    static /* synthetic */ void startFixedItemAnimation$default(SpenSettingQTColorDialLayout spenSettingQTColorDialLayout, View view, long j, boolean z, Animator.AnimatorListener animatorListener, int i, Object obj) {
        if ((i & 8) != 0) {
            animatorListener = null;
        }
        spenSettingQTColorDialLayout.startFixedItemAnimation(view, j, z, animatorListener);
    }

    private final void startFixedItemAnimation(final View view, long startDelay, boolean isShow, Animator.AnimatorListener listener) {
        view.animate().cancel();
        this.mIsShowAnimation = isShow;
        if (isShow) {
            view.setVisibility(8);
            view.setScaleX(0.0f);
            view.setScaleY(0.0f);
            view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).setStartDelay(startDelay).withStartAction(new Runnable() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    view.setVisibility(0);
                }
            }).setListener(listener).start();
            return;
        }
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.animate().scaleX(0.0f).scaleY(0.0f).setDuration(350L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).setStartDelay(startDelay).setListener(listener).start();
    }

    private final void startDialItemAnimation(View view, long startOffset, boolean isShow) {
        ScaleAnimation scaleAnimation;
        if (isShow) {
            scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, view.getWidth() / 2, view.getHeight() / 2);
            scaleAnimation.setDuration(400L);
        } else {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, view.getWidth() / 2, view.getHeight() / 2);
            scaleAnimation2.setDuration(350L);
            scaleAnimation = scaleAnimation2;
        }
        scaleAnimation.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
        scaleAnimation.setStartOffset(startOffset);
        view.startAnimation(scaleAnimation);
    }
}
