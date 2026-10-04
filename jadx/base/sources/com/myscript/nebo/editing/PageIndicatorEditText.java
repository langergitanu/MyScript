package com.myscript.nebo.editing;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.myscript.nebo.C6079R;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PageIndicatorEditText.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\b\u0004*\u0001%\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u001c\u001a\u00020\u0017H\u0014J\b\u0010\u001d\u001a\u00020\u0017H\u0014J\u0016\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nJ\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0014R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0012\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&¨\u0006("}, m1599d2 = {"Lcom/myscript/nebo/editing/PageIndicatorEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "formattedSuffix", "", "getFormattedSuffix", "()Ljava/lang/String;", "fullLabel", "getFullLabel", "selectedPageNumber", "Ljava/lang/Integer;", "pageCount", "pageIndicatorChangedListener", "Lkotlin/Function1;", "", "getPageIndicatorChangedListener", "()Lkotlin/jvm/functions/Function1;", "setPageIndicatorChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "onAttachedToWindow", "onDetachedFromWindow", "setState", "requestedSelectedPageNumber", "requestedPageCount", "onSelectionChanged", "selStart", "selEnd", "onTextChangedListener", "com/myscript/nebo/editing/PageIndicatorEditText$onTextChangedListener$1", "Lcom/myscript/nebo/editing/PageIndicatorEditText$onTextChangedListener$1;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageIndicatorEditText extends AppCompatEditText {
    private static final int MIN_PAGE_COUNT = 1;
    private static final int MIN_PAGE_NUMBER = 1;
    private final PageIndicatorEditText$onTextChangedListener$1 onTextChangedListener;
    private int pageCount;
    private Function1<? super Integer, Unit> pageIndicatorChangedListener;
    private Integer selectedPageNumber;
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.myscript.nebo.editing.PageIndicatorEditText$onTextChangedListener$1] */
    public PageIndicatorEditText(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.selectedPageNumber = 1;
        this.pageCount = 1;
        setText(getFullLabel());
        this.onTextChangedListener = new TextWatcher() { // from class: com.myscript.nebo.editing.PageIndicatorEditText$onTextChangedListener$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                Intrinsics.checkNotNullParameter(charSequence, "charSequence");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Intrinsics.checkNotNullParameter(s, "s");
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Integer numValueOf;
                Intrinsics.checkNotNullParameter(s, "s");
                try {
                    String strRemoveSuffix = StringsKt.removeSuffix(s.toString(), (CharSequence) this.this$0.getFormattedSuffix());
                    numValueOf = StringsKt.isBlank(strRemoveSuffix) ? null : Integer.valueOf(Integer.parseInt(strRemoveSuffix));
                } catch (NumberFormatException unused) {
                    numValueOf = -1;
                }
                if (Intrinsics.areEqual(numValueOf, this.this$0.selectedPageNumber)) {
                    return;
                }
                this.this$0.selectedPageNumber = numValueOf != null ? Integer.valueOf(RangesKt.coerceIn(numValueOf.intValue(), 1, this.this$0.pageCount)) : null;
                PageIndicatorEditText pageIndicatorEditText = this.this$0;
                pageIndicatorEditText.setText(pageIndicatorEditText.getFullLabel());
                Editable editableText = this.this$0.getEditableText();
                Integer num = this.this$0.selectedPageNumber;
                Selection.setSelection(editableText, num != null ? PageIndicatorEditTextKt.getNumberOfDigits(num.intValue()) : 0);
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.myscript.nebo.editing.PageIndicatorEditText$onTextChangedListener$1] */
    public PageIndicatorEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.selectedPageNumber = 1;
        this.pageCount = 1;
        setText(getFullLabel());
        this.onTextChangedListener = new TextWatcher() { // from class: com.myscript.nebo.editing.PageIndicatorEditText$onTextChangedListener$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                Intrinsics.checkNotNullParameter(charSequence, "charSequence");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Intrinsics.checkNotNullParameter(s, "s");
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Integer numValueOf;
                Intrinsics.checkNotNullParameter(s, "s");
                try {
                    String strRemoveSuffix = StringsKt.removeSuffix(s.toString(), (CharSequence) this.this$0.getFormattedSuffix());
                    numValueOf = StringsKt.isBlank(strRemoveSuffix) ? null : Integer.valueOf(Integer.parseInt(strRemoveSuffix));
                } catch (NumberFormatException unused) {
                    numValueOf = -1;
                }
                if (Intrinsics.areEqual(numValueOf, this.this$0.selectedPageNumber)) {
                    return;
                }
                this.this$0.selectedPageNumber = numValueOf != null ? Integer.valueOf(RangesKt.coerceIn(numValueOf.intValue(), 1, this.this$0.pageCount)) : null;
                PageIndicatorEditText pageIndicatorEditText = this.this$0;
                pageIndicatorEditText.setText(pageIndicatorEditText.getFullLabel());
                Editable editableText = this.this$0.getEditableText();
                Integer num = this.this$0.selectedPageNumber;
                Selection.setSelection(editableText, num != null ? PageIndicatorEditTextKt.getNumberOfDigits(num.intValue()) : 0);
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.myscript.nebo.editing.PageIndicatorEditText$onTextChangedListener$1] */
    public PageIndicatorEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.selectedPageNumber = 1;
        this.pageCount = 1;
        setText(getFullLabel());
        this.onTextChangedListener = new TextWatcher() { // from class: com.myscript.nebo.editing.PageIndicatorEditText$onTextChangedListener$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                Intrinsics.checkNotNullParameter(charSequence, "charSequence");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Intrinsics.checkNotNullParameter(s, "s");
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Integer numValueOf;
                Intrinsics.checkNotNullParameter(s, "s");
                try {
                    String strRemoveSuffix = StringsKt.removeSuffix(s.toString(), (CharSequence) this.this$0.getFormattedSuffix());
                    numValueOf = StringsKt.isBlank(strRemoveSuffix) ? null : Integer.valueOf(Integer.parseInt(strRemoveSuffix));
                } catch (NumberFormatException unused) {
                    numValueOf = -1;
                }
                if (Intrinsics.areEqual(numValueOf, this.this$0.selectedPageNumber)) {
                    return;
                }
                this.this$0.selectedPageNumber = numValueOf != null ? Integer.valueOf(RangesKt.coerceIn(numValueOf.intValue(), 1, this.this$0.pageCount)) : null;
                PageIndicatorEditText pageIndicatorEditText = this.this$0;
                pageIndicatorEditText.setText(pageIndicatorEditText.getFullLabel());
                Editable editableText = this.this$0.getEditableText();
                Integer num = this.this$0.selectedPageNumber;
                Selection.setSelection(editableText, num != null ? PageIndicatorEditTextKt.getNumberOfDigits(num.intValue()) : 0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFormattedSuffix() {
        String string = getResources().getString(C6079R.string.child_page_count, Integer.valueOf(this.pageCount));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFullLabel() {
        Object obj = this.selectedPageNumber;
        if (obj == null) {
            obj = "";
        }
        return obj + getFormattedSuffix();
    }

    public final Function1<Integer, Unit> getPageIndicatorChangedListener() {
        return this.pageIndicatorChangedListener;
    }

    public final void setPageIndicatorChangedListener(Function1<? super Integer, Unit> function1) {
        this.pageIndicatorChangedListener = function1;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        addTextChangedListener(this.onTextChangedListener);
        setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.myscript.nebo.editing.PageIndicatorEditText$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return PageIndicatorEditText.onAttachedToWindow$lambda$0(this.f$0, textView, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onAttachedToWindow$lambda$0(PageIndicatorEditText pageIndicatorEditText, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 0 && i != 6) {
            return false;
        }
        if (pageIndicatorEditText.selectedPageNumber == null) {
            pageIndicatorEditText.selectedPageNumber = 1;
            pageIndicatorEditText.setText(pageIndicatorEditText.getFullLabel());
        }
        Function1<? super Integer, Unit> function1 = pageIndicatorEditText.pageIndicatorChangedListener;
        if (function1 != null) {
            Integer num = pageIndicatorEditText.selectedPageNumber;
            function1.invoke(Integer.valueOf(num != null ? num.intValue() : 1));
        }
        pageIndicatorEditText.clearFocus();
        return false;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeTextChangedListener(this.onTextChangedListener);
        setOnEditorActionListener(null);
    }

    public final void setState(int requestedSelectedPageNumber, int requestedPageCount) {
        Integer num = this.selectedPageNumber;
        if (num != null && requestedSelectedPageNumber == num.intValue() && requestedPageCount == this.pageCount) {
            return;
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(requestedPageCount, 1);
        this.pageCount = iCoerceAtLeast;
        this.selectedPageNumber = Integer.valueOf(RangesKt.coerceIn(requestedSelectedPageNumber, 1, iCoerceAtLeast));
        if (hasFocus()) {
            clearFocus();
            Object systemService = getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(getWindowToken(), 0);
        }
        Function1<? super Integer, Unit> function1 = this.pageIndicatorChangedListener;
        this.pageIndicatorChangedListener = null;
        setText(getFullLabel());
        this.pageIndicatorChangedListener = function1;
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int selStart, int selEnd) {
        Integer num = this.selectedPageNumber;
        int numberOfDigits = num != null ? PageIndicatorEditTextKt.getNumberOfDigits(num.intValue()) : 0;
        int iCoerceAtMost = RangesKt.coerceAtMost(selStart, numberOfDigits);
        int iCoerceAtMost2 = RangesKt.coerceAtMost(selEnd, numberOfDigits);
        if (selStart != iCoerceAtMost || selEnd != iCoerceAtMost2) {
            setSelection(iCoerceAtMost, iCoerceAtMost2);
        }
        super.onSelectionChanged(iCoerceAtMost, iCoerceAtMost2);
    }
}
