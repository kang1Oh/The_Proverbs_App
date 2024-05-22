/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proverbsapp;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Janey
 */
public class VerseFileHandling{
    
    public static VerseAVLTree readVersesFromFile(String file){
        VerseAVLTree avltree = new VerseAVLTree();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine(); // skip the first line
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                int chapter = Integer.parseInt(parts[0]);
                int verse = Integer.parseInt(parts[1]);
                String unformatted = parts[2];
                String formatted = parts[3];
                String keywords = parts[4];
                VerseNode node = new VerseNode(chapter, verse, unformatted, formatted, keywords);
                avltree.setRoot(avltree.insert(avltree.getRoot(), node));
            }
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to read data from file!");
        }
        return avltree;
    }
    
    //ReadFile Method Test [Please Ignore]: BEGIN
    
    
    public static void main(String[] args){
        VerseAVLTree avlTree = readVersesFromFile("Proverbs6to10.txt");
        
        System.out.println("AVL Tree Root: \n   "+avlTree.getRoot()+"\n");
        
        System.out.println(  "++===== TREE TRAVERSALS =====++\n");
        // Print the inorder traversal of the AVL tree
        System.out.println("Inorder Traversal:");
        avlTree.InOrder(avlTree.getRoot());
        System.out.println("\n");
        // Print the preorder traversal of the AVL tree
        System.out.println("Preorder Traversal:");
        avlTree.PreOrder(avlTree.getRoot());
        System.out.println("\n");
        // Print the postOrder traversal of the AVL tree
        System.out.println("Postorder Traversal:");
        avlTree.PostOrder(avlTree.getRoot());
        System.out.println("\n");
        
        try{
            VerseNode found = avlTree.searchNode(1,34, avlTree.getRoot());
            System.out.println("test search: \n"+found.toString());
        }catch(Exception e){
            System.out.println("Verse does not exist.");
        }
        
            
        try{
            VerseNode found1 = avlTree.searchNodeByKeyword("disgrace", avlTree.getRoot());
            System.out.println("test search: \n"+found1.toString());
        }catch(Exception e){
            System.out.println("Verse does not exist.");
        }
    }
    
    //ReadFile Method Test [Please Ignore]: END
    
}
