package googlemaster;


/**
 * @author : mengmuzi
 * create at:  2019-08-14  22:24
 * @description: 二叉树的遍历
 */

class TreeNode{

    private final char value;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public char getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
class TreeCreator {
    public TreeNode createSampleTree(){
        TreeNode root = new TreeNode('A');
        root.setLeft(new TreeNode('B'));
        root.setRight(new TreeNode('C'));
        root.getLeft().setLeft(new TreeNode('D'));
        root.getLeft().setRight(new TreeNode('E'));
        root.getLeft().getRight().setLeft(new TreeNode('G'));
        root.getRight().setRight(new TreeNode('F'));
        return root;
    }
}

public class TreeTraversal{

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getValue());
        inOrder(root.getRight());
    }
    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue());
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
    }

}
