package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class FindReplace {
    static native void FindReplaceText(long j, String str, String str2, long j2);

    private FindReplace() {
    }

    public static void findReplaceText(PDFDoc pDFDoc, String str, String str2, FindReplaceOptions findReplaceOptions) throws PDFNetException {
        if (findReplaceOptions == null) {
            findReplaceOptions = new FindReplaceOptions();
        }
        FindReplaceText(pDFDoc.__GetHandle(), str, str2, findReplaceOptions.mo1134a());
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(findReplaceOptions);
    }

    public static void findReplaceText(PDFDoc pDFDoc, String str, String str2) throws PDFNetException {
        findReplaceText(pDFDoc, str, str2, null);
    }
}
