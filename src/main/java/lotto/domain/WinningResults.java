package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinningResults {

    private final List<WinningResult> results;

    public WinningResults() {
        results = new ArrayList<>();
        for (WinningType type : WinningType.values()) {
            results.add(new WinningResult(type));
        }
    }

    public void addResult(WinningType winningType) {
        results.stream()
                .filter(result -> result.getWinningType() == winningType)
                .forEach(WinningResult::increaseCount);
    }

    public List<WinningType> getWinningTypes() {
        List<WinningType> winningTypes = new ArrayList<>();
        for (WinningResult result : results) {
            winningTypes.add(result.getWinningType());
        }
        return winningTypes;
    }

    public List<Integer> getCounts() {
        List<Integer> counts = new ArrayList<>();
        for (WinningResult result : results) {
            counts.add(result.getCount());
        }
        return counts;
    }

    public Integer getCountByWinningType(WinningType winningType) {
        return results.stream()
                .filter(result -> result.getWinningType() == winningType)
                .map(WinningResult::getCount)
                .findFirst()
                .orElse(null);
    }

    public String toString() {
        return results.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

}
