package com.pdftron.pdf;

import com.caverock.androidsvg.SVGParser;
import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;
import com.pdftron.sdf.ObjSet;
import java.util.HashMap;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: loaded from: classes7.dex */
public class Convert {
    public static final int e_default = 2;
    public static final int e_fast = 2;
    public static final int e_high_quality = 3;
    public static final int e_keep_all = 4;
    public static final int e_keep_most = 3;
    public static final int e_off = 0;
    public static final int e_simple = 1;
    public static final int e_strict = 1;
    public static final int e_very_strict = 0;

    static native long AppendUniversalConversion(long j, String str, long j2);

    static native long AppendUniversalConversionWithFilter(long j, long j2, long j3);

    static native long CreateBlackBoxContext(String str);

    static native long CreateBlackBoxContextConvert(String str, String str2);

    static native long CreateOfficeTemplateConversion(String str, long j);

    static native long CreateOfficeTemplateConversionWithFilter(long j, long j2);

    static native long CreateReflow(long j, String str);

    static native void DocToEmf(long j, String str);

    static native void DocToEpub(long j, String str, long j2, long j3);

    static native void DocToExcel(long j, String str, long j2);

    static native void DocToExcelWithFilter(long j, long j2, long j3);

    static native void DocToHtml(long j, String str, long j2);

    static native void DocToPowerPoint(long j, String str, long j2);

    static native void DocToPowerPointWithFilter(long j, long j2, long j3);

    static native void DocToSvg(long j, String str);

    static native void DocToSvgWithOptions(long j, String str, long j2);

    static native void DocToTiff(long j, String str, long j2);

    static native void DocToTiffWithFilter(long j, long j2, long j3);

    static native void DocToWord(long j, String str, long j2);

    static native void DocToWordWithFilter(long j, long j2, long j3);

    static native void DocToXod(long j, String str, long j2);

    static native long DocToXodStream(long j, long j2);

    static native void DocToXps(long j, String str, long j2);

    static native void FileToEpub(String str, String str2, long j, long j2);

    static native void FileToExcel(String str, String str2, long j);

    static native void FileToHtml(String str, String str2, long j);

    static native void FileToPdf(long j, String str);

    static native void FileToPowerPoint(String str, String str2, long j);

    static native void FileToTiff(String str, String str2, long j);

    static native void FileToTiffWithFilter(String str, long j, long j2);

    static native void FileToWord(String str, String str2, long j);

    static native void FileToXod(String str, String str2, long j);

    static native long FileToXodStream(String str, long j);

    static native void FileToXps(String str, String str2, long j);

    static native void FromCAD(long j, String str, long j2);

    static native void FromDICOM(long j, String str, long j2);

    static native void FromEmf(long j, String str);

    static native void FromSVG(long j, String str, long j2);

    static native void FromText(long j, String str, long j2);

    static native void FromTiff(long j, long j2);

    static native void FromXps(long j, String str);

    static native void FromXpsBuf(long j, byte[] bArr);

    static native void OfficeToPdf(long j, String str, long j2);

    static native void OfficeToPdfWithFilter(long j, long j2, long j3);

    static native void PageToEmf(long j, String str);

    static native void PageToSvg(long j, String str);

    static native void PageToSvgWithOptions(long j, String str, long j2);

    static native boolean RequiresPrinter(String str);

    static native long UniversalConversion(String str, long j);

    static native long UniversalConversionWithFilter(long j, long j2);

    static native long UniversalConversionWithPdf(long j, String str, long j2);

    static native long UniversalConversionWithPdfAndFilter(long j, long j2, long j3);

    static native void WordToPdf(long j, String str, long j2);

    static native long WordToPdfConversion(long j, String str, long j2);

    static native long WordToPdfConversionWithFilter(long j, long j2, long j3);

    static native void WordToPdfWithFilter(long j, long j2, long j3);

    public static class XPSOutputCommonOptions {
        public static final int e_op_off = 0;
        public static final int e_op_on = 1;
        public static final int e_op_pdfx_on = 2;

        /* JADX INFO: renamed from: a */
        Obj f1485a;

        /* JADX INFO: renamed from: b */
        private ObjSet f1486b;

        public XPSOutputCommonOptions() {
            try {
                ObjSet objSet = new ObjSet();
                this.f1486b = objSet;
                this.f1485a = objSet.createDict();
            } catch (PDFNetException unused) {
                System.err.println("Error Occurred when creating XPSOutputCommonOptions.");
            }
        }

        public void setPrintMode(boolean z) throws PDFNetException {
            this.f1485a.putBool("PRINTMODE", z);
        }

        public void setDPI(int i) throws PDFNetException {
            this.f1485a.putNumber("DPI", i);
        }

        public void setRenderPages(boolean z) throws PDFNetException {
            this.f1485a.putBool("RENDER", z);
        }

        public void setThickenLines(boolean z) throws PDFNetException {
            this.f1485a.putBool("THICKENLINES", z);
        }

        public void generateURLLinks(boolean z) throws PDFNetException {
            this.f1485a.putBool("URL_LINKS", z);
        }

        public void setOverprint(int i) throws PDFNetException {
            if (i == 0) {
                this.f1485a.putName("OVERPRINT_MODE", "OFF");
            } else if (i == 1) {
                this.f1485a.putName("OVERPRINT_MODE", "ON");
            } else {
                if (i != 2) {
                    return;
                }
                this.f1485a.putName("OVERPRINT_MODE", "PDFX");
            }
        }
    }

    public static class XPSOutputOptions extends XPSOutputCommonOptions {
        public void setOpenXps(boolean z) throws PDFNetException {
            this.f1485a.putBool("OPENXPS", z);
        }
    }

    public static class XODOutputOptions extends XPSOutputCommonOptions {
        public static final int e_external_xfdf = 1;
        public static final int e_flatten = 2;
        public static final int e_internal_xfdf = 0;

        public void setExtractUsingZorder(boolean z) throws PDFNetException {
            this.f1485a.putBool("USEZORDER", z);
        }

        public void setOutputThumbnails(boolean z) throws PDFNetException {
            this.f1485a.putBool("NOTHUMBS", !z);
        }

        public void setThumbnailSize(int i) throws PDFNetException {
            setThumbnailSize(i, i);
        }

        public void setThumbnailSize(int i, int i2) throws PDFNetException {
            this.f1485a.putNumber("THUMB_SIZE", i);
            this.f1485a.putNumber("LARGE_THUMB_SIZE", i2);
        }

        public void setElementLimit(int i) throws PDFNetException {
            this.f1485a.putNumber("ELEMENTLIMIT", i);
        }

        public void setOpacityMaskWorkaround(boolean z) throws PDFNetException {
            this.f1485a.putBool("MASKRENDER", z);
        }

        public void setMaximumImagePixels(int i) throws PDFNetException {
            this.f1485a.putNumber("MAX_IMAGE_PIXELS", i);
        }

        public void setFlattenThreshold(int i) throws PDFNetException {
            Convert.m1138a(this.f1485a, i);
        }

        public void setFlattenContent(int i) throws PDFNetException {
            Convert.m1139b(this.f1485a, i);
        }

        public void setPreferJPG(boolean z) throws PDFNetException {
            this.f1485a.putBool("PREFER_JPEG", z);
        }

        public void setJPGQuality(int i) throws PDFNetException {
            this.f1485a.putNumber("JPEG_QUALITY", i);
        }

        public void setSilverlightTextWorkaround(boolean z) throws PDFNetException {
            this.f1485a.putBool("REMOVE_ROTATED_TEXT", z);
        }

        public void setAnnotationOutput(int i) throws PDFNetException {
            if (i == 0) {
                this.f1485a.putName("ANNOTATION_OUTPUT", "INTERNAL");
            } else if (i == 1) {
                this.f1485a.putName("ANNOTATION_OUTPUT", "EXTERNAL");
            } else {
                if (i != 2) {
                    return;
                }
                this.f1485a.putName("ANNOTATION_OUTPUT", "FLATTEN");
            }
        }

