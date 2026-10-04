package com.myscript.atk.p021ui;

/* JADX INFO: loaded from: classes4.dex */
public enum PrompterWordState {
    New,
    Update,
    Delete,
    None;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static PrompterWordState swigToEnum(int i) {
        PrompterWordState[] prompterWordStateArr = (PrompterWordState[]) PrompterWordState.class.getEnumConstants();
        if (i < prompterWordStateArr.length && i >= 0) {
            PrompterWordState prompterWordState = prompterWordStateArr[i];
            if (prompterWordState.swigValue == i) {
                return prompterWordState;
            }
        }
        for (PrompterWordState prompterWordState2 : prompterWordStateArr) {
            if (prompterWordState2.swigValue == i) {
                return prompterWordState2;
            }
        }
        throw new IllegalArgumentException("No enum " + PrompterWordState.class + " with value " + i);
    }

    PrompterWordState() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    PrompterWordState(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    PrompterWordState(PrompterWordState prompterWordState) {
        int i = prompterWordState.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
