package com.myscript.android.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class EllipsizeTextView extends AppCompatTextView {
    private boolean isEllipsized;
    private boolean isStale;
    private final List<EllipsizeListener> mEllipsizeListeners;
    private EllipsizeStrategy mEllipsizeStrategy;
    private Pattern mEndPunctPattern;
    private CharSequence mFullText;
    private float mLineAddVertPad;
    private float mLineSpacingMult;
    private int mMaxLines;
    private boolean programmaticChange;
    private static final CharSequence ELLIPSIS = "…";
    private static final Pattern DEFAULT_END_PUNCTUATION = Pattern.compile("[\\.!?,;:…]*$", 32);

    public interface EllipsizeListener {
        void ellipsizeStateChanged(boolean z);
    }

    public EllipsizeTextView(Context context) {
        this(context, null);
    }

    public EllipsizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.textViewStyle);
    }

    public EllipsizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEllipsizeListeners = new ArrayList();
        this.mLineSpacingMult = 1.0f;
        this.mLineAddVertPad = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.maxLines}, i, 0);
        setMaxLines(typedArrayObtainStyledAttributes.getInt(0, Integer.MAX_VALUE));
        typedArrayObtainStyledAttributes.recycle();
        setEndPunctuationPattern(DEFAULT_END_PUNCTUATION);
    }

    public void setEndPunctuationPattern(Pattern pattern) {
        this.mEndPunctPattern = pattern;
    }

    public void addEllipsizeListener(EllipsizeListener ellipsizeListener) {
        this.mEllipsizeListeners.add(ellipsizeListener);
    }

    public void removeEllipsizeListener(EllipsizeListener ellipsizeListener) {
        this.mEllipsizeListeners.remove(ellipsizeListener);
    }

    public boolean isEllipsized() {
        return this.isEllipsized;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.mMaxLines;
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.mMaxLines = i;
        this.isStale = true;
    }

    public boolean ellipsizingLastFullyVisibleLine() {
        return this.mMaxLines == Integer.MAX_VALUE;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.mLineAddVertPad = f;
        this.mLineSpacingMult = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (!this.programmaticChange) {
            this.mFullText = charSequence;
            this.isStale = true;
        }
        super.setText(charSequence, bufferType);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (ellipsizingLastFullyVisibleLine()) {
            this.isStale = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        if (ellipsizingLastFullyVisibleLine()) {
            this.isStale = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.isStale) {
            resetText();
        }
        super.onDraw(canvas);
    }

    private void resetText() {
        boolean z;
        int maxLines = getMaxLines();
        CharSequence charSequenceProcessText = this.mFullText;
        if (maxLines != -1) {
            if (this.mEllipsizeStrategy == null) {
                setEllipsize(null);
            }
            charSequenceProcessText = this.mEllipsizeStrategy.processText(this.mFullText);
            z = !this.mEllipsizeStrategy.isInLayout(this.mFullText);
        } else {
            z = false;
        }
        if (!charSequenceProcessText.equals(getText())) {
            this.programmaticChange = true;
            try {
                setText(charSequenceProcessText);
            } finally {
                this.programmaticChange = false;
            }
        }
        this.isStale = false;
        if (z != this.isEllipsized) {
            this.isEllipsized = z;
            Iterator<EllipsizeListener> it = this.mEllipsizeListeners.iterator();
            while (it.hasNext()) {
                it.next().ellipsizeStateChanged(z);
            }
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == null) {
            this.mEllipsizeStrategy = new EllipsizeNoneStrategy();
            return;
        }
        int i = C60131.$SwitchMap$android$text$TextUtils$TruncateAt[truncateAt.ordinal()];
        if (i == 1) {
            this.mEllipsizeStrategy = new EllipsizeEndStrategy();
            return;
        }
        if (i == 2) {
            this.mEllipsizeStrategy = new EllipsizeStartStrategy();
            return;
        }
        if (i == 3) {
            this.mEllipsizeStrategy = new EllipsizeMiddleStrategy();
            return;
        }
        if (i == 4) {
            super.setEllipsize(truncateAt);
            this.isStale = false;
        }
        this.mEllipsizeStrategy = new EllipsizeNoneStrategy();
    }

    /* JADX INFO: renamed from: com.myscript.android.utils.EllipsizeTextView$1 */
    static /* synthetic */ class C60131 {
        static final /* synthetic */ int[] $SwitchMap$android$text$TextUtils$TruncateAt;

        static {
            int[] iArr = new int[TextUtils.TruncateAt.values().length];
            $SwitchMap$android$text$TextUtils$TruncateAt = iArr;
            try {
                iArr[TextUtils.TruncateAt.END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$text$TextUtils$TruncateAt[TextUtils.TruncateAt.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$text$TextUtils$TruncateAt[TextUtils.TruncateAt.MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$text$TextUtils$TruncateAt[TextUtils.TruncateAt.MARQUEE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private abstract class EllipsizeStrategy {
        protected abstract CharSequence createEllipsizedText(CharSequence charSequence);

        private EllipsizeStrategy() {
        }

        public CharSequence processText(CharSequence charSequence) {
            return !isInLayout(charSequence) ? createEllipsizedText(charSequence) : charSequence;
        }

        public boolean isInLayout(CharSequence charSequence) {
            return createWorkingLayout(charSequence).getLineCount() <= getLinesCount();
        }

        protected Layout createWorkingLayout(CharSequence charSequence) {
            return new StaticLayout(charSequence, EllipsizeTextView.this.getPaint(), (EllipsizeTextView.this.getMeasuredWidth() - EllipsizeTextView.this.getPaddingLeft()) - EllipsizeTextView.this.getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, EllipsizeTextView.this.mLineSpacingMult, EllipsizeTextView.this.mLineAddVertPad, false);
        }

        protected int getLinesCount() {
            if (EllipsizeTextView.this.ellipsizingLastFullyVisibleLine()) {
                int fullyVisibleLinesCount = getFullyVisibleLinesCount();
                if (fullyVisibleLinesCount == -1) {
                    return 1;
                }
                return fullyVisibleLinesCount;
            }
            return EllipsizeTextView.this.mMaxLines;
        }

        protected int getFullyVisibleLinesCount() {
            return ((EllipsizeTextView.this.getHeight() - EllipsizeTextView.this.getCompoundPaddingTop()) - EllipsizeTextView.this.getCompoundPaddingBottom()) / createWorkingLayout("").getLineBottom(0);
        }
    }

    private class EllipsizeNoneStrategy extends EllipsizeStrategy {
        @Override // com.myscript.android.utils.EllipsizeTextView.EllipsizeStrategy
        protected CharSequence createEllipsizedText(CharSequence charSequence) {
            return charSequence;
        }

        private EllipsizeNoneStrategy() {
            super();
        }
    }

    private class EllipsizeEndStrategy extends EllipsizeStrategy {
        private EllipsizeEndStrategy() {
            super();
        }

        @Override // com.myscript.android.utils.EllipsizeTextView.EllipsizeStrategy
        protected CharSequence createEllipsizedText(CharSequence charSequence) {
            int iLastIndexOf;
            int lineEnd = createWorkingLayout(charSequence).getLineEnd(EllipsizeTextView.this.mMaxLines - 1);
            int length = charSequence.length();
            int length2 = length - lineEnd;
            if (length2 < EllipsizeTextView.ELLIPSIS.length()) {
                length2 = EllipsizeTextView.ELLIPSIS.length();
            }
            String strTrim = TextUtils.substring(charSequence, 0, length - length2).trim();
            String strStripEndPunctuation = stripEndPunctuation(strTrim);
            while (!isInLayout(strStripEndPunctuation + ((Object) EllipsizeTextView.ELLIPSIS)) && (iLastIndexOf = strTrim.lastIndexOf(32)) != -1) {
                strTrim = strTrim.substring(0, iLastIndexOf).trim();
                strStripEndPunctuation = stripEndPunctuation(strTrim);
            }
            String str = strStripEndPunctuation + ((Object) EllipsizeTextView.ELLIPSIS);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            if (charSequence instanceof Spanned) {
                TextUtils.copySpansFrom((Spanned) charSequence, 0, str.length(), null, spannableStringBuilder, 0);
            }
            return spannableStringBuilder;
        }

        public String stripEndPunctuation(CharSequence charSequence) {
            return EllipsizeTextView.this.mEndPunctPattern.matcher(charSequence).replaceFirst("");
        }
    }

    private class EllipsizeStartStrategy extends EllipsizeStrategy {
        private EllipsizeStartStrategy() {
            super();
        }

        @Override // com.myscript.android.utils.EllipsizeTextView.EllipsizeStrategy
        protected CharSequence createEllipsizedText(CharSequence charSequence) {
            int iIndexOf;
            int lineEnd = createWorkingLayout(charSequence).getLineEnd(EllipsizeTextView.this.mMaxLines - 1);
            int length = charSequence.length();
            int length2 = length - lineEnd;
            if (length2 < EllipsizeTextView.ELLIPSIS.length()) {
                length2 = EllipsizeTextView.ELLIPSIS.length();
            }
            String strTrim = TextUtils.substring(charSequence, length2, length).trim();
            while (!isInLayout(((Object) EllipsizeTextView.ELLIPSIS) + strTrim) && (iIndexOf = strTrim.indexOf(32)) != -1) {
                strTrim = strTrim.substring(iIndexOf, strTrim.length()).trim();
            }
            String str = ((Object) EllipsizeTextView.ELLIPSIS) + strTrim;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            if (charSequence instanceof Spanned) {
                TextUtils.copySpansFrom((Spanned) charSequence, length - str.length(), length, null, spannableStringBuilder, 0);
            }
            return spannableStringBuilder;
        }
    }

    private class EllipsizeMiddleStrategy extends EllipsizeStrategy {
        private EllipsizeMiddleStrategy() {
            super();
        }

        @Override // com.myscript.android.utils.EllipsizeTextView.EllipsizeStrategy
        protected CharSequence createEllipsizedText(CharSequence charSequence) {
            SpannableStringBuilder spannableStringBuilder;
            int lineEnd = createWorkingLayout(charSequence).getLineEnd(EllipsizeTextView.this.mMaxLines - 1);
            int length = charSequence.length();
            int length2 = length - lineEnd;
            if (length2 < EllipsizeTextView.ELLIPSIS.length()) {
                length2 = EllipsizeTextView.ELLIPSIS.length();
            }
            int i = length2 + (lineEnd % 2);
            int i2 = length / 2;
            int i3 = i / 2;
            String strTrim = TextUtils.substring(charSequence, 0, i2 - i3).trim();
            String strTrim2 = TextUtils.substring(charSequence, i2 + i3, length).trim();
            while (!isInLayout(strTrim + ((Object) EllipsizeTextView.ELLIPSIS) + strTrim2)) {
                int iLastIndexOf = strTrim.lastIndexOf(32);
                int iIndexOf = strTrim2.indexOf(32);
                if (iLastIndexOf == -1 || iIndexOf == -1) {
                    break;
                }
                strTrim = strTrim.substring(0, iLastIndexOf).trim();
                strTrim2 = strTrim2.substring(iIndexOf, strTrim2.length()).trim();
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(strTrim);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(strTrim2);
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                spannableStringBuilder = spannableStringBuilder2;
                TextUtils.copySpansFrom(spanned, 0, strTrim.length(), null, spannableStringBuilder, 0);
                TextUtils.copySpansFrom(spanned, length - strTrim2.length(), length, null, spannableStringBuilder3, 0);
            } else {
                spannableStringBuilder = spannableStringBuilder2;
            }
            return TextUtils.concat(spannableStringBuilder, EllipsizeTextView.ELLIPSIS, spannableStringBuilder3);
        }
    }
}
