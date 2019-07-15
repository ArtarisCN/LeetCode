package delegate;

/**
 * delegate
 * LeetCode
 * 2019.03.19.16:41
 *
 * @author : artairs
 */
class Owner implements Sales {
    @Override
    public void sell(int money) {
        System.out.println("我是房东我正在出售我的房产，要价" + money);
    }

    @Override
    public void look() {
        System.out.println("带入看房");
    }
}
