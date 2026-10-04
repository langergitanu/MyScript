package com.myscript.nebo.common.indicator;

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
import androidx.viewpager.widget.ViewPager;
import com.myscript.nebo.common.C6183R;

/* JADX INFO: loaded from: classes3.dex */
public class PageIndicator extends HorizontalScrollView implements ViewPager.OnPageChangeListener {
    private View.OnClickListener mClickListener;
    private int mCurrentItem;
    private int mImagePadding;
    private LinearLayout mIndicatorList;
    private Drawable mItemDrawable;
    private ViewPager.OnPageChangeListener mListener;
    private ViewPager mViewPager;

    public PageIndicator(Context context) {
        super(context);
        init(context, null);
    }

    public PageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public PageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public PageIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.mIndicatorList = linearLayout;
        linearLayout.setOrientation(0);
        addView(this.mIndicatorList, new FrameLayout.LayoutParams(-2, -1, 17));
        this.mImagePadding = (int) context.getResources().getDimension(C6183R.dimen.pager_indicator_padding);
        this.mCurrentItem = 0;
        this.mItemDrawable = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6183R.styleable.PageIndicator);
            this.mItemDrawable = typedArrayObtainStyledAttributes.getDrawable(C6183R.styleable.PageIndicator_bullet_drawable);
            this.mImagePadding = (int) typedArrayObtainStyledAttributes.getDimension(C6183R.styleable.PageIndicator_bullet_padding, this.mImagePadding);
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.mItemDrawable == null) {
            this.mItemDrawable = ContextCompat.getDrawable(context, C6183R.drawable.ic_pager_indicator_default);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        viewPager.addOnPageChangeListener(this);
        this.mClickListener = new View.OnClickListener() { // from class: com.myscript.nebo.common.indicator.PageIndicator$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setViewPager$0(view);
            }
        };
        setStepCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewPager$0(View view) {
        if (isClickable()) {
            this.mViewPager.setCurrentItem(((Integer) view.getTag()).intValue());
        }
    }

    private void setStepCount() {
        this.mCurrentItem = this.mViewPager.getCurrentItem();
        int count = this.mViewPager.getAdapter().getCount();
        setStepCount(count, count);
    }

    public void setStepCount(int i, int i2) {
        Context context = getContext();
        int i3 = 0;
        while (i3 < i) {
            boolean z = true;
            boolean z2 = i3 == this.mCurrentItem;
            ImageView imageView = (ImageView) this.mIndicatorList.getChildAt(i3);
            if (imageView == null) {
                imageView = new ImageView(context);
                imageView.setImageDrawable(this.mItemDrawable.getConstantState().newDrawable());
                int i4 = this.mImagePadding;
                imageView.setPadding(i4, i4, i4, i4);
                imageView.setTag(Integer.valueOf(i3));
                imageView.setOnClickListener(this.mClickListener);
                this.mIndicatorList.addView(imageView);
            }
            imageView.setSelected(z2);
            if (i3 >= i2) {
                z = false;
            }
            imageView.setEnabled(z);
            i3++;
        }
    }

    public void setCurrentItem(int i) {
        ImageView imageView = (ImageView) this.mIndicatorList.getChildAt(this.mCurrentItem);
        if (imageView != null) {
            imageView.setSelected(false);
        }
        ImageView imageView2 = (ImageView) this.mIndicatorList.getChildAt(i);
        if (imageView2 != null) {
            imageView2.setSelected(true);
        }
        this.mCurrentItem = i;
    }

    public void setPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mListener = onPageChangeListener;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        setCurrentItem(i);
        ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }
}
