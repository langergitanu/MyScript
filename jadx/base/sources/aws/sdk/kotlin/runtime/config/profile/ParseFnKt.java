package aws.sdk.kotlin.runtime.config.profile;

import aws.sdk.kotlin.runtime.config.profile.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ParseFn.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0000\u001a&\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0000\u001a&\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0000\u001a&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0000\u001a&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0000*¢\u0001\b\u0000\u0010\u0000\"M\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00012M\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001¨\u0006\u0012"}, m1599d2 = {"ParseFn", "Lkotlin/Function3;", "Laws/sdk/kotlin/runtime/config/profile/FileLine;", "Lkotlin/ParameterName;", "name", "input", "Laws/sdk/kotlin/runtime/config/profile/Token$Section;", "currentSection", "Laws/sdk/kotlin/runtime/config/profile/Token$Property;", "lastProperty", "Laws/sdk/kotlin/runtime/config/profile/Token;", "configurationSection", "credentialProfile", "property", "continuation", "Laws/sdk/kotlin/runtime/config/profile/Token$Continuation;", "subProperty", "Laws/sdk/kotlin/runtime/config/profile/Token$SubProperty;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ParseFnKt {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Token.Section configurationSection(FileLine input, Token.Section section, Token.Property property) {
        ConfigSectionType configSectionType;
        Intrinsics.checkNotNullParameter(input, "input");
        if (!FileLineKt.isSection(input)) {
            return null;
        }
        boolean z = true;
        List<String> listSplitWhitespace = TextKt.splitWhitespace(StringsKt.dropLast(StringsKt.drop(TextKt.stripComments(TextKt.stripInlineComments(input.getContent())), 1), 1), 2);
        boolean zAreEqual = Intrinsics.areEqual(CollectionsKt.firstOrNull((List) listSplitWhitespace), "default");
        boolean z2 = !zAreEqual;
        String str = listSplitWhitespace.get(0);
        switch (str.hashCode()) {
            case -1572100904:
                if (str.equals(Literals.SSO_SESSION_KEYWORD)) {
                    configSectionType = ConfigSectionType.SSO_SESSION;
                } else {
                    configSectionType = ConfigSectionType.UNKNOWN;
                }
                break;
            case -309425751:
                if (str.equals("profile")) {
                    configSectionType = ConfigSectionType.PROFILE;
                    break;
                }
                break;
            case 1379209310:
                if (str.equals(Literals.SERVICES_KEYWORD)) {
                    configSectionType = ConfigSectionType.SERVICES;
                    break;
                }
                break;
            case 1544803905:
                if (!str.equals("default")) {
                }
                break;
        }
        String str2 = (String) CollectionsKt.lastOrNull((List) listSplitWhitespace);
        if (str2 == null) {
            str2 = "";
        }
        if ((listSplitWhitespace.size() != 1 || !Intrinsics.areEqual(listSplitWhitespace.get(0), "default")) && (listSplitWhitespace.size() != 2 || str2.length() <= 0 || zAreEqual || !TextKt.isValidIdentifier(listSplitWhitespace.get(1)))) {
            z = false;
        }
        return new Token.Section(str2, configSectionType, z2, z);
    }

    public static final Token.Section credentialProfile(FileLine input, Token.Section section, Token.Property property) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (!FileLineKt.isProfile(input)) {
            return null;
        }
        String string = StringsKt.trim((CharSequence) StringsKt.dropLast(StringsKt.drop(TextKt.stripComments(TextKt.stripInlineComments(input.getContent())), 1), 1)).toString();
        return new Token.Section(string, ConfigSectionType.PROFILE, false, TextKt.isValidIdentifier(string));
    }

    public static final Token.Property property(FileLine input, Token.Section section, Token.Property property) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (!FileLineKt.isProperty(input) || section == null) {
            return null;
        }
        Pair<String, String> pairSplitProperty = TextKt.splitProperty(input.getContent());
        return new Token.Property(pairSplitProperty.component1(), TextKt.stripInlineComments(pairSplitProperty.component2()));
    }

    public static final Token.Continuation continuation(FileLine input, Token.Section section, Token.Property property) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (!FileLineKt.isContinuation(input) || property == null || property.getValue().length() == 0) {
            return null;
        }
        return new Token.Continuation(StringsKt.trim((CharSequence) input.getContent()).toString());
    }

    public static final Token.SubProperty subProperty(FileLine input, Token.Section section, Token.Property property) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (!FileLineKt.isSubProperty(input) || property == null || property.getValue().length() > 0) {
            return null;
        }
        Pair<String, String> pairSplitProperty = TextKt.splitProperty(input.getContent());
        return new Token.SubProperty(pairSplitProperty.component1(), pairSplitProperty.component2());
    }
}
