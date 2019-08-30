package otherQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * otherQuestion
 * LeetCode
 * 2019.08.19.11:09
 * <p>
 * ![](http://img.artaris.cn//blog/img/20190819110847.png)
 *
 * @author : artairs
 */
class ByteDance1 {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    private void printKPartsPoint(int[][] points, int k) throws IllegaInputException {
        if (points.length < 2)
            return;
        int lengthSum = 0;
        int lastX = points[0][0], lastY = points[0][1], thisX, thisY;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < points.length; i++) {
            thisX = points[i][0];
            thisY = points[i][1];
            if (thisX == lastX) {
                lengthSum += Math.abs(thisY - lastY);
            } else if (thisY == lastY) {
                lengthSum += Math.abs(thisX - lastX);
            } else {
                throw new IllegaInputException("input point is not illegal !!");
            }

            lastX = thisX;
            lastY = thisY;
        }

        int partLength = lengthSum / k;
        int remainLength = partLength;
        int startX = points[0][0], startY = points[0][1], endX, endY;
        for (int i = 1; i < points.length; i++) {
            endX = points[i][0];
            endY = points[i][1];
            while (true) {
                if (startX == endX) {
                    int resultY;
                    if (Math.abs(startY - endY) > remainLength) {
                        if (endY > startX) {
                            resultY = startY + remainLength;
                        } else {
                            resultY = startY - remainLength;
                        }
                        result.add(Arrays.asList(startX, resultY));
                        startY = resultY;
                        remainLength = partLength;
                    } else if (Math.abs(startY - endY) < remainLength) {
                        remainLength -= Math.abs(startY - endY);
                        break;
                    } else {
                        result.add(Arrays.asList(endX, endY));
                        remainLength = partLength;
                        break;
                    }
                } else if (startY == endY) {
                    int resultX;
                    if (Math.abs(startX - endX) > remainLength) {
                        if (endX > startX) {
                            resultX = startX + remainLength;
                        } else {
                            resultX = startX - remainLength;
                        }
                        result.add(Arrays.asList(resultX, startY));
                        startX = resultX;
                        remainLength = partLength;
                    } else if (Math.abs(startX - endX) < remainLength) {
                        remainLength -= Math.abs(startX - endX);
                        break;
                    } else {
                        result.add(Arrays.asList(endX, endY));
                        remainLength = partLength;
                        break;
                    }
                }
            }
        }


    }

    public class IllegaInputException extends Exception {
        public IllegaInputException(String message) {
            super(message);
        }
    }
}
