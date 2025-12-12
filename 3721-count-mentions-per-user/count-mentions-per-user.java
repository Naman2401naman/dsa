class Solution {

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        int[] mentions = new int[numberOfUsers];     // answer
        int[] offline = new int[numberOfUsers];      // last offline time

        // 1️⃣ Sort by time
        // if time same → OFFLINE first
        events.sort((a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));

            if (t1 != t2) return t1 - t2;
            return a.get(0).equals("OFFLINE") ? -1 : 1;
        });
        for (List<String> e : events) {

            if (e.get(0).equals("OFFLINE")) {
                int time = Integer.parseInt(e.get(1));
                int id = Integer.parseInt(e.get(2));
                offline[id] = time;
            }

            else {
                int time = Integer.parseInt(e.get(1));
                String[] words = e.get(2).split(" ");

                for (String w : words) {

                    if (w.equals("ALL")) {
                        for (int i = 0; i < numberOfUsers; i++)
                            mentions[i]++;
                    }

                    else if (w.equals("HERE")) {
                        for (int i = 0; i < numberOfUsers; i++) {
                            if (offline[i] == 0 || offline[i] + 60 <= time)
                                mentions[i]++;
                        }
                    }

                    else {
                        int id = Integer.parseInt(w.substring(2));
                        mentions[id]++;
                    }
                }
            }
        }

        return mentions;
    }
}
