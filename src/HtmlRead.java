import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HtmlRead {

    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }

    public HtmlRead() {

        try {
            System.out.println();
            System.out.print("hello \n");
            URL url = new URL("https://www.milton.edu/");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String line;
            while ( (line = reader.readLine()) != null ) {
                if(line.contains("href=")) {
                    line.indexOf("href=");
                    int abcd = line.indexOf("href=");

                String pqrs = line.substring(abcd+6);
//                System.out.println("og"+pqrs);
                pqrs.indexOf("\"");
                int end = pqrs.indexOf("\"");
                pqrs.indexOf("'");
                int end1 = pqrs.indexOf("'");
//               System.out.println(end);
//         System.out.print(end1);
                    if(end1 <0){
                        String link = pqrs.substring(0,end);
                        System.out.println(link);
                    } else if (end <0) {
                        String link = pqrs.substring(0,end1);
                        System.out.println(link);
                    }
                    else if(end<end1){
                        String link = pqrs.substring(0,end);
                        System.out.println(link);
                    }else{
                        String link = pqrs.substring(0,end1);
                        System.out.println(link);
                    }
                 //   System.out.println(pqrs.substring(0,end));
                }
            }
            reader.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

    }

}
