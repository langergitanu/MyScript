package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class Logger {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Logger(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Logger logger) {
        if (logger == null) {
            return 0L;
        }
        return logger.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Logger(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void println(Level level, Category category, String str) {
        print(level, category, str + "\n");
    }

    public static final class Prefix {
        public static final int CALLSTACK = 14;
        public static final int FILEPOS = 16;
        public static final int INDENT = 8;
        public static final int LEAN = 1;
        public static final int LEVEL = 1;
        public static final int MINIMAL = 0;
        public static final int NAMESPACE = 32;
        public static final int STANDARD = 49;
        public static final int THREAD = 2;
        public static final int TIMESTAMP = 4;

        private Prefix() {
        }
    }

    public Logger(Level level, C6023x31232b1e c6023x31232b1e, SWIGTYPE_p_std__ostream sWIGTYPE_p_std__ostream) {
        this(ATKCoreJNI.new_Logger__SWIG_0(level.swigValue(), C6023x31232b1e.getCPtr(c6023x31232b1e), SWIGTYPE_p_std__ostream.getCPtr(sWIGTYPE_p_std__ostream)), true);
    }

    public Logger(Level level, C6023x31232b1e c6023x31232b1e) {
        this(ATKCoreJNI.new_Logger__SWIG_1(level.swigValue(), C6023x31232b1e.getCPtr(c6023x31232b1e)), true);
    }

    public void setLevel(Level level) {
        ATKCoreJNI.Logger_setLevel(this.swigCPtr, this, level.swigValue());
    }

    public Level get_level() {
        return Level.swigToEnum(ATKCoreJNI.Logger_get_level(this.swigCPtr, this));
    }

    public C6023x31232b1e get_category() {
        return new C6023x31232b1e(ATKCoreJNI.Logger_get_category(this.swigCPtr, this), true);
    }

    public void prefix_enable(C6024xf2844cf2 c6024xf2844cf2) {
        ATKCoreJNI.Logger_prefix_enable(this.swigCPtr, this, C6024xf2844cf2.getCPtr(c6024xf2844cf2));
    }

    public void prefix_disable(C6024xf2844cf2 c6024xf2844cf2) {
        ATKCoreJNI.Logger_prefix_disable(this.swigCPtr, this, C6024xf2844cf2.getCPtr(c6024xf2844cf2));
    }

    public void set_prefix(C6024xf2844cf2 c6024xf2844cf2) {
        ATKCoreJNI.Logger_set_prefix(this.swigCPtr, this, C6024xf2844cf2.getCPtr(c6024xf2844cf2));
    }

    public C6024xf2844cf2 prefix_filter() {
        return new C6024xf2844cf2(ATKCoreJNI.Logger_prefix_filter(this.swigCPtr, this), true);
    }

    public int indent(int i) {
        return ATKCoreJNI.Logger_indent__SWIG_0(this.swigCPtr, this, i);
    }

    public int indent() {
        return ATKCoreJNI.Logger_indent__SWIG_1(this.swigCPtr, this);
    }

    public long timestamp() {
        return ATKCoreJNI.Logger_timestamp(this.swigCPtr, this);
    }

    public static Logger getLogger() {
        return new Logger(ATKCoreJNI.Logger_getLogger(), false);
    }

    public void print(Level level, Category category, String str) {
        ATKCoreJNI.Logger_print(this.swigCPtr, this, level.swigValue(), category.swigValue(), str.getBytes());
    }

    public enum Level {
        None(0),
        Error(1),
        Info(2),
        Debug(3);

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static Level swigToEnum(int i) {
            Level[] levelArr = (Level[]) Level.class.getEnumConstants();
            if (i < levelArr.length && i >= 0) {
                Level level = levelArr[i];
                if (level.swigValue == i) {
                    return level;
                }
            }
            for (Level level2 : levelArr) {
                if (level2.swigValue == i) {
                    return level2;
                }
            }
            throw new IllegalArgumentException("No enum " + Level.class + " with value " + i);
        }

        Level() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        Level(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        Level(Level level) {
            int i = level.swigValue;
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        private static class SwigNext {
            private static int next;

            private SwigNext() {
            }
        }
    }

    public enum Category {
        NONE(0),
        COMMON(1),
        UNITTEST(2),
        RECO(4),
        TEXT(8),
        GEOM(16),
        DIAGRAM(32),
        SNT2CORE(64),
        DMS(128),
        TUTORIAL(256),
        CORE(512),
        MATH(1024),
        SHARED_UI(2048),
        ALL(4095);

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static Category swigToEnum(int i) {
            Category[] categoryArr = (Category[]) Category.class.getEnumConstants();
            if (i < categoryArr.length && i >= 0) {
                Category category = categoryArr[i];
                if (category.swigValue == i) {
                    return category;
                }
            }
            for (Category category2 : categoryArr) {
                if (category2.swigValue == i) {
                    return category2;
                }
            }
            throw new IllegalArgumentException("No enum " + Category.class + " with value " + i);
        }

        Category() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        Category(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        Category(Category category) {
            int i = category.swigValue;
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
