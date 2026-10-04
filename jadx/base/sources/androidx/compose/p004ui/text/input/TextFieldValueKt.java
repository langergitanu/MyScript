package androidx.compose.p004ui.text.input;

import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.TextRange;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextFieldValue.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0007"}, m1599d2 = {"getTextBeforeSelection", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/input/TextFieldValue;", "maxChars", "", "getTextAfterSelection", "getSelectedText", "ui-text"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TextFieldValueKt {
    public static final AnnotatedString getTextBeforeSelection(TextFieldValue textFieldValue, int i) {
        AnnotatedString annotatedString = textFieldValue.getAnnotatedString();
        int iM10451getMinimpl = TextRange.m10451getMinimpl(textFieldValue.getSelection());
        int i2 = iM10451getMinimpl - i;
        if (((i ^ iM10451getMinimpl) & (iM10451getMinimpl ^ i2)) < 0) {
            i2 = 0;
        }
        return annotatedString.subSequence(Math.max(0, i2), TextRange.m10451getMinimpl(textFieldValue.getSelection()));
    }

    public static final AnnotatedString getTextAfterSelection(TextFieldValue textFieldValue, int i) {
        AnnotatedString annotatedString = textFieldValue.getAnnotatedString();
        int iM10450getMaximpl = TextRange.m10450getMaximpl(textFieldValue.getSelection());
        int iM10450getMaximpl2 = TextRange.m10450getMaximpl(textFieldValue.getSelection());
        int length = iM10450getMaximpl2 + i;
        if (((i ^ length) & (iM10450getMaximpl2 ^ length)) < 0) {
            length = textFieldValue.getText().length();
        }
        return annotatedString.subSequence(iM10450getMaximpl, Math.min(length, textFieldValue.getText().length()));
    }

    public static final AnnotatedString getSelectedText(TextFieldValue textFieldValue) {
        return textFieldValue.getAnnotatedString().m10258subSequence5zctL8(textFieldValue.getSelection());
    }
}
