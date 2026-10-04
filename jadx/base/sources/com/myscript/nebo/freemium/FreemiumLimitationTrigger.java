package com.myscript.nebo.freemium;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: FreemiumLimitationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/freemium/FreemiumLimitationTrigger;", "", "<init>", "(Ljava/lang/String;I)V", "TRIGGER_NONE", "TRIGGER_EDIT_MENU_LASSO", "TRIGGER_CONVERT_BLOCK", "TRIGGER_CONVERT_ALL_BUTTON", "TRIGGER_CONVERSION_PREVIEW_TOGGLE", "TRIGGER_AI_TAP_ON_BUTTON", "TRIGGER_AI_BUTTON_SHOW_HIDE_SETTING", "TRIGGER_AI_EDIT_MENU_ENTRY", "TRIGGER_GRID_CREATE_BUTTON", "TRIGGER_GRID_VIEW_DUPLICATE", "TRIGGER_OPENING_AN_EXTERNAL_PDF", "TRIGGER_ADD_A_PAGE_FROM_LONG_NOTE_BANNER", "TRIGGER_IMPORT_AS_PDF_BUTTON", "TRIGGER_SHAPE_ON_HOLD_GESTURE", "TRIGGER_SCRATCH_GESTURE", "TRIGGER_SYNC_SETTING_INTERACTION", "TRIGGER_PDF_INSERT_BLANK_PAGE", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FreemiumLimitationTrigger {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FreemiumLimitationTrigger[] $VALUES;
    public static final FreemiumLimitationTrigger TRIGGER_NONE = new FreemiumLimitationTrigger("TRIGGER_NONE", 0);
    public static final FreemiumLimitationTrigger TRIGGER_EDIT_MENU_LASSO = new FreemiumLimitationTrigger("TRIGGER_EDIT_MENU_LASSO", 1);
    public static final FreemiumLimitationTrigger TRIGGER_CONVERT_BLOCK = new FreemiumLimitationTrigger("TRIGGER_CONVERT_BLOCK", 2);
    public static final FreemiumLimitationTrigger TRIGGER_CONVERT_ALL_BUTTON = new FreemiumLimitationTrigger("TRIGGER_CONVERT_ALL_BUTTON", 3);
    public static final FreemiumLimitationTrigger TRIGGER_CONVERSION_PREVIEW_TOGGLE = new FreemiumLimitationTrigger("TRIGGER_CONVERSION_PREVIEW_TOGGLE", 4);
    public static final FreemiumLimitationTrigger TRIGGER_AI_TAP_ON_BUTTON = new FreemiumLimitationTrigger("TRIGGER_AI_TAP_ON_BUTTON", 5);
    public static final FreemiumLimitationTrigger TRIGGER_AI_BUTTON_SHOW_HIDE_SETTING = new FreemiumLimitationTrigger("TRIGGER_AI_BUTTON_SHOW_HIDE_SETTING", 6);
    public static final FreemiumLimitationTrigger TRIGGER_AI_EDIT_MENU_ENTRY = new FreemiumLimitationTrigger("TRIGGER_AI_EDIT_MENU_ENTRY", 7);
    public static final FreemiumLimitationTrigger TRIGGER_GRID_CREATE_BUTTON = new FreemiumLimitationTrigger("TRIGGER_GRID_CREATE_BUTTON", 8);
    public static final FreemiumLimitationTrigger TRIGGER_GRID_VIEW_DUPLICATE = new FreemiumLimitationTrigger("TRIGGER_GRID_VIEW_DUPLICATE", 9);
    public static final FreemiumLimitationTrigger TRIGGER_OPENING_AN_EXTERNAL_PDF = new FreemiumLimitationTrigger("TRIGGER_OPENING_AN_EXTERNAL_PDF", 10);
    public static final FreemiumLimitationTrigger TRIGGER_ADD_A_PAGE_FROM_LONG_NOTE_BANNER = new FreemiumLimitationTrigger("TRIGGER_ADD_A_PAGE_FROM_LONG_NOTE_BANNER", 11);
    public static final FreemiumLimitationTrigger TRIGGER_IMPORT_AS_PDF_BUTTON = new FreemiumLimitationTrigger("TRIGGER_IMPORT_AS_PDF_BUTTON", 12);
    public static final FreemiumLimitationTrigger TRIGGER_SHAPE_ON_HOLD_GESTURE = new FreemiumLimitationTrigger("TRIGGER_SHAPE_ON_HOLD_GESTURE", 13);
    public static final FreemiumLimitationTrigger TRIGGER_SCRATCH_GESTURE = new FreemiumLimitationTrigger("TRIGGER_SCRATCH_GESTURE", 14);
    public static final FreemiumLimitationTrigger TRIGGER_SYNC_SETTING_INTERACTION = new FreemiumLimitationTrigger("TRIGGER_SYNC_SETTING_INTERACTION", 15);
    public static final FreemiumLimitationTrigger TRIGGER_PDF_INSERT_BLANK_PAGE = new FreemiumLimitationTrigger("TRIGGER_PDF_INSERT_BLANK_PAGE", 16);

    private static final /* synthetic */ FreemiumLimitationTrigger[] $values() {
        return new FreemiumLimitationTrigger[]{TRIGGER_NONE, TRIGGER_EDIT_MENU_LASSO, TRIGGER_CONVERT_BLOCK, TRIGGER_CONVERT_ALL_BUTTON, TRIGGER_CONVERSION_PREVIEW_TOGGLE, TRIGGER_AI_TAP_ON_BUTTON, TRIGGER_AI_BUTTON_SHOW_HIDE_SETTING, TRIGGER_AI_EDIT_MENU_ENTRY, TRIGGER_GRID_CREATE_BUTTON, TRIGGER_GRID_VIEW_DUPLICATE, TRIGGER_OPENING_AN_EXTERNAL_PDF, TRIGGER_ADD_A_PAGE_FROM_LONG_NOTE_BANNER, TRIGGER_IMPORT_AS_PDF_BUTTON, TRIGGER_SHAPE_ON_HOLD_GESTURE, TRIGGER_SCRATCH_GESTURE, TRIGGER_SYNC_SETTING_INTERACTION, TRIGGER_PDF_INSERT_BLANK_PAGE};
    }

    public static EnumEntries<FreemiumLimitationTrigger> getEntries() {
        return $ENTRIES;
    }

    public static FreemiumLimitationTrigger valueOf(String str) {
        return (FreemiumLimitationTrigger) Enum.valueOf(FreemiumLimitationTrigger.class, str);
    }

    public static FreemiumLimitationTrigger[] values() {
        return (FreemiumLimitationTrigger[]) $VALUES.clone();
    }

    private FreemiumLimitationTrigger(String str, int i) {
    }

    static {
        FreemiumLimitationTrigger[] freemiumLimitationTriggerArr$values = $values();
        $VALUES = freemiumLimitationTriggerArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(freemiumLimitationTriggerArr$values);
    }
}
