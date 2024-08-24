package com.brasens.math.statistic;

import com.brasens.dtos.Vector;
import com.brasens.math.Vector2D;
import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DescriptiveStatistics {

    public static List<Vector> createNormalDistribution(double mean, double standardDeviation, int size) {
        try {
            NormalDistribution normalDistribution = new NormalDistribution(mean, standardDeviation);
            List<Vector> distributionValues = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                double x = normalDistribution.sample();
                double y = normalDistribution.density(x);
                distributionValues.add(new Vector(x, y));
            }
            return distributionValues;
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList<>();
        }
    }

    public static double Mean(List<Double> data) {
        try {
            double sum = 0;
            for (double d : data)
                sum += d;
            return sum / data.size();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static double Median(List<Double> data) {
        try {
            List<Double> clonedList = new ArrayList<>(data);
            Collections.sort(clonedList);
            int size = clonedList.size();
            if (size % 2 != 0)
                return clonedList.get(size / 2);
            else {
                return (clonedList.get((size / 2) - 1) + clonedList.get(size / 2)) / 2.0;
            }
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static double Mode(List<Double> data) {
        try {
            if (!data.isEmpty()) {
                Map<Double, Integer> frequencyMap = new HashMap<>();
                for (Double d : data) {
                    frequencyMap.put(d, frequencyMap.getOrDefault(d, 0) + 1);
                }

                double mode = data.get(0);
                int maxCount = 0;
                for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
                    if (entry.getValue() > maxCount) {
                        maxCount = entry.getValue();
                        mode = entry.getKey();
                    }
                }
                return mode;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public static double RMS(List<Double> data) {
        try {
            double sum = 0;
            for (double d : data)
                sum += d * d;
            return Math.sqrt(sum / data.size());
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static double Peak(List<Double> data) {
        try {
            return Collections.max(data);
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static double PeakToPeak(List<Double> data) {
        try {
            return Collections.max(data) - Collections.min(data);
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static double Variance(List<Double> data, double mean) {
        try {
            double sum = 0;
            for (double d : data)
                sum += (d - mean) * (d - mean);
            return sum / (data.size() - 1);
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static double StandardDeviation(List<Double> data, double mean) {
        try {
            return Math.sqrt(Variance(data, mean));
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static double Kurtosis(List<Double> distribution, double distributionMean, double distributionStd) {
        try {
            double sum = 0;
            for (double d : distribution)
                sum += Math.pow((d - distributionMean), 4);
            return sum / ((distribution.size() - 1) * Math.pow(distributionStd, 4));
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static double Skewness(List<Double> distribution, double distributionMean, double distributionStd) {
        try {
            double sum = 0;
            for (double d : distribution)
                sum += Math.pow((d - distributionMean), 3);
            return sum / ((distribution.size() - 1) * Math.pow(distributionStd, 3));
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static List<Double> calculateZScores(List<Double> data, double mean, double standardDeviation) {
        try {
            List<Double> zScores = new ArrayList<>();
            for (double d : data) {
                double z = (d - mean) / standardDeviation;
                zScores.add(z);
            }
            return zScores;
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList<>();
        }
    }

    public static double[] getMaxMinZScores(List<Double> zScores) {
        try {
            double maxZScore = Collections.max(zScores);
            double minZScore = Collections.min(zScores);
            return new double[]{maxZScore, minZScore};
        } catch (Exception e) {
            System.out.println(e);
            return new double[0];
        }
    }

}
