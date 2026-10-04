package com.myscript.nebo.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.Locale;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: loaded from: classes3.dex */
public class LanguagePill extends TextView {
    public LanguagePill(Context context) {
        super(context);
    }

    public LanguagePill(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LanguagePill(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setLanguage(Locale locale) {
        setLanguage(locale, false);
    }

    public void setLanguage(Locale locale, boolean z) {
        setLanguage(locale.getLanguage() + "-" + locale.getCountry());
    }

    public void setLanguage(String str) {
        setLanguage(str, false);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0 && "".equals(getText())) {
            return;
        }
        super.setVisibility(i);
    }

    public void setLanguage(String str, boolean z) {
        if (str == null) {
            setText("");
            return;
        }
        String strReplace = str.replace('_', Soundex.SILENT_MARKER);
        int iLastIndexOf = strReplace.lastIndexOf(45);
        if (z && iLastIndexOf != -1) {
            strReplace = strReplace.substring(0, iLastIndexOf);
        }
        setText(strReplace.toUpperCase(Locale.getDefault()));
        setVisibility(0);
    }
}
