package net.fanzhiwei.mylib.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * User: zhiweifan
 * Date: 14-3-13
 * Time: 下午4:13
 * 建立一个多级树，并递归遍历它
 */
public class MenuTreeItem {
    private String name;
    private MenuTreeItem parent;
    private List<MenuTreeItem> childList;

    public MenuTreeItem(String name, MenuTreeItem parent) {
        this.name = name;
        this.parent = parent;
        parent.addChild(this);
    }

    public MenuTreeItem(String name) {
        this.name = name;
    }

    private void addChild(MenuTreeItem child) {
        if (childList == null) {
            childList = new ArrayList<MenuTreeItem>();
            childList.add(child);
        } else {
            childList.add(child);
        }
    }

    public boolean hasChild() {
        if (childList == null || childList.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public List<MenuTreeItem> getChildList() {
        return childList;
    }

    public MenuTreeItem getParent() {
        return parent;
    }
}
