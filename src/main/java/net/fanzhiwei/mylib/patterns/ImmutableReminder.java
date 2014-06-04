package net.fanzhiwei.mylib.patterns;


import java.util.Date;

/**
 * User: zhiweifan
 * Date: 14-5-22
 * Time: 下午3:30
 * 有时候你要实现的immutable类中可能包含mutable的类，比如java.util.Date,尽管你将其设置成了final的，
 * 但是它的值还是可以被修改的，为了避免这个问题，我们建议返回给用户该对象的一个拷贝，这也是Java的最佳实践之一。
 * 下面是一个创建包含mutable类对象的immutable类的例子
 * 使用Immutable类的好处：
 1）Immutable对象是线程安全的，可以不用被synchronize就在并发环境中共享

 2）Immutable对象简化了程序开发，因为它无需使用额外的锁机制就可以在线程间共享

 3）Immutable对象提高了程序的性能，因为它减少了synchroinzed的使用

 4）Immutable对象是可以被重复使用的，你可以将它们缓存起来重复使用，就像字符串字面量和整型数字一样。你可以使用静态工厂方法来提供类似于valueOf（）这样的方法，它可以从缓存中返回一个已经存在的Immutable对象，而不是重新创建一个。
 */
public final class ImmutableReminder{
    private final Date remindingDate;

    /**
     *
     * @param remindingDate
     * @param flag true为不可变，false
     */
    public ImmutableReminder (Date remindingDate,boolean flag) {
        if (flag) {
            if(remindingDate.getTime() < System.currentTimeMillis()){
                throw new IllegalArgumentException("Can not set reminder for past time: " + remindingDate);
            }
            //创建对象时，也不直接使用参数对象，防止可变化参数对象影响
            this.remindingDate = new Date(remindingDate.getTime());
        } else {
            this.remindingDate = remindingDate;
        }
    }

    public Date getRemindingDate() {
        //直接返回对象，会导致参数对象露出，被修改，下次再调用此方法获取时，返回的对象改变
        //return remindingDate;
        return (Date) remindingDate.clone();
    }
}

