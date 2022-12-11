class Solution {
public:
    void findLeaves(TreeNode *root, vector<int> &leaf){
        if(root==nullptr){
            return;
        }
        if(root->left==nullptr && root->right==nullptr){
            leaf.emplace_back(root->val);
        }
        findLeaves(root->left, leaf);
        findLeaves(root->right, leaf);
    }
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
       vector<int> leaf1;
        vector<int> leaf2; 
        findLeaves(root1, leaf1);
        findLeaves(root2, leaf2);
        if(leaf1.size()!=leaf2.size()){
            return false;
        }
        for(int i=0;i<leaf1.size();i++){
            if(leaf1[i]!=leaf2[i]){
                return false;
            }
        }
        return true;
    }
};class Solution {
public:
    void findLeaves(TreeNode *root, vector<int> &leaf){
        if(root==nullptr){
            return;
        }
        if(root->left==nullptr && root->right==nullptr){
            leaf.emplace_back(root->val);
        }
        findLeaves(root->left, leaf);
        findLeaves(root->right, leaf);
    }
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
       vector<int> leaf1;
        vector<int> leaf2; 
        findLeaves(root1, leaf1);
        findLeaves(root2, leaf2);
        if(leaf1.size()!=leaf2.size()){
            return false;
        }
        for(int i=0;i<leaf1.size();i++){
            if(leaf1[i]!=leaf2[i]){
                return false;
            }
        }
        return true;
    }
};