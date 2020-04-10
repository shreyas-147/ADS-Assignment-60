/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADSASG;

import java.util.HashSet;

/**
 *
 * @author Shreyas Kolte
 */
public class BTAsg {
    public static void main(String[] args) {
        Btree tree=new Btree(3);
        HashSet<Integer> ret=new HashSet<>();
        tree.insert(23);
        tree.insert(35);
        tree.insert(40);
        tree.insert(65);
        tree.insert(72);
        tree.insert(73);
        tree.insert(70);
        tree.insert(80);
        System.out.println("Normal Traversal");
        tree.traverse();
        System.out.println("Reverse Traversal");
        ret=tree.traverseRev();
    }
}
class Btree { 
    public BTNode root; 
    public int t;  
    Btree(int t) { 
        this.root = null; 
        this.t = t; 
        
    } 
  
    public void traverse() { 
        if (this.root != null) 
            this.root.traverse(); 
        System.out.println(); 
    } 
  
    public HashSet<Integer> traverseRev() { 
        if (this.root != null) 
            return this.root.traverseRev(); 
        else
            return null;
    }
    
    public void insert(int k) 
    { 
        if (root == null) 
        { 
            root = new BTNode(t, true); 
            root.keys[0] = k;  
            root.n = 1;  
//            System.out.println("Inserted In Null");
        } 
        else 
        { 
//            System.out.println("Insering without null");
            if (root.n == 2*t-1) 
            { 
                BTNode s = new BTNode(t, false); 
                s.C[0] = root; 
                s.splitChild(0, root); 
                int i = 0; 
                if (s.keys[0] < k) 
                    i++; 
                s.C[i].insertNonFull(k);
                root = s; 
            } 
            else  
                root.insertNonFull(k); 
        } 
    }
}

class BTNode { 
    int[] keys;
    int t; 
    BTNode[] C; 
    int n; 
    boolean leaf;  
    int rootcount=1;
    int travelcount=0;
    HashSet<Integer> arrRev ;
 
    BTNode(int t, boolean leaf) { 
        this.t = t; 
        this.leaf = leaf; 
        this.keys = new int[2 * t - 1]; 
        this.C = new BTNode[2 * t]; 
        this.n = 0;
        arrRev = new HashSet<>();
    } 
  
    public void traverse() { 
        int i = 0; 
        for (i = 0; i < this.n; i++) { 
            if (this.leaf == false) { 
                C[i].traverse(); 
            } 
            System.out.print(keys[i] + " "); 
        } 
  
        if (leaf == false) 
            C[i].traverse(); 
    } 
    
  
    public HashSet<Integer> traverseRev() { 
        
        int i = this.n==2*t-1?this.n-1:this.n;
        travelcount++;
        for (; i >=0; i--) {          
            if (this.leaf == false) { 
                    arrRev=C[i].traverseRev(); 
            } 
            if(keys[i]>0){ 
                if(!arrRev.contains(keys[i])){
                    arrRev.add(keys[i]);
                    System.out.print(keys[i] + " ");
                }
            } 
        } 
        if(i<0){
            return arrRev ;
        }
        if (leaf == false) 
            arrRev=C[i].traverseRev(); 
        
        return arrRev;
    } 
    
    
    public void insertNonFull(int k) 
    { 
        int i = n-1; 
        if (leaf == true) 
        { 
            while (i >= 0 && keys[i] > k) 
            { 
                keys[i+1] = keys[i]; 
                i--; 
            } 
            keys[i+1] = k; 
            n = n+1; 
        } 
        else 
        { 
            while (i >= 0 && keys[i] > k) 
                i--; 
            if (C[i+1].n == 2*t-1) 
            { 
                splitChild(i+1, C[i+1]); 
                if (keys[i+1] < k) 
                    i++; 
            } 
            C[i+1].insertNonFull(k); 
        } 
    }
    
    
    
    public void splitChild(int i, BTNode y) 
    { 
        BTNode z = new BTNode(y.t, y.leaf); 
        z.n = t - 1; 
        for (int j = 0; j < t-1; j++) 
            z.keys[j] = y.keys[j+t]; 
        if (y.leaf == false) 
        { 
            for (int j = 0; j < t; j++) 
                z.C[j] = y.C[j+t]; 
        } 
        y.n = t - 1; 
        for (int j = n; j >= i+1; j--) 
            C[j+1] = C[j]; 
        C[i+1] = z; 
        for (int j = n-1; j >= i; j--) 
            keys[j+1] = keys[j]; 
        keys[i] = y.keys[t-1]; 
        n = n + 1; 
    }
}

/*
!!!OUTPUT!!!
run:
Normal Traversal
23 35 40 65 70 72 73 80 
Reverse Traversal
80 73 72 70 65 40 35 23 BUILD SUCCESSFUL (total time: 0 seconds)


*/
