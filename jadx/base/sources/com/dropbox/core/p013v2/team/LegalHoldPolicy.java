package com.dropbox.core.p013v2.team;

import androidx.core.app.NotificationCompat;
import com.dropbox.core.p013v2.team.LegalHoldStatus;
import com.dropbox.core.p013v2.team.MembersInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class LegalHoldPolicy {

    @Nullable
    protected final Date activationTime;

    @Nullable
    protected final String description;

    @Nullable
    protected final Date endDate;

    /* JADX INFO: renamed from: id */
    @Nonnull
    protected final String f750id;

    @Nonnull
    protected final MembersInfo members;

    @Nonnull
    protected final String name;

    @Nonnull
    protected final Date startDate;

    @Nonnull
    protected final LegalHoldStatus status;

    public LegalHoldPolicy(@Nonnull String str, @Nonnull String str2, @Nonnull MembersInfo membersInfo, @Nonnull LegalHoldStatus legalHoldStatus, @Nonnull Date date, @Nullable String str3, @Nullable Date date2, @Nullable Date date3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (!Pattern.matches("^pid_dbhid:.+", str)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.f750id = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        if (str2.length() > 140) {
            throw new IllegalArgumentException("String 'name' is longer than 140");
        }
        this.name = str2;
        if (str3 != null && str3.length() > 501) {
            throw new IllegalArgumentException("String 'description' is longer than 501");
        }
        this.description = str3;
        this.activationTime = LangUtil.truncateMillis(date2);
        if (membersInfo == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        this.members = membersInfo;
        if (legalHoldStatus == null) {
            throw new IllegalArgumentException("Required value for 'status' is null");
        }
        this.status = legalHoldStatus;
        if (date == null) {
            throw new IllegalArgumentException("Required value for 'startDate' is null");
        }
        this.startDate = LangUtil.truncateMillis(date);
        this.endDate = LangUtil.truncateMillis(date3);
    }

    public LegalHoldPolicy(@Nonnull String str, @Nonnull String str2, @Nonnull MembersInfo membersInfo, @Nonnull LegalHoldStatus legalHoldStatus, @Nonnull Date date) {
        this(str, str2, membersInfo, legalHoldStatus, date, null, null, null);
    }

    @Nonnull
    public String getId() {
        return this.f750id;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public MembersInfo getMembers() {
        return this.members;
    }

    @Nonnull
    public LegalHoldStatus getStatus() {
        return this.status;
    }

    @Nonnull
    public Date getStartDate() {
        return this.startDate;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    @Nullable
    public Date getActivationTime() {
        return this.activationTime;
    }

    @Nullable
    public Date getEndDate() {
        return this.endDate;
    }

    public static Builder newBuilder(String str, String str2, MembersInfo membersInfo, LegalHoldStatus legalHoldStatus, Date date) {
        return new Builder(str, str2, membersInfo, legalHoldStatus, date);
    }

    public static class Builder {
        protected Date activationTime;
        protected String description;
        protected Date endDate;

        /* JADX INFO: renamed from: id */
        protected final String f751id;
        protected final MembersInfo members;
        protected final String name;
        protected final Date startDate;
        protected final LegalHoldStatus status;

        protected Builder(String str, String str2, MembersInfo membersInfo, LegalHoldStatus legalHoldStatus, Date date) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'id' is null");
            }
            if (!Pattern.matches("^pid_dbhid:.+", str)) {
                throw new IllegalArgumentException("String 'id' does not match pattern");
            }
            this.f751id = str;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            if (str2.length() > 140) {
                throw new IllegalArgumentException("String 'name' is longer than 140");
            }
            this.name = str2;
            if (membersInfo == null) {
                throw new IllegalArgumentException("Required value for 'members' is null");
            }
            this.members = membersInfo;
            if (legalHoldStatus == null) {
                throw new IllegalArgumentException("Required value for 'status' is null");
            }
            this.status = legalHoldStatus;
            if (date == null) {
                throw new IllegalArgumentException("Required value for 'startDate' is null");
            }
            this.startDate = LangUtil.truncateMillis(date);
            this.description = null;
            this.activationTime = null;
            this.endDate = null;
        }

        public Builder withDescription(String str) {
            if (str != null && str.length() > 501) {
                throw new IllegalArgumentException("String 'description' is longer than 501");
            }
            this.description = str;
            return this;
        }

        public Builder withActivationTime(Date date) {
            this.activationTime = LangUtil.truncateMillis(date);
            return this;
        }

        public Builder withEndDate(Date date) {
            this.endDate = LangUtil.truncateMillis(date);
            return this;
        }

        public LegalHoldPolicy build() {
            return new LegalHoldPolicy(this.f751id, this.name, this.members, this.status, this.startDate, this.description, this.activationTime, this.endDate);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f750id, this.name, this.description, this.activationTime, this.members, this.status, this.startDate, this.endDate});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        MembersInfo membersInfo;
        MembersInfo membersInfo2;
        LegalHoldStatus legalHoldStatus;
        LegalHoldStatus legalHoldStatus2;
        Date date;
        Date date2;
        String str3;
        String str4;
        Date date3;
        Date date4;
        Date date5;
        Date date6;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        LegalHoldPolicy legalHoldPolicy = (LegalHoldPolicy) obj;
        String str5 = this.f750id;
        String str6 = legalHoldPolicy.f750id;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.name) == (str2 = legalHoldPolicy.name) || str.equals(str2)) && (((membersInfo = this.members) == (membersInfo2 = legalHoldPolicy.members) || membersInfo.equals(membersInfo2)) && (((legalHoldStatus = this.status) == (legalHoldStatus2 = legalHoldPolicy.status) || legalHoldStatus.equals(legalHoldStatus2)) && (((date = this.startDate) == (date2 = legalHoldPolicy.startDate) || date.equals(date2)) && (((str3 = this.description) == (str4 = legalHoldPolicy.description) || (str3 != null && str3.equals(str4))) && (((date3 = this.activationTime) == (date4 = legalHoldPolicy.activationTime) || (date3 != null && date3.equals(date4))) && ((date5 = this.endDate) == (date6 = legalHoldPolicy.endDate) || (date5 != null && date5.equals(date6))))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LegalHoldPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        /*  JADX ERROR: ConcurrentModificationException in pass: MethodInvokeVisitor
            java.util.ConcurrentModificationException
            	at java.base/java.util.HashMap$HashIterator.nextNode(HashMap.java:1605)
            	at java.base/java.util.HashMap$KeyIterator.next(HashMap.java:1628)
            	at jadx.core.utils.Utils.collectionMap(Utils.java:252)
            	at jadx.core.dex.nodes.MethodNode.getThrows(MethodNode.java:490)
            	at jadx.core.dex.visitors.methods.MutableMethodDetails.<init>(MutableMethodDetails.java:25)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.resolveTypeVars(MethodInvokeVisitor.java:250)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:113)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:98)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.lambda$visit$0(MethodInvokeVisitor.java:73)
            	at jadx.core.dex.nodes.InsnNode.visitInsns(InsnNode.java:301)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:71)
            */
        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(com.dropbox.core.p013v2.team.LegalHoldPolicy r3, com.fasterxml.jackson.core.JsonGenerator r4, boolean r5) throws java.io.IOException {
            /*
                r2 = this;
                if (r5 != 0) goto L5
                r4.writeStartObject()
            L5:
                java.lang.String r0 = "id"
                r4.writeFieldName(r0)
                com.dropbox.core.stone.StoneSerializer r0 = com.dropbox.core.stone.StoneSerializers.string()
                java.lang.String r1 = r3.f750id
                r0.serialize(r1, r4)
                java.lang.String r0 = "name"
                r4.writeFieldName(r0)
                com.dropbox.core.stone.StoneSerializer r0 = com.dropbox.core.stone.StoneSerializers.string()
                java.lang.String r1 = r3.name
                r0.serialize(r1, r4)
                java.lang.String r0 = "members"
                r4.writeFieldName(r0)
                com.dropbox.core.v2.team.MembersInfo$Serializer r0 = com.dropbox.core.v2.team.MembersInfo.Serializer.INSTANCE
                com.dropbox.core.v2.team.MembersInfo r1 = r3.members
                r0.serialize(r1, r4)
                java.lang.String r0 = "status"
                r4.writeFieldName(r0)
                com.dropbox.core.v2.team.LegalHoldStatus$Serializer r0 = com.dropbox.core.v2.team.LegalHoldStatus.Serializer.INSTANCE
                com.dropbox.core.v2.team.LegalHoldStatus r1 = r3.status
                r0.serialize(r1, r4)
                java.lang.String r0 = "start_date"
                r4.writeFieldName(r0)
                com.dropbox.core.stone.StoneSerializer r0 = com.dropbox.core.stone.StoneSerializers.timestamp()
                java.util.Date r1 = r3.startDate
                r0.serialize(r1, r4)
                java.lang.String r0 = r3.description
                if (r0 == 0) goto L5d
                java.lang.String r0 = "description"
                r4.writeFieldName(r0)
                com.dropbox.core.stone.StoneSerializer r0 = com.dropbox.core.stone.StoneSerializers.string()
                com.dropbox.core.stone.StoneSerializer r0 = com.dropbox.core.stone.StoneSerializers.nullable(r0)
                java.lang.String r1 = r3.description
                r0.serialize(r1, r4)
            L5d:
                java.util.Date r0 = r3.activationTime
                if (r0 == 0) goto L73
                java.lang.String r0 = "activation_time"
                r4.writeFieldName(r0)
                com.dropbox.core.stone.StoneSerializer r0 = com.dropbox.core.stone.StoneSerializers.timestamp()
                com.dropbox.core.stone.StoneSerializer r0 = com.dropbox.core.stone.StoneSerializers.nullable(r0)
                java.util.Date r1 = r3.activationTime
                r0.serialize(r1, r4)
            L73:
                java.util.Date r0 = r3.endDate
                if (r0 == 0) goto L89
                java.lang.String r0 = "end_date"
                r4.writeFieldName(r0)
                com.dropbox.core.stone.StoneSerializer r0 = com.dropbox.core.stone.StoneSerializers.timestamp()
                com.dropbox.core.stone.StoneSerializer r0 = com.dropbox.core.stone.StoneSerializers.nullable(r0)
                java.util.Date r3 = r3.endDate
                r0.serialize(r3, r4)
            L89:
                if (r5 != 0) goto L8e
                r4.writeEndObject()
            L8e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dropbox.core.v2.team.LegalHoldPolicy.Serializer.serialize(com.dropbox.core.v2.team.LegalHoldPolicy, com.fasterxml.jackson.core.JsonGenerator, boolean):void");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LegalHoldPolicy deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                MembersInfo membersInfoDeserialize = null;
                LegalHoldStatus legalHoldStatusDeserialize = null;
                Date dateDeserialize = null;
                String str = null;
                Date date = null;
                Date date2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("members".equals(currentName)) {
                        membersInfoDeserialize = MembersInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if (NotificationCompat.CATEGORY_STATUS.equals(currentName)) {
                        legalHoldStatusDeserialize = LegalHoldStatus.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if (FirebaseAnalytics.Param.START_DATE.equals(currentName)) {
                        dateDeserialize = StoneSerializers.timestamp().deserialize(jsonParser);
                    } else if ("description".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("activation_time".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if (FirebaseAnalytics.Param.END_DATE.equals(currentName)) {
                        date2 = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
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
                if (membersInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"members\" missing.");
                }
                if (legalHoldStatusDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"status\" missing.");
                }
                if (dateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"start_date\" missing.");
                }
                LegalHoldPolicy legalHoldPolicy = new LegalHoldPolicy(strDeserialize, strDeserialize2, membersInfoDeserialize, legalHoldStatusDeserialize, dateDeserialize, str, date, date2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(legalHoldPolicy, legalHoldPolicy.toStringMultiline());
                return legalHoldPolicy;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
