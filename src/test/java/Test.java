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
    }
}
