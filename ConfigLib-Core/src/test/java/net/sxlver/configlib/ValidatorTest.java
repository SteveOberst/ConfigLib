package net.sxlver.configlib;

import net.sxlver.configlib.annotation.ConfigurationElement;
import net.sxlver.configlib.annotation.ElementType;
import net.sxlver.configlib.classes.TestSubClass;
import net.sxlver.configlib.util.CollectionFactory;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SuppressWarnings("unused")
public class ValidatorTest {
    @Test
    void instanceFromMapRequiresMapToInitializeCustomClass() {
        class A {
            TestSubClass c = new TestSubClass();
        }

        Map<String, Object> map = CollectionFactory.mapOf(
                "c", "s"
        );
        String msg = "Initializing field 'c' requires a Map<String, Object> " +
                "but the given object is not a map." +
                "\nType: 'String'\tValue: 's'";
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new A(), map, msg);
    }

    @Test
    void instanceFromMapChecksEnumValuesAreString() {
        class A {
            FieldMapperHelpers.LocalTestEnum t = FieldMapperHelpers.LocalTestEnum.T;
        }
        Map<String, Object> map = CollectionFactory.mapOf(
                "t", 1
        );
        String msg = "Initializing enum 't' requires a string but '1' is of " +
                "type 'Integer'.";
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new A(), map, msg);
    }

    @Test
    void instanceFromMapRequiresMapWithStringsAsKeys() {
        class A {
            TestSubClass c = new TestSubClass();
        }

        Map<String, Object> map = CollectionFactory.mapOf(
                "c", CollectionFactory.mapOf(1, 200, "string", "s")
        );
        String msg = "Initializing field 'c' requires a Map<String, Object> " +
                "but the given map contains non-string keys." +
                "\nAll entries: " + map.get("c");
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new A(), map, msg);
    }


    @Test
    void instanceToMapRequiresNonNullMapKeys() {
        class A {
            TestSubClass c = new TestSubClass();
        }
        Map<String, Object> m1 = new HashMap<>();
        m1.put(null, "null");
        Map<String, Object> m2 = CollectionFactory.mapOf("c", m1);
        String msg = "Initializing field 'c' requires a Map<String, Object> " +
                "but the given map contains non-string keys." +
                "\nAll entries: {null=null}";
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new A(), m2, msg);
    }

    @Test
    void instanceFromMapRequiresCustomClassToHaveNoArgsConstructors() {
        class A {
            FieldMapperHelpers.Sub3 s = new FieldMapperHelpers.Sub3(1);
        }
        Map<String, Object> map = CollectionFactory.mapOf("s", CollectionFactory.mapOf());
        String msg = "Type 'Sub3' of field 's' doesn't have a no-args constructor.";
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new A(), map, msg);
    }

    @Test
    void instanceFromMapRequiresCustomClassToBeConfigurationElements() {
        class A {
            FieldMapperHelpers.Sub1 s = new FieldMapperHelpers.Sub1();
        }
        Map<String, Object> map = CollectionFactory.mapOf("s", CollectionFactory.mapOf());
        String msg = "Type 'Sub1' of field 's' is not annotated " +
                "as a configuration element.";
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new A(), map, msg);
    }

    @Test
    void instanceFromMapChecksThatContainerTypesMatch() {
        class A {
            CopyOnWriteArrayList<?> l = new CopyOnWriteArrayList<>();
        }
        class B {
            ConcurrentSkipListSet<?> s = new ConcurrentSkipListSet<>();
        }
        class C {
            ConcurrentHashMap<?, ?> m = new ConcurrentHashMap<>();
        }
        Map<String, Object> m = CollectionFactory.mapOf("l", CollectionFactory.listOf("s"));
        String msg = "Can not set field 'l' with type 'CopyOnWriteArrayList' " +
                "to 'ArrayList'.";
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new A(), m, msg);

        m = CollectionFactory.mapOf("s", CollectionFactory.setOf("s"));
        msg = "Can not set field 's' with type 'ConcurrentSkipListSet' " +
                "to 'LinkedHashSet'.";
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new B(), m, msg);

        m = CollectionFactory.mapOf("m", CollectionFactory.mapOf(1, "s"));
        msg = "Can not set field 'm' with type 'ConcurrentHashMap' " +
                "to 'LinkedHashMap'.";
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new C(), m, msg);

    }

    @Test
    void instanceToMapThrowsExceptionIfDefaultValueIsNull() {
        class A {
            String string;
        }
        String msg = "The value of field 'string' is null.\n" +
                "Please assign a non-null default value or remove this field.";
        FieldMapperHelpers.assertItmCfgExceptionMessage(new A(), msg);
    }

    @Test
    void instanceFromMapThrowsExceptionIfDefaultValueIsNull() {
        class A {
            String string;
        }
        Map<String, Object> map = CollectionFactory.mapOf("string", "s");
        String msg = "The value of field 'string' is null.\n" +
                "Please assign a non-null default value or remove this field.";
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new A(), map, msg);
    }

    @Test
    void instanceToMapRequiresListsWithoutElementTypeToContainSimpleTypes() {
        class A {
            List<TestSubClass> l = new ArrayList<>(CollectionFactory.listOf(
                    TestSubClass.TEST_VALUES
            ));
        }
        class B {
            List<Set<Map<Integer, TestSubClass>>> l = new ArrayList<>(CollectionFactory.listOf(
                    CollectionFactory.setOf(CollectionFactory.mapOf(1, TestSubClass.TEST_VALUES))
            ));
        }

        String asString = TestSubClass.TEST_VALUES.toString();

        A a = new A();
        String msg = "The type of an element of list 'l' is not a simple type " +
                "but list 'l' is missing the ElementType annotation.\n" +
                "All elements: [" + asString + "]";
        FieldMapperHelpers.assertItmCfgExceptionMessage(a, msg);

        B b = new B();
        msg = "The type of an element of list 'l' is not a simple type " +
                "but list 'l' is missing the ElementType annotation.\n" +
                "All elements: [[{1=" + asString + "}]]";
        FieldMapperHelpers.assertItmCfgExceptionMessage(b, msg);
    }

    @Test
    void instanceToMapRequiresSetsWithoutElementTypeToContainSimpleTypes() {
        class A {
            Set<TestSubClass> s = new HashSet<>(CollectionFactory.setOf(
                    TestSubClass.TEST_VALUES
            ));
        }
        class B {
            Set<List<Map<Integer, TestSubClass>>> s = new HashSet<>(CollectionFactory.setOf(
                    CollectionFactory.listOf(CollectionFactory.mapOf(1, TestSubClass.TEST_VALUES))
            ));
        }

        String asString = TestSubClass.TEST_VALUES.toString();

        A a = new A();
        String msg = "The type of an element of set 's' is not a simple type " +
                "but set 's' is missing the ElementType annotation.\n" +
                "All elements: [" + asString + "]";
        FieldMapperHelpers.assertItmCfgExceptionMessage(a, msg);

        B b = new B();
        msg = "The type of an element of set 's' is not a simple type " +
                "but set 's' is missing the ElementType annotation.\n" +
                "All elements: [[{1=" + asString + "}]]";
        FieldMapperHelpers.assertItmCfgExceptionMessage(b, msg);
    }

    @Test
    void instanceToMapRequiresMapsWithoutElementTypeToContainSimpleTypes() {
        class A {
            Map<Integer, TestSubClass> m = new HashMap<>(CollectionFactory.mapOf(
                    1, TestSubClass.TEST_VALUES
            ));
        }
        class B {
            Map<Integer, Set<List<TestSubClass>>> m = new HashMap<>(CollectionFactory.mapOf(
                    1, CollectionFactory.setOf(CollectionFactory.listOf(TestSubClass.TEST_VALUES))
            ));
        }

        String asString = TestSubClass.TEST_VALUES.toString();

        A a = new A();
        String msg = "The type of a value of map 'm' is not a simple type " +
                "but map 'm' is missing the ElementType annotation.\n" +
                "All entries: {1=" + asString + "}";
        FieldMapperHelpers.assertItmCfgExceptionMessage(a, msg);

        B b = new B();
        msg = "The type of a value of map 'm' is not a simple type " +
                "but map 'm' is missing the ElementType annotation.\n" +
                "All entries: {1=[[" + asString + "]]}";
        FieldMapperHelpers.assertItmCfgExceptionMessage(b, msg);
    }

    @Test
    void instanceToMapRequiresNonNullListElements() {
        class A {
            @ElementType(TestSubClass.class)
            List<TestSubClass> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();
        }
        A a = new A();
        a.l1.add(null);
        a.l2.add(null);

        String msg = "An element of list 'l1' is null.\n" +
                "Please either remove or replace this element.\n" +
                "All elements: [null]";
        FieldMapperHelpers.assertItmCfgExceptionMessage(a, msg);

        a.l1.clear();
        msg = "An element of list 'l2' is null.\n" +
                "Please either remove or replace this element.\n" +
                "All elements: [null]";
        FieldMapperHelpers.assertItmCfgExceptionMessage(a, msg);
    }

    @Test
    void instanceToMapRequiresNonNullListElementsRecursively() {
        class A {
            @ElementType(TestSubClass.class)
            List<List<TestSubClass>> bla = new ArrayList<>();
        }
        A o = new A();
        o.bla.add(new ArrayList<>());
        o.bla.get(0).add(null);
        String msg = "An element of list 'bla' is null.\n" +
                "Please either remove or replace this element.\n" +
                "All elements: [[null]]";
        FieldMapperHelpers.assertItmCfgExceptionMessage(o, msg);
    }

    @Test
    void instanceToMapRequiresNonNullSetElements() {
        class A {
            @ElementType(TestSubClass.class)
            Set<TestSubClass> s1 = new HashSet<>();
            Set<Integer> s2 = new HashSet<>();
        }
        A a = new A();
        a.s1.add(null);
        a.s2.add(null);

        String msg = "An element of set 's1' is null.\n" +
                "Please either remove or replace this element.\n" +
                "All elements: [null]";
        FieldMapperHelpers.assertItmCfgExceptionMessage(a, msg);

        a.s1.clear();
        msg = "An element of set 's2' is null.\n" +
                "Please either remove or replace this element.\n" +
                "All elements: [null]";
        FieldMapperHelpers.assertItmCfgExceptionMessage(a, msg);
    }

    @Test
    void instanceToMapRequiresNonNullSetElementsRecursively() {
        class A {
            @ElementType(TestSubClass.class)
            Set<List<TestSubClass>> bla = new HashSet<>();
        }
        A o = new A();
        o.bla.add(new ArrayList<>());
        o.bla.iterator().next().add(null);
        String msg = "An element of set 'bla' is null.\n" +
                "Please either remove or replace this element.\n" +
                "All elements: [[null]]";
        FieldMapperHelpers.assertItmCfgExceptionMessage(o, msg);
    }


    @Test
    void instanceToMapRequiresNonNullMapValues() {
        class A {
            @ElementType(TestSubClass.class)
            Map<Integer, TestSubClass> m1 = new HashMap<>();
            Map<Integer, TestSubClass> m2 = new HashMap<>();
        }
        A a = new A();
        a.m1.put(1, null);
        a.m2.put(1, null);

        String msg = "A value of map 'm1' is null.\n" +
                "Please either remove or replace this element.\n" +
                "All entries: {1=null}";
        FieldMapperHelpers.assertItmCfgExceptionMessage(a, msg);

        a.m1.clear();
        msg = "A value of map 'm2' is null.\n" +
                "Please either remove or replace this element.\n" +
                "All entries: {1=null}";
        FieldMapperHelpers.assertItmCfgExceptionMessage(a, msg);
    }

    @Test
    void instanceToMapRequiresNonNullMapValuesRecursively() {
        class A {
            @ElementType(TestSubClass.class)
            Map<Integer, List<TestSubClass>> bla = new HashMap<>();
        }
        A o = new A();
        o.bla.put(1, new ArrayList<>());
        o.bla.get(1).add(null);
        String msg = "A value of map 'bla' is null.\n" +
                "Please either remove or replace this element.\n" +
                "All entries: {1=[null]}";
        FieldMapperHelpers.assertItmCfgExceptionMessage(o, msg);
    }

    @Test
    void instanceToMapRequiresSimpleMapKeys() {
        class A {
            Map<TestSubClass, Integer> m = new HashMap<>();
        }
        A a = new A();
        a.m.put(TestSubClass.TEST_VALUES, 1);

        String msg = "The keys of map 'm' must be simple types.";
        FieldMapperHelpers.assertItmCfgExceptionMessage(a, msg);
    }

    @Test
    void instanceToMapRequiresContainerTypesToMatchElementType() {
        class A {
            @ElementType(TestSubClass.class)
            List<Integer> l = new ArrayList<>();
            @ElementType(TestSubClass.class)
            Set<Integer> s = new HashSet<>();
            @ElementType(TestSubClass.class)
            Map<Integer, Integer> m = new HashMap<>();
        }
        A a = new A();
        a.l.add(1);
        a.s.add(1);
        a.m.put(1, 1);

        String msg = "The type of an element of list 'l' doesn't match the " +
                "type indicated by the ElementType annotation.\n" +
                "Required type: 'TestSubClass'\tActual type: 'Integer'\n" +
                "All elements: [1]";
        FieldMapperHelpers.assertItmCfgExceptionMessage(a, msg);

        a.l.clear();
        msg = "The type of an element of set 's' doesn't match the " +
                "type indicated by the ElementType annotation.\n" +
                "Required type: 'TestSubClass'\tActual type: 'Integer'\n" +
                "All elements: [1]";
        FieldMapperHelpers.assertItmCfgExceptionMessage(a, msg);

        a.s.clear();
        msg = "The type of a value of map 'm' doesn't match the " +
                "type indicated by the ElementType annotation.\n" +
                "Required type: 'TestSubClass'\tActual type: 'Integer'\n" +
                "All entries: {1=1}";
        FieldMapperHelpers.assertItmCfgExceptionMessage(a, msg);
    }

    @Test
    void instanceToMapRequiresCustomClassesToBeConfigurationElements() {
        class A {
            FieldMapperHelpers.Sub1 s = new FieldMapperHelpers.Sub1();
        }
        class B {
            FieldMapperHelpers.Sub2 s = new FieldMapperHelpers.Sub2();
        }

        Map<String, Object> map = CollectionFactory.mapOf("s", Collections.emptyMap());

        MatcherAssert.assertThat(FieldMapperHelpers.instanceToMap(new B()), is(map));

        String msg = "Type 'Sub1' of field 's' is not annotated " +
                "as a configuration element.";
        FieldMapperHelpers.assertItmCfgExceptionMessage(new A(), msg);
    }

    @Test
    void instanceToMapRequiresElementTypesToBeConcreteType() {
        class A {
            @ElementType(FieldMapperHelpers.LocalTestInterface.class)
            List<FieldMapperHelpers.LocalTestInterface> l = new ArrayList<>();
        }
        class B {
            @ElementType(FieldMapperHelpers.LocalTestAbstractClass.class)
            List<FieldMapperHelpers.LocalTestAbstractClass> l = new ArrayList<>();
        }
        class C {
            @ElementType(int.class)
            List<FieldMapperHelpers.LocalTestAbstractClass> l = new ArrayList<>();
        }
        class D {
            @ElementType(TestSubClass[].class)
            List<TestSubClass[]> l = new ArrayList<>();
        }
        class E {
            @ElementType(FieldMapperHelpers.LocalTestEnum.class)
            List<FieldMapperHelpers.LocalTestEnum> l = new ArrayList<>();
        }
        Map<String, Object> m = CollectionFactory.mapOf("l", CollectionFactory.listOf());

        String msg = "The element type of field 'l' must be a concrete class " +
                "but type 'LocalTestInterface' is an interface.";
        FieldMapperHelpers.assertItmCfgExceptionMessage(new A(), msg);
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new A(), m, msg);

        msg = "The element type of field 'l' must be a concrete class " +
                "but type 'LocalTestAbstractClass' is an abstract class.";
        FieldMapperHelpers.assertItmCfgExceptionMessage(new B(), msg);
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new B(), m, msg);

        msg = "The element type 'int' of field 'l' is not a configuration element.";
        FieldMapperHelpers.assertItmCfgExceptionMessage(new C(), msg);
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new C(), m, msg);

        msg = "The element type 'TestSubClass[]' of field 'l' is " +
                "not a configuration element.";
        FieldMapperHelpers.assertItmCfgExceptionMessage(new D(), msg);
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new D(), m, msg);
    }

    @Test
    void instanceToMapRequiresConfigurationElementsToHaveNoArgsConstructors() {
        @ConfigurationElement
        class Sub {
            Sub(int n) {}
        }

        class A {
            Sub s = new Sub(2);
        }

        String msg = "Type 'Sub' of field 's' doesn't have a no-args constructor.";
        FieldMapperHelpers.assertItmCfgExceptionMessage(new A(), msg);
    }

    @Test
    void instanceToMapRequiresElementTypesToBeConfigurationElements() {
        class A {
            @ElementType(String.class)
            List<String> l = new ArrayList<>();
        }
        String msg = "The element type 'String' of field 'l' is not a " +
                "configuration element.";
        FieldMapperHelpers.assertItmCfgExceptionMessage(new A(), msg);
    }

    @Test
    void instanceToMapRequiresElementTypesToHaveNoArgsConstructors() {
        class A {
            @ElementType(FieldMapperHelpers.Sub3.class)
            List<FieldMapperHelpers.Sub3> list = new ArrayList<>();
        }
        String msg = "The element type 'Sub3' of field 'list' " +
                "doesn't have a no-args constructor.";
        FieldMapperHelpers.assertItmCfgExceptionMessage(new A(), msg);
    }

    @Test
    void instanceToAndFromMapRequireFieldsWithElementTypeToBeContainers() {
        class A {
            @ElementType(String.class)
            String s = "";
        }
        String msg = "Field 's' is annotated with the ElementType annotation but " +
                "is not a List, Set or Map.";
        FieldMapperHelpers.assertItmCfgExceptionMessage(new A(), msg);
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new A(), CollectionFactory.mapOf("s", ""), msg);
    }

    @Test
    void instanceFromMapsRequiresElementTypeToBeEnumType() {
        class A {
            @ElementType(value = TestSubClass.class, nestingLevel = 1)
            List<List<TestSubClass>> l = CollectionFactory.listOf();
        }
        Map<String, Object> map = CollectionFactory.mapOf(
                "l", CollectionFactory.listOf(CollectionFactory.listOf("Q", "V"))
        );
        ConfigurationException ex = FieldMapperHelpers.assertIfmThrowsCfgException(new A(), map);
        Throwable cause = ex.getCause();

        String msg = "Element type 'TestSubClass' of field 'l' is not an enum type.";
        assertThat(cause.getMessage(), is(msg));
    }

    @Test
    void instanceFromMapElementConverterRequiresObjectsOfTypeMapStringObject() {
        class A {
            @ElementType(value = TestSubClass.class, nestingLevel = 1)
            List<List<TestSubClass>> l = CollectionFactory.listOf();
        }
        Map<String, Object> map = CollectionFactory.mapOf(
                "l", CollectionFactory.listOf(CollectionFactory.listOf(1, 2))
        );
        String msg = "Field 'l' of class 'A' has a nesting level of 1 but element " +
                "'1' of type 'Integer' cannot be converted to 'TestSubClass'.";
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new A(), map, msg);
    }

    @Test
    void instanceToMapRequiresCorrectNestingLevelForLists() {
        TestSubClass testValues = TestSubClass.TEST_VALUES;
        class A {
            @ElementType(TestSubClass.class)
            List<List<TestSubClass>> l1 = CollectionFactory.listOf();

            @ElementType(TestSubClass.class)
            List<List<TestSubClass>> l2 = CollectionFactory.listOf(CollectionFactory.listOf(testValues));
        }
        class B {
            @ElementType(value = TestSubClass.class, nestingLevel = 1)
            List<List<List<TestSubClass>>> l = CollectionFactory.listOf(CollectionFactory.listOf(CollectionFactory.listOf(testValues)));
        }
        class C {
            @ElementType(value = TestSubClass.class, nestingLevel = 3)
            List<List<List<TestSubClass>>> l = CollectionFactory.listOf(CollectionFactory.listOf(CollectionFactory.listOf(testValues)));
        }
        class D {
            @ElementType(value = TestSubClass.class, nestingLevel = 1)
            List<List<TestSubClass>> l = CollectionFactory.listOf(CollectionFactory.listOf(
                    TestSubClass.of(11, "11"), TestSubClass.of(12, "12"),
                    TestSubClass.of(13, "13"), TestSubClass.of(14, "14")
            ));
        }

        String msg = "Field 'l2' of class 'A' has a nesting level of 0 but the " +
                "first object of type 'TestSubClass' was found on level 1.";
        FieldMapperHelpers.assertItmCfgExceptionMessage(new A(), msg);

        msg = "Field 'l' of class 'B' has a nesting level of 1 but the " +
                "first object of type 'TestSubClass' was found on level 2.";
        FieldMapperHelpers.assertItmCfgExceptionMessage(new B(), msg);

        msg = "Field 'l' of class 'C' has a nesting level of 3 but the " +
                "first object of type 'TestSubClass' was found on level 2.";
        FieldMapperHelpers.assertItmCfgExceptionMessage(new C(), msg);

        Map<String, Object> map = FieldMapperHelpers.instanceToMap(new D());
        D d = FieldMapperHelpers.instanceFromMap(new D(), map);
        assertThat(d.l, is(new D().l));
    }


    @Test
    void instanceToMapRequiresCorrectNestingLevelForMaps() {
        TestSubClass testValues = TestSubClass.TEST_VALUES;
        class A {
            @ElementType(TestSubClass.class)
            Map<String, Map<String, TestSubClass>> m1 = CollectionFactory.mapOf();

            @ElementType(TestSubClass.class)
            Map<Integer, Map<String, TestSubClass>> m2 = CollectionFactory.mapOf(
                    1, CollectionFactory.mapOf("1", TestSubClass.of(11, "11")),
                    2, CollectionFactory.mapOf("2", TestSubClass.of(12, "12"))
            );
        }
        class B {
            @ElementType(value = TestSubClass.class, nestingLevel = 1)
            Map<String, Map<String, Map<String, TestSubClass>>> m = CollectionFactory.mapOf(
                    "1", CollectionFactory.mapOf("2", CollectionFactory.mapOf("3", testValues)),
                    "1", CollectionFactory.mapOf("2", CollectionFactory.mapOf("3", testValues))
            );
        }
        class C {
            @ElementType(value = TestSubClass.class, nestingLevel = 3)
            Map<String, Map<String, Map<String, TestSubClass>>> m = CollectionFactory.mapOf(
                    "1", CollectionFactory.mapOf("2", CollectionFactory.mapOf("3", testValues)),
                    "1", CollectionFactory.mapOf("2", CollectionFactory.mapOf("3", testValues))
            );
        }
        class D {
            @ElementType(value = TestSubClass.class, nestingLevel = 1)
            Map<Integer, Map<String, TestSubClass>> m = CollectionFactory.mapOf(
                    1, CollectionFactory.mapOf("1", TestSubClass.of(11, "11")),
                    2, CollectionFactory.mapOf("2", TestSubClass.of(12, "12")),
                    3, CollectionFactory.mapOf("3", TestSubClass.of(13, "13")),
                    4, CollectionFactory.mapOf("4", TestSubClass.of(14, "14"))
            );
        }

        String msg = "Field 'm2' of class 'A' has a nesting level of 0 but the " +
                "first object of type 'TestSubClass' was found on level 1.";
        FieldMapperHelpers.assertItmCfgExceptionMessage(new A(), msg);

        msg = "Field 'm' of class 'B' has a nesting level of 1 but the " +
                "first object of type 'TestSubClass' was found on level 2.";
        FieldMapperHelpers.assertItmCfgExceptionMessage(new B(), msg);

        msg = "Field 'm' of class 'C' has a nesting level of 3 but the " +
                "first object of type 'TestSubClass' was found on level 2.";
        FieldMapperHelpers.assertItmCfgExceptionMessage(new C(), msg);

        Map<String, Object> map = FieldMapperHelpers.instanceToMap(new D());
        D d = FieldMapperHelpers.instanceFromMap(new D(), map);
        assertThat(d.m, is(new D().m));
    }

    /* The case that the nestingLevel is set to high cannot properly be detected. */
    @Test
    void instanceFromMapRequiresCorrectNestingLevelForLists() {
        class A {
            @ElementType(TestSubClass.class)
            List<TestSubClass> l = CollectionFactory.listOf();
        }
        class B {
            @ElementType(FieldMapperHelpers.LocalTestEnum.class)
            List<FieldMapperHelpers.LocalTestEnum> l = CollectionFactory.listOf();
        }
        class C {
            @ElementType(TestSubClass.class)
            List<List<TestSubClass>> l = CollectionFactory.listOf();
        }
        class D {
            @ElementType(FieldMapperHelpers.LocalTestEnum.class)
            List<List<FieldMapperHelpers.LocalTestEnum>> l = CollectionFactory.listOf();
        }
        Map<String, Object> m = TestSubClass.TEST_VALUES.asMap();
        FieldMapperHelpers.instanceFromMap(new A(), CollectionFactory.mapOf("l", CollectionFactory.listOf(m)));
        FieldMapperHelpers.instanceFromMap(new B(), CollectionFactory.mapOf("l", CollectionFactory.listOf("S", "T")));

        String elementAsString = m.toString();
        String msg = "Field 'l' of class 'C' has a nesting level of 0 but element '[" +
                elementAsString + "]' of type 'ArrayList' cannot be converted " +
                "to 'TestSubClass'.";
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new C(), CollectionFactory.mapOf("l", CollectionFactory.listOf(CollectionFactory.listOf(m))), msg);

        msg = "Field 'l' of class 'D' has a nesting level of 0 but element '[S, T]' of type " +
                "'ArrayList' cannot be converted to 'LocalTestEnum'.";
        FieldMapperHelpers.assertIfmCfgExceptionMessage(new D(), CollectionFactory.mapOf("l", CollectionFactory.listOf(CollectionFactory.listOf("S", "T"))), msg);
    }
}
