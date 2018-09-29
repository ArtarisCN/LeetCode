package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * question
 * LeetCode
 * 2018.09.29.11:58
 * <p>
 * 874. Walking Robot Simulation
 * https://leetcode.com/problems/walking-robot-simulation/description/
 *
 * @author : artairs
 */
class WalkingRobotSimulation {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        System.out.println(robotSim(new int[]{1, 2, -2, 5, -1, -2, -1, 8, 3, -1, 9, 4, -2, 3, 2, 4, 3, 9, 2, -1, -1, -2, 1, 3, -2, 4, 1, 4, -1, 1, 9, -1, -2, 5, -1, 5, 5, -2, 6, 6, 7, 7, 2, 8, 9, -1, 7, 4, 6, 9, 9, 9, -1, 5, 1, 3, 3, -1, 5, 9, 7, 4, 8, -1, -2, 1, 3, 2, 9, 3, -1, -2, 8, 8, 7, 5, -2, 6, 8, 4, 6, 2, 7, 2, -1, 7, -2, 3, 3, 2, -2, 6, 9, 8, 1, -2, -1, 1, 4, 7},
                new int[][]{{-57, -58}, {-72, 91}, {-55, 35}, {-20, 29}, {51, 70}, {-61, 88}, {-62, 99}, {52, 17}, {-75, -32}, {91, -22}, {54, 33}, {-45, -59}, {47, -48}, {53, -98}, {-91, 83}, {81, 12}, {-34, -90}, {-79, -82}, {-15, -86}, {-24, 66}, {-35, 35}, {3, 31}, {87, 93}, {2, -19}, {87, -93}, {24, -10}, {84, -53}, {86, 87}, {-88, -18}, {-51, 89}, {96, 66}, {-77, -94}, {-39, -1}, {89, 51}, {-23, -72}, {27, 24}, {53, -80}, {52, -33}, {32, 4}, {78, -55}, {-25, 18}, {-23, 47}, {79, -5}, {-23, -22}, {14, -25}, {-11, 69}, {63, 36}, {35, -99}, {-24, 82}, {-29, -98}, {-50, -70}, {72, 95}, {80, 80}, {-68, -40}, {65, 70}, {-92, 78}, {-45, -63}, {1, 34}, {81, 50}, {14, 91}, {-77, -54}, {13, -88}, {24, 37}, {-12, 59}, {-48, -62}, {57, -22}, {-8, 85}, {48, 71}, {12, 1}, {-20, 36}, {-32, -14}, {39, 46}, {-41, 75}, {13, -23}, {98, 10}, {-88, 64}, {50, 37}, {-95, -32}, {46, -91}, {10, 79}, {-11, 43}, {-94, 98}, {79, 42}, {51, 71}, {4, -30}, {2, 74}, {4, 10}, {61, 98}, {57, 98}, {46, 43}, {-16, 72}, {53, -69}, {54, -96}, {22, 0}, {-7, 92}, {-69, 80}, {68, -73}, {-24, -92}, {-21, 82}, {32, -1}, {-6, 16}, {15, -29}, {70, -66}, {-85, 80}, {50, -3}, {6, 13}, {-30, -98}, {-30, 59}, {-67, 40}, {17, 72}, {79, 82}, {89, -100}, {2, 79}, {-95, -46}, {17, 68}, {-46, 81}, {-5, -57}, {7, 58}, {-42, 68}, {19, -95}, {-17, -76}, {81, -86}, {79, 78}, {-82, -67}, {6, 0}, {35, -16}, {98, 83}, {-81, 100}, {-11, 46}, {-21, -38}, {-30, -41}, {86, 18}, {-68, 6}, {80, 75}, {-96, -44}, {-19, 66}, {21, 84}, {-56, -64}, {39, -15}, {0, 45}, {-81, -54}, {-66, -93}, {-4, 2}, {-42, -67}, {-15, -33}, {1, -32}, {-74, -24}, {7, 18}, {-62, 84}, {19, 61}, {39, 79}, {60, -98}, {-76, 45}, {58, -98}, {33, 26}, {-74, -95}, {22, 30}, {-68, -62}, {-59, 4}, {-62, 35}, {-78, 80}, {-82, 54}, {-42, 81}, {56, -15}, {32, -19}, {34, 93}, {57, -100}, {-1, -87}, {68, -26}, {18, 86}, {-55, -19}, {-68, -99}, {-9, 47}, {24, 94}, {92, 97}, {5, 67}, {97, -71}, {63, -57}, {-52, -14}, {-86, -78}, {-17, 92}, {-61, -83}, {-84, -10}, {20, 13}, {-68, -47}, {7, 28}, {66, 89}, {-41, -17}, {-14, -46}, {-72, -91}, {4, 52}, {-17, -59}, {-85, -46}, {-94, -23}, {-48, -3}, {-64, -37}, {2, 26}, {76, 88}, {-8, -46}, {-19, -68}}));

//        System.out.println(robotSim(new int[]{-2,-1,4,7,8},new int[][]{{1,1},{2,1},{4,4},{5,-5},{2,-3},{-2,-3},{-1,-3},{-4,-1},{-4,3},{5,1}}));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int robotSim(int[] commands, int[][] obstacles) {
        int direct = 0, x = 0, y = 0, maxDistance = 0;
        List<Integer> com = new ArrayList<>();
        Stack<Integer> temp = new Stack<>();

