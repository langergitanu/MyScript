package com.myscript.nebo.videotutorial;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PageIndicator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000fJ\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\u0018\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u000bH\u0002J\u0010\u0010!\u001a\u00020\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002J \u0010\"\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000bH\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u000bH\u0016J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u000bH\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, m1599d2 = {"Lcom/myscript/nebo/videotutorial/PageIndicator;", "Landroid/widget/HorizontalScrollView;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "itemDrawable", "Landroid/graphics/drawable/Drawable;", "indicatorList", "Landroid/widget/LinearLayout;", "imagePadding", "viewPager", "Landroidx/viewpager/widget/ViewPager;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "currentItem", "init", "", "setViewPager", "setStepCount", "actualTotal", "unlockedCount", "setCurrentItem", "position", "setPageChangeListener", "onPageScrolled", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "onPageScrollStateChanged", "state", "video-tutorial_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageIndicator extends HorizontalScrollView implements ViewPager.OnPageChangeListener {
    private int currentItem;
    private int imagePadding;
    private LinearLayout indicatorList;
    private Drawable itemDrawable;
    private ViewPager.OnPageChangeListener listener;
    private ViewPager viewPager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageIndicator(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, attributeSet);
    }

    private final void init(Context context, AttributeSet attrs) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.indicatorList = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout linearLayout2 = this.indicatorList;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicatorList");
            linearLayout2 = null;
        }
        addView(linearLayout2, new FrameLayout.LayoutParams(-2, -1, 17));
        this.imagePadding = (int) context.getResources().getDimension(C6903R.dimen.pager_indicator_padding);
        this.currentItem = 0;
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, C6903R.styleable.PageIndicator);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            this.itemDrawable = typedArrayObtainStyledAttributes.getDrawable(C6903R.styleable.PageIndicator_bullet_drawable);
            this.imagePadding = (int) typedArrayObtainStyledAttributes.getDimension(C6903R.styleable.PageIndicator_bullet_padding, this.imagePadding);
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        Drawable drawable = ContextCompat.getDrawable(context, C6903R.drawable.ic_pager_indicator_tutorial);
        Intrinsics.checkNotNull(drawable);
        this.itemDrawable = drawable;
    }

    public final void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            viewPager2.removeOnPageChangeListener(this);
        }
        this.viewPager = viewPager;
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(this);
        }
        setStepCount();
    }

    private final void setStepCount() {
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            this.currentItem = viewPager.getCurrentItem();
            PagerAdapter adapter = viewPager.getAdapter();
            Intrinsics.checkNotNull(adapter);
            int count = adapter.getCount();
            setStepCount(count, count);
        }
    }

    private final void setStepCount(int actualTotal, int unlockedCount) {
        Drawable.ConstantState constantState;
        Context context = getContext();
        int i = 0;
        while (i < actualTotal) {
            LinearLayout linearLayout = this.indicatorList;
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indicatorList");
                linearLayout = null;
            }
            View childAt = linearLayout.getChildAt(i);
            ImageView imageView = childAt instanceof ImageView ? (ImageView) childAt : null;
            if (imageView == null) {
                imageView = new ImageView(context);
                Drawable drawable = this.itemDrawable;
                imageView.setImageDrawable((drawable == null || (constantState = drawable.getConstantState()) == null) ? null : constantState.newDrawable());
                int i2 = this.imagePadding;
                imageView.setPadding(i2, i2, i2, i2);
                imageView.setTag(Integer.valueOf(i));
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.videotutorial.PageIndicator$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PageIndicator.setStepCount$lambda$1$0$0(this.f$0, view);
                    }
                });
                LinearLayout linearLayout3 = this.indicatorList;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("indicatorList");
                } else {
                    linearLayout2 = linearLayout3;
                }
                linearLayout2.addView(imageView);
            }
            boolean z = true;
            imageView.setSelected(i == this.currentItem);
            if (i >= unlockedCount) {
                z = false;
            }
            imageView.setEnabled(z);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStepCount$lambda$1$0$0(PageIndicator pageIndicator, View view) {
        ViewPager viewPager = pageIndicator.viewPager;
        if (viewPager != null) {
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
            viewPager.setCurrentItem(((Integer) tag).intValue());
        }
    }

    private final void setCurrentItem(int position) {
        LinearLayout linearLayout = this.indicatorList;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicatorList");
            linearLayout = null;
        }
        View childAt = linearLayout.getChildAt(this.currentItem);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
        ((ImageView) childAt).setSelected(false);
        LinearLayout linearLayout3 = this.indicatorList;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicatorList");
        } else {
            linearLayout2 = linearLayout3;
        }
        View childAt2 = linearLayout2.getChildAt(position);
        Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.ImageView");
        ((ImageView) childAt2).setSelected(true);
        this.currentItem = position;
    }

    public final void setPageChangeListener(ViewPager.OnPageChangeListener listener) {
        this.listener = listener;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.listener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int position) {
        setCurrentItem(position);
        ViewPager.OnPageChangeListener onPageChangeListener = this.listener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(position);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.listener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(state);
        }
    }
}
