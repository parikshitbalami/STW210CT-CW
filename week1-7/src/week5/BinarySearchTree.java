package week5;

public class BinarySearchTree {
public static class Node{
Node left;
Node right;
int data;
Node(int data){
this.data=data;
this.left=null;
this.right=null;
}
}
public Node BST(Node root,int data) {
//root=50
//data=40
//root.left=null= root
if(root ==null) {
return new Node(data);
}
if(data<root.data) {
root.left=BST(root.left,data);
}
else {
root.right=BST(root.right,data);
}
return root;

}
public void inorder(Node root) {
if(root==null) {
return;
}
inorder(root.left);
System.out.println(root.data);
inorder(root.right);
}
public static void main(String [] args) {
BinarySearchTree tree=new BinarySearchTree();
Node root=null;
root=tree.BST(root,50);
root=tree.BST(root, 40);
root=tree.BST(root, 60);
}

}