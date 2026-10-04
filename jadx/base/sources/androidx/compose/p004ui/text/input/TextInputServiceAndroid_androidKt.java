package androidx.compose.p004ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.p004ui.text.TextRange;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.media3.extractor.p007ts.TsExtractor;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextInputServiceAndroid.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a\u001c\u0010\u0005\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0000\u001a\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"DEBUG_CLASS", "", "updateWithEmojiCompat", "", "Landroid/view/inputmethod/EditorInfo;", "update", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "asExecutor", "Ljava/util/concurrent/Executor;", "Landroid/view/Choreographer;", "hasFlag", "", "bits", "", "flag", "ui"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }

    public static final void update(EditorInfo editorInfo, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        String privateImeOptions;
        int imeAction = imeOptions.getImeAction();
        int i = 6;
        if (ImeAction.m10632equalsimpl0(imeAction, ImeAction.INSTANCE.m10645getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m10632equalsimpl0(imeAction, ImeAction.INSTANCE.m10649getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m10632equalsimpl0(imeAction, ImeAction.INSTANCE.m10647getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m10632equalsimpl0(imeAction, ImeAction.INSTANCE.m10648getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m10632equalsimpl0(imeAction, ImeAction.INSTANCE.m10650getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m10632equalsimpl0(imeAction, ImeAction.INSTANCE.m10651getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m10632equalsimpl0(imeAction, ImeAction.INSTANCE.m10652getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m10632equalsimpl0(imeAction, ImeAction.INSTANCE.m10646getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i;
        PlatformImeOptions platformImeOptions = imeOptions.getPlatformImeOptions();
        if (platformImeOptions != null && (privateImeOptions = platformImeOptions.getPrivateImeOptions()) != null) {
            editorInfo.privateImeOptions = privateImeOptions;
        }
        int keyboardType = imeOptions.getKeyboardType();
        if (KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10706getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10699getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10702getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10705getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10708getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10701getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10704getPasswordPjHm6EE())) {
            editorInfo.inputType = TsExtractor.TS_STREAM_TYPE_AC3;
        } else if (KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10703getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else if (KeyboardType.m10685equalsimpl0(keyboardType, KeyboardType.INSTANCE.m10700getDecimalPjHm6EE())) {
            editorInfo.inputType = 8194;
        } else {
            throw new IllegalStateException("Invalid Keyboard Type".toString());
        }
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
        editorInfo.initialSelStart = TextRange.m10453getStartimpl(textFieldValue.getSelection());
        editorInfo.initialSelEnd = TextRange.m10448getEndimpl(textFieldValue.getSelection());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }

    public static final Executor asExecutor(final Choreographer choreographer) {
        return new Executor() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                TextInputServiceAndroid_androidKt.asExecutor$lambda$0(choreographer, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asExecutor$lambda$0(Choreographer choreographer, final Runnable runnable) {
        choreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                runnable.run();
            }
        });
    }
}
