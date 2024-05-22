package proverbsapp;


//import com.sun.media.jfxmedia.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Janey
 * 
 */
public class VerseBinaryTree {
    
    VerseNode root;
    VerseNode resultNode=null;
  
    
    VerseBinaryTree(){ root = null;  }
    VerseBinaryTree(VerseNode r) {  root = r;  }
    
    public VerseNode insert(VerseNode newNode, VerseNode t){
        if(t==null) t=newNode;
            
        else if (t.getLeftTree()== null) t.setLeftTree(insert(newNode,t.getLeftTree()));
        else if (t.getRightTree()== null) t.setRightTree(insert (newNode, t.getRightTree()));
        
      return newNode;
    }
    
    public void InOrder(VerseNode t){       
        if (t != null)  {
            InOrder(t.getLeftTree());
             System.out.print(t.toString()+" ");
            InOrder(t.getRightTree());
        }
    }
    
    public void PostOrder(VerseNode t){
        if (t != null)
        {
            PostOrder(t.getLeftTree());
            PostOrder(t.getRightTree());
            System.out.print(t.toString()+" ");
        }
    }
     
    public void PreOrder(VerseNode t){
        if (t != null)
        {
            System.out.print(t.toString()+" ");
            PreOrder(t.getLeftTree());
            PreOrder(t.getRightTree());
        }
    }
     
    public VerseNode getRoot(){
        return root;   
    }
    
    public int getHeight(VerseNode bt){
        if(bt == null)
            return -1;
        else
            return 1 + Math.max(getHeight(bt.getLeftTree()),getHeight(bt.getRightTree()));
    }
    
    public VerseNode searchNode(VerseNode t, VerseNode node) {
        if (t == null) {
            return null;
        }

        if (t.getChapter() > node.getChapter()) {
            return searchNode(node, t.getRightTree());
        } else if (t.getChapter() < node.getChapter()) {
            return searchNode(node, t.getLeftTree());
        } else if (t.getChapter() == node.getChapter()) {
            if (t.getVerse() > node.getVerse()) {
                return searchNode(node, t.getRightTree());
            } else if (t.getVerse() < node.getVerse()) {
                return searchNode(node, t.getLeftTree());
            } else {
                return t;  // Add this return statement to stop the recursion
            }
        }

        return null;
    }
    
    public void setRoot(VerseNode r){
        root=r;
    }
    
}
