package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AccessLevel;
import com.dropbox.core.p013v2.sharing.MemberPermission;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class MembershipInfo {

    @Nonnull
    protected final AccessLevel accessType;

    @Nullable
    protected final String initials;
    protected final boolean isInherited;

    @Nullable
    protected final List<MemberPermission> permissions;

    public MembershipInfo(@Nonnull AccessLevel accessLevel, @Nullable List<MemberPermission> list, @Nullable String str, boolean z) {
        if (accessLevel == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = accessLevel;
        if (list != null) {
            Iterator<MemberPermission> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'permissions' is null");
                }
            }
        }
        this.permissions = list;
        this.initials = str;
        this.isInherited = z;
    }

    public MembershipInfo(@Nonnull AccessLevel accessLevel) {
        this(accessLevel, null, null, false);
    }

    @Nonnull
    public AccessLevel getAccessType() {
        return this.accessType;
    }

    @Nullable
    public List<MemberPermission> getPermissions() {
        return this.permissions;
    }

    @Nullable
    public String getInitials() {
        return this.initials;
    }

    public boolean getIsInherited() {
        return this.isInherited;
    }

    public static Builder newBuilder(AccessLevel accessLevel) {
        return new Builder(accessLevel);
    }

    public static class Builder {
        protected final AccessLevel accessType;
        protected String initials;
        protected boolean isInherited;
        protected List<MemberPermission> permissions;

        protected Builder(AccessLevel accessLevel) {
            if (accessLevel == null) {
                throw new IllegalArgumentException("Required value for 'accessType' is null");
            }
            this.accessType = accessLevel;
            this.permissions = null;
            this.initials = null;
            this.isInherited = false;
        }

        public Builder withPermissions(List<MemberPermission> list) {
            if (list != null) {
                Iterator<MemberPermission> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'permissions' is null");
                    }
                }
            }
            this.permissions = list;
            return this;
        }

        public Builder withInitials(String str) {
            this.initials = str;
            return this;
        }

        public Builder withIsInherited(Boolean bool) {
            if (bool != null) {
                this.isInherited = bool.booleanValue();
                return this;
            }
            this.isInherited = false;
            return this;
        }

        public MembershipInfo build() {
            return new MembershipInfo(this.accessType, this.permissions, this.initials, this.isInherited);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.accessType, this.permissions, this.initials, Boolean.valueOf(this.isInherited)});
    }

    public boolean equals(Object obj) {
        MembershipInfo membershipInfo;
        AccessLevel accessLevel;
        AccessLevel accessLevel2;
        List<MemberPermission> list;
        List<MemberPermission> list2;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((accessLevel = this.accessType) == (accessLevel2 = (membershipInfo = (MembershipInfo) obj).accessType) || accessLevel.equals(accessLevel2)) && (((list = this.permissions) == (list2 = membershipInfo.permissions) || (list != null && list.equals(list2))) && (((str = this.initials) == (str2 = membershipInfo.initials) || (str != null && str.equals(str2))) && this.isInherited == membershipInfo.isInherited));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    private static class Serializer extends StructSerializer<MembershipInfo> {
        public static final Serializer INSTANCE = new Serializer();

        private Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MembershipInfo membershipInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("access_type");
            AccessLevel.Serializer.INSTANCE.serialize(membershipInfo.accessType, jsonGenerator);
            if (membershipInfo.permissions != null) {
                jsonGenerator.writeFieldName("permissions");
                StoneSerializers.nullable(StoneSerializers.list(MemberPermission.Serializer.INSTANCE)).serialize(membershipInfo.permissions, jsonGenerator);
            }
            if (membershipInfo.initials != null) {
                jsonGenerator.writeFieldName("initials");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(membershipInfo.initials, jsonGenerator);
            }
            jsonGenerator.writeFieldName("is_inherited");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(membershipInfo.isInherited), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MembershipInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AccessLevel accessLevelDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                Boolean boolDeserialize = false;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("access_type".equals(currentName)) {
                        accessLevelDeserialize = AccessLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("permissions".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(MemberPermission.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("initials".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("is_inherited".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (accessLevelDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"access_type\" missing.");
                }
                MembershipInfo membershipInfo = new MembershipInfo(accessLevelDeserialize, list, str, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(membershipInfo, membershipInfo.toStringMultiline());
                return membershipInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
