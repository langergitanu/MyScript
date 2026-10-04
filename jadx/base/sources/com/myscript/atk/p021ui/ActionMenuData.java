package com.myscript.atk.p021ui;

import com.myscript.atk.core.Point;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class ActionMenuData {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ActionMenuData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ActionMenuData actionMenuData) {
        if (actionMenuData == null) {
            return 0L;
        }
        return actionMenuData.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKSharedUIJNI.delete_ActionMenuData(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setActions(SWIGActionMenuEntryList sWIGActionMenuEntryList) {
        SWIGActionMenuEntryList sWIGActionMenuEntryList2 = new SWIGActionMenuEntryList(sWIGActionMenuEntryList);
        ATKSharedUIJNI.ActionMenuData_actions_set(this.swigCPtr, this, SWIGActionMenuEntryList.getCPtr(sWIGActionMenuEntryList2), sWIGActionMenuEntryList2);
    }

    public SWIGActionMenuEntryList getActions() {
        long jActionMenuData_actions_get = ATKSharedUIJNI.ActionMenuData_actions_get(this.swigCPtr, this);
        if (jActionMenuData_actions_get == 0) {
            return null;
        }
        return new SWIGActionMenuEntryList(jActionMenuData_actions_get, false);
    }

    public void setInputPoint(Point point) {
        ATKSharedUIJNI.ActionMenuData_inputPoint_set(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public Point getInputPoint() {
        long jActionMenuData_inputPoint_get = ATKSharedUIJNI.ActionMenuData_inputPoint_get(this.swigCPtr, this);
        if (jActionMenuData_inputPoint_get == 0) {
            return null;
        }
        return new Point(jActionMenuData_inputPoint_get, false);
    }

    public void setMenuPoint(Point point) {
        ATKSharedUIJNI.ActionMenuData_menuPoint_set(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public Point getMenuPoint() {
        long jActionMenuData_menuPoint_get = ATKSharedUIJNI.ActionMenuData_menuPoint_get(this.swigCPtr, this);
        if (jActionMenuData_menuPoint_get == 0) {
            return null;
        }
        return new Point(jActionMenuData_menuPoint_get, false);
    }

    public void setContentType(String str) {
        ATKSharedUIJNI.ActionMenuData_contentType_set(this.swigCPtr, this, str.getBytes());
    }

    public String getContentType() {
        return new String(ATKSharedUIJNI.ActionMenuData_contentType_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setNature(MenuNature menuNature) {
        ATKSharedUIJNI.ActionMenuData_nature_set(this.swigCPtr, this, menuNature.swigValue());
    }

    public MenuNature getNature() {
        return MenuNature.swigToEnum(ATKSharedUIJNI.ActionMenuData_nature_get(this.swigCPtr, this));
    }

    public ActionMenuData() {
        this(ATKSharedUIJNI.new_ActionMenuData(), true);
    }
}
