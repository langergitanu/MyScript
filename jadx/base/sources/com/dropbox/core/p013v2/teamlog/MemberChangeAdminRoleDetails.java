package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.AdminRole;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class MemberChangeAdminRoleDetails {

    @Nullable
    protected final AdminRole newValue;

    @Nullable
    protected final AdminRole previousValue;

    public MemberChangeAdminRoleDetails(@Nullable AdminRole adminRole, @Nullable AdminRole adminRole2) {
        this.newValue = adminRole;
        this.previousValue = adminRole2;
    }

    public MemberChangeAdminRoleDetails() {
        this(null, null);
    }

    @Nullable
    public AdminRole getNewValue() {
        return this.newValue;
    }

    @Nullable
    public AdminRole getPreviousValue() {
        return this.previousValue;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected AdminRole newValue = null;
        protected AdminRole previousValue = null;

        protected Builder() {
        }

        public Builder withNewValue(AdminRole adminRole) {
            this.newValue = adminRole;
            return this;
        }

        public Builder withPreviousValue(AdminRole adminRole) {
            this.previousValue = adminRole;
            return this;
        }

        public MemberChangeAdminRoleDetails build() {
            return new MemberChangeAdminRoleDetails(this.newValue, this.previousValue);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        AdminRole adminRole;
        AdminRole adminRole2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MemberChangeAdminRoleDetails memberChangeAdminRoleDetails = (MemberChangeAdminRoleDetails) obj;
        AdminRole adminRole3 = this.newValue;
        AdminRole adminRole4 = memberChangeAdminRoleDetails.newValue;
        return (adminRole3 == adminRole4 || (adminRole3 != null && adminRole3.equals(adminRole4))) && ((adminRole = this.previousValue) == (adminRole2 = memberChangeAdminRoleDetails.previousValue) || (adminRole != null && adminRole.equals(adminRole2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberChangeAdminRoleDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberChangeAdminRoleDetails memberChangeAdminRoleDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (memberChangeAdminRoleDetails.newValue != null) {
                jsonGenerator.writeFieldName("new_value");
                StoneSerializers.nullable(AdminRole.Serializer.INSTANCE).serialize(memberChangeAdminRoleDetails.newValue, jsonGenerator);
            }
            if (memberChangeAdminRoleDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(AdminRole.Serializer.INSTANCE).serialize(memberChangeAdminRoleDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberChangeAdminRoleDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AdminRole adminRole = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AdminRole adminRole2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        adminRole = (AdminRole) StoneSerializers.nullable(AdminRole.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        adminRole2 = (AdminRole) StoneSerializers.nullable(AdminRole.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                MemberChangeAdminRoleDetails memberChangeAdminRoleDetails = new MemberChangeAdminRoleDetails(adminRole, adminRole2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberChangeAdminRoleDetails, memberChangeAdminRoleDetails.toStringMultiline());
                return memberChangeAdminRoleDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
