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
      Node <E> aNode = root;
      if (root == null) return false;
      if (aNode.data.compareTo(someElement) == 0) return true;
      else {
    	  while (aNode.data.compareTo(someElement) != 0) {
    		  if(aNode.data.compareTo(someElement) < 0) {
    			  if (aNode.right == null) return false;
    			  else aNode = aNode.right;
    		  }
    		  else {
    			  if (aNode.left == null) return false;
    			  else aNode = aNode.left;
    		  }
    	  }
    	  return true;
      }
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
	  if(root == null) return null;
	  Node <E> aNode = root;
      count.setData(count.getData() + 1);
      while (aNode.data.compareTo(someElement) != 0) {
    	  if(aNode.data.compareTo(someElement) > 0) {
    		  
    		  if (aNode.left == null) return null;
    		  else aNode = aNode.left;
    		  
    	  }
    	  else {
    		  if(aNode.right == null) return null;
    		  else aNode = aNode.right;
    	  }
    	  count.setData(count.getData() + 1);
      }
      return aNode.data;
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
	 if (root == null) {
		 root = new Node <E>(someElement);
		 return true;
	 }
	 else {
		 Node <E> aNode = root;
		 if (aNode.data.compareTo(someElement) == 0) return false;
		 while (aNode.data.compareTo(someElement) != 0) { 
			 if (aNode.data.compareTo(someElement) < 0) { 
				 if (aNode.right == null) {
					 Node <E> addedNode = new Node <E> (someElement);
					 aNode.right = addedNode;
					 return true;
				 }
				 else aNode = aNode.right;
			 }
			 else {
				 if(aNode.left == null) {
					 Node <E> addedNode = new Node <E> (someElement);
					 aNode.left = addedNode;
					 return true;
				 }
				 else aNode = aNode.left;
			 }
		 }
		 return false;
	 }
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
	   if (root == null) return false; //empty tree
	   Node <E> aNode = root;
	   Node <E> parent = null;  
	   while (aNode.data.compareTo(someElement) != 0) { // The node has a different value than the one we're searching for
		   if(aNode.data.compareTo(someElement) > 0) {
			   if (aNode.left == null) return false; // element not in tree and cannot be removed
			   else { // move to the left subtree
				   parent = aNode;
				   aNode = aNode.left;
			   }
		   }
			   
		   if(aNode.data.compareTo(someElement) < 0) {
			   if (aNode.right == null) return false; // element not in tree and cannot be removed
			   else { //move the the right subtree
				   parent = aNode;
				   aNode = aNode.right;
			   }
		   }
	   }
		   //Found the node
		   
		   //case 1: the node is a leaf
		   if (aNode.left == null && aNode.right == null) { // leaf
			   if (aNode.data.equals(root.data)) {//leaf is the root
				   root = null;
			   }
			   else {// leaf is not the root
				   if (parent.right != null && parent.right.equals(aNode)) {// node is right-child of parent
					   parent.right = null;
				   }
				   else if (parent.left != null && parent.left.equals(aNode)) { // node is left-child
					   parent.left = null;
				   }
				   aNode = null;
				   
			   }
			   return true;
		   }
		   else if (aNode.left == null && aNode.right != null) {//aNode has only a right child
			   if(aNode.data.equals(root.data)) {// aNode is the root
				   root = aNode.right;
			   }
			   else {//aNode is not the root
				   if(parent.right != null && parent.right.equals(aNode)) {// node is the right-child of its parent
					   parent.right = aNode.right;
					   aNode = null;
				   }
				   else if (parent.left != null && parent.left.equals(aNode)) {// node is the left-child of its parent
					   parent.left = aNode.right;
					   aNode = null;
				   }
					   
			   }
			   return true;
		   }
		   else if (aNode.left != null && aNode.right == null) { // node has only a left child
			   if(aNode.data.equals(root.data)) {//node is the root
				   root = aNode.left;
			   }
			   else {
				   if(parent.right != null && parent.right.equals(aNode)) {//node is the right-child of its parent
					   parent.right = aNode.left;
					   aNode = null;
				   }
				   else if (parent.left != null && parent.left.equals(aNode)) {
					   parent.left = aNode.left;
					   aNode = null;
				   }
			   }
			   return true;
		   }
		   else if (aNode.left != null && aNode.right != null) {
			  Node <E> temp = aNode.right;
			  if(parent == null) {//aNode is the root
				  aNode.data = delete(temp.getLeftMostData());
				  return true;
			  }
			  else if(parent.right != null && parent.right.equals(aNode)) {
				  aNode.data = delete(temp.getLeftMostData());

				  return true;
			  }
			  else if(parent.left != null && parent.left.equals(aNode)) {
				  aNode.data = delete(temp.getLeftMostData());

				  return true;
			  }
			  else return false;
			  
		   }
		   else return false;
	   
   }
   
   
   /** @return the minimum element in the Set */
   // Complexity: O(h) - where h is the height of the tree.
   // In the worst case it could be O(n).  But on aveage
   // we can expect a complexity of O(log n)


   public E first() {
	   return root.getLeftMostData();
   }

   /** @return the maximum element in the Set */
   // Complexity: O(h) - where h is the height of the tree.
   // In the worst case it could be O(n).  But on aveage
   // we can expect a complexity of O(log n)
   public E last() {
	   return root.getRightMostData();
   }

   public E delete(E someElement) {
	   if (remove(someElement)) return someElement;
	   else return null;
   }

}
// this line is to ensure this is the latest version of the code: 11/14/19 3:07 PM
