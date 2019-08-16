package googlemaster;

/**
 * @author : mengmuzi
 * create at:  2019-08-17  01:22
 * @description: 寻找中序遍历的下一个节点
 */
public class InOrder {
    public TreeNode next(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.getRight() != null) {
            return first(node.getRight());
        } else {
            while (node.getParent() != null && node.getParent().getLeft() != node) {
                node = node.getParent();
            }
            return node.getParent();
        }
    }

    private TreeNode first(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode curNode = node;//因为要保留当前的节点，所以重新搞了一个新的节点
        while (curNode.getLeft() != null) {
            curNode = curNode.getLeft();
        }
        return curNode;
    }


    public static void main(String[] args) {
        TreeCreator treeCreator = new TreeCreator();
        InOrder inOrder = new InOrder();

        TreeNode sampleTree = treeCreator.createSampleTree();
        for (TreeNode node = inOrder.first(sampleTree); node != null; node = inOrder.next(node)) {
            System.out.print(node.getValue());
        }
        System.out.println();

    }

}
