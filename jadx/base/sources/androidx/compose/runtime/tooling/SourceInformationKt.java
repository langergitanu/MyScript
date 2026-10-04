package androidx.compose.runtime.tooling;

import androidx.compose.runtime.internal.Utils_androidKt;
import aws.sdk.kotlin.runtime.config.profile.Literals;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: SourceInformation.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002\u001a\u0012\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u0007H\u0002\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u0007H\u0002\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t*\u00020\u0007H\u0002\u001a\f\u0010\u000e\u001a\u00020\u0003*\u00020\u0003H\u0002¨\u0006\u000f"}, m1599d2 = {"parseSourceInformation", "Landroidx/compose/runtime/tooling/SourceInformation;", "data", "", "parseSourceInformationInternal", "hasSection", "", "Landroidx/compose/runtime/tooling/SourceInfoParserState;", "parseParameterIndex", "", "Landroidx/compose/runtime/tooling/ParameterSourceInformation;", "parseParameterNames", "parseLocations", "Landroidx/compose/runtime/tooling/LocationSourceInformation;", "replaceComposePrefix", "runtime"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SourceInformationKt {
    public static final SourceInformation parseSourceInformation(String str) {
        if (str.length() == 0) {
            return null;
        }
        try {
            return parseSourceInformationInternal(str);
        } catch (ParseException e) {
            Utils_androidKt.logError(e.getMessage(), e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SourceInformation parseSourceInformationInternal(String str) throws ParseException {
        boolean z;
        boolean z2;
        String strTakeUntil;
        String strTakeUntil2;
        SourceInfoParserState sourceInfoParserState = new SourceInfoParserState(str);
        String strTakeUntilEnd = null;
        if (sourceInfoParserState.matches('C')) {
            SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
            if (sourceInfoParserState.matches('C')) {
                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
                z = true;
            } else {
                z = false;
            }
            if (sourceInfoParserState.matches('(')) {
                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
                strTakeUntil = sourceInfoParserState.takeUntil(")");
                sourceInfoParserState.expect(')');
                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
                z2 = true;
                List<ParameterSourceInformation> listEmptyList = CollectionsKt.emptyList();
                while (hasSection(sourceInfoParserState)) {
                    char cCurrent = sourceInfoParserState.current();
                    if (cCurrent == 'N') {
                        listEmptyList = parseParameterNames(sourceInfoParserState);
                    } else if (cCurrent == 'P') {
                        listEmptyList = parseParameterIndex(sourceInfoParserState);
                    } else {
                        sourceInfoParserState.advance(2);
                        int i = 0;
                        while (true) {
                            if (i > 0 || !sourceInfoParserState.matches(')')) {
                                if (sourceInfoParserState.atEnd()) {
                                    sourceInfoParserState.throwParseError("unexpected end");
                                    throw new KotlinNothingValueException();
                                }
                                if (sourceInfoParserState.matches('(')) {
                                    i++;
                                } else if (sourceInfoParserState.matches(')')) {
                                    i--;
                                }
                                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
                            } else {
                                sourceInfoParserState.expect(')');
                                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
                                break;
                            }
                        }
                    }
                }
                List<LocationSourceInformation> listEmptyList2 = CollectionsKt.emptyList();
                if (sourceInfoParserState.matches(AbstractJsonLexerKt.COLON)) {
                    listEmptyList2 = parseLocations(sourceInfoParserState);
                } else {
                    SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
                }
                strTakeUntil2 = sourceInfoParserState.takeUntil(Literals.COMMENT_1);
                if (strTakeUntil2.length() <= 0) {
                    strTakeUntil2 = null;
                }
                if (sourceInfoParserState.matches('#')) {
                    SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
                    strTakeUntilEnd = sourceInfoParserState.takeUntilEnd();
                }
                String str2 = strTakeUntil2;
                return new SourceInformation(z2, z, strTakeUntil, str2, listEmptyList, strTakeUntilEnd, listEmptyList2, str);
            }
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        strTakeUntil = null;
        List<ParameterSourceInformation> listEmptyList3 = CollectionsKt.emptyList();
        while (hasSection(sourceInfoParserState)) {
        }
        List<LocationSourceInformation> listEmptyList22 = CollectionsKt.emptyList();
        if (sourceInfoParserState.matches(AbstractJsonLexerKt.COLON)) {
        }
        strTakeUntil2 = sourceInfoParserState.takeUntil(Literals.COMMENT_1);
        if (strTakeUntil2.length() <= 0) {
        }
        if (sourceInfoParserState.matches('#')) {
        }
        String str22 = strTakeUntil2;
        return new SourceInformation(z2, z, strTakeUntil, str22, listEmptyList3, strTakeUntilEnd, listEmptyList22, str);
    }

    private static final boolean hasSection(SourceInfoParserState sourceInfoParserState) {
        return sourceInfoParserState.getI() < sourceInfoParserState.getData().length() - 1 && Character.isLetter(sourceInfoParserState.getData().charAt(sourceInfoParserState.getI())) && sourceInfoParserState.getData().charAt(sourceInfoParserState.getI() + 1) == '(';
    }

    private static final List<ParameterSourceInformation> parseParameterIndex(SourceInfoParserState sourceInfoParserState) throws ParseException {
        String strReplaceComposePrefix;
        sourceInfoParserState.advance(2);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (!sourceInfoParserState.atEnd() && !sourceInfoParserState.matches(')')) {
            if (sourceInfoParserState.matches('!')) {
                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
                String strTakeUntil = sourceInfoParserState.takeUntil("!,)");
                if (strTakeUntil.length() != 0) {
                    int i = Integer.parseInt(strTakeUntil);
                    int i2 = 0;
                    while (i > 0) {
                        int size = arrayList.size();
                        int i3 = 0;
                        while (true) {
                            if (i3 < size) {
                                if (((ParameterSourceInformation) arrayList.get(i3)).getSortedIndex() == i2) {
                                    i2++;
                                    break;
                                }
                                i3++;
                            } else {
                                arrayList.add(new ParameterSourceInformation(i2, null, null, 6, null));
                                i--;
                                break;
                            }
                        }
                    }
                } else {
                    z = true;
                }
            } else {
                int iTakeIntUntil = sourceInfoParserState.takeIntUntil("!:,)");
                if (sourceInfoParserState.matches(AbstractJsonLexerKt.COLON)) {
                    SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
                    strReplaceComposePrefix = replaceComposePrefix(sourceInfoParserState.takeUntil("!,)"));
                } else {
                    strReplaceComposePrefix = null;
                }
                if (z) {
                    int i4 = 0;
                    while (i4 < iTakeIntUntil) {
                        int size2 = arrayList.size();
                        int i5 = 0;
                        while (true) {
                            if (i5 < size2) {
                                if (((ParameterSourceInformation) arrayList.get(i5)).getSortedIndex() == i4) {
                                    i4++;
                                    break;
                                }
                                i5++;
                            } else {
                                arrayList.add(new ParameterSourceInformation(i4, null, null, 6, null));
                                break;
                            }
                        }
                    }
                    z = false;
                }
                arrayList.add(new ParameterSourceInformation(iTakeIntUntil, null, strReplaceComposePrefix, 2, null));
            }
            if (sourceInfoParserState.matches(AbstractJsonLexerKt.COMMA)) {
                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
            }
        }
        sourceInfoParserState.expect(')');
        SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
        return arrayList;
    }

    private static final List<ParameterSourceInformation> parseParameterNames(SourceInfoParserState sourceInfoParserState) throws ParseException {
        String strReplaceComposePrefix;
        sourceInfoParserState.advance(2);
        ArrayList arrayList = new ArrayList();
        while (!sourceInfoParserState.atEnd() && !sourceInfoParserState.matches(')')) {
            String strTakeUntil = sourceInfoParserState.takeUntil(":,)");
            if (sourceInfoParserState.matches(AbstractJsonLexerKt.COLON)) {
                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
                strReplaceComposePrefix = replaceComposePrefix(sourceInfoParserState.takeUntil(",)"));
            } else {
                strReplaceComposePrefix = null;
            }
            arrayList.add(new ParameterSourceInformation(arrayList.size(), strTakeUntil, strReplaceComposePrefix));
            if (sourceInfoParserState.matches(AbstractJsonLexerKt.COMMA)) {
                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
            }
        }
        sourceInfoParserState.expect(')');
        SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
        return arrayList;
    }

    private static final List<LocationSourceInformation> parseLocations(SourceInfoParserState sourceInfoParserState) throws ParseException {
        boolean z;
        Integer numValueOf;
        ArrayList arrayList = new ArrayList();
        while (!sourceInfoParserState.atEnd() && !sourceInfoParserState.matches(AbstractJsonLexerKt.COLON)) {
            if (sourceInfoParserState.matches('*')) {
                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
                z = true;
            } else {
                z = false;
            }
            Integer numValueOf2 = !sourceInfoParserState.matches('@') ? Integer.valueOf(sourceInfoParserState.takeIntUntil("@") + 1) : null;
            SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
            int iTakeIntUntil = sourceInfoParserState.takeIntUntil("L,:");
            if (sourceInfoParserState.matches('L')) {
                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
                numValueOf = Integer.valueOf(sourceInfoParserState.takeIntUntil(",:"));
            } else {
                numValueOf = null;
            }
            arrayList.add(new LocationSourceInformation(numValueOf2 != null ? numValueOf2.intValue() : -1, iTakeIntUntil, numValueOf != null ? numValueOf.intValue() : -1, z));
            if (sourceInfoParserState.matches(AbstractJsonLexerKt.COMMA)) {
                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
            }
        }
        SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
        return arrayList;
    }

    private static final String replaceComposePrefix(String str) {
        return StringsKt.replaceFirst$default(str, "c#", "androidx.compose.", false, 4, (Object) null);
    }
}
