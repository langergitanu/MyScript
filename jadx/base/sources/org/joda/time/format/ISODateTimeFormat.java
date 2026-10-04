package org.joda.time.format;

import java.util.Collection;
import java.util.HashSet;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.language.Soundex;
import org.joda.time.DateTimeFieldType;

/* JADX INFO: loaded from: classes9.dex */
public class ISODateTimeFormat {
    protected ISODateTimeFormat() {
    }

    public static DateTimeFormatter forFields(Collection<DateTimeFieldType> collection, boolean z, boolean z2) {
        boolean zDateByWeek;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException("The fields must not be null or empty");
        }
        HashSet hashSet = new HashSet(collection);
        int size = hashSet.size();
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        if (hashSet.contains(DateTimeFieldType.monthOfYear())) {
            zDateByWeek = dateByMonth(dateTimeFormatterBuilder, hashSet, z, z2);
        } else if (hashSet.contains(DateTimeFieldType.dayOfYear())) {
            zDateByWeek = dateByOrdinal(dateTimeFormatterBuilder, hashSet, z, z2);
        } else if (hashSet.contains(DateTimeFieldType.weekOfWeekyear())) {
            zDateByWeek = dateByWeek(dateTimeFormatterBuilder, hashSet, z, z2);
        } else if (hashSet.contains(DateTimeFieldType.dayOfMonth())) {
            zDateByWeek = dateByMonth(dateTimeFormatterBuilder, hashSet, z, z2);
        } else if (hashSet.contains(DateTimeFieldType.dayOfWeek())) {
            zDateByWeek = dateByWeek(dateTimeFormatterBuilder, hashSet, z, z2);
        } else {
            if (!hashSet.remove(DateTimeFieldType.year())) {
                if (hashSet.remove(DateTimeFieldType.weekyear())) {
                    dateTimeFormatterBuilder.append(Constants.f2816we);
                } else {
                    zDateByWeek = false;
                }
            } else {
                dateTimeFormatterBuilder.append(Constants.f2818ye);
            }
            zDateByWeek = true;
        }
        if (hashSet.size() < size) {
            z3 = true;
            z6 = z2;
            z4 = zDateByWeek;
            z5 = z;
        } else {
            z3 = false;
            z4 = zDateByWeek;
            z5 = z;
            z6 = z2;
        }
        time(dateTimeFormatterBuilder, hashSet, z5, z6, z4, z3);
        if (!dateTimeFormatterBuilder.canBuildFormatter()) {
            throw new IllegalArgumentException("No valid format for fields: " + collection);
        }
        try {
            collection.retainAll(hashSet);
        } catch (UnsupportedOperationException unused) {
        }
        return dateTimeFormatterBuilder.toFormatter();
    }

    private static boolean dateByMonth(DateTimeFormatterBuilder dateTimeFormatterBuilder, Collection<DateTimeFieldType> collection, boolean z, boolean z2) {
        if (!collection.remove(DateTimeFieldType.year())) {
            if (collection.remove(DateTimeFieldType.monthOfYear())) {
                dateTimeFormatterBuilder.appendLiteral(Soundex.SILENT_MARKER);
                dateTimeFormatterBuilder.appendLiteral(Soundex.SILENT_MARKER);
                dateTimeFormatterBuilder.appendMonthOfYear(2);
                if (!collection.remove(DateTimeFieldType.dayOfMonth())) {
                    return true;
                }
                appendSeparator(dateTimeFormatterBuilder, z);
                dateTimeFormatterBuilder.appendDayOfMonth(2);
                return false;
            }
            if (collection.remove(DateTimeFieldType.dayOfMonth())) {
                dateTimeFormatterBuilder.appendLiteral(Soundex.SILENT_MARKER);
                dateTimeFormatterBuilder.appendLiteral(Soundex.SILENT_MARKER);
                dateTimeFormatterBuilder.appendLiteral(Soundex.SILENT_MARKER);
                dateTimeFormatterBuilder.appendDayOfMonth(2);
            }
            return false;
        }
        dateTimeFormatterBuilder.append(Constants.f2818ye);
        if (collection.remove(DateTimeFieldType.monthOfYear())) {
            if (collection.remove(DateTimeFieldType.dayOfMonth())) {
                appendSeparator(dateTimeFormatterBuilder, z);
                dateTimeFormatterBuilder.appendMonthOfYear(2);
                appendSeparator(dateTimeFormatterBuilder, z);
                dateTimeFormatterBuilder.appendDayOfMonth(2);
                return false;
            }
            dateTimeFormatterBuilder.appendLiteral(Soundex.SILENT_MARKER);
            dateTimeFormatterBuilder.appendMonthOfYear(2);
            return true;
        }
        if (!collection.remove(DateTimeFieldType.dayOfMonth())) {
            return true;
        }
        checkNotStrictISO(collection, z2);
        dateTimeFormatterBuilder.appendLiteral(Soundex.SILENT_MARKER);
        dateTimeFormatterBuilder.appendLiteral(Soundex.SILENT_MARKER);
        dateTimeFormatterBuilder.appendDayOfMonth(2);
        return false;
    }

    private static boolean dateByOrdinal(DateTimeFormatterBuilder dateTimeFormatterBuilder, Collection<DateTimeFieldType> collection, boolean z, boolean z2) {
        if (!collection.remove(DateTimeFieldType.year())) {
            if (collection.remove(DateTimeFieldType.dayOfYear())) {
                dateTimeFormatterBuilder.appendLiteral(Soundex.SILENT_MARKER);
                dateTimeFormatterBuilder.appendDayOfYear(3);
            }
            return false;
        }
        dateTimeFormatterBuilder.append(Constants.f2818ye);
        if (!collection.remove(DateTimeFieldType.dayOfYear())) {
            return true;
        }
        appendSeparator(dateTimeFormatterBuilder, z);
        dateTimeFormatterBuilder.appendDayOfYear(3);
        return false;
    }

    private static boolean dateByWeek(DateTimeFormatterBuilder dateTimeFormatterBuilder, Collection<DateTimeFieldType> collection, boolean z, boolean z2) {
        if (!collection.remove(DateTimeFieldType.weekyear())) {
            if (collection.remove(DateTimeFieldType.weekOfWeekyear())) {
                dateTimeFormatterBuilder.appendLiteral(Soundex.SILENT_MARKER);
                dateTimeFormatterBuilder.appendLiteral('W');
                dateTimeFormatterBuilder.appendWeekOfWeekyear(2);
                if (!collection.remove(DateTimeFieldType.dayOfWeek())) {
                    return true;
                }
                appendSeparator(dateTimeFormatterBuilder, z);
                dateTimeFormatterBuilder.appendDayOfWeek(1);
                return false;
            }
            if (collection.remove(DateTimeFieldType.dayOfWeek())) {
                dateTimeFormatterBuilder.appendLiteral(Soundex.SILENT_MARKER);
                dateTimeFormatterBuilder.appendLiteral('W');
                dateTimeFormatterBuilder.appendLiteral(Soundex.SILENT_MARKER);
                dateTimeFormatterBuilder.appendDayOfWeek(1);
            }
            return false;
        }
        dateTimeFormatterBuilder.append(Constants.f2816we);
        if (collection.remove(DateTimeFieldType.weekOfWeekyear())) {
            appendSeparator(dateTimeFormatterBuilder, z);
            dateTimeFormatterBuilder.appendLiteral('W');
            dateTimeFormatterBuilder.appendWeekOfWeekyear(2);
            if (!collection.remove(DateTimeFieldType.dayOfWeek())) {
                return true;
            }
            appendSeparator(dateTimeFormatterBuilder, z);
            dateTimeFormatterBuilder.appendDayOfWeek(1);
            return false;
        }
        if (!collection.remove(DateTimeFieldType.dayOfWeek())) {
            return true;
        }
        checkNotStrictISO(collection, z2);
        appendSeparator(dateTimeFormatterBuilder, z);
        dateTimeFormatterBuilder.appendLiteral('W');
        dateTimeFormatterBuilder.appendLiteral(Soundex.SILENT_MARKER);
        dateTimeFormatterBuilder.appendDayOfWeek(1);
        return false;
    }

    private static void time(DateTimeFormatterBuilder dateTimeFormatterBuilder, Collection<DateTimeFieldType> collection, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean zRemove = collection.remove(DateTimeFieldType.hourOfDay());
        boolean zRemove2 = collection.remove(DateTimeFieldType.minuteOfHour());
        boolean zRemove3 = collection.remove(DateTimeFieldType.secondOfMinute());
        boolean zRemove4 = collection.remove(DateTimeFieldType.millisOfSecond());
        if (zRemove || zRemove2 || zRemove3 || zRemove4) {
            if (zRemove || zRemove2 || zRemove3 || zRemove4) {
                if (z2 && z3) {
                    throw new IllegalArgumentException("No valid ISO8601 format for fields because Date was reduced precision: " + collection);
                }
                if (z4) {
                    dateTimeFormatterBuilder.appendLiteral('T');
                }
            }
            if ((!zRemove || !zRemove2 || !zRemove3) && (!zRemove || zRemove3 || zRemove4)) {
                if (z2 && z4) {
                    throw new IllegalArgumentException("No valid ISO8601 format for fields because Time was truncated: " + collection);
                }
                if ((zRemove || ((!zRemove2 || !zRemove3) && ((!zRemove2 || zRemove4) && !zRemove3))) && z2) {
                    throw new IllegalArgumentException("No valid ISO8601 format for fields: " + collection);
                }
            }
            if (zRemove) {
                dateTimeFormatterBuilder.appendHourOfDay(2);
            } else if (zRemove2 || zRemove3 || zRemove4) {
                dateTimeFormatterBuilder.appendLiteral(Soundex.SILENT_MARKER);
            }
            if (z && zRemove && zRemove2) {
                dateTimeFormatterBuilder.appendLiteral(AbstractJsonLexerKt.COLON);
            }
            if (zRemove2) {
                dateTimeFormatterBuilder.appendMinuteOfHour(2);
            } else if (zRemove3 || zRemove4) {
                dateTimeFormatterBuilder.appendLiteral(Soundex.SILENT_MARKER);
            }
            if (z && zRemove2 && zRemove3) {
                dateTimeFormatterBuilder.appendLiteral(AbstractJsonLexerKt.COLON);
            }
            if (zRemove3) {
                dateTimeFormatterBuilder.appendSecondOfMinute(2);
            } else if (zRemove4) {
                dateTimeFormatterBuilder.appendLiteral(Soundex.SILENT_MARKER);
            }
            if (zRemove4) {
                dateTimeFormatterBuilder.appendLiteral('.');
                dateTimeFormatterBuilder.appendMillisOfSecond(3);
            }
        }
    }

    private static void checkNotStrictISO(Collection<DateTimeFieldType> collection, boolean z) {
        if (z) {
            throw new IllegalArgumentException("No valid ISO8601 format for fields: " + collection);
        }
    }

    private static void appendSeparator(DateTimeFormatterBuilder dateTimeFormatterBuilder, boolean z) {
        if (z) {
            dateTimeFormatterBuilder.appendLiteral(Soundex.SILENT_MARKER);
        }
    }

    public static DateTimeFormatter dateParser() {
        return Constants.f2808dp;
    }

    public static DateTimeFormatter localDateParser() {
        return Constants.ldp;
    }

    public static DateTimeFormatter dateElementParser() {
        return Constants.dpe;
    }

    public static DateTimeFormatter timeParser() {
        return Constants.f2813tp;
    }

    public static DateTimeFormatter localTimeParser() {
        return Constants.ltp;
    }

    public static DateTimeFormatter timeElementParser() {
        return Constants.tpe;
    }

    public static DateTimeFormatter dateTimeParser() {
        return Constants.dtp;
    }

    public static DateTimeFormatter dateOptionalTimeParser() {
        return Constants.dotp;
    }

    public static DateTimeFormatter localDateOptionalTimeParser() {
        return Constants.ldotp;
    }

    public static DateTimeFormatter date() {
        return yearMonthDay();
    }

    public static DateTimeFormatter time() {
        return Constants.f2812t;
    }

    public static DateTimeFormatter timeNoMillis() {
        return Constants.f2815tx;
    }

    public static DateTimeFormatter tTime() {
        return Constants.f2814tt;
    }

    public static DateTimeFormatter tTimeNoMillis() {
        return Constants.ttx;
    }

    public static DateTimeFormatter dateTime() {
        return Constants.f2809dt;
    }

    public static DateTimeFormatter dateTimeNoMillis() {
        return Constants.dtx;
    }

    public static DateTimeFormatter ordinalDate() {
        return Constants.f2811od;
    }

    public static DateTimeFormatter ordinalDateTime() {
        return Constants.odt;
    }

    public static DateTimeFormatter ordinalDateTimeNoMillis() {
        return Constants.odtx;
    }

    public static DateTimeFormatter weekDate() {
        return Constants.wwd;
    }

    public static DateTimeFormatter weekDateTime() {
        return Constants.wdt;
    }

    public static DateTimeFormatter weekDateTimeNoMillis() {
        return Constants.wdtx;
    }

    public static DateTimeFormatter basicDate() {
        return Constants.f2805bd;
    }

    public static DateTimeFormatter basicTime() {
        return Constants.f2806bt;
    }

    public static DateTimeFormatter basicTimeNoMillis() {
        return Constants.btx;
    }

    public static DateTimeFormatter basicTTime() {
        return Constants.btt;
    }

    public static DateTimeFormatter basicTTimeNoMillis() {
        return Constants.bttx;
    }

    public static DateTimeFormatter basicDateTime() {
        return Constants.bdt;
    }

    public static DateTimeFormatter basicDateTimeNoMillis() {
        return Constants.bdtx;
    }

    public static DateTimeFormatter basicOrdinalDate() {
        return Constants.bod;
    }

    public static DateTimeFormatter basicOrdinalDateTime() {
        return Constants.bodt;
    }

    public static DateTimeFormatter basicOrdinalDateTimeNoMillis() {
        return Constants.bodtx;
    }

    public static DateTimeFormatter basicWeekDate() {
        return Constants.bwd;
    }

    public static DateTimeFormatter basicWeekDateTime() {
        return Constants.bwdt;
    }

    public static DateTimeFormatter basicWeekDateTimeNoMillis() {
        return Constants.bwdtx;
    }

    public static DateTimeFormatter year() {
        return Constants.f2818ye;
    }

    public static DateTimeFormatter yearMonth() {
        return Constants.f2819ym;
    }

    public static DateTimeFormatter yearMonthDay() {
        return Constants.ymd;
    }

    public static DateTimeFormatter weekyear() {
        return Constants.f2816we;
    }

    public static DateTimeFormatter weekyearWeek() {
        return Constants.f2817ww;
    }

    public static DateTimeFormatter weekyearWeekDay() {
        return Constants.wwd;
    }

    public static DateTimeFormatter hour() {
        return Constants.hde;
    }

    public static DateTimeFormatter hourMinute() {
        return Constants.f2810hm;
    }

    public static DateTimeFormatter hourMinuteSecond() {
        return Constants.hms;
    }

    public static DateTimeFormatter hourMinuteSecondMillis() {
        return Constants.hmsl;
    }

    public static DateTimeFormatter hourMinuteSecondFraction() {
        return Constants.hmsf;
    }

    public static DateTimeFormatter dateHour() {
        return Constants.f2807dh;
    }

    public static DateTimeFormatter dateHourMinute() {
        return Constants.dhm;
    }

    public static DateTimeFormatter dateHourMinuteSecond() {
        return Constants.dhms;
    }

    public static DateTimeFormatter dateHourMinuteSecondMillis() {
        return Constants.dhmsl;
    }

    public static DateTimeFormatter dateHourMinuteSecondFraction() {
        return Constants.dhmsf;
    }

    static final class Constants {

        /* JADX INFO: renamed from: ye */
        private static final DateTimeFormatter f2818ye = yearElement();
        private static final DateTimeFormatter mye = monthElement();
        private static final DateTimeFormatter dme = dayOfMonthElement();

        /* JADX INFO: renamed from: we */
        private static final DateTimeFormatter f2816we = weekyearElement();
        private static final DateTimeFormatter wwe = weekElement();
        private static final DateTimeFormatter dwe = dayOfWeekElement();
        private static final DateTimeFormatter dye = dayOfYearElement();
        private static final DateTimeFormatter hde = hourElement();
        private static final DateTimeFormatter mhe = minuteElement();
        private static final DateTimeFormatter sme = secondElement();
        private static final DateTimeFormatter fse = fractionElement();

        /* JADX INFO: renamed from: ze */
        private static final DateTimeFormatter f2820ze = offsetElement();
        private static final DateTimeFormatter lte = literalTElement();

        /* JADX INFO: renamed from: ym */
        private static final DateTimeFormatter f2819ym = yearMonth();
        private static final DateTimeFormatter ymd = yearMonthDay();

        /* JADX INFO: renamed from: ww */
        private static final DateTimeFormatter f2817ww = weekyearWeek();
        private static final DateTimeFormatter wwd = weekyearWeekDay();

        /* JADX INFO: renamed from: hm */
        private static final DateTimeFormatter f2810hm = hourMinute();
        private static final DateTimeFormatter hms = hourMinuteSecond();
        private static final DateTimeFormatter hmsl = hourMinuteSecondMillis();
        private static final DateTimeFormatter hmsf = hourMinuteSecondFraction();

        /* JADX INFO: renamed from: dh */
        private static final DateTimeFormatter f2807dh = dateHour();
        private static final DateTimeFormatter dhm = dateHourMinute();
        private static final DateTimeFormatter dhms = dateHourMinuteSecond();
        private static final DateTimeFormatter dhmsl = dateHourMinuteSecondMillis();
        private static final DateTimeFormatter dhmsf = dateHourMinuteSecondFraction();

        /* JADX INFO: renamed from: t */
        private static final DateTimeFormatter f2812t = time();

        /* JADX INFO: renamed from: tx */
        private static final DateTimeFormatter f2815tx = timeNoMillis();

        /* JADX INFO: renamed from: tt */
        private static final DateTimeFormatter f2814tt = tTime();
        private static final DateTimeFormatter ttx = tTimeNoMillis();

        /* JADX INFO: renamed from: dt */
        private static final DateTimeFormatter f2809dt = dateTime();
        private static final DateTimeFormatter dtx = dateTimeNoMillis();
        private static final DateTimeFormatter wdt = weekDateTime();
        private static final DateTimeFormatter wdtx = weekDateTimeNoMillis();

        /* JADX INFO: renamed from: od */
        private static final DateTimeFormatter f2811od = ordinalDate();
        private static final DateTimeFormatter odt = ordinalDateTime();
        private static final DateTimeFormatter odtx = ordinalDateTimeNoMillis();

        /* JADX INFO: renamed from: bd */
        private static final DateTimeFormatter f2805bd = basicDate();

        /* JADX INFO: renamed from: bt */
        private static final DateTimeFormatter f2806bt = basicTime();
        private static final DateTimeFormatter btx = basicTimeNoMillis();
        private static final DateTimeFormatter btt = basicTTime();
        private static final DateTimeFormatter bttx = basicTTimeNoMillis();
        private static final DateTimeFormatter bdt = basicDateTime();
        private static final DateTimeFormatter bdtx = basicDateTimeNoMillis();
        private static final DateTimeFormatter bod = basicOrdinalDate();
        private static final DateTimeFormatter bodt = basicOrdinalDateTime();
        private static final DateTimeFormatter bodtx = basicOrdinalDateTimeNoMillis();
        private static final DateTimeFormatter bwd = basicWeekDate();
        private static final DateTimeFormatter bwdt = basicWeekDateTime();
        private static final DateTimeFormatter bwdtx = basicWeekDateTimeNoMillis();
        private static final DateTimeFormatter dpe = dateElementParser();
        private static final DateTimeFormatter tpe = timeElementParser();

        /* JADX INFO: renamed from: dp */
        private static final DateTimeFormatter f2808dp = dateParser();
        private static final DateTimeFormatter ldp = localDateParser();

        /* JADX INFO: renamed from: tp */
        private static final DateTimeFormatter f2813tp = timeParser();
        private static final DateTimeFormatter ltp = localTimeParser();
        private static final DateTimeFormatter dtp = dateTimeParser();
        private static final DateTimeFormatter dotp = dateOptionalTimeParser();
        private static final DateTimeFormatter ldotp = localDateOptionalTimeParser();

        Constants() {
        }

        private static DateTimeFormatter dateParser() {
            DateTimeFormatter dateTimeFormatter = f2808dp;
            if (dateTimeFormatter != null) {
                return dateTimeFormatter;
            }
            return new DateTimeFormatterBuilder().append(dateElementParser()).appendOptional(new DateTimeFormatterBuilder().appendLiteral('T').append(offsetElement()).toParser()).toFormatter();
        }

        private static DateTimeFormatter localDateParser() {
            DateTimeFormatter dateTimeFormatter = ldp;
            return dateTimeFormatter == null ? dateElementParser().withZoneUTC() : dateTimeFormatter;
        }

        private static DateTimeFormatter dateElementParser() {
            DateTimeFormatter dateTimeFormatter = dpe;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append((DateTimePrinter) null, new DateTimeParser[]{new DateTimeFormatterBuilder().append(yearElement()).appendOptional(new DateTimeFormatterBuilder().append(monthElement()).appendOptional(dayOfMonthElement().getParser()).toParser()).toParser(), new DateTimeFormatterBuilder().append(weekyearElement()).append(weekElement()).appendOptional(dayOfWeekElement().getParser()).toParser(), new DateTimeFormatterBuilder().append(yearElement()).append(dayOfYearElement()).toParser()}).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter timeParser() {
            DateTimeFormatter dateTimeFormatter = f2813tp;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendOptional(literalTElement().getParser()).append(timeElementParser()).appendOptional(offsetElement().getParser()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter localTimeParser() {
            DateTimeFormatter dateTimeFormatter = ltp;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendOptional(literalTElement().getParser()).append(timeElementParser()).toFormatter().withZoneUTC() : dateTimeFormatter;
        }

        private static DateTimeFormatter timeElementParser() {
            DateTimeFormatter dateTimeFormatter = tpe;
            if (dateTimeFormatter != null) {
                return dateTimeFormatter;
            }
            DateTimeParser parser = new DateTimeFormatterBuilder().append((DateTimePrinter) null, new DateTimeParser[]{new DateTimeFormatterBuilder().appendLiteral('.').toParser(), new DateTimeFormatterBuilder().appendLiteral(AbstractJsonLexerKt.COMMA).toParser()}).toParser();
            return new DateTimeFormatterBuilder().append(hourElement()).append((DateTimePrinter) null, new DateTimeParser[]{new DateTimeFormatterBuilder().append(minuteElement()).append((DateTimePrinter) null, new DateTimeParser[]{new DateTimeFormatterBuilder().append(secondElement()).appendOptional(new DateTimeFormatterBuilder().append(parser).appendFractionOfSecond(1, 9).toParser()).toParser(), new DateTimeFormatterBuilder().append(parser).appendFractionOfMinute(1, 9).toParser(), null}).toParser(), new DateTimeFormatterBuilder().append(parser).appendFractionOfHour(1, 9).toParser(), null}).toFormatter();
        }

        private static DateTimeFormatter dateTimeParser() {
            DateTimeFormatter dateTimeFormatter = dtp;
            if (dateTimeFormatter != null) {
                return dateTimeFormatter;
            }
            return new DateTimeFormatterBuilder().append((DateTimePrinter) null, new DateTimeParser[]{new DateTimeFormatterBuilder().appendLiteral('T').append(timeElementParser()).appendOptional(offsetElement().getParser()).toParser(), dateOptionalTimeParser().getParser()}).toFormatter();
        }

        private static DateTimeFormatter dateOptionalTimeParser() {
            DateTimeFormatter dateTimeFormatter = dotp;
            if (dateTimeFormatter != null) {
                return dateTimeFormatter;
            }
            return new DateTimeFormatterBuilder().append(dateElementParser()).appendOptional(new DateTimeFormatterBuilder().appendLiteral('T').appendOptional(timeElementParser().getParser()).appendOptional(offsetElement().getParser()).toParser()).toFormatter();
        }

        private static DateTimeFormatter localDateOptionalTimeParser() {
            DateTimeFormatter dateTimeFormatter = ldotp;
            if (dateTimeFormatter != null) {
                return dateTimeFormatter;
            }
            return new DateTimeFormatterBuilder().append(dateElementParser()).appendOptional(new DateTimeFormatterBuilder().appendLiteral('T').append(timeElementParser()).toParser()).toFormatter().withZoneUTC();
        }

        private static DateTimeFormatter time() {
            DateTimeFormatter dateTimeFormatter = f2812t;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(hourMinuteSecondFraction()).append(offsetElement()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter timeNoMillis() {
            DateTimeFormatter dateTimeFormatter = f2815tx;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(hourMinuteSecond()).append(offsetElement()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter tTime() {
            DateTimeFormatter dateTimeFormatter = f2814tt;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(literalTElement()).append(time()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter tTimeNoMillis() {
            DateTimeFormatter dateTimeFormatter = ttx;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(literalTElement()).append(timeNoMillis()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter dateTime() {
            DateTimeFormatter dateTimeFormatter = f2809dt;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(ISODateTimeFormat.date()).append(tTime()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter dateTimeNoMillis() {
            DateTimeFormatter dateTimeFormatter = dtx;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(ISODateTimeFormat.date()).append(tTimeNoMillis()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter ordinalDate() {
            DateTimeFormatter dateTimeFormatter = f2811od;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(yearElement()).append(dayOfYearElement()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter ordinalDateTime() {
            DateTimeFormatter dateTimeFormatter = odt;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(ordinalDate()).append(tTime()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter ordinalDateTimeNoMillis() {
            DateTimeFormatter dateTimeFormatter = odtx;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(ordinalDate()).append(tTimeNoMillis()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter weekDateTime() {
            DateTimeFormatter dateTimeFormatter = wdt;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(ISODateTimeFormat.weekDate()).append(tTime()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter weekDateTimeNoMillis() {
            DateTimeFormatter dateTimeFormatter = wdtx;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(ISODateTimeFormat.weekDate()).append(tTimeNoMillis()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter basicDate() {
            DateTimeFormatter dateTimeFormatter = f2805bd;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendYear(4, 4).appendFixedDecimal(DateTimeFieldType.monthOfYear(), 2).appendFixedDecimal(DateTimeFieldType.dayOfMonth(), 2).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter basicTime() {
            DateTimeFormatter dateTimeFormatter = f2806bt;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendFixedDecimal(DateTimeFieldType.hourOfDay(), 2).appendFixedDecimal(DateTimeFieldType.minuteOfHour(), 2).appendFixedDecimal(DateTimeFieldType.secondOfMinute(), 2).appendLiteral('.').appendFractionOfSecond(3, 9).appendTimeZoneOffset("Z", false, 2, 2).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter basicTimeNoMillis() {
            DateTimeFormatter dateTimeFormatter = btx;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendFixedDecimal(DateTimeFieldType.hourOfDay(), 2).appendFixedDecimal(DateTimeFieldType.minuteOfHour(), 2).appendFixedDecimal(DateTimeFieldType.secondOfMinute(), 2).appendTimeZoneOffset("Z", false, 2, 2).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter basicTTime() {
            DateTimeFormatter dateTimeFormatter = btt;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(literalTElement()).append(basicTime()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter basicTTimeNoMillis() {
            DateTimeFormatter dateTimeFormatter = bttx;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(literalTElement()).append(basicTimeNoMillis()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter basicDateTime() {
            DateTimeFormatter dateTimeFormatter = bdt;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(basicDate()).append(basicTTime()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter basicDateTimeNoMillis() {
            DateTimeFormatter dateTimeFormatter = bdtx;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(basicDate()).append(basicTTimeNoMillis()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter basicOrdinalDate() {
            DateTimeFormatter dateTimeFormatter = bod;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendYear(4, 4).appendFixedDecimal(DateTimeFieldType.dayOfYear(), 3).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter basicOrdinalDateTime() {
            DateTimeFormatter dateTimeFormatter = bodt;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(basicOrdinalDate()).append(basicTTime()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter basicOrdinalDateTimeNoMillis() {
            DateTimeFormatter dateTimeFormatter = bodtx;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(basicOrdinalDate()).append(basicTTimeNoMillis()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter basicWeekDate() {
            DateTimeFormatter dateTimeFormatter = bwd;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendWeekyear(4, 4).appendLiteral('W').appendFixedDecimal(DateTimeFieldType.weekOfWeekyear(), 2).appendFixedDecimal(DateTimeFieldType.dayOfWeek(), 1).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter basicWeekDateTime() {
            DateTimeFormatter dateTimeFormatter = bwdt;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(basicWeekDate()).append(basicTTime()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter basicWeekDateTimeNoMillis() {
            DateTimeFormatter dateTimeFormatter = bwdtx;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(basicWeekDate()).append(basicTTimeNoMillis()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter yearMonth() {
            DateTimeFormatter dateTimeFormatter = f2819ym;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(yearElement()).append(monthElement()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter yearMonthDay() {
            DateTimeFormatter dateTimeFormatter = ymd;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(yearElement()).append(monthElement()).append(dayOfMonthElement()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter weekyearWeek() {
            DateTimeFormatter dateTimeFormatter = f2817ww;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(weekyearElement()).append(weekElement()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter weekyearWeekDay() {
            DateTimeFormatter dateTimeFormatter = wwd;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(weekyearElement()).append(weekElement()).append(dayOfWeekElement()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter hourMinute() {
            DateTimeFormatter dateTimeFormatter = f2810hm;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(hourElement()).append(minuteElement()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter hourMinuteSecond() {
            DateTimeFormatter dateTimeFormatter = hms;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(hourElement()).append(minuteElement()).append(secondElement()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter hourMinuteSecondMillis() {
            DateTimeFormatter dateTimeFormatter = hmsl;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(hourElement()).append(minuteElement()).append(secondElement()).appendLiteral('.').appendFractionOfSecond(3, 3).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter hourMinuteSecondFraction() {
            DateTimeFormatter dateTimeFormatter = hmsf;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(hourElement()).append(minuteElement()).append(secondElement()).append(fractionElement()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter dateHour() {
            DateTimeFormatter dateTimeFormatter = f2807dh;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(ISODateTimeFormat.date()).append(literalTElement()).append(ISODateTimeFormat.hour()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter dateHourMinute() {
            DateTimeFormatter dateTimeFormatter = dhm;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(ISODateTimeFormat.date()).append(literalTElement()).append(hourMinute()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter dateHourMinuteSecond() {
            DateTimeFormatter dateTimeFormatter = dhms;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(ISODateTimeFormat.date()).append(literalTElement()).append(hourMinuteSecond()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter dateHourMinuteSecondMillis() {
            DateTimeFormatter dateTimeFormatter = dhmsl;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(ISODateTimeFormat.date()).append(literalTElement()).append(hourMinuteSecondMillis()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter dateHourMinuteSecondFraction() {
            DateTimeFormatter dateTimeFormatter = dhmsf;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().append(ISODateTimeFormat.date()).append(literalTElement()).append(hourMinuteSecondFraction()).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter yearElement() {
            DateTimeFormatter dateTimeFormatter = f2818ye;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendYear(4, 9).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter monthElement() {
            DateTimeFormatter dateTimeFormatter = mye;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendLiteral(Soundex.SILENT_MARKER).appendMonthOfYear(2).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter dayOfMonthElement() {
            DateTimeFormatter dateTimeFormatter = dme;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendLiteral(Soundex.SILENT_MARKER).appendDayOfMonth(2).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter weekyearElement() {
            DateTimeFormatter dateTimeFormatter = f2816we;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendWeekyear(4, 9).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter weekElement() {
            DateTimeFormatter dateTimeFormatter = wwe;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendLiteral("-W").appendWeekOfWeekyear(2).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter dayOfWeekElement() {
            DateTimeFormatter dateTimeFormatter = dwe;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendLiteral(Soundex.SILENT_MARKER).appendDayOfWeek(1).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter dayOfYearElement() {
            DateTimeFormatter dateTimeFormatter = dye;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendLiteral(Soundex.SILENT_MARKER).appendDayOfYear(3).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter literalTElement() {
            DateTimeFormatter dateTimeFormatter = lte;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendLiteral('T').toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter hourElement() {
            DateTimeFormatter dateTimeFormatter = hde;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendHourOfDay(2).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter minuteElement() {
            DateTimeFormatter dateTimeFormatter = mhe;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendLiteral(AbstractJsonLexerKt.COLON).appendMinuteOfHour(2).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter secondElement() {
            DateTimeFormatter dateTimeFormatter = sme;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendLiteral(AbstractJsonLexerKt.COLON).appendSecondOfMinute(2).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter fractionElement() {
            DateTimeFormatter dateTimeFormatter = fse;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendLiteral('.').appendFractionOfSecond(3, 9).toFormatter() : dateTimeFormatter;
        }

        private static DateTimeFormatter offsetElement() {
            DateTimeFormatter dateTimeFormatter = f2820ze;
            return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendTimeZoneOffset("Z", true, 2, 4).toFormatter() : dateTimeFormatter;
        }
    }
}
