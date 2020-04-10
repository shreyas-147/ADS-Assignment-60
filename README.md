# ADS-Assignment-60
Problem Statement: To traverse a B-Tree in reverse order.
Flow Of the Program:- 
Classes Involved :-Btree, BTNode, BTAsg(Driver Class)
Methods Involved:- 
Btree: insert(int){BTNode.insertNonFull(int)} , 
        traverse(){BTNode.traverse()},
        traverseRev(){BTNode.traverseRev()}
BTNode: traverse(),
        traverseRev(),
        insertNonFull(int){splitChild(int,BTNode)},
        splitChild(int,BTNode)

Dataset (Already Feeded) (23 35 40 65 72 73 70 80 )

OUTPUT:
run:
Normal Traversal
23 35 40 65 70 72 73 80 
Reverse Traversal
80 73 72 70 65 40 35 23 BUILD SUCCESSFUL (total time: 0 seconds)

Description:
1) Object of Btree is created.
2) Minimum degree of tree is set to 3.
3) Keys are inserted in the tree using tree.insert() .
4) If the tree is not empty then insert() will call BTNode.insertNonFull() .
5)First, normal traversal is printed using traverse() method.
6) Second, reverse traversal is printed using traverseRev() method.
