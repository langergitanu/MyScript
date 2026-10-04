package com.myscript.nebo.grid;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.search.HistoryAdapter;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridSearchView.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ&\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0002J\u0012\u00101\u001a\u0002002\b\b\u0002\u00102\u001a\u000203H\u0007J\u0006\u00104\u001a\u000203J\u0006\u00105\u001a\u000200J\u0010\u00106\u001a\u0002002\u0006\u00107\u001a\u000203H\u0002J\u0014\u00108\u001a\u0002002\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:J\b\u00102\u001a\u000200H\u0002J\b\u0010<\u001a\u000200H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R(\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001d@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u0006>"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridSearchView;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "searchViewIcon", "Landroid/widget/ImageView;", "searchInputView", "Landroid/widget/AutoCompleteTextView;", "navPrimaryView", "Landroid/view/View;", "closeSearch", "value", "Landroid/view/View$OnClickListener;", "onSearchIconClicked", "getOnSearchIconClicked", "()Landroid/view/View$OnClickListener;", "setOnSearchIconClicked", "(Landroid/view/View$OnClickListener;)V", "onCloseButtonClicked", "getOnCloseButtonClicked", "setOnCloseButtonClicked", "Lcom/myscript/nebo/grid/OnHistoryItemClickListener;", "onHistoryItemClickListener", "getOnHistoryItemClickListener", "()Lcom/myscript/nebo/grid/OnHistoryItemClickListener;", "setOnHistoryItemClickListener", "(Lcom/myscript/nebo/grid/OnHistoryItemClickListener;)V", "onSearchTriggered", "Lcom/myscript/nebo/grid/OnSearchTriggeredListener;", "getOnSearchTriggered", "()Lcom/myscript/nebo/grid/OnSearchTriggeredListener;", "setOnSearchTriggered", "(Lcom/myscript/nebo/grid/OnSearchTriggeredListener;)V", "historyAdapter", "Lcom/myscript/nebo/search/HistoryAdapter;", "inputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "getInputMethodManager", "()Landroid/view/inputmethod/InputMethodManager;", "init", "", TtmlNode.TEXT_EMPHASIS_MARK_OPEN, "openInputMethod", "", "searchUpdated", "close", "updateSearchIcon", "isSearchActive", "updateSearchHistory", "history", "", "", "closeInputMethod", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GridSearchView extends FrameLayout {
    private static final String TAG = "GridSearchView";
    private View closeSearch;
    private final HistoryAdapter historyAdapter;
    private View navPrimaryView;
    private View.OnClickListener onCloseButtonClicked;
    private OnHistoryItemClickListener onHistoryItemClickListener;
    private View.OnClickListener onSearchIconClicked;
    private OnSearchTriggeredListener onSearchTriggered;
    private AutoCompleteTextView searchInputView;
    private ImageView searchViewIcon;
    public static final int $stable = 8;

    public final void open() {
        open$default(this, false, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridSearchView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.historyAdapter = new HistoryAdapter(getContext());
        init$default(this, context, null, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.historyAdapter = new HistoryAdapter(getContext());
        init$default(this, context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridSearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.historyAdapter = new HistoryAdapter(getContext());
        init$default(this, context, attributeSet, 0, 4, null);
    }

    public final View.OnClickListener getOnSearchIconClicked() {
        return this.onSearchIconClicked;
    }

    public final void setOnSearchIconClicked(View.OnClickListener onClickListener) {
        ImageView imageView = this.searchViewIcon;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public final View.OnClickListener getOnCloseButtonClicked() {
        return this.onCloseButtonClicked;
    }

    public final void setOnCloseButtonClicked(View.OnClickListener onClickListener) {
        View view = this.closeSearch;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public final OnHistoryItemClickListener getOnHistoryItemClickListener() {
        return this.onHistoryItemClickListener;
    }

    public final void setOnHistoryItemClickListener(final OnHistoryItemClickListener onHistoryItemClickListener) {
        AutoCompleteTextView autoCompleteTextView = this.searchInputView;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnItemClickListener(onHistoryItemClickListener != null ? new AdapterView.OnItemClickListener() { // from class: com.myscript.nebo.grid.GridSearchView$$ExternalSyntheticLambda2
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    GridSearchView._set_onHistoryItemClickListener_$lambda$0$0(onHistoryItemClickListener, this, adapterView, view, i, j);
                }
            } : null);
        }
        this.onHistoryItemClickListener = onHistoryItemClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _set_onHistoryItemClickListener_$lambda$0$0(OnHistoryItemClickListener onHistoryItemClickListener, GridSearchView gridSearchView, AdapterView adapterView, View view, int i, long j) {
        onHistoryItemClickListener.onHistoryItemClicked(adapterView.getItemAtPosition(i).toString(), gridSearchView.historyAdapter.isClearItem(i));
    }

    public final OnSearchTriggeredListener getOnSearchTriggered() {
        return this.onSearchTriggered;
    }

    public final void setOnSearchTriggered(OnSearchTriggeredListener onSearchTriggeredListener) {
        this.onSearchTriggered = onSearchTriggeredListener;
    }

    private final InputMethodManager getInputMethodManager() {
        Object systemService = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return (InputMethodManager) systemService;
    }

    static /* synthetic */ void init$default(GridSearchView gridSearchView, Context context, AttributeSet attributeSet, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        gridSearchView.init(context, attributeSet, i);
    }

    private final void init(Context context, AttributeSet attrs, int defStyle) {
        FrameLayout.inflate(context, C6079R.layout.grid_search_action_view, this);
        this.navPrimaryView = getRootView().findViewById(C6079R.id.grid_view_toolbar_actions);
        ImageView imageView = (ImageView) getRootView().findViewById(C6079R.id.action_search);
        Intrinsics.checkNotNull(imageView);
        imageView.setVisibility(8);
        imageView.setEnabled(true);
        this.searchViewIcon = imageView;
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) getRootView().findViewById(C6079R.id.edittext_search);
        autoCompleteTextView.setAdapter(this.historyAdapter);
        autoCompleteTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.myscript.nebo.grid.GridSearchView$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return GridSearchView.init$lambda$1$0(this.f$0, textView, i, keyEvent);
            }
        });
        autoCompleteTextView.setOnKeyListener(new View.OnKeyListener() { // from class: com.myscript.nebo.grid.GridSearchView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return GridSearchView.init$lambda$1$1(this.f$0, view, i, keyEvent);
            }
        });
        this.searchInputView = autoCompleteTextView;
        View viewFindViewById = getRootView().findViewById(C6079R.id.action_close_search);
        this.closeSearch = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setEnabled(true);
        }
        AutoCompleteTextView autoCompleteTextView2 = this.searchInputView;
        if (autoCompleteTextView2 != null) {
            autoCompleteTextView2.setText("");
        }
        AutoCompleteTextView autoCompleteTextView3 = this.searchInputView;
        if (autoCompleteTextView3 != null) {
            autoCompleteTextView3.setVisibility(8);
        }
        View view = this.closeSearch;
        if (view != null) {
            view.setVisibility(8);
        }
        setVisibility(8);
        setLayoutParams(new Toolbar.LayoutParams(-2, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$1$0(GridSearchView gridSearchView, TextView textView, int i, KeyEvent keyEvent) {
        OnSearchTriggeredListener onSearchTriggeredListener;
        String string;
        Editable text;
        if (i != 3 || (onSearchTriggeredListener = gridSearchView.onSearchTriggered) == null) {
            return false;
        }
        AutoCompleteTextView autoCompleteTextView = gridSearchView.searchInputView;
        if (autoCompleteTextView == null || (text = autoCompleteTextView.getText()) == null || (string = text.toString()) == null) {
            string = "";
        }
        return onSearchTriggeredListener.onSearchTriggered(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$1$1(GridSearchView gridSearchView, View view, int i, KeyEvent keyEvent) {
        OnSearchTriggeredListener onSearchTriggeredListener;
        String string;
        Editable text;
        if (keyEvent.getAction() != 0 || i != 66 || (onSearchTriggeredListener = gridSearchView.onSearchTriggered) == null) {
            return false;
        }
        AutoCompleteTextView autoCompleteTextView = gridSearchView.searchInputView;
        if (autoCompleteTextView == null || (text = autoCompleteTextView.getText()) == null || (string = text.toString()) == null) {
            string = "";
        }
        return onSearchTriggeredListener.onSearchTriggered(string);
    }

    public static /* synthetic */ void open$default(GridSearchView gridSearchView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        gridSearchView.open(z);
    }

    public final void open(boolean openInputMethod) {
        updateSearchIcon(false);
        AutoCompleteTextView autoCompleteTextView = this.searchInputView;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setVisibility(0);
        }
        AutoCompleteTextView autoCompleteTextView2 = this.searchInputView;
        if (autoCompleteTextView2 != null) {
            autoCompleteTextView2.setText("");
        }
        if (openInputMethod) {
            AutoCompleteTextView autoCompleteTextView3 = this.searchInputView;
            if (autoCompleteTextView3 != null) {
                autoCompleteTextView3.requestFocus();
            }
            openInputMethod();
        }
        View view = this.closeSearch;
        if (view != null) {
            view.setVisibility(0);
        }
        setVisibility(0);
        setLayoutParams(new Toolbar.LayoutParams(-1, -2));
    }

    public final boolean searchUpdated() {
        updateSearchIcon(true);
        View view = this.closeSearch;
        if (view != null) {
            view.setVisibility(0);
        }
        setVisibility(0);
        setLayoutParams(new Toolbar.LayoutParams(-1, -2));
        AutoCompleteTextView autoCompleteTextView = this.searchInputView;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setVisibility(0);
        }
        AutoCompleteTextView autoCompleteTextView2 = this.searchInputView;
        if (autoCompleteTextView2 != null) {
            autoCompleteTextView2.dismissDropDown();
        }
        AutoCompleteTextView autoCompleteTextView3 = this.searchInputView;
        if (autoCompleteTextView3 != null) {
            autoCompleteTextView3.clearFocus();
        }
        closeInputMethod();
        return true;
    }

    public final void close() {
        updateSearchIcon(false);
        AutoCompleteTextView autoCompleteTextView = this.searchInputView;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setText("");
        }
        AutoCompleteTextView autoCompleteTextView2 = this.searchInputView;
        if (autoCompleteTextView2 != null) {
            autoCompleteTextView2.setVisibility(8);
        }
        View view = this.closeSearch;
        if (view != null) {
            view.setVisibility(8);
        }
        setVisibility(8);
        setLayoutParams(new Toolbar.LayoutParams(-2, -2));
        closeInputMethod();
    }

    private final void updateSearchIcon(boolean isSearchActive) {
        ImageView imageView = this.searchViewIcon;
        if (imageView != null) {
            imageView.setEnabled(!isSearchActive);
        }
        ImageView imageView2 = this.searchViewIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(isSearchActive ? 0 : 8);
        }
    }

    public final void updateSearchHistory(List<String> history) {
        Intrinsics.checkNotNullParameter(history, "history");
        this.historyAdapter.clear();
        List<String> list = history;
        if (list.isEmpty()) {
            return;
        }
        this.historyAdapter.addAll(list);
    }

    private final void openInputMethod() {
        AutoCompleteTextView autoCompleteTextView = this.searchInputView;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.requestFocus();
        }
        getInputMethodManager().showSoftInput(this.searchInputView, 1);
    }

    private final void closeInputMethod() {
        AutoCompleteTextView autoCompleteTextView = this.searchInputView;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.clearFocus();
        }
        InputMethodManager inputMethodManager = getInputMethodManager();
        AutoCompleteTextView autoCompleteTextView2 = this.searchInputView;
        inputMethodManager.hideSoftInputFromWindow(autoCompleteTextView2 != null ? autoCompleteTextView2.getWindowToken() : null, 0);
    }
}
