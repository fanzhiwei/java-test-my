package net.fanzhiwei.mylib.guava;

import com.google.common.base.Optional;
import org.junit.Test;

import java.util.Set;

/**
 * User: zhiweifan
 * Date: 14-5-23
 * Time: 下午4:28
 */
public class GuavaOptionalTest {
    @Test
    public void test1() {
        String str;
        if (null instanceof java.lang.Object) {
            System.out.println("null属于java.lang.Object类型");
        }
    }

    @Test
    public void optionalTest() {
        Optional<Integer> possible=Optional.of(6);
        if(possible.isPresent()){
            System.out.println("possible isPresent:"+possible.isPresent());
            System.out.println("possible value:"+possible.get());
        }
    }

    @Test
    public void optionalStaticMethodTest() throws Exception {
        Optional<Integer> possible=Optional.of(6);
        Optional<Integer> absentOpt=Optional.absent();
        Optional<Integer> nullableOpt=Optional.fromNullable(null);
        Optional<Integer> notNullableOpt=Optional.fromNullable(10);
        if(possible.isPresent()){
            System.out.println("possible isPresent:"+possible.isPresent());
            System.out.println("possible value:"+possible.get());
        }
        if(absentOpt.isPresent()){
            System.out.println("absentOpt isPresent:"+absentOpt.isPresent()); ;
        }
        if(nullableOpt.isPresent()){
            System.out.println("fromNullableOpt isPresent:" + nullableOpt.isPresent()); ;
        }
        if(notNullableOpt.isPresent()){
            System.out.println("notNullableOpt isPresent:" + notNullableOpt.isPresent()); ;
        }
    }

    @Test
    public void optionalMethodTest() {
        Optional<Long> value = Optional.fromNullable(null);
        if(value.isPresent()==true){
            System.out.println("获得返回值: " + value.get());
        }else{
            System.out.println("获得返回值: " + value.or(-12L));
        }

        System.out.println("获得返回值 orNull: " + value.orNull());

        Optional<Long> valueNotNull = Optional.fromNullable(15L);
        if(valueNotNull.isPresent()==true){
            Set<Long> set=valueNotNull.asSet();
            System.out.println("获得返回值 set 的 size : " + set.size());
            System.out.println("获得返回值: " + valueNotNull.get());
        }else{
            System.out.println("获得返回值: " + valueNotNull.or(-12L));
        }

        System.out.println("获得返回值 orNull: " + valueNotNull.orNull());
    }
}
