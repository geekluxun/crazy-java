package com.geekluxun.apache.commons.collections;

import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.collections4.*;
import org.springframework.util.Assert;
import org.w3c.dom.Node;

import javax.imageio.metadata.IIOMetadataNode;
import java.util.Iterator;
import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-13 15:42
 * @Description:
 * @Other:
 */
public class IteratorUtilsDemo {
    public static void main(String[] argc) {
        IteratorUtilsDemo demo = new IteratorUtilsDemo();
        demo.demo1();
        demo.demo2();
        demo.demo3();
        demo.demo4();
        demo.demo5();
        demo.demo6();
    }

    /**
     * 重置迭代器
     */
    private void demo1() {
        ResettableIterator<Integer> iterator = IteratorUtils.arrayIterator(1, 3, 4, 8, 10);
        iterator.forEachRemaining((e) -> System.out.println("element:" + e));
        Assert.isTrue(iterator.hasNext() == false);
        // 重置迭代器
        iterator.reset();
        Assert.isTrue(iterator.hasNext() == true);
        System.out.println();
    }

    /**
     * 双向迭代
     */
    private void demo2() {
        ResettableListIterator<Integer> iterator = IteratorUtils.arrayListIterator(1, 3, 4, 8, 10);
        while (iterator.hasNext()) {
            System.out.println("元素:" + iterator.next());
        }
        Assert.isTrue(iterator.hasNext() == false);
        Assert.isTrue(iterator.hasPrevious() == true);
        while (iterator.hasPrevious()) {
            System.out.println("向前迭代：" + iterator.previous());
        }
    }

    private void demo3() {
        List listA = Lists.newArrayList(3, 8, 1);
        List listB = Lists.newArrayList(2, 5, 7);
        // 按照自然顺序 每次迭代取两个迭代器next中较小的那个元素 顺序：2,3,5,7,8,1
        Iterator<Integer> iterator = IteratorUtils.collatedIterator(ComparatorUtils.naturalComparator(), listA.iterator(), listB.iterator());

        iterator.forEachRemaining((e) -> System.out.println("demo3联合后的元素:" + e));
        System.out.println();

    }

    private void demo4() {
        List listA = Lists.newArrayList(3, 8, 1);
        listA.sort(ComparatorUtils.naturalComparator());

        List listB = Lists.newArrayList(2, 5, 7);
        listB.sort(ComparatorUtils.naturalComparator());

        // 按照自然顺序 每次迭代取两个迭代器next中较小的那个元素
        Iterator<Integer> iterator = IteratorUtils.collatedIterator(ComparatorUtils.naturalComparator(), listA.iterator(), listB.iterator());

        iterator.forEachRemaining((e) -> System.out.println("demo4联合后的元素:" + e));
        System.out.println();

    }

    private void demo5() {
        Node root = new IIOMetadataNode("root");
        Node child1 = new IIOMetadataNode("child1");
        Node chiid2 = new IIOMetadataNode("child2");
        Node child11 = new IIOMetadataNode("child11");
        child1.appendChild(child11);
        root.appendChild(child1);
        root.appendChild(chiid2);
        Iterator<Node> iterator = IteratorUtils.nodeListIterator(root);
        // 此处不是递归遍历文档树，只是第一层!!!
        for (Node childNode : IteratorUtils.asIterable(iterator)) {
            System.out.println("节点：" + childNode.getNodeName());
        }

        System.out.println();
    }

    private void demo6() {
        Transformer transformer = new Transformer() {
            @Override
            public Object transform(Object input) {
                System.out.println("transform");
                if (input instanceof Leaf) {
                    return input;
                }
                if (input instanceof Branch) {
                    return ((Branch) input).getLeaves().iterator();
                }
                if (input instanceof Tree) {
                    return ((Tree) input).getBranches().iterator();
                }
                if (input instanceof Forest) {
                    return ((Forest) input).getTrees().iterator();
                }
                throw new ClassCastException();
            }
        };

        Branch branch = new Branch();
        branch.setLeaves(Lists.newArrayList(new Leaf(), new Leaf()));

        Tree tree = new Tree();
        tree.setBranches(Lists.newArrayList(branch));
        Forest forest = new Forest();
        forest.setTrees(Lists.newArrayList(tree));
        Iterator iterator = IteratorUtils.objectGraphIterator(forest, transformer);

        System.out.println();
    }

    @Data
    private class Forest {
        List<Tree> trees;

        public String toString() {
            return "我是森林";
        }
    }

    @Data
    private class Tree extends Forest {
        List<Branch> branches;

        public String toString() {
            return "我是大树";
        }
    }

    @Data
    private class Branch extends Tree {
        List<Leaf> leaves;

        @Override
        public String toString() {
            return "我是枝干";
        }
    }

    @Data
    private class Leaf extends Branch {
        @Override
        public String toString() {
            return "我是叶子";
        }
    }
}
