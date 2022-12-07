

// User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;

//           public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    // Return the Kth smallest element in the given BST
    private int steps = 0;
    private int kthSmallest(Node root){
        if(root==null){
            return -1;
        }
        int left = kthSmallest(root.left);
        if(left!=-1){
            return left;
        }
        this.steps--;
        if(this.steps==0){
            return root.data;
        }
        int right = kthSmallest(root.right);
        return right;
    }
    public int KthSmallestElement(Node root, int K) {
        // Write your code here
        this.steps = K;
        return kthSmallest(root);
    }
}