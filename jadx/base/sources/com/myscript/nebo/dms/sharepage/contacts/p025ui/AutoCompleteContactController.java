package com.myscript.nebo.dms.sharepage.contacts.p025ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.nebo.dms.sharepage.C6280R;
import com.myscript.nebo.dms.sharepage.contacts.model.ContactItem;
import com.myscript.snt.core.SearchMatchParser;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: AutoCompleteContactController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002 !B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J*\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J*\u0010\u001a\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0014\u0010\u001c\u001a\u00020\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/contacts/ui/AutoCompleteContactController;", "Landroid/text/TextWatcher;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "autoCompleteTextView", "Landroid/widget/AutoCompleteTextView;", "callback", "Lcom/myscript/nebo/dms/sharepage/contacts/ui/AutoCompleteContactController$AutoCompleteContactCallback;", "<init>", "(Landroid/content/Context;Landroid/widget/AutoCompleteTextView;Lcom/myscript/nebo/dms/sharepage/contacts/ui/AutoCompleteContactController$AutoCompleteContactCallback;)V", "adapter", "Lcom/myscript/nebo/dms/sharepage/contacts/ui/SuggestedContactsAdapter;", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "isValidEmail", "", TypedValues.AttributesType.S_TARGET, "", "beforeTextChanged", CmcdData.STREAMING_FORMAT_SS, TtmlNode.START, "", "count", TtmlNode.ANNOTATION_POSITION_AFTER, "onTextChanged", TtmlNode.ANNOTATION_POSITION_BEFORE, "updateSuggestions", "contacts", "", "Lcom/myscript/nebo/dms/sharepage/contacts/model/ContactItem;", "AutoCompleteContactCallback", "Companion", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AutoCompleteContactController implements TextWatcher {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Character[] EMAIL_SEPARATOR_CHARS = {Character.valueOf(AbstractJsonLexerKt.COMMA), Character.valueOf(SearchMatchParser.DELIMETER)};
    private SuggestedContactsAdapter adapter;
    private final AutoCompleteTextView autoCompleteTextView;
    private final AutoCompleteContactCallback callback;

    /* JADX INFO: compiled from: AutoCompleteContactController.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/contacts/ui/AutoCompleteContactController$AutoCompleteContactCallback;", "", "addContact", "", "contact", "Lcom/myscript/nebo/dms/sharepage/contacts/model/ContactItem;", "fetchContacts", "queryText", "", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface AutoCompleteContactCallback {
        void addContact(ContactItem contact);

        void fetchContacts(String queryText);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public AutoCompleteContactController(final Context context, final AutoCompleteTextView autoCompleteTextView, AutoCompleteContactCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(autoCompleteTextView, "autoCompleteTextView");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.autoCompleteTextView = autoCompleteTextView;
        this.callback = callback;
        this.adapter = new SuggestedContactsAdapter(context);
        autoCompleteTextView.setThreshold(2);
        autoCompleteTextView.setAdapter(this.adapter);
        autoCompleteTextView.addTextChangedListener(this);
        autoCompleteTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.myscript.nebo.dms.sharepage.contacts.ui.AutoCompleteContactController$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return AutoCompleteContactController.lambda$0$0(this.f$0, autoCompleteTextView, context, textView, i, keyEvent);
            }
        });
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.myscript.nebo.dms.sharepage.contacts.ui.AutoCompleteContactController$$ExternalSyntheticLambda1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                AutoCompleteContactController.lambda$0$1(this.f$0, autoCompleteTextView, adapterView, view, i, j);
            }
        });
        autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.myscript.nebo.dms.sharepage.contacts.ui.AutoCompleteContactController$$ExternalSyntheticLambda2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                AutoCompleteContactController.lambda$0$2(this.f$0, autoCompleteTextView, context, view, z);
            }
        });
    }

    static final boolean lambda$0$0(AutoCompleteContactController autoCompleteContactController, AutoCompleteTextView autoCompleteTextView, Context context, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 5 || keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) {
            Editable text = autoCompleteTextView.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            if (autoCompleteContactController.isValidEmail(text)) {
                autoCompleteContactController.callback.addContact(new ContactItem(autoCompleteTextView.getText().toString(), 0L, null, null, 14, null));
                autoCompleteTextView.setText("");
                return true;
            }
        }
        Editable text2 = autoCompleteTextView.getText();
        Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
        if (StringsKt.isBlank(text2)) {
            return true;
        }
        autoCompleteTextView.setError(context.getString(C6280R.string.share_page_contact_input_error));
        return true;
    }

    static final void lambda$0$1(AutoCompleteContactController autoCompleteContactController, AutoCompleteTextView autoCompleteTextView, AdapterView adapterView, View view, int i, long j) {
        ContactItem item = autoCompleteContactController.adapter.getItem(i);
        if (item != null) {
            autoCompleteContactController.callback.addContact(item);
        }
        autoCompleteTextView.setText("");
    }

    static final void lambda$0$2(AutoCompleteContactController autoCompleteContactController, AutoCompleteTextView autoCompleteTextView, Context context, View view, boolean z) {
        if (z) {
            return;
        }
        Editable text = autoCompleteTextView.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        if (autoCompleteContactController.isValidEmail(text)) {
            autoCompleteContactController.callback.addContact(new ContactItem(autoCompleteTextView.getText().toString(), 0L, null, null, 14, null));
            autoCompleteTextView.setText("");
            return;
        }
        Editable text2 = autoCompleteTextView.getText();
        Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
        if (StringsKt.isBlank(text2)) {
            return;
        }
        autoCompleteTextView.setError(context.getString(C6280R.string.share_page_contact_input_error));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String string;
        String str;
        Character chLastOrNull;
        if (editable == null || (string = editable.toString()) == null || (chLastOrNull = StringsKt.lastOrNull((str = string))) == null) {
            return;
        }
        char cCharValue = chLastOrNull.charValue();
        if (ArraysKt.contains(EMAIL_SEPARATOR_CHARS, Character.valueOf(cCharValue)) || Character.isWhitespace(cCharValue)) {
            String string2 = StringsKt.trim((CharSequence) StringsKt.take(string, string.length() - 1)).toString();
            if (isValidEmail(string2)) {
                this.callback.addContact(new ContactItem(string2, 0L, null, null, 14, null));
                this.autoCompleteTextView.setText("");
                return;
            }
            return;
        }
        this.callback.fetchContacts(StringsKt.trim((CharSequence) str).toString());
    }

    private final boolean isValidEmail(CharSequence target) {
        if (StringsKt.isBlank(target)) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(StringsKt.trim(target)).matches();
    }

    public final void updateSuggestions(List<ContactItem> contacts) {
        Intrinsics.checkNotNullParameter(contacts, "contacts");
        SuggestedContactsAdapter suggestedContactsAdapter = this.adapter;
        suggestedContactsAdapter.clear();
        suggestedContactsAdapter.addAll(contacts);
        suggestedContactsAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: compiled from: AutoCompleteContactController.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\f\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/contacts/ui/AutoCompleteContactController$Companion;", "", "<init>", "()V", "EMAIL_SEPARATOR_CHARS", "", "", "getEMAIL_SEPARATOR_CHARS", "()[Ljava/lang/Character;", "[Ljava/lang/Character;", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Character[] getEMAIL_SEPARATOR_CHARS() {
            return AutoCompleteContactController.EMAIL_SEPARATOR_CHARS;
        }
    }
}
