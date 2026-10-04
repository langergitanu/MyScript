package com.myscript.atk.resourcemanager.utils;

import com.myscript.atk.resourcemanager.internal.utils.IOUtils;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Parser<T> {
    public abstract T parse(String str);

    public T parse(File file) throws FileNotFoundException {
        return parse(IOUtils.fileToString(file));
    }

    protected String[] fastSplit(String str, char c) {
        if (str == null || str.length() == 0) {
            return new String[0];
        }
        String[] strArr = new String[str.length() / 2];
        int iIndexOf = str.indexOf(c);
        int i = 0;
        int i2 = 0;
        while (iIndexOf >= 0) {
            strArr[i] = str.substring(i2, iIndexOf);
            i2 = iIndexOf + 1;
            iIndexOf = str.indexOf(c, i2);
            i++;
        }
        int i3 = i + 1;
        strArr[i] = str.substring(i2);
        String[] strArr2 = new String[i3];
        System.arraycopy(strArr, 0, strArr2, 0, i3);
        return strArr2;
    }
}
