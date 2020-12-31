class main {
    public static void main(String[] args) {
        int[] inputs = new int[] {5,4,20,15,3,1,50,7,9}; // Values to be put in
        LinkedBinaryTree<Integer> binaryTree = new LinkedBinaryTree<Integer>(); // Creating the linked binary tree

        for(int i = 0; i < inputs.length; i++) 
        // Adding the values to the tree using the properly created outerAdder method
        // which abides to the rules to the linked binary tree
            binaryTree.add(inputs[i]);
        
        binaryTree.inOrder(binaryTree.root()); // Adding the root to the tree
        System.out.println(); // Spacing
        
        System.out.println(binaryTree.find(7)); // Checking if the two provided numbers in the lab manual are in the binary tree
        System.out.println(binaryTree.find(100));
    }
}