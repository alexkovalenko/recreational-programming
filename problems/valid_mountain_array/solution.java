class Solution {
    public boolean validMountainArray(int[] arr) {
        
//         if (arr == null || arr.length < 3) {
//             return false;
//         }
        
//         int peak = arr[0];
//         int peakIndex = 0;
//         for (int i = 1; i < arr.length; i++) {
//             if (peak < arr[i]) {
//                 peak = arr[i];
//                 peakIndex = i;
//             } else if (peak == arr[i]) {
//                 return false;
//             }
//         }
        
//         if (peakIndex == 0 || peakIndex == arr.length - 1)
//             return false;
        
//         int left = peakIndex, right = peakIndex;
        
//         while (left > 1 || right < arr.length - 1) {
//             if (left > 1) {
//                 if (arr[left] <= arr[left - 1]) {
//                     return false;
//                 } else {
//                     left--;
//                 }
//             }
            
//             if (right < arr.length - 1) {
//                 if (arr[right] <= arr[right + 1]) {
//                     return false;
//                 } else {
//                     right++;
//                 } 
//             }   
//         }
        
        int len = arr.length, i = 0;
        
        while (i + 1 < len && arr[i] < arr[i + 1]) 
            i++;
        
        if (i == 0 || i == len - 1)
            return false;
        
        while (i + 1 < len && arr[i] > arr[i + 1]) 
            i++;

        return i == len - 1;
    }
}