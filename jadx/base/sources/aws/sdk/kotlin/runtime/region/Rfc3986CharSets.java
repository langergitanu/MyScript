package aws.sdk.kotlin.runtime.region;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.ranges.CharRange;

/* JADX INFO: compiled from: ValidateRegion.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\f\n\u0002\b\u000f\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, m1599d2 = {"Laws/sdk/kotlin/runtime/region/Rfc3986CharSets;", "", "<init>", "()V", "alpha", "", "", "getAlpha", "()Ljava/util/Set;", "digit", "getDigit", "unreserved", "getUnreserved", "hexdig", "getHexdig", "pctEncoded", "getPctEncoded", "subDelims", "getSubDelims", "regName", "getRegName", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class Rfc3986CharSets {
    public static final Rfc3986CharSets INSTANCE = new Rfc3986CharSets();
    private static final Set<Character> alpha;
    private static final Set<Character> digit;
    private static final Set<Character> hexdig;
    private static final Set<Character> pctEncoded;
    private static final Set<Character> regName;
    private static final Set<Character> subDelims;
    private static final Set<Character> unreserved;

    private Rfc3986CharSets() {
    }

    static {
        Set<Character> setPlus = SetsKt.plus((Set) ValidateRegionKt.charSet(new CharRange('A', 'Z')), (Iterable) ValidateRegionKt.charSet(new CharRange('a', 'z')));
        alpha = setPlus;
        Set<Character> setCharSet = ValidateRegionKt.charSet(new CharRange('0', '9'));
        digit = setCharSet;
        Set<Character> setPlus2 = SetsKt.plus(SetsKt.plus((Set) setPlus, (Iterable) setCharSet), (Iterable) ValidateRegionKt.charSet("-._~"));
        unreserved = setPlus2;
        Set<Character> setPlus3 = SetsKt.plus((Set) setCharSet, (Iterable) ValidateRegionKt.charSet(new CharRange('A', 'F')));
        hexdig = setPlus3;
        Set<Character> setPlus4 = SetsKt.plus(setPlus3, '%');
        pctEncoded = setPlus4;
        Set<Character> setCharSet2 = ValidateRegionKt.charSet("!$&'()*+,;=");
        subDelims = setCharSet2;
        regName = SetsKt.plus(SetsKt.plus((Set) setPlus2, (Iterable) setPlus4), (Iterable) setCharSet2);
    }

    public final Set<Character> getAlpha() {
        return alpha;
    }

    public final Set<Character> getDigit() {
        return digit;
    }

    public final Set<Character> getUnreserved() {
        return unreserved;
    }

    public final Set<Character> getHexdig() {
        return hexdig;
    }

    public final Set<Character> getPctEncoded() {
        return pctEncoded;
    }

    public final Set<Character> getSubDelims() {
        return subDelims;
    }

    public final Set<Character> getRegName() {
        return regName;
    }
}
