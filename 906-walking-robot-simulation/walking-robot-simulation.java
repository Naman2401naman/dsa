class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        Set<List<Integer>> block=new HashSet<>();
        for(int[] o:obstacles){
            block.add(Arrays.asList(o[0],o[1]));
        }
        int[][] directions={
            {0,1},{1,0},{0,-1},{-1,0}
        };

        int x=0;
        int y=0;
        int maxx=0;
        int dir=0;
        for(int cmd:commands){
            if(cmd==-1){
                dir=(dir+1)%4;
            }else if(cmd==-2){
                dir=(dir+3)%4;
            }else{
                while(cmd-->0){
                    int nx=x+directions[dir][0];
                    int ny=y+directions[dir][1];

                    if(block.contains(Arrays.asList(nx,ny))) break;
                    x=nx;
                    y=ny;
                    maxx=Math.max(maxx,x*x+y*y);
                }
            }
        }
        return maxx;
    }
}