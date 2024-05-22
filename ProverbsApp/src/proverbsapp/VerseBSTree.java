package proverbsapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Janey
 */
public class VerseBSTree extends VerseBinaryTree {
    
    VerseBSTree(){
        super();        
    }
    
    VerseBSTree(VerseNode r){
        super(r);       
    }
    
    public VerseNode insert(VerseNode t, VerseNode newNode){
    
        if(t==null) {
            t = newNode; return t;
        }else if(t.getChapter()> newNode.getChapter()){ 
            t.setLeftTree(insert(t.getLeftTree(),newNode));
        }else if(t.getChapter()< newNode.getChapter()) {
            t.setRightTree(insert(t.getRightTree(),newNode));
        }else if(t.getChapter() == newNode.getChapter()){
            if(t.getVerse()> newNode.getVerse()){ 
                t.setLeftTree(insert(t.getLeftTree(),newNode));
            }else if(t.getVerse()< newNode.getVerse()) {
                t.setRightTree(insert(t.getRightTree(),newNode));
            }
        }
        
        return t;
    }
    
    public VerseNode findMin(VerseNode t){
        if(t==null) return null;
        else if(t.getLeftTree()==null) return t;
        return findMin(t.getLeftTree());
    
    }
    
    public VerseNode findMax(VerseNode t){
        if(t==null) return null;
        else if(t.getRightTree()==null) return t;
        return findMax(t.getRightTree());
    
    }
    
      
    
    public VerseNode searchNode(int chapter, int verse, VerseNode node) {
        if (chapter == 0 || verse == 0 || node == null) {
            return null;
        }

        // Compare chapter and verse with the current node
        if (chapter < node.getChapter()) {
            // If the target chapter is less, search in the left subtree
            return searchNode(chapter, verse, node.getLeftTree());
        } else if (chapter > node.getChapter()) {
            // If the target chapter is greater, search in the right subtree
            return searchNode(chapter, verse, node.getRightTree());
        } else {
            // If chapters are equal, compare verses
            if (verse < node.getVerse()) {
                // If the target verse is less, search in the left subtree
                return searchNode(chapter, verse, node.getLeftTree());
            } else if (verse > node.getVerse()) {
                // If the target verse is greater, search in the right subtree
                return searchNode(chapter, verse, node.getRightTree());
            } else {
                // Chapter and verse match, return the current node
                return node;
            }
        }
    }
    
    public VerseNode searchNodeByKeyword(String keyword, VerseNode node) {
        if (node == null || keyword.isBlank()) {
            return null;
        }

        // Split the keywords in node and check if any match the provided keyword
        String[] keywords = node.getKeywords().split(", ");
        for (String kw : keywords) {
            if (kw.equalsIgnoreCase(keyword)) {
                return node;
            }
        }

        // Recursively search in the left and right subtrees
        VerseNode leftResult = searchNodeByKeyword(keyword, node.getLeftTree());
        if (leftResult != null) {
            return leftResult;
        }

        return searchNodeByKeyword(keyword, node.getRightTree());
    }


      
    
    public VerseNode remove(VerseNode node,VerseNode t){
        if (t==null) return t;
        
        if (t.getLeftTree() != null && t.getRightTree() != null)
        {
            t.setSelf(findMin(t.getRightTree()).getSelf());
            t.setRightTree(remove(node,t.getRightTree()));
        }
        else 
            t = (t.getLeftTree() != null ) ? t.getLeftTree():t.getRightTree();
        
        return t;
    }
    
}
