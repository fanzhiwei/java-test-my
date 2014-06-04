package net.fanzhiwei.mylib.guava;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.*;

import static com.google.common.collect.Sets.SetView;

import com.google.common.primitives.Ints;
import net.fanzhiwei.mylib.dto.SimpleDTO;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

/**
 * User: zhiweifan
 * Date: 14-5-22
 * Time: 下午5:37
 */
public class GuavaCollectionsMapTest {
    //不可变list与map创建
    @Test
    public void guavaListMapSyntax() {
        //快速创建不可变list
        ImmutableList<String> ofList = ImmutableList.of("a", "b", "c", "d");
        //快速创建不可变map,根据源码（），最多建五个大小
        ImmutableMap<String, String> ofMap = ImmutableMap.of("key1", "value1", "key2", "value2");
        System.out.println("ImmutableMap大小" + ofMap.size());

        //Lists.newArrayList();
        //Sets.newHashSet();
        Map<String, Map<Long, List<String>>> map = Maps.newHashMap();

        //把一个List转换为int数组
        List<Integer> list = ImmutableList.of(1, 2, 3, 4);
        int[] array2 = Ints.toArray(list);
    }

    @Test
    public void functionTest() {
        //方法签名 public static <K,V1,V2> Map<K,V2> transformValues(Map<K,V1> fromMap, Function<? super V1,V2> function)
        Map<String, Integer> eurPriceMap = ImmutableMap.of("a", 4, "b", 9);
        Map<String, Double> usdPriceMap = Maps.transformValues(eurPriceMap, new Function<Integer, Double>() {
            double eurToUsd = 1.4888;

            public Double apply(final Integer from) {
                return from * eurToUsd;
            }
        });
        System.out.println(eurPriceMap);
        System.out.println(usdPriceMap);
    }

    @Test
    public void collectionsOpTest() {
        HashSet<Integer> setA = Sets.newHashSet(1, 2, 3, 4, 5);
        HashSet<Integer> setB = Sets.newHashSet(4, 5, 6, 7, 8);

        SetView<Integer> union = Sets.union(setA, setB);
        System.out.println("union:");
        for (Integer integer : union) {
            System.out.println(integer);
        }

        SetView<Integer> difference = Sets.difference(setA, setB);
        System.out.println("difference,before add:");
        for (Integer integer : difference) {
            System.out.println(integer);
        }
        //不同于惯例，这些方法没有做任何的拷贝。相反，他们返回了代表了这两个集合的视图。
        // 但是在有些情况下， 这些拷贝又很有用，我们可以用immutableCopy类中提供的一个便利方法来实现拷贝
        setB.add(3);//在取得difference后，再添加，结果返回添加此项后的不同视图，说明不是拷贝，注意使用。
        System.out.println("difference:");
        for (Integer integer : difference) {
            System.out.println(integer);
        }

        Sets.SetView<Integer> intersection = Sets.intersection(setA, setB);
        System.out.println("intersection:");
        for (Integer integer : intersection) {
            System.out.println(integer);
        }
    }

