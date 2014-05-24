package net.fanzhiwei.mylib.guava;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import static com.google.common.collect.Sets.SetView;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * User: zhiweifan
 * Date: 14-5-22
 * Time: 下午5:37
 */
public class GuavaCollectionsTest {
    //不可变list与map创建
    @Test
    public void guavaListMap() {
        //快速创建不可变list
        ImmutableList<String> ofList = ImmutableList.of("a", "b", "c", "d");
        //快速创建不可变map,根据源码（），最多建五个大小
        ImmutableMap<String, String> ofMap = ImmutableMap.of("key1", "value1", "key2", "value2");
        System.out.println("ImmutableMap大小" + ofMap.size());

        Map<String, Map<Long, List<String>>> map = Maps.newHashMap();
//        Lists.newArrayList();
//        Sets.newHashSet();

//        把一个List转换为int数组
        List<Integer> list = ImmutableList.of(1, 2, 3, 4);
        int[] array2 = Ints.toArray(list);
    }

    @Test
    public void functionTest() {
//       方法签名 public static <K,V1,V2> Map<K,V2> transformValues(Map<K,V1> fromMap, Function<? super V1,V2> function)
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
    public void Preconditions() throws Exception {

        getPersonByPrecondition(8,"peida");

        try {
            getPersonByPrecondition(-9,"peida");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            getPersonByPrecondition(8,"");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            getPersonByPrecondition(8,null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getPersonByPrecondition(int age,String neme)throws Exception{
        Preconditions.checkNotNull(neme, "neme为null");
        Preconditions.checkArgument(neme.length()>0, "neme为\'\'");
        Preconditions.checkArgument(age>0, "age 必须大于0");
        System.out.println("a person age:"+age+",neme:"+neme);
    }
}
