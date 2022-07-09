package de.exlll.configlib.configurations;

import de.exlll.configlib.TestUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static de.exlll.configlib.TestUtils.*;
import static java.util.Arrays.asList;

public final class ExampleConfigurationsSerialized {
    public static final Map<String, ?> EXAMPLE_CONFIGURATION_B1_1 = entriesAsMap(
            entry("b1_primBool", true),
            entry("b1_refChar", "b"),
            entry("b1_string", "c"),
            entry("b1_listByte", List.of(1L, 2L, 3L)),
            entry("b1_arrayShort", List.of(1L, 2L, 3L)),
            entry("b1_setInteger", asList(1L, 2L, 3L)),
            entry("b1_listEmpty", Collections.emptyList()),
            entry("b1_mapLongLong", asMap(1L, 2L, 3L, 4L)),
            entry("b1_listListByte", List.of(
                    List.of(1L, 2L, 3L),
                    List.of(2L, 3L, 4L)
            )),
            entry("b1_point", "1:2")
    );
    public static final Map<String, ?> EXAMPLE_CONFIGURATION_B1_2 = entriesAsMap(
            entry("b1_primBool", false),
            entry("b1_refChar", "c"),
            entry("b1_string", "d"),
            entry("b1_listByte", List.of(2L, 3L, 4L)),
            entry("b1_arrayShort", List.of(2L, 3L, 4L)),
            entry("b1_setInteger", asList(2L, 3L, 4L)),
            entry("b1_listEmpty", Collections.emptyList()),
            entry("b1_mapLongLong", asMap(2L, 3L, 4L, 5L)),
            entry("b1_listListByte", List.of(
                    List.of(2L, 3L, 4L),
                    List.of(3L, 4L, 5L)
            )),
            entry("b1_point", "1:3")
    );
    public static final Map<String, ?> EXAMPLE_CONFIGURATION_B2_1 = extend(EXAMPLE_CONFIGURATION_B1_1,
            entry("b2_primChar", "a"),
            entry("b2_refBool", true),
            entry("b2_bigInteger", "1"),
            entry("b2_listShort", List.of(2L, 3L, 4L)),
            entry("b2_arrayInteger", List.of(2L, 3L, 4L)),
            entry("b2_setLong", asList(2L, 3L, 4L)),
            entry("b2_arrayEmpty", Collections.emptyList()),
            entry("b2_mapFloatFloat", asMap(1d, 2d, 3d, 4d)),
            entry("b2_setArrayDouble", asList(
                    List.of(1d, 2d, 3d, 4d),
                    List.of(5d, 6d, 7d, 8d)
            )),
            entry("b2_listPoint", List.of("1:2", "3:4"))
    );
    public static final Map<String, ?> EXAMPLE_CONFIGURATION_B2_2 = extend(EXAMPLE_CONFIGURATION_B1_2,
            entry("b2_primChar", "b"),
            entry("b2_refBool", false),
            entry("b2_bigInteger", "2"),
            entry("b2_listShort", List.of(3L, 4L, 5L)),
            entry("b2_arrayInteger", List.of(3L, 4L, 5L)),
            entry("b2_setLong", asList(3L, 4L, 5L)),
            entry("b2_arrayEmpty", Collections.emptyList()),
            entry("b2_mapFloatFloat", asMap(2d, 3d, 4d, 5d)),
            entry("b2_setArrayDouble", asList(
                    List.of(2d, 3d, 4d, 5d),
                    List.of(6d, 7d, 8d, 9d)
            )),
            entry("b2_listPoint", List.of("2:3", "4:5"))
    );
    public static final Map<String, ?> EXAMPLE_CONFIGURATION_A1 = TestUtils.entriesAsMap(
            entry("a1_primBool", true),
            entry("a1_primChar", "a"),
            entry("a1_primByte", 1L),
            entry("a1_primShort", 3L),
            entry("a1_primInt", 5L),
            entry("a1_primLong", 7L),
            entry("a1_primFloat", 9d),
            entry("a1_primDouble", 11d),
            entry("a1_refBool", true),
            entry("a1_refChar", "c"),
            entry("a1_refByte", 13L),
            entry("a1_refShort", 15L),
            entry("a1_refInt", 17L),
            entry("a1_refLong", 19L),
            entry("a1_refFloat", 21d),
            entry("a1_refDouble", 23d),
            entry("a1_string", "a"),
            entry("a1_bigInteger", "1"),
            entry("a1_bigDecimal", "1"),
            entry("a1_localDate", "2000-01-01"),
            entry("a1_localTime", "00:01"),
            entry("a1_localDateTime", "2000-01-01T00:00"),
            entry("a1_uuid", "d50f3bdd-ac66-4b74-a01f-4617b24d68c0"),
            entry("a1_Enm", "A"),
            entry("a1_b1", EXAMPLE_CONFIGURATION_B1_1),
            entry("a1_b2", EXAMPLE_CONFIGURATION_B2_1),
            entry("a1_listBoolean", List.of(true, false, true)),
            entry("a1_listChar", List.of("a", "b", "c")),
            entry("a1_listByte", List.of(1L, 2L, 3L)),
            entry("a1_listShort", List.of(1L, 2L, 3L)),
            entry("a1_listInteger", List.of(1L, 2L, 3L)),
            entry("a1_listLong", List.of(1L, 2L, 3L)),
            entry("a1_listFloat", List.of(1d, 2d, 3d)),
            entry("a1_listDouble", List.of(1d, 2d, 3d)),
            entry("a1_listString", List.of("1", "2", "3")),
            entry("a1_listBigInteger", List.of("1", "2", "3")),
            entry("a1_listBigDecimal", List.of("1", "2", "3")),
            entry("a1_listLocalDate", List.of("2000-01-01", "2000-01-02", "2000-01-03")),
            entry("a1_listLocalTime", List.of("00:01", "00:02", "00:03")),
            entry("a1_listLocalDateTime", List.of("2000-01-01T00:00", "2000-01-02T00:00", "2000-01-03T00:00")),
            entry("a1_listUuid", List.of("d50f3bdd-ac66-4b74-a01f-4617b24d68c0", "d50f3bdd-ac66-4b74-a01f-4617b24d68c1", "d50f3bdd-ac66-4b74-a01f-4617b24d68c2")),
            entry("a1_listEnm", List.of("A", "B", "C")),
            entry("a1_listB1", List.of(EXAMPLE_CONFIGURATION_B1_1)),
            entry("a1_listB2", List.of(EXAMPLE_CONFIGURATION_B2_1)),
            entry("a1_arrayPrimBoolean", List.of(true, false, true)),
            entry("a1_arrayPrimChar", List.of("a", "b", "c")),
            entry("a1_arrayPrimByte", List.of(1L, 2L, 3L)),
            entry("a1_arrayPrimShort", List.of(1L, 2L, 3L)),
            entry("a1_arrayPrimInteger", List.of(1L, 2L, 3L)),
            entry("a1_arrayPrimLong", List.of(1L, 2L, 3L)),
            entry("a1_arrayPrimFloat", List.of(1d, 2d, 3d)),
            entry("a1_arrayPrimDouble", List.of(1d, 2d, 3d)),
            entry("a1_arrayBoolean", List.of(true, false, true)),
            entry("a1_arrayChar", List.of("a", "b", "c")),
            entry("a1_arrayByte", List.of(1L, 2L, 3L)),
            entry("a1_arrayShort", List.of(1L, 2L, 3L)),
            entry("a1_arrayInteger", List.of(1L, 2L, 3L)),
            entry("a1_arrayLong", List.of(1L, 2L, 3L)),
            entry("a1_arrayFloat", List.of(1d, 2d, 3d)),
            entry("a1_arrayDouble", List.of(1d, 2d, 3d)),
            entry("a1_arrayString", List.of("1", "2", "3")),
            entry("a1_arrayBigInteger", List.of("1", "2", "3")),
            entry("a1_arrayBigDecimal", List.of("1", "2", "3")),
            entry("a1_arrayLocalDate", List.of("2000-01-01", "2000-01-02", "2000-01-03")),
            entry("a1_arrayLocalTime", List.of("00:01", "00:02", "00:03")),
            entry("a1_arrayLocalDateTime", List.of("2000-01-01T00:00", "2000-01-02T00:00", "2000-01-03T00:00")),
            entry("a1_arrayUuid", List.of("d50f3bdd-ac66-4b74-a01f-4617b24d68c0", "d50f3bdd-ac66-4b74-a01f-4617b24d68c1", "d50f3bdd-ac66-4b74-a01f-4617b24d68c2")),
            entry("a1_arrayEnm", List.of("A", "B", "C")),
            entry("a1_arrayB1", List.of(EXAMPLE_CONFIGURATION_B1_1)),
            entry("a1_arrayB2", List.of(EXAMPLE_CONFIGURATION_B2_1)),
            entry("a1_setBoolean", List.of(true)),
            entry("a1_setChar", asList("a", "b", "c")),
            entry("a1_setByte", asList(1L, 2L, 3L)),
            entry("a1_setShort", asList(1L, 2L, 3L)),
            entry("a1_setInteger", asList(1L, 2L, 3L)),
            entry("a1_setLong", asList(1L, 2L, 3L)),
            entry("a1_setFloat", asList(1d, 2d, 3d)),
            entry("a1_setDouble", asList(1d, 2d, 3d)),
            entry("a1_setString", asList("1", "2", "3")),
            entry("a1_setBigInteger", asList("1", "2", "3")),
            entry("a1_setBigDecimal", asList("1", "2", "3")),
            entry("a1_setLocalDate", asList("2000-01-01", "2000-01-02", "2000-01-03")),
            entry("a1_setLocalTime", asList("00:01", "00:02", "00:03")),
            entry("a1_setLocalDateTime", asList("2000-01-01T00:00", "2000-01-02T00:00", "2000-01-03T00:00")),
            entry("a1_setUuid", asList("d50f3bdd-ac66-4b74-a01f-4617b24d68c0", "d50f3bdd-ac66-4b74-a01f-4617b24d68c1", "d50f3bdd-ac66-4b74-a01f-4617b24d68c2")),
            entry("a1_setEnm", asList("A", "B", "C")),
            entry("a1_setB1", List.of(EXAMPLE_CONFIGURATION_B1_1)),
            entry("a1_setB2", List.of(EXAMPLE_CONFIGURATION_B2_1)),
            entry("a1_mapBooleanBoolean", asMap(true, true, false, false)),
            entry("a1_mapCharChar", asMap("a", "b", "c", "d")),
            entry("a1_mapByteByte", asMap(1L, 2L, 3L, 4L)),
            entry("a1_mapShortShort", asMap(1L, 2L, 3L, 4L)),
            entry("a1_mapIntegerInteger", asMap(1L, 2L, 3L, 4L)),
            entry("a1_mapLongLong", asMap(1L, 2L, 3L, 4L)),
            entry("a1_mapFloatFloat", asMap(1d, 2d, 3d, 4d)),
            entry("a1_mapDoubleDouble", asMap(1d, 2d, 3d, 4d)),
            entry("a1_mapStringString", asMap("1", "2", "3", "4")),
            entry("a1_mapBigIntegerBigInteger", asMap("1", "2", "3", "4")),
            entry("a1_mapBigDecimalBigDecimal", asMap("1", "2", "3", "4")),
            entry("a1_mapLocalDateLocalDate", asMap("2000-01-01", "2000-01-02", "2000-01-03", "2000-01-04")),
            entry("a1_mapLocalTimeLocalTime", asMap("00:01", "00:02", "00:03", "00:04")),
            entry("a1_mapLocalDateTimeLocalDateTime", asMap("2000-01-01T00:00", "2000-01-02T00:00", "2000-01-03T00:00", "2000-01-04T00:00")),
            entry("a1_mapUuidUuid", asMap("d50f3bdd-ac66-4b74-a01f-4617b24d68c0", "d50f3bdd-ac66-4b74-a01f-4617b24d68c1", "d50f3bdd-ac66-4b74-a01f-4617b24d68c2", "d50f3bdd-ac66-4b74-a01f-4617b24d68c3")),
            entry("a1_mapEnmEnm", asMap("A", "B", "C", "D")),
            entry("a1_mapIntegerB1", asMap(1L, EXAMPLE_CONFIGURATION_B1_1, 2L, EXAMPLE_CONFIGURATION_B1_2)),
            entry("a1_mapEnmB2", asMap("A", EXAMPLE_CONFIGURATION_B2_1, "B", EXAMPLE_CONFIGURATION_B2_2)),
            entry("a1_listEmpty", Collections.emptyList()),
            entry("a1_arrayEmpty", Collections.emptyList()),
            entry("a1_setEmpty", Collections.emptyList()),
            entry("a1_mapEmpty", Collections.emptyMap()),
            entry("a1_listListByte", List.of(List.of(), List.of(1L), List.of(1L, 2L))),
            entry("a1_listArrayFloat", List.of(List.of(), List.of(1d), List.of(1d, 2d))),
            entry("a1_listSetString", List.of(List.of(), List.of("1"), asList("1", "2"))),
            entry("a1_listMapEnmLocalDate", List.of(asMap(), asMap("A", "2000-01-01"), asMap("A", "2000-01-01", "B", "2000-01-02"))),
            entry("a1_setSetShort", asList(List.of(), List.of(1L), asList(1L, 2L))),
            entry("a1_setArrayDouble", asList(List.of(), List.of(1d), List.of(1d, 2d))),
            entry("a1_setListString", asList(List.of(), List.of("1"), List.of("1", "2"))),
            entry("a1_setMapEnmLocalTime", asList(asMap(), asMap("A", "00:01"), asMap("A", "00:01", "B", "00:02"))),
            entry("a1_mapIntegerMapLongBoolean", asMap(1L, asMap(), 2L, asMap(1L, true), 3L, asMap(1L, true, 2L, false))),
            entry("a1_mapStringListB1", asMap("1", List.of(), "2", List.of(EXAMPLE_CONFIGURATION_B1_1), "3", List.of(EXAMPLE_CONFIGURATION_B1_1, EXAMPLE_CONFIGURATION_B1_2))),
            entry("a1_mapBigIntegerArrayBigDecimal", asMap("1", List.of(), "2", List.of("1"), "3", List.of("1", "2"))),
            entry("a1_mapEnmSetB2", asMap("A", List.of(), "B", List.of(EXAMPLE_CONFIGURATION_B2_1), "C", asList(EXAMPLE_CONFIGURATION_B2_1, EXAMPLE_CONFIGURATION_B2_2))),
            entry("a1_mapIntegerListMapShortSetB2", asMap(1L, List.of(), 2L, List.of(asMap()), 3L, List.of(asMap(1L, List.of(), 2L, List.of(EXAMPLE_CONFIGURATION_B2_1))), 4L, List.of(asMap(1L, List.of(), 2L, List.of(EXAMPLE_CONFIGURATION_B2_1)), asMap()))),
            entry("a1_arrayArrayPrimBoolean", List.of(List.of(), List.of(true), List.of(true, false))),
            entry("a1_arrayArrayPrimChar", List.of(List.of(), List.of("a"), List.of("a", "b"))),
            entry("a1_arrayArrayPrimByte", List.of(List.of(), List.of(1L), List.of(1L, 2L))),
            entry("a1_arrayArrayPrimShort", List.of(List.of(), List.of(1L), List.of(1L, 2L))),
            entry("a1_arrayArrayPrimInteger", List.of(List.of(), List.of(1L), List.of(1L, 2L))),
            entry("a1_arrayArrayPrimLong", List.of(List.of(), List.of(1L), List.of(1L, 2L))),
            entry("a1_arrayArrayPrimFloat", List.of(List.of(), List.of(1d), List.of(1d, 2d))),
            entry("a1_arrayArrayPrimDouble", List.of(List.of(), List.of(1d), List.of(1d, 2d))),
            entry("a1_arrayArrayBoolean", List.of(List.of(), List.of(true), List.of(true, false))),
            entry("a1_arrayArrayChar", List.of(List.of(), List.of("a"), List.of("a", "b"))),
            entry("a1_arrayArrayByte", List.of(List.of(), List.of(1L), List.of(1L, 2L))),
            entry("a1_arrayArrayShort", List.of(List.of(), List.of(1L), List.of(1L, 2L))),
            entry("a1_arrayArrayInteger", List.of(List.of(), List.of(1L), List.of(1L, 2L))),
            entry("a1_arrayArrayLong", List.of(List.of(), List.of(1L), List.of(1L, 2L))),
            entry("a1_arrayArrayFloat", List.of(List.of(), List.of(1d), List.of(1d, 2d))),
            entry("a1_arrayArrayDouble", List.of(List.of(), List.of(1d), List.of(1d, 2d))),
            entry("a1_arrayArrayString", List.of(List.of(), List.of("a"), List.of("a", "b"))),
            entry("a1_arrayArrayBigInteger", List.of(List.of(), List.of("1"), List.of("1", "2"))),
            entry("a1_arrayArrayBigDecimal", List.of(List.of(), List.of("1"), List.of("1", "2"))),
            entry("a1_arrayArrayLocalDate", List.of(List.of(), List.of("2000-01-01"), List.of("2000-01-01", "2000-01-02"))),
            entry("a1_arrayArrayLocalTime", List.of(List.of(), List.of("00:01"), List.of("00:01", "00:02"))),
            entry("a1_arrayArrayLocalDateTime", List.of(List.of(), List.of("2000-01-01T00:00"), List.of("2000-01-01T00:00", "2000-01-02T00:00"))),
            entry("a1_arrayArrayUuid", List.of(List.of(), List.of("d50f3bdd-ac66-4b74-a01f-4617b24d68c0"), List.of("d50f3bdd-ac66-4b74-a01f-4617b24d68c0", "d50f3bdd-ac66-4b74-a01f-4617b24d68c1"))),
            entry("a1_arrayArrayEnm", List.of(List.of(), List.of("A"), List.of("A", "B"))),
            entry("a1_arrayArrayB1", List.of(List.of(), List.of(EXAMPLE_CONFIGURATION_B1_1))),
            entry("a1_arrayArrayB2", List.of(List.of(), List.of(EXAMPLE_CONFIGURATION_B2_1))),
            entry("a1_point", "0:1"),
            entry("a1_listPoint", List.of("0:1", "0:2", "0:3")),
            entry("a1_arrayPoint", List.of("0:1", "0:2", "0:3")),
            entry("a1_setPoint", asList("0:1", "0:2", "0:3")),
            entry("a1_mapEnmListPoint", asMap("A", List.of(), "B", List.of("0:1"), "C", List.of("0:1", "0:2")))
    );
    public static final Map<String, ?> EXAMPLE_CONFIGURATION_A2 = extend(EXAMPLE_CONFIGURATION_A1,
            entry("a2_primBool", true),
            entry("a2_primChar", "b"),
            entry("a2_primByte", 2L),
            entry("a2_primShort", 4L),
            entry("a2_primInt", 6L),
            entry("a2_primLong", 8L),
            entry("a2_primFloat", 10d),
            entry("a2_primDouble", 12d),
            entry("a2_refBool", true),
            entry("a2_refChar", "d"),
            entry("a2_refByte", 14L),
            entry("a2_refShort", 16L),
            entry("a2_refInt", 18L),
            entry("a2_refLong", 20L),
            entry("a2_refFloat", 22d),
            entry("a2_refDouble", 24d),
            entry("a2_string", "b"),
            entry("a2_bigInteger", "2"),
            entry("a2_bigDecimal", "2"),
            entry("a2_localDate", "2000-01-02"),
            entry("a2_localTime", "00:02"),
            entry("a2_localDateTime", "2000-01-02T00:00"),
            entry("a2_uuid", "d50f3bdd-ac66-4b74-a01f-4617b24d68c1"),
            entry("a2_Enm", "B"),
            entry("a2_b1", EXAMPLE_CONFIGURATION_B1_2),
            entry("a2_b2", EXAMPLE_CONFIGURATION_B2_2),
            entry("a2_listBoolean", List.of(false, true, false)),
            entry("a2_listChar", List.of("d", "e", "f")),
            entry("a2_listByte", List.of(2L, 3L, 4L)),
            entry("a2_listShort", List.of(2L, 3L, 4L)),
            entry("a2_listInteger", List.of(2L, 3L, 4L)),
            entry("a2_listLong", List.of(2L, 3L, 4L)),
            entry("a2_listFloat", List.of(2d, 3d, 4d)),
            entry("a2_listDouble", List.of(2d, 3d, 4d)),
            entry("a2_listString", List.of("2", "3", "4")),
            entry("a2_listBigInteger", List.of("2", "3", "4")),
            entry("a2_listBigDecimal", List.of("2", "3", "4")),
            entry("a2_listLocalDate", List.of("2000-01-02", "2000-01-03", "2000-01-04")),
            entry("a2_listLocalTime", List.of("00:02", "00:03", "00:04")),
            entry("a2_listLocalDateTime", List.of("2000-01-02T00:00", "2000-01-03T00:00", "2000-01-04T00:00")),
            entry("a2_listUuid", List.of("d50f3bdd-ac66-4b74-a01f-4617b24d68c1", "d50f3bdd-ac66-4b74-a01f-4617b24d68c2", "d50f3bdd-ac66-4b74-a01f-4617b24d68c3")),
            entry("a2_listEnm", List.of("B", "C", "D")),
            entry("a2_listB1", List.of(EXAMPLE_CONFIGURATION_B1_1, EXAMPLE_CONFIGURATION_B1_2)),
            entry("a2_listB2", List.of(EXAMPLE_CONFIGURATION_B2_1, EXAMPLE_CONFIGURATION_B2_2)),
            entry("a2_arrayPrimBoolean", List.of(false, true, false)),
            entry("a2_arrayPrimChar", List.of("d", "e", "f")),
            entry("a2_arrayPrimByte", List.of(2L, 3L, 4L)),
            entry("a2_arrayPrimShort", List.of(2L, 3L, 4L)),
            entry("a2_arrayPrimInteger", List.of(2L, 3L, 4L)),
            entry("a2_arrayPrimLong", List.of(2L, 3L, 4L)),
            entry("a2_arrayPrimFloat", List.of(2d, 3d, 4d)),
            entry("a2_arrayPrimDouble", List.of(2d, 3d, 4d)),
            entry("a2_arrayBoolean", List.of(false, true, false)),
            entry("a2_arrayChar", List.of("d", "e", "f")),
            entry("a2_arrayByte", List.of(2L, 3L, 4L)),
            entry("a2_arrayShort", List.of(2L, 3L, 4L)),
            entry("a2_arrayInteger", List.of(2L, 3L, 4L)),
            entry("a2_arrayLong", List.of(2L, 3L, 4L)),
            entry("a2_arrayFloat", List.of(2d, 3d, 4d)),
            entry("a2_arrayDouble", List.of(2d, 3d, 4d)),
            entry("a2_arrayString", List.of("2", "3", "4")),
            entry("a2_arrayBigInteger", List.of("2", "3", "4")),
            entry("a2_arrayBigDecimal", List.of("2", "3", "4")),
            entry("a2_arrayLocalDate", List.of("2000-01-02", "2000-01-03", "2000-01-04")),
            entry("a2_arrayLocalTime", List.of("00:02", "00:03", "00:04")),
            entry("a2_arrayLocalDateTime", List.of("2000-01-02T00:00", "2000-01-03T00:00", "2000-01-04T00:00")),
            entry("a2_arrayUuid", List.of("d50f3bdd-ac66-4b74-a01f-4617b24d68c1", "d50f3bdd-ac66-4b74-a01f-4617b24d68c2", "d50f3bdd-ac66-4b74-a01f-4617b24d68c3")),
            entry("a2_arrayEnm", List.of("B", "C", "D")),
            entry("a2_arrayB1", List.of(EXAMPLE_CONFIGURATION_B1_1, EXAMPLE_CONFIGURATION_B1_2)),
            entry("a2_arrayB2", List.of(EXAMPLE_CONFIGURATION_B2_1, EXAMPLE_CONFIGURATION_B2_2)),
            entry("a2_setBoolean", List.of(false)),
            entry("a2_setChar", asList("d", "e", "f")),
            entry("a2_setByte", asList(2L, 3L, 4L)),
            entry("a2_setShort", asList(2L, 3L, 4L)),
            entry("a2_setInteger", asList(2L, 3L, 4L)),
            entry("a2_setLong", asList(2L, 3L, 4L)),
            entry("a2_setFloat", asList(2d, 3d, 4d)),
            entry("a2_setDouble", asList(2d, 3d, 4d)),
            entry("a2_setString", asList("2", "3", "4")),
            entry("a2_setBigInteger", asList("2", "3", "4")),
            entry("a2_setBigDecimal", asList("2", "3", "4")),
            entry("a2_setLocalDate", asList("2000-01-02", "2000-01-03", "2000-01-04")),
            entry("a2_setLocalTime", asList("00:02", "00:03", "00:04")),
            entry("a2_setLocalDateTime", asList("2000-01-02T00:00", "2000-01-03T00:00", "2000-01-04T00:00")),
            entry("a2_setUuid", asList("d50f3bdd-ac66-4b74-a01f-4617b24d68c1", "d50f3bdd-ac66-4b74-a01f-4617b24d68c2", "d50f3bdd-ac66-4b74-a01f-4617b24d68c3")),
            entry("a2_setEnm", asList("B", "C", "D")),
            entry("a2_setB1", asList(EXAMPLE_CONFIGURATION_B1_1, EXAMPLE_CONFIGURATION_B1_2)),
            entry("a2_setB2", asList(EXAMPLE_CONFIGURATION_B2_1, EXAMPLE_CONFIGURATION_B2_2)),
            entry("a2_mapBooleanBoolean", asMap(true, true, false, false)),
            entry("a2_mapCharChar", asMap("b", "c", "d", "e")),
            entry("a2_mapByteByte", asMap(2L, 3L, 4L, 5L)),
            entry("a2_mapShortShort", asMap(2L, 3L, 4L, 5L)),
            entry("a2_mapIntegerInteger", asMap(2L, 3L, 4L, 5L)),
            entry("a2_mapLongLong", asMap(2L, 3L, 4L, 5L)),
            entry("a2_mapFloatFloat", asMap(2d, 3d, 4d, 5d)),
            entry("a2_mapDoubleDouble", asMap(2d, 3d, 4d, 5d)),
            entry("a2_mapStringString", asMap("2", "3", "4", "5")),
            entry("a2_mapBigIntegerBigInteger", asMap("2", "3", "4", "5")),
            entry("a2_mapBigDecimalBigDecimal", asMap("2", "3", "4", "5")),
            entry("a2_mapLocalDateLocalDate", asMap("2000-01-02", "2000-01-03", "2000-01-04", "2000-01-05")),
            entry("a2_mapLocalTimeLocalTime", asMap("00:02", "00:03", "00:04", "00:05")),
            entry("a2_mapLocalDateTimeLocalDateTime", asMap("2000-01-02T00:00", "2000-01-03T00:00", "2000-01-04T00:00", "2000-01-05T00:00")),
            entry("a2_mapUuidUuid", asMap("d50f3bdd-ac66-4b74-a01f-4617b24d68c1", "d50f3bdd-ac66-4b74-a01f-4617b24d68c2", "d50f3bdd-ac66-4b74-a01f-4617b24d68c3", "d50f3bdd-ac66-4b74-a01f-4617b24d68c4")),
            entry("a2_mapEnmEnm", asMap("B", "C", "D", "E")),
            entry("a2_mapIntegerB1", asMap(2L, EXAMPLE_CONFIGURATION_B1_1, 3L, EXAMPLE_CONFIGURATION_B1_2)),
            entry("a2_mapEnmB2", asMap("B", EXAMPLE_CONFIGURATION_B2_1, "C", EXAMPLE_CONFIGURATION_B2_2)),
            entry("a2_listEmpty", Collections.emptyList()),
            entry("a2_arrayEmpty", Collections.emptyList()),
            entry("a2_setEmpty", Collections.emptyList()),
            entry("a2_mapEmpty", Collections.emptyMap()),
            entry("a2_listListByte", List.of(List.of(1L), List.of(1L, 2L), List.of(1L, 2L, 3L))),
            entry("a2_listArrayFloat", List.of(List.of(1d), List.of(1d, 2d), List.of(1d, 2d, 3d))),
            entry("a2_listSetString", List.of(List.of("1"), asList("1", "2"), asList("1", "2", "3"))),
            entry("a2_listMapEnmLocalDate", List.of(asMap("A", "2000-01-01"), asMap("A", "2000-01-01", "B", "2000-01-02"), asMap("A", "2000-01-01", "B", "2000-01-02", "C", "2000-01-03"))),
            entry("a2_setSetShort", asList(List.of(1L), asList(1L, 2L), asList(1L, 2L, 3L))),
            entry("a2_setArrayDouble", asList(List.of(1d), List.of(1d, 2d), List.of(1d, 2d, 3d))),
            entry("a2_setListString", asList(List.of("1"), List.of("1", "2"), List.of("1", "2", "3"))),
            entry("a2_setMapEnmLocalTime", asList(asMap("A", "00:01"), asMap("A", "00:01", "B", "00:02"), asMap("A", "00:01", "B", "00:02", "C", "00:03"))),
            entry("a2_mapIntegerMapLongBoolean", asMap(2L, asMap(1L, true), 3L, asMap(1L, true, 2L, false), 4L, asMap(1L, true, 2L, false, 3L, true))),
            entry("a2_mapStringListB1", asMap("2", List.of(EXAMPLE_CONFIGURATION_B1_1), "3", List.of(EXAMPLE_CONFIGURATION_B1_1, EXAMPLE_CONFIGURATION_B1_2), "4", List.of(EXAMPLE_CONFIGURATION_B1_1, EXAMPLE_CONFIGURATION_B1_2, EXAMPLE_CONFIGURATION_B1_1))),
            entry("a2_mapBigIntegerArrayBigDecimal", asMap("2", List.of("1"), "3", List.of("1", "2"), "4", List.of("1", "2", "3"))),
            entry("a2_mapEnmSetB2", asMap("B", List.of(EXAMPLE_CONFIGURATION_B2_1), "C", asList(EXAMPLE_CONFIGURATION_B2_1, EXAMPLE_CONFIGURATION_B2_2), "D", List.of())),
            entry("a2_mapIntegerListMapShortSetB2", asMap(2L, List.of(asMap()), 3L, List.of(asMap(1L, List.of(), 2L, List.of(EXAMPLE_CONFIGURATION_B2_1))), 4L, List.of(asMap(1L, List.of(), 2L, List.of(EXAMPLE_CONFIGURATION_B2_1)), asMap()), 5L, List.of(asMap(1L, List.of(), 2L, List.of(EXAMPLE_CONFIGURATION_B2_1)), asMap(1L, List.of())))),
            entry("a2_arrayArrayPrimBoolean", List.of(List.of(true), List.of(true, false), List.of(true, false, true))),
            entry("a2_arrayArrayPrimChar", List.of(List.of("a"), List.of("a", "b"), List.of("a", "b", "c"))),
            entry("a2_arrayArrayPrimByte", List.of(List.of(1L), List.of(1L, 2L), List.of(1L, 2L, 3L))),
            entry("a2_arrayArrayPrimShort", List.of(List.of(1L), List.of(1L, 2L), List.of(1L, 2L, 3L))),
            entry("a2_arrayArrayPrimInteger", List.of(List.of(1L), List.of(1L, 2L), List.of(1L, 2L, 3L))),
            entry("a2_arrayArrayPrimLong", List.of(List.of(1L), List.of(1L, 2L), List.of(1L, 2L, 3L))),
            entry("a2_arrayArrayPrimFloat", List.of(List.of(1d), List.of(1d, 2d), List.of(1d, 2d, 3d))),
            entry("a2_arrayArrayPrimDouble", List.of(List.of(1d), List.of(1d, 2d), List.of(1d, 2d, 3d))),
            entry("a2_arrayArrayBoolean", List.of(List.of(true), List.of(true, false), List.of(true, false, true))),
            entry("a2_arrayArrayChar", List.of(List.of("a"), List.of("a", "b"), List.of("a", "b", "c"))),
            entry("a2_arrayArrayByte", List.of(List.of(1L), List.of(1L, 2L), List.of(1L, 2L, 3L))),
            entry("a2_arrayArrayShort", List.of(List.of(1L), List.of(1L, 2L), List.of(1L, 2L, 3L))),
            entry("a2_arrayArrayInteger", List.of(List.of(1L), List.of(1L, 2L), List.of(1L, 2L, 3L))),
            entry("a2_arrayArrayLong", List.of(List.of(1L), List.of(1L, 2L), List.of(1L, 2L, 3L))),
            entry("a2_arrayArrayFloat", List.of(List.of(1d), List.of(1d, 2d), List.of(1d, 2d, 3d))),
            entry("a2_arrayArrayDouble", List.of(List.of(1d), List.of(1d, 2d), List.of(1d, 2d, 3d))),
            entry("a2_arrayArrayString", List.of(List.of("a"), List.of("a", "b"), List.of("a", "b", "c"))),
            entry("a2_arrayArrayBigInteger", List.of(List.of("1"), List.of("1", "2"), List.of("1", "2", "3"))),
            entry("a2_arrayArrayBigDecimal", List.of(List.of("1"), List.of("1", "2"), List.of("1", "2", "3"))),
            entry("a2_arrayArrayLocalDate", List.of(List.of("2000-01-01"), List.of("2000-01-01", "2000-01-02"), List.of("2000-01-01", "2000-01-02", "2000-01-03"))),
            entry("a2_arrayArrayLocalTime", List.of(List.of("00:01"), List.of("00:01", "00:02"), List.of("00:01", "00:02", "00:03"))),
            entry("a2_arrayArrayLocalDateTime", List.of(List.of("2000-01-01T00:00"), List.of("2000-01-01T00:00", "2000-01-02T00:00"), List.of("2000-01-01T00:00", "2000-01-02T00:00", "2000-01-03T00:00"))),
            entry("a2_arrayArrayUuid", List.of(List.of("d50f3bdd-ac66-4b74-a01f-4617b24d68c0"), List.of("d50f3bdd-ac66-4b74-a01f-4617b24d68c0", "d50f3bdd-ac66-4b74-a01f-4617b24d68c1"), List.of("d50f3bdd-ac66-4b74-a01f-4617b24d68c0", "d50f3bdd-ac66-4b74-a01f-4617b24d68c1", "d50f3bdd-ac66-4b74-a01f-4617b24d68c2"))),
            entry("a2_arrayArrayEnm", List.of(List.of("A"), List.of("A", "B"), List.of("A", "B", "C"))),
            entry("a2_arrayArrayB1", List.of(List.of(EXAMPLE_CONFIGURATION_B1_1), List.of(EXAMPLE_CONFIGURATION_B1_2))),
            entry("a2_arrayArrayB2", List.of(List.of(EXAMPLE_CONFIGURATION_B2_1), List.of(EXAMPLE_CONFIGURATION_B2_2))),
            entry("a2_point", "0:2"),
            entry("a2_listPoint", List.of("0:2", "0:3", "0:4")),
            entry("a2_arrayPoint", List.of("0:2", "0:3", "0:4")),
            entry("a2_setPoint", asList("0:2", "0:3", "0:4")),
            entry("a2_mapEnmListPoint", asMap("B", List.of("0:1"), "C", List.of("0:1", "0:2"), "D", List.of("0:1", "0:2", "0:3")))
    );
    public static final Map<String, ?> EXAMPLE_CONFIGURATION_NULLS_WITH_1 = entriesAsMap(
            entry("nullInteger", null),
            entry("nullString", null),
            entry("nullEnm", null),
            entry("nullB1", null),
            entry("nullList", null),
            entry("nullArray", null),
            entry("nullSet", null),
            entry("nullMap", null),
            entry("nullPoint", null),
            entry("listNullString", asList(null, "a", null)),
            entry("arrayNullDouble", asList(null, 1d, null)),
            entry("setNullInteger", Collections.singletonList((Long) null)),
            entry("mapNullEnmKey", entriesAsMap(entry(null, "1"))),
            entry("mapNullBigIntegerValue", entriesAsMap(entry("A", null)))
    );
    public static final Map<String, ?> EXAMPLE_CONFIGURATION_NULLS_WITH_2 = entriesAsMap(
            entry("nullInteger", null),
            entry("nullString", null),
            entry("nullEnm", null),
            entry("nullB1", null),
            entry("nullList", null),
            entry("nullArray", null),
            entry("nullSet", null),
            entry("nullMap", null),
            entry("nullPoint", null),
            entry("listNullString", asList("b", null, "c")),
            entry("arrayNullDouble", asList(2d, null, 3d)),
            entry("setNullInteger", asList(null, 1L)),
            entry("mapNullEnmKey", entriesAsMap(entry(null, "1"), entry("A", "2"))),
            entry("mapNullBigIntegerValue", entriesAsMap(entry("A", null), entry("B", "1")))
    );
    public static final Map<String, ?> EXAMPLE_CONFIGURATION_NULLS_WITHOUT_1 = entriesAsMap(
            entry("listNullString", List.of("a")),
            entry("arrayNullDouble", List.of(1d)),
            entry("setNullInteger", List.of()),
            entry("mapNullEnmKey", entriesAsMap()),
            entry("mapNullBigIntegerValue", entriesAsMap())
    );
    public static final Map<String, ?> EXAMPLE_CONFIGURATION_NULLS_WITHOUT_2 = entriesAsMap(
            entry("listNullString", asList("b", "c")),
            entry("arrayNullDouble", asList(2d, 3d)),
            entry("setNullInteger", List.of(1L)),
            entry("mapNullEnmKey", entriesAsMap(entry("A", "2"))),
            entry("mapNullBigIntegerValue", entriesAsMap(entry("B", "1")))
    );
}
