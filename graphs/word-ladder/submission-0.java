class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet<>();
        for(String str : wordList)
            set.add(str);

        if(!set.contains(endWord))
            return 0;

        int level = 1;
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);

        while(!q.isEmpty()){

            int size = q.size();
            for(int i = 0; i < size; i++){

                String str = q.poll();

                if(str.equals(endWord))
                    return level;

                char[] strArr = str.toCharArray();
                for(int j = 0; j < str.length(); j++){
                    char temp = strArr[j];
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if(temp != ch){
                            strArr[j] = ch;
                            String newstr = new String(strArr);
                            if(set.contains(newstr)){
                                q.add(newstr);
                                set.remove(newstr);
                            }
                        }
                    }
                    strArr[j] = temp;
                }
            }
            level++;
        }

        return 0;
    }
}
