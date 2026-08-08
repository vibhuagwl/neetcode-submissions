class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums1) {
            minHeap.offer(num);
        }
        for (int num : nums2) {
            minHeap.offer(num);
        }
        int total = nums1.length + nums2.length;
        for (int i = 0; i < (total - 1) / 2; i++) {
            minHeap.poll();
        }
        int middle = minHeap.poll();
        if (total % 2 == 1) {
            return middle;
        }
        int next = minHeap.poll();
        return ((double) middle + next) / 2.0;
    }
}
