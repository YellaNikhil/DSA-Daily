
class Solution
{
    public:
    int count = 0;
    bool findSingleValues(Node *root, int parent){
        if(root==nullptr){
            return 0;
        }
        if(root->left == nullptr && root->right==nullptr){
            this->count++;
            return root->data == parent;
        }
        bool left = findSingleValues(root->left, root->data);
        bool right = findSingleValues(root->right, root->data);
        if(left && right){
            this->count++;
        }
        return left && right && root->data == parent;
    }
    int singlevalued(Node *root)
    {
        //code here
        if(root==nullptr){
            return this->count;
        }
        findSingleValues(root, root->data);
        return this->count;
    }
    
};