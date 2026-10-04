package aws.sdk.kotlin.runtime.config.profile;

import aws.sdk.kotlin.runtime.config.profile.AwsConfigValue;
import aws.sdk.kotlin.runtime.config.profile.Token;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AwsConfigParser.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000j\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0007\u001a\u00020\b*\"\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u00030\u0001j\u0002`\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001aB\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u00030\u0001j\u0002`\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0000\u001a*\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0000\u001a>\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a0\u00190\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001aH\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u00030\u0001j\u0002`\t2\u001e\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a0\u00010\u0001H\u0002\u001a&\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0002\u001a%\u0010!\u001a\u00020\"*\u00020\u000e2\u0006\u0010#\u001a\u00020\u00152\u000e\b\u0004\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040%H\u0082\b\"\u0018\u0010\u001b\u001a\u00020\u0004*\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d*4\b\u0000\u0010\u0000\"\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002`\u00030\u00012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u00030\u0001*$\b\u0000\u0010\u0006\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001¨\u0006&"}, m1599d2 = {"TypedSectionMap", "", "Laws/sdk/kotlin/runtime/config/profile/ConfigSectionType;", "Laws/sdk/kotlin/runtime/config/profile/SectionMap;", "", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "SectionMap", "toSharedConfig", "Laws/sdk/kotlin/runtime/config/profile/AwsSharedConfig;", "Laws/sdk/kotlin/runtime/config/profile/TypedSectionMap;", FirebaseAnalytics.Param.SOURCE, "Laws/sdk/kotlin/runtime/config/profile/AwsConfigurationSource;", "parse", "logger", "Laws/smithy/kotlin/runtime/telemetry/logging/Logger;", "type", "Laws/sdk/kotlin/runtime/config/profile/FileType;", "input", "tokenize", "", "Lkotlin/Pair;", "Laws/sdk/kotlin/runtime/config/profile/FileLine;", "Laws/sdk/kotlin/runtime/config/profile/Token;", "toSectionMap", "Laws/sdk/kotlin/runtime/config/profile/Token$Section;", "", "Laws/sdk/kotlin/runtime/config/profile/AwsConfigValue;", "sectionName", "getSectionName", "(Laws/sdk/kotlin/runtime/config/profile/Token$Section;)Ljava/lang/String;", "mergeSections", "tokenIndexMap", "sections", "warnParse", "", "line", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsConfigParserKt {

    /* JADX INFO: compiled from: AwsConfigParser.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ConfigSectionType.values().length];
            try {
                iArr[ConfigSectionType.PROFILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConfigSectionType.SSO_SESSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ConfigSectionType.SERVICES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ConfigSectionType.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final AwsSharedConfig toSharedConfig(Map<ConfigSectionType, ? extends Map<String, ConfigSection>> map, AwsConfigurationSource source) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return new AwsSharedConfig(map, source);
    }

    public static final Map<ConfigSectionType, Map<String, ConfigSection>> parse(Logger logger, FileType type, String str) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(type, "type");
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return MapsKt.emptyMap();
        }
        return mergeSections(toSectionMap(tokenize(type, str), logger));
    }

    public static final List<Pair<FileLine, Token>> tokenize(FileType type, String input) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(input, "input");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        List<String> listLines = StringsKt.lines(input);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listLines, 10));
        int i = 0;
        for (Object obj : listLines) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new FileLine(i2, (String) obj));
            i = i2;
        }
        ArrayList<FileLine> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            FileLine fileLine = (FileLine) obj2;
            if (!StringsKt.isBlank(fileLine.getContent()) && !FileLineKt.isComment(fileLine)) {
                arrayList2.add(obj2);
            }
        }
        Token.Section section = null;
        Token.Property property = null;
        for (FileLine fileLine2 : arrayList2) {
            Token token = type.tokenOf(fileLine2, section, property);
            if (token instanceof Token.Section) {
                section = (Token.Section) token;
                property = null;
            } else if (token instanceof Token.Property) {
                property = (Token.Property) token;
            }
            listCreateListBuilder.add(TuplesKt.m1606to(fileLine2, token));
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, aws.sdk.kotlin.runtime.config.profile.Token, java.lang.Object] */
    public static final Map<Token.Section, Map<String, AwsConfigValue>> toSectionMap(List<? extends Pair<FileLine, ? extends Token>> list, Logger logger) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Token.Property property = null;
        LinkedHashMap linkedHashMap = null;
        for (Pair<FileLine, ? extends Token> pair : list) {
            final FileLine fileLineComponent1 = pair.component1();
            final Token tokenComponent2 = pair.component2();
            if (tokenComponent2 instanceof Token.Section) {
                objectRef.element = tokenComponent2;
                if (!mapCreateMapBuilder.containsKey(tokenComponent2)) {
                    if (((Token.Section) tokenComponent2).isValid()) {
                        mapCreateMapBuilder.put(tokenComponent2, new LinkedHashMap());
                    } else {
                        Logger.warn$default(logger, null, new Function0<String>() { // from class: aws.sdk.kotlin.runtime.config.profile.AwsConfigParserKt$toSectionMap$lambda$0$$inlined$warnParse$1
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return TextKt.contextMessage("Ignoring invalid " + AwsConfigParserKt.getSectionName((Token.Section) tokenComponent2) + " '" + ((Token.Section) tokenComponent2).getName() + '\'', Integer.valueOf(fileLineComponent1.getLineNumber()));
                            }
                        }, 1, null);
                    }
                }
                property = null;
            } else if (tokenComponent2 instanceof Token.Property) {
                T t = objectRef.element;
                Intrinsics.checkNotNull(t, "null cannot be cast to non-null type aws.sdk.kotlin.runtime.config.profile.Token.Section");
                property = (Token.Property) tokenComponent2;
                if (property.isValid()) {
                    if (((Token.Section) objectRef.element).isValid()) {
                        Object obj = mapCreateMapBuilder.get(objectRef.element);
                        Intrinsics.checkNotNull(obj);
                        Map map = (Map) obj;
                        if (map.containsKey(property.getKey())) {
                            Logger.warn$default(logger, null, new Function0<String>() { // from class: aws.sdk.kotlin.runtime.config.profile.AwsConfigParserKt$toSectionMap$lambda$0$$inlined$warnParse$4
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return TextKt.contextMessage("'" + ((Token.Property) tokenComponent2).getKey() + "' defined multiple times in " + AwsConfigParserKt.getSectionName((Token.Section) objectRef.element) + " '" + ((Token.Section) objectRef.element).getName() + '\'', Integer.valueOf(fileLineComponent1.getLineNumber()));
                                }
                            }, 1, null);
                        }
                        if (map.containsKey(property.getKey())) {
                            Logger.warn$default(logger, null, new Function0<String>() { // from class: aws.sdk.kotlin.runtime.config.profile.AwsConfigParserKt$toSectionMap$lambda$0$$inlined$warnParse$5
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return TextKt.contextMessage("Overwriting previously-defined property '" + ((Token.Property) tokenComponent2).getKey() + '\'', Integer.valueOf(fileLineComponent1.getLineNumber()));
                                }
                            }, 1, null);
                        }
                        map.put(property.getKey(), new AwsConfigValue.String(property.getValue()));
                    } else {
                        Logger.warn$default(logger, null, new Function0<String>() { // from class: aws.sdk.kotlin.runtime.config.profile.AwsConfigParserKt$toSectionMap$lambda$0$$inlined$warnParse$3
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return TextKt.contextMessage("Ignoring property under invalid " + AwsConfigParserKt.getSectionName((Token.Section) objectRef.element) + " '" + ((Token.Section) objectRef.element).getName() + '\'', Integer.valueOf(fileLineComponent1.getLineNumber()));
                            }
                        }, 1, null);
                    }
                } else {
                    Logger.warn$default(logger, null, new Function0<String>() { // from class: aws.sdk.kotlin.runtime.config.profile.AwsConfigParserKt$toSectionMap$lambda$0$$inlined$warnParse$2
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return TextKt.contextMessage("Ignoring invalid property '" + ((Token.Property) tokenComponent2).getKey() + '\'', Integer.valueOf(fileLineComponent1.getLineNumber()));
                        }
                    }, 1, null);
                }
            } else if (tokenComponent2 instanceof Token.Continuation) {
                T t2 = objectRef.element;
                Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type aws.sdk.kotlin.runtime.config.profile.Token.Section");
                Intrinsics.checkNotNull(property, "null cannot be cast to non-null type aws.sdk.kotlin.runtime.config.profile.Token.Property");
                Object obj2 = mapCreateMapBuilder.get(objectRef.element);
                Intrinsics.checkNotNull(obj2);
                Map map2 = (Map) obj2;
                Object obj3 = map2.get(property.getKey());
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type aws.sdk.kotlin.runtime.config.profile.AwsConfigValue.String");
                map2.put(property.getKey(), new AwsConfigValue.String(((AwsConfigValue.String) obj3).getValue() + '\n' + ((Token.Continuation) tokenComponent2).getValue()));
            } else {
                if (!(tokenComponent2 instanceof Token.SubProperty)) {
                    throw new NoWhenBranchMatchedException();
                }
                T t3 = objectRef.element;
                Intrinsics.checkNotNull(t3, "null cannot be cast to non-null type aws.sdk.kotlin.runtime.config.profile.Token.Section");
                Intrinsics.checkNotNull(property, "null cannot be cast to non-null type aws.sdk.kotlin.runtime.config.profile.Token.Property");
                Token.SubProperty subProperty = (Token.SubProperty) tokenComponent2;
                if (subProperty.isValid()) {
                    Object obj4 = mapCreateMapBuilder.get(objectRef.element);
                    Intrinsics.checkNotNull(obj4);
                    Map map3 = (Map) obj4;
                    AwsConfigValue awsConfigValue = (AwsConfigValue) map3.get(property.getKey());
                    if (awsConfigValue instanceof AwsConfigValue.String) {
                        if (((AwsConfigValue.String) awsConfigValue).getValue().length() > 0) {
                            Logger.warn$default(logger, null, new Function0<String>() { // from class: aws.sdk.kotlin.runtime.config.profile.AwsConfigParserKt$toSectionMap$lambda$0$$inlined$warnParse$7
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return TextKt.contextMessage("Overwriting previously-defined property '" + ((Token.SubProperty) tokenComponent2).getKey() + '\'', Integer.valueOf(fileLineComponent1.getLineNumber()));
                                }
                            }, 1, null);
                        }
                        linkedHashMap = new LinkedHashMap();
                        map3.put(property.getKey(), new AwsConfigValue.Map(linkedHashMap));
                    }
                    Intrinsics.checkNotNull(linkedHashMap);
                    linkedHashMap.put(subProperty.getKey(), subProperty.getValue());
                } else {
                    Logger.warn$default(logger, null, new Function0<String>() { // from class: aws.sdk.kotlin.runtime.config.profile.AwsConfigParserKt$toSectionMap$lambda$0$$inlined$warnParse$6
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return TextKt.contextMessage("Ignoring invalid sub-property '" + ((Token.SubProperty) tokenComponent2).getKey() + '\'', Integer.valueOf(fileLineComponent1.getLineNumber()));
                        }
                    }, 1, null);
                }
            }
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getSectionName(Token.Section section) {
        int i = WhenMappings.$EnumSwitchMapping$0[section.getType().ordinal()];
        if (i == 1) {
            return "profile";
        }
        if (i == 2) {
            return Literals.SSO_SESSION_KEYWORD;
        }
        if (i == 3) {
            return Literals.SERVICES_KEYWORD;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return "unknown section";
    }

    private static final Map<String, ConfigSection> mergeSections(List<ConfigSection> list) {
        Map<String, AwsConfigValue> mapEmptyMap;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (ConfigSection configSection : list) {
            ConfigSection configSection2 = (ConfigSection) mapCreateMapBuilder.get(configSection.getName());
            if (configSection2 == null || (mapEmptyMap = configSection2.getProperties$aws_config()) == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            mapCreateMapBuilder.put(configSection.getName(), new ConfigSection(configSection.getName(), MapsKt.plus(mapEmptyMap, configSection.getProperties$aws_config()), configSection.getSectionType$aws_config()));
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    private static final void warnParse(Logger logger, final FileLine fileLine, final Function0<String> function0) {
        Logger.warn$default(logger, null, new Function0<String>() { // from class: aws.sdk.kotlin.runtime.config.profile.AwsConfigParserKt.warnParse.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return TextKt.contextMessage(function0.invoke(), Integer.valueOf(fileLine.getLineNumber()));
            }
        }, 1, null);
    }

    private static final Map<ConfigSectionType, Map<String, ConfigSection>> mergeSections(Map<Token.Section, ? extends Map<String, ? extends AwsConfigValue>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Token.Section, ? extends Map<String, ? extends AwsConfigValue>> entry : map.entrySet()) {
            boolean hasSectionPrefix = entry.getKey().getHasSectionPrefix();
            if (!hasSectionPrefix) {
                if (hasSectionPrefix) {
                    throw new NoWhenBranchMatchedException();
                }
                Set<Token.Section> setKeySet = map.keySet();
                if (!(setKeySet instanceof Collection) || !setKeySet.isEmpty()) {
                    for (Token.Section section : setKeySet) {
                        if (!section.getHasSectionPrefix() || !Intrinsics.areEqual(section.getName(), entry.getKey().getName()) || section.getType() != entry.getKey().getType()) {
                        }
                    }
                }
            }
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            arrayList.add(new ConfigSection(((Token.Section) entry2.getKey()).getName(), (Map) entry2.getValue(), ((Token.Section) entry2.getKey()).getType()));
        }
        ArrayList arrayList2 = arrayList;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (ConfigSectionType configSectionType : ConfigSectionType.values()) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : arrayList2) {
                if (((ConfigSection) obj).getSectionType$aws_config() == configSectionType) {
                    arrayList3.add(obj);
                }
            }
            Map<String, ConfigSection> mapMergeSections = mergeSections(arrayList3);
            if (!mapMergeSections.isEmpty()) {
                linkedHashMap2.put(configSectionType, mapMergeSections);
            }
        }
        return linkedHashMap2;
    }
}
