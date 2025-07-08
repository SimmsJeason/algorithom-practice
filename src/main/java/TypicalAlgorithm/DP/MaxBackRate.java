package TypicalAlgorithm.DP;

/**
 *最大回撤是金融和量化投资领域的重要风险指标，用于衡量资产价格从峰值到谷底的最大跌幅，反映投资组合或策略的极端下行风险。以下是计算方法和示例：
 * 公式 = max（峰值 - 谷值） / 峰值
 * 含义：在选定时间段内，资产净值从最高点到最低点的最大百分比跌幅。 也就是 峰值所在时间一定大于谷值所在时间
 */
public class MaxBackRate {
    /**
     *  max((vi - vj) / vi)  ->  f(i) = 1- vj / vi  vi 表示峰值，vj 表示谷值
     *  由公式可知： 如果 vi-1 < vi  -> f(i-1) < f(i)  所以DP 记忆数组需要记录最大净值 maxPeek， 最大回撤 = 1- max()
     */
    ThreadLocal<String> tt = new ThreadLocal<>();

    public void test() {
        tt.set("dfdfdfd");
        tt.get();
        tt.remove();
    }

}
