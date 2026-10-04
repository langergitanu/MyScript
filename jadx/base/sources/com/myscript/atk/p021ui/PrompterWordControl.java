package com.myscript.atk.p021ui;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.C4627R;
import com.myscript.atk.p021ui.SmartGuideEvent;

/* JADX INFO: loaded from: classes4.dex */
public class PrompterWordControl extends TextView {
    private static final String TEXT_COLOR_ID = "textColor";
    private static int mDestColor;
    private static int mLongDurationAnimation;
    private static Handler mMainHandler;
    private static int mShortDurationAnimation;
    private static int mSrcColor;
    private static int mTranslateNew;
    private static int mTranslateUpdate;
    private ObjectAnimator mColorAnim;
    private String mPreviousLabel;
    private int mPrompterWordId;
    private PrompterWordState mState;
    private PrompterWord mWord;
    private int mWordIndex;

    public PrompterWordControl(Context context) {
        super(context);
        init();
    }

    public PrompterWordControl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PrompterWordControl(Context context, PrompterWord prompterWord, int i) {
        super(context);
        init();
        setWord(prompterWord);
        this.mWordIndex = i;
        setupUI();
    }

    /* JADX INFO: renamed from: id */
    public int m1062id() {
        return this.mPrompterWordId;
    }

    private void init() {
        if (mMainHandler == null) {
            init(getContext());
        }
    }

    private static void init(Context context) {
        Resources resources = context.getResources();
        mMainHandler = new Handler(Looper.getMainLooper());
        mShortDurationAnimation = resources.getInteger(C6033R.integer.config_shortAnimTime);
        mLongDurationAnimation = resources.getInteger(C6033R.integer.config_longAnimTime);
        mTranslateNew = (int) resources.getDimension(C6033R.dimen.animation_new_translate);
        mTranslateUpdate = (int) resources.getDimension(C6033R.dimen.animation_update_translate);
        updateColorsFromTheme(context);
    }

    private void setWord(PrompterWord prompterWord) {
        this.mWord = prompterWord;
        this.mPrompterWordId = prompterWord.m1061id();
        this.mPreviousLabel = "";
        this.mState = prompterWord.state();
        setText(prompterWord.labelWithSpace());
    }

    public PrompterWord getWord() {
        return this.mWord;
    }

    public void update(PrompterWord prompterWord, int i) {
        this.mWord = prompterWord;
        this.mPreviousLabel = getText().toString();
        this.mState = prompterWord.state();
        this.mWordIndex = i;
        setTag(new SmartGuideEvent(SmartGuideEvent.SmartGuideButtons.SELECT_TEXT, this.mWordIndex));
        if (this.mPreviousLabel.equals(prompterWord.labelWithSpace())) {
            return;
        }
        setText(prompterWord.labelWithSpace());
    }

    private void setupUI() {
        setTextColor(mSrcColor);
        setAlpha(0.0f);
        setTag(new SmartGuideEvent(SmartGuideEvent.SmartGuideButtons.SELECT_TEXT, this.mWordIndex));
    }

    public void animateUpdatedWord() {
        updateColorsFromTheme(getContext());
        clearAnimation();
        if (this.mState == PrompterWordState.New) {
            setTextColor(mSrcColor);
            setTranslationX(mTranslateNew);
            animate().alpha(1.0f).translationXBy(-mTranslateNew).setDuration(mShortDurationAnimation);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, TEXT_COLOR_ID, getCurrentTextColor(), mDestColor);
            this.mColorAnim = objectAnimatorOfInt;
            objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
            this.mColorAnim.setDuration(mLongDurationAnimation);
            this.mColorAnim.setStartDelay(0L);
            this.mColorAnim.start();
            return;
        }
        if (this.mState == PrompterWordState.Delete) {
            animate().alpha(0.0f).setDuration(mShortDurationAnimation);
            return;
        }
        if (this.mState == PrompterWordState.Update) {
            ObjectAnimator objectAnimator = this.mColorAnim;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            setTextColor(mSrcColor);
            setTranslationY(mTranslateUpdate);
            animate().alpha(1.0f).translationYBy(-mTranslateUpdate).setDuration(mShortDurationAnimation);
            setTranslationY(0.0f);
            ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(this, TEXT_COLOR_ID, getCurrentTextColor(), mDestColor);
            this.mColorAnim = objectAnimatorOfInt2;
            objectAnimatorOfInt2.setEvaluator(new ArgbEvaluator());
            this.mColorAnim.setDuration(mLongDurationAnimation);
            this.mColorAnim.setStartDelay(0L);
            this.mColorAnim.start();
            return;
        }
        if (this.mState == PrompterWordState.None) {
            animate().alpha(1.0f).setDuration(mShortDurationAnimation);
            ObjectAnimator objectAnimatorOfInt3 = ObjectAnimator.ofInt(this, TEXT_COLOR_ID, getCurrentTextColor(), mDestColor);
            this.mColorAnim = objectAnimatorOfInt3;
            objectAnimatorOfInt3.setEvaluator(new ArgbEvaluator());
            this.mColorAnim.setDuration(mLongDurationAnimation);
            this.mColorAnim.setStartDelay(0L);
            this.mColorAnim.start();
        }
    }

    public void select() {
        setTextColor(mSrcColor);
    }

    public void unselect() {
        setTextColor(mDestColor);
    }

    private static void updateColorsFromTheme(Context context) {
        Resources resources = context.getResources();
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C4627R.attr.colorOnSurface, typedValue, true);
        int i = typedValue.data;
        mSrcColor = ColorUtils.setAlphaComponent(i, resources.getInteger(C6033R.integer.prompter_word_new_alpha));
        mDestColor = ColorUtils.setAlphaComponent(i, resources.getInteger(C6033R.integer.prompter_word_normal_alpha));
    }
}
