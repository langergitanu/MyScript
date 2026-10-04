package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class GetMembershipReport extends BaseDfbReport {

    @Nonnull
    protected final List<Long> licenses;

    @Nonnull
    protected final List<Long> membersJoined;

    @Nonnull
    protected final List<Long> pendingInvites;

    @Nonnull
    protected final List<Long> suspendedMembers;

    @Nonnull
    protected final List<Long> teamSize;

    public GetMembershipReport(@Nonnull String str, @Nonnull List<Long> list, @Nonnull List<Long> list2, @Nonnull List<Long> list3, @Nonnull List<Long> list4, @Nonnull List<Long> list5) {
        super(str);
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'teamSize' is null");
        }
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'teamSize' is null");
            }
        }
        this.teamSize = list;
        if (list2 == null) {
            throw new IllegalArgumentException("Required value for 'pendingInvites' is null");
        }
        Iterator<Long> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (it2.next() == null) {
                throw new IllegalArgumentException("An item in list 'pendingInvites' is null");
            }
        }
        this.pendingInvites = list2;
        if (list3 == null) {
            throw new IllegalArgumentException("Required value for 'membersJoined' is null");
        }
        Iterator<Long> it3 = list3.iterator();
        while (it3.hasNext()) {
            if (it3.next() == null) {
                throw new IllegalArgumentException("An item in list 'membersJoined' is null");
            }
        }
        this.membersJoined = list3;
        if (list4 == null) {
            throw new IllegalArgumentException("Required value for 'suspendedMembers' is null");
        }
        Iterator<Long> it4 = list4.iterator();
        while (it4.hasNext()) {
            if (it4.next() == null) {
                throw new IllegalArgumentException("An item in list 'suspendedMembers' is null");
            }
        }
        this.suspendedMembers = list4;
        if (list5 == null) {
            throw new IllegalArgumentException("Required value for 'licenses' is null");
        }
        Iterator<Long> it5 = list5.iterator();
        while (it5.hasNext()) {
            if (it5.next() == null) {
                throw new IllegalArgumentException("An item in list 'licenses' is null");
            }
        }
        this.licenses = list5;
    }

    @Override // com.dropbox.core.p013v2.team.BaseDfbReport
    @Nonnull
    public String getStartDate() {
        return this.startDate;
    }

    @Nonnull
    public List<Long> getTeamSize() {
        return this.teamSize;
    }

    @Nonnull
    public List<Long> getPendingInvites() {
        return this.pendingInvites;
    }

    @Nonnull
    public List<Long> getMembersJoined() {
        return this.membersJoined;
    }

    @Nonnull
    public List<Long> getSuspendedMembers() {
        return this.suspendedMembers;
    }

    @Nonnull
    public List<Long> getLicenses() {
        return this.licenses;
    }

    @Override // com.dropbox.core.p013v2.team.BaseDfbReport
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.teamSize, this.pendingInvites, this.membersJoined, this.suspendedMembers, this.licenses});
    }

    @Override // com.dropbox.core.p013v2.team.BaseDfbReport
    public boolean equals(Object obj) {
        List<Long> list;
        List<Long> list2;
        List<Long> list3;
        List<Long> list4;
        List<Long> list5;
        List<Long> list6;
        List<Long> list7;
        List<Long> list8;
        List<Long> list9;
        List<Long> list10;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GetMembershipReport getMembershipReport = (GetMembershipReport) obj;
        return (this.startDate == getMembershipReport.startDate || this.startDate.equals(getMembershipReport.startDate)) && ((list = this.teamSize) == (list2 = getMembershipReport.teamSize) || list.equals(list2)) && (((list3 = this.pendingInvites) == (list4 = getMembershipReport.pendingInvites) || list3.equals(list4)) && (((list5 = this.membersJoined) == (list6 = getMembershipReport.membersJoined) || list5.equals(list6)) && (((list7 = this.suspendedMembers) == (list8 = getMembershipReport.suspendedMembers) || list7.equals(list8)) && ((list9 = this.licenses) == (list10 = getMembershipReport.licenses) || list9.equals(list10)))));
    }

    @Override // com.dropbox.core.p013v2.team.BaseDfbReport
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.BaseDfbReport
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GetMembershipReport> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GetMembershipReport getMembershipReport, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(FirebaseAnalytics.Param.START_DATE);
            StoneSerializers.string().serialize(getMembershipReport.startDate, jsonGenerator);
            jsonGenerator.writeFieldName("team_size");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(getMembershipReport.teamSize, jsonGenerator);
            jsonGenerator.writeFieldName("pending_invites");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(getMembershipReport.pendingInvites, jsonGenerator);
            jsonGenerator.writeFieldName("members_joined");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(getMembershipReport.membersJoined, jsonGenerator);
            jsonGenerator.writeFieldName("suspended_members");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(getMembershipReport.suspendedMembers, jsonGenerator);
            jsonGenerator.writeFieldName("licenses");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(getMembershipReport.licenses, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GetMembershipReport deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                List list = null;
                List list2 = null;
                List list3 = null;
                List list4 = null;
                List list5 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (FirebaseAnalytics.Param.START_DATE.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("team_size".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(jsonParser);
                    } else if ("pending_invites".equals(currentName)) {
                        list2 = (List) StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(jsonParser);
                    } else if ("members_joined".equals(currentName)) {
                        list3 = (List) StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(jsonParser);
                    } else if ("suspended_members".equals(currentName)) {
                        list4 = (List) StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(jsonParser);
                    } else if ("licenses".equals(currentName)) {
                        list5 = (List) StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"start_date\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_size\" missing.");
                }
                if (list2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"pending_invites\" missing.");
                }
                if (list3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"members_joined\" missing.");
                }
                if (list4 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"suspended_members\" missing.");
                }
                if (list5 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"licenses\" missing.");
                }
                GetMembershipReport getMembershipReport = new GetMembershipReport(strDeserialize, list, list2, list3, list4, list5);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(getMembershipReport, getMembershipReport.toStringMultiline());
                return getMembershipReport;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
