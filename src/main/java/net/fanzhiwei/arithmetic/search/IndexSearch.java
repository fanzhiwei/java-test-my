package net.fanzhiwei.arithmetic.search;

// 索引项实体
class IndexItem
{
    public IndexItem(int index, int start, int lenght)
    {
        this.index = index;
        this.start = start;
        this.length = length;
    }

    // 对应主表的值
    public int index;
    // 主表记录区间段的开始位置
    public int start;
    // 主表记录区间段的长度
    public int length;
}

public class IndexSearch
{

    // 学生主表
    static int[] students =
    { 101, 102, 103, 104, 105, 0, 0, 0, 0, 0, 201, 202, 203, 204, 0, 0, 0, 0,
            0, 0, 301, 302, 303, 0, 0, 0, 0, 0, 0, 0 };

    // /学生索引表
    static IndexItem[] indexItem =
    { new IndexItem(1, 0, 5), new IndexItem(2, 10, 4), new IndexItem(3, 20, 3) };

    public static int indexSearch(int key)
    {
        IndexItem item = null;

        // 建立索引规则
        int index = key / 100;
        //首先去索引找
        for (int i = 0; i < indexItem.length; i++)
        {
            if (indexItem[i].index == index)
            {
                item = new IndexItem(index, indexItem[i].start,indexItem[i].length);
                break;
            }
        }

        //如果item为null，则说明在索引中查找失败
        if (item == null)
            return -1;

        for (int i = item.start; i < item.start + item.length; i++)
        {
            if (students[i] == key)
            {
                return i;
            }
        }
        return -1;
    }
}
// 索引查找：
//
// 一提到“索引”，估计大家第一反应就是“数据库索引”，对的，其实主键建立“索引”，就是方便我们在海量数据中查找。
//
// 关于“索引”的知识，估计大家都比我清楚，我就简单介绍下。
//
// 我们自己写算法来实现索引查找时常使用的三个术语：
//
// 第一：主表， 这个很简单，要查找的对象。
//
// 第二：索引项， 一般我们会用函数将一个主表划分成几个子表，每个子表建立一个索引，这个索引叫做索引项。
//
// 第三：索引表, 索引项的集合也就是索引表。
//
//
//
// 一般“索引项”包含三种内容：index，start，length
//
// 第一： index，也就是索引指向主表的关键字。
//
// 第二：start， 也就是index在主表中的位置。
//
// 第三：length, 也就是子表的区间长度。
