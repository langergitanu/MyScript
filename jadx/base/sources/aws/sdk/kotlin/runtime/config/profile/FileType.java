package aws.sdk.kotlin.runtime.config.profile;

import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import aws.sdk.kotlin.runtime.config.profile.Token;
import aws.smithy.kotlin.runtime.config.EnvironmentSetting;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import org.apache.http.cookie.ClientCookie;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: FileType.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0082\u0001\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012[\u0010\u0005\u001aW\u0012S\u0012Q\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0007j\u0002`\u00110\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Rc\u0010\u0005\u001aW\u0012S\u0012Q\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0007j\u0002`\u00110\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u001b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/profile/FileType;", "", "setting", "Laws/smithy/kotlin/runtime/config/EnvironmentSetting;", "", "lineParsers", "", "Lkotlin/Function3;", "Laws/sdk/kotlin/runtime/config/profile/FileLine;", "Lkotlin/ParameterName;", "name", "input", "Laws/sdk/kotlin/runtime/config/profile/Token$Section;", "currentSection", "Laws/sdk/kotlin/runtime/config/profile/Token$Property;", "lastProperty", "Laws/sdk/kotlin/runtime/config/profile/Token;", "Laws/sdk/kotlin/runtime/config/profile/ParseFn;", "pathSegments", "<init>", "(Ljava/lang/String;ILaws/smithy/kotlin/runtime/config/EnvironmentSetting;Ljava/util/List;Ljava/util/List;)V", "CONFIGURATION", "CREDENTIAL", ClientCookie.PATH_ATTR, DeviceDimensionProvider.KEY_PLATFORM, "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "tokenOf", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FileType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FileType[] $VALUES;
    public static final FileType CONFIGURATION = new FileType("CONFIGURATION", 0, AwsSdkSetting.INSTANCE.getAwsConfigFile(), CollectionsKt.listOf((Object[]) new KFunction[]{C31181.INSTANCE, C31192.INSTANCE, C31203.INSTANCE, C31214.INSTANCE}), CollectionsKt.listOf((Object[]) new String[]{"~", ".aws", "config"}));
    public static final FileType CREDENTIAL = new FileType("CREDENTIAL", 1, AwsSdkSetting.INSTANCE.getAwsSharedCredentialsFile(), CollectionsKt.listOf((Object[]) new KFunction[]{C31225.INSTANCE, C31236.INSTANCE, C31247.INSTANCE, C31258.INSTANCE}), CollectionsKt.listOf((Object[]) new String[]{"~", ".aws", "credentials"}));
    private final List<Function3<FileLine, Token.Section, Token.Property, Token>> lineParsers;
    private final List<String> pathSegments;
    private final EnvironmentSetting<String> setting;

    private static final /* synthetic */ FileType[] $values() {
        return new FileType[]{CONFIGURATION, CREDENTIAL};
    }

    public static EnumEntries<FileType> getEntries() {
        return $ENTRIES;
    }

    public static FileType valueOf(String str) {
        return (FileType) Enum.valueOf(FileType.class, str);
    }

    public static FileType[] values() {
        return (FileType[]) $VALUES.clone();
    }

    private FileType(String str, int i, EnvironmentSetting environmentSetting, List list, List list2) {
        this.setting = environmentSetting;
        this.lineParsers = list;
        this.pathSegments = list2;
    }

    static {
        FileType[] fileTypeArr$values = $values();
        $VALUES = fileTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(fileTypeArr$values);
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.profile.FileType$1 */
    /* JADX INFO: compiled from: FileType.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C31181 extends FunctionReferenceImpl implements Function3<FileLine, Token.Section, Token.Property, Token.Section> {
        public static final C31181 INSTANCE = new C31181();

        C31181() {
            super(3, ParseFnKt.class, "configurationSection", "configurationSection(Laws/sdk/kotlin/runtime/config/profile/FileLine;Laws/sdk/kotlin/runtime/config/profile/Token$Section;Laws/sdk/kotlin/runtime/config/profile/Token$Property;)Laws/sdk/kotlin/runtime/config/profile/Token$Section;", 1);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Token.Section invoke(FileLine p0, Token.Section section, Token.Property property) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ParseFnKt.configurationSection(p0, section, property);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.profile.FileType$2 */
    /* JADX INFO: compiled from: FileType.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C31192 extends FunctionReferenceImpl implements Function3<FileLine, Token.Section, Token.Property, Token.Property> {
        public static final C31192 INSTANCE = new C31192();

        C31192() {
            super(3, ParseFnKt.class, "property", "property(Laws/sdk/kotlin/runtime/config/profile/FileLine;Laws/sdk/kotlin/runtime/config/profile/Token$Section;Laws/sdk/kotlin/runtime/config/profile/Token$Property;)Laws/sdk/kotlin/runtime/config/profile/Token$Property;", 1);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Token.Property invoke(FileLine p0, Token.Section section, Token.Property property) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ParseFnKt.property(p0, section, property);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.profile.FileType$3 */
    /* JADX INFO: compiled from: FileType.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C31203 extends FunctionReferenceImpl implements Function3<FileLine, Token.Section, Token.Property, Token.Continuation> {
        public static final C31203 INSTANCE = new C31203();

        C31203() {
            super(3, ParseFnKt.class, "continuation", "continuation(Laws/sdk/kotlin/runtime/config/profile/FileLine;Laws/sdk/kotlin/runtime/config/profile/Token$Section;Laws/sdk/kotlin/runtime/config/profile/Token$Property;)Laws/sdk/kotlin/runtime/config/profile/Token$Continuation;", 1);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Token.Continuation invoke(FileLine p0, Token.Section section, Token.Property property) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ParseFnKt.continuation(p0, section, property);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.profile.FileType$4 */
    /* JADX INFO: compiled from: FileType.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C31214 extends FunctionReferenceImpl implements Function3<FileLine, Token.Section, Token.Property, Token.SubProperty> {
        public static final C31214 INSTANCE = new C31214();

        C31214() {
            super(3, ParseFnKt.class, "subProperty", "subProperty(Laws/sdk/kotlin/runtime/config/profile/FileLine;Laws/sdk/kotlin/runtime/config/profile/Token$Section;Laws/sdk/kotlin/runtime/config/profile/Token$Property;)Laws/sdk/kotlin/runtime/config/profile/Token$SubProperty;", 1);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Token.SubProperty invoke(FileLine p0, Token.Section section, Token.Property property) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ParseFnKt.subProperty(p0, section, property);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.profile.FileType$5 */
    /* JADX INFO: compiled from: FileType.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C31225 extends FunctionReferenceImpl implements Function3<FileLine, Token.Section, Token.Property, Token.Section> {
        public static final C31225 INSTANCE = new C31225();

        C31225() {
            super(3, ParseFnKt.class, "credentialProfile", "credentialProfile(Laws/sdk/kotlin/runtime/config/profile/FileLine;Laws/sdk/kotlin/runtime/config/profile/Token$Section;Laws/sdk/kotlin/runtime/config/profile/Token$Property;)Laws/sdk/kotlin/runtime/config/profile/Token$Section;", 1);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Token.Section invoke(FileLine p0, Token.Section section, Token.Property property) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ParseFnKt.credentialProfile(p0, section, property);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.profile.FileType$6 */
    /* JADX INFO: compiled from: FileType.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C31236 extends FunctionReferenceImpl implements Function3<FileLine, Token.Section, Token.Property, Token.Property> {
        public static final C31236 INSTANCE = new C31236();

        C31236() {
            super(3, ParseFnKt.class, "property", "property(Laws/sdk/kotlin/runtime/config/profile/FileLine;Laws/sdk/kotlin/runtime/config/profile/Token$Section;Laws/sdk/kotlin/runtime/config/profile/Token$Property;)Laws/sdk/kotlin/runtime/config/profile/Token$Property;", 1);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Token.Property invoke(FileLine p0, Token.Section section, Token.Property property) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ParseFnKt.property(p0, section, property);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.profile.FileType$7 */
    /* JADX INFO: compiled from: FileType.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C31247 extends FunctionReferenceImpl implements Function3<FileLine, Token.Section, Token.Property, Token.Continuation> {
        public static final C31247 INSTANCE = new C31247();

        C31247() {
            super(3, ParseFnKt.class, "continuation", "continuation(Laws/sdk/kotlin/runtime/config/profile/FileLine;Laws/sdk/kotlin/runtime/config/profile/Token$Section;Laws/sdk/kotlin/runtime/config/profile/Token$Property;)Laws/sdk/kotlin/runtime/config/profile/Token$Continuation;", 1);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Token.Continuation invoke(FileLine p0, Token.Section section, Token.Property property) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ParseFnKt.continuation(p0, section, property);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.profile.FileType$8 */
    /* JADX INFO: compiled from: FileType.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C31258 extends FunctionReferenceImpl implements Function3<FileLine, Token.Section, Token.Property, Token.SubProperty> {
        public static final C31258 INSTANCE = new C31258();

        C31258() {
            super(3, ParseFnKt.class, "subProperty", "subProperty(Laws/sdk/kotlin/runtime/config/profile/FileLine;Laws/sdk/kotlin/runtime/config/profile/Token$Section;Laws/sdk/kotlin/runtime/config/profile/Token$Property;)Laws/sdk/kotlin/runtime/config/profile/Token$SubProperty;", 1);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Token.SubProperty invoke(FileLine p0, Token.Section section, Token.Property property) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ParseFnKt.subProperty(p0, section, property);
        }
    }

    public final String path(PlatformProvider platform) {
        String string;
        Intrinsics.checkNotNullParameter(platform, "platform");
        String str = (String) EnvironmentSettingKt.resolve(this.setting, platform);
        return (str == null || (string = StringsKt.trim((CharSequence) str).toString()) == null) ? CollectionsKt.joinToString$default(this.pathSegments, platform.getFilePathSeparator(), null, null, 0, null, null, 62, null) : string;
    }

    public final Token tokenOf(FileLine input, Token.Section currentSection, Token.Property lastProperty) {
        Token token;
        Intrinsics.checkNotNullParameter(input, "input");
        Iterator<T> it = this.lineParsers.iterator();
        while (true) {
            if (!it.hasNext()) {
                token = null;
                break;
            }
            token = (Token) ((Function3) it.next()).invoke(input, currentSection, lastProperty);
            if (token != null) {
                break;
            }
        }
        if (token != null) {
            return token;
        }
        throw new AwsConfigParseException("Encountered unexpected token", input.getLineNumber());
    }
}
