package com.revenuecat.purchases.rules.customoperators;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.rules.RulesEngine;
import com.revenuecat.purchases.rules.Value;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: SemverOperator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000f"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/customoperators/SemanticVersion;", "", "core", "", "", "prerelease", "", "(Ljava/util/List;Ljava/util/List;)V", "getCore", "()Ljava/util/List;", "getPrerelease", "compare", "", "other", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
final class SemanticVersion {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Long> core;
    private final List<String> prerelease;

    public SemanticVersion(List<Long> core, List<String> prerelease) {
        Intrinsics.checkNotNullParameter(core, "core");
        Intrinsics.checkNotNullParameter(prerelease, "prerelease");
        this.core = core;
        this.prerelease = prerelease;
    }

    public final List<Long> getCore() {
        return this.core;
    }

    public final List<String> getPrerelease() {
        return this.prerelease;
    }

    public final int compare(SemanticVersion other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (Pair pair : CollectionsKt.zip(this.core, other.core)) {
            long jLongValue = ((Number) pair.component1()).longValue();
            long jLongValue2 = ((Number) pair.component2()).longValue();
            if (jLongValue != jLongValue2) {
                return jLongValue < jLongValue2 ? -1 : 1;
            }
        }
        if (this.prerelease.isEmpty() && other.prerelease.isEmpty()) {
            return 0;
        }
        if (this.prerelease.isEmpty()) {
            return 1;
        }
        if (other.prerelease.isEmpty()) {
            return -1;
        }
        return INSTANCE.comparePrerelease(this.prerelease, other.prerelease);
    }

    /* JADX INFO: compiled from: SemverOperator.kt */
    @Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\b\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002¨\u0006\u001e"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/customoperators/SemanticVersion$Companion;", "", "()V", "compareIdentifiers", "", TtmlNode.LEFT, "", TtmlNode.RIGHT, "comparePrerelease", "lhs", "", "rhs", "invalid", "Lcom/revenuecat/purchases/rules/RulesEngine$EvaluationException$TypeMismatch;", "version", "isIdentifierCharacter", "", FirebaseAnalytics.Param.CHARACTER, "", "numericIdentifier", "", "text", "(Ljava/lang/String;)Ljava/lang/Long;", "parse", "Lcom/revenuecat/purchases/rules/customoperators/SemanticVersion;", "value", "Lcom/revenuecat/purchases/rules/Value;", "parseCore", "original", "parsePrerelease", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean isIdentifierCharacter(char character) {
            if ('a' <= character && character < '{') {
                return true;
            }
            if ('A' > character || character >= '[') {
                return ('0' <= character && character < ':') || character == '-';
            }
            return true;
        }

        private Companion() {
        }

        public final SemanticVersion parse(Value value) throws RulesEngine.EvaluationException.TypeMismatch {
            Intrinsics.checkNotNullParameter(value, "value");
            if (!(value instanceof Value.StringValue)) {
                throw new RulesEngine.EvaluationException.TypeMismatch("operator 'rc.semverCompare' expected version strings, got " + value);
            }
            String value2 = ((Value.StringValue) value).getValue();
            String str = null;
            String strSubstringBefore$default = StringsKt.substringBefore$default(value2, '+', (String) null, 2, (Object) null);
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) strSubstringBefore$default, Soundex.SILENT_MARKER, 0, false, 6, (Object) null);
            if (iIndexOf$default >= 0) {
                String strSubstring = strSubstringBefore$default.substring(0, iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String strSubstring2 = strSubstringBefore$default.substring(iIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                str = strSubstring2;
                strSubstringBefore$default = strSubstring;
            }
            return new SemanticVersion(parseCore(strSubstringBefore$default, value2), parsePrerelease(str, value2));
        }

        private final List<Long> parseCore(String text, String original) throws RulesEngine.EvaluationException.TypeMismatch {
            List listSplit$default = StringsKt.split$default((CharSequence) text, new String[]{"."}, false, 0, 6, (Object) null);
            if (listSplit$default.isEmpty() || listSplit$default.size() > 3) {
                throw invalid(original);
            }
            List list = listSplit$default;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Long lNumericIdentifier = SemanticVersion.INSTANCE.numericIdentifier((String) it.next());
                if (lNumericIdentifier == null) {
                    throw SemanticVersion.INSTANCE.invalid(original);
                }
                arrayList.add(Long.valueOf(lNumericIdentifier.longValue()));
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = arrayList2;
            int size = 3 - arrayList2.size();
            ArrayList arrayList4 = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList4.add(0L);
            }
            return CollectionsKt.plus((Collection) arrayList3, (Iterable) arrayList4);
        }

        private final List<String> parsePrerelease(String text, String original) throws RulesEngine.EvaluationException.TypeMismatch {
            if (text == null) {
                return CollectionsKt.emptyList();
            }
            List<String> listSplit$default = StringsKt.split$default((CharSequence) text, new String[]{"."}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
            for (String str : listSplit$default) {
                String str2 = str;
                if (str2.length() != 0) {
                    Companion companion = SemanticVersion.INSTANCE;
                    for (int i = 0; i < str2.length(); i++) {
                        if (companion.isIdentifierCharacter(str2.charAt(i))) {
                        }
                    }
                    arrayList.add(str);
                }
                throw SemanticVersion.INSTANCE.invalid(original);
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int comparePrerelease(List<String> lhs, List<String> rhs) {
            for (Pair pair : CollectionsKt.zip(lhs, rhs)) {
                int iCompareIdentifiers = SemanticVersion.INSTANCE.compareIdentifiers((String) pair.component1(), (String) pair.component2());
                if (iCompareIdentifiers != 0) {
                    return iCompareIdentifiers;
                }
            }
            if (lhs.size() == rhs.size()) {
                return 0;
            }
            return lhs.size() < rhs.size() ? -1 : 1;
        }

        private final int compareIdentifiers(String left, String right) {
            Long lNumericIdentifier = numericIdentifier(left);
            Long lNumericIdentifier2 = numericIdentifier(right);
            if (lNumericIdentifier != null && lNumericIdentifier2 != null) {
                if (Intrinsics.areEqual(lNumericIdentifier, lNumericIdentifier2)) {
                    return 0;
                }
                return lNumericIdentifier.longValue() < lNumericIdentifier2.longValue() ? -1 : 1;
            }
            if (lNumericIdentifier != null) {
                return -1;
            }
            if (lNumericIdentifier2 != null) {
                return 1;
            }
            if (Intrinsics.areEqual(left, right)) {
                return 0;
            }
            return left.compareTo(right) < 0 ? -1 : 1;
        }

        private final Long numericIdentifier(String text) {
            String str = text;
            if (str.length() == 0) {
                return null;
            }
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if ('0' > cCharAt || cCharAt >= ':') {
                    return null;
                }
            }
            return StringsKt.toLongOrNull(text);
        }

        private final RulesEngine.EvaluationException.TypeMismatch invalid(String version) {
            return new RulesEngine.EvaluationException.TypeMismatch("operator 'rc.semverCompare' could not parse version '" + version + '\'');
        }
    }
}
