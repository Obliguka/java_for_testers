public class Hello {
    public static void main(String[] args) {
           var x = 1;
           var y = 0;
           if(y==0)
           {
               System.out.println("Devision by zero is not allowed");
           }
           else{
               int z = devide(x, y);
               System.out.println(z);
               System.out.println("Первое задания из модуля 0");
           }
      /* }catch(ArithmeticException exception){
           System.out.println("Devision by zero is not allowed");
           //System.out.println(exception.getMessage());
           //exception.printStackTrace();
       }*/

       /*var configFile = new File("sandbox/build.gradle");
        System.out.println(configFile.getAbsoluteFile());
        System.out.println(configFile.exists());*/
    }

    private static int devide(int x, int y) {
        var z = x / y;
        return z;
    }
}
