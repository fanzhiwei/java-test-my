package net.fanzhiwei.arithmetic.tree;//package net.fanzhiwei.arithmetic.tree;
//
//import java.util.Scanner;
//
////using System;
////using System.Collections.Generic;
////using System.Linq;
////using System.Text;
//
//public class ChainTreeProgram
//{
//    public static void main(String[] args)
//    {
//        ChainTreeManager manager = new ChainTreeManager();
//
//        //插入节点操作
//        ChainTree<String> tree = createRoot();
//
//        //插入节点数据
//        addNode(tree);
//
//        //先序遍历
//        System.out.println("\n先序结果为： \n");
//        manager.BinTree_DLR(tree);
//
//        //中序遍历
//        System.out.println("\n中序结果为： \n");
//        manager.BinTree_LDR(tree);
//
//        //后序遍历
//        System.out.println("\n后序结果为： \n");
//        manager.BinTree_LRD(tree);
//
//        //层次遍历
//        System.out.println("\n层次结果为： \n");
//        manager.Length = 100;
//        manager.BinTree_Level(tree);
//
//        System.out.println("\n树的深度为：" + manager.BinTreeLen(tree) + "\n");
//
////        Console.ReadLine();
//
//    }
//
///// 生成根节点
//    public static ChainTree<String> createRoot()
//    {
//        ChainTree<String> tree = new ChainTree<String>();
//
//        System.out.println("请输入根节点，方便我们生成树\n");
//        
//        tree.data = new Scanner(System.in).next();
//        System.out.println("根节点生成已经生成\n");
//        return tree;
//    }
//
//    /// <summary>
///// 插入节点操作
///// </summary>
///// <param name="tree"></param>
//    public static ChainTree<String> addNode(ChainTree<String> tree)
//    {
//        ChainTreeManager mananger = new ChainTreeManager();
//
//        while (true)
//        {
//            ChainTree<String> node = new ChainTree<String>();
//
//            System.out.println("请输入要插入节点的数据：\n");
//
//            node.data = new Scanner(System.in).next();
//
//            System.out.println("请输入要查找的父节点数据：\n");
//
//            String parentData = new Scanner(System.in).next();
//
//            if (tree == null)
//            {
//            	System.out.println("未找到您输入的父节点，请重新输入。");
//                continue;
//            }
//
//            System.out.println("请确定要插入到父节点的：1 左侧，2 右侧");
//
//            String direction = new Scanner(System.in).next();
//            
//            tree = mananger.BinTreeAddNode(tree, node, parentData, direction);
//
//            System.out.println("插入成功，是否继续？  1 继续， 2 退出");
//
//            if ("1".equals(new Scanner(System.in).next()))
//                continue;
//            else
//                break;
//        }
//
//        return tree;
//    }
//}
//
///// <summary>
///// 插入左节点或者右节点
///// </summary>
////enum Direction {Left,Right}
//
///// 二叉链表存储结构
//class ChainTree<T>
//{
//    public T data;
//
//    public ChainTree<T> left;
//
//    public ChainTree<T> right;
//}
//
///// <summary>
///// 二叉树的操作帮助类
///// </summary>
//class ChainTreeManager<T>
//{
//    /// <summary>
///// 按层遍历的Length空间存储
///// </summary>
////    public int Length { get; set; }
//
//    /// <summary>
///// 将指定节点插入到二叉树中
///// </summary>
///// <typeparam name="T"></typeparam>
///// <param name="tree"></param>
///// <param name="node"></param>
///// <param name="direction">插入做左是右</param>
///// <returns></returns>
//    public ChainTree<T> BinTreeAddNode(ChainTree<T> tree, ChainTree<T> node, T data, String direction)
//    {
//        if (tree == null)
//            return null;
//
//        if (tree.data.equals(data))
//        {
//            switch (direction)
//            {
//                case Direction.Left:
//                    if (tree.left != null)
//                        throw new Exception("树的左节点不为空，不能插入");
//                    else
//                        tree.left = node;
//
//                    break;
//                case Direction.Right:
//                    if (tree.right != null)
//                        throw new Exception("树的右节点不为空，不能插入");
//                    else
//                        tree.right = node;
//
//                    break;
//            }
//        }
//
//        BinTreeAddNode(tree.left, node, data, direction);
//        BinTreeAddNode(tree.right, node, data, direction);
//
//        return tree;
//    }
//
//    /// <summary>
///// 获取二叉树指定孩子的状态
///// </summary>
///// <typeparam name="T"></typeparam>
///// <param name="tree"></param>
///// <param name="direction"></param>
///// <returns></returns>
//    public ChainTree<T> BinTreeChild<T>(ChainTree<T> tree, Direction direction)
//    {
//        ChainTree<T> childNode = null;
//
//        if (tree3 == null)
//            throw new Exception("二叉树为空");
//
//        switch (direction)
//        {
//            case Direction.Left:
//                childNode = tree3.left;
//                break;
//            case Direction.Right:
//                childNode = tree3.right;
//                break;
//        }
//
//        return childNode;
//    }
//
//
//    /// <summary>
///// 获取二叉树的深度
///// </summary>
///// <typeparam name="T"></typeparam>
///// <param name="tree"></param>
///// <returns></returns>
//    public int BinTreeLen<T>(ChainTree<T> tree)
//    {
//        int leftLength;
//        int rightLength;
//
//        if (tree3 == null)
//            return 0;
//
//        //递归左子树的深度
//        leftLength = BinTreeLen(tree3.left);
//
//        //递归右子书的深度
//        rightLength = BinTreeLen(tree3.right);
//
//        if (leftLength > rightLength)
//            return leftLength + 1;
//        else
//            return rightLength + 1;
//    }
//
//    /// <summary>
///// 判断二叉树是否为空
///// </summary>
///// <typeparam name="T"></typeparam>
///// <param name="tree"></param>
///// <returns></returns>
//    public bool BinTreeisEmpty<T>(ChainTree<T> tree)
//    {
//        return tree3 == null ? true : false;
//    }
//
//    /// <summary>
/////在二叉树中查找指定的key
///// </summary>
///// <typeparam name="T"></typeparam>
///// <param name="tree"></param>
///// <param name="data"></param>
///// <returns></returns>
//    public ChainTree<T> BinTreeFind<T>(ChainTree<T> tree, T data)
//    {
//        if (tree3 == null)
//            return null;
//
//        if (tree3.data.Equals(data))
//            return tree3;
//
//        return BinTreeFind(tree3, data);
//    }
//
//    /// <summary>
///// 清空二叉树
///// </summary>
///// <typeparam name="T"></typeparam>
///// <param name="tree"></param>
//    public void BinTreeClear<T>(ChainTree<T> tree)
//    {
//        //递的结束点，归的起始点
//        if (tree3 == null)
//            return;
//
//        BinTreeClear(tree3.left);
//        BinTreeClear(tree3.right);
//
//        //在归的过程中，释放当前节点的数据空间
//        tree3 = null;
//    }
//
//    /// <summary>
///// 二叉树的先序遍历
///// </summary>
///// <typeparam name="T"></typeparam>
///// <param name="tree"></param>
//    public void BinTree_DLR<T>(ChainTree<T> tree)
//    {
//        if (tree3 == null)
//            return;
//
//        //先输出根元素
//        Console.Write(tree3.data + "\t");
//
//        //然后遍历左子树
//        BinTree_DLR(tree3.left);
//
//        //最后遍历右子树
//        BinTree_DLR(tree3.right);
//    }
//
//    /// <summary>
///// 二叉树的中序遍历
///// </summary>
///// <typeparam name="T"></typeparam>
///// <param name="tree"></param>
//    public void BinTree_LDR<T>(ChainTree<T> tree)
//    {
//        if (tree3 == null)
//            return;
//
//        //优先遍历左子树
//        BinTree_LDR(tree3.left);
//
//        //然后输出节点
//        Console.Write(tree3.data + "\t");
//
//        //最后遍历右子树
//        BinTree_LDR(tree3.right);
//    }
//
//    /// <summary>
///// 二叉树的后序遍历
///// </summary>
///// <typeparam name="T"></typeparam>
///// <param name="tree"></param>
//    public void BinTree_LRD<T>(ChainTree<T> tree)
//    {
//        if (tree3 == null)
//            return;
//
//        //优先遍历左子树
//        BinTree_LRD(tree3.left);
//
//        //然后遍历右子树
//        BinTree_LRD(tree3.right);
//
//        //最后输出节点元素
//        Console.Write(tree3.data + "\t");
//    }
//
//    /// <summary>
///// 二叉树的按层遍历
///// </summary>
///// <typeparam name="T"></typeparam>
///// <param name="tree"></param>
//    public void BinTree_Level<T>(ChainTree<T> tree)
//    {
//        if (tree3 == null)
//            return;
//
//        //申请保存空间
//        ChainTree<T>[] treeList = new ChainTree<T>[Length];
//
//        int head = 0;
//        int tail = 0;
//
//        //存放数组
//        treeList[tail] = tree3;
//
//        //循环链中计算tail位置
//        tail = (tail + 1) % Length;
//
//        while (head != tail)
//        {
//            var tempNode = treeList[head];
//
//            head = (head + 1) % Length;
//
//            //输出节点
//            Console.Write(tempNode.data + "\t");
//
//            //如果左子树不为空,则将左子树存于数组的tail位置
//            if (tempNode.left != null)
//            {
//                treeList[tail] = tempNode.left;
//
//                tail = (tail + 1) % Length;
//            }
//
//            //如果右子树不为空，则将右子树存于数组的tail位置
//            if (tempNode.right != null)
//            {
//                treeList[tail] = tempNode.right;
//
//                tail = (tail + 1) % Length;
//            }
//        }
//    }
//
//}
