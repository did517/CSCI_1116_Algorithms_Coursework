import java.util.*;

public class CountOccurrenceOfWords2 {
    public static void main(String[] args) {

        String text = "Good morning. Have a good class. "
                + "Have a good visit. Have fun!";

        Map<String, Integer> map = new HashMap<>();

        String[] words = text.split("[\\s+\\p{P}]");

        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();

            if (key.length() > 0) {
                if (!map.containsKey(key))
                    map.put(key, 1);
                else
                    map.put(key, map.get(key) + 1);
            }
        }

        ArrayList<WordOccurrence> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }

        Collections.sort(list);

        for (WordOccurrence word : list) {
            System.out.println(word);
        }
    }
}
