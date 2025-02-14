//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class pair {
    int first;
    int second;

    pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class GfG {

    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();

            String currVal = ip[i];

            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }

            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static boolean isBST(Node n, int lower, int upper) {
        if (n == null) return true;
        if (n.data <= lower || n.data >= upper) return false;
        return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper);
    }

    static boolean compare(Node a, Node b, ArrayList<pair> mismatch) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.data != b.data) {
            mismatch.add(new pair(a.data, b.data));
        }

        return compare(a.left, b.left, mismatch) && compare(a.right, b.right, mismatch);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Node duplicate = buildTree(s);

            Solution ob = new Solution();
            ob.correctBST(root);

            if (!isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                System.out.println(0);
                continue;
            }

            ArrayList<pair> mismatch = new ArrayList<>();
            if (!compare(root, duplicate, mismatch)) {
                System.out.println(0);
                continue;
            }

            if (mismatch.size() != 2 ||
                mismatch.get(0).first != mismatch.get(1).second ||
                mismatch.get(0).second != mismatch.get(1).first) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    

    // Function to correct the BST by swapping the wrong nodes back
    int correctBST(Node root) {
        // To store the nodes to be swapped
        Node first = null, second = null, prev = null;

        // Helper function to perform inorder traversal
        InorderInfo info = new InorderInfo();
        inorderTraversal(root, info);

        first = info.first;
        second = info.second;

        // If both first and second are found, return 1 swap required
        if (first != null && second != null) {
            // Swap the values of the two incorrect nodes
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
            return 1; // We need one swap
        }

        // No swapped nodes, the tree is already valid
        return 0;
    }


    class InorderInfo {
        Node first = null;
        Node second = null;
        Node prev = null;
    }

    // Helper function for inorder traversal
    void inorderTraversal(Node root, InorderInfo info) {
        // Base case: if the node is null, return
        if (root == null) {
            return;
        }

        // Traverse the left subtree
        inorderTraversal(root.left, info);

        // Check for violations in the BST property
        if (info.prev != null && root.data < info.prev.data) {
            // If it's the first violation, mark the first node
            if (info.first == null) {
                info.first = info.prev;
            }
            // Mark the second node (which is out of order)
            info.second = root;
        }

        // Update the prev node to the current node
        info.prev = root;

        // Traverse the right subtree
        inorderTraversal(root.right, info);
    }
}

