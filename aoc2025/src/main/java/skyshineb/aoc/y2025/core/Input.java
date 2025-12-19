package skyshineb.aoc.y2025.core;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private final String raw;

    public Input(String raw) {
        this.raw = raw;
    }

    public String raw() {
        return raw;
    }

    public List<String> lines() {
        String[] parts = raw.split("\\R", -1);
        int n = parts.length;

        if (endsWithLineBreak(raw) && n > 0 && parts[n - 1].isEmpty()) {
            n--;
        }

        if (n == 0) return List.of();

        ArrayList<String> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) list.add(parts[i]);
        return list;
    }

    private boolean endsWithLineBreak(String s) {
        char last = s.charAt(s.length() - 1);
        return last == '\n' || last == '\r';
    }
}