    @Test
    public void Preconditions() {

        getPersonByPrecondition(8, "peida");

        try {
            getPersonByPrecondition(-9, "peida");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            getPersonByPrecondition(8, "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            getPersonByPrecondition(8, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getPersonByPrecondition(int age, String neme) {
        Preconditions.checkNotNull(neme, "neme为null");
        Preconditions.checkArgument(neme.length() > 0, "neme为\'\'");
        Preconditions.checkArgument(age > 0, "age 必须大于0");
        System.out.println("a person age:" + age + ",neme:" + neme);
    }

    //Multimap的实现
    //Multimap提供了丰富的实现，所以你可以用它来替代程序里的Map<K, Collection<V>>，具体的实现如下：
    //Implementation             Keys 的行为类似       　　　 Values的行为类似
    //ArrayListMultimap          HashMap                   　ArrayList
    //HashMultimap               HashMap                  　 HashSet
    //LinkedListMultimap         LinkedHashMap*              LinkedList*
    //LinkedHashMultimap         LinkedHashMap               LinkedHashSet
    //TreeMultimap               TreeMap                     TreeSet
    //ImmutableListMultimap      ImmutableMap                ImmutableList
    //ImmutableSetMultimap       ImmutableMap                ImmutableSet
    @Test
    public void multiMapTest() {
        Multimap<String, SimpleDTO> multimap = ArrayListMultimap.create();
        SimpleDTO d1 = new SimpleDTO();
        d1.setStr("d1");
        multimap.put("aa", d1);
        SimpleDTO d2 = new SimpleDTO();
        d2.setStr("d2");
        multimap.put("aa", d2);
        //Map<String,Collection<SimpleDTO>> result =  multimap.asMap();
        List<SimpleDTO> list = (List<SimpleDTO>) multimap.get("aa");
        for (SimpleDTO testDto : list) {
            System.out.println(testDto.getStr());
        }
    }

    @Test
    public void multisetTest() {
        //常用实现 Multiset 接口的类有：
        //HashMultiset: 元素存放于 HashMap
        //LinkedHashMultiset: 元素存放于 LinkedHashMap，即元素的排列顺序由第一次放入的顺序决定
        //TreeMultiset:元素被排序存放于TreeMap
        //EnumMultiset: 元素必须是 enum 类型
        //ImmutableMultiset: 不可修改的 Mutiset
        //统计相同对象，如字符串在 List里面出现的次数
        ImmutableList<String> ofList = ImmutableList.of("a", "b", "a", "d");
        HashMultiset<String> multiSet = HashMultiset.create();
        multiSet.addAll(ofList);
        //count word “a”
        System.out.println(multiSet.count("a"));
        multiSet.setCount("a", 100);
        multiSet.add("a");
        //count word “a”
        System.out.println(multiSet.count("a"));
    }

    @Test
    public void biMapTest() {
        //BiMap的常用实现有：
        //HashBiMap: key 集合与 value 集合都有 HashMap 实现
        //EnumBiMap: key 与 value 都必须是 enum 类型
        //ImmutableBiMap: 不可修改的 BiMap
        BiMap<String, Integer> bm = HashBiMap.create();
        bm.put("A", 1);
        bm.put("B", 2);
        bm.put("C", 3);
        bm.put("D", 4);
        bm.put("E", 5);
        BiMap<Integer, String> inverseBm = bm.inverse();
        System.out.println(inverseBm.get(5));
        System.out.println(inverseBm.get(6));
    }

    @Test
    public void mapMakerTest() {
        //用来构造 ConcurrentHashMap
        //ConcurrentHashMap with concurrency level 8
        ConcurrentMap<String, Object> concurrentMap = new MapMaker().concurrencyLevel(8).makeMap();
        //构造用各种不同 reference 作为 key 和 value 的 Map:
        //ConcurrentMap with soft reference key and weak reference value
        ConcurrentMap<String, Object> map2 = new MapMaker().weakValues().makeMap();
    }

    @Test
    public void collections2FilterTest() {
        ImmutableList<Integer> list = ImmutableList.of(4, 12, 5, 2, 6, 15);
        Collection<Integer> filterCollection =
                Collections2.filter(list, new Predicate<Integer>() {
                    @Override
                    public boolean apply(Integer input) {
                        return input >= 10;
                    }
                });
        for (Integer i : filterCollection) {
            System.out.println(i);
        }
    }

    @Test
    public void collections2transformTest() {
        ImmutableList<String> ofList = ImmutableList.of("a", "b", "a", "d");
        Collection<String> formatCollection =
                Collections2.transform(ofList, new Function<String, String>() {
                    @Override
                    public String apply(String input) {
                        return input + "transform";
                    }
                });
        for (String str : formatCollection) {
            System.out.println(str);
        }
    }
}
