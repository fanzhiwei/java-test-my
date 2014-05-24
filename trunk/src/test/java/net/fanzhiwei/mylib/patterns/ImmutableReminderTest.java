package net.fanzhiwei.mylib.patterns;

import net.fanzhiwei.mylib.patterns.ImmutableReminder;
import org.junit.Test;

import java.util.Date;

/**
 * User: zhiweifan
 * Date: 14-5-22
 * Time: 下午3:41
 */
public class ImmutableReminderTest {

    @Test
    public void immutableReminderFalseTest () {

        //可变对象传入，当可变对象改变时，输出结果的变化
        Date date = new Date(1550746230225l);
        ImmutableReminder ir = new ImmutableReminder(date,false);
        System.out.println(ir.getRemindingDate());
        date.setTime(1220746230225l);
        System.out.println(ir.getRemindingDate());
    }

    @Test
    public void immutableReminderTrueTest () {

        //避免使用可变对象
        Date date = new Date(1550746230225l);
        ImmutableReminder ir = new ImmutableReminder(date,true);
        System.out.println(ir.getRemindingDate());
        date.setTime(1220746230225l);
        System.out.println(ir.getRemindingDate());
        ir.getRemindingDate().setTime(1600746230225l);
        System.out.println(ir.getRemindingDate());
    }
}
