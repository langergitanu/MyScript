package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Doc;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class DataExtractionModule {
    static native void DetectAndAddFormFieldsToPDF(long j, long j2);

    static native void ExtractData(String str, String str2, int i, long j);

    static native String ExtractDataAsString(String str, int i, long j);

    static native void ExtractToXLSX(String str, String str2, long j);

    static native void ExtractToXLSXWithFilter(String str, long j, long j2);

    static native boolean IsModuleAvailable(int i);

    public enum DataExtractionEngine {
        e_tabular(0),
        e_form(1),
        e_doc_structure(2),
        e_form_key_value(3),
        e_generic_key_value(4),
        e_doc_classification(5);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, DataExtractionEngine> f1512b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        final int f1514a;

        static {
            for (DataExtractionEngine dataExtractionEngine : values()) {
                f1512b.put(Integer.valueOf(dataExtractionEngine.f1514a), dataExtractionEngine);
            }
        }

        DataExtractionEngine(int i) {
            this.f1514a = i;
        }
    }

    private DataExtractionModule() {
    }

    public static boolean isModuleAvailable(DataExtractionEngine dataExtractionEngine) throws PDFNetException {
        return IsModuleAvailable(dataExtractionEngine.f1514a);
    }

    public static String extractData(String str, DataExtractionEngine dataExtractionEngine) throws PDFNetException {
        return ExtractDataAsString(str, dataExtractionEngine.f1514a, 0L);
    }

    public static String extractData(String str, DataExtractionEngine dataExtractionEngine, DataExtractionOptions dataExtractionOptions) throws PDFNetException {
        String strExtractDataAsString = ExtractDataAsString(str, dataExtractionEngine.f1514a, dataExtractionOptions != null ? dataExtractionOptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(dataExtractionOptions);
        return strExtractDataAsString;
    }

    public static void extractData(String str, String str2, DataExtractionEngine dataExtractionEngine) throws PDFNetException {
        ExtractData(str, str2, dataExtractionEngine.f1514a, 0L);
    }

    public static void extractData(String str, String str2, DataExtractionEngine dataExtractionEngine, DataExtractionOptions dataExtractionOptions) throws PDFNetException {
        ExtractData(str, str2, dataExtractionEngine.f1514a, dataExtractionOptions != null ? dataExtractionOptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(dataExtractionOptions);
    }

    public static void detectAndAddFormFieldsToPDF(Doc doc) throws PDFNetException {
        DetectAndAddFormFieldsToPDF(doc.__GetHandle(), 0L);
        ReachabilityHelper.ensureReachable(doc);
    }

    public static void detectAndAddFormFieldsToPDF(Doc doc, DataExtractionOptions dataExtractionOptions) throws PDFNetException {
        DetectAndAddFormFieldsToPDF(doc.__GetHandle(), dataExtractionOptions != null ? dataExtractionOptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(dataExtractionOptions);
    }

    public static void extractToXLSX(String str, String str2) throws PDFNetException {
        ExtractToXLSX(str, str2, 0L);
    }

    public static void extractToXLSX(String str, String str2, DataExtractionOptions dataExtractionOptions) throws PDFNetException {
        ExtractToXLSX(str, str2, dataExtractionOptions != null ? dataExtractionOptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(dataExtractionOptions);
    }

    public static void extractToXLSX(String str, Filter filter) throws PDFNetException {
        ExtractToXLSXWithFilter(str, filter.__GetHandle(), 0L);
        ReachabilityHelper.ensureReachable(filter);
    }

    public static void extractToXLSX(String str, Filter filter, DataExtractionOptions dataExtractionOptions) throws PDFNetException {
        ExtractToXLSXWithFilter(str, filter.__GetHandle(), dataExtractionOptions != null ? dataExtractionOptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(filter);
        ReachabilityHelper.ensureReachable(dataExtractionOptions);
    }
}
