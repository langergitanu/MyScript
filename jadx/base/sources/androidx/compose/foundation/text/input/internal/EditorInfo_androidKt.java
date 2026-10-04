package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.p004ui.text.TextRange;
import androidx.compose.p004ui.text.input.ImeAction;
import androidx.compose.p004ui.text.input.ImeOptions;
import androidx.compose.p004ui.text.input.KeyboardCapitalization;
import androidx.compose.p004ui.text.input.KeyboardType;
import androidx.compose.p004ui.text.input.PlatformImeOptions;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.media3.extractor.p007ts.TsExtractor;
import kotlin.Metadata;

/* JADX INFO: compiled from: EditorInfo.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, m1599d2 = {"update", "", "Landroid/view/inputmethod/EditorInfo;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "contentMimeTypes", "", "", "update-pLxbY9I", "(Landroid/view/inputmethod/EditorInfo;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/input/ImeOptions;[Ljava/lang/String;)V", "hasFlag", "", "bits", "", "flag", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EditorInfo_androidKt {
    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    /* JADX INFO: renamed from: update-pLxbY9I$default, reason: not valid java name */
    public static /* synthetic */ void m3680updatepLxbY9I$default(EditorInfo editorInfo, CharSequence charSequence, long j, ImeOptions imeOptions, String[] strArr, int i, Object obj) {
        if ((i & 8) != 0) {
            strArr = null;
        }
        m3679updatepLxbY9I(editorInfo, charSequence, j, imeOptions, strArr);
    }

    /* JADX INFO: renamed from: update-pLxbY9I, reason: not valid java name */
    public static final void m3679updatepLxbY9I(EditorInfo editorInfo, CharSequence charSequence, long j, ImeOptions imeOptions, String[] strArr) {
        String privateImeOptions;
        int imeAction = imeOptions.getImeAction();
        int i = 3;
        int i2 = 6;
        if (ImeAction.m10632equalsimpl0(imeAction, ImeAction.INSTANCE.m10645getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i2 = 0;
            }
        } else if (ImeAction.m10632equalsimpl0(imeAction, ImeAction.INSTANCE.m10649getNoneeUduSuo())) {
            i2 = 1;
        } else if (ImeAction.m10632equalsimpl0(imeAction, ImeAction.INSTANCE.m10647getGoeUduSuo())) {
            i2 = 2;
        } else if (ImeAction.m10632equalsimpl0(imeAction, ImeAction.INSTANCE.m10648getNexteUduSuo())) {
            i2 = 5;
        } else if (ImeAction.m10632equalsimpl0(imeAction, ImeAction.INSTANCE.m10650getPreviouseUduSuo())) {
            i2 = 7;
        } else if (ImeAction.m10632equalsimpl0(imeAction, ImeAction.INSTANCE.m10651getSearcheUduSuo())) {
            i2 = 3;
        } else if (ImeAction.m10632equalsimpl0(imeAction, ImeAction.INSTANCE.m10652getSendeUduSuo())) {
            i2 = 4;
        } else if (!ImeAction.m10632equalsimpl0(imeAction, ImeAction.INSTANCE.m10646getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i2;
        PlatformImeOptions platformImeOptions = imeOptions.getPlatformImeOptions();
        if (platformImeOptions != null && (privateImeOptions = platformImeOptions.getPrivateImeOptions()) != null) {
            editorInfo.privateImeOptions = privateImeOptions;
        }
        LocaleListHelper.INSTANCE.setHintLocales(editorInfo, imeOptions.getHintLocales());
        int keyboardType = imeOptions.getKeyboardType();
        if (KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10706getTextPjHm6EE())) {
            i = 1;
        } else if (KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10699getAsciiPjHm6EE())) {
            editorInfo.imeOptions |= Integer.MIN_VALUE;
            i = 1;
        } else if (KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10702getNumberPjHm6EE())) {
            i = 2;
        } else if (!KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10705getPhonePjHm6EE())) {
            if (KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10708getUriPjHm6EE())) {
                i = 17;
            } else if (KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10701getEmailPjHm6EE())) {
                i = 33;
            } else if (KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10704getPasswordPjHm6EE())) {
                i = TsExtractor.TS_STREAM_TYPE_AC3;
            } else if (KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10703getNumberPasswordPjHm6EE())) {
                i = 18;
            } else {
                if (!KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10700getDecimalPjHm6EE())) {
                    throw new IllegalStateException("Invalid Keyboard Type".toString());
                }
                i = 8194;
            }
        }
        editorInfo.inputType = i;
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m10632equalsimpl0(imeOptions.getImeAction(), ImeAction.INSTANCE.m10645getDefaulteUduSuo())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int capitalization = imeOptions.getCapitalization();
            if (KeyboardCapitalization.m10668equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m10677getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m10668equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m10681getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m10668equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m10679getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m10453getStartimpl(j);
        editorInfo.initialSelEnd = TextRange.m10448getEndimpl(j);
        EditorInfoCompat.setInitialSurroundingText(editorInfo, charSequence);
        if (strArr != null) {
            EditorInfoCompat.setContentMimeTypes(editorInfo, strArr);
        }
        editorInfo.imeOptions |= 33554432;
        if (StylusHandwriting_androidKt.isStylusHandwritingSupported() && !KeyboardType.m10685equalsimpl0(imeOptions.getKeyboardType(), KeyboardType.INSTANCE.m10704getPasswordPjHm6EE()) && !KeyboardType.m10685equalsimpl0(imeOptions.getKeyboardType(), KeyboardType.INSTANCE.m10703getNumberPasswordPjHm6EE())) {
            EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, true);
            EditorInfoApi34.INSTANCE.setHandwritingGestures(editorInfo);
        } else {
            EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, false);
        }
    }
}
