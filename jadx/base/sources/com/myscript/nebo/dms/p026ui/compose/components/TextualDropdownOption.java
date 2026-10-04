package com.myscript.nebo.dms.p026ui.compose.components;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: textualDropdownMenu.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/dms/ui/compose/components/TextualDropdownOption;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "label", "", "<init>", "(Ljava/lang/Object;Ljava/lang/String;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getLabel", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/String;)Lcom/myscript/nebo/dms/ui/compose/components/TextualDropdownOption;", "equals", "", "other", "hashCode", "", "toString", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class TextualDropdownOption<T> {
    public static final int $stable = 0;
    private final String label;
    private final T value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextualDropdownOption copy$default(TextualDropdownOption textualDropdownOption, Object obj, String str, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = textualDropdownOption.value;
        }
        if ((i & 2) != 0) {
            str = textualDropdownOption.label;
        }
        return textualDropdownOption.copy(obj, str);
    }

    public final T component1() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    public final TextualDropdownOption<T> copy(T value, String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        return new TextualDropdownOption<>(value, label);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextualDropdownOption)) {
            return false;
        }
        TextualDropdownOption textualDropdownOption = (TextualDropdownOption) other;
        return Intrinsics.areEqual(this.value, textualDropdownOption.value) && Intrinsics.areEqual(this.label, textualDropdownOption.label);
    }

    public int hashCode() {
        T t = this.value;
        return ((t == null ? 0 : t.hashCode()) * 31) + this.label.hashCode();
    }

    public String toString() {
        return "TextualDropdownOption(value=" + this.value + ", label=" + this.label + ")";
    }

    public TextualDropdownOption(T t, String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.value = t;
        this.label = label;
    }

    public final String getLabel() {
        return this.label;
    }

    public final T getValue() {
        return this.value;
    }
}
