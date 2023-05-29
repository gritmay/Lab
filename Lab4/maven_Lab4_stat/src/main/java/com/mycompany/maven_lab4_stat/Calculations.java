package com.mycompany.maven_lab4_stat;

import java.util.ArrayList;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.interval.ConfidenceInterval;

public class Calculations {
    private ArrayList<double[]> samples = new ArrayList<>();

    public double calcGeomMean(double[] array) {
        return StatUtils.geometricMean(array);
    }

    public double calcMean(double[] array) {
        return StatUtils.mean(array);
    }

    public double calcSD(double[] array) {
        StandardDeviation sd = new StandardDeviation();
        return sd.evaluate(array);
    }

    public double calcR(double[] array) {
        return StatUtils.max(array) - StatUtils.min(array);
    }

    public double calcCov(double[] array1, double[] array2) {
            Covariance covariance = new Covariance();
            return covariance.covariance(array1,array2);
    }

    public int calcN(double[] array) {
        return array.length;
    }

    public double calcCoeffVar(double[] array) {
        StandardDeviation sd = new StandardDeviation();
        double mean =StatUtils.mean(array);
        return sd.evaluate(array) / mean;
    }

    public static ConfidenceInterval calcConfInterval(double[] array, double alpha) {
        StandardDeviation standartDev = new StandardDeviation();
        double mean = StatUtils.mean(array);
        double sd = standartDev.evaluate(array);
        NormalDistribution normalDistribution = new NormalDistribution();
        double z = normalDistribution.inverseCumulativeProbability(1.0 - alpha / 2.0);
        return new ConfidenceInterval(mean - z * sd / Math.sqrt(array.length), mean + z * sd / Math.sqrt(array.length), alpha);
    }

    public static double calcVar(double[] array) {
        Variance variance = new Variance();
        return variance.evaluate(array);
    }

    public static double calcMin(double[] array) {
        return StatUtils.min(array);
    }

    public static double calcMax(double[] array) {
        return StatUtils.max(array);
    }

    public ArrayList<ArrayList<Object>> makeCalc(ArrayList<double[]> samples)
    {
        ArrayList<ArrayList<Object>> results = new ArrayList<ArrayList<Object>>(); //лист значений для всех выборок
        for(int i=0; i<samples.size(); i++)
        {
            ArrayList<Object> values = new ArrayList<Object>(); //лист значений для одной выборки
            values.add(calcGeomMean(samples.get(i)));
            values.add(calcMean(samples.get(i)));
            values.add(calcSD(samples.get(i)));
            values.add(calcR(samples.get(i)));
            values.add(calcN(samples.get(i)));
            values.add(calcCoeffVar(samples.get(i)));
            values.add(calcConfInterval(samples.get(i), 0.05));
            values.add(calcVar(samples.get(i)));
            values.add(calcMin(samples.get(i)));
            values.add(calcMax(samples.get(i)));
            results.add(values);
        }
        return results;
    }
    
    public double[][] makeMatrix(ArrayList<double[]> samples)
    {
        double[][] results = new double[3][3];
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                results[i][j] = calcCov(samples.get(i), samples.get(j));
            }
        }
        return results;
    }
}
