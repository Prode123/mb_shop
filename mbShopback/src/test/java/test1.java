import org.junit.Test;

public class test1 {

    @Test
    public void test11(){
        String gpic="D:\\img\\7d9d7072-f52e-4755-9411-3b003a9ecf0awallhaven-8ok7vk.jpg";
        System.out.println("/img/"+gpic.substring(gpic.indexOf("g")+2));
    }
}
