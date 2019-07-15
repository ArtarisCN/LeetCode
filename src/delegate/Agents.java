package delegate;

/**
 * delegate
 * LeetCode
 * 2019.03.19.16:41
 *
 * @author : artairs
 */
public class Agents implements Sales {
    private Owner owner;
    public Agents() {
    }
 /*   @Override
    public void sell() {
        System.out.println("我是房产中介，正在核实买房者是否符合购买该房屋的资格");
        getOwner().sell();
        System.out.println("我是房产中介，正在收取提成");
    }*/

    @Override
    public void sell(int money) {

    }

    @Override
    public void look() {
        System.out.println("带入看房");
    }

    private Owner getOwner() {
        if (owner==null) {
            owner=new Owner();
        }
        return owner;
    }
}