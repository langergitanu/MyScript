package com.myscript.nebo.export;

import com.myscript.atk.core.MimeType;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.clipboard.ClipboardContentProvider;
import com.myscript.nebo.common.C6183R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExportHelper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u001a\n\u0010\u000b\u001a\u00020\u0004*\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0015\u0010\u0003\u001a\u00020\u0001*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, m1599d2 = {"STREAM_MIME_TYPE", "", "ALL_TEXT_MIME_TYPE", "contentType", "Lcom/myscript/atk/core/MimeType;", "getContentType", "(Lcom/myscript/atk/core/MimeType;)Ljava/lang/String;", "stringRes", "", "getStringRes", "(Lcom/myscript/atk/core/MimeType;)I", "toMimeType", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ExportHelperKt {
    private static final String ALL_TEXT_MIME_TYPE = "text/*";
    private static final String STREAM_MIME_TYPE = "application/binary";

    /* JADX INFO: compiled from: ExportHelper.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MimeType.values().length];
            try {
                iArr[MimeType.HTML.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MimeType.DOCX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MimeType.PPTX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MimeType.TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MimeType.PDF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MimeType.PNG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MimeType.SVG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MimeType.NEBO.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String getContentType(MimeType mimeType) {
        Intrinsics.checkNotNullParameter(mimeType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[mimeType.ordinal()]) {
            case 1:
                return ClipboardContentProvider.HTML_MIMETYPE;
            case 2:
                return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
            case 3:
                return "application/vnd.openxmlformats-officedocument.presentationml.presentation";
            case 4:
                return "text/plain";
            case 5:
                return "application/pdf";
            case 6:
                return "image/png";
            case 7:
                return "image/svg+xml";
            case 8:
                return STREAM_MIME_TYPE;
            default:
                return "application/octet-stream";
        }
    }

    public static final int getStringRes(MimeType mimeType) {
        Intrinsics.checkNotNullParameter(mimeType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[mimeType.ordinal()]) {
            case 2:
                return C6183R.string.export_to_word;
            case 3:
                return C6079R.string.export_to_powerpoint;
            case 4:
                return C6183R.string.share_as_text;
            case 5:
                return C6183R.string.export_to_pdf;
            case 6:
                return C6183R.string.export_to_png;
            case 7:
                return C6183R.string.export_to_svg;
            case 8:
                return C6183R.string.export_to_nebo;
            default:
                throw new IllegalStateException(("Unsupported mimeType " + mimeType.name()).toString());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final MimeType toMimeType(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        switch (str.hashCode()) {
            case -1248334925:
                if (str.equals("application/pdf")) {
                    return MimeType.PDF;
                }
                break;
            case -1082243251:
                if (str.equals(ClipboardContentProvider.HTML_MIMETYPE)) {
                    return MimeType.HTML;
                }
                break;
            case -1073633483:
                if (str.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation")) {
                    return MimeType.PPTX;
                }
                break;
            case -1050893613:
                if (str.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
                    return MimeType.DOCX;
                }
                break;
            case -879258763:
                if (str.equals("image/png")) {
                    return MimeType.PNG;
                }
                break;
            case -227171396:
                if (str.equals("image/svg+xml")) {
                    return MimeType.SVG;
                }
                break;
            case 580210080:
                if (str.equals(STREAM_MIME_TYPE)) {
                    return MimeType.NEBO;
                }
                break;
            case 817335912:
                if (str.equals("text/plain")) {
                    return MimeType.TEXT;
                }
                break;
        }
        throw new IllegalStateException(("Unsupported mimeType " + str).toString());
    }
}
