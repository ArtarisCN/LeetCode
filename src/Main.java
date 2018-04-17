import java.io.File;
import java.io.FileOutputStream;

import util.Decode;

/**
 * Created by rick on 2017/7/18.
 */
public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();    //获取开始时间

        try {
            byte[] data = Decode.decodes("YTYT68WDN6UI39PL0RF3X027TGNN69XDAYNEPHZN6GGDLPW70PH3J3YPYWG7372E3J032UYT2WPJXE4RNJUZCTTYHRRHGD8ZH69K836GNPSJY8AN09N09JYK62FTNZHGWH7FS01XPXPXOCTOHD3RRICC16XLXZKOG0X17J13OKCND5SJCXE8UIGFORL3SEJXE7CFSLL05C8CZ1LO5Y01J031AAK4OPXK5JTS3YOGSL16EYHOU3127PL5U6AC5UFRHDETSSGGLTIW8KSGKI466Z5LA81GFNEH836PXRCR2YYYFFXA6LRH2Z507P5PYSAK9WAP8AXX8TK74GSX3UKI6WHXOR5Y5589L7IAEG04CNZ8Y9Z9WGXHOSO33596SO8CNO95ZEYIW7SKDI8462LIONC9XIRHGD8ZH69K835DPT35WYO0EJ1A");

            System.out.println(new String(data));

            File file = new File("decode");
            if( !file.exists()) {

                file.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            System.out.println("写入成功：");

            byte[] data1 = Decode.decryptByte(data,"!Q@W#E$R%T^Y&U*I(O)P");
            System.out.println(new String(data1));

        } catch (Exception e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

}
