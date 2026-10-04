package com.dropbox.core.p013v2.users;

import com.dropbox.core.p013v2.teampolicies.OfficeAddInPolicy;
import com.dropbox.core.p013v2.teampolicies.TeamSharingPolicies;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class FullTeam extends Team {

    @Nonnull
    protected final OfficeAddInPolicy officeAddinPolicy;

    @Nonnull
    protected final TeamSharingPolicies sharingPolicies;

    public FullTeam(@Nonnull String str, @Nonnull String str2, @Nonnull TeamSharingPolicies teamSharingPolicies, @Nonnull OfficeAddInPolicy officeAddInPolicy) {
        super(str, str2);
        if (teamSharingPolicies == null) {
            throw new IllegalArgumentException("Required value for 'sharingPolicies' is null");
        }
        this.sharingPolicies = teamSharingPolicies;
        if (officeAddInPolicy == null) {
            throw new IllegalArgumentException("Required value for 'officeAddinPolicy' is null");
        }
        this.officeAddinPolicy = officeAddInPolicy;
    }

    @Override // com.dropbox.core.p013v2.users.Team
    @Nonnull
    public String getId() {
        return this.f815id;
    }

    @Override // com.dropbox.core.p013v2.users.Team
    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public TeamSharingPolicies getSharingPolicies() {
        return this.sharingPolicies;
    }

    @Nonnull
    public OfficeAddInPolicy getOfficeAddinPolicy() {
        return this.officeAddinPolicy;
    }

    @Override // com.dropbox.core.p013v2.users.Team
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.sharingPolicies, this.officeAddinPolicy});
    }

    @Override // com.dropbox.core.p013v2.users.Team
    public boolean equals(Object obj) {
        TeamSharingPolicies teamSharingPolicies;
        TeamSharingPolicies teamSharingPolicies2;
        OfficeAddInPolicy officeAddInPolicy;
        OfficeAddInPolicy officeAddInPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FullTeam fullTeam = (FullTeam) obj;
        return (this.f815id == fullTeam.f815id || this.f815id.equals(fullTeam.f815id)) && (this.name == fullTeam.name || this.name.equals(fullTeam.name)) && (((teamSharingPolicies = this.sharingPolicies) == (teamSharingPolicies2 = fullTeam.sharingPolicies) || teamSharingPolicies.equals(teamSharingPolicies2)) && ((officeAddInPolicy = this.officeAddinPolicy) == (officeAddInPolicy2 = fullTeam.officeAddinPolicy) || officeAddInPolicy.equals(officeAddInPolicy2)));
    }

    @Override // com.dropbox.core.p013v2.users.Team
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.users.Team
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FullTeam> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FullTeam fullTeam, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("id");
            StoneSerializers.string().serialize(fullTeam.f815id, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(fullTeam.name, jsonGenerator);
            jsonGenerator.writeFieldName("sharing_policies");
            TeamSharingPolicies.Serializer.INSTANCE.serialize(fullTeam.sharingPolicies, jsonGenerator);
            jsonGenerator.writeFieldName("office_addin_policy");
            OfficeAddInPolicy.Serializer.INSTANCE.serialize(fullTeam.officeAddinPolicy, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FullTeam deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize2 = null;
                TeamSharingPolicies teamSharingPoliciesDeserialize = null;
                OfficeAddInPolicy officeAddInPolicyDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("sharing_policies".equals(currentName)) {
                        teamSharingPoliciesDeserialize = TeamSharingPolicies.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("office_addin_policy".equals(currentName)) {
                        officeAddInPolicyDeserialize = OfficeAddInPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (teamSharingPoliciesDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"sharing_policies\" missing.");
                }
                if (officeAddInPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"office_addin_policy\" missing.");
                }
                FullTeam fullTeam = new FullTeam(strDeserialize, strDeserialize2, teamSharingPoliciesDeserialize, officeAddInPolicyDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fullTeam, fullTeam.toStringMultiline());
                return fullTeam;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
