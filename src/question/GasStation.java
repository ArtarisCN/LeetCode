package question;

/**
 * question
 * LeetCode
 * 2019.05.09.11:34
 * <p>
 * 134. Gas Station
 * https://leetcode-cn.com/problems/gas-station/
 *
 * @author : artairs
 */
class GasStation {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        int[] gas = new int[]{1, 2, 3, 4, 5};
//        int[] cost = new int[]{3, 4, 5, 1, 2};

//        int[] gas = new int[]{5,1,2,3,4};
//        int[] cost = new int[]{4,4,1,5,1};

//        int[] gas = new int[]{5, 8, 2, 8};
//        int[] cost = new int[]{6, 5, 6, 6};

        int[] gas = new int[]{3,1,1};
        int[] cost = new int[]{1,2,2};



        System.out.println(canCompleteCircuit(gas, cost));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int[] startSation = new int[gas.length];
        int gasSum = 0, costSum = 0;

        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                startSation[i] = 1;
            }
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (gasSum < costSum) {
            return -1;
        }

        for (int i = 0; i < startSation.length; i++) {
            if (startSation[i] == 1) {
                int result = check(gas, cost, i);
                if (result >= 0) {
                    return result;
                }
            }
        }

        return -1;
    }

    private static int check(int[] gas, int[] cost, int start) {
        int currentGas = gas[start];
        int length = gas.length, index = start + 1 == length ? 0 : start + 1;
        while (index != start) {
            if (currentGas < cost[index == 0 ? length - 1 : index - 1]) {
                return -1;
            } else {
                currentGas = currentGas + gas[index] - cost[index == 0 ? length - 1 : index - 1];
            }
            index++;
            if (index == length) {
                index = 0;
            }
        }
        return start;
    }


}
