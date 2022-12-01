class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
public:    
	void rearrange(long long arr[], int n){
	        long long largest = arr[n-1] + 1;
        	for(int i=0;i<n;i++){
            if(i%2==1){
                arr[i] = arr[i] + largest*(arr[i/2]%largest);
            }
            else{
                arr[i] = arr[i] + largest*(arr[n-i/2-1]%largest);
            }
        }
        for(int i=0;i<n;i++){
            arr[i] /= largest;
        }
    }
};