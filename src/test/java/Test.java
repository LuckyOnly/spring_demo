import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        final Product product=new Product();
        Product cglibpro=(Product) Enhancer.create(product.getClass(), new MethodInterceptor(){
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object returnValue =null;
                Float money=(Float)args[0];
                if("sale".equals(method.getName())){
                    returnValue = method.invoke(product,money*0.8f);
                }
                return returnValue;
            }
        });
        cglibpro.sale(1000f);
        db_table(1000005570);
    }
    public static void  db_table(Integer member_id){
    int s = member_id % 16;
    int i = 0;
    if(s >= 0 & s < 4){
            i = 1;
        }
    else if( s >= 4 & s < 8){
        i = 2;
    }else if(s >= 8 & s < 12){
        i = 3;
    }else if(s >= 12 & s < 16){
        i = 4;
    }


    int j = member_id % 4;
        System.out.println("i是分库"+i+",j是分表"+j);

    }
}
