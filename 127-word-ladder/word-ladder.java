class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue=new LinkedList<>();
        Set<String> set=new HashSet<>(wordList);
        queue.add(beginWord);
        Set<String> visited=new HashSet<>();
        if(!set.contains(endWord)){
            return 0;
        }
        int changes=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                String word=queue.poll();
                if(word.equals(endWord)){
                    return changes;
                }
                for(int j=0;j<word.length();j++){
                    for(int k='a';k<='z';k++){
                        char[] arr=word.toCharArray();
                        arr[j]=(char) k;
                        String str=new String(arr);
                        if(set.contains(str) && !visited.contains(str)){
                            queue.add(str);
                            visited.add(str);
                        }
                    }
                }

            }
            changes++;
        }
        return 0;

    }
}