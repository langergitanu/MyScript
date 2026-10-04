package aws.smithy.kotlin.runtime.time;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import aws.smithy.kotlin.runtime.time.Needed;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: ParserCombinators.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000j\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aW\u0010\u0013\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00110\rj\b\u0012\u0004\u0012\u00020\b`\u00122\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001aW\u0010\u0016\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00110\rj\b\u0012\u0004\u0012\u00020\b`\u00122\u0006\u0010\u0015\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001aW\u0010\u0019\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00110\rj\b\u0012\u0004\u0012\u00020\u0000`\u00122\u0006\u0010\u0018\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0019\u0010\u0017\u001ac\u0010\u001d\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00110\rj\b\u0012\u0004\u0012\u00020\u001c`\u00122\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u001aH\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001as\u0010!\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00110\rj\b\u0012\u0004\u0012\u00020\u001c`\u00122\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u001aH\u0000¢\u0006\u0004\b!\u0010\"\u001a/\u0010%\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0000H\u0002¢\u0006\u0004\b%\u0010&\u001a\u0083\u0001\u0010*\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\rj\b\u0012\u0004\u0012\u00028\u0000`\u0012\"\b\b\u0000\u0010(*\u00020'2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0018\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00028\u00000\rH\u0000¢\u0006\u0004\b*\u0010+\u001a_\u0010,\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\rj\b\u0012\u0004\u0012\u00020\u0002`\u00122\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0002H\u0000¢\u0006\u0004\b,\u0010-\u001a_\u0010/\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u00110\rj\b\u0012\u0004\u0012\u00020.`\u00122\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0002H\u0000¢\u0006\u0004\b/\u0010-\u001aW\u00100\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\rj\b\u0012\u0004\u0012\u00020\u0002`\u00122\u0006\u0010 \u001a\u00020\u0002H\u0000¢\u0006\u0004\b0\u00101\u001ag\u00103\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\rj\b\u0012\u0004\u0012\u00020\u0002`\u00122\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u00102\u001a\u00020\u001cH\u0000¢\u0006\u0004\b3\u00104\u001a_\u00105\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\rj\b\u0012\u0004\u0012\u00020\u0002`\u00122\u0006\u0010 \u001a\u00020\u00022\u0006\u00102\u001a\u00020\u001cH\u0000¢\u0006\u0004\b5\u00106\u001ag\u00108\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\rj\b\u0012\u0004\u0012\u00020\u0002`\u00122\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0000¢\u0006\u0004\b8\u00109\u001a¡\u0001\u0010;\u001aF\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00110\rj\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0012\"\u0004\b\u0000\u0010(2F\u0010:\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\rj\b\u0012\u0004\u0012\u00028\u0000`\u0012H\u0000¢\u0006\u0004\b;\u0010<\u001a¥\u0001\u0010>\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\rj\b\u0012\u0004\u0012\u00028\u0000`\u0012\"\u0004\b\u0000\u0010(2F\u0010:\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\rj\b\u0012\u0004\u0012\u00028\u0000`\u00122\u0006\u0010=\u001a\u00028\u0000H\u0000¢\u0006\u0004\b>\u0010?\u001aê\u0001\u0010B\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\rj\b\u0012\u0004\u0012\u00028\u0000`\u0012\"\u0004\b\u0000\u0010(2\u0092\u0001\u0010A\u001aJ\u0012F\b\u0001\u0012B\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\rj\b\u0012\u0004\u0012\u00028\u0000`\u00120@\"B\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\rj\b\u0012\u0004\u0012\u00028\u0000`\u0012H\u0000¢\u0006\u0004\bB\u0010C\u001aë\u0001\u0010G\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00110\rj\b\u0012\u0004\u0012\u00028\u0001`\u0012\"\u0004\b\u0000\u0010(\"\u0004\b\u0001\u0010D2F\u0010E\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\rj\b\u0012\u0004\u0012\u00028\u0000`\u00122F\u0010F\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00110\rj\b\u0012\u0004\u0012\u00028\u0001`\u0012H\u0000¢\u0006\u0004\bG\u0010H\u001a·\u0001\u0010J\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00110\rj\b\u0012\u0004\u0012\u00028\u0001`\u0012\"\u0004\b\u0000\u0010(\"\u0004\b\u0001\u0010D2F\u0010:\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\rj\b\u0012\u0004\u0012\u00028\u0000`\u00122\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001aH\u0000¢\u0006\u0004\bJ\u0010K\u001a©\u0001\u0010M\u001aF\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00110\rj\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0012\"\u0004\b\u0000\u0010(2\u0006\u0010L\u001a\u00020\n2F\u0010:\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\rj\b\u0012\u0004\u0012\u00028\u0000`\u0012H\u0000¢\u0006\u0004\bM\u0010N\u001aÿ\u0001\u0010Q\u001aZ\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010P0\u00110\rj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010P`\u0012\"\u0004\b\u0000\u0010(\"\u0004\b\u0001\u0010D*B\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\rj\b\u0012\u0004\u0012\u00028\u0000`\u00122F\u0010O\u001aB\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00110\rj\b\u0012\u0004\u0012\u00028\u0001`\u0012H\u0000¢\u0006\u0004\bQ\u0010H*~\b\u0000\u0010R\u001a\u0004\b\u0000\u0010(\"8\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\r28\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\r¨\u0006S"}, m1599d2 = {"", "input", "", "pos", "need", "", "precond", "(Ljava/lang/String;II)V", "", "chr", "", "isDigit", "(C)Z", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "str", "Laws/smithy/kotlin/runtime/time/ParseResult;", "Laws/smithy/kotlin/runtime/time/Parser;", "char", "(C)Lkotlin/jvm/functions/Function2;", "chars", "oneOf", "(Ljava/lang/String;)Lkotlin/jvm/functions/Function2;", "match", "tag", "Lkotlin/Function1;", "predicate", "Lkotlin/ranges/IntRange;", "takeTill", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function2;", CmcdData.OBJECT_TYPE_MANIFEST, "n", "takeWhileMN", "(IILkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function2;", "expected", NotificationCompat.CATEGORY_MESSAGE, "fmtTakeWhileErrorMsg", "(IIILjava/lang/String;)Ljava/lang/String;", "", ExifInterface.GPS_DIRECTION_TRUE, "transform", "takeMNDigitsT", "(IILkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "takeMNDigitsInt", "(II)Lkotlin/jvm/functions/Function2;", "", "takeMNDigitsLong", "takeNDigits", "(I)Lkotlin/jvm/functions/Function2;", "range", "mnDigitsInRange", "(IILkotlin/ranges/IntRange;)Lkotlin/jvm/functions/Function2;", "nDigitsInRange", "(ILkotlin/ranges/IntRange;)Lkotlin/jvm/functions/Function2;", "denomDigits", "fraction", "(III)Lkotlin/jvm/functions/Function2;", "parser", "optional", "(Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "or", "optionalOr", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;)Lkotlin/jvm/functions/Function2;", "", "parsers", "alt", "([Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", ExifInterface.LATITUDE_SOUTH, "pre", "post", "preceded", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "block", "map", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function2;", "condition", "cond", "(ZLkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "next", "Lkotlin/Pair;", "then", "Parser", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ParserCombinatorsKt {
    public static final boolean isDigit(char c) {
        return '0' <= c && c < ':';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object optionalOr$lambda$0(Object obj, Object obj2) {
        return obj2 == null ? obj : obj2;
    }

    public static /* synthetic */ void precond$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        precond(str, i, i2);
    }

    public static final void precond(String input, int i, int i2) {
        Needed.Size size;
        Intrinsics.checkNotNullParameter(input, "input");
        if (i2 == 0) {
            if (i < input.length()) {
                return;
            }
        } else if (i + i2 <= input.length()) {
            return;
        }
        if (i2 == 0) {
            size = Needed.Unknown.INSTANCE;
        } else {
            size = new Needed.Size(i2);
        }
        throw new IncompleteException(input, size);
    }

    /* JADX INFO: renamed from: char, reason: not valid java name */
    public static final Function2<String, Integer, ParseResult<Character>> m12299char(final char c) {
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParserCombinatorsKt.char$lambda$0(c, (String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult char$lambda$0(char c, String str, int i) {
        Intrinsics.checkNotNullParameter(str, "str");
        precond(str, i, 1);
        char cCharAt = str.charAt(i);
        if (cCharAt != c) {
            throw new ParseException(str, "expected `" + c + "` found `" + cCharAt + '`', i);
        }
        return new ParseResult(i + 1, Character.valueOf(cCharAt));
    }

    public static final Function2<String, Integer, ParseResult<Character>> oneOf(final String chars) {
        Intrinsics.checkNotNullParameter(chars, "chars");
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParserCombinatorsKt.oneOf$lambda$0(chars, (String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult oneOf$lambda$0(String str, String str2, int i) {
        ParseResult parseResult;
        Intrinsics.checkNotNullParameter(str2, "str");
        precond(str2, i, 1);
        char cCharAt = str2.charAt(i);
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                parseResult = null;
                break;
            }
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 == cCharAt) {
                parseResult = new ParseResult(i + 1, Character.valueOf(cCharAt2));
                break;
            }
            i2++;
        }
        if (parseResult != null) {
            return parseResult;
        }
        throw new ParseException(str2, "expected one of `" + str + "` found " + cCharAt, i);
    }

    public static final Function2<String, Integer, ParseResult<String>> tag(final String match) {
        Intrinsics.checkNotNullParameter(match, "match");
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParserCombinatorsKt.tag$lambda$0(match, (String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult tag$lambda$0(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str2, "str");
        precond(str2, i, str.length());
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (str2.charAt(i + i2) != str.charAt(i2)) {
                StringBuilder sbAppend = new StringBuilder("expected `").append(str).append("` found `");
                String strSubstring = str2.substring(i, str.length() + i);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                throw new ParseException(str2, sbAppend.append(strSubstring).append('`').toString(), i);
            }
        }
        return new ParseResult(i + str.length(), str);
    }

    public static final Function2<String, Integer, ParseResult<IntRange>> takeTill(final Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParserCombinatorsKt.takeTill$lambda$0(predicate, (String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult takeTill$lambda$0(Function1 function1, String str, int i) {
        Intrinsics.checkNotNullParameter(str, "str");
        precond$default(str, i, 0, 4, null);
        int i2 = i;
        while (i2 < str.length() && !((Boolean) function1.invoke(Character.valueOf(str.charAt(i2)))).booleanValue()) {
            i2++;
        }
        if (i2 == str.length()) {
            throw new IncompleteException(str, Needed.Unknown.INSTANCE);
        }
        return new ParseResult(i2, RangesKt.until(i, i2));
    }

    public static final Function2<String, Integer, ParseResult<IntRange>> takeWhileMN(final int i, final int i2, final Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParserCombinatorsKt.takeWhileMN$lambda$0(i2, i, predicate, (String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult takeWhileMN$lambda$0(int i, int i2, Function1 function1, String str, int i3) {
        Intrinsics.checkNotNullParameter(str, "str");
        if (i < i2) {
            throw new IllegalArgumentException(("min m=" + i2 + " cannot be greater than max=" + i).toString());
        }
        precond$default(str, i3, 0, 4, null);
        int i4 = i3;
        while (i4 < str.length() && i4 - i3 < i && ((Boolean) function1.invoke(Character.valueOf(str.charAt(i4)))).booleanValue()) {
            i4++;
        }
        int i5 = i4 - i3;
        if (i5 < i2) {
            if (i4 >= str.length()) {
                throw new IncompleteException(str, new Needed.Size(i2 - i5));
            }
            throw new TakeWhileMNException(str, i4, i2, i5);
        }
        return new ParseResult(i4, new IntRange(i3, i4 - 1));
    }

    private static final String fmtTakeWhileErrorMsg(int i, int i2, int i3, String str) {
        return "expected " + (i == i2 ? "exactly" : "at least") + TokenParser.f2383SP + i3 + " digits; " + str;
    }

    public static final <T extends Number> Function2<String, Integer, ParseResult<T>> takeMNDigitsT(final int i, final int i2, final Function2<? super String, ? super IntRange, ? extends T> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParserCombinatorsKt.takeMNDigitsT$lambda$0(i, i2, transform, (String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult takeMNDigitsT$lambda$0(int i, int i2, Function2 function2, String str, int i3) {
        Intrinsics.checkNotNullParameter(str, "str");
        precond$default(str, i3, 0, 4, null);
        try {
            ParseResult<IntRange> parseResultInvoke = takeWhileMN(i, i2, ParserCombinatorsKt$takeMNDigitsT$1$1.INSTANCE).invoke(str, Integer.valueOf(i3));
            int pos = parseResultInvoke.getPos();
            IntRange intRangeComponent2 = parseResultInvoke.component2();
            if (intRangeComponent2.isEmpty()) {
                throw new ParseException(str, "expected integer", i3);
            }
            return new ParseResult(pos, (Number) function2.invoke(str, intRangeComponent2));
        } catch (IncompleteException e) {
            throw new ParseException(str, fmtTakeWhileErrorMsg(i, i2, i, String.valueOf(e.getNeeded())), i3);
        } catch (TakeWhileMNException e2) {
            throw new ParseException(str, fmtTakeWhileErrorMsg(i, i2, e2.getExpected(), "found " + e2.getMatched()), i3);
        }
    }

    public static final Function2<String, Integer, ParseResult<Integer>> takeMNDigitsInt(int i, int i2) {
        return takeMNDigitsT(i, i2, new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(ParserCombinatorsKt.takeMNDigitsInt$lambda$0((String) obj, (IntRange) obj2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int takeMNDigitsInt$lambda$0(String str, IntRange range) {
        Intrinsics.checkNotNullParameter(str, "str");
        Intrinsics.checkNotNullParameter(range, "range");
        return Integer.parseInt(StringsKt.substring(str, range));
    }

    public static final Function2<String, Integer, ParseResult<Long>> takeMNDigitsLong(int i, int i2) {
        return takeMNDigitsT(i, i2, new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Long.valueOf(ParserCombinatorsKt.takeMNDigitsLong$lambda$0((String) obj, (IntRange) obj2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long takeMNDigitsLong$lambda$0(String str, IntRange range) {
        Intrinsics.checkNotNullParameter(str, "str");
        Intrinsics.checkNotNullParameter(range, "range");
        return Long.parseLong(StringsKt.substring(str, range));
    }

    public static final Function2<String, Integer, ParseResult<Integer>> takeNDigits(int i) {
        return takeMNDigitsInt(i, i);
    }

    public static final Function2<String, Integer, ParseResult<Integer>> mnDigitsInRange(final int i, final int i2, final IntRange range) {
        Intrinsics.checkNotNullParameter(range, "range");
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParserCombinatorsKt.mnDigitsInRange$lambda$0(i, i2, range, (String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult mnDigitsInRange$lambda$0(int i, int i2, IntRange intRange, String str, int i3) {
        Intrinsics.checkNotNullParameter(str, "str");
        precond$default(str, i3, 0, 4, null);
        ParseResult<Integer> parseResultInvoke = takeMNDigitsInt(i, i2).invoke(str, Integer.valueOf(i3));
        int pos = parseResultInvoke.getPos();
        int iIntValue = parseResultInvoke.component2().intValue();
        if (!intRange.contains(iIntValue)) {
            throw new ParseException(str, iIntValue + " not in range " + intRange, i3);
        }
        return new ParseResult(pos, Integer.valueOf(iIntValue));
    }

    public static final Function2<String, Integer, ParseResult<Integer>> nDigitsInRange(int i, IntRange range) {
        Intrinsics.checkNotNullParameter(range, "range");
        return mnDigitsInRange(i, i, range);
    }

    public static final Function2<String, Integer, ParseResult<Integer>> fraction(final int i, final int i2, final int i3) {
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParserCombinatorsKt.fraction$lambda$0(i3, i2, i, (String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult fraction$lambda$0(int i, int i2, int i3, String str, int i4) {
        Intrinsics.checkNotNullParameter(str, "str");
        if (i > i2) {
            throw new IllegalArgumentException(("denomDigits (" + i + ") must be less than max=" + i2 + " digits to parse").toString());
        }
        precond$default(str, i4, 0, 4, null);
        ParseResult<IntRange> parseResultInvoke = takeWhileMN(i3, i2, ParserCombinatorsKt$fraction$1$2.INSTANCE).invoke(str, Integer.valueOf(i4));
        int pos = parseResultInvoke.getPos();
        IntRange intRangeComponent2 = parseResultInvoke.component2();
        if (intRangeComponent2.isEmpty()) {
            throw new ParseException(str, "expected integer", i4);
        }
        int i5 = Integer.parseInt(StringsKt.substring(str, intRangeComponent2));
        for (int last = intRangeComponent2.getLast() - intRangeComponent2.getFirst(); last < i - 1; last++) {
            i5 *= 10;
        }
        return new ParseResult(pos, Integer.valueOf(i5));
    }

    public static final <T> Function2<String, Integer, ParseResult<T>> optional(final Function2<? super String, ? super Integer, ? extends ParseResult<? extends T>> parser) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParserCombinatorsKt.optional$lambda$0(parser, (String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult optional$lambda$0(Function2 function2, String str, int i) {
        Intrinsics.checkNotNullParameter(str, "str");
        try {
            return (ParseResult) function2.invoke(str, Integer.valueOf(i));
        } catch (ParseException unused) {
            return new ParseResult(i, null);
        }
    }

    public static final <T> Function2<String, Integer, ParseResult<T>> optionalOr(Function2<? super String, ? super Integer, ? extends ParseResult<? extends T>> parser, final T t) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        return map(optional(parser), new Function1() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ParserCombinatorsKt.optionalOr$lambda$0(t, obj);
            }
        });
    }

    public static final <T> Function2<String, Integer, ParseResult<T>> alt(final Function2<? super String, ? super Integer, ? extends ParseResult<? extends T>>... parsers) {
        Intrinsics.checkNotNullParameter(parsers, "parsers");
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParserCombinatorsKt.alt$lambda$0(parsers, (String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult alt$lambda$0(Function2[] function2Arr, String str, int i) {
        ParseResult parseResult;
        Intrinsics.checkNotNullParameter(str, "str");
        int length = function2Arr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                parseResult = null;
                break;
            }
            try {
                parseResult = (ParseResult) function2Arr[i2].invoke(str, Integer.valueOf(i));
                break;
            } catch (ParseException unused) {
                i2++;
            }
        }
        if (parseResult != null) {
            return parseResult;
        }
        throw new ParseException(str, "no alternatives matched", i);
    }

    public static final <T, S> Function2<String, Integer, ParseResult<S>> preceded(final Function2<? super String, ? super Integer, ? extends ParseResult<? extends T>> pre, final Function2<? super String, ? super Integer, ? extends ParseResult<? extends S>> post) {
        Intrinsics.checkNotNullParameter(pre, "pre");
        Intrinsics.checkNotNullParameter(post, "post");
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParserCombinatorsKt.preceded$lambda$0(pre, post, (String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult preceded$lambda$0(Function2 function2, Function2 function22, String str, int i) {
        Intrinsics.checkNotNullParameter(str, "str");
        return (ParseResult) function22.invoke(str, Integer.valueOf(((ParseResult) function2.invoke(str, Integer.valueOf(i))).getPos()));
    }

    public static final <T, S> Function2<String, Integer, ParseResult<S>> map(final Function2<? super String, ? super Integer, ? extends ParseResult<? extends T>> parser, final Function1<? super T, ? extends S> block) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(block, "block");
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParserCombinatorsKt.map$lambda$0(parser, block, (String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult map$lambda$0(Function2 function2, Function1 function1, String str, int i) {
        Intrinsics.checkNotNullParameter(str, "str");
        ParseResult parseResult = (ParseResult) function2.invoke(str, Integer.valueOf(i));
        return new ParseResult(parseResult.getPos(), function1.invoke(parseResult.component2()));
    }

    public static final <T> Function2<String, Integer, ParseResult<T>> cond(final boolean z, final Function2<? super String, ? super Integer, ? extends ParseResult<? extends T>> parser) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParserCombinatorsKt.cond$lambda$0(z, parser, (String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult cond$lambda$0(boolean z, Function2 function2, String str, int i) {
        Intrinsics.checkNotNullParameter(str, "str");
        if (z) {
            return (ParseResult) function2.invoke(str, Integer.valueOf(i));
        }
        return new ParseResult(i, null);
    }

    public static final <T, S> Function2<String, Integer, ParseResult<Pair<T, S>>> then(final Function2<? super String, ? super Integer, ? extends ParseResult<? extends T>> function2, final Function2<? super String, ? super Integer, ? extends ParseResult<? extends S>> next) {
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(next, "next");
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParserCombinatorsKt.then$lambda$0(function2, next, (String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult then$lambda$0(Function2 function2, Function2 function22, String str, int i) {
        Intrinsics.checkNotNullParameter(str, "str");
        ParseResult parseResult = (ParseResult) function2.invoke(str, Integer.valueOf(i));
        int pos = parseResult.getPos();
        Object objComponent2 = parseResult.component2();
        ParseResult parseResult2 = (ParseResult) function22.invoke(str, Integer.valueOf(pos));
        return new ParseResult(parseResult2.getPos(), new Pair(objComponent2, parseResult2.component2()));
    }
}
