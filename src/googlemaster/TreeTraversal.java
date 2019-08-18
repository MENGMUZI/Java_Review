package googlemaster;


/**
 * @author : mengmuzi
 * create at:  2019-08-14  22:24
 * @description: 1.二叉树的遍历 2.根据前序和中序求后序
 */

class TreeNode {

    private final char value;

    private TreeNode left;

    private TreeNode right;

    private TreeNode parent;

    public TreeNode(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public char getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
        if(left != null){
            this.left.setParent(this);
        }
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
        if(right != null){
            this.right.setParent(this);
        }
    }

    public TreeNode getParent() {
        return parent;
    }

    private void setParent(TreeNode parent) {
        this.parent = parent;
    }
}

class TreeCreator {
    public TreeNode createSampleTree() {
        TreeNode root = new TreeNode('A');
        root.setLeft(new TreeNode('B'));
        root.setRight(new TreeNode('C'));
        root.getLeft().setLeft(new TreeNode('D'));
        root.getLeft().setRight(new TreeNode('E'));
        root.getLeft().getRight().setLeft(new TreeNode('G'));
        root.getRight().setRight(new TreeNode('F'));
        return root;
    }

    //根据前序和中序求后序
    public TreeNode createTreeByPreAndIn(String preOrder, String inOrder) {
        if (preOrder.isEmpty()) {
            return null;
        }
        char rootValue = preOrder.charAt(0);
        int rootIndex = inOrder.indexOf(rootValue);

        TreeNode root = new TreeNode(rootValue);
        root.setLeft(createTreeByPreAndIn(preOrder.substring(1, 1 + rootIndex), inOrder.substring(0, rootIndex)));
        root.setRight(createTreeByPreAndIn(preOrder.substring(1 + rootIndex), inOrder.substring(1 + rootIndex)));

        return root;
    }


}

//二叉树的遍历
public class TreeTraversal {

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getValue());
        inOrder(root.getRight());
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue());
    }

    public String postOrder(String preOrder, String inOrder) {
        if (preOrder.isEmpty()) {
            return "";
        }
        char rootValue = preOrder.charAt(0);
        int rootIndex = inOrder.indexOf(rootValue);
        return postOrder(preOrder.substring(1, 1 + rootIndex), inOrder.substring(0, rootIndex))
                + postOrder(preOrder.substring(1 + rootIndex), inOrder.substring(1 + rootIndex))
                + rootValue;

    }


    public static void main(String[] args) {
        TreeCreator treeCreator = new TreeCreator();
        TreeTraversal treeTraversal = new TreeTraversal();
        TreeNode tree = treeCreator.createSampleTree();
        treeTraversal.preOrder(tree);
        System.out.println();
        treeTraversal.inOrder(tree);
        System.out.println();
        treeTraversal.postOrder(tree);
        System.out.println();

        System.out.println("=======CreateTreeByPreOrderAndInOrder======");
        TreeNode node = treeCreator.createTreeByPreAndIn("ABDEGCF", "DBGEACF");
        treeTraversal.postOrder(node);
        System.out.println();

        System.out.println("=======PostOrderByPreOrderAndInOrder======");
        System.out.println(treeTraversal.postOrder("ABDEGCF", "DBGEACF"));

    }

}