        public void setExternalParts(boolean z) throws PDFNetException {
            this.f1485a.putBool("EXTERNAL_PARTS", z);
        }

        public void setEncryptPassword(String str) throws PDFNetException {
            this.f1485a.putName("ENCRYPT_PASSWORD", str);
        }

        public void UseSilverlightFlashCompatible(boolean z) throws PDFNetException {
            this.f1485a.putBool("COMPATIBLE_XOD", z);
        }
    }

    public static class OutputOptionsOCR {

        public enum LanguageChoice {
            e_lang_auto(0),
            e_lang_catalan(1),
            e_lang_danish(2),
            e_lang_german(3),
            e_lang_english(4),
            e_lang_spanish(5),
            e_lang_finnish(6),
            e_lang_french(7),
            e_lang_italian(8),
            e_lang_dutch(9),
            e_lang_norwegian(10),
            e_lang_portuguese(11),
            e_lang_polish(12),
            e_lang_romanian(13),
            e_lang_russian(14),
            e_lang_slovenian(15),
            e_lang_swedish(16),
            e_lang_turkish(17);


            /* JADX INFO: renamed from: b */
            private static HashMap<Integer, LanguageChoice> f1470b = new HashMap<>();

            /* JADX INFO: renamed from: a */
            private int f1472a;

            static {
                for (LanguageChoice languageChoice : values()) {
                    f1470b.put(Integer.valueOf(languageChoice.f1472a), languageChoice);
                }
            }

            LanguageChoice(int i) {
                this.f1472a = i;
            }
        }

        public enum PreferredOCREngine {
            e_engine_default(0),
            e_engine_tesseract(1);


            /* JADX INFO: renamed from: b */
            private static HashMap<Integer, PreferredOCREngine> f1473b = new HashMap<>();

            /* JADX INFO: renamed from: a */
            private int f1475a;

            static {
                for (PreferredOCREngine preferredOCREngine : values()) {
                    f1473b.put(Integer.valueOf(preferredOCREngine.f1475a), preferredOCREngine);
                }
            }

            PreferredOCREngine(int i) {
                this.f1475a = i;
            }
        }

        /* JADX INFO: renamed from: a */
        static String m1140a(LanguageChoice languageChoice) {
            switch (C69291.f1462a[languageChoice.ordinal()]) {
                case 1:
                    return "ca";
                case 2:
                    return "da";
                case 3:
                    return "de";
                case 4:
                    return "en";
                case 5:
                    return "es";
                case 6:
                    return "fi";
                case 7:
                    return "fr";
                case 8:
                    return "it";
                case 9:
                    return "nl";
                case 10:
                    return "no";
                case 11:
                    return "pt";
                case 12:
                    return "pl";
                case 13:
                    return "ro";
                case 14:
                    return "ru";
                case 15:
                    return "sl";
                case 16:
                    return "sv";
                case 17:
                    return "tr";
                default:
                    return "au";
            }
        }

