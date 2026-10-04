package com.myscript.android.utils.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.C6014R;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RangePreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001(\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\fJ \u0010%\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0012\u0010*\u001a\u00020&2\b\u0010\u0016\u001a\u0004\u0018\u00010+H\u0014J\u001d\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\tH\u0014¢\u0006\u0002\u00100J\u0010\u00101\u001a\u00020&2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u00105\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0006\u00106\u001a\u00020&J\b\u00107\u001a\u00020&H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@BX\u0082\u000e¢\u0006\n\n\u0002\u0010\u001d\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0013R\u001e\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0014\u0010!\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0013R\u0012\u0010#\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)¨\u00068"}, m1599d2 = {"Lcom/myscript/android/utils/preference/RangePreference;", "Landroidx/preference/Preference;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "seekBar", "Landroid/widget/SeekBar;", "value", "", "minValue", "getMinValue", "()F", "maxValue", "getMaxValue", "defaultValue", "getDefaultValue", "setDefaultValue", "(F)V", "_value", "set_value", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getValue", "stepSize", "getStepSize", "factor", "getFactor", "smallerDrawableRes", "biggerDrawableRes", "configure", "", "onValueUpdate", "com/myscript/android/utils/preference/RangePreference$onValueUpdate$1", "Lcom/myscript/android/utils/preference/RangePreference$onValueUpdate$1;", "onSetInitialValue", "", "onGetDefaultValue", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/content/res/TypedArray;", FirebaseAnalytics.Param.INDEX, "(Landroid/content/res/TypedArray;I)Ljava/lang/Float;", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "toSeekBarValue", "fromSeekBarValue", "reset", "applyValueToUI", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RangePreference extends Preference {
    public static final int $stable = 8;
    private Float _value;
    private int biggerDrawableRes;
    private float defaultValue;
    private float maxValue;
    private float minValue;
    private final RangePreference$onValueUpdate$1 onValueUpdate;
    private SeekBar seekBar;
    private int smallerDrawableRes;
    private float stepSize;

    public final float getMinValue() {
        return this.minValue;
    }

    public final float getMaxValue() {
        return this.maxValue;
    }

    public final float getDefaultValue() {
        return this.defaultValue;
    }

    private final void setDefaultValue(float f) {
        this.defaultValue = RangesKt.coerceIn(f, this.minValue, this.maxValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void set_value(Float f) {
        Float fValueOf = f != null ? Float.valueOf(RangesKt.coerceIn(f.floatValue(), this.minValue, this.maxValue)) : null;
        this._value = fValueOf;
        callChangeListener(Float.valueOf(fValueOf != null ? fValueOf.floatValue() : this.defaultValue));
        Float f2 = this._value;
        persistFloat(f2 != null ? f2.floatValue() : this.defaultValue);
    }

    public final float getValue() {
        Float f = this._value;
        return f != null ? f.floatValue() : this.defaultValue;
    }

    public final float getStepSize() {
        return this.stepSize;
    }

    private final float getFactor() {
        float f = this.stepSize;
        return (f <= 0.0f || f >= 1.0f) ? 1.0f : 10.0f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.myscript.android.utils.preference.RangePreference$onValueUpdate$1] */
    public RangePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.onValueUpdate = new SeekBar.OnSeekBarChangeListener() { // from class: com.myscript.android.utils.preference.RangePreference$onValueUpdate$1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float fFromSeekBarValue = this.this$0.fromSeekBarValue(progress);
                if (Intrinsics.areEqual(this.this$0._value, fFromSeekBarValue)) {
                    return;
                }
                this.this$0.set_value(Float.valueOf(fFromSeekBarValue));
            }
        };
        configure(attrs, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.myscript.android.utils.preference.RangePreference$onValueUpdate$1] */
    public RangePreference(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.onValueUpdate = new SeekBar.OnSeekBarChangeListener() { // from class: com.myscript.android.utils.preference.RangePreference$onValueUpdate$1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float fFromSeekBarValue = this.this$0.fromSeekBarValue(progress);
                if (Intrinsics.areEqual(this.this$0._value, fFromSeekBarValue)) {
                    return;
                }
                this.this$0.set_value(Float.valueOf(fFromSeekBarValue));
            }
        };
        configure(attrs, i, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.myscript.android.utils.preference.RangePreference$onValueUpdate$1] */
    public RangePreference(Context context, AttributeSet attrs, int i, int i2) {
        super(context, attrs, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.onValueUpdate = new SeekBar.OnSeekBarChangeListener() { // from class: com.myscript.android.utils.preference.RangePreference$onValueUpdate$1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float fFromSeekBarValue = this.this$0.fromSeekBarValue(progress);
                if (Intrinsics.areEqual(this.this$0._value, fFromSeekBarValue)) {
                    return;
                }
                this.this$0.set_value(Float.valueOf(fFromSeekBarValue));
            }
        };
        configure(attrs, i, i2);
    }

    private final void configure(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        setLayoutResource(C6014R.layout.range_preference);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, C6014R.styleable.RangePreference, defStyleAttr, defStyleRes);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            this.minValue = typedArrayObtainStyledAttributes.getFloat(C6014R.styleable.RangePreference_minRangeValue, 0.0f);
            this.maxValue = typedArrayObtainStyledAttributes.getFloat(C6014R.styleable.RangePreference_maxRangeValue, 0.0f);
            setDefaultValue(typedArrayObtainStyledAttributes.getFloat(C6014R.styleable.RangePreference_defaultRangeValue, 0.0f));
            this.stepSize = typedArrayObtainStyledAttributes.getFloat(C6014R.styleable.RangePreference_rangeStepSize, 0.0f);
            this.smallerDrawableRes = typedArrayObtainStyledAttributes.getResourceId(C6014R.styleable.RangePreference_smallerDrawable, 0);
            this.biggerDrawableRes = typedArrayObtainStyledAttributes.getResourceId(C6014R.styleable.RangePreference_biggerDrawable, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(Object defaultValue) {
        Float f = defaultValue instanceof Float ? (Float) defaultValue : null;
        set_value(Float.valueOf(getPersistedFloat(f != null ? f.floatValue() : this.defaultValue)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public Float onGetDefaultValue(TypedArray a2, int index) {
        Intrinsics.checkNotNullParameter(a2, "a");
        return Float.valueOf(a2.getFloat(index, this.defaultValue));
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder);
        View itemView = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        itemView.setClickable(false);
        SeekBar seekBar = (SeekBar) itemView.findViewById(C6014R.id.range_pref_seekbar);
        if (seekBar != null) {
            seekBar.setMax(toSeekBarValue(this.maxValue));
            seekBar.setProgress(toSeekBarValue(getValue()));
            seekBar.setOnSeekBarChangeListener(this.onValueUpdate);
        } else {
            seekBar = null;
        }
        this.seekBar = seekBar;
        ImageView imageView = (ImageView) itemView.findViewById(C6014R.id.range_pref_smaller_icon);
        int i = this.smallerDrawableRes;
        if (i != 0) {
            imageView.setImageResource(i);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.android.utils.preference.RangePreference$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RangePreference.onBindViewHolder$lambda$1(this.f$0, view);
                }
            });
        } else {
            imageView.setVisibility(8);
        }
        TextView textView = (TextView) itemView.findViewById(C6014R.id.range_pref_title);
        CharSequence title = getTitle();
        if (title != null && !StringsKt.isBlank(title)) {
            textView.setText(getTitle());
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) itemView.findViewById(C6014R.id.range_pref_summary);
        CharSequence summary = getSummary();
        if (summary != null && !StringsKt.isBlank(summary)) {
            textView2.setText(getSummary());
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        ImageView imageView2 = (ImageView) itemView.findViewById(C6014R.id.range_pref_bigger_icon);
        int i2 = this.biggerDrawableRes;
        if (i2 != 0) {
            imageView2.setImageResource(i2);
            imageView2.setVisibility(0);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.android.utils.preference.RangePreference$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RangePreference.onBindViewHolder$lambda$2(this.f$0, view);
                }
            });
            return;
        }
        imageView2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(RangePreference rangePreference, View view) {
        SeekBar seekBar = rangePreference.seekBar;
        if (seekBar != null) {
            seekBar.setProgress(seekBar.getProgress() - 1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(RangePreference rangePreference, View view) {
        SeekBar seekBar = rangePreference.seekBar;
        if (seekBar != null) {
            seekBar.setProgress(seekBar.getProgress() + 1, true);
        }
    }

    private final int toSeekBarValue(float value) {
        return ((int) (value * getFactor())) - ((int) (this.minValue * getFactor()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float fromSeekBarValue(int value) {
        return this.minValue + (value / getFactor());
    }

    public final void reset() {
        if (Intrinsics.areEqual(this._value, this.defaultValue)) {
            return;
        }
        set_value(Float.valueOf(this.defaultValue));
        applyValueToUI();
    }

    private final void applyValueToUI() {
        int seekBarValue = toSeekBarValue(getValue());
        SeekBar seekBar = this.seekBar;
        if (seekBar == null || seekBarValue == seekBar.getProgress()) {
            return;
        }
        seekBar.setProgress(seekBarValue, true);
    }
}
