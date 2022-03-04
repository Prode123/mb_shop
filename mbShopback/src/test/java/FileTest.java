import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileTest {
    @Test
    public void fileTest() throws IOException {

//        字节输入流
        FileInputStream in=new FileInputStream("C:\\Users\\lenovo\\Desktop\\c\\d\\");

//        转换输入流：就是一个字符流
//        首先需要一个字节输入流（节点流）
//        在此基础上转为字符输入流
        InputStreamReader reader=new InputStreamReader(in);
        char[]  cc=new  char[10];
        int  i=reader.read(cc);
        System.out.println(new  String(cc,0,i));

//        先关输出流再关输入流
//        后打开的先关闭
        reader.close();
        in.close();
    }
}
