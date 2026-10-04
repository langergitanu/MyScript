package com.survicate.surveys.presentation.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.theming.FontType;
import com.survicate.surveys.presentation.theming.MicroDrawableFactory;
import com.survicate.surveys.utils.LocaleUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LanguageSelectorPopup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002/0B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJK\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\f0\u0019J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u001c\u0010\u001f\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u00132\n\u0010!\u001a\u00060\"R\u00020\u0000H\u0002J\u0010\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u00061"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/LanguageSelectorPopup;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "<init>", "(Landroid/content/Context;Lcom/survicate/surveys/entities/survey/theme/ColorScheme;Lcom/survicate/surveys/helpers/ViewDependencies;)V", "onDismiss", "Lkotlin/Function0;", "", "getOnDismiss", "()Lkotlin/jvm/functions/Function0;", "setOnDismiss", "(Lkotlin/jvm/functions/Function0;)V", "show", "anchor", "Landroid/view/View;", "languageCodes", "", "", "selectedLanguageCode", "onSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "langCode", "getLanguageItemsFrom", "Lcom/survicate/surveys/presentation/widget/LanguageSelectorPopup$LanguageItem;", "buildPopupWindow", "Landroid/widget/ListPopupWindow;", "languageAdapter", "Lcom/survicate/surveys/presentation/widget/LanguageSelectorPopup$LanguageAdapter;", "configureListView", "listView", "Landroid/widget/ListView;", "createPopupBackground", "Landroid/graphics/drawable/Drawable;", "createLanguageItemBackground", "forceHighlight", "", "measureContentWidth", "", "adapter", "Landroid/widget/ListAdapter;", "LanguageAdapter", "LanguageItem", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class LanguageSelectorPopup {
    private final ColorScheme colorScheme;
    private final Context context;
    private Function0<Unit> onDismiss;
    private final ViewDependencies viewDependencies;

    public LanguageSelectorPopup(Context context, ColorScheme colorScheme, ViewDependencies viewDependencies) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        this.context = context;
        this.colorScheme = colorScheme;
        this.viewDependencies = viewDependencies;
    }

    public final Function0<Unit> getOnDismiss() {
        return this.onDismiss;
    }

    public final void setOnDismiss(Function0<Unit> function0) {
        this.onDismiss = function0;
    }

    public static /* synthetic */ void show$default(LanguageSelectorPopup languageSelectorPopup, View view, List list, String str, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        languageSelectorPopup.show(view, list, str, function1);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.survicate.surveys.presentation.widget.LanguageSelectorPopup$show$lifecycleObserver$1] */
    public final void show(View anchor, List<String> languageCodes, String selectedLanguageCode, final Function1<? super String, Unit> onSelected) {
        Lifecycle lifecycleRegistry;
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(languageCodes, "languageCodes");
        Intrinsics.checkNotNullParameter(onSelected, "onSelected");
        final List<LanguageItem> languageItemsFrom = getLanguageItemsFrom(languageCodes);
        final ListPopupWindow listPopupWindowBuildPopupWindow = buildPopupWindow(anchor, new LanguageAdapter(this, languageItemsFrom, selectedLanguageCode));
        listPopupWindowBuildPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.survicate.surveys.presentation.widget.LanguageSelectorPopup$$ExternalSyntheticLambda0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                LanguageSelectorPopup.show$lambda$1$lambda$0(listPopupWindowBuildPopupWindow, onSelected, languageItemsFrom, adapterView, view, i, j);
            }
        });
        final LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(anchor);
        final ?? r3 = new DefaultLifecycleObserver() { // from class: com.survicate.surveys.presentation.widget.LanguageSelectorPopup$show$lifecycleObserver$1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onStop(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                listPopupWindowBuildPopupWindow.dismiss();
            }
        };
        if (lifecycleOwner != null && (lifecycleRegistry = lifecycleOwner.getLifecycleRegistry()) != null) {
            lifecycleRegistry.addObserver((LifecycleObserver) r3);
        }
        listPopupWindowBuildPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.survicate.surveys.presentation.widget.LanguageSelectorPopup$$ExternalSyntheticLambda1
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                LanguageSelectorPopup.show$lambda$2(lifecycleOwner, r3, this);
            }
        });
        listPopupWindowBuildPopupWindow.show();
        ListView listView = listPopupWindowBuildPopupWindow.getListView();
        if (listView == null) {
            return;
        }
        configureListView(listView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$1$lambda$0(ListPopupWindow listPopupWindow, Function1 function1, List list, AdapterView adapterView, View view, int i, long j) {
        listPopupWindow.dismiss();
        function1.invoke(((LanguageItem) list.get(i)).getLanguageCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$2(LifecycleOwner lifecycleOwner, LanguageSelectorPopup$show$lifecycleObserver$1 languageSelectorPopup$show$lifecycleObserver$1, LanguageSelectorPopup languageSelectorPopup) {
        Lifecycle lifecycleRegistry;
        if (lifecycleOwner != null && (lifecycleRegistry = lifecycleOwner.getLifecycleRegistry()) != null) {
            lifecycleRegistry.removeObserver(languageSelectorPopup$show$lifecycleObserver$1);
        }
        Function0<Unit> function0 = languageSelectorPopup.onDismiss;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final List<LanguageItem> getLanguageItemsFrom(List<String> languageCodes) {
        List<String> list = languageCodes;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            arrayList.add(new LanguageItem(str, LocaleUtils.INSTANCE.getDisplayName(str), LocaleUtils.INSTANCE.getTalkbackName(str)));
        }
        return arrayList;
    }

    private final ListPopupWindow buildPopupWindow(View anchor, LanguageAdapter languageAdapter) {
        ListPopupWindow listPopupWindow = new ListPopupWindow(this.context);
        listPopupWindow.setAnchorView(anchor);
        LanguageAdapter languageAdapter2 = languageAdapter;
        listPopupWindow.setWidth(measureContentWidth(languageAdapter2));
        listPopupWindow.setModal(true);
        listPopupWindow.setInputMethodMode(2);
        listPopupWindow.setBackgroundDrawable(createPopupBackground());
        listPopupWindow.setAdapter(languageAdapter2);
        return listPopupWindow;
    }

    private final void configureListView(ListView listView) {
        Object parent = listView.getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view != null) {
            view.setClipToOutline(true);
        }
        listView.setSelector(new ColorDrawable(0));
    }

    private final Drawable createPopupBackground() {
        return MicroDrawableFactory.INSTANCE.createLanguageSelectorBackground(this.context, this.colorScheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable createLanguageItemBackground(boolean forceHighlight) {
        return MicroDrawableFactory.INSTANCE.createLanguageItemBackground(this.context, this.colorScheme, forceHighlight);
    }

    private final int measureContentWidth(ListAdapter adapter) {
        FrameLayout frameLayout = new FrameLayout(this.context);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = adapter.getCount();
        View view = null;
        int iMax = 0;
        for (int i = 0; i < count; i++) {
            view = adapter.getView(i, view, frameLayout);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        return iMax;
    }

    /* JADX INFO: compiled from: LanguageSelectorPopup.kt */
    @Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\nH\u0016J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0004H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/LanguageSelectorPopup$LanguageAdapter;", "Landroid/widget/BaseAdapter;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/survicate/surveys/presentation/widget/LanguageSelectorPopup$LanguageItem;", "selectedLanguageCode", "", "<init>", "(Lcom/survicate/surveys/presentation/widget/LanguageSelectorPopup;Ljava/util/List;Ljava/lang/String;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setupItemView", "", "itemView", "item", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    private final class LanguageAdapter extends BaseAdapter {
        private final List<LanguageItem> items;
        private final String selectedLanguageCode;
        final /* synthetic */ LanguageSelectorPopup this$0;

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        public LanguageAdapter(LanguageSelectorPopup languageSelectorPopup, List<LanguageItem> items, String str) {
            Intrinsics.checkNotNullParameter(items, "items");
            this.this$0 = languageSelectorPopup;
            this.items = items;
            this.selectedLanguageCode = str;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.items.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            return this.items.get(position);
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (convertView == null) {
                convertView = LayoutInflater.from(this.this$0.context).inflate(C8369R.layout.item_micro_language_selector, parent, false);
                Intrinsics.checkNotNullExpressionValue(convertView, "inflate(...)");
            }
            setupItemView(convertView, this.items.get(position));
            return convertView;
        }

        private final void setupItemView(View itemView, LanguageItem item) {
            boolean zAreEqual = Intrinsics.areEqual(item.getLanguageCode(), this.selectedLanguageCode);
            itemView.setBackground(this.this$0.createLanguageItemBackground(zAreEqual));
            TextView textView = (TextView) itemView.findViewById(C8369R.id.item_micro_language_selector_lang_name);
            textView.setTypeface(this.this$0.viewDependencies.getFontProvider().provideFont(this.this$0.context, zAreEqual ? FontType.BOLD : FontType.REGULAR));
            textView.setText(item.getDisplayName());
            textView.setTextColor(zAreEqual ? this.this$0.colorScheme.getQuestion() : this.this$0.colorScheme.getAnswer());
            textView.setContentDescription(item.getContentDescription());
        }
    }

    /* JADX INFO: compiled from: LanguageSelectorPopup.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/LanguageSelectorPopup$LanguageItem;", "", RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE, "", "displayName", "contentDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLanguageCode", "()Ljava/lang/String;", "getDisplayName", "getContentDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    private static final /* data */ class LanguageItem {
        private final String contentDescription;
        private final String displayName;
        private final String languageCode;

        public static /* synthetic */ LanguageItem copy$default(LanguageItem languageItem, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = languageItem.languageCode;
            }
            if ((i & 2) != 0) {
                str2 = languageItem.displayName;
            }
            if ((i & 4) != 0) {
                str3 = languageItem.contentDescription;
            }
            return languageItem.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLanguageCode() {
            return this.languageCode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDisplayName() {
            return this.displayName;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getContentDescription() {
            return this.contentDescription;
        }

        public final LanguageItem copy(String languageCode, String displayName, String contentDescription) {
            Intrinsics.checkNotNullParameter(languageCode, "languageCode");
            Intrinsics.checkNotNullParameter(displayName, "displayName");
            Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
            return new LanguageItem(languageCode, displayName, contentDescription);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LanguageItem)) {
                return false;
            }
            LanguageItem languageItem = (LanguageItem) other;
            return Intrinsics.areEqual(this.languageCode, languageItem.languageCode) && Intrinsics.areEqual(this.displayName, languageItem.displayName) && Intrinsics.areEqual(this.contentDescription, languageItem.contentDescription);
        }

        public int hashCode() {
            return (((this.languageCode.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.contentDescription.hashCode();
        }

        public String toString() {
            return "LanguageItem(languageCode=" + this.languageCode + ", displayName=" + this.displayName + ", contentDescription=" + this.contentDescription + ')';
        }

        public LanguageItem(String languageCode, String displayName, String contentDescription) {
            Intrinsics.checkNotNullParameter(languageCode, "languageCode");
            Intrinsics.checkNotNullParameter(displayName, "displayName");
            Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
            this.languageCode = languageCode;
            this.displayName = displayName;
            this.contentDescription = contentDescription;
        }

        public final String getLanguageCode() {
            return this.languageCode;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final String getContentDescription() {
            return this.contentDescription;
        }
    }
}
