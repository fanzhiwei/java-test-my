package net.fanzhiwei.mylib.structure;

import org.junit.Test;

/**
 * User: zhiweifan
 * Date: 14-3-13
 * Time: 下午4:20
 */
public class MenuTree {
    @Test
    public void test() {
        //建顶级菜单
        MenuTreeItem root = new MenuTreeItem("顶级");
        //二级菜单
        MenuTreeItem second1 = new MenuTreeItem("二级1",root);
        MenuTreeItem second2 = new MenuTreeItem("二级2",root);
        //三级菜单
        MenuTreeItem three1 = new MenuTreeItem("三级1",second1);
        MenuTreeItem three2 = new MenuTreeItem("三级2",second1);
        MenuTreeItem three3 = new MenuTreeItem("三级3",second2);
        MenuTreeItem three4 = new MenuTreeItem("三级4",second2);

        //递归遍历
        printMenu(root,0);
    }

    /**
     * 递归当前树
     * @param tree
     */
    private void printMenu(MenuTreeItem tree,int level) {
        for (int i = 0;i < level;i++) {
            System.out.print("\t");
        }
        System.out.println(tree.getName());
        if (tree.hasChild()) {
            level++;
            for (MenuTreeItem t : tree.getChildList()) {
                printMenu(t,level);
            }
        }
    }
}
