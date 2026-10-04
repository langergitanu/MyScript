package aws.sdk.kotlin.runtime.config.profile;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Token.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004\u0082\u0001\u0004\t\n\u000b\f¨\u0006\rÀ\u0006\u0003"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/profile/Token;", "", "isValid", "", "()Z", "Section", "Property", "Continuation", "SubProperty", "Laws/sdk/kotlin/runtime/config/profile/Token$Continuation;", "Laws/sdk/kotlin/runtime/config/profile/Token$Property;", "Laws/sdk/kotlin/runtime/config/profile/Token$Section;", "Laws/sdk/kotlin/runtime/config/profile/Token$SubProperty;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Token {
    default boolean isValid() {
        return true;
    }

    /* JADX INFO: compiled from: Token.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isValid(Token token) {
            return Token.super.isValid();
        }
    }

    /* JADX INFO: compiled from: Token.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010¨\u0006\u001c"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/profile/Token$Section;", "Laws/sdk/kotlin/runtime/config/profile/Token;", "name", "", "type", "Laws/sdk/kotlin/runtime/config/profile/ConfigSectionType;", "hasSectionPrefix", "", "isValid", "<init>", "(Ljava/lang/String;Laws/sdk/kotlin/runtime/config/profile/ConfigSectionType;ZZ)V", "getName", "()Ljava/lang/String;", "getType", "()Laws/sdk/kotlin/runtime/config/profile/ConfigSectionType;", "getHasSectionPrefix", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Section implements Token {
        private final boolean hasSectionPrefix;
        private final boolean isValid;
        private final String name;
        private final ConfigSectionType type;

        public static /* synthetic */ Section copy$default(Section section, String str, ConfigSectionType configSectionType, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = section.name;
            }
            if ((i & 2) != 0) {
                configSectionType = section.type;
            }
            if ((i & 4) != 0) {
                z = section.hasSectionPrefix;
            }
            if ((i & 8) != 0) {
                z2 = section.isValid;
            }
            return section.copy(str, configSectionType, z, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ConfigSectionType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getHasSectionPrefix() {
            return this.hasSectionPrefix;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsValid() {
            return this.isValid;
        }

        public final Section copy(String name, ConfigSectionType type, boolean hasSectionPrefix, boolean isValid) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            return new Section(name, type, hasSectionPrefix, isValid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Section)) {
                return false;
            }
            Section section = (Section) other;
            return Intrinsics.areEqual(this.name, section.name) && this.type == section.type && this.hasSectionPrefix == section.hasSectionPrefix && this.isValid == section.isValid;
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + this.type.hashCode()) * 31) + Boolean.hashCode(this.hasSectionPrefix)) * 31) + Boolean.hashCode(this.isValid);
        }

        public String toString() {
            return "Section(name=" + this.name + ", type=" + this.type + ", hasSectionPrefix=" + this.hasSectionPrefix + ", isValid=" + this.isValid + ')';
        }

        public Section(String name, ConfigSectionType type, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            this.name = name;
            this.type = type;
            this.hasSectionPrefix = z;
            this.isValid = z2;
        }

        public /* synthetic */ Section(String str, ConfigSectionType configSectionType, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, configSectionType, z, (i & 8) != 0 ? true : z2);
        }

        public final boolean getHasSectionPrefix() {
            return this.hasSectionPrefix;
        }

        public final String getName() {
            return this.name;
        }

        public final ConfigSectionType getType() {
            return this.type;
        }

        @Override // aws.sdk.kotlin.runtime.config.profile.Token
        public boolean isValid() {
            return this.isValid;
        }
    }

    /* JADX INFO: compiled from: Token.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u0006\u0016"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/profile/Token$Property;", "Laws/sdk/kotlin/runtime/config/profile/Token;", SubscriberAttributeKt.JSON_NAME_KEY, "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getValue", "isValid", "", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Property implements Token {
        private final String key;
        private final String value;

        public static /* synthetic */ Property copy$default(Property property, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = property.key;
            }
            if ((i & 2) != 0) {
                str2 = property.value;
            }
            return property.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final Property copy(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return new Property(key, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Property)) {
                return false;
            }
            Property property = (Property) other;
            return Intrinsics.areEqual(this.key, property.key) && Intrinsics.areEqual(this.value, property.value);
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.value.hashCode();
        }

        public String toString() {
            return "Property(key=" + this.key + ", value=" + this.value + ')';
        }

        public Property(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.key = key;
            this.value = value;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getValue() {
            return this.value;
        }

        @Override // aws.sdk.kotlin.runtime.config.profile.Token
        public boolean isValid() {
            return TextKt.isValidIdentifier(this.key);
        }
    }

    /* JADX INFO: compiled from: Token.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/profile/Token$Continuation;", "Laws/sdk/kotlin/runtime/config/profile/Token;", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Continuation implements Token {
        private final String value;

        public static /* synthetic */ Continuation copy$default(Continuation continuation, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = continuation.value;
            }
            return continuation.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final Continuation copy(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Continuation(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Continuation) && Intrinsics.areEqual(this.value, ((Continuation) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Continuation(value=" + this.value + ')';
        }

        public Continuation(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final String getValue() {
            return this.value;
        }

        @Override // aws.sdk.kotlin.runtime.config.profile.Token
        public /* bridge */ boolean isValid() {
            return super.isValid();
        }
    }

    /* JADX INFO: compiled from: Token.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u0006\u0016"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/profile/Token$SubProperty;", "Laws/sdk/kotlin/runtime/config/profile/Token;", SubscriberAttributeKt.JSON_NAME_KEY, "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getValue", "isValid", "", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SubProperty implements Token {
        private final String key;
        private final String value;

        public static /* synthetic */ SubProperty copy$default(SubProperty subProperty, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subProperty.key;
            }
            if ((i & 2) != 0) {
                str2 = subProperty.value;
            }
            return subProperty.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final SubProperty copy(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return new SubProperty(key, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubProperty)) {
                return false;
            }
            SubProperty subProperty = (SubProperty) other;
            return Intrinsics.areEqual(this.key, subProperty.key) && Intrinsics.areEqual(this.value, subProperty.value);
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.value.hashCode();
        }

        public String toString() {
            return "SubProperty(key=" + this.key + ", value=" + this.value + ')';
        }

        public SubProperty(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.key = key;
            this.value = value;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getValue() {
            return this.value;
        }

        @Override // aws.sdk.kotlin.runtime.config.profile.Token
        public boolean isValid() {
            return TextKt.isValidIdentifier(this.key);
        }
    }
}
