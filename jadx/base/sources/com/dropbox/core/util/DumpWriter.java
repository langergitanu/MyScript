package com.dropbox.core.util;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import aws.sdk.kotlin.runtime.config.profile.Literals;
import com.dropbox.core.json.JsonDateReader;
import com.revenuecat.purchases.common.Constants;
import com.survicate.surveys.TextRecallingManager;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DumpWriter {
    /* JADX INFO: renamed from: f */
    public abstract DumpWriter mo519f(String str);

    public abstract DumpWriter listEnd();

    public abstract DumpWriter listStart();

    public abstract DumpWriter recordEnd();

    public abstract DumpWriter recordStart(String str);

    public abstract DumpWriter verbatim(String str);

    public static final class Multiline extends DumpWriter {
        private final StringBuilder buf;
        private int currentIndent;
        private final int indentAmount;

        /* JADX INFO: renamed from: nl */
        boolean f658nl;

        public Multiline(StringBuilder sb, int i, int i2, boolean z) {
            this.f658nl = true;
            if (sb == null) {
                throw new IllegalArgumentException("'buf' must not be null");
            }
            if (i < 0) {
                throw new IllegalArgumentException("'indentAmount' must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("'currentIndent' must be non-negative");
            }
            this.buf = sb;
            this.indentAmount = i;
            this.currentIndent = i2;
            this.f658nl = z;
        }

        public Multiline(StringBuilder sb, int i, boolean z) {
            this(sb, i, 0, z);
        }

        private void prefix() {
            if (this.f658nl) {
                int i = this.currentIndent;
                for (int i2 = 0; i2 < i; i2++) {
                    this.buf.append(TokenParser.f2383SP);
                }
            }
        }

        private void indentMore() {
            this.currentIndent += this.indentAmount;
        }

        private void indentLess() {
            int i = this.indentAmount;
            int i2 = this.currentIndent;
            if (i > i2) {
                throw new IllegalStateException("indent went negative");
            }
            this.currentIndent = i2 - i;
        }

        @Override // com.dropbox.core.util.DumpWriter
        public DumpWriter recordStart(String str) {
            prefix();
            if (str != null) {
                this.buf.append(str).append(" ");
            }
            this.buf.append("{\n");
            this.f658nl = true;
            indentMore();
            return this;
        }

        @Override // com.dropbox.core.util.DumpWriter
        public DumpWriter recordEnd() {
            if (!this.f658nl) {
                throw new AssertionError("called recordEnd() in a bad state");
            }
            indentLess();
            prefix();
            this.buf.append("}\n");
            this.f658nl = true;
            return this;
        }

        @Override // com.dropbox.core.util.DumpWriter
        /* JADX INFO: renamed from: f */
        public DumpWriter mo519f(String str) {
            if (!this.f658nl) {
                throw new AssertionError("called fieldStart() in a bad state");
            }
            prefix();
            this.buf.append(str).append(" = ");
            this.f658nl = false;
            return this;
        }

        @Override // com.dropbox.core.util.DumpWriter
        public DumpWriter listStart() {
            prefix();
            this.buf.append("[\n");
            this.f658nl = true;
            indentMore();
            return this;
        }

        @Override // com.dropbox.core.util.DumpWriter
        public DumpWriter listEnd() {
            if (!this.f658nl) {
                throw new AssertionError("called listEnd() in a bad state");
            }
            indentLess();
            prefix();
            this.buf.append("]\n");
            this.f658nl = true;
            return this;
        }

        @Override // com.dropbox.core.util.DumpWriter
        public DumpWriter verbatim(String str) {
            prefix();
            this.buf.append(str);
            this.buf.append('\n');
            this.f658nl = true;
            return this;
        }
    }

    public static final class Plain extends DumpWriter {
        private StringBuilder buf;
        private boolean needSep = false;

        public Plain(StringBuilder sb) {
            this.buf = sb;
        }

        private void sep() {
            if (this.needSep) {
                this.buf.append(TextRecallingManager.ANSWER_SEPARATOR);
            } else {
                this.needSep = true;
            }
        }

        @Override // com.dropbox.core.util.DumpWriter
        public DumpWriter recordStart(String str) {
            if (str != null) {
                this.buf.append(str);
            }
            this.buf.append("(");
            this.needSep = false;
            return this;
        }

        @Override // com.dropbox.core.util.DumpWriter
        public DumpWriter recordEnd() {
            this.buf.append(")");
            this.needSep = true;
            return this;
        }

        @Override // com.dropbox.core.util.DumpWriter
        /* JADX INFO: renamed from: f */
        public DumpWriter mo519f(String str) {
            sep();
            this.buf.append(str).append(Literals.PROPERTY_SPLITTER);
            this.needSep = false;
            return this;
        }

        @Override // com.dropbox.core.util.DumpWriter
        public DumpWriter listStart() {
            sep();
            this.buf.append("[");
            this.needSep = false;
            return this;
        }

        @Override // com.dropbox.core.util.DumpWriter
        public DumpWriter listEnd() {
            this.buf.append("]");
            this.needSep = true;
            return this;
        }

        @Override // com.dropbox.core.util.DumpWriter
        public DumpWriter verbatim(String str) {
            sep();
            this.buf.append(str);
            return this;
        }
    }

    public DumpWriter fieldVerbatim(String str, String str2) {
        return mo519f(str).verbatim(str2);
    }

    /* JADX INFO: renamed from: v */
    public DumpWriter m525v(Iterable<? extends Dumpable> iterable) {
        if (iterable == null) {
            verbatim(AbstractJsonLexerKt.NULL);
            return this;
        }
        listStart();
        Iterator<? extends Dumpable> it = iterable.iterator();
        while (it.hasNext()) {
            m524v(it.next());
        }
        listEnd();
        return this;
    }

    /* JADX INFO: renamed from: v */
    public DumpWriter m527v(String str) {
        if (str == null) {
            verbatim(AbstractJsonLexerKt.NULL);
            return this;
        }
        verbatim(StringUtil.m531jq(str));
        return this;
    }

    /* JADX INFO: renamed from: v */
    public DumpWriter m522v(int i) {
        return verbatim(Integer.toString(i));
    }

    /* JADX INFO: renamed from: v */
    public DumpWriter m523v(long j) {
        return verbatim(Long.toString(j));
    }

    /* JADX INFO: renamed from: v */
    public DumpWriter m529v(boolean z) {
        return verbatim(Boolean.toString(z));
    }

    /* JADX INFO: renamed from: v */
    public DumpWriter m521v(float f) {
        return verbatim(Float.toString(f));
    }

    /* JADX INFO: renamed from: v */
    public DumpWriter m520v(double d) {
        return verbatim(Double.toString(d));
    }

    /* JADX INFO: renamed from: v */
    public DumpWriter m528v(Date date) {
        return verbatim(toStringDate(date));
    }

    /* JADX INFO: renamed from: v */
    public DumpWriter m526v(Long l) {
        return verbatim(l == null ? AbstractJsonLexerKt.NULL : Long.toString(l.longValue()));
    }

    /* JADX INFO: renamed from: v */
    public DumpWriter m524v(Dumpable dumpable) {
        if (dumpable == null) {
            verbatim(AbstractJsonLexerKt.NULL);
            return this;
        }
        recordStart(dumpable.getTypeName());
        dumpable.dumpFields(this);
        recordEnd();
        return this;
    }

    public static String toStringDate(Date date) {
        if (date == null) {
            return AbstractJsonLexerKt.NULL;
        }
        StringBuilder sb = new StringBuilder("\"");
        GregorianCalendar gregorianCalendar = new GregorianCalendar(JsonDateReader.UTC);
        gregorianCalendar.setTime(date);
        String string = Integer.toString(gregorianCalendar.get(1));
        String strZeroPad = zeroPad(Integer.toString(gregorianCalendar.get(2) + 1), 2);
        String strZeroPad2 = zeroPad(Integer.toString(gregorianCalendar.get(5)), 2);
        String strZeroPad3 = zeroPad(Integer.toString(gregorianCalendar.get(11)), 2);
        String strZeroPad4 = zeroPad(Integer.toString(gregorianCalendar.get(12)), 2);
        String strZeroPad5 = zeroPad(Integer.toString(gregorianCalendar.get(13)), 2);
        sb.append(string).append(DomExceptionUtils.SEPARATOR).append(strZeroPad).append(DomExceptionUtils.SEPARATOR).append(strZeroPad2).append(" ");
        sb.append(strZeroPad3).append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR).append(strZeroPad4).append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR).append(strZeroPad5).append(" UTC\"");
        return sb.toString();
    }

    private static String zeroPad(String str, int i) {
        while (str.length() < i) {
            str = "0" + str;
        }
        return str;
    }
}
