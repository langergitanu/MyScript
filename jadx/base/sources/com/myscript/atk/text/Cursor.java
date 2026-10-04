package com.myscript.atk.text;

import com.myscript.atk.core.Point;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class Cursor {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Cursor(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Cursor cursor) {
        if (cursor == null) {
            return 0L;
        }
        return cursor.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKTextJNI.delete_Cursor(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public Cursor() {
        this(ATKTextJNI.new_Cursor(), true);
    }

    public State state() {
        return State.swigToEnum(ATKTextJNI.Cursor_state(this.swigCPtr, this));
    }

    public String boxId() {
        return new String(ATKTextJNI.Cursor_boxId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public int intervalValue() {
        return ATKTextJNI.Cursor_intervalValue(this.swigCPtr, this);
    }

    public int line() {
        return ATKTextJNI.Cursor_line(this.swigCPtr, this);
    }

    public int column() {
        return ATKTextJNI.Cursor_column(this.swigCPtr, this);
    }

    public Point position() {
        return new Point(ATKTextJNI.Cursor_position(this.swigCPtr, this), true);
    }

    public float size() {
        return ATKTextJNI.Cursor_size(this.swigCPtr, this);
    }

    public String childPageCursorPageId() {
        return new String(ATKTextJNI.Cursor_childPageCursorPageId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public long childPageCursorIndex() {
        return ATKTextJNI.Cursor_childPageCursorIndex(this.swigCPtr, this);
    }

    public ChildPageCursor childPageCursor() {
        return new ChildPageCursor(ATKTextJNI.Cursor_childPageCursor(this.swigCPtr, this), false);
    }

    public void invalidate() {
        ATKTextJNI.Cursor_invalidate(this.swigCPtr, this);
    }

    public void invalidatePosition() {
        ATKTextJNI.Cursor_invalidatePosition(this.swigCPtr, this);
    }

    public void setBox(String str, int i) {
        ATKTextJNI.Cursor_setBox(this.swigCPtr, this, str.getBytes(), i);
    }

    public void setIntervalValue(int i) {
        ATKTextJNI.Cursor_setIntervalValue(this.swigCPtr, this, i);
    }

    public void addToIntervalValue(int i) {
        ATKTextJNI.Cursor_addToIntervalValue(this.swigCPtr, this, i);
    }

    public void setGridPosition(int i, int i2) {
        ATKTextJNI.Cursor_setGridPosition(this.swigCPtr, this, i, i2);
    }

    public void setPosition(Point point) {
        ATKTextJNI.Cursor_setPosition__SWIG_0(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public void setPosition(float f, float f2) {
        ATKTextJNI.Cursor_setPosition__SWIG_1(this.swigCPtr, this, f, f2);
    }

    public void setSize(float f) {
        ATKTextJNI.Cursor_setSize(this.swigCPtr, this, f);
    }

    public void setChildPageCursor(ChildPageCursor childPageCursor) {
        ATKTextJNI.Cursor_setChildPageCursor__SWIG_0(this.swigCPtr, this, ChildPageCursor.getCPtr(childPageCursor), childPageCursor);
    }

    public void setChildPageCursor(String str, long j) {
        ATKTextJNI.Cursor_setChildPageCursor__SWIG_1(this.swigCPtr, this, str.getBytes(), j);
    }

    public enum State {
        UNSET,
        SET_OUT_BLOCK,
        SET_BLOCK,
        SET_PDF;

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static State swigToEnum(int i) {
            State[] stateArr = (State[]) State.class.getEnumConstants();
            if (i < stateArr.length && i >= 0) {
                State state = stateArr[i];
                if (state.swigValue == i) {
                    return state;
                }
            }
            for (State state2 : stateArr) {
                if (state2.swigValue == i) {
                    return state2;
                }
            }
            throw new IllegalArgumentException("No enum " + State.class + " with value " + i);
        }

        State() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        State(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        State(State state) {
            int i = state.swigValue;
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        private static class SwigNext {
            private static int next;

            private SwigNext() {
            }
        }
    }
}
