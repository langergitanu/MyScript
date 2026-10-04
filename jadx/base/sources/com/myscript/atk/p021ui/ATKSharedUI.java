package com.myscript.atk.p021ui;

import com.myscript.atk.core.SWIGVectorString;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class ATKSharedUI {
    ATKSharedUI() {
    }

    public static List<String> getActionMenuEntryLabels() {
        long jActionMenuEntryLabels_get = ATKSharedUIJNI.ActionMenuEntryLabels_get();
        if (jActionMenuEntryLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jActionMenuEntryLabels_get, false);
    }

    public static List<String> getMenuTypeLabels() {
        long jMenuTypeLabels_get = ATKSharedUIJNI.MenuTypeLabels_get();
        if (jMenuTypeLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jMenuTypeLabels_get, false);
    }

    public static List<String> getMenuNatureLabels() {
        long jMenuNatureLabels_get = ATKSharedUIJNI.MenuNatureLabels_get();
        if (jMenuNatureLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jMenuNatureLabels_get, false);
    }

    public static ActionMenuData getEMPTY_ACTION_MENU() {
        long jEMPTY_ACTION_MENU_get = ATKSharedUIJNI.EMPTY_ACTION_MENU_get();
        if (jEMPTY_ACTION_MENU_get == 0) {
            return null;
        }
        return new ActionMenuData(jEMPTY_ACTION_MENU_get, false);
    }
}
