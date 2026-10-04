package com.myscript.nebo.freemium;

import com.myscript.nebo.analytics.firebase.PremiumModalOrigin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FreemiumLimitationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m1599d2 = {"getOriginForAnalytics", "", "Lcom/myscript/nebo/freemium/FreemiumLimitationTrigger;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FreemiumLimitationViewModelKt {

    /* JADX INFO: compiled from: FreemiumLimitationViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FreemiumLimitationTrigger.values().length];
            try {
                iArr[FreemiumLimitationTrigger.TRIGGER_CONVERT_BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FreemiumLimitationTrigger.TRIGGER_CONVERT_ALL_BUTTON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FreemiumLimitationTrigger.TRIGGER_CONVERSION_PREVIEW_TOGGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FreemiumLimitationTrigger.TRIGGER_AI_TAP_ON_BUTTON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FreemiumLimitationTrigger.TRIGGER_AI_BUTTON_SHOW_HIDE_SETTING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FreemiumLimitationTrigger.TRIGGER_AI_EDIT_MENU_ENTRY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FreemiumLimitationTrigger.TRIGGER_GRID_CREATE_BUTTON.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[FreemiumLimitationTrigger.TRIGGER_GRID_VIEW_DUPLICATE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[FreemiumLimitationTrigger.TRIGGER_OPENING_AN_EXTERNAL_PDF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[FreemiumLimitationTrigger.TRIGGER_ADD_A_PAGE_FROM_LONG_NOTE_BANNER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[FreemiumLimitationTrigger.TRIGGER_IMPORT_AS_PDF_BUTTON.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[FreemiumLimitationTrigger.TRIGGER_SHAPE_ON_HOLD_GESTURE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[FreemiumLimitationTrigger.TRIGGER_SCRATCH_GESTURE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[FreemiumLimitationTrigger.TRIGGER_SYNC_SETTING_INTERACTION.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[FreemiumLimitationTrigger.TRIGGER_PDF_INSERT_BLANK_PAGE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String getOriginForAnalytics(FreemiumLimitationTrigger freemiumLimitationTrigger) {
        PremiumModalOrigin premiumModalOrigin;
        Intrinsics.checkNotNullParameter(freemiumLimitationTrigger, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[freemiumLimitationTrigger.ordinal()]) {
            case 1:
                premiumModalOrigin = PremiumModalOrigin.Convert;
                break;
            case 2:
                premiumModalOrigin = PremiumModalOrigin.Convert;
                break;
            case 3:
                premiumModalOrigin = PremiumModalOrigin.Convert;
                break;
            case 4:
                premiumModalOrigin = PremiumModalOrigin.AICanvas;
                break;
            case 5:
                premiumModalOrigin = PremiumModalOrigin.AICanvas;
                break;
            case 6:
                premiumModalOrigin = PremiumModalOrigin.AICanvas;
                break;
            case 7:
                premiumModalOrigin = PremiumModalOrigin.CreateDocumentBoard;
                break;
            case 8:
                premiumModalOrigin = PremiumModalOrigin.DuplicateNote;
                break;
            case 9:
                premiumModalOrigin = PremiumModalOrigin.ImportPDF;
                break;
            case 10:
                premiumModalOrigin = PremiumModalOrigin.LongPageBanner;
                break;
            case 11:
                premiumModalOrigin = PremiumModalOrigin.ImportPDF;
                break;
            case 12:
                premiumModalOrigin = PremiumModalOrigin.Shape;
                break;
            case 13:
                premiumModalOrigin = PremiumModalOrigin.Scratch;
                break;
            case 14:
                premiumModalOrigin = PremiumModalOrigin.Sync;
                break;
            case 15:
                premiumModalOrigin = PremiumModalOrigin.AddPDFPage;
                break;
            default:
                premiumModalOrigin = PremiumModalOrigin.None;
                break;
        }
        return premiumModalOrigin.getOrigin();
    }
}
