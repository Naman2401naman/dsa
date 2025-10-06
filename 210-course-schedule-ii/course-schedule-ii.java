class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg=new int[numCourses];
        int[] ans=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int idx=prerequisites[i][0];
            indeg[idx]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                queue.add(i);
            }
        }
        int cnt=0;
        while(!queue.isEmpty()){
            int finder=queue.poll();
            ans[cnt]=finder;
            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][1]==finder){
                    int idx=prerequisites[i][0];
                    indeg[idx]--;
                    if(indeg[idx]==0){
                        queue.add(idx);
                    }
                }
            }
            cnt++;
        }
        if(cnt==numCourses) return ans;
        else return new int[0];
    }
}