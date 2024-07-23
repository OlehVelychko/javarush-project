package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    private List<Advertisement> bestAds;
    private long maxAmount;
    private int maxDuration;
    private int minCount;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    /**
     * Processes advertising video
     */
    public void processVideos() {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }

        bestAds = new ArrayList<>();
        maxAmount = 0;
        maxDuration = 0;
        minCount = Integer.MAX_VALUE;

        List<Advertisement> ads = storage.list();
        findOptimalAds(new ArrayList<>(), ads, 0, 0, 0);

        if (bestAds.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        Collections.sort(bestAds, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
                if (result == 0) {
                    result = Long.compare(o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration(),
                            o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
                }
                return result;
            }
        });

        for (Advertisement ad : bestAds) {
            System.out.println(String.format("%s is displaying... %d, %d",
                    ad.getName(),
                    ad.getAmountPerOneDisplaying(),
                    ad.getAmountPerOneDisplaying() * 1000 / ad.getDuration()));
            ad.revalidate();
        }
    }

    /**
     * Help method for seeking optimal advertisement
     *
     * @param selected
     * @param ads
     * @param currentIndex
     * @param currentAmount
     * @param currentDuration
     */
    private void findOptimalAds(List<Advertisement> selected, List<Advertisement> ads, int currentIndex, long currentAmount, int currentDuration) {
        if (currentDuration > timeSeconds) {
            return;
        }

        if (currentAmount > maxAmount ||
                (currentAmount == maxAmount && currentDuration > maxDuration) ||
                (currentAmount == maxAmount && currentDuration == maxDuration && selected.size() < minCount)) {
            bestAds = new ArrayList<>(selected);
            maxAmount = currentAmount;
            maxDuration = currentDuration;
            minCount = selected.size();
        }

        for (int i = currentIndex; i < ads.size(); i++) {
            Advertisement ad = ads.get(i);
            if (ad.getHits() > 0) {
                selected.add(ad);
                findOptimalAds(selected, ads, i + 1, currentAmount + ad.getAmountPerOneDisplaying(), currentDuration + ad.getDuration());
                selected.remove(selected.size() - 1);
            }
        }
    }
}
