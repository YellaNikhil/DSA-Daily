class Solution {
  public:
  void setMaxValue(Node *root, vector<int> &result, int level){
        if(root==nullptr){
            return ;
        }
        if(result.size() <= level){
            result.emplace_back(root->data);
        }
        else{
            int val = max(result[level], root->data);
            result[level] = val;
        }
        setMaxValue(root->left, result, level + 1);
        setMaxValue(root->right, result, level + 1);
    }
    vector<int> maximumValue(Node* root) {
        //code here
        vector<int> result;
        setMaxValue(root, result, 0);
        return result;
    }
};

