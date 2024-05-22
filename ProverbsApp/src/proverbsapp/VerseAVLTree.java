/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proverbsapp;

/**
 *
 * @author Janey
 */
public class VerseAVLTree extends VerseBSTree{
    
    VerseAVLTree(){
        super();
    }
    VerseAVLTree(VerseNode r){
        super(r);
    }
    
    public void makeEmpty() {
        setRoot(makeEmpty(getRoot()));
    }

    // Recursive helper method to make a subtree empty
    private VerseNode makeEmpty(VerseNode node) {
        if (node == null) {
            return null;
        }

        // Recursively make the left and right subtrees empty
        node.setLeftTree(makeEmpty(node.getLeftTree()));
        node.setRightTree(makeEmpty(node.getRightTree()));

        // Set the current node to null, effectively removing it
        return null;
    }
    
    @Override
    public VerseNode insert(VerseNode t, VerseNode newNode){
        t = super.insert(t, newNode);
        t = balance(t);
        return t;
    }
    
    public int height(VerseNode node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }
    
    public void updateHeight(VerseNode node) {
        if (node != null) {
            int leftHeight = (node.getLeftTree() == null) ? 0 : node.getLeftTree().getHeight();
            int rightHeight = (node.getRightTree() == null) ? 0 : node.getRightTree().getHeight();
            node.setHeight(1 + Math.max(leftHeight, rightHeight));
        }
    }
    
    public int getBalanceFactor(VerseNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeftTree()) - height(node.getRightTree());
    }
    
    public VerseNode balance(VerseNode t){
        updateHeight(t);
        
        //check balance factor
        int balance = getBalanceFactor(t);
        // Left Heavy
        if (balance > 1) {
            // Left-Right Case
            if (getBalanceFactor(t.getLeftTree()) < 0) {
                t.setLeftTree(leftRotate(t.getLeftTree()));
            }
            // Left-Left Case
            return rightRotate(t);
        }
        // Right Heavy
        else if (balance < -1) {
            // Right-Left Case
            if (getBalanceFactor(t.getRightTree()) > 0) {
                t.setRightTree(rightRotate(t.getRightTree()));
            }
            // Right-Right Case
            return leftRotate(t);
        }

        return t; // Tree is balanced
    }
    
    public VerseNode rightRotate(VerseNode y) {
        VerseNode x = y.getLeftTree();
        VerseNode T2 = x.getRightTree();

        // Perform rotation
        x.setRightTree(y);
        y.setLeftTree(T2);

        // Update heights
        updateHeight(y);
        updateHeight(x);

        return x;
    }

    // Rotate the tree to the left
    public VerseNode leftRotate(VerseNode x) {
        VerseNode y = x.getRightTree();
        VerseNode T2 = y.getLeftTree();

        // Perform rotation
        y.setLeftTree(x);
        x.setRightTree(T2);

        // Update heights
        updateHeight(x);
        updateHeight(y);

        return y;
    }
    
    public boolean isBalanced() {
        return isBalanced(getRoot());
    }

    // Helper method to recursively check the balance of a subtree
    private boolean isBalanced(VerseNode node) {
        if (node == null) {
            return true; // An empty tree is always balanced
        }

        int balance = getBalanceFactor(node);

        // Check if the balance factor is within the valid range [-1, 1]
        if (balance < -1 || balance > 1) {
            return false;
        }

        // Recursively check the balance of the left and right subtrees
        return isBalanced(node.getLeftTree()) && isBalanced(node.getRightTree());
    }
}
