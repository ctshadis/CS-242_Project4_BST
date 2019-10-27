public class BinarySearchTree <E extends Comparable <E>>
        extends BinaryTree <E> implements SearchTree <E> {
   // this version uses iteration instead of recursion in search,
   // insert and delete

   // denotes whether the addition is successful
   // protected boolean addReturn;

   // denotes whether the deletion is successful
   // protected boolean deleteReturn;

   /**
     Constructor - initializes the tree to an empty tree
     */
   public BinarySearchTree () {
      super() ;
   }

   public BinarySearchTree(E data, BinarySearchTree <E> left,
          BinarySearchTree <E> right)  {
	   super(data, left, right);
   }

   /**
     Searches for a given element in the binary search tree
     @param
        someElement element to be searched
     @return
        true - if someElement is found in the tree; false
                  otherwise
     */
   // Complexity: O(h) - where h is the height of the tree.
   // In the worst case it could be O(n).  But on aveage
   // we can expect a complexity of O(log n)
   public boolean contains( E someElement) {
      return true;  // REMOVE THIS LINE WHEN YOU ARE DONE
      // TO BE COMPLETED BY THE STUDENT
   }

   /**
     Searches for a given element in the binary search tree
     @param
           someElement element to be searched
     @param count keeps track of the number of comparisons
      for this search
     @return
           E - if someElement is found in the tree; null
                     otherwise
    */
   // Complexity: O(h) - where h is the height of the tree.
   // In the worst case it could be O(n).  But on aveage
   // we can expect a complexity of O(log n)
   public E find (E someElement, IntObject count) {
      return someElement; // REMOVE THIS LINE WHEN YOU ARE DONE
      // TO BE COMPLETED BY THE STUDENT
    }

    /**
     inserts an element into a BST
     @param
        someElement element that needs to be inserted
     @param
        count keeps track of the number of comparisons
        done for this insert
     @return true if the insertion is successful, false otherwise
     */
   // Complexity: O(h) - where h is the height of the tree.
   // In the worst case it could be O(n).  But on aveage
   // we can expect a complexity of O(log n)
   public boolean add(E someElement) {
     return true; // REMOVE THIS LINE WHEN YOU ARE DONE
     // TO BE COMPLETED BY THE STUDENT
   }

   /**
     removes an element from a BST
     @param
       someElement element that needs to be deleted
     @return
	    returns true if someElement is found in the tree and is
	    successfully deleted; returns false if someElement is
        not found in the tree.
    */
   // Complexity: O(h) - where h is the height of the tree.
   // In the worst case it could be O(n).  But on aveage
   // we can expect a complexity of O(log n)
   public boolean remove(E someElement) {
      return true; // REMOVE THIS LINE WHEN YOU ARE DONE
      // TO BE COMPLETED BY THE STUDENT
   } // delete

   /** @return the minimum element in the Set */
   // Complexity: O(h) - where h is the height of the tree.
   // In the worst case it could be O(n).  But on aveage
   // we can expect a complexity of O(log n)


   public E first() {
	   return null; // REMOVE THIS LINE WHEN YOU ARE DONE
      // TO BE COMPLETED BY THE STUDENT
   }

   /** @return the maximum element in the Set */
   // Complexity: O(h) - where h is the height of the tree.
   // In the worst case it could be O(n).  But on aveage
   // we can expect a complexity of O(log n)
   public E last() {
	   return null; // REMOVE THIS LINE WHEN YOU ARE DONE
      	// TO BE COMPLETED BY THE STUDENT
   }

   public E delete(E someElement) {
	   return someElement; // REMOVE THIS LINE WHEN YOU ARE DONE
   	   // TO BE COMPLETED BY THE STUDENT
   }
}


