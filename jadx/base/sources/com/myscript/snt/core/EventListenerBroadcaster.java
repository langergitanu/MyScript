package com.myscript.snt.core;

import com.myscript.atk.core.Json;
import com.myscript.atk.core.SWIGVectorTagId;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class EventListenerBroadcaster {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public EventListenerBroadcaster(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(EventListenerBroadcaster eventListenerBroadcaster) {
        if (eventListenerBroadcaster == null) {
            return 0L;
        }
        return eventListenerBroadcaster.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_EventListenerBroadcaster(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void itemAdded(String str, long j) {
        NeboEngineJNI.EventListenerBroadcaster_itemAdded(this.swigCPtr, this, str.getBytes(), j);
    }

    public void itemChanged(String str, long j) {
        NeboEngineJNI.EventListenerBroadcaster_itemChanged(this.swigCPtr, this, str.getBytes(), j);
    }

    public void itemRemoved(String str, long j) {
        NeboEngineJNI.EventListenerBroadcaster_itemRemoved(this.swigCPtr, this, str.getBytes(), j);
    }

    public void selectionChanged() {
        NeboEngineJNI.EventListenerBroadcaster_selectionChanged(this.swigCPtr, this);
    }

    public void flush() {
        NeboEngineJNI.EventListenerBroadcaster_flush(this.swigCPtr, this);
    }

    public void gestureTriggered(String str, SWIGTYPE_p_myscript__gesture__GestureIntent sWIGTYPE_p_myscript__gesture__GestureIntent, SWIGTYPE_p_myscript__gesture__GestureType sWIGTYPE_p_myscript__gesture__GestureType, SWIGTYPE_p_myscript__gesture__GestureGeometry sWIGTYPE_p_myscript__gesture__GestureGeometry, SWIGTYPE_p_atk__core__Tool__Kind sWIGTYPE_p_atk__core__Tool__Kind, String str2) {
        NeboEngineJNI.EventListenerBroadcaster_gestureTriggered(this.swigCPtr, this, str.getBytes(), SWIGTYPE_p_myscript__gesture__GestureIntent.getCPtr(sWIGTYPE_p_myscript__gesture__GestureIntent), SWIGTYPE_p_myscript__gesture__GestureType.getCPtr(sWIGTYPE_p_myscript__gesture__GestureType), SWIGTYPE_p_myscript__gesture__GestureGeometry.getCPtr(sWIGTYPE_p_myscript__gesture__GestureGeometry), SWIGTYPE_p_atk__core__Tool__Kind.getCPtr(sWIGTYPE_p_atk__core__Tool__Kind), str2.getBytes());
    }

    public void gestureCanceled(String str, SWIGTYPE_p_myscript__gesture__GestureIntent sWIGTYPE_p_myscript__gesture__GestureIntent, SWIGTYPE_p_myscript__gesture__GestureType sWIGTYPE_p_myscript__gesture__GestureType, SWIGTYPE_p_myscript__gesture__GestureGeometry sWIGTYPE_p_myscript__gesture__GestureGeometry, String str2) {
        NeboEngineJNI.EventListenerBroadcaster_gestureCanceled(this.swigCPtr, this, str.getBytes(), SWIGTYPE_p_myscript__gesture__GestureIntent.getCPtr(sWIGTYPE_p_myscript__gesture__GestureIntent), SWIGTYPE_p_myscript__gesture__GestureType.getCPtr(sWIGTYPE_p_myscript__gesture__GestureType), SWIGTYPE_p_myscript__gesture__GestureGeometry.getCPtr(sWIGTYPE_p_myscript__gesture__GestureGeometry), str2.getBytes());
    }

    public void onHold(String str, SWIGTYPE_p_atk__core__OnHoldEvent sWIGTYPE_p_atk__core__OnHoldEvent, SWIGTYPE_p_atk__core__Tool__Kind sWIGTYPE_p_atk__core__Tool__Kind, int i, Json json, boolean z) {
        NeboEngineJNI.EventListenerBroadcaster_onHold(this.swigCPtr, this, str.getBytes(), SWIGTYPE_p_atk__core__OnHoldEvent.getCPtr(sWIGTYPE_p_atk__core__OnHoldEvent), SWIGTYPE_p_atk__core__Tool__Kind.getCPtr(sWIGTYPE_p_atk__core__Tool__Kind), i, Json.getCPtr(json), json, z);
    }

    public void holdItemAdded(String str, List<Long> list) {
        SWIGVectorTagId sWIGVectorTagId = new SWIGVectorTagId(list);
        NeboEngineJNI.EventListenerBroadcaster_holdItemAdded(this.swigCPtr, this, str.getBytes(), SWIGVectorTagId.getCPtr(sWIGVectorTagId), sWIGVectorTagId);
    }

    public EventListenerBroadcaster() {
        this(NeboEngineJNI.new_EventListenerBroadcaster(), true);
    }
}