        /* JADX INFO: renamed from: a */
        static String m1141a(PreferredOCREngine preferredOCREngine) {
            if (C69291.f1463b[preferredOCREngine.ordinal()] == 1) {
                return "TESS";
            }
            return "DEFAULT";
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.Convert$1 */
    static /* synthetic */ class C69291 {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f1462a;

        /* JADX INFO: renamed from: b */
        static final /* synthetic */ int[] f1463b;

        static {
            int[] iArr = new int[OutputOptionsOCR.PreferredOCREngine.values().length];
            f1463b = iArr;
            try {
                iArr[OutputOptionsOCR.PreferredOCREngine.e_engine_tesseract.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[OutputOptionsOCR.LanguageChoice.values().length];
            f1462a = iArr2;
            try {
                iArr2[OutputOptionsOCR.LanguageChoice.e_lang_catalan.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1462a[OutputOptionsOCR.LanguageChoice.e_lang_danish.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1462a[OutputOptionsOCR.LanguageChoice.e_lang_german.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1462a[OutputOptionsOCR.LanguageChoice.e_lang_english.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1462a[OutputOptionsOCR.LanguageChoice.e_lang_spanish.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1462a[OutputOptionsOCR.LanguageChoice.e_lang_finnish.ordinal()] = 6;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1462a[OutputOptionsOCR.LanguageChoice.e_lang_french.ordinal()] = 7;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1462a[OutputOptionsOCR.LanguageChoice.e_lang_italian.ordinal()] = 8;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1462a[OutputOptionsOCR.LanguageChoice.e_lang_dutch.ordinal()] = 9;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1462a[OutputOptionsOCR.LanguageChoice.e_lang_norwegian.ordinal()] = 10;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1462a[OutputOptionsOCR.LanguageChoice.e_lang_portuguese.ordinal()] = 11;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1462a[OutputOptionsOCR.LanguageChoice.e_lang_polish.ordinal()] = 12;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f1462a[OutputOptionsOCR.LanguageChoice.e_lang_romanian.ordinal()] = 13;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f1462a[OutputOptionsOCR.LanguageChoice.e_lang_russian.ordinal()] = 14;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f1462a[OutputOptionsOCR.LanguageChoice.e_lang_slovenian.ordinal()] = 15;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f1462a[OutputOptionsOCR.LanguageChoice.e_lang_swedish.ordinal()] = 16;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f1462a[OutputOptionsOCR.LanguageChoice.e_lang_turkish.ordinal()] = 17;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    public static class StructuredOutputOptions {

        public enum SectionConversionSetting {
            e_Recover,
            e_DoNotDetect,
            e_DetectAndRemove
        }

        /* JADX INFO: renamed from: a */
        static SectionConversionSetting m1142a(Obj obj) throws PDFNetException {
            if (obj != null && !obj.isNull()) {
                int number = (int) obj.getNumber();
                if (number == 1) {
                    return SectionConversionSetting.e_DoNotDetect;
                }
                if (number == 2) {
                    return SectionConversionSetting.e_DetectAndRemove;
                }
                return SectionConversionSetting.e_Recover;
            }
            return SectionConversionSetting.e_Recover;
        }
    }

    public static class HTMLOutputOptions {
        public static final int e_fixed_position = 0;
        public static final int e_ocr_always = 4;
        public static final int e_ocr_image = 1;
        public static final int e_ocr_image_text = 0;
        public static final int e_ocr_off = 3;
        public static final int e_ocr_text = 2;
        public static final int e_reflow_full = 2;
        public static final int e_reflow_paragraphs = 1;

        /* JADX INFO: renamed from: a */
        Obj f1468a;

        /* JADX INFO: renamed from: b */
        private ObjSet f1469b;

        public HTMLOutputOptions() {
            try {
                ObjSet objSet = new ObjSet();
                this.f1469b = objSet;
                this.f1468a = objSet.createDict();
            } catch (PDFNetException unused) {
                System.err.println("Error Occurred when creating HTMLOutputOptions.");
            }
        }

        public void setPreferJPG(boolean z) throws PDFNetException {
            this.f1468a.putBool("PREFER_JPEG", z);
        }

        public void setJPGQuality(int i) throws PDFNetException {
            this.f1468a.putNumber("JPEG_QUALITY", i);
        }

        public void setDPI(int i) throws PDFNetException {
            this.f1468a.putNumber("DPI", i);
        }

        public void setMaximumImagePixels(int i) throws PDFNetException {
            this.f1468a.putNumber("MAX_IMAGE_PIXELS", i);
        }

        public void setContentReflowSetting(int i) throws PDFNetException {
            if (i == 0) {
                this.f1468a.putName("REFLOW", "FIXED_POSITION");
            } else if (i == 1) {
                this.f1468a.putName("REFLOW", "REFLOW_PARAGRAPHS");
            } else {
                if (i != 2) {
                    return;
                }
                this.f1468a.putName("REFLOW", "REFLOW_FULL");
            }
        }

        public void setScale(double d) throws PDFNetException {
            this.f1468a.putNumber("SCALE", d);
        }

        public void setExternalLinks(boolean z) throws PDFNetException {
            this.f1468a.putBool("EXTERNAL_LINKS", z);
        }

        public void setInternalLinks(boolean z) throws PDFNetException {
            this.f1468a.putBool("INTERNAL_LINKS", z);
        }

        public void setSimplifyText(boolean z) throws PDFNetException {
            this.f1468a.putBool("SIMPLIFY_TEXT", z);
        }

        public void setTitle(String str) throws PDFNetException {
            this.f1468a.putText("TITLE", str);
        }

        public void setImageDPI(int i) throws PDFNetException {
            this.f1468a.putNumber("IMAGE_DPI", i);
        }

        public void setEmbedImages(boolean z) throws PDFNetException {
            this.f1468a.putBool("EMBED_IMAGES", z);
        }

        public void setFileConversionTimeoutSeconds(int i) throws PDFNetException {
            this.f1468a.putNumber("FILE_TIMEOUT", i);
        }

        public void setPages(int i, int i2) throws PDFNetException {
            this.f1468a.putNumber("PAGE_FROM", i);
            this.f1468a.putNumber("PAGE_TO", i2);
        }

        public void setPDFPassword(String str) throws PDFNetException {
            this.f1468a.putText("PASSWORD", str);
        }

        public void setSearchableImageSetting(int i) throws PDFNetException {
            if (i == 0) {
                this.f1468a.putName("OCRED", "IMAGE+TEXT");
                return;
            }
            if (i == 1) {
                this.f1468a.putName("OCRED", "IMAGE");
                return;
            }
            if (i == 2) {
                this.f1468a.putName("OCRED", "TEXT");
            } else if (i == 3) {
                this.f1468a.putName("OCRED", "OFF");
            } else {
                if (i != 4) {
                    return;
                }
                this.f1468a.putName("OCRED", "ALWAYS");
            }
        }

        public void setTextRecoveryNSE(boolean z) throws PDFNetException {
            this.f1468a.putBool("USE_OCR_NSE", z);
        }

        public void setSimpleLists(boolean z) throws PDFNetException {
            this.f1468a.putBool("SIMPLE_LISTS", z);
        }

        public void setConnectHyphens(boolean z) throws PDFNetException {
            this.f1468a.putBool("CONNECT_HYPHENS", z);
        }

        public void setDisableVerticalSplit(boolean z) throws PDFNetException {
            this.f1468a.putBool("DISABLE_VERTICAL_SPLIT", z);
        }

        public void setNoPageWidth(boolean z) throws PDFNetException {
            this.f1468a.putBool("NO_PAGE_WIDTH", z);
        }

        public void setLanguage(OutputOptionsOCR.LanguageChoice languageChoice) throws PDFNetException {
            this.f1468a.putText("LANGUAGE", OutputOptionsOCR.m1140a(languageChoice));
        }

        public void setPreferredOCREngine(OutputOptionsOCR.PreferredOCREngine preferredOCREngine) throws PDFNetException {
            this.f1468a.putText("PREFERREDOCR", OutputOptionsOCR.m1141a(preferredOCREngine));
        }

        public void setHeadersAndFootersSetting(StructuredOutputOptions.SectionConversionSetting sectionConversionSetting) throws PDFNetException {
            this.f1468a.putNumber("DETECT_HEADERSANDFOOTERS", sectionConversionSetting.ordinal());
        }

        public StructuredOutputOptions.SectionConversionSetting getHeadersAndFootersSetting() throws PDFNetException {
            return StructuredOutputOptions.m1142a(this.f1468a.findObj("DETECT_HEADERSANDFOOTERS"));
        }

        public void setFootnotesSetting(StructuredOutputOptions.SectionConversionSetting sectionConversionSetting) throws PDFNetException {
            this.f1468a.putNumber("DETECT_FOOTNOTES", sectionConversionSetting.ordinal());
        }

        public StructuredOutputOptions.SectionConversionSetting getFootnotesSetting() throws PDFNetException {
            return StructuredOutputOptions.m1142a(this.f1468a.findObj("DETECT_FOOTNOTES"));
        }
    }

    public static class WordOutputOptions {
        public static final int e_ocr_always = 4;
        public static final int e_ocr_image = 1;
        public static final int e_ocr_image_text = 0;
        public static final int e_ocr_off = 3;
        public static final int e_ocr_text = 2;
        public static final int e_wof_doc = 1;
        public static final int e_wof_docx = 0;
        public static final int e_wof_rtf = 2;
        public static final int e_wof_txt = 3;

        /* JADX INFO: renamed from: a */
        Obj f1483a;

        /* JADX INFO: renamed from: b */
        private ObjSet f1484b;

        public WordOutputOptions() {
            try {
                ObjSet objSet = new ObjSet();
                this.f1484b = objSet;
                this.f1483a = objSet.createDict();
            } catch (PDFNetException unused) {
                System.err.println("Error Occurred when creating WordOutputOptions.");
            }
        }

        public void setWordOutputFormat(int i) throws PDFNetException {
            if (i == 0) {
                this.f1483a.putName("OUTPUT_FORMAT", "DOCX");
                return;
            }
            if (i == 1) {
                this.f1483a.putName("OUTPUT_FORMAT", "DOC");
            } else if (i == 2) {
                this.f1483a.putName("OUTPUT_FORMAT", "RTF");
            } else {
                if (i != 3) {
                    return;
                }
                this.f1483a.putName("OUTPUT_FORMAT", "TXT");
            }
        }

        public void setPages(int i, int i2) throws PDFNetException {
            this.f1483a.putNumber("PAGE_FROM", i);
            this.f1483a.putNumber("PAGE_TO", i2);
        }

        public void setPDFPassword(String str) throws PDFNetException {
            this.f1483a.putText("PASSWORD", str);
        }

        public void setSearchableImageSetting(int i) throws PDFNetException {
            if (i == 0) {
                this.f1483a.putName("OCRED", "IMAGE+TEXT");
                return;
            }
            if (i == 1) {
                this.f1483a.putName("OCRED", "IMAGE");
                return;
            }
            if (i == 2) {
                this.f1483a.putName("OCRED", "TEXT");
            } else if (i == 3) {
                this.f1483a.putName("OCRED", "OFF");
            } else {
                if (i != 4) {
                    return;
                }
                this.f1483a.putName("OCRED", "ALWAYS");
            }
        }

        public void setTextRecoveryNSE(boolean z) throws PDFNetException {
            this.f1483a.putBool("USE_OCR_NSE", z);
        }

        public void setDetectTOC(boolean z) throws PDFNetException {
            this.f1483a.putBool("DETECT_TOC", z);
        }

        public void setConnectHyphens(boolean z) throws PDFNetException {
            this.f1483a.putBool("CONNECT_HYPHENS", z);
        }

        public void setLanguage(OutputOptionsOCR.LanguageChoice languageChoice) throws PDFNetException {
            this.f1483a.putText("LANGUAGE", OutputOptionsOCR.m1140a(languageChoice));
        }

        public void setPreferredOCREngine(OutputOptionsOCR.PreferredOCREngine preferredOCREngine) throws PDFNetException {
            this.f1483a.putText("PREFERREDOCR", OutputOptionsOCR.m1141a(preferredOCREngine));
        }

        public void setCustomOCRLanguage(String str) throws PDFNetException {
            this.f1483a.putText("LANGUAGE", str);
        }

        public void setPrioritizeVisualAppearance(boolean z) throws PDFNetException {
            this.f1483a.putBool("VISUAL_REPLICA", z);
        }

        public void setHeadersAndFootersSetting(StructuredOutputOptions.SectionConversionSetting sectionConversionSetting) throws PDFNetException {
            this.f1483a.putNumber("DETECT_HEADERSANDFOOTERS", sectionConversionSetting.ordinal());
        }

        public StructuredOutputOptions.SectionConversionSetting getHeadersAndFootersSetting() throws PDFNetException {
            return StructuredOutputOptions.m1142a(this.f1483a.findObj("DETECT_HEADERSANDFOOTERS"));
        }

        public void setFootnotesSetting(StructuredOutputOptions.SectionConversionSetting sectionConversionSetting) throws PDFNetException {
            this.f1483a.putNumber("DETECT_FOOTNOTES", sectionConversionSetting.ordinal());
        }

        public StructuredOutputOptions.SectionConversionSetting getFootnotesSetting() throws PDFNetException {
            return StructuredOutputOptions.m1142a(this.f1483a.findObj("DETECT_FOOTNOTES"));
        }
    }

    public static class ExcelOutputOptions {
        public static final int e_ocr_always = 4;
        public static final int e_ocr_off = 3;
        public static final int e_ocr_text = 2;

        /* JADX INFO: renamed from: a */
        Obj f1466a;

        /* JADX INFO: renamed from: b */
        private ObjSet f1467b;

        public ExcelOutputOptions() {
            try {
                ObjSet objSet = new ObjSet();
                this.f1467b = objSet;
                this.f1466a = objSet.createDict();
            } catch (PDFNetException unused) {
                System.err.println("Error Occurred when creating ExcelOutputOptions.");
            }
        }

        public void setPages(int i, int i2) throws PDFNetException {
            this.f1466a.putNumber("PAGE_FROM", i);
            this.f1466a.putNumber("PAGE_TO", i2);
        }

        public void setPDFPassword(String str) throws PDFNetException {
            this.f1466a.putText("PASSWORD", str);
        }

        public void setSearchableImageSetting(int i) throws PDFNetException {
            if (i == 2) {
                this.f1466a.putName("OCRED", "TEXT");
            } else if (i == 3) {
                this.f1466a.putName("OCRED", "OFF");
            } else {
                if (i != 4) {
                    return;
                }
                this.f1466a.putName("OCRED", "ALWAYS");
            }
        }

        public void setTextRecoveryNSE(boolean z) throws PDFNetException {
            this.f1466a.putBool("USE_OCR_NSE", z);
        }

        public void setLanguage(OutputOptionsOCR.LanguageChoice languageChoice) throws PDFNetException {
            this.f1466a.putText("LANGUAGE", OutputOptionsOCR.m1140a(languageChoice));
        }

        public void setPreferredOCREngine(OutputOptionsOCR.PreferredOCREngine preferredOCREngine) throws PDFNetException {
            this.f1466a.putText("PREFERREDOCR", OutputOptionsOCR.m1141a(preferredOCREngine));
        }

        public void setCustomOCRLanguage(String str) throws PDFNetException {
            this.f1466a.putText("LANGUAGE", str);
        }

        public void setNonTableContent(boolean z) throws PDFNetException {
            this.f1466a.putBool("NON_TABLES", z);
        }

        public void setSingleSheet(boolean z) throws PDFNetException {
            this.f1466a.putBool("SINGLE_SHEET", z);
        }

        public void setPageSingleSheet(boolean z) throws PDFNetException {
            this.f1466a.putBool("PAGE_SINGLE", z);
        }

        public void setHeadersAndFootersSetting(StructuredOutputOptions.SectionConversionSetting sectionConversionSetting) throws PDFNetException {
            this.f1466a.putNumber("DETECT_HEADERSANDFOOTERS", sectionConversionSetting.ordinal());
        }

        public StructuredOutputOptions.SectionConversionSetting getHeadersAndFootersSetting() throws PDFNetException {
            return StructuredOutputOptions.m1142a(this.f1466a.findObj("DETECT_HEADERSANDFOOTERS"));
        }

        public void setFootnotesSetting(StructuredOutputOptions.SectionConversionSetting sectionConversionSetting) throws PDFNetException {
            this.f1466a.putNumber("DETECT_FOOTNOTES", sectionConversionSetting.ordinal());
        }

        public StructuredOutputOptions.SectionConversionSetting getFootnotesSetting() throws PDFNetException {
            return StructuredOutputOptions.m1142a(this.f1466a.findObj("DETECT_FOOTNOTES"));
        }
    }

    public static class PowerPointOutputOptions {
        public static final int e_ocr_always = 4;
        public static final int e_ocr_off = 3;
        public static final int e_ocr_text = 2;

        /* JADX INFO: renamed from: a */
        Obj f1476a;

        /* JADX INFO: renamed from: b */
        private ObjSet f1477b;

        public PowerPointOutputOptions() {
            try {
                ObjSet objSet = new ObjSet();
                this.f1477b = objSet;
                this.f1476a = objSet.createDict();
            } catch (PDFNetException unused) {
                System.err.println("Error Occurred when creating PowerPointOutputOptions.");
            }
        }

        public void setPages(int i, int i2) throws PDFNetException {
            this.f1476a.putNumber("PAGE_FROM", i);
            this.f1476a.putNumber("PAGE_TO", i2);
        }

        public void setPDFPassword(String str) throws PDFNetException {
            this.f1476a.putText("PASSWORD", str);
        }

        public void setSearchableImageSetting(int i) throws PDFNetException {
            if (i == 2) {
                this.f1476a.putName("OCRED", "TEXT");
            } else if (i == 3) {
                this.f1476a.putName("OCRED", "OFF");
            } else {
                if (i != 4) {
                    return;
                }
                this.f1476a.putName("OCRED", "ALWAYS");
            }
        }

        public void setTextRecoveryNSE(boolean z) throws PDFNetException {
            this.f1476a.putBool("USE_OCR_NSE", z);
        }

        public void setLanguage(OutputOptionsOCR.LanguageChoice languageChoice) throws PDFNetException {
            this.f1476a.putText("LANGUAGE", OutputOptionsOCR.m1140a(languageChoice));
        }

        public void setPreferredOCREngine(OutputOptionsOCR.PreferredOCREngine preferredOCREngine) throws PDFNetException {
            this.f1476a.putText("PREFERREDOCR", OutputOptionsOCR.m1141a(preferredOCREngine));
        }

        public void setCustomOCRLanguage(String str) throws PDFNetException {
            this.f1476a.putText("LANGUAGE", str);
        }

        public void setHeadersAndFootersSetting(StructuredOutputOptions.SectionConversionSetting sectionConversionSetting) throws PDFNetException {
            this.f1476a.putNumber("DETECT_HEADERSANDFOOTERS", sectionConversionSetting.ordinal());
        }

        public StructuredOutputOptions.SectionConversionSetting getHeadersAndFootersSetting() throws PDFNetException {
            return StructuredOutputOptions.m1142a(this.f1476a.findObj("DETECT_HEADERSANDFOOTERS"));
        }

        public void setFootnotesSetting(StructuredOutputOptions.SectionConversionSetting sectionConversionSetting) throws PDFNetException {
            this.f1476a.putNumber("DETECT_FOOTNOTES", sectionConversionSetting.ordinal());
        }

        public StructuredOutputOptions.SectionConversionSetting getFootnotesSetting() throws PDFNetException {
            return StructuredOutputOptions.m1142a(this.f1476a.findObj("DETECT_FOOTNOTES"));
        }
    }

    public static class EPUBOutputOptions {

        /* JADX INFO: renamed from: a */
        Obj f1464a;

        /* JADX INFO: renamed from: b */
        private ObjSet f1465b;

        public EPUBOutputOptions() {
            try {
                ObjSet objSet = new ObjSet();
                this.f1465b = objSet;
                this.f1464a = objSet.createDict();
            } catch (PDFNetException unused) {
                System.err.println("Error Occurred when creating EPUBOutputOptions.");
            }
        }

        public void setExpanded(boolean z) throws PDFNetException {
            this.f1464a.putBool("EPUB_EXPANDED", z);
        }

        public void setReuseCover(boolean z) throws PDFNetException {
            this.f1464a.putBool("EPUB_REUSE_COVER", z);
        }
    }

    public static class TiffOutputOptions {
        public static final int e_art = 4;
        public static final int e_bleed = 2;
        public static final int e_crop = 1;
        public static final int e_media = 0;
        public static final int e_op_off = 0;
        public static final int e_op_on = 1;
        public static final int e_op_pdfx_on = 2;
        public static final int e_trim = 3;

        /* JADX INFO: renamed from: a */
        Obj f1481a;

        /* JADX INFO: renamed from: b */
        private ObjSet f1482b;

        public TiffOutputOptions() {
            try {
                ObjSet objSet = new ObjSet();
                this.f1482b = objSet;
                this.f1481a = objSet.createDict();
            } catch (PDFNetException unused) {
                System.err.println("Error Occurred when creating TiffOutputOptions.");
            }
        }

        public void setBox(int i) throws PDFNetException {
            if (i == 0) {
                this.f1481a.putName("BOX", SVGParser.XML_STYLESHEET_ATTR_MEDIA);
                return;
            }
            if (i == 1) {
                this.f1481a.putName("BOX", "crop");
                return;
            }
            if (i == 2) {
                this.f1481a.putName("BOX", "bleed");
            } else if (i == 3) {
                this.f1481a.putName("BOX", "trim");
            } else {
                if (i != 4) {
                    return;
                }
                this.f1481a.putName("BOX", "art");
            }
        }

        public void setRotate(int i) throws PDFNetException {
            if (i == 0) {
                this.f1481a.putName("ROTATE", "0");
                return;
            }
            if (i == 90) {
                this.f1481a.putName("ROTATE", "90");
            } else if (i == 180) {
                this.f1481a.putName("ROTATE", "180");
            } else {
                if (i != 270) {
                    return;
                }
                this.f1481a.putName("ROTATE", "270");
            }
        }

        public void setRotate(double d, double d2, double d3, double d4) throws PDFNetException {
            this.f1481a.putNumber("CLIP_X1", d);
            this.f1481a.putNumber("CLIP_Y1", d2);
            this.f1481a.putNumber("CLIP_X2", d3);
            this.f1481a.putNumber("CLIP_Y2", d4);
        }

        public void setPages(String str) throws PDFNetException {
            this.f1481a.putName("PAGES", str);
        }

        public void setOverprint(int i) throws PDFNetException {
            if (i == 0) {
                this.f1481a.putName("OVERPRINT", DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else if (i == 1) {
                this.f1481a.putName("OVERPRINT", DebugKt.DEBUG_PROPERTY_VALUE_ON);
            } else {
                if (i != 2) {
                    return;
                }
                this.f1481a.putName("OVERPRINT", "pdfx");
            }
        }

        public void setCMYK(boolean z) throws PDFNetException {
            this.f1481a.putBool("CMYK", z);
        }

        public void setDither(boolean z) throws PDFNetException {
            this.f1481a.putBool("DITHER", z);
        }

        public void setGray(boolean z) throws PDFNetException {
            this.f1481a.putBool("GRAY", z);
        }

        public void setMono(boolean z) throws PDFNetException {
            this.f1481a.putBool("MONO", z);
        }

        public void setAnnots(boolean z) throws PDFNetException {
            this.f1481a.putBool("ANNOTS", z);
        }

        public void setSmooth(boolean z) throws PDFNetException {
            this.f1481a.putBool("SMOOTH", z);
        }

        public void setPrintmode(boolean z) throws PDFNetException {
            this.f1481a.putBool("PRINTMODE", z);
        }

        public void setTransparentPage(boolean z) throws PDFNetException {
            this.f1481a.putBool("TRANSPARENT_PAGE", z);
        }

        public void setPalettized(boolean z) throws PDFNetException {
            this.f1481a.putBool("PALETTIZED", z);
        }

        public void setDPI(double d) throws PDFNetException {
            this.f1481a.putNumber("DPI", d);
        }

        public void setGamma(double d) throws PDFNetException {
            this.f1481a.putNumber("GAMMA", d);
        }

        public void setHRes(int i) throws PDFNetException {
            this.f1481a.putNumber("HRES", i);
        }

        public void setVRes(int i) throws PDFNetException {
            this.f1481a.putNumber("VRES", i);
        }
    }

    public static void fromXps(Doc doc, String str) throws PDFNetException {
        FromXps(doc.__GetHandle(), str);
        ReachabilityHelper.ensureReachable(doc);
    }

    public static void fromXps(Doc doc, byte[] bArr) throws PDFNetException {
        FromXpsBuf(doc.__GetHandle(), bArr);
        ReachabilityHelper.ensureReachable(doc);
    }

    public static void fromEmf(Doc doc, String str) throws PDFNetException {
        FromEmf(doc.__GetHandle(), str);
        ReachabilityHelper.ensureReachable(doc);
    }

    public static void fromText(Doc doc, String str, Obj obj) throws PDFNetException {
        FromText(doc.__GetHandle(), str, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(obj);
    }

    public static void toEmf(Doc doc, String str) throws PDFNetException {
        DocToEmf(doc.__GetHandle(), str);
        ReachabilityHelper.ensureReachable(doc);
    }

    public static void toEmf(Page page, String str) throws PDFNetException {
        PageToEmf(page.f1990a, str);
        ReachabilityHelper.ensureReachable(page);
    }

    public static class SVGOutputOptions {
        public static final int e_op_off = 0;
        public static final int e_op_on = 1;
        public static final int e_op_pdfx_on = 2;

        /* JADX INFO: renamed from: a */
        Obj f1478a;

        /* JADX INFO: renamed from: b */
        private ObjSet f1479b;

        public SVGOutputOptions() {
            try {
                ObjSet objSet = new ObjSet();
                this.f1479b = objSet;
                this.f1478a = objSet.createDict();
            } catch (PDFNetException unused) {
                System.err.println("Error occurred when creating SVGOutputOptions.");
            }
        }

        public void setEmbedImages(boolean z) throws PDFNetException {
            this.f1478a.putBool("EMBEDIMAGES", z);
        }

        public void setNoFonts(boolean z) throws PDFNetException {
            this.f1478a.putBool("NOFONTS", z);
        }

        public void setSvgFonts(boolean z) throws PDFNetException {
            this.f1478a.putBool("SVGFONTS", z);
        }

        public void setEmbedFonts(boolean z) throws PDFNetException {
            this.f1478a.putBool("EMBEDFONTS", z);
        }

        public void setNoUnicode(boolean z) throws PDFNetException {
            this.f1478a.putBool("NOUNICODE", z);
        }

        public void setIndividualCharPlacement(boolean z) throws PDFNetException {
            this.f1478a.putBool("INDIVIDUALCHARPLACEMENT", z);
        }

        public void setRemoveCharPlacement(boolean z) throws PDFNetException {
            this.f1478a.putBool("REMOVECHARPLACEMENT", z);
        }

        public void setFlattenContent(int i) throws PDFNetException {
            Convert.m1139b(this.f1478a, i);
        }

        public void setFlattenThreshold(int i) throws PDFNetException {
            Convert.m1138a(this.f1478a, i);
        }

        public void setCompress(boolean z) throws PDFNetException {
            this.f1478a.putBool("SVGZ", z);
        }

        public void setOutputThumbnails(boolean z) throws PDFNetException {
            this.f1478a.putBool("NOTHUMBS", !z);
        }

        public void setThumbnailSize(int i) throws PDFNetException {
            this.f1478a.putNumber("THUMB_SIZE", i);
        }

        public void setCreateXmlWrapper(boolean z) throws PDFNetException {
            this.f1478a.putBool("NOXMLDOC", !z);
        }

        public void setDtd(boolean z) throws PDFNetException {
            this.f1478a.putBool("OMITDTD", !z);
        }

        public void setAnnots(boolean z) throws PDFNetException {
            this.f1478a.putBool("NOANNOTS", !z);
        }

        public void setOverprint(int i) throws PDFNetException {
            if (i == 0) {
                this.f1478a.putName("OVERPRINT_MODE", "OFF");
            } else if (i == 1) {
                this.f1478a.putName("OVERPRINT_MODE", "ON");
            } else {
                if (i != 2) {
                    return;
                }
                this.f1478a.putName("OVERPRINT_MODE", "PDFX");
            }
        }
    }

    public static void toSvg(Doc doc, String str) throws PDFNetException {
        DocToSvg(doc.__GetHandle(), str);
        ReachabilityHelper.ensureReachable(doc);
    }

    public static void toSvg(Doc doc, String str, SVGOutputOptions sVGOutputOptions) throws PDFNetException {
        DocToSvgWithOptions(doc.__GetHandle(), str, sVGOutputOptions.f1478a.__GetHandle());
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(sVGOutputOptions);
    }

    public static void toSvg(Page page, String str) throws PDFNetException {
        PageToSvg(page.f1990a, str);
        ReachabilityHelper.ensureReachable(page);
    }

    public static void toSvg(Page page, String str, SVGOutputOptions sVGOutputOptions) throws PDFNetException {
        PageToSvgWithOptions(page.f1990a, str, sVGOutputOptions.f1478a.__GetHandle());
        ReachabilityHelper.ensureReachable(page);
        ReachabilityHelper.ensureReachable(sVGOutputOptions);
    }

    public static void toXps(Doc doc, String str) throws PDFNetException {
        DocToXps(doc.__GetHandle(), str, 0L);
        ReachabilityHelper.ensureReachable(doc);
    }

    public static void toXps(Doc doc, String str, XPSOutputOptions xPSOutputOptions) throws PDFNetException {
        DocToXps(doc.__GetHandle(), str, xPSOutputOptions.f1485a.__GetHandle());
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(xPSOutputOptions);
    }

    public static void toXps(String str, String str2) throws PDFNetException {
        FileToXps(str, str2, 0L);
    }

    public static void toXps(String str, String str2, XPSOutputOptions xPSOutputOptions) throws PDFNetException {
        FileToXps(str, str2, xPSOutputOptions.f1485a.__GetHandle());
        ReachabilityHelper.ensureReachable(xPSOutputOptions);
    }

    public static void toXod(String str, String str2) throws PDFNetException {
        FileToXod(str, str2, 0L);
    }

    public static void toXod(String str, String str2, XODOutputOptions xODOutputOptions) throws PDFNetException {
        FileToXod(str, str2, xODOutputOptions.f1485a.__GetHandle());
        ReachabilityHelper.ensureReachable(xODOutputOptions);
    }

    public static void toXod(Doc doc, String str) throws PDFNetException {
        DocToXod(doc.__GetHandle(), str, 0L);
        ReachabilityHelper.ensureReachable(doc);
    }

    public static void toXod(Doc doc, String str, XODOutputOptions xODOutputOptions) throws PDFNetException {
        DocToXod(doc.__GetHandle(), str, xODOutputOptions.f1485a.__GetHandle());
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(xODOutputOptions);
    }

    public static Filter toXod(Doc doc) throws PDFNetException {
        Filter filter__Create = Filter.__Create(DocToXodStream(doc.__GetHandle(), 0L), null);
        ReachabilityHelper.ensureReachable(doc);
        return filter__Create;
    }

    public static Filter toXod(Doc doc, XODOutputOptions xODOutputOptions) throws PDFNetException {
        Filter filter__Create = Filter.__Create(DocToXodStream(doc.__GetHandle(), xODOutputOptions.f1485a.__GetHandle()), null);
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(xODOutputOptions);
        return filter__Create;
    }

    public static Filter toXod(String str) throws PDFNetException {
        return Filter.__Create(FileToXodStream(str, 0L), null);
    }

    public static Filter toXod(String str, XODOutputOptions xODOutputOptions) throws PDFNetException {
        Filter filter__Create = Filter.__Create(FileToXodStream(str, xODOutputOptions.f1485a.__GetHandle()), null);
        ReachabilityHelper.ensureReachable(xODOutputOptions);
        return filter__Create;
    }

    public static void toHtml(String str, String str2) throws PDFNetException {
        FileToHtml(str, str2, 0L);
    }

    public static void toHtml(String str, String str2, HTMLOutputOptions hTMLOutputOptions) throws PDFNetException {
        FileToHtml(str, str2, hTMLOutputOptions.f1468a.__GetHandle());
        ReachabilityHelper.ensureReachable(hTMLOutputOptions);
    }

    public static void toHtml(Doc doc, String str) throws PDFNetException {
        DocToHtml(doc.__GetHandle(), str, 0L);
        ReachabilityHelper.ensureReachable(doc);
    }

    public static void toHtml(Doc doc, String str, HTMLOutputOptions hTMLOutputOptions) throws PDFNetException {
        DocToHtml(doc.__GetHandle(), str, hTMLOutputOptions.f1468a.__GetHandle());
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(hTMLOutputOptions);
    }

    public static void toWord(String str, String str2) throws PDFNetException {
        FileToWord(str, str2, 0L);
    }

    public static void toWord(String str, String str2, WordOutputOptions wordOutputOptions) throws PDFNetException {
        FileToWord(str, str2, wordOutputOptions.f1483a.__GetHandle());
        ReachabilityHelper.ensureReachable(wordOutputOptions);
    }

    public static void toWord(Doc doc, String str) throws PDFNetException {
        DocToWord(doc.__GetHandle(), str, 0L);
        ReachabilityHelper.ensureReachable(doc);
    }

    public static void toWord(Doc doc, String str, WordOutputOptions wordOutputOptions) throws PDFNetException {
        DocToWord(doc.__GetHandle(), str, wordOutputOptions.f1483a.__GetHandle());
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(wordOutputOptions);
    }

    public static void toWord(Doc doc, Filter filter) throws PDFNetException {
        DocToWordWithFilter(doc.__GetHandle(), filter.__GetHandle(), 0L);
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(filter);
    }

    public static void toWord(Doc doc, Filter filter, WordOutputOptions wordOutputOptions) throws PDFNetException {
        DocToWordWithFilter(doc.__GetHandle(), filter.__GetHandle(), wordOutputOptions.f1483a.__GetHandle());
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(filter);
        ReachabilityHelper.ensureReachable(wordOutputOptions);
    }

    public static void toExcel(String str, String str2) throws PDFNetException {
        FileToExcel(str, str2, 0L);
    }

    public static void toExcel(String str, String str2, ExcelOutputOptions excelOutputOptions) throws PDFNetException {
        FileToExcel(str, str2, excelOutputOptions.f1466a.__GetHandle());
        ReachabilityHelper.ensureReachable(excelOutputOptions);
    }

    public static void toExcel(Doc doc, String str) throws PDFNetException {
        DocToExcel(doc.__GetHandle(), str, 0L);
        ReachabilityHelper.ensureReachable(doc);
    }

    public static void toExcel(Doc doc, String str, ExcelOutputOptions excelOutputOptions) throws PDFNetException {
        DocToExcel(doc.__GetHandle(), str, excelOutputOptions.f1466a.__GetHandle());
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(excelOutputOptions);
    }

    public static void toExcel(Doc doc, Filter filter) throws PDFNetException {
        DocToExcelWithFilter(doc.__GetHandle(), filter.__GetHandle(), 0L);
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(filter);
    }

    public static void toExcel(Doc doc, Filter filter, ExcelOutputOptions excelOutputOptions) throws PDFNetException {
        DocToExcelWithFilter(doc.__GetHandle(), filter.__GetHandle(), excelOutputOptions.f1466a.__GetHandle());
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(filter);
        ReachabilityHelper.ensureReachable(excelOutputOptions);
    }

    public static void toPowerPoint(String str, String str2) throws PDFNetException {
        FileToPowerPoint(str, str2, 0L);
    }

    public static void toPowerPoint(String str, String str2, PowerPointOutputOptions powerPointOutputOptions) throws PDFNetException {
        FileToPowerPoint(str, str2, powerPointOutputOptions.f1476a.__GetHandle());
        ReachabilityHelper.ensureReachable(powerPointOutputOptions);
    }

    public static void toPowerPoint(Doc doc, String str) throws PDFNetException {
        DocToPowerPoint(doc.__GetHandle(), str, 0L);
        ReachabilityHelper.ensureReachable(doc);
    }

    public static void toPowerPoint(Doc doc, String str, PowerPointOutputOptions powerPointOutputOptions) throws PDFNetException {
        DocToPowerPoint(doc.__GetHandle(), str, powerPointOutputOptions.f1476a.__GetHandle());
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(powerPointOutputOptions);
    }

    public static void toPowerPoint(Doc doc, Filter filter) throws PDFNetException {
        DocToPowerPointWithFilter(doc.__GetHandle(), filter.__GetHandle(), 0L);
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(filter);
    }

    public static void toPowerPoint(Doc doc, Filter filter, PowerPointOutputOptions powerPointOutputOptions) throws PDFNetException {
        DocToPowerPointWithFilter(doc.__GetHandle(), filter.__GetHandle(), powerPointOutputOptions.f1476a.__GetHandle());
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(filter);
        ReachabilityHelper.ensureReachable(powerPointOutputOptions);
    }

    public static void toEpub(String str, String str2) throws PDFNetException {
        FileToEpub(str, str2, 0L, 0L);
    }

    public static void toEpub(String str, String str2, HTMLOutputOptions hTMLOutputOptions) throws PDFNetException {
        FileToEpub(str, str2, hTMLOutputOptions.f1468a.__GetHandle(), 0L);
        ReachabilityHelper.ensureReachable(hTMLOutputOptions);
    }

    public static void toEpub(String str, String str2, EPUBOutputOptions ePUBOutputOptions) throws PDFNetException {
        FileToEpub(str, str2, 0L, ePUBOutputOptions.f1464a.__GetHandle());
        ReachabilityHelper.ensureReachable(ePUBOutputOptions);
    }

    public static void toEpub(String str, String str2, HTMLOutputOptions hTMLOutputOptions, EPUBOutputOptions ePUBOutputOptions) throws PDFNetException {
        FileToEpub(str, str2, hTMLOutputOptions.f1468a.__GetHandle(), ePUBOutputOptions.f1464a.__GetHandle());
        ReachabilityHelper.ensureReachable(hTMLOutputOptions);
        ReachabilityHelper.ensureReachable(ePUBOutputOptions);
    }

    public static void toEpub(Doc doc, String str) throws PDFNetException {
        DocToEpub(doc.__GetHandle(), str, 0L, 0L);
        ReachabilityHelper.ensureReachable(doc);
    }

    public static void toEpub(Doc doc, String str, HTMLOutputOptions hTMLOutputOptions) throws PDFNetException {
        DocToEpub(doc.__GetHandle(), str, hTMLOutputOptions.f1468a.__GetHandle(), 0L);
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(hTMLOutputOptions);
    }

    public static void toEpub(Doc doc, String str, EPUBOutputOptions ePUBOutputOptions) throws PDFNetException {
        DocToEpub(doc.__GetHandle(), str, 0L, ePUBOutputOptions.f1464a.__GetHandle());
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(ePUBOutputOptions);
    }

    public static void toEpub(Doc doc, String str, HTMLOutputOptions hTMLOutputOptions, EPUBOutputOptions ePUBOutputOptions) throws PDFNetException {
        DocToEpub(doc.__GetHandle(), str, hTMLOutputOptions.f1468a.__GetHandle(), ePUBOutputOptions.f1464a.__GetHandle());
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(hTMLOutputOptions);
        ReachabilityHelper.ensureReachable(ePUBOutputOptions);
    }

    public static void toTiff(String str, String str2) throws PDFNetException {
        FileToTiff(str, str2, 0L);
    }

    public static void toTiff(String str, String str2, TiffOutputOptions tiffOutputOptions) throws PDFNetException {
        FileToTiff(str, str2, tiffOutputOptions.f1481a.__GetHandle());
        ReachabilityHelper.ensureReachable(tiffOutputOptions);
    }

    public static void toTiff(Doc doc, String str) throws PDFNetException {
        DocToTiff(doc.__GetHandle(), str, 0L);
        ReachabilityHelper.ensureReachable(doc);
    }

    public static void toTiff(Doc doc, String str, TiffOutputOptions tiffOutputOptions) throws PDFNetException {
        DocToTiff(doc.__GetHandle(), str, tiffOutputOptions.f1481a.__GetHandle());
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(tiffOutputOptions);
    }

    public static void toTiff(String str, Filter filter) throws PDFNetException {
        FileToTiffWithFilter(str, filter.__GetHandle(), 0L);
        ReachabilityHelper.ensureReachable(filter);
    }

    public static void toTiff(String str, Filter filter, TiffOutputOptions tiffOutputOptions) throws PDFNetException {
        FileToTiffWithFilter(str, filter.__GetHandle(), tiffOutputOptions.f1481a.__GetHandle());
        ReachabilityHelper.ensureReachable(filter);
        ReachabilityHelper.ensureReachable(tiffOutputOptions);
    }

    public static void toTiff(Doc doc, Filter filter) throws PDFNetException {
        DocToTiffWithFilter(doc.__GetHandle(), filter.__GetHandle(), 0L);
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(filter);
    }

    public static void toTiff(Doc doc, Filter filter, TiffOutputOptions tiffOutputOptions) throws PDFNetException {
        DocToTiffWithFilter(doc.__GetHandle(), filter.__GetHandle(), tiffOutputOptions.f1481a.__GetHandle());
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(filter);
        ReachabilityHelper.ensureReachable(tiffOutputOptions);
    }

    public static DocumentConversion universalConversion(String str, ConversionOptions conversionOptions) throws PDFNetException {
        DocumentConversion documentConversion = new DocumentConversion(UniversalConversion(str, conversionOptions != null ? conversionOptions.mo1134a() : 0L));
        ReachabilityHelper.ensureReachable(conversionOptions);
        return documentConversion;
    }

    public static DocumentConversion universalConversion(Filter filter, ConversionOptions conversionOptions) throws PDFNetException {
        DocumentConversion documentConversion = new DocumentConversion(UniversalConversionWithFilter(filter.__GetHandle(), conversionOptions != null ? conversionOptions.mo1134a() : 0L));
        ReachabilityHelper.ensureReachable(conversionOptions);
        ReachabilityHelper.ensureReachable(filter);
        return documentConversion;
    }

    public static DocumentConversion appendUniversalConversion(DocumentConversion documentConversion, String str, ConversionOptions conversionOptions) throws PDFNetException {
        DocumentConversion documentConversion2 = new DocumentConversion(AppendUniversalConversion(documentConversion.__GetHandle(), str, conversionOptions != null ? conversionOptions.mo1134a() : 0L));
        ReachabilityHelper.ensureReachable(documentConversion);
        ReachabilityHelper.ensureReachable(conversionOptions);
        return documentConversion2;
    }

    public static DocumentConversion appendUniversalConversion(DocumentConversion documentConversion, Filter filter, ConversionOptions conversionOptions) throws PDFNetException {
        DocumentConversion documentConversion2 = new DocumentConversion(AppendUniversalConversionWithFilter(documentConversion.__GetHandle(), filter.__GetHandle(), conversionOptions != null ? conversionOptions.mo1134a() : 0L));
        ReachabilityHelper.ensureReachable(documentConversion);
        ReachabilityHelper.ensureReachable(conversionOptions);
        ReachabilityHelper.ensureReachable(filter);
        return documentConversion2;
    }

    public static void wordToPdf(Doc doc, String str, WordToPDFOptions wordToPDFOptions) throws PDFNetException {
        WordToPdf(doc.__GetHandle(), str, wordToPDFOptions != null ? wordToPDFOptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(wordToPDFOptions);
    }

    public static DocumentConversion wordToPdfConversion(Doc doc, String str, WordToPDFOptions wordToPDFOptions) throws PDFNetException {
        DocumentConversion documentConversion = new DocumentConversion(WordToPdfConversion(doc.__GetHandle(), str, wordToPDFOptions != null ? wordToPDFOptions.mo1134a() : 0L));
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(wordToPDFOptions);
        return documentConversion;
    }

    public static void wordToPdf(Doc doc, Filter filter, WordToPDFOptions wordToPDFOptions) throws PDFNetException {
        WordToPdfWithFilter(doc.__GetHandle(), filter.__GetHandle(), wordToPDFOptions != null ? wordToPDFOptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(wordToPDFOptions);
        ReachabilityHelper.ensureReachable(filter);
    }

    public static DocumentConversion wordToPdfConversion(Doc doc, Filter filter, WordToPDFOptions wordToPDFOptions) throws PDFNetException {
        DocumentConversion documentConversion = new DocumentConversion(WordToPdfConversionWithFilter(doc.__GetHandle(), filter.__GetHandle(), wordToPDFOptions != null ? wordToPDFOptions.mo1134a() : 0L));
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(wordToPDFOptions);
        ReachabilityHelper.ensureReachable(filter);
        return documentConversion;
    }

    public static void officeToPdf(Doc doc, String str, ConversionOptions conversionOptions) throws PDFNetException {
        OfficeToPdf(doc.__GetHandle(), str, conversionOptions != null ? conversionOptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(conversionOptions);
    }

    public static DocumentConversion streamingPdfConversion(String str, ConversionOptions conversionOptions) throws PDFNetException {
        DocumentConversion documentConversion = new DocumentConversion(UniversalConversion(str, conversionOptions != null ? conversionOptions.mo1134a() : 0L));
        ReachabilityHelper.ensureReachable(conversionOptions);
        return documentConversion;
    }

    public static void officeToPdf(Doc doc, Filter filter, ConversionOptions conversionOptions) throws PDFNetException {
        OfficeToPdfWithFilter(doc.__GetHandle(), filter.__GetHandle(), conversionOptions != null ? conversionOptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(conversionOptions);
        ReachabilityHelper.ensureReachable(filter);
    }

    public static DocumentConversion streamingPdfConversion(Filter filter, ConversionOptions conversionOptions) throws PDFNetException {
        DocumentConversion documentConversion = new DocumentConversion(UniversalConversionWithFilter(filter.__GetHandle(), conversionOptions != null ? conversionOptions.mo1134a() : 0L));
        ReachabilityHelper.ensureReachable(conversionOptions);
        ReachabilityHelper.ensureReachable(filter);
        return documentConversion;
    }

    public static DocumentConversion streamingPdfConversion(Doc doc, String str, ConversionOptions conversionOptions) throws PDFNetException {
        DocumentConversion documentConversion = new DocumentConversion(UniversalConversionWithPdf(doc.__GetHandle(), str, conversionOptions != null ? conversionOptions.mo1134a() : 0L));
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(conversionOptions);
        return documentConversion;
    }

    public static DocumentConversion streamingPdfConversion(Doc doc, Filter filter, ConversionOptions conversionOptions) throws PDFNetException {
        DocumentConversion documentConversion = new DocumentConversion(UniversalConversionWithPdfAndFilter(doc.__GetHandle(), filter.__GetHandle(), conversionOptions != null ? conversionOptions.mo1134a() : 0L));
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(conversionOptions);
        ReachabilityHelper.ensureReachable(filter);
        return documentConversion;
    }

    public static TemplateDocument createOfficeTemplate(String str, ConversionOptions conversionOptions) throws PDFNetException {
        TemplateDocument templateDocument = new TemplateDocument(CreateOfficeTemplateConversion(str, conversionOptions != null ? conversionOptions.mo1134a() : 0L));
        ReachabilityHelper.ensureReachable(conversionOptions);
        return templateDocument;
    }

    public static TemplateDocument createOfficeTemplate(Filter filter, ConversionOptions conversionOptions) throws PDFNetException {
        TemplateDocument templateDocument = new TemplateDocument(CreateOfficeTemplateConversionWithFilter(filter.__GetHandle(), conversionOptions != null ? conversionOptions.mo1134a() : 0L));
        ReachabilityHelper.ensureReachable(conversionOptions);
        ReachabilityHelper.ensureReachable(filter);
        return templateDocument;
    }

    public static BlackBoxContext createBlackBoxContext(String str) throws PDFNetException {
        return new BlackBoxContext(CreateBlackBoxContext(str));
    }

    public static BlackBoxContext createBlackBoxContextConvert(String str, String str2) throws PDFNetException {
        return new BlackBoxContext(CreateBlackBoxContextConvert(str, str2));
    }

    public static Reflow createReflow(Page page, String str) throws PDFNetException {
        Reflow reflow = new Reflow(CreateReflow(page.f1990a, str));
        ReachabilityHelper.ensureReachable(page);
        return reflow;
    }

    public static void toPdf(Doc doc, String str) throws PDFNetException {
        FileToPdf(doc.__GetHandle(), str);
        ReachabilityHelper.ensureReachable(doc);
    }

    public static void fromCAD(Doc doc, String str, CADConvertOptions cADConvertOptions) throws PDFNetException {
        FromCAD(doc.__GetHandle(), str, cADConvertOptions != null ? cADConvertOptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(cADConvertOptions);
    }

    public static void fromDICOM(Doc doc, String str, AdvancedImagingConvertOptions advancedImagingConvertOptions) throws PDFNetException {
        FromDICOM(doc.__GetHandle(), str, advancedImagingConvertOptions != null ? advancedImagingConvertOptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(advancedImagingConvertOptions);
    }

    public static void fromSVG(Doc doc, String str, SVGConvertOptions sVGConvertOptions) throws PDFNetException {
        FromSVG(doc.__GetHandle(), str, sVGConvertOptions != null ? sVGConvertOptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(sVGConvertOptions);
    }

    public static void fromTiff(Doc doc, Filter filter) throws PDFNetException {
        FromTiff(doc.__GetHandle(), filter.__GetHandle());
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(filter);
    }

    public static boolean requiresPrinter(String str) throws PDFNetException {
        return RequiresPrinter(str);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m1138a(Obj obj, int i) throws PDFNetException {
        if (i == 0) {
            obj.putName("FLATTEN_THRESHOLD", "VERY_STRICT");
            return;
        }
        if (i == 1) {
            obj.putName("FLATTEN_THRESHOLD", "STRICT");
            return;
        }
        if (i == 2) {
            obj.putName("FLATTEN_THRESHOLD", "DEFAULT");
        } else if (i == 3) {
            obj.putName("FLATTEN_THRESHOLD", "KEEP_MOST");
        } else {
            if (i != 4) {
                return;
            }
            obj.putName("FLATTEN_THRESHOLD", "KEEP_ALL");
        }
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ void m1139b(Obj obj, int i) throws PDFNetException {
        if (i == 0) {
            obj.putName("FLATTEN_CONTENT", "OFF");
            return;
        }
        if (i == 1) {
            obj.putName("FLATTEN_CONTENT", "SIMPLE");
        } else if (i == 2) {
            obj.putName("FLATTEN_CONTENT", "FAST");
        } else {
            if (i != 3) {
                return;
            }
            obj.putName("FLATTEN_CONTENT", "HIGH_QUALITY");
        }
    }
}