        List<String> obs = new ArrayList<>();

        for (int[] obstacle : obstacles) {
            obs.add(obstacle[0] + " " + obstacle[1]);
        }

        for (int i = commands.length - 1; i >= 0; i--) {
            temp.push(commands[i]);
        }

        int currentValue = 0;
        int current = -1;
        while (!temp.empty()) {
            int v = temp.pop();
            switch (current) {
                case -1:
                    current = v < 0 ? 0 : 1;
                    currentValue = v;
                    continue;
                case 0:
                    if (v < 0) {
                        if (v == -1) {
                            switch (currentValue) {
                                case -1:
                                    currentValue = -3;
                                    break;
                                case -2:
                                    currentValue = -4;
                                    break;
                                case -3:
                                    currentValue = -2;
                                    break;
                                case -4:
                                    currentValue = -1;
                                    break;
                            }
                        } else if (v == -2) {
                            switch (currentValue) {
                                case -1:
                                    currentValue = -4;
                                    break;
                                case -2:
                                    currentValue = -3;
                                    break;
                                case -3:
                                    currentValue = -1;
                                    break;
                                case -4:
                                    currentValue = -2;
                                    break;
                            }
                        }
                    } else {
                        switch (currentValue) {
                            case -1:
                            case -2:
                                com.add(currentValue);
                                break;
                            case -3:
                                com.add(-1);
                                com.add(-1);
                                break;
                            default:
                                break;
                        }
                        currentValue = v;
                        current = 1;
                    }
                    break;
                case 1:
                    if (v < 0) {
                        com.add(currentValue);
                        currentValue = v;
                        current = 0;
                    } else {
                        currentValue += v;
                    }
                    break;
            }
        }

        com.add(currentValue);

        for (int command : com) {

            if (command < 0) {
                if (command == -1) {
                    direct += 1;
                } else if (command == -2) {
                    direct += 3;
                }
                direct %= 4;
            } else {
                switch (direct) {
                    case 0:
                        while (command != 0) {
                            if (obs.contains(x + " " + (y + 1))) {
                                break;
                            } else {
                                y++;
                            }
                            command--;
                        }
                        break;
                    case 1:
                        while (command != 0) {
                            if (obs.contains((x + 1) + " " + y )) {
                                break;
                            } else {
                                x++;
                            }
                            command--;
                        }
                        break;
                    case 2:
                        while (command != 0) {
                            if (obs.contains(x  + " " + (y - 1))) {
                                break;
                            } else {
                                y--;
                            }
                            command--;
                        }
                        break;
                    case 3:
                        while (command != 0) {
                            if (obs.contains( (x - 1)  + " " + y)) {
                                break;
                            } else {
                                x--;
                            }
                            command--;
                        }
                        break;
                }
            }

            maxDistance = x * x + y * y > maxDistance ? x * x + y * y : maxDistance;
        }

        return maxDistance;
    }


}
