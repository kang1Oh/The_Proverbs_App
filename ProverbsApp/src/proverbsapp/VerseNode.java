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
public class VerseNode {
    int chapter, verse;
    String unformatted, formatted, keywords;
    int height;
    VerseNode self;
    VerseNode leftTree;
    VerseNode rightTree;
    
    public VerseNode() {
        chapter = 0;
        verse = 0; 
        unformatted = ""; 
        formatted = ""; 
        keywords = "";
        height = 0;
        leftTree = null;
        rightTree = null;
    }
    public VerseNode(int c, int v, String uf, String f, String keyw) {
        chapter = c;
        verse = v; 
        unformatted = uf; 
        formatted = f; 
        keywords = keyw;
    }
    
    public VerseNode(int c, int v, String uf, String f, String keyw, int h, VerseNode LT, VerseNode RT) {
        chapter = c;
        verse = v; 
        unformatted = uf; 
        formatted = f; 
        keywords = keyw;
        height = h;
        leftTree = LT;
        rightTree = RT;
    }
    
    
    public void setSelf(VerseNode x){
        self = x;
    }
    public void setChapter(int x) {
        this.chapter = x;
    }
    public void setVerse(int x) {
        this.verse = x;
    }
    public void setUnformattedText(String x) {
        this.unformatted = x;
    }
    public void setFormattedText(String x) {
        this.formatted = x;
    }
    public void setKeywords(String x) {
        this.keywords = x;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public void setLeftTree(VerseNode leftTree) {
        this.leftTree = leftTree;
    }
    public void setRightTree(VerseNode rightTree) {
        this.rightTree = rightTree;
    }

    public VerseNode getSelf(){
        return self;
    }
    public int getChapter() {
        return this.chapter;
    }
    public int getVerse() {
        return this.verse;
    }
    public String getUnformattedText() {
        return this.unformatted;
    }
    public String getFormattedText() {
        return this.formatted;
    }
    public String getKeywords() {
        return this.keywords;
    }
    public int getHeight(){
        return height;
    }
    public VerseNode getLeftTree() {
        return leftTree;
    }
    public VerseNode getRightTree() {
        return rightTree;
    }
    
    public boolean equals(VerseNode n){
        return (this.self == n.getSelf());
    }
    @Override
    public String toString() {
        return "<html>Chapter "+chapter
              +" Verse "+verse +"<br>"
              +"<br>"+formatted+"</html>";
    }
    
    
    
    
    
    
}
